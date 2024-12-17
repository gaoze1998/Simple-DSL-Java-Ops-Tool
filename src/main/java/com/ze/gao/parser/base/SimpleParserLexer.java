// Generated from /Users/ze.gao/Documents/work/general-data-ops-tool/src/main/java/com/ze/gao/parser/base/SimpleParser.g4 by ANTLR 4.13.2
package com.ze.gao.parser.base;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class SimpleParserLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, LETTER=19, DIGIT=20, WS=21, SL_COMMENT=22, ML_COMMENT=23;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "LETTER", "DIGIT", "WS", "SL_COMMENT", "ML_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'.'", "'['", "']'", "':'", "'and'", "'or'", "'!='", "'>'", 
			"'<'", "'>='", "'<='", "'('", "')'", "','", "'''", "'\\''", "'\\\\'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "LETTER", "DIGIT", "WS", "SL_COMMENT", 
			"ML_COMMENT"
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


	public SimpleParserLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SimpleParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0017\u007f\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0014\u0004\u0014a\b\u0014\u000b\u0014\f\u0014b\u0001\u0014\u0001"+
		"\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015k\b"+
		"\u0015\n\u0015\f\u0015n\t\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0005\u0016v\b\u0016\n\u0016\f\u0016y\t"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"w\u0000\u0017\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005"+
		"\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019"+
		"\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015"+
		"+\u0016-\u0017\u0001\u0000\u0004\u0003\u0000AZ__az\u0001\u000009\u0003"+
		"\u0000\t\n\r\r  \u0002\u0000\n\n\r\r\u0081\u0000\u0001\u0001\u0000\u0000"+
		"\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000"+
		"\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000"+
		"\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000"+
		"\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000"+
		"\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000"+
		"\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000"+
		"\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000"+
		"\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001"+
		"\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000"+
		"\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000"+
		"\u0000-\u0001\u0000\u0000\u0000\u0001/\u0001\u0000\u0000\u0000\u00031"+
		"\u0001\u0000\u0000\u0000\u00053\u0001\u0000\u0000\u0000\u00075\u0001\u0000"+
		"\u0000\u0000\t7\u0001\u0000\u0000\u0000\u000b9\u0001\u0000\u0000\u0000"+
		"\r=\u0001\u0000\u0000\u0000\u000f@\u0001\u0000\u0000\u0000\u0011C\u0001"+
		"\u0000\u0000\u0000\u0013E\u0001\u0000\u0000\u0000\u0015G\u0001\u0000\u0000"+
		"\u0000\u0017J\u0001\u0000\u0000\u0000\u0019M\u0001\u0000\u0000\u0000\u001b"+
		"O\u0001\u0000\u0000\u0000\u001dQ\u0001\u0000\u0000\u0000\u001fS\u0001"+
		"\u0000\u0000\u0000!U\u0001\u0000\u0000\u0000#X\u0001\u0000\u0000\u0000"+
		"%[\u0001\u0000\u0000\u0000\']\u0001\u0000\u0000\u0000)`\u0001\u0000\u0000"+
		"\u0000+f\u0001\u0000\u0000\u0000-q\u0001\u0000\u0000\u0000/0\u0005=\u0000"+
		"\u00000\u0002\u0001\u0000\u0000\u000012\u0005.\u0000\u00002\u0004\u0001"+
		"\u0000\u0000\u000034\u0005[\u0000\u00004\u0006\u0001\u0000\u0000\u0000"+
		"56\u0005]\u0000\u00006\b\u0001\u0000\u0000\u000078\u0005:\u0000\u0000"+
		"8\n\u0001\u0000\u0000\u00009:\u0005a\u0000\u0000:;\u0005n\u0000\u0000"+
		";<\u0005d\u0000\u0000<\f\u0001\u0000\u0000\u0000=>\u0005o\u0000\u0000"+
		">?\u0005r\u0000\u0000?\u000e\u0001\u0000\u0000\u0000@A\u0005!\u0000\u0000"+
		"AB\u0005=\u0000\u0000B\u0010\u0001\u0000\u0000\u0000CD\u0005>\u0000\u0000"+
		"D\u0012\u0001\u0000\u0000\u0000EF\u0005<\u0000\u0000F\u0014\u0001\u0000"+
		"\u0000\u0000GH\u0005>\u0000\u0000HI\u0005=\u0000\u0000I\u0016\u0001\u0000"+
		"\u0000\u0000JK\u0005<\u0000\u0000KL\u0005=\u0000\u0000L\u0018\u0001\u0000"+
		"\u0000\u0000MN\u0005(\u0000\u0000N\u001a\u0001\u0000\u0000\u0000OP\u0005"+
		")\u0000\u0000P\u001c\u0001\u0000\u0000\u0000QR\u0005,\u0000\u0000R\u001e"+
		"\u0001\u0000\u0000\u0000ST\u0005\'\u0000\u0000T \u0001\u0000\u0000\u0000"+
		"UV\u0005\\\u0000\u0000VW\u0005\'\u0000\u0000W\"\u0001\u0000\u0000\u0000"+
		"XY\u0005\\\u0000\u0000YZ\u0005\\\u0000\u0000Z$\u0001\u0000\u0000\u0000"+
		"[\\\u0007\u0000\u0000\u0000\\&\u0001\u0000\u0000\u0000]^\u0007\u0001\u0000"+
		"\u0000^(\u0001\u0000\u0000\u0000_a\u0007\u0002\u0000\u0000`_\u0001\u0000"+
		"\u0000\u0000ab\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000bc\u0001"+
		"\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000de\u0006\u0014\u0000\u0000"+
		"e*\u0001\u0000\u0000\u0000fg\u0005/\u0000\u0000gh\u0005/\u0000\u0000h"+
		"l\u0001\u0000\u0000\u0000ik\b\u0003\u0000\u0000ji\u0001\u0000\u0000\u0000"+
		"kn\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000"+
		"\u0000mo\u0001\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000op\u0006\u0015"+
		"\u0000\u0000p,\u0001\u0000\u0000\u0000qr\u0005/\u0000\u0000rs\u0005*\u0000"+
		"\u0000sw\u0001\u0000\u0000\u0000tv\t\u0000\u0000\u0000ut\u0001\u0000\u0000"+
		"\u0000vy\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000wu\u0001\u0000"+
		"\u0000\u0000xz\u0001\u0000\u0000\u0000yw\u0001\u0000\u0000\u0000z{\u0005"+
		"*\u0000\u0000{|\u0005/\u0000\u0000|}\u0001\u0000\u0000\u0000}~\u0006\u0016"+
		"\u0000\u0000~.\u0001\u0000\u0000\u0000\u0004\u0000blw\u0001\u0006\u0000"+
		"\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}