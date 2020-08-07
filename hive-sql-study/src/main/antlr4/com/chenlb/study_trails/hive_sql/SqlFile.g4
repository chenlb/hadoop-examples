grammar SqlFile;

sqlFile
    : sqlClauses* EOF
    ;

sqlClauses
    : SEMI* sqlClause (SEMI+ sqlClause)* SEMI*
    ;

sqlClause
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
 	| '`' (~'`' | '``')* '`'
 	;
COMMENT
	: '/*' .*? '*/' -> skip
	;

LINE_COMMENT
	: '--' .*? '\r'? '\n' -> skip
	;

fragment
ESC
	: '\\' [btnr"\\]
	;