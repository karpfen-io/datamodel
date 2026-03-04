/**
 * Copyright 2026 Karl Kegel
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dsl.textual

import parser.*
import states.*
import states.actions.*
import states.conditions.*
import states.macros.*
import java.io.File

/**
 * Converts KStates DSL strings and files into StateMachine objects.
 */
object KstatesDSLConverter {

    /**
     * Parses a KStates string and converts it to a StateMachine.
     *
     * @param content The KStates content as a string.
     * @return The parsed state machine.
     * @throws IllegalArgumentException If the state machine does not have exactly one initial state.
     */
    fun parseKstatesString(content: String): StateMachine {
        val parsed = KStatesFileParser().parseString(content)

        val stateObjects = parsed.states.map { convertState(it, null) }.toMutableList()
        val transitions = parsed.transitions.map { convertTransition(it) }.toMutableList()
        val macros = parsed.macros.map { convertMacro(it) }.toMutableList()

        val initialStates = countInitialStates(stateObjects)
        require(initialStates == 1) {
            "Exactly one state must be marked as INITIAL, but found $initialStates."
        }

        return StateMachine(parsed.attachedToClass, stateObjects, transitions, macros)
    }

    /**
     * Parses a KStates file and converts it to a StateMachine.
     *
     * @param filePath The path to the KStates file to parse.
     * @return The parsed state machine.
     */
    fun parseKstatesFile(filePath: String): StateMachine {
        val content = File(filePath).readText()
        return parseKstatesString(content)
    }

    private fun convertState(parsedState: ParsedState, outerState: State?): State {
        val state = State(
            name = parsedState.name,
            onEntry = convertActionBlock(parsedState.onEntry),
            onDo = convertActionBlock(parsedState.onDo),
            innerStates = mutableListOf(),
            outerState = outerState,
            isInitial = parsedState.isInitial
        )

        for (inner in parsedState.innerStates) {
            state.innerStates.add(convertState(inner, state))
        }

        return state
    }

    private fun convertActionBlock(block: parser.ParsedActionBlock?): ActionBlock {
        val actions = block?.actions?.map { action ->
            ActionRule(
                operationType = when (action.operationType) {
                    ParsedActionOperationType.SET -> ActionOperationType.SET
                    ParsedActionOperationType.APPEND -> ActionOperationType.APPEND
                    ParsedActionOperationType.EVENT -> ActionOperationType.EVENT
                },
                leftSide = action.leftSide,
                rightSide = convertActionRightSide(action.rightSide)
            )
        } ?: emptyList()

        return ActionBlock(actions.toMutableList())
    }

    private fun convertActionRightSide(rightSide: parser.ParsedActionRightSide): ActionRightSide {
        return when (rightSide) {
            is ParsedMacroActionRightSide -> MacroActionRightSide(rightSide.macroName, rightSide.args)
            is ParsedEvalActionRightSide -> EvalActionRightSide(rightSide.code)
            is ParsedValueActionRightSide -> ValueActionRightSide(rightSide.value)
        }
    }

    private fun convertTransition(transition: ParsedTransition): Transition {
        return Transition(
            fromState = transition.fromState,
            toState = transition.toState,
            allowLoops = transition.allowLoops,
            condition = convertCondition(transition.condition)
        )
    }

    private fun convertCondition(condition: ParsedCondition?): Condition {
        return when (condition) {
            is ParsedEvalCondition -> EvalCondition(condition.code)
            is ParsedEventCondition -> EventCondition(condition.eventDomain, condition.eventValue)
            is ParsedValueCondition -> ValueCondition(condition.variableKey)
            null -> ValueCondition("true")
        }
    }

    private fun convertMacro(macro: ParsedMacro): Macro {
        return Macro(
            name = macro.name,
            takes = macro.takes.map { TakesDirective(it.paramName, it.paramType) },
            returns = ReturnsDirective(macro.returns.returnType),
            definition = Definition(CodeBlock(macro.definitionCode))
        )
    }

    private fun countInitialStates(states: List<State>): Int {
        var initialCount = 0
        for (state in states) {
            if (state.isInitial) {
                initialCount += 1
            }
            initialCount += countInitialStates(state.innerStates)
        }
        return initialCount
    }
}

