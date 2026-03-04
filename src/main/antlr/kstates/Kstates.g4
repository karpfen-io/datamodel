grammar Kstates;

kstates_file
    : statemachine EOF
    ;

statemachine
    : STATEMACHINE ATTACHED TO STRING LBRACE states_block transitions_block macros_block? RBRACE
    ;

states_block
    : STATES LBRACE state_definition* RBRACE
    ;

state_definition
    : INITIAL? STATE STRING LBRACE entry_block? do_block? state_definition* RBRACE
    ;

entry_block
    : ENTRY action_block
    ;

do_block
    : DO action_block
    ;

action_block
    : LBRACE action_rule* RBRACE
    ;

action_rule
    : action_operation LPAREN STRING COMMA action_right_side RPAREN
    ;

action_operation
    : SET
    | APPEND
    | EVENT
    ;

action_right_side
    : macro_call
    | eval_statement
    | STRING
    ;

macro_call
    : MACRO LPAREN STRING (COMMA STRING)* RPAREN
    ;

eval_statement
    : EVAL LBRACE eval_code_block RBRACE
    ;

transitions_block
    : TRANSITIONS LBRACE transition_definition* RBRACE
    ;

transition_definition
    : TRANSITION STRING ARROW STRING not_looping? LBRACE condition_block? RBRACE
    ;

not_looping
    : NOT LOOPING
    ;

condition_block
    : CONDITION LBRACE transition_condition RBRACE
    ;

transition_condition
    : eval_statement
    | event_condition
    | value_condition
    ;

event_condition
    : EVENT LPAREN STRING COMMA STRING RPAREN
    ;

value_condition
    : VALUE LPAREN STRING RPAREN
    ;

macros_block
    : MACROS LBRACE macro_definition* RBRACE
    ;

macro_definition
    : MACRO STRING LBRACE takes_directive* returns_directive definition_block RBRACE
    ;

takes_directive
    : TAKES LPAREN STRING COMMA type_expression RPAREN
    ;

returns_directive
    : RETURNS LPAREN return_expression RPAREN
    ;

return_expression
    : type_expression
    | reference_expression
    ;

type_expression
    : STRING
    | typed_call_expression
    ;

typed_call_expression
    : IDENT LPAREN STRING RPAREN
    ;

reference_expression
    : REFERENCE LPAREN STRING RPAREN
    ;

definition_block
    : DEFINITION LBRACE eval_statement RBRACE
    ;

eval_code_block
    : code_content*
    ;

code_content
    : LBRACE eval_code_block RBRACE
    | ~(LBRACE | RBRACE)
    ;

STATEMACHINE : 'STATEMACHINE' ;
ATTACHED     : 'ATTACHED' ;
TO           : 'TO' ;
STATES       : 'STATES' ;
STATE        : 'STATE' ;
INITIAL      : 'INITIAL' ;
ENTRY        : 'ENTRY' ;
DO           : 'DO' ;
SET          : 'SET' ;
APPEND       : 'APPEND' ;
EVENT        : 'EVENT' ;
MACRO        : 'MACRO' ;
EVAL         : 'EVAL' ;
TRANSITIONS  : 'TRANSITIONS' ;
TRANSITION   : 'TRANSITION' ;
NOT          : 'NOT' ;
LOOPING      : 'LOOPING' ;
CONDITION    : 'CONDITION' ;
VALUE        : 'VALUE' ;
MACROS       : 'MACROS' ;
TAKES        : 'TAKES' ;
RETURNS      : 'RETURNS' ;
DEFINITION   : 'DEFINITION' ;
REFERENCE    : 'reference' ;

ARROW        : '->' ;
LBRACE       : '{' ;
RBRACE       : '}' ;
LPAREN       : '(' ;
RPAREN       : ')' ;
COMMA        : ',' ;

STRING       : '"' ( '\\' . | ~["\\\r\n] )* '"' ;
SSTRING      : '\'' ( '\\' . | ~['\\\r\n] )* '\'' ;
IDENT        : [a-zA-Z_][a-zA-Z0-9_]* ;
NUMBER       : [0-9]+ ('.' [0-9]+)? ;

WS           : [ \t\r\n]+ -> channel(HIDDEN) ;
LINE_COMMENT : '//' ~[\r\n]* -> channel(HIDDEN) ;
SYMBOL       : . ;

