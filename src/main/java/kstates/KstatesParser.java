// Generated from kstates/Kstates.g4 by ANTLR 4.13.1
package kstates;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class KstatesParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		STATEMACHINE=1, ATTACHED=2, TO=3, STATES=4, STATE=5, INITIAL=6, ENTRY=7, 
		DO=8, SET=9, APPEND=10, EVENT=11, MACRO=12, EVAL=13, TRANSITIONS=14, TRANSITION=15, 
		NOT=16, LOOPING=17, CONDITION=18, VALUE=19, MACROS=20, TAKES=21, RETURNS=22, 
		DEFINITION=23, REFERENCE=24, ARROW=25, LBRACE=26, RBRACE=27, LPAREN=28, 
		RPAREN=29, COMMA=30, STRING=31, SSTRING=32, IDENT=33, NUMBER=34, WS=35, 
		LINE_COMMENT=36, SYMBOL=37;
	public static final int
		RULE_kstates_file = 0, RULE_statemachine = 1, RULE_states_block = 2, RULE_state_definition = 3, 
		RULE_entry_block = 4, RULE_do_block = 5, RULE_action_block = 6, RULE_action_rule = 7, 
		RULE_action_operation = 8, RULE_action_right_side = 9, RULE_macro_call = 10, 
		RULE_eval_statement = 11, RULE_transitions_block = 12, RULE_transition_definition = 13, 
		RULE_not_looping = 14, RULE_condition_block = 15, RULE_transition_condition = 16, 
		RULE_event_condition = 17, RULE_value_condition = 18, RULE_macros_block = 19, 
		RULE_macro_definition = 20, RULE_takes_directive = 21, RULE_returns_directive = 22, 
		RULE_return_expression = 23, RULE_type_expression = 24, RULE_typed_call_expression = 25, 
		RULE_reference_expression = 26, RULE_definition_block = 27, RULE_eval_code_block = 28, 
		RULE_code_content = 29;
	private static String[] makeRuleNames() {
		return new String[] {
			"kstates_file", "statemachine", "states_block", "state_definition", "entry_block", 
			"do_block", "action_block", "action_rule", "action_operation", "action_right_side", 
			"macro_call", "eval_statement", "transitions_block", "transition_definition", 
			"not_looping", "condition_block", "transition_condition", "event_condition", 
			"value_condition", "macros_block", "macro_definition", "takes_directive", 
			"returns_directive", "return_expression", "type_expression", "typed_call_expression", 
			"reference_expression", "definition_block", "eval_code_block", "code_content"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'STATEMACHINE'", "'ATTACHED'", "'TO'", "'STATES'", "'STATE'", 
			"'INITIAL'", "'ENTRY'", "'DO'", "'SET'", "'APPEND'", "'EVENT'", "'MACRO'", 
			"'EVAL'", "'TRANSITIONS'", "'TRANSITION'", "'NOT'", "'LOOPING'", "'CONDITION'", 
			"'VALUE'", "'MACROS'", "'TAKES'", "'RETURNS'", "'DEFINITION'", "'reference'", 
			"'->'", "'{'", "'}'", "'('", "')'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "STATEMACHINE", "ATTACHED", "TO", "STATES", "STATE", "INITIAL", 
			"ENTRY", "DO", "SET", "APPEND", "EVENT", "MACRO", "EVAL", "TRANSITIONS", 
			"TRANSITION", "NOT", "LOOPING", "CONDITION", "VALUE", "MACROS", "TAKES", 
			"RETURNS", "DEFINITION", "REFERENCE", "ARROW", "LBRACE", "RBRACE", "LPAREN", 
			"RPAREN", "COMMA", "STRING", "SSTRING", "IDENT", "NUMBER", "WS", "LINE_COMMENT", 
			"SYMBOL"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Kstates.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public KstatesParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Kstates_fileContext extends ParserRuleContext {
		public StatemachineContext statemachine() {
			return getRuleContext(StatemachineContext.class,0);
		}
		public TerminalNode EOF() { return getToken(KstatesParser.EOF, 0); }
		public Kstates_fileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_kstates_file; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KstatesVisitor ) return ((KstatesVisitor<? extends T>)visitor).visitKstates_file(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Kstates_fileContext kstates_file() throws RecognitionException {
		Kstates_fileContext _localctx = new Kstates_fileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_kstates_file);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			statemachine();
			setState(61);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatemachineContext extends ParserRuleContext {
		public TerminalNode STATEMACHINE() { return getToken(KstatesParser.STATEMACHINE, 0); }
		public TerminalNode ATTACHED() { return getToken(KstatesParser.ATTACHED, 0); }
		public TerminalNode TO() { return getToken(KstatesParser.TO, 0); }
		public TerminalNode STRING() { return getToken(KstatesParser.STRING, 0); }
		public TerminalNode LBRACE() { return getToken(KstatesParser.LBRACE, 0); }
		public States_blockContext states_block() {
			return getRuleContext(States_blockContext.class,0);
		}
		public Transitions_blockContext transitions_block() {
			return getRuleContext(Transitions_blockContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(KstatesParser.RBRACE, 0); }
		public Macros_blockContext macros_block() {
			return getRuleContext(Macros_blockContext.class,0);
		}
		public StatemachineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statemachine; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KstatesVisitor ) return ((KstatesVisitor<? extends T>)visitor).visitStatemachine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatemachineContext statemachine() throws RecognitionException {
		StatemachineContext _localctx = new StatemachineContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statemachine);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(STATEMACHINE);
			setState(64);
			match(ATTACHED);
			setState(65);
			match(TO);
			setState(66);
			match(STRING);
			setState(67);
			match(LBRACE);
			setState(68);
			states_block();
			setState(69);
			transitions_block();
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MACROS) {
				{
				setState(70);
				macros_block();
				}
			}

			setState(73);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class States_blockContext extends ParserRuleContext {
		public TerminalNode STATES() { return getToken(KstatesParser.STATES, 0); }
		public TerminalNode LBRACE() { return getToken(KstatesParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(KstatesParser.RBRACE, 0); }
		public List<State_definitionContext> state_definition() {
			return getRuleContexts(State_definitionContext.class);
		}
		public State_definitionContext state_definition(int i) {
			return getRuleContext(State_definitionContext.class,i);
		}
		public States_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_states_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KstatesVisitor ) return ((KstatesVisitor<? extends T>)visitor).visitStates_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final States_blockContext states_block() throws RecognitionException {
		States_blockContext _localctx = new States_blockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_states_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(STATES);
			setState(76);
			match(LBRACE);
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==STATE || _la==INITIAL) {
				{
				{
				setState(77);
				state_definition();
				}
				}
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(83);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class State_definitionContext extends ParserRuleContext {
		public TerminalNode STATE() { return getToken(KstatesParser.STATE, 0); }
		public TerminalNode STRING() { return getToken(KstatesParser.STRING, 0); }
		public TerminalNode LBRACE() { return getToken(KstatesParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(KstatesParser.RBRACE, 0); }
		public TerminalNode INITIAL() { return getToken(KstatesParser.INITIAL, 0); }
		public Entry_blockContext entry_block() {
			return getRuleContext(Entry_blockContext.class,0);
		}
		public Do_blockContext do_block() {
			return getRuleContext(Do_blockContext.class,0);
		}
		public List<State_definitionContext> state_definition() {
			return getRuleContexts(State_definitionContext.class);
		}
		public State_definitionContext state_definition(int i) {
			return getRuleContext(State_definitionContext.class,i);
		}
		public State_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_state_definition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KstatesVisitor ) return ((KstatesVisitor<? extends T>)visitor).visitState_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final State_definitionContext state_definition() throws RecognitionException {
		State_definitionContext _localctx = new State_definitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_state_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INITIAL) {
				{
				setState(85);
				match(INITIAL);
				}
			}

			setState(88);
			match(STATE);
			setState(89);
			match(STRING);
			setState(90);
			match(LBRACE);
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ENTRY) {
				{
				setState(91);
				entry_block();
				}
			}

			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DO) {
				{
				setState(94);
				do_block();
				}
			}

			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==STATE || _la==INITIAL) {
				{
				{
				setState(97);
				state_definition();
				}
				}
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(103);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Entry_blockContext extends ParserRuleContext {
		public TerminalNode ENTRY() { return getToken(KstatesParser.ENTRY, 0); }
		public Action_blockContext action_block() {
			return getRuleContext(Action_blockContext.class,0);
		}
		public Entry_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entry_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KstatesVisitor ) return ((KstatesVisitor<? extends T>)visitor).visitEntry_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Entry_blockContext entry_block() throws RecognitionException {
		Entry_blockContext _localctx = new Entry_blockContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_entry_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(ENTRY);
			setState(106);
			action_block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Do_blockContext extends ParserRuleContext {
		public TerminalNode DO() { return getToken(KstatesParser.DO, 0); }
		public Action_blockContext action_block() {
			return getRuleContext(Action_blockContext.class,0);
		}
		public Do_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_do_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KstatesVisitor ) return ((KstatesVisitor<? extends T>)visitor).visitDo_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Do_blockContext do_block() throws RecognitionException {
		Do_blockContext _localctx = new Do_blockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_do_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(DO);
			setState(109);
			action_block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Action_blockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(KstatesParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(KstatesParser.RBRACE, 0); }
		public List<Action_ruleContext> action_rule() {
			return getRuleContexts(Action_ruleContext.class);
		}
		public Action_ruleContext action_rule(int i) {
			return getRuleContext(Action_ruleContext.class,i);
		}
		public Action_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KstatesVisitor ) return ((KstatesVisitor<? extends T>)visitor).visitAction_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Action_blockContext action_block() throws RecognitionException {
		Action_blockContext _localctx = new Action_blockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_action_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(LBRACE);
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3584L) != 0)) {
				{
				{
				setState(112);
				action_rule();
				}
				}
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(118);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Action_ruleContext extends ParserRuleContext {
		public Action_operationContext action_operation() {
			return getRuleContext(Action_operationContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(KstatesParser.LPAREN, 0); }
		public TerminalNode STRING() { return getToken(KstatesParser.STRING, 0); }
		public TerminalNode COMMA() { return getToken(KstatesParser.COMMA, 0); }
		public Action_right_sideContext action_right_side() {
			return getRuleContext(Action_right_sideContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(KstatesParser.RPAREN, 0); }
		public Action_ruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action_rule; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KstatesVisitor ) return ((KstatesVisitor<? extends T>)visitor).visitAction_rule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Action_ruleContext action_rule() throws RecognitionException {
		Action_ruleContext _localctx = new Action_ruleContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_action_rule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			action_operation();
			setState(121);
			match(LPAREN);
			setState(122);
			match(STRING);
			setState(123);
			match(COMMA);
			setState(124);
			action_right_side();
			setState(125);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Action_operationContext extends ParserRuleContext {
		public TerminalNode SET() { return getToken(KstatesParser.SET, 0); }
		public TerminalNode APPEND() { return getToken(KstatesParser.APPEND, 0); }
		public TerminalNode EVENT() { return getToken(KstatesParser.EVENT, 0); }
		public Action_operationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action_operation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KstatesVisitor ) return ((KstatesVisitor<? extends T>)visitor).visitAction_operation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Action_operationContext action_operation() throws RecognitionException {
		Action_operationContext _localctx = new Action_operationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_action_operation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3584L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Action_right_sideContext extends ParserRuleContext {
		public Macro_callContext macro_call() {
			return getRuleContext(Macro_callContext.class,0);
		}
		public Eval_statementContext eval_statement() {
			return getRuleContext(Eval_statementContext.class,0);
		}
		public TerminalNode STRING() { return getToken(KstatesParser.STRING, 0); }
		public Action_right_sideContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action_right_side; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KstatesVisitor ) return ((KstatesVisitor<? extends T>)visitor).visitAction_right_side(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Action_right_sideContext action_right_side() throws RecognitionException {
		Action_right_sideContext _localctx = new Action_right_sideContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_action_right_side);
		try {
			setState(132);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MACRO:
				enterOuterAlt(_localctx, 1);
				{
				setState(129);
				macro_call();
				}
				break;
			case EVAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(130);
				eval_statement();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(131);
				match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Macro_callContext extends ParserRuleContext {
		public TerminalNode MACRO() { return getToken(KstatesParser.MACRO, 0); }
		public TerminalNode LPAREN() { return getToken(KstatesParser.LPAREN, 0); }
		public List<TerminalNode> STRING() { return getTokens(KstatesParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(KstatesParser.STRING, i);
		}
		public TerminalNode RPAREN() { return getToken(KstatesParser.RPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(KstatesParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(KstatesParser.COMMA, i);
		}
		public Macro_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macro_call; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KstatesVisitor ) return ((KstatesVisitor<? extends T>)visitor).visitMacro_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Macro_callContext macro_call() throws RecognitionException {
		Macro_callContext _localctx = new Macro_callContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_macro_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(MACRO);
			setState(135);
			match(LPAREN);
			setState(136);
			match(STRING);
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(137);
				match(COMMA);
				setState(138);
				match(STRING);
				}
				}
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(144);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Eval_statementContext extends ParserRuleContext {
		public TerminalNode EVAL() { return getToken(KstatesParser.EVAL, 0); }
		public TerminalNode LBRACE() { return getToken(KstatesParser.LBRACE, 0); }
		public Eval_code_blockContext eval_code_block() {
			return getRuleContext(Eval_code_blockContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(KstatesParser.RBRACE, 0); }
		public Eval_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eval_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KstatesVisitor ) return ((KstatesVisitor<? extends T>)visitor).visitEval_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Eval_statementContext eval_statement() throws RecognitionException {
		Eval_statementContext _localctx = new Eval_statementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_eval_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(EVAL);
			setState(147);
			match(LBRACE);
			setState(148);
			eval_code_block();
			setState(149);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Transitions_blockContext extends ParserRuleContext {
		public TerminalNode TRANSITIONS() { return getToken(KstatesParser.TRANSITIONS, 0); }
		public TerminalNode LBRACE() { return getToken(KstatesParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(KstatesParser.RBRACE, 0); }
		public List<Transition_definitionContext> transition_definition() {
			return getRuleContexts(Transition_definitionContext.class);
		}
		public Transition_definitionContext transition_definition(int i) {
			return getRuleContext(Transition_definitionContext.class,i);
		}
		public Transitions_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transitions_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KstatesVisitor ) return ((KstatesVisitor<? extends T>)visitor).visitTransitions_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Transitions_blockContext transitions_block() throws RecognitionException {
		Transitions_blockContext _localctx = new Transitions_blockContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_transitions_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(TRANSITIONS);
			setState(152);
			match(LBRACE);
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TRANSITION) {
				{
				{
				setState(153);
				transition_definition();
				}
				}
				setState(158);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(159);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Transition_definitionContext extends ParserRuleContext {
		public TerminalNode TRANSITION() { return getToken(KstatesParser.TRANSITION, 0); }
		public List<TerminalNode> STRING() { return getTokens(KstatesParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(KstatesParser.STRING, i);
		}
		public TerminalNode ARROW() { return getToken(KstatesParser.ARROW, 0); }
		public TerminalNode LBRACE() { return getToken(KstatesParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(KstatesParser.RBRACE, 0); }
		public Not_loopingContext not_looping() {
			return getRuleContext(Not_loopingContext.class,0);
		}
		public Condition_blockContext condition_block() {
			return getRuleContext(Condition_blockContext.class,0);
		}
		public Transition_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transition_definition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KstatesVisitor ) return ((KstatesVisitor<? extends T>)visitor).visitTransition_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Transition_definitionContext transition_definition() throws RecognitionException {
		Transition_definitionContext _localctx = new Transition_definitionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_transition_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(TRANSITION);
			setState(162);
			match(STRING);
			setState(163);
			match(ARROW);
			setState(164);
			match(STRING);
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(165);
				not_looping();
				}
			}

			setState(168);
			match(LBRACE);
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONDITION) {
				{
				setState(169);
				condition_block();
				}
			}

			setState(172);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Not_loopingContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(KstatesParser.NOT, 0); }
		public TerminalNode LOOPING() { return getToken(KstatesParser.LOOPING, 0); }
		public Not_loopingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_not_looping; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KstatesVisitor ) return ((KstatesVisitor<? extends T>)visitor).visitNot_looping(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Not_loopingContext not_looping() throws RecognitionException {
		Not_loopingContext _localctx = new Not_loopingContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_not_looping);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(NOT);
			setState(175);
			match(LOOPING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Condition_blockContext extends ParserRuleContext {
		public TerminalNode CONDITION() { return getToken(KstatesParser.CONDITION, 0); }
		public TerminalNode LBRACE() { return getToken(KstatesParser.LBRACE, 0); }
		public Transition_conditionContext transition_condition() {
			return getRuleContext(Transition_conditionContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(KstatesParser.RBRACE, 0); }
		public Condition_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KstatesVisitor ) return ((KstatesVisitor<? extends T>)visitor).visitCondition_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Condition_blockContext condition_block() throws RecognitionException {
		Condition_blockContext _localctx = new Condition_blockContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_condition_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			match(CONDITION);
			setState(178);
			match(LBRACE);
			setState(179);
			transition_condition();
			setState(180);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Transition_conditionContext extends ParserRuleContext {
		public Eval_statementContext eval_statement() {
			return getRuleContext(Eval_statementContext.class,0);
		}
		public Event_conditionContext event_condition() {
			return getRuleContext(Event_conditionContext.class,0);
		}
		public Value_conditionContext value_condition() {
			return getRuleContext(Value_conditionContext.class,0);
		}
		public Transition_conditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transition_condition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KstatesVisitor ) return ((KstatesVisitor<? extends T>)visitor).visitTransition_condition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Transition_conditionContext transition_condition() throws RecognitionException {
		Transition_conditionContext _localctx = new Transition_conditionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_transition_condition);
		try {
			setState(185);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EVAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(182);
				eval_statement();
				}
				break;
			case EVENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(183);
				event_condition();
				}
				break;
			case VALUE:
				enterOuterAlt(_localctx, 3);
				{
				setState(184);
				value_condition();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Event_conditionContext extends ParserRuleContext {
		public TerminalNode EVENT() { return getToken(KstatesParser.EVENT, 0); }
		public TerminalNode LPAREN() { return getToken(KstatesParser.LPAREN, 0); }
		public List<TerminalNode> STRING() { return getTokens(KstatesParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(KstatesParser.STRING, i);
		}
		public TerminalNode COMMA() { return getToken(KstatesParser.COMMA, 0); }
		public TerminalNode RPAREN() { return getToken(KstatesParser.RPAREN, 0); }
		public Event_conditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_event_condition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KstatesVisitor ) return ((KstatesVisitor<? extends T>)visitor).visitEvent_condition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Event_conditionContext event_condition() throws RecognitionException {
		Event_conditionContext _localctx = new Event_conditionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_event_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			match(EVENT);
			setState(188);
			match(LPAREN);
			setState(189);
			match(STRING);
			setState(190);
			match(COMMA);
			setState(191);
			match(STRING);
			setState(192);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Value_conditionContext extends ParserRuleContext {
		public TerminalNode VALUE() { return getToken(KstatesParser.VALUE, 0); }
		public TerminalNode LPAREN() { return getToken(KstatesParser.LPAREN, 0); }
		public TerminalNode STRING() { return getToken(KstatesParser.STRING, 0); }
		public TerminalNode RPAREN() { return getToken(KstatesParser.RPAREN, 0); }
		public Value_conditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_condition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KstatesVisitor ) return ((KstatesVisitor<? extends T>)visitor).visitValue_condition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Value_conditionContext value_condition() throws RecognitionException {
		Value_conditionContext _localctx = new Value_conditionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_value_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			match(VALUE);
			setState(195);
			match(LPAREN);
			setState(196);
			match(STRING);
			setState(197);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Macros_blockContext extends ParserRuleContext {
		public TerminalNode MACROS() { return getToken(KstatesParser.MACROS, 0); }
		public TerminalNode LBRACE() { return getToken(KstatesParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(KstatesParser.RBRACE, 0); }
		public List<Macro_definitionContext> macro_definition() {
			return getRuleContexts(Macro_definitionContext.class);
		}
		public Macro_definitionContext macro_definition(int i) {
			return getRuleContext(Macro_definitionContext.class,i);
		}
		public Macros_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macros_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KstatesVisitor ) return ((KstatesVisitor<? extends T>)visitor).visitMacros_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Macros_blockContext macros_block() throws RecognitionException {
		Macros_blockContext _localctx = new Macros_blockContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_macros_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			match(MACROS);
			setState(200);
			match(LBRACE);
			setState(204);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MACRO) {
				{
				{
				setState(201);
				macro_definition();
				}
				}
				setState(206);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(207);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Macro_definitionContext extends ParserRuleContext {
		public TerminalNode MACRO() { return getToken(KstatesParser.MACRO, 0); }
		public TerminalNode STRING() { return getToken(KstatesParser.STRING, 0); }
		public TerminalNode LBRACE() { return getToken(KstatesParser.LBRACE, 0); }
		public Returns_directiveContext returns_directive() {
			return getRuleContext(Returns_directiveContext.class,0);
		}
		public Definition_blockContext definition_block() {
			return getRuleContext(Definition_blockContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(KstatesParser.RBRACE, 0); }
		public List<Takes_directiveContext> takes_directive() {
			return getRuleContexts(Takes_directiveContext.class);
		}
		public Takes_directiveContext takes_directive(int i) {
			return getRuleContext(Takes_directiveContext.class,i);
		}
		public Macro_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macro_definition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KstatesVisitor ) return ((KstatesVisitor<? extends T>)visitor).visitMacro_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Macro_definitionContext macro_definition() throws RecognitionException {
		Macro_definitionContext _localctx = new Macro_definitionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_macro_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			match(MACRO);
			setState(210);
			match(STRING);
			setState(211);
			match(LBRACE);
			setState(215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TAKES) {
				{
				{
				setState(212);
				takes_directive();
				}
				}
				setState(217);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(218);
			returns_directive();
			setState(219);
			definition_block();
			setState(220);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Takes_directiveContext extends ParserRuleContext {
		public TerminalNode TAKES() { return getToken(KstatesParser.TAKES, 0); }
		public TerminalNode LPAREN() { return getToken(KstatesParser.LPAREN, 0); }
		public TerminalNode STRING() { return getToken(KstatesParser.STRING, 0); }
		public TerminalNode COMMA() { return getToken(KstatesParser.COMMA, 0); }
		public Type_expressionContext type_expression() {
			return getRuleContext(Type_expressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(KstatesParser.RPAREN, 0); }
		public Takes_directiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_takes_directive; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KstatesVisitor ) return ((KstatesVisitor<? extends T>)visitor).visitTakes_directive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Takes_directiveContext takes_directive() throws RecognitionException {
		Takes_directiveContext _localctx = new Takes_directiveContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_takes_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			match(TAKES);
			setState(223);
			match(LPAREN);
			setState(224);
			match(STRING);
			setState(225);
			match(COMMA);
			setState(226);
			type_expression();
			setState(227);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Returns_directiveContext extends ParserRuleContext {
		public TerminalNode RETURNS() { return getToken(KstatesParser.RETURNS, 0); }
		public TerminalNode LPAREN() { return getToken(KstatesParser.LPAREN, 0); }
		public Return_expressionContext return_expression() {
			return getRuleContext(Return_expressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(KstatesParser.RPAREN, 0); }
		public Returns_directiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returns_directive; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KstatesVisitor ) return ((KstatesVisitor<? extends T>)visitor).visitReturns_directive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Returns_directiveContext returns_directive() throws RecognitionException {
		Returns_directiveContext _localctx = new Returns_directiveContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_returns_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			match(RETURNS);
			setState(230);
			match(LPAREN);
			setState(231);
			return_expression();
			setState(232);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Return_expressionContext extends ParserRuleContext {
		public Type_expressionContext type_expression() {
			return getRuleContext(Type_expressionContext.class,0);
		}
		public Reference_expressionContext reference_expression() {
			return getRuleContext(Reference_expressionContext.class,0);
		}
		public Return_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KstatesVisitor ) return ((KstatesVisitor<? extends T>)visitor).visitReturn_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_expressionContext return_expression() throws RecognitionException {
		Return_expressionContext _localctx = new Return_expressionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_return_expression);
		try {
			setState(236);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(234);
				type_expression();
				}
				break;
			case REFERENCE:
				enterOuterAlt(_localctx, 2);
				{
				setState(235);
				reference_expression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Type_expressionContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(KstatesParser.STRING, 0); }
		public Typed_call_expressionContext typed_call_expression() {
			return getRuleContext(Typed_call_expressionContext.class,0);
		}
		public Type_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KstatesVisitor ) return ((KstatesVisitor<? extends T>)visitor).visitType_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_expressionContext type_expression() throws RecognitionException {
		Type_expressionContext _localctx = new Type_expressionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_type_expression);
		try {
			setState(240);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(238);
				match(STRING);
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(239);
				typed_call_expression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Typed_call_expressionContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(KstatesParser.IDENT, 0); }
		public TerminalNode LPAREN() { return getToken(KstatesParser.LPAREN, 0); }
		public TerminalNode STRING() { return getToken(KstatesParser.STRING, 0); }
		public TerminalNode RPAREN() { return getToken(KstatesParser.RPAREN, 0); }
		public Typed_call_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typed_call_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KstatesVisitor ) return ((KstatesVisitor<? extends T>)visitor).visitTyped_call_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Typed_call_expressionContext typed_call_expression() throws RecognitionException {
		Typed_call_expressionContext _localctx = new Typed_call_expressionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_typed_call_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			match(IDENT);
			setState(243);
			match(LPAREN);
			setState(244);
			match(STRING);
			setState(245);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Reference_expressionContext extends ParserRuleContext {
		public TerminalNode REFERENCE() { return getToken(KstatesParser.REFERENCE, 0); }
		public TerminalNode LPAREN() { return getToken(KstatesParser.LPAREN, 0); }
		public TerminalNode STRING() { return getToken(KstatesParser.STRING, 0); }
		public TerminalNode RPAREN() { return getToken(KstatesParser.RPAREN, 0); }
		public Reference_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reference_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KstatesVisitor ) return ((KstatesVisitor<? extends T>)visitor).visitReference_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Reference_expressionContext reference_expression() throws RecognitionException {
		Reference_expressionContext _localctx = new Reference_expressionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_reference_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			match(REFERENCE);
			setState(248);
			match(LPAREN);
			setState(249);
			match(STRING);
			setState(250);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Definition_blockContext extends ParserRuleContext {
		public TerminalNode DEFINITION() { return getToken(KstatesParser.DEFINITION, 0); }
		public TerminalNode LBRACE() { return getToken(KstatesParser.LBRACE, 0); }
		public Eval_statementContext eval_statement() {
			return getRuleContext(Eval_statementContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(KstatesParser.RBRACE, 0); }
		public Definition_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KstatesVisitor ) return ((KstatesVisitor<? extends T>)visitor).visitDefinition_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Definition_blockContext definition_block() throws RecognitionException {
		Definition_blockContext _localctx = new Definition_blockContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_definition_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			match(DEFINITION);
			setState(253);
			match(LBRACE);
			setState(254);
			eval_statement();
			setState(255);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Eval_code_blockContext extends ParserRuleContext {
		public List<Code_contentContext> code_content() {
			return getRuleContexts(Code_contentContext.class);
		}
		public Code_contentContext code_content(int i) {
			return getRuleContext(Code_contentContext.class,i);
		}
		public Eval_code_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eval_code_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KstatesVisitor ) return ((KstatesVisitor<? extends T>)visitor).visitEval_code_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Eval_code_blockContext eval_code_block() throws RecognitionException {
		Eval_code_blockContext _localctx = new Eval_code_blockContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_eval_code_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 274743689214L) != 0)) {
				{
				{
				setState(257);
				code_content();
				}
				}
				setState(262);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Code_contentContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(KstatesParser.LBRACE, 0); }
		public Eval_code_blockContext eval_code_block() {
			return getRuleContext(Eval_code_blockContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(KstatesParser.RBRACE, 0); }
		public Code_contentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_code_content; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KstatesVisitor ) return ((KstatesVisitor<? extends T>)visitor).visitCode_content(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Code_contentContext code_content() throws RecognitionException {
		Code_contentContext _localctx = new Code_contentContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_code_content);
		int _la;
		try {
			setState(268);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(263);
				match(LBRACE);
				setState(264);
				eval_code_block();
				setState(265);
				match(RBRACE);
				}
				break;
			case STATEMACHINE:
			case ATTACHED:
			case TO:
			case STATES:
			case STATE:
			case INITIAL:
			case ENTRY:
			case DO:
			case SET:
			case APPEND:
			case EVENT:
			case MACRO:
			case EVAL:
			case TRANSITIONS:
			case TRANSITION:
			case NOT:
			case LOOPING:
			case CONDITION:
			case VALUE:
			case MACROS:
			case TAKES:
			case RETURNS:
			case DEFINITION:
			case REFERENCE:
			case ARROW:
			case LPAREN:
			case RPAREN:
			case COMMA:
			case STRING:
			case SSTRING:
			case IDENT:
			case NUMBER:
			case WS:
			case LINE_COMMENT:
			case SYMBOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(267);
				_la = _input.LA(1);
				if ( _la <= 0 || (_la==LBRACE || _la==RBRACE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001%\u010f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001H\b\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002O\b\u0002"+
		"\n\u0002\f\u0002R\t\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0003\u0003"+
		"W\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"]\b\u0003\u0001\u0003\u0003\u0003`\b\u0003\u0001\u0003\u0005\u0003c\b"+
		"\u0003\n\u0003\f\u0003f\t\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0005\u0006r\b\u0006\n\u0006\f\u0006u\t\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0003\t\u0085"+
		"\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u008c\b\n\n\n\f\n"+
		"\u008f\t\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\f\u0005\f\u009b\b\f\n\f\f\f\u009e\t"+
		"\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00a7"+
		"\b\r\u0001\r\u0001\r\u0003\r\u00ab\b\r\u0001\r\u0001\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00ba\b\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u00cb\b\u0013\n\u0013\f\u0013"+
		"\u00ce\t\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0005\u0014\u00d6\b\u0014\n\u0014\f\u0014\u00d9\t\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0003"+
		"\u0017\u00ed\b\u0017\u0001\u0018\u0001\u0018\u0003\u0018\u00f1\b\u0018"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0005\u001c\u0103\b\u001c"+
		"\n\u001c\f\u001c\u0106\t\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0003\u001d\u010d\b\u001d\u0001\u001d\u0000\u0000\u001e"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$&(*,.02468:\u0000\u0002\u0001\u0000\t\u000b\u0001\u0000"+
		"\u001a\u001b\u0105\u0000<\u0001\u0000\u0000\u0000\u0002?\u0001\u0000\u0000"+
		"\u0000\u0004K\u0001\u0000\u0000\u0000\u0006V\u0001\u0000\u0000\u0000\b"+
		"i\u0001\u0000\u0000\u0000\nl\u0001\u0000\u0000\u0000\fo\u0001\u0000\u0000"+
		"\u0000\u000ex\u0001\u0000\u0000\u0000\u0010\u007f\u0001\u0000\u0000\u0000"+
		"\u0012\u0084\u0001\u0000\u0000\u0000\u0014\u0086\u0001\u0000\u0000\u0000"+
		"\u0016\u0092\u0001\u0000\u0000\u0000\u0018\u0097\u0001\u0000\u0000\u0000"+
		"\u001a\u00a1\u0001\u0000\u0000\u0000\u001c\u00ae\u0001\u0000\u0000\u0000"+
		"\u001e\u00b1\u0001\u0000\u0000\u0000 \u00b9\u0001\u0000\u0000\u0000\""+
		"\u00bb\u0001\u0000\u0000\u0000$\u00c2\u0001\u0000\u0000\u0000&\u00c7\u0001"+
		"\u0000\u0000\u0000(\u00d1\u0001\u0000\u0000\u0000*\u00de\u0001\u0000\u0000"+
		"\u0000,\u00e5\u0001\u0000\u0000\u0000.\u00ec\u0001\u0000\u0000\u00000"+
		"\u00f0\u0001\u0000\u0000\u00002\u00f2\u0001\u0000\u0000\u00004\u00f7\u0001"+
		"\u0000\u0000\u00006\u00fc\u0001\u0000\u0000\u00008\u0104\u0001\u0000\u0000"+
		"\u0000:\u010c\u0001\u0000\u0000\u0000<=\u0003\u0002\u0001\u0000=>\u0005"+
		"\u0000\u0000\u0001>\u0001\u0001\u0000\u0000\u0000?@\u0005\u0001\u0000"+
		"\u0000@A\u0005\u0002\u0000\u0000AB\u0005\u0003\u0000\u0000BC\u0005\u001f"+
		"\u0000\u0000CD\u0005\u001a\u0000\u0000DE\u0003\u0004\u0002\u0000EG\u0003"+
		"\u0018\f\u0000FH\u0003&\u0013\u0000GF\u0001\u0000\u0000\u0000GH\u0001"+
		"\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000IJ\u0005\u001b\u0000\u0000"+
		"J\u0003\u0001\u0000\u0000\u0000KL\u0005\u0004\u0000\u0000LP\u0005\u001a"+
		"\u0000\u0000MO\u0003\u0006\u0003\u0000NM\u0001\u0000\u0000\u0000OR\u0001"+
		"\u0000\u0000\u0000PN\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000"+
		"QS\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000ST\u0005\u001b\u0000"+
		"\u0000T\u0005\u0001\u0000\u0000\u0000UW\u0005\u0006\u0000\u0000VU\u0001"+
		"\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000"+
		"XY\u0005\u0005\u0000\u0000YZ\u0005\u001f\u0000\u0000Z\\\u0005\u001a\u0000"+
		"\u0000[]\u0003\b\u0004\u0000\\[\u0001\u0000\u0000\u0000\\]\u0001\u0000"+
		"\u0000\u0000]_\u0001\u0000\u0000\u0000^`\u0003\n\u0005\u0000_^\u0001\u0000"+
		"\u0000\u0000_`\u0001\u0000\u0000\u0000`d\u0001\u0000\u0000\u0000ac\u0003"+
		"\u0006\u0003\u0000ba\u0001\u0000\u0000\u0000cf\u0001\u0000\u0000\u0000"+
		"db\u0001\u0000\u0000\u0000de\u0001\u0000\u0000\u0000eg\u0001\u0000\u0000"+
		"\u0000fd\u0001\u0000\u0000\u0000gh\u0005\u001b\u0000\u0000h\u0007\u0001"+
		"\u0000\u0000\u0000ij\u0005\u0007\u0000\u0000jk\u0003\f\u0006\u0000k\t"+
		"\u0001\u0000\u0000\u0000lm\u0005\b\u0000\u0000mn\u0003\f\u0006\u0000n"+
		"\u000b\u0001\u0000\u0000\u0000os\u0005\u001a\u0000\u0000pr\u0003\u000e"+
		"\u0007\u0000qp\u0001\u0000\u0000\u0000ru\u0001\u0000\u0000\u0000sq\u0001"+
		"\u0000\u0000\u0000st\u0001\u0000\u0000\u0000tv\u0001\u0000\u0000\u0000"+
		"us\u0001\u0000\u0000\u0000vw\u0005\u001b\u0000\u0000w\r\u0001\u0000\u0000"+
		"\u0000xy\u0003\u0010\b\u0000yz\u0005\u001c\u0000\u0000z{\u0005\u001f\u0000"+
		"\u0000{|\u0005\u001e\u0000\u0000|}\u0003\u0012\t\u0000}~\u0005\u001d\u0000"+
		"\u0000~\u000f\u0001\u0000\u0000\u0000\u007f\u0080\u0007\u0000\u0000\u0000"+
		"\u0080\u0011\u0001\u0000\u0000\u0000\u0081\u0085\u0003\u0014\n\u0000\u0082"+
		"\u0085\u0003\u0016\u000b\u0000\u0083\u0085\u0005\u001f\u0000\u0000\u0084"+
		"\u0081\u0001\u0000\u0000\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0084"+
		"\u0083\u0001\u0000\u0000\u0000\u0085\u0013\u0001\u0000\u0000\u0000\u0086"+
		"\u0087\u0005\f\u0000\u0000\u0087\u0088\u0005\u001c\u0000\u0000\u0088\u008d"+
		"\u0005\u001f\u0000\u0000\u0089\u008a\u0005\u001e\u0000\u0000\u008a\u008c"+
		"\u0005\u001f\u0000\u0000\u008b\u0089\u0001\u0000\u0000\u0000\u008c\u008f"+
		"\u0001\u0000\u0000\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008d\u008e"+
		"\u0001\u0000\u0000\u0000\u008e\u0090\u0001\u0000\u0000\u0000\u008f\u008d"+
		"\u0001\u0000\u0000\u0000\u0090\u0091\u0005\u001d\u0000\u0000\u0091\u0015"+
		"\u0001\u0000\u0000\u0000\u0092\u0093\u0005\r\u0000\u0000\u0093\u0094\u0005"+
		"\u001a\u0000\u0000\u0094\u0095\u00038\u001c\u0000\u0095\u0096\u0005\u001b"+
		"\u0000\u0000\u0096\u0017\u0001\u0000\u0000\u0000\u0097\u0098\u0005\u000e"+
		"\u0000\u0000\u0098\u009c\u0005\u001a\u0000\u0000\u0099\u009b\u0003\u001a"+
		"\r\u0000\u009a\u0099\u0001\u0000\u0000\u0000\u009b\u009e\u0001\u0000\u0000"+
		"\u0000\u009c\u009a\u0001\u0000\u0000\u0000\u009c\u009d\u0001\u0000\u0000"+
		"\u0000\u009d\u009f\u0001\u0000\u0000\u0000\u009e\u009c\u0001\u0000\u0000"+
		"\u0000\u009f\u00a0\u0005\u001b\u0000\u0000\u00a0\u0019\u0001\u0000\u0000"+
		"\u0000\u00a1\u00a2\u0005\u000f\u0000\u0000\u00a2\u00a3\u0005\u001f\u0000"+
		"\u0000\u00a3\u00a4\u0005\u0019\u0000\u0000\u00a4\u00a6\u0005\u001f\u0000"+
		"\u0000\u00a5\u00a7\u0003\u001c\u000e\u0000\u00a6\u00a5\u0001\u0000\u0000"+
		"\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000"+
		"\u0000\u00a8\u00aa\u0005\u001a\u0000\u0000\u00a9\u00ab\u0003\u001e\u000f"+
		"\u0000\u00aa\u00a9\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000"+
		"\u0000\u00ab\u00ac\u0001\u0000\u0000\u0000\u00ac\u00ad\u0005\u001b\u0000"+
		"\u0000\u00ad\u001b\u0001\u0000\u0000\u0000\u00ae\u00af\u0005\u0010\u0000"+
		"\u0000\u00af\u00b0\u0005\u0011\u0000\u0000\u00b0\u001d\u0001\u0000\u0000"+
		"\u0000\u00b1\u00b2\u0005\u0012\u0000\u0000\u00b2\u00b3\u0005\u001a\u0000"+
		"\u0000\u00b3\u00b4\u0003 \u0010\u0000\u00b4\u00b5\u0005\u001b\u0000\u0000"+
		"\u00b5\u001f\u0001\u0000\u0000\u0000\u00b6\u00ba\u0003\u0016\u000b\u0000"+
		"\u00b7\u00ba\u0003\"\u0011\u0000\u00b8\u00ba\u0003$\u0012\u0000\u00b9"+
		"\u00b6\u0001\u0000\u0000\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000\u00b9"+
		"\u00b8\u0001\u0000\u0000\u0000\u00ba!\u0001\u0000\u0000\u0000\u00bb\u00bc"+
		"\u0005\u000b\u0000\u0000\u00bc\u00bd\u0005\u001c\u0000\u0000\u00bd\u00be"+
		"\u0005\u001f\u0000\u0000\u00be\u00bf\u0005\u001e\u0000\u0000\u00bf\u00c0"+
		"\u0005\u001f\u0000\u0000\u00c0\u00c1\u0005\u001d\u0000\u0000\u00c1#\u0001"+
		"\u0000\u0000\u0000\u00c2\u00c3\u0005\u0013\u0000\u0000\u00c3\u00c4\u0005"+
		"\u001c\u0000\u0000\u00c4\u00c5\u0005\u001f\u0000\u0000\u00c5\u00c6\u0005"+
		"\u001d\u0000\u0000\u00c6%\u0001\u0000\u0000\u0000\u00c7\u00c8\u0005\u0014"+
		"\u0000\u0000\u00c8\u00cc\u0005\u001a\u0000\u0000\u00c9\u00cb\u0003(\u0014"+
		"\u0000\u00ca\u00c9\u0001\u0000\u0000\u0000\u00cb\u00ce\u0001\u0000\u0000"+
		"\u0000\u00cc\u00ca\u0001\u0000\u0000\u0000\u00cc\u00cd\u0001\u0000\u0000"+
		"\u0000\u00cd\u00cf\u0001\u0000\u0000\u0000\u00ce\u00cc\u0001\u0000\u0000"+
		"\u0000\u00cf\u00d0\u0005\u001b\u0000\u0000\u00d0\'\u0001\u0000\u0000\u0000"+
		"\u00d1\u00d2\u0005\f\u0000\u0000\u00d2\u00d3\u0005\u001f\u0000\u0000\u00d3"+
		"\u00d7\u0005\u001a\u0000\u0000\u00d4\u00d6\u0003*\u0015\u0000\u00d5\u00d4"+
		"\u0001\u0000\u0000\u0000\u00d6\u00d9\u0001\u0000\u0000\u0000\u00d7\u00d5"+
		"\u0001\u0000\u0000\u0000\u00d7\u00d8\u0001\u0000\u0000\u0000\u00d8\u00da"+
		"\u0001\u0000\u0000\u0000\u00d9\u00d7\u0001\u0000\u0000\u0000\u00da\u00db"+
		"\u0003,\u0016\u0000\u00db\u00dc\u00036\u001b\u0000\u00dc\u00dd\u0005\u001b"+
		"\u0000\u0000\u00dd)\u0001\u0000\u0000\u0000\u00de\u00df\u0005\u0015\u0000"+
		"\u0000\u00df\u00e0\u0005\u001c\u0000\u0000\u00e0\u00e1\u0005\u001f\u0000"+
		"\u0000\u00e1\u00e2\u0005\u001e\u0000\u0000\u00e2\u00e3\u00030\u0018\u0000"+
		"\u00e3\u00e4\u0005\u001d\u0000\u0000\u00e4+\u0001\u0000\u0000\u0000\u00e5"+
		"\u00e6\u0005\u0016\u0000\u0000\u00e6\u00e7\u0005\u001c\u0000\u0000\u00e7"+
		"\u00e8\u0003.\u0017\u0000\u00e8\u00e9\u0005\u001d\u0000\u0000\u00e9-\u0001"+
		"\u0000\u0000\u0000\u00ea\u00ed\u00030\u0018\u0000\u00eb\u00ed\u00034\u001a"+
		"\u0000\u00ec\u00ea\u0001\u0000\u0000\u0000\u00ec\u00eb\u0001\u0000\u0000"+
		"\u0000\u00ed/\u0001\u0000\u0000\u0000\u00ee\u00f1\u0005\u001f\u0000\u0000"+
		"\u00ef\u00f1\u00032\u0019\u0000\u00f0\u00ee\u0001\u0000\u0000\u0000\u00f0"+
		"\u00ef\u0001\u0000\u0000\u0000\u00f11\u0001\u0000\u0000\u0000\u00f2\u00f3"+
		"\u0005!\u0000\u0000\u00f3\u00f4\u0005\u001c\u0000\u0000\u00f4\u00f5\u0005"+
		"\u001f\u0000\u0000\u00f5\u00f6\u0005\u001d\u0000\u0000\u00f63\u0001\u0000"+
		"\u0000\u0000\u00f7\u00f8\u0005\u0018\u0000\u0000\u00f8\u00f9\u0005\u001c"+
		"\u0000\u0000\u00f9\u00fa\u0005\u001f\u0000\u0000\u00fa\u00fb\u0005\u001d"+
		"\u0000\u0000\u00fb5\u0001\u0000\u0000\u0000\u00fc\u00fd\u0005\u0017\u0000"+
		"\u0000\u00fd\u00fe\u0005\u001a\u0000\u0000\u00fe\u00ff\u0003\u0016\u000b"+
		"\u0000\u00ff\u0100\u0005\u001b\u0000\u0000\u01007\u0001\u0000\u0000\u0000"+
		"\u0101\u0103\u0003:\u001d\u0000\u0102\u0101\u0001\u0000\u0000\u0000\u0103"+
		"\u0106\u0001\u0000\u0000\u0000\u0104\u0102\u0001\u0000\u0000\u0000\u0104"+
		"\u0105\u0001\u0000\u0000\u0000\u01059\u0001\u0000\u0000\u0000\u0106\u0104"+
		"\u0001\u0000\u0000\u0000\u0107\u0108\u0005\u001a\u0000\u0000\u0108\u0109"+
		"\u00038\u001c\u0000\u0109\u010a\u0005\u001b\u0000\u0000\u010a\u010d\u0001"+
		"\u0000\u0000\u0000\u010b\u010d\b\u0001\u0000\u0000\u010c\u0107\u0001\u0000"+
		"\u0000\u0000\u010c\u010b\u0001\u0000\u0000\u0000\u010d;\u0001\u0000\u0000"+
		"\u0000\u0013GPV\\_ds\u0084\u008d\u009c\u00a6\u00aa\u00b9\u00cc\u00d7\u00ec"+
		"\u00f0\u0104\u010c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}