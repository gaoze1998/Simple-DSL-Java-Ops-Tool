package com.ze.gao.parser;

import com.ze.gao.parser.base.SimpleParserLexer;
import com.ze.gao.parser.base.SimpleParserParser;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import lombok.Getter;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class SimpleParser {
    private final StandardEvaluationContext context;
    private final SpelVisitor visitor;
    @Getter
    private String lastSpel;

    @Getter
    private static final Map<String, String> GROOVY_METHOD_MAP = new HashMap<>();

    public SimpleParser(Object object, Map<String, Method> methodMap) {
        StandardEvaluationContext c = new StandardEvaluationContext(object);

        try {
            c.registerFunction("executeGroovy",
                    SimpleParser.class.getMethod("executeGroovy", String.class, Object[].class));
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        if (methodMap != null) {
            for (Map.Entry<String, Method> nameMethodEntry : methodMap.entrySet()) {
                c.registerFunction(nameMethodEntry.getKey(), nameMethodEntry.getValue());
            }
        }

        this.context = c;
        this.visitor = new SpelVisitor(c);
    }

    public Object execute(String x) {
        SimpleParserLexer lexer = new SimpleParserLexer(CharStreams.fromString(x));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SimpleParserParser parser = new SimpleParserParser(tokens);
        SimpleParserParser.StatementContext tree = parser.statement();

        String spel = visitor.visit(tree);

        this.lastSpel = spel;

        return visitor.getParser().parseExpression(spel).getValue(context);
    }

    public void addGroovy(String name, String script) {
        GROOVY_METHOD_MAP.put(name, script);
    }

    public static Object executeGroovy(String name, Object ...args) {
        String script = GROOVY_METHOD_MAP.get(name);
        if (script == null) {
            throw new RuntimeException("groovy function [] not exist!".formatted(name));
        }

        Binding binding = new Binding();
        binding.setProperty("args", args);
        GroovyShell groovyShell = new GroovyShell(binding);

        return groovyShell.evaluate(script);
    }
}
