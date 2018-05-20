grammar SqlSplit;

sql_file
    : sql_clauses* EOF
    ;

sql_clauses
    : SEMI* sql_clause (SEMI+ sql_clause)* SEMI*
    ;

sql_clause
	: (STRING | CHARS)+
	;

SEMI
	: ';'
	;

CHARS
	: ~';'
	;

STRING
 	: '"' (ESC | .)*? '"'
 	| '\'' (ESC | .)*? '\''
 	| '`' .*? '`'
 	;
COMMENT
	: '/*' .*? '*/' -> skip
	;

LINE_COMMENT
	: '--' .*? '\r'? '\n' -> skip
	;

WS : [ \t\r\n]+ -> skip;

fragment
ESC
	: '\\' [btnr"'\\]
	;