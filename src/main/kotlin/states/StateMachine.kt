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
package states

/**
 * Represents a hierarchical state machine definition attached to a specific class.
 *
 * @property attachedToClass The name of the class this state machine is attached to.
 * @property states List of top-level states defined in this state machine.
 * @property transitions List of state transitions with conditions.
 * @property macros List of macro definitions for use in actions and conditions.
 */
data class StateMachine(
    val attachedToClass: String,
    val states: MutableList<State>,
    val transitions: MutableList<Transition>,
    val macros: MutableList<Macro>
    ) {
    override fun toString(): String =
        "StateMachine(attachedToClass=$attachedToClass, states=${states.size}, transitions=${transitions.size}, macros=${macros.size})"
}