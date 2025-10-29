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
		YAY=1, OP=2, BOOL=3, PRINT=4, INPUT=5, REV=6, LIT=7, ID=8, IF=9, ELSE=10, 
		WHILE=11;
	public static final int
		RULE_prog = 0, RULE_stat = 1, RULE_expr = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "stat", "expr"
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
			null, "YAY", "OP", "BOOL", "PRINT", "INPUT", "REV", "LIT", "ID", "IF", 
			"ELSE", "WHILE"
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
			setState(10);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRINT:
			case ID:
			case IF:
			case WHILE:
				_localctx = new RegularProgContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(6);
				stat();
				setState(7);
				prog();
				}
				break;
			case EOF:
				_localctx = new EmptyProgContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(9);
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
	public static class IfElseStatContext extends StatContext {
		public TerminalNode IF() { return getToken(ParseRules.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> YAY() { return getTokens(ParseRules.YAY); }
		public TerminalNode YAY(int i) {
			return getToken(ParseRules.YAY, i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(ParseRules.ELSE, 0); }
		public IfElseStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).enterIfElseStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).exitIfElseStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParseRulesVisitor ) return ((ParseRulesVisitor<? extends T>)visitor).visitIfElseStat(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignStatContext extends StatContext {
		public TerminalNode ID() { return getToken(ParseRules.ID, 0); }
		public TerminalNode YAY() { return getToken(ParseRules.YAY, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).enterAssignStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).exitAssignStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParseRulesVisitor ) return ((ParseRulesVisitor<? extends T>)visitor).visitAssignStat(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrintStatContext extends StatContext {
		public TerminalNode PRINT() { return getToken(ParseRules.PRINT, 0); }
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
	public static class IfStatContext extends StatContext {
		public TerminalNode IF() { return getToken(ParseRules.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> YAY() { return getTokens(ParseRules.YAY); }
		public TerminalNode YAY(int i) {
			return getToken(ParseRules.YAY, i);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public IfStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).enterIfStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).exitIfStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParseRulesVisitor ) return ((ParseRulesVisitor<? extends T>)visitor).visitIfStat(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WhileStatContext extends StatContext {
		public TerminalNode WHILE() { return getToken(ParseRules.WHILE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> YAY() { return getTokens(ParseRules.YAY); }
		public TerminalNode YAY(int i) {
			return getToken(ParseRules.YAY, i);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public WhileStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).enterWhileStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).exitWhileStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParseRulesVisitor ) return ((ParseRulesVisitor<? extends T>)visitor).visitWhileStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		try {
			setState(39);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new PrintStatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(12);
				match(PRINT);
				setState(13);
				expr(0);
				}
				break;
			case 2:
				_localctx = new AssignStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(14);
				match(ID);
				setState(15);
				match(YAY);
				setState(16);
				expr(0);
				}
				break;
			case 3:
				_localctx = new IfStatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(17);
				match(IF);
				setState(18);
				expr(0);
				setState(19);
				match(YAY);
				setState(20);
				stat();
				setState(21);
				match(YAY);
				}
				break;
			case 4:
				_localctx = new IfElseStatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(23);
				match(IF);
				setState(24);
				expr(0);
				setState(25);
				match(YAY);
				setState(26);
				stat();
				setState(27);
				match(YAY);
				setState(28);
				match(ELSE);
				setState(29);
				match(YAY);
				setState(30);
				stat();
				setState(31);
				match(YAY);
				}
				break;
			case 5:
				_localctx = new WhileStatContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(33);
				match(WHILE);
				setState(34);
				expr(0);
				setState(35);
				match(YAY);
				setState(36);
				stat();
				setState(37);
				match(YAY);
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
	public static class InputContext extends ExprContext {
		public TerminalNode INPUT() { return getToken(ParseRules.INPUT, 0); }
		public InputContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).enterInput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).exitInput(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParseRulesVisitor ) return ((ParseRulesVisitor<? extends T>)visitor).visitInput(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReverseContext extends ExprContext {
		public TerminalNode REV() { return getToken(ParseRules.REV, 0); }
		public List<TerminalNode> YAY() { return getTokens(ParseRules.YAY); }
		public TerminalNode YAY(int i) {
			return getToken(ParseRules.YAY, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReverseContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).enterReverse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).exitReverse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParseRulesVisitor ) return ((ParseRulesVisitor<? extends T>)visitor).visitReverse(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BoolContext extends ExprContext {
		public TerminalNode BOOL() { return getToken(ParseRules.BOOL, 0); }
		public BoolContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).exitBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParseRulesVisitor ) return ((ParseRulesVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarContext extends ExprContext {
		public TerminalNode ID() { return getToken(ParseRules.ID, 0); }
		public VarContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).exitVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParseRulesVisitor ) return ((ParseRulesVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LitContext extends ExprContext {
		public TerminalNode LIT() { return getToken(ParseRules.LIT, 0); }
		public LitContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).enterLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).exitLit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParseRulesVisitor ) return ((ParseRulesVisitor<? extends T>)visitor).visitLit(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BinaryOpContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OP() { return getToken(ParseRules.OP, 0); }
		public BinaryOpContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).enterBinaryOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParseRulesListener ) ((ParseRulesListener)listener).exitBinaryOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParseRulesVisitor ) return ((ParseRulesVisitor<? extends T>)visitor).visitBinaryOp(this);
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
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				_localctx = new VarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(42);
				match(ID);
				}
				break;
			case LIT:
				{
				_localctx = new LitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(43);
				match(LIT);
				}
				break;
			case BOOL:
				{
				_localctx = new BoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(44);
				match(BOOL);
				}
				break;
			case INPUT:
				{
				_localctx = new InputContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(45);
				match(INPUT);
				}
				break;
			case REV:
				{
				_localctx = new ReverseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(46);
				match(REV);
				setState(47);
				match(YAY);
				setState(48);
				expr(0);
				setState(49);
				match(YAY);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(58);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BinaryOpContext(new ExprContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(53);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(54);
					match(OP);
					setState(55);
					expr(2);
					}
					} 
				}
				setState(60);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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
		case 2:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u000b>\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0003"+
		"\u0000\u000b\b\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001(\b"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u00024\b"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u00029\b\u0002\n\u0002"+
		"\f\u0002<\t\u0002\u0001\u0002\u0000\u0001\u0004\u0003\u0000\u0002\u0004"+
		"\u0000\u0000D\u0000\n\u0001\u0000\u0000\u0000\u0002\'\u0001\u0000\u0000"+
		"\u0000\u00043\u0001\u0000\u0000\u0000\u0006\u0007\u0003\u0002\u0001\u0000"+
		"\u0007\b\u0003\u0000\u0000\u0000\b\u000b\u0001\u0000\u0000\u0000\t\u000b"+
		"\u0005\u0000\u0000\u0001\n\u0006\u0001\u0000\u0000\u0000\n\t\u0001\u0000"+
		"\u0000\u0000\u000b\u0001\u0001\u0000\u0000\u0000\f\r\u0005\u0004\u0000"+
		"\u0000\r(\u0003\u0004\u0002\u0000\u000e\u000f\u0005\b\u0000\u0000\u000f"+
		"\u0010\u0005\u0001\u0000\u0000\u0010(\u0003\u0004\u0002\u0000\u0011\u0012"+
		"\u0005\t\u0000\u0000\u0012\u0013\u0003\u0004\u0002\u0000\u0013\u0014\u0005"+
		"\u0001\u0000\u0000\u0014\u0015\u0003\u0002\u0001\u0000\u0015\u0016\u0005"+
		"\u0001\u0000\u0000\u0016(\u0001\u0000\u0000\u0000\u0017\u0018\u0005\t"+
		"\u0000\u0000\u0018\u0019\u0003\u0004\u0002\u0000\u0019\u001a\u0005\u0001"+
		"\u0000\u0000\u001a\u001b\u0003\u0002\u0001\u0000\u001b\u001c\u0005\u0001"+
		"\u0000\u0000\u001c\u001d\u0005\n\u0000\u0000\u001d\u001e\u0005\u0001\u0000"+
		"\u0000\u001e\u001f\u0003\u0002\u0001\u0000\u001f \u0005\u0001\u0000\u0000"+
		" (\u0001\u0000\u0000\u0000!\"\u0005\u000b\u0000\u0000\"#\u0003\u0004\u0002"+
		"\u0000#$\u0005\u0001\u0000\u0000$%\u0003\u0002\u0001\u0000%&\u0005\u0001"+
		"\u0000\u0000&(\u0001\u0000\u0000\u0000\'\f\u0001\u0000\u0000\u0000\'\u000e"+
		"\u0001\u0000\u0000\u0000\'\u0011\u0001\u0000\u0000\u0000\'\u0017\u0001"+
		"\u0000\u0000\u0000\'!\u0001\u0000\u0000\u0000(\u0003\u0001\u0000\u0000"+
		"\u0000)*\u0006\u0002\uffff\uffff\u0000*4\u0005\b\u0000\u0000+4\u0005\u0007"+
		"\u0000\u0000,4\u0005\u0003\u0000\u0000-4\u0005\u0005\u0000\u0000./\u0005"+
		"\u0006\u0000\u0000/0\u0005\u0001\u0000\u000001\u0003\u0004\u0002\u0000"+
		"12\u0005\u0001\u0000\u000024\u0001\u0000\u0000\u00003)\u0001\u0000\u0000"+
		"\u00003+\u0001\u0000\u0000\u00003,\u0001\u0000\u0000\u00003-\u0001\u0000"+
		"\u0000\u00003.\u0001\u0000\u0000\u00004:\u0001\u0000\u0000\u000056\n\u0001"+
		"\u0000\u000067\u0005\u0002\u0000\u000079\u0003\u0004\u0002\u000285\u0001"+
		"\u0000\u0000\u00009<\u0001\u0000\u0000\u0000:8\u0001\u0000\u0000\u0000"+
		":;\u0001\u0000\u0000\u0000;\u0005\u0001\u0000\u0000\u0000<:\u0001\u0000"+
		"\u0000\u0000\u0004\n\'3:";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}