# Simple Java Ops DSL

[中文文档](README-ZH.md)

## Project Highlights
- **DSL to SpEL Conversion**: Convert custom DSL expressions to Spring Expression Language (SpEL).
- **Support 1 DSL to N SpEL**: Convert one DSL expression to multiple SpEL expressions.
- **Dynamic Method Invocation**: Support for invoking Java methods and Groovy scripts dynamically.

## Features
- **Logical Expression Parsing**: Parse and evaluate logical expressions with custom conditions.
- **Function Calls**: Support for function calls within expressions.
- **Literal Handling**: Handle string and number literals within expressions.
- **Dynamic Groovy Script Execution**: Execute Groovy scripts dynamically within expressions.

## Quick Start
1. **Clone the repository**:
    ```sh
    git clone https://github.com/yourusername/your-repo-name.git
    cd your-repo-name
    ```

2. **Build the project using Maven**:
    ```sh
    mvn clean install
    ```

3. **Run the application**:
    ```sh
    mvn exec:java -Dexec.mainClass="com.ze.gao.App"
    ```

4. **Example Usage**:
    - Modify the `input` string in `App.java` to test different DSL expressions.
    - Run the application to see the converted SpEL and the effect on the `Contract` object.

## Syntax Description
```g4
grammar SimpleParser;

// Top-level grammar rules
statement: assignment | expression ;

// Assignment statement
assignment: leftExpression '=' rightExpression ;

// Left-hand side expression (can only be a path expression)
leftExpression: pathExpression ;

// Right-hand side expression (supports all expression types)
rightExpression: expression ;

// Expression
expression: pathExpression
          | literal
          | functionCall ;

// Path expression
pathExpression: identifier ( '.' pathComponent )* ;
pathComponent: identifier | arrayAccess ;

// Array access and filtering
arrayAccess: identifier '[' filterExpression ']' ;
filterExpression: simpleFilter
                | numberFilter
                | wildcardFilter
                | functionCall
                | logicalExpression ;

numberFilter: numberLiteral ;
wildcardFilter: '*' ;

// Simple filter
simpleFilter: identifier ':' literal ;

// Logical expression
logicalExpression: condition ( logicalOperator condition )* ;
condition: identifier comparisonOperator ( literal | expression ) ;
logicalOperator: 'and' | 'or' ;
comparisonOperator: '=' | '!=' | '>' | '<' | '>=' | '<=' ;

// Function call
functionCall: identifier '(' functionArgs ')' ;
functionArgs: functionArg ( ',' functionArg )* ;
functionArg: literal | pathExpression ;

// Basic elements
identifier: LETTER ( LETTER | DIGIT )* ;
LETTER: [A-Za-z_] ;
DIGIT: [0-9] ;

// Literal
literal: stringLiteral | numberLiteral ;
stringLiteral: '\'' (~'\'' | '\\\'' | '\\\\')* '\'' ; // Supports escape characters
numberLiteral: DIGIT+ ( '.' DIGIT+ )? ;

// Ignore whitespace and comments
WS: [ \t\r\n]+ -> skip ;
SL_COMMENT: '//' ~[\r\n]* -> skip ;
ML_COMMENT: '/*' .*? '*/' -> skip ;
```

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.