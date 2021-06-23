header {package decaf;}

options
{
  mangleLiteralPrefix = "TK_";
  language="Java";
}

class DecafParser extends Parser;
options
{
  importVocab=DecafScanner;
  k=3;
  buildAST=true;
}
tokens
{
 CALLOUT;
}

program: TK_class ID LCURLY (field_decl)* RCURLY EOF;

field_decl : type field_list SEMICOLON;
field_list : (ID|ID SLEFT int_literal SRIGHT)(COMMA (ID|ID SLEFT int_literal SRIGHT))*;
method_decl: method_type ID (BLEFT id_list BRIGHT)* block;
method_type: type | TK_void;
id_list: (type ID (COMMA type ID)*);
block: LCURLY(var_decl)* (statement)* RCURLY;
var_decl: (type ID)(COMMA type ID)* SEMICOLON;
type: (TK_int | TK_boolean);
statement: location assign_op expr SEMICOLON
   | method_call SEMICOLON
   | TK_if (expr) block (TK_else block)
   | TK_for ID EQUALS expr COMMA (expr block)
   | TK_return (expr)SEMICOLON
   | TK_break SEMICOLON
   | TK_continue SEMICOLON
   | block;
assign_op: EQUALS
   | PEQUALS
   | SEQUALS;
   
method_call: method_name BLEFT (expr (COMMA expr)*)? BRIGHT
   | TK_callout BLEFT STRING (COMMA callout_arg)* BRIGHT;
method_name: ID;
location: ID
   | ID SLEFT expr SRIGHT;
   
expr: and_expr (DOR and_expr)*;
and_expr: equal_expr (DAND equal_expr)*;
equal_expr: rel_expr ((EQUIV | NEQUAL) rel_expr)?;
rel_expr: add_expr ((HIGHER | LOWER | HEQUAL | LEQUAL) add_expr)?;
add_expr: times_expr ((PLUS | MINUS) times_expr)*;
times_expr: not_expr ((MULTIPLY | DIVIDE | PERCENT) not_expr)*;
not_expr: (NOT)? minus_expr;
minus_expr: (MINUS)? order;
order: location | BLEFT (expr) BRIGHT | literal | method_call;


literal: int_literal | CHAR_LITERAL | bool_literal;
bool_literal: TK_true | TK_false;
int_literal: DECIMAL_LITERAL | HEX_LITERAL;
callout_arg: expr | STRING;