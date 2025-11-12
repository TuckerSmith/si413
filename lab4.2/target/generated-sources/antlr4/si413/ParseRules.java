// Generated from si413/ParseRules.g4 by ANTLR 4.13.1
package si413;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ParseRules extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IF=1, RETURN=2, CONCAT=3, WHILE=4, FUNCTION=5, COMMA=6, LARROW=7, RARROW=8, 
		LPREN=9, RPREN=10, LBRACK=11, RBRACK=12, NOT=13, OP=14, BOOL=15, PRINT=16, 
		INPUT=17, REV=18, LIT=19, ID=20, IGNORE=21;
	public static final int
		RULE_prog = 0, RULE_stat = 1, RULE_arguments = 2, RULE_argumentsRepeat = 3, 
		RULE_bracket = 4, RULE_inner = 5, RULE_expr = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "stat", "arguments", "argumentsRepeat", "bracket", "inner", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IF", "RETURN", "CONCAT", "WHILE", "FUNCTION", "COMMA", "LARROW", 
			"RARROW", "LPREN", "RPREN", "LBRACK", "RBRACK", "NOT", "OP", "BOOL", 
			"PRINT", "INPUT", "REV", "LIT", "ID", "IGNORE"
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
	public String getGrammarFileName() { return "ParseRules.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ParseRules(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	 
		public ProgContext() { }
		public void copyFrom(ProgContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RegularProgContext extends ProgContext {
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public ProgContext prog() {
			return getRuleContext(ProgContext.class,0);
		}
		public RegularProgContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).enterRegularProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).exitRegularProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParseRulesVisitor ) return ((ParseRulesVisitor<? extends T>)visitor).visitRegularProg(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EmptyProgContext extends ProgContext {
		public TerminalNode EOF() { return getToken(ParseRules.EOF, 0); }
		public EmptyProgContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).enterEmptyProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).exitEmptyProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParseRulesVisitor ) return ((ParseRulesVisitor<? extends T>)visitor).visitEmptyProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			setState(18);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
			case RETURN:
			case WHILE:
			case FUNCTION:
			case PRINT:
			case ID:
				_localctx = new RegularProgContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(14);
				stat();
				setState(15);
				prog();
				}
				break;
			case EOF:
				_localctx = new EmptyProgContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(17);
				match(EOF);
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
	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStatContext extends StatContext {
		public TerminalNode RETURN() { return getToken(ParseRules.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).enterReturnStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).exitReturnStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParseRulesVisitor ) return ((ParseRulesVisitor<? extends T>)visitor).visitReturnStat(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IFStatContext extends StatContext {
		public TerminalNode IF() { return getToken(ParseRules.IF, 0); }
		public TerminalNode LPREN() { return getToken(ParseRules.LPREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPREN() { return getToken(ParseRules.RPREN, 0); }
		public BracketContext bracket() {
			return getRuleContext(BracketContext.class,0);
		}
		public IFStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).enterIFStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).exitIFStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParseRulesVisitor ) return ((ParseRulesVisitor<? extends T>)visitor).visitIFStat(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WHILEStatContext extends StatContext {
		public TerminalNode WHILE() { return getToken(ParseRules.WHILE, 0); }
		public TerminalNode LPREN() { return getToken(ParseRules.LPREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPREN() { return getToken(ParseRules.RPREN, 0); }
		public BracketContext bracket() {
			return getRuleContext(BracketContext.class,0);
		}
		public WHILEStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).enterWHILEStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).exitWHILEStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParseRulesVisitor ) return ((ParseRulesVisitor<? extends T>)visitor).visitWHILEStat(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FUNCcallVoidStatContext extends StatContext {
		public TerminalNode ID() { return getToken(ParseRules.ID, 0); }
		public TerminalNode LPREN() { return getToken(ParseRules.LPREN, 0); }
		public TerminalNode RPREN() { return getToken(ParseRules.RPREN, 0); }
		public FUNCcallVoidStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).enterFUNCcallVoidStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).exitFUNCcallVoidStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParseRulesVisitor ) return ((ParseRulesVisitor<? extends T>)visitor).visitFUNCcallVoidStat(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrintStatContext extends StatContext {
		public List<TerminalNode> PRINT() { return getTokens(ParseRules.PRINT); }
		public TerminalNode PRINT(int i) {
			return getToken(ParseRules.PRINT, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PrintStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).enterPrintStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).exitPrintStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParseRulesVisitor ) return ((ParseRulesVisitor<? extends T>)visitor).visitPrintStat(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FUNCcallStatContext extends StatContext {
		public TerminalNode ID() { return getToken(ParseRules.ID, 0); }
		public TerminalNode LPREN() { return getToken(ParseRules.LPREN, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode RPREN() { return getToken(ParseRules.RPREN, 0); }
		public FUNCcallStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).enterFUNCcallStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).exitFUNCcallStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParseRulesVisitor ) return ((ParseRulesVisitor<? extends T>)visitor).visitFUNCcallStat(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IDStatContext extends StatContext {
		public List<TerminalNode> ID() { return getTokens(ParseRules.ID); }
		public TerminalNode ID(int i) {
			return getToken(ParseRules.ID, i);
		}
		public TerminalNode LARROW() { return getToken(ParseRules.LARROW, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RARROW() { return getToken(ParseRules.RARROW, 0); }
		public IDStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).enterIDStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).exitIDStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParseRulesVisitor ) return ((ParseRulesVisitor<? extends T>)visitor).visitIDStat(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FUNCVOIDStatContext extends StatContext {
		public TerminalNode FUNCTION() { return getToken(ParseRules.FUNCTION, 0); }
		public TerminalNode ID() { return getToken(ParseRules.ID, 0); }
		public TerminalNode LPREN() { return getToken(ParseRules.LPREN, 0); }
		public TerminalNode RPREN() { return getToken(ParseRules.RPREN, 0); }
		public BracketContext bracket() {
			return getRuleContext(BracketContext.class,0);
		}
		public FUNCVOIDStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).enterFUNCVOIDStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).exitFUNCVOIDStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParseRulesVisitor ) return ((ParseRulesVisitor<? extends T>)visitor).visitFUNCVOIDStat(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FUNCStatContext extends StatContext {
		public TerminalNode FUNCTION() { return getToken(ParseRules.FUNCTION, 0); }
		public TerminalNode ID() { return getToken(ParseRules.ID, 0); }
		public TerminalNode LPREN() { return getToken(ParseRules.LPREN, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode RPREN() { return getToken(ParseRules.RPREN, 0); }
		public BracketContext bracket() {
			return getRuleContext(BracketContext.class,0);
		}
		public FUNCStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).enterFUNCStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).exitFUNCStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParseRulesVisitor ) return ((ParseRulesVisitor<? extends T>)visitor).visitFUNCStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		try {
			setState(64);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new PrintStatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(20);
				match(PRINT);
				setState(21);
				expr(0);
				setState(22);
				match(PRINT);
				}
				break;
			case 2:
				_localctx = new IDStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(24);
				match(ID);
				setState(25);
				match(LARROW);
				setState(26);
				expr(0);
				setState(27);
				match(RARROW);
				setState(28);
				match(ID);
				}
				break;
			case 3:
				_localctx = new IFStatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(30);
				match(IF);
				setState(31);
				match(LPREN);
				setState(32);
				expr(0);
				setState(33);
				match(RPREN);
				setState(34);
				bracket();
				}
				break;
			case 4:
				_localctx = new WHILEStatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(36);
				match(WHILE);
				setState(37);
				match(LPREN);
				setState(38);
				expr(0);
				setState(39);
				match(RPREN);
				setState(40);
				bracket();
				}
				break;
			case 5:
				_localctx = new FUNCStatContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(42);
				match(FUNCTION);
				setState(43);
				match(ID);
				setState(44);
				match(LPREN);
				setState(45);
				arguments();
				setState(46);
				match(RPREN);
				setState(47);
				bracket();
				}
				break;
			case 6:
				_localctx = new FUNCVOIDStatContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(49);
				match(FUNCTION);
				setState(50);
				match(ID);
				setState(51);
				match(LPREN);
				setState(52);
				match(RPREN);
				setState(53);
				bracket();
				}
				break;
			case 7:
				_localctx = new FUNCcallVoidStatContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(54);
				match(ID);
				setState(55);
				match(LPREN);
				setState(56);
				match(RPREN);
				}
				break;
			case 8:
				_localctx = new FUNCcallStatContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(57);
				match(ID);
				setState(58);
				match(LPREN);
				setState(59);
				arguments();
				setState(60);
				match(RPREN);
				}
				break;
			case 9:
				_localctx = new ReturnStatContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(62);
				match(RETURN);
				setState(63);
				expr(0);
				}
				break;
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
	public static class ArgumentsContext extends ParserRuleContext {
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
	 
		public ArgumentsContext() { }
		public void copyFrom(ArgumentsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArgArgContext extends ArgumentsContext {
		public TerminalNode ID() { return getToken(ParseRules.ID, 0); }
		public ArgumentsRepeatContext argumentsRepeat() {
			return getRuleContext(ArgumentsRepeatContext.class,0);
		}
		public ArgArgContext(ArgumentsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).enterArgArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).exitArgArg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParseRulesVisitor ) return ((ParseRulesVisitor<? extends T>)visitor).visitArgArg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_arguments);
		try {
			_localctx = new ArgArgContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(ID);
			setState(67);
			argumentsRepeat();
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
	public static class ArgumentsRepeatContext extends ParserRuleContext {
		public ArgumentsRepeatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentsRepeat; }
	 
		public ArgumentsRepeatContext() { }
		public void copyFrom(ArgumentsRepeatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArgRepeatContext extends ArgumentsRepeatContext {
		public TerminalNode COMMA() { return getToken(ParseRules.COMMA, 0); }
		public TerminalNode ID() { return getToken(ParseRules.ID, 0); }
		public ArgumentsRepeatContext argumentsRepeat() {
			return getRuleContext(ArgumentsRepeatContext.class,0);
		}
		public ArgRepeatContext(ArgumentsRepeatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).enterArgRepeat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).exitArgRepeat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParseRulesVisitor ) return ((ParseRulesVisitor<? extends T>)visitor).visitArgRepeat(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EmptyargumentContext extends ArgumentsRepeatContext {
		public EmptyargumentContext(ArgumentsRepeatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).enterEmptyargument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).exitEmptyargument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParseRulesVisitor ) return ((ParseRulesVisitor<? extends T>)visitor).visitEmptyargument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsRepeatContext argumentsRepeat() throws RecognitionException {
		ArgumentsRepeatContext _localctx = new ArgumentsRepeatContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_argumentsRepeat);
		try {
			setState(73);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMMA:
				_localctx = new ArgRepeatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				match(COMMA);
				setState(70);
				match(ID);
				setState(71);
				argumentsRepeat();
				}
				break;
			case RPREN:
				_localctx = new EmptyargumentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
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
	public static class BracketContext extends ParserRuleContext {
		public BracketContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bracket; }
	 
		public BracketContext() { }
		public void copyFrom(BracketContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LRBracketContext extends BracketContext {
		public TerminalNode LBRACK() { return getToken(ParseRules.LBRACK, 0); }
		public InnerContext inner() {
			return getRuleContext(InnerContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(ParseRules.RBRACK, 0); }
		public LRBracketContext(BracketContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).enterLRBracket(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).exitLRBracket(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParseRulesVisitor ) return ((ParseRulesVisitor<? extends T>)visitor).visitLRBracket(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BracketContext bracket() throws RecognitionException {
		BracketContext _localctx = new BracketContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_bracket);
		try {
			_localctx = new LRBracketContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(LBRACK);
			setState(76);
			inner();
			setState(77);
			match(RBRACK);
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
	public static class InnerContext extends ParserRuleContext {
		public InnerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inner; }
	 
		public InnerContext() { }
		public void copyFrom(InnerContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InnerInnerContext extends InnerContext {
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public InnerContext inner() {
			return getRuleContext(InnerContext.class,0);
		}
		public InnerInnerContext(InnerContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).enterInnerInner(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).exitInnerInner(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParseRulesVisitor ) return ((ParseRulesVisitor<? extends T>)visitor).visitInnerInner(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EmptyInnerContext extends InnerContext {
		public EmptyInnerContext(InnerContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).enterEmptyInner(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).exitEmptyInner(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParseRulesVisitor ) return ((ParseRulesVisitor<? extends T>)visitor).visitEmptyInner(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InnerContext inner() throws RecognitionException {
		InnerContext _localctx = new InnerContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_inner);
		try {
			setState(83);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
			case RETURN:
			case WHILE:
			case FUNCTION:
			case PRINT:
			case ID:
				_localctx = new InnerInnerContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(79);
				stat();
				setState(80);
				inner();
				}
				break;
			case RBRACK:
				_localctx = new EmptyInnerContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
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
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RevExprContext extends ExprContext {
		public List<TerminalNode> REV() { return getTokens(ParseRules.REV); }
		public TerminalNode REV(int i) {
			return getToken(ParseRules.REV, i);
		}
		public TerminalNode LARROW() { return getToken(ParseRules.LARROW, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RARROW() { return getToken(ParseRules.RARROW, 0); }
		public RevExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).enterRevExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).exitRevExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParseRulesVisitor ) return ((ParseRulesVisitor<? extends T>)visitor).visitRevExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IDExprContext extends ExprContext {
		public TerminalNode ID() { return getToken(ParseRules.ID, 0); }
		public IDExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).enterIDExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).exitIDExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParseRulesVisitor ) return ((ParseRulesVisitor<? extends T>)visitor).visitIDExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BoolLitExprContext extends ExprContext {
		public TerminalNode BOOL() { return getToken(ParseRules.BOOL, 0); }
		public BoolLitExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).enterBoolLitExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).exitBoolLitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParseRulesVisitor ) return ((ParseRulesVisitor<? extends T>)visitor).visitBoolLitExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConcatExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode CONCAT() { return getToken(ParseRules.CONCAT, 0); }
		public ConcatExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).enterConcatExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).exitConcatExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParseRulesVisitor ) return ((ParseRulesVisitor<? extends T>)visitor).visitConcatExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IDLRVoidExprContext extends ExprContext {
		public TerminalNode ID() { return getToken(ParseRules.ID, 0); }
		public TerminalNode LPREN() { return getToken(ParseRules.LPREN, 0); }
		public TerminalNode RPREN() { return getToken(ParseRules.RPREN, 0); }
		public IDLRVoidExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).enterIDLRVoidExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).exitIDLRVoidExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParseRulesVisitor ) return ((ParseRulesVisitor<? extends T>)visitor).visitIDLRVoidExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IDLRExprContext extends ExprContext {
		public TerminalNode ID() { return getToken(ParseRules.ID, 0); }
		public TerminalNode LPREN() { return getToken(ParseRules.LPREN, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode RPREN() { return getToken(ParseRules.RPREN, 0); }
		public IDLRExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).enterIDLRExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).exitIDLRExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParseRulesVisitor ) return ((ParseRulesVisitor<? extends T>)visitor).visitIDLRExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LitExprContext extends ExprContext {
		public TerminalNode LIT() { return getToken(ParseRules.LIT, 0); }
		public LitExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).enterLitExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).exitLitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParseRulesVisitor ) return ((ParseRulesVisitor<? extends T>)visitor).visitLitExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InputExprContext extends ExprContext {
		public TerminalNode INPUT() { return getToken(ParseRules.INPUT, 0); }
		public InputExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).enterInputExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).exitInputExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParseRulesVisitor ) return ((ParseRulesVisitor<? extends T>)visitor).visitInputExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotExprContext extends ExprContext {
		public TerminalNode NOT() { return getToken(ParseRules.NOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NotExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).enterNotExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).exitNotExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParseRulesVisitor ) return ((ParseRulesVisitor<? extends T>)visitor).visitNotExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenExprContext extends ExprContext {
		public TerminalNode LPREN() { return getToken(ParseRules.LPREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPREN() { return getToken(ParseRules.RPREN, 0); }
		public ParenExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).enterParenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).exitParenExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParseRulesVisitor ) return ((ParseRulesVisitor<? extends T>)visitor).visitParenExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OpExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OP() { return getToken(ParseRules.OP, 0); }
		public OpExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).enterOpExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).exitOpExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParseRulesVisitor ) return ((ParseRulesVisitor<? extends T>)visitor).visitOpExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				_localctx = new LitExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(86);
				match(LIT);
				}
				break;
			case 2:
				{
				_localctx = new InputExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(87);
				match(INPUT);
				}
				break;
			case 3:
				{
				_localctx = new RevExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(88);
				match(REV);
				setState(89);
				match(LARROW);
				setState(90);
				expr(0);
				setState(91);
				match(RARROW);
				setState(92);
				match(REV);
				}
				break;
			case 4:
				{
				_localctx = new IDExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(94);
				match(ID);
				}
				break;
			case 5:
				{
				_localctx = new BoolLitExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(95);
				match(BOOL);
				}
				break;
			case 6:
				{
				_localctx = new IDLRExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(96);
				match(ID);
				setState(97);
				match(LPREN);
				setState(98);
				arguments();
				setState(99);
				match(RPREN);
				}
				break;
			case 7:
				{
				_localctx = new IDLRVoidExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(101);
				match(ID);
				setState(102);
				match(LPREN);
				setState(103);
				match(RPREN);
				}
				break;
			case 8:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(104);
				match(LPREN);
				setState(105);
				expr(0);
				setState(106);
				match(RPREN);
				}
				break;
			case 9:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(108);
				match(NOT);
				setState(109);
				expr(2);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(120);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(118);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new ConcatExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(112);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(113);
						match(CONCAT);
						setState(114);
						expr(7);
						}
						break;
					case 2:
						{
						_localctx = new OpExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(115);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(116);
						match(OP);
						setState(117);
						expr(2);
						}
						break;
					}
					} 
				}
				setState(122);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 6:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0015|\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0003\u0000\u0013\b\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001A\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003J\b\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0003\u0005T\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006o\b\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005"+
		"\u0006w\b\u0006\n\u0006\f\u0006z\t\u0006\u0001\u0006\u0000\u0001\f\u0007"+
		"\u0000\u0002\u0004\u0006\b\n\f\u0000\u0000\u0089\u0000\u0012\u0001\u0000"+
		"\u0000\u0000\u0002@\u0001\u0000\u0000\u0000\u0004B\u0001\u0000\u0000\u0000"+
		"\u0006I\u0001\u0000\u0000\u0000\bK\u0001\u0000\u0000\u0000\nS\u0001\u0000"+
		"\u0000\u0000\fn\u0001\u0000\u0000\u0000\u000e\u000f\u0003\u0002\u0001"+
		"\u0000\u000f\u0010\u0003\u0000\u0000\u0000\u0010\u0013\u0001\u0000\u0000"+
		"\u0000\u0011\u0013\u0005\u0000\u0000\u0001\u0012\u000e\u0001\u0000\u0000"+
		"\u0000\u0012\u0011\u0001\u0000\u0000\u0000\u0013\u0001\u0001\u0000\u0000"+
		"\u0000\u0014\u0015\u0005\u0010\u0000\u0000\u0015\u0016\u0003\f\u0006\u0000"+
		"\u0016\u0017\u0005\u0010\u0000\u0000\u0017A\u0001\u0000\u0000\u0000\u0018"+
		"\u0019\u0005\u0014\u0000\u0000\u0019\u001a\u0005\u0007\u0000\u0000\u001a"+
		"\u001b\u0003\f\u0006\u0000\u001b\u001c\u0005\b\u0000\u0000\u001c\u001d"+
		"\u0005\u0014\u0000\u0000\u001dA\u0001\u0000\u0000\u0000\u001e\u001f\u0005"+
		"\u0001\u0000\u0000\u001f \u0005\t\u0000\u0000 !\u0003\f\u0006\u0000!\""+
		"\u0005\n\u0000\u0000\"#\u0003\b\u0004\u0000#A\u0001\u0000\u0000\u0000"+
		"$%\u0005\u0004\u0000\u0000%&\u0005\t\u0000\u0000&\'\u0003\f\u0006\u0000"+
		"\'(\u0005\n\u0000\u0000()\u0003\b\u0004\u0000)A\u0001\u0000\u0000\u0000"+
		"*+\u0005\u0005\u0000\u0000+,\u0005\u0014\u0000\u0000,-\u0005\t\u0000\u0000"+
		"-.\u0003\u0004\u0002\u0000./\u0005\n\u0000\u0000/0\u0003\b\u0004\u0000"+
		"0A\u0001\u0000\u0000\u000012\u0005\u0005\u0000\u000023\u0005\u0014\u0000"+
		"\u000034\u0005\t\u0000\u000045\u0005\n\u0000\u00005A\u0003\b\u0004\u0000"+
		"67\u0005\u0014\u0000\u000078\u0005\t\u0000\u00008A\u0005\n\u0000\u0000"+
		"9:\u0005\u0014\u0000\u0000:;\u0005\t\u0000\u0000;<\u0003\u0004\u0002\u0000"+
		"<=\u0005\n\u0000\u0000=A\u0001\u0000\u0000\u0000>?\u0005\u0002\u0000\u0000"+
		"?A\u0003\f\u0006\u0000@\u0014\u0001\u0000\u0000\u0000@\u0018\u0001\u0000"+
		"\u0000\u0000@\u001e\u0001\u0000\u0000\u0000@$\u0001\u0000\u0000\u0000"+
		"@*\u0001\u0000\u0000\u0000@1\u0001\u0000\u0000\u0000@6\u0001\u0000\u0000"+
		"\u0000@9\u0001\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000A\u0003\u0001"+
		"\u0000\u0000\u0000BC\u0005\u0014\u0000\u0000CD\u0003\u0006\u0003\u0000"+
		"D\u0005\u0001\u0000\u0000\u0000EF\u0005\u0006\u0000\u0000FG\u0005\u0014"+
		"\u0000\u0000GJ\u0003\u0006\u0003\u0000HJ\u0001\u0000\u0000\u0000IE\u0001"+
		"\u0000\u0000\u0000IH\u0001\u0000\u0000\u0000J\u0007\u0001\u0000\u0000"+
		"\u0000KL\u0005\u000b\u0000\u0000LM\u0003\n\u0005\u0000MN\u0005\f\u0000"+
		"\u0000N\t\u0001\u0000\u0000\u0000OP\u0003\u0002\u0001\u0000PQ\u0003\n"+
		"\u0005\u0000QT\u0001\u0000\u0000\u0000RT\u0001\u0000\u0000\u0000SO\u0001"+
		"\u0000\u0000\u0000SR\u0001\u0000\u0000\u0000T\u000b\u0001\u0000\u0000"+
		"\u0000UV\u0006\u0006\uffff\uffff\u0000Vo\u0005\u0013\u0000\u0000Wo\u0005"+
		"\u0011\u0000\u0000XY\u0005\u0012\u0000\u0000YZ\u0005\u0007\u0000\u0000"+
		"Z[\u0003\f\u0006\u0000[\\\u0005\b\u0000\u0000\\]\u0005\u0012\u0000\u0000"+
		"]o\u0001\u0000\u0000\u0000^o\u0005\u0014\u0000\u0000_o\u0005\u000f\u0000"+
		"\u0000`a\u0005\u0014\u0000\u0000ab\u0005\t\u0000\u0000bc\u0003\u0004\u0002"+
		"\u0000cd\u0005\n\u0000\u0000do\u0001\u0000\u0000\u0000ef\u0005\u0014\u0000"+
		"\u0000fg\u0005\t\u0000\u0000go\u0005\n\u0000\u0000hi\u0005\t\u0000\u0000"+
		"ij\u0003\f\u0006\u0000jk\u0005\n\u0000\u0000ko\u0001\u0000\u0000\u0000"+
		"lm\u0005\r\u0000\u0000mo\u0003\f\u0006\u0002nU\u0001\u0000\u0000\u0000"+
		"nW\u0001\u0000\u0000\u0000nX\u0001\u0000\u0000\u0000n^\u0001\u0000\u0000"+
		"\u0000n_\u0001\u0000\u0000\u0000n`\u0001\u0000\u0000\u0000ne\u0001\u0000"+
		"\u0000\u0000nh\u0001\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000ox\u0001"+
		"\u0000\u0000\u0000pq\n\u0006\u0000\u0000qr\u0005\u0003\u0000\u0000rw\u0003"+
		"\f\u0006\u0007st\n\u0001\u0000\u0000tu\u0005\u000e\u0000\u0000uw\u0003"+
		"\f\u0006\u0002vp\u0001\u0000\u0000\u0000vs\u0001\u0000\u0000\u0000wz\u0001"+
		"\u0000\u0000\u0000xv\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000"+
		"y\r\u0001\u0000\u0000\u0000zx\u0001\u0000\u0000\u0000\u0007\u0012@ISn"+
		"vx";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}