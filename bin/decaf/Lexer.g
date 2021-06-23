header {package decaf;}

options 
{
  mangleLiteralPrefix = "TK_";
  language="Java";
}

class DecafScanner extends Lexer;
options 
{
  k=2;
}

tokens 
{
  "class"; "int"; "else"; "boolean"; "void"; "if"; "return"; "false"; "callout"; "continue"; "break"; "for"; "true";
}

LCURLY options { paraphrase = "{"; } : "{";
RCURLY options { paraphrase = "}"; } : "}";
BLEFT options { paraphrase = "("; } : '(';
BRIGHT options { paraphrase = ")"; } : ')';

NOT: "!";
PEQUALS: "+=";
SEQUALS: "-=";
SEMICOLON: ';';
COMMA: ',';
PLUS: '+';
MULTIPLY: '*';
PERCENT: '&';
DIVIDE: '/';
MINUS: '-';
HIGHER: '>';
LOWER: '<';
NEQUAL: "!=";
EQUIV: "==";
LEQUAL: "<=";
HEQUAL: ">=";
DAND: "&&";
DOR: "||";
EQUALS: '=';
SRIGHT: ']';
SLEFT: '[';


protected DIGIT : '0' .. '9' ;
protected HEX_DIGIT : (DIGIT | 'a'. .'z' | 'A'. .'Z');
protected ALPHA : ('a'. .'z' | 'A'. .'Z' | '_');
protected ALPHA_NUM : (ALPHA | DIGIT);
protected ESC: '\\' ('n' | '"' | 't' | 'r' | '\''|'\\');
protected VALIDCHAR : (' '. .'!' | '#'. .'&' | '('. .'[' | ']'. .'~');

HEX_LITERAL : "0x"(HEX_DIGIT)(HEX_DIGIT)*;
ID : (ALPHA)(ALPHA_NUM)*;
CHAR_LITERAL : '\'' (ESC| VALIDCHAR) '\'' ;
STRING : '"' (ESC| VALIDCHAR)* '"';
WS_ : (' ' | '\n' {newline();} | '\t' | '\r' {newline();}) {_ttype = Token.SKIP; };
SL_COMMENT : "//" (~'\n')* '\n' {_ttype = Token.SKIP; newline (); };
DECIMAL_LITERAL : (DIGIT)+;
