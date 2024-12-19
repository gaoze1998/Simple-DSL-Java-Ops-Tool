// Generated from /Users/ze.gao/Documents/work/Simple-DSL-Java-Ops-Tool/src/main/java/com/ze/gao/parser/base/SimpleParser.g4 by ANTLR 4.13.2
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
		T__17=18, T__18=19, LETTER=20, DIGIT=21, WS=22, SL_COMMENT=23, ML_COMMENT=24;
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
			"T__17", "T__18", "LETTER", "DIGIT", "WS", "SL_COMMENT", "ML_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'.'", "'['", "']'", "'*'", "':'", "'and'", "'or'", "'!='", 
			"'>'", "'<'", "'>='", "'<='", "'('", "')'", "','", "'''", "'\\''", "'\\\\'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "LETTER", "DIGIT", "WS", 
			"SL_COMMENT", "ML_COMMENT"
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
		"\u0004\u0000\u0018\u0083\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0004\u0015"+
		"e\b\u0015\u000b\u0015\f\u0015f\u0001\u0015\u0001\u0015\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0005\u0016o\b\u0016\n\u0016\f\u0016r\t"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0005\u0017z\b\u0017\n\u0017\f\u0017}\t\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001{\u0000\u0018\u0001\u0001"+
		"\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f"+
		"\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f"+
		"\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u0018"+
		"\u0001\u0000\u0004\u0003\u0000AZ__az\u0001\u000009\u0003\u0000\t\n\r\r"+
		"  \u0002\u0000\n\n\r\r\u0085\u0000\u0001\u0001\u0000\u0000\u0000\u0000"+
		"\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000"+
		"\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b"+
		"\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001"+
		"\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001"+
		"\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001"+
		"\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001"+
		"\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001"+
		"\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000"+
		"\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000"+
		"\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-"+
		"\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00011\u0001\u0000"+
		"\u0000\u0000\u00033\u0001\u0000\u0000\u0000\u00055\u0001\u0000\u0000\u0000"+
		"\u00077\u0001\u0000\u0000\u0000\t9\u0001\u0000\u0000\u0000\u000b;\u0001"+
		"\u0000\u0000\u0000\r=\u0001\u0000\u0000\u0000\u000fA\u0001\u0000\u0000"+
		"\u0000\u0011D\u0001\u0000\u0000\u0000\u0013G\u0001\u0000\u0000\u0000\u0015"+
		"I\u0001\u0000\u0000\u0000\u0017K\u0001\u0000\u0000\u0000\u0019N\u0001"+
		"\u0000\u0000\u0000\u001bQ\u0001\u0000\u0000\u0000\u001dS\u0001\u0000\u0000"+
		"\u0000\u001fU\u0001\u0000\u0000\u0000!W\u0001\u0000\u0000\u0000#Y\u0001"+
		"\u0000\u0000\u0000%\\\u0001\u0000\u0000\u0000\'_\u0001\u0000\u0000\u0000"+
		")a\u0001\u0000\u0000\u0000+d\u0001\u0000\u0000\u0000-j\u0001\u0000\u0000"+
		"\u0000/u\u0001\u0000\u0000\u000012\u0005=\u0000\u00002\u0002\u0001\u0000"+
		"\u0000\u000034\u0005.\u0000\u00004\u0004\u0001\u0000\u0000\u000056\u0005"+
		"[\u0000\u00006\u0006\u0001\u0000\u0000\u000078\u0005]\u0000\u00008\b\u0001"+
		"\u0000\u0000\u00009:\u0005*\u0000\u0000:\n\u0001\u0000\u0000\u0000;<\u0005"+
		":\u0000\u0000<\f\u0001\u0000\u0000\u0000=>\u0005a\u0000\u0000>?\u0005"+
		"n\u0000\u0000?@\u0005d\u0000\u0000@\u000e\u0001\u0000\u0000\u0000AB\u0005"+
		"o\u0000\u0000BC\u0005r\u0000\u0000C\u0010\u0001\u0000\u0000\u0000DE\u0005"+
		"!\u0000\u0000EF\u0005=\u0000\u0000F\u0012\u0001\u0000\u0000\u0000GH\u0005"+
		">\u0000\u0000H\u0014\u0001\u0000\u0000\u0000IJ\u0005<\u0000\u0000J\u0016"+
		"\u0001\u0000\u0000\u0000KL\u0005>\u0000\u0000LM\u0005=\u0000\u0000M\u0018"+
		"\u0001\u0000\u0000\u0000NO\u0005<\u0000\u0000OP\u0005=\u0000\u0000P\u001a"+
		"\u0001\u0000\u0000\u0000QR\u0005(\u0000\u0000R\u001c\u0001\u0000\u0000"+
		"\u0000ST\u0005)\u0000\u0000T\u001e\u0001\u0000\u0000\u0000UV\u0005,\u0000"+
		"\u0000V \u0001\u0000\u0000\u0000WX\u0005\'\u0000\u0000X\"\u0001\u0000"+
		"\u0000\u0000YZ\u0005\\\u0000\u0000Z[\u0005\'\u0000\u0000[$\u0001\u0000"+
		"\u0000\u0000\\]\u0005\\\u0000\u0000]^\u0005\\\u0000\u0000^&\u0001\u0000"+
		"\u0000\u0000_`\u0007\u0000\u0000\u0000`(\u0001\u0000\u0000\u0000ab\u0007"+
		"\u0001\u0000\u0000b*\u0001\u0000\u0000\u0000ce\u0007\u0002\u0000\u0000"+
		"dc\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000"+
		"\u0000fg\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000hi\u0006\u0015"+
		"\u0000\u0000i,\u0001\u0000\u0000\u0000jk\u0005/\u0000\u0000kl\u0005/\u0000"+
		"\u0000lp\u0001\u0000\u0000\u0000mo\b\u0003\u0000\u0000nm\u0001\u0000\u0000"+
		"\u0000or\u0001\u0000\u0000\u0000pn\u0001\u0000\u0000\u0000pq\u0001\u0000"+
		"\u0000\u0000qs\u0001\u0000\u0000\u0000rp\u0001\u0000\u0000\u0000st\u0006"+
		"\u0016\u0000\u0000t.\u0001\u0000\u0000\u0000uv\u0005/\u0000\u0000vw\u0005"+
		"*\u0000\u0000w{\u0001\u0000\u0000\u0000xz\t\u0000\u0000\u0000yx\u0001"+
		"\u0000\u0000\u0000z}\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000"+
		"{y\u0001\u0000\u0000\u0000|~\u0001\u0000\u0000\u0000}{\u0001\u0000\u0000"+
		"\u0000~\u007f\u0005*\u0000\u0000\u007f\u0080\u0005/\u0000\u0000\u0080"+
		"\u0081\u0001\u0000\u0000\u0000\u0081\u0082\u0006\u0017\u0000\u0000\u0082"+
		"0\u0001\u0000\u0000\u0000\u0004\u0000fp{\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}