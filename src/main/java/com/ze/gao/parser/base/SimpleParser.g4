grammar SimpleParser;

// 顶层语法规则
statement: assignment | expression ;

// 赋值语句
assignment: leftExpression '=' rightExpression ;

// 左值表达式（只能是路径表达式）
leftExpression: pathExpression ;

// 右值表达式（支持所有表达式类型）
rightExpression: expression ;

// 表达式
expression: pathExpression
          | literal
          | functionCall ;

// 路径表达式
pathExpression: identifier ( '.' pathComponent )* ;
pathComponent: identifier | arrayAccess ;

// 数组访问与过滤
arrayAccess: identifier '[' filterExpression ']' ;
filterExpression: simpleFilter
                | numberFilter
                | wildcardFilter
                | functionCall
                | logicalExpression ;

numberFilter: numberLiteral ;
wildcardFilter: '*' ;

// 简单过滤器
simpleFilter: identifier ':' literal ;

// 逻辑表达式
logicalExpression: condition ( logicalOperator condition )* ;
condition: identifier comparisonOperator ( literal | expression ) ;
logicalOperator: 'and' | 'or' ;
comparisonOperator: '=' | '!=' | '>' | '<' | '>=' | '<=' ;

// 函数调用
functionCall: identifier '(' functionArgs ')' ;
functionArgs: functionArg ( ',' functionArg )* ;
functionArg: literal | pathExpression ;

// 基础元素
identifier: LETTER ( LETTER | DIGIT )* ;
LETTER: [A-Za-z_] ;
DIGIT: [0-9] ;

// 字面量
literal: stringLiteral | numberLiteral ;
stringLiteral: '\'' (~'\'' | '\\\'' | '\\\\')* '\'' ; // 支持转义字符
numberLiteral: DIGIT+ ( '.' DIGIT+ )? ;

// 忽略空白字符和注释
WS: [ \t\r\n]+ -> skip ;
SL_COMMENT: '//' ~[\r\n]* -> skip ;
ML_COMMENT: '/*' .*? '*/' -> skip ;
