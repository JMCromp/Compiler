package decaf;
import antlr.TokenBuffer;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.ANTLRException;
import antlr.LLkParser;
import antlr.Token;
import antlr.TokenStream;
import antlr.RecognitionException;
import antlr.NoViableAltException;
import antlr.MismatchedTokenException;
import antlr.SemanticException;
import antlr.ParserSharedInputState;
import antlr.collections.impl.BitSet;
import antlr.collections.AST;
import java.util.Hashtable;
import antlr.ASTFactory;
import antlr.ASTPair;
import antlr.collections.impl.ASTArray;

public class DecafParser extends antlr.LLkParser       implements DecafParserTokenTypes
 {

protected DecafParser(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public DecafParser(TokenBuffer tokenBuf) {
  this(tokenBuf,3);
}

protected DecafParser(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public DecafParser(TokenStream lexer) {
  this(lexer,3);
}

public DecafParser(ParserSharedInputState state) {
  super(state,3);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

	public final void program() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST program_AST = null;
		
		try {      // for error handling
			AST tmp1_AST = null;
			tmp1_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp1_AST);
			match(TK_class);
			AST tmp2_AST = null;
			tmp2_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp2_AST);
			match(ID);
			AST tmp3_AST = null;
			tmp3_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp3_AST);
			match(LCURLY);
			{
			_loop3:
			do {
				if ((LA(1)==TK_int||LA(1)==TK_boolean)) {
					field_decl();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop3;
				}
				
			} while (true);
			}
			AST tmp4_AST = null;
			tmp4_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp4_AST);
			match(RCURLY);
			AST tmp5_AST = null;
			tmp5_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp5_AST);
			match(Token.EOF_TYPE);
			program_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
		returnAST = program_AST;
	}
	
	public final void field_decl() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST field_decl_AST = null;
		
		try {      // for error handling
			type();
			astFactory.addASTChild(currentAST, returnAST);
			field_list();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp6_AST = null;
			tmp6_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp6_AST);
			match(SEMICOLON);
			field_decl_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_1);
		}
		returnAST = field_decl_AST;
	}
	
	public final void type() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST type_AST = null;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case TK_int:
			{
				AST tmp7_AST = null;
				tmp7_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp7_AST);
				match(TK_int);
				break;
			}
			case TK_boolean:
			{
				AST tmp8_AST = null;
				tmp8_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp8_AST);
				match(TK_boolean);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			type_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_2);
		}
		returnAST = type_AST;
	}
	
	public final void field_list() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST field_list_AST = null;
		
		try {      // for error handling
			{
			if ((LA(1)==ID) && (LA(2)==SEMICOLON||LA(2)==COMMA)) {
				AST tmp9_AST = null;
				tmp9_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp9_AST);
				match(ID);
			}
			else if ((LA(1)==ID) && (LA(2)==SLEFT)) {
				AST tmp10_AST = null;
				tmp10_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp10_AST);
				match(ID);
				AST tmp11_AST = null;
				tmp11_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp11_AST);
				match(SLEFT);
				int_literal();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp12_AST = null;
				tmp12_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp12_AST);
				match(SRIGHT);
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			{
			_loop9:
			do {
				if ((LA(1)==COMMA)) {
					AST tmp13_AST = null;
					tmp13_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp13_AST);
					match(COMMA);
					{
					if ((LA(1)==ID) && (LA(2)==SEMICOLON||LA(2)==COMMA)) {
						AST tmp14_AST = null;
						tmp14_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp14_AST);
						match(ID);
					}
					else if ((LA(1)==ID) && (LA(2)==SLEFT)) {
						AST tmp15_AST = null;
						tmp15_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp15_AST);
						match(ID);
						AST tmp16_AST = null;
						tmp16_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp16_AST);
						match(SLEFT);
						int_literal();
						astFactory.addASTChild(currentAST, returnAST);
						AST tmp17_AST = null;
						tmp17_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp17_AST);
						match(SRIGHT);
					}
					else {
						throw new NoViableAltException(LT(1), getFilename());
					}
					
					}
				}
				else {
					break _loop9;
				}
				
			} while (true);
			}
			field_list_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_3);
		}
		returnAST = field_list_AST;
	}
	
	public final void int_literal() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST int_literal_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case DECIMAL_LITERAL:
			{
				AST tmp18_AST = null;
				tmp18_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp18_AST);
				match(DECIMAL_LITERAL);
				int_literal_AST = (AST)currentAST.root;
				break;
			}
			case HEX_LITERAL:
			{
				AST tmp19_AST = null;
				tmp19_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp19_AST);
				match(HEX_LITERAL);
				int_literal_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_4);
		}
		returnAST = int_literal_AST;
	}
	
	public final void method_decl() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST method_decl_AST = null;
		
		try {      // for error handling
			method_type();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp20_AST = null;
			tmp20_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp20_AST);
			match(ID);
			{
			_loop12:
			do {
				if ((LA(1)==BLEFT)) {
					AST tmp21_AST = null;
					tmp21_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp21_AST);
					match(BLEFT);
					id_list();
					astFactory.addASTChild(currentAST, returnAST);
					AST tmp22_AST = null;
					tmp22_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp22_AST);
					match(BRIGHT);
				}
				else {
					break _loop12;
				}
				
			} while (true);
			}
			block();
			astFactory.addASTChild(currentAST, returnAST);
			method_decl_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
		returnAST = method_decl_AST;
	}
	
	public final void method_type() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST method_type_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case TK_int:
			case TK_boolean:
			{
				type();
				astFactory.addASTChild(currentAST, returnAST);
				method_type_AST = (AST)currentAST.root;
				break;
			}
			case TK_void:
			{
				AST tmp23_AST = null;
				tmp23_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp23_AST);
				match(TK_void);
				method_type_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_2);
		}
		returnAST = method_type_AST;
	}
	
	public final void id_list() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST id_list_AST = null;
		
		try {      // for error handling
			{
			type();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp24_AST = null;
			tmp24_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp24_AST);
			match(ID);
			{
			_loop17:
			do {
				if ((LA(1)==COMMA)) {
					AST tmp25_AST = null;
					tmp25_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp25_AST);
					match(COMMA);
					type();
					astFactory.addASTChild(currentAST, returnAST);
					AST tmp26_AST = null;
					tmp26_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp26_AST);
					match(ID);
				}
				else {
					break _loop17;
				}
				
			} while (true);
			}
			}
			id_list_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_5);
		}
		returnAST = id_list_AST;
	}
	
	public final void block() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST block_AST = null;
		
		try {      // for error handling
			AST tmp27_AST = null;
			tmp27_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp27_AST);
			match(LCURLY);
			{
			_loop20:
			do {
				if ((LA(1)==TK_int||LA(1)==TK_boolean)) {
					var_decl();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop20;
				}
				
			} while (true);
			}
			{
			_loop22:
			do {
				if ((_tokenSet_6.member(LA(1)))) {
					statement();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop22;
				}
				
			} while (true);
			}
			AST tmp28_AST = null;
			tmp28_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp28_AST);
			match(RCURLY);
			block_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_7);
		}
		returnAST = block_AST;
	}
	
	public final void var_decl() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST var_decl_AST = null;
		
		try {      // for error handling
			{
			type();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp29_AST = null;
			tmp29_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp29_AST);
			match(ID);
			}
			{
			_loop26:
			do {
				if ((LA(1)==COMMA)) {
					AST tmp30_AST = null;
					tmp30_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp30_AST);
					match(COMMA);
					type();
					astFactory.addASTChild(currentAST, returnAST);
					AST tmp31_AST = null;
					tmp31_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp31_AST);
					match(ID);
				}
				else {
					break _loop26;
				}
				
			} while (true);
			}
			AST tmp32_AST = null;
			tmp32_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp32_AST);
			match(SEMICOLON);
			var_decl_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_8);
		}
		returnAST = var_decl_AST;
	}
	
	public final void statement() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST statement_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case TK_if:
			{
				AST tmp33_AST = null;
				tmp33_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp33_AST);
				match(TK_if);
				{
				expr();
				astFactory.addASTChild(currentAST, returnAST);
				}
				block();
				astFactory.addASTChild(currentAST, returnAST);
				{
				AST tmp34_AST = null;
				tmp34_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp34_AST);
				match(TK_else);
				block();
				astFactory.addASTChild(currentAST, returnAST);
				}
				statement_AST = (AST)currentAST.root;
				break;
			}
			case TK_for:
			{
				AST tmp35_AST = null;
				tmp35_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp35_AST);
				match(TK_for);
				AST tmp36_AST = null;
				tmp36_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp36_AST);
				match(ID);
				AST tmp37_AST = null;
				tmp37_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp37_AST);
				match(EQUALS);
				expr();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp38_AST = null;
				tmp38_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp38_AST);
				match(COMMA);
				{
				expr();
				astFactory.addASTChild(currentAST, returnAST);
				block();
				astFactory.addASTChild(currentAST, returnAST);
				}
				statement_AST = (AST)currentAST.root;
				break;
			}
			case TK_return:
			{
				AST tmp39_AST = null;
				tmp39_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp39_AST);
				match(TK_return);
				{
				expr();
				astFactory.addASTChild(currentAST, returnAST);
				}
				AST tmp40_AST = null;
				tmp40_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp40_AST);
				match(SEMICOLON);
				statement_AST = (AST)currentAST.root;
				break;
			}
			case TK_break:
			{
				AST tmp41_AST = null;
				tmp41_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp41_AST);
				match(TK_break);
				AST tmp42_AST = null;
				tmp42_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp42_AST);
				match(SEMICOLON);
				statement_AST = (AST)currentAST.root;
				break;
			}
			case TK_continue:
			{
				AST tmp43_AST = null;
				tmp43_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp43_AST);
				match(TK_continue);
				AST tmp44_AST = null;
				tmp44_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp44_AST);
				match(SEMICOLON);
				statement_AST = (AST)currentAST.root;
				break;
			}
			case LCURLY:
			{
				block();
				astFactory.addASTChild(currentAST, returnAST);
				statement_AST = (AST)currentAST.root;
				break;
			}
			default:
				if ((LA(1)==ID) && (_tokenSet_9.member(LA(2)))) {
					location();
					astFactory.addASTChild(currentAST, returnAST);
					assign_op();
					astFactory.addASTChild(currentAST, returnAST);
					expr();
					astFactory.addASTChild(currentAST, returnAST);
					AST tmp45_AST = null;
					tmp45_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp45_AST);
					match(SEMICOLON);
					statement_AST = (AST)currentAST.root;
				}
				else if ((LA(1)==TK_callout||LA(1)==ID) && (LA(2)==BLEFT)) {
					method_call();
					astFactory.addASTChild(currentAST, returnAST);
					AST tmp46_AST = null;
					tmp46_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp46_AST);
					match(SEMICOLON);
					statement_AST = (AST)currentAST.root;
				}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_10);
		}
		returnAST = statement_AST;
	}
	
	public final void location() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST location_AST = null;
		
		try {      // for error handling
			if ((LA(1)==ID) && (_tokenSet_11.member(LA(2)))) {
				AST tmp47_AST = null;
				tmp47_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp47_AST);
				match(ID);
				location_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==ID) && (LA(2)==SLEFT)) {
				AST tmp48_AST = null;
				tmp48_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp48_AST);
				match(ID);
				AST tmp49_AST = null;
				tmp49_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp49_AST);
				match(SLEFT);
				expr();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp50_AST = null;
				tmp50_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp50_AST);
				match(SRIGHT);
				location_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_11);
		}
		returnAST = location_AST;
	}
	
	public final void assign_op() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST assign_op_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case EQUALS:
			{
				AST tmp51_AST = null;
				tmp51_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp51_AST);
				match(EQUALS);
				assign_op_AST = (AST)currentAST.root;
				break;
			}
			case PEQUALS:
			{
				AST tmp52_AST = null;
				tmp52_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp52_AST);
				match(PEQUALS);
				assign_op_AST = (AST)currentAST.root;
				break;
			}
			case SEQUALS:
			{
				AST tmp53_AST = null;
				tmp53_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp53_AST);
				match(SEQUALS);
				assign_op_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_12);
		}
		returnAST = assign_op_AST;
	}
	
	public final void expr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST expr_AST = null;
		
		try {      // for error handling
			and_expr();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop45:
			do {
				if ((LA(1)==DOR)) {
					AST tmp54_AST = null;
					tmp54_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp54_AST);
					match(DOR);
					and_expr();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop45;
				}
				
			} while (true);
			}
			expr_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_13);
		}
		returnAST = expr_AST;
	}
	
	public final void method_call() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST method_call_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case ID:
			{
				method_name();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp55_AST = null;
				tmp55_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp55_AST);
				match(BLEFT);
				{
				switch ( LA(1)) {
				case TK_false:
				case TK_callout:
				case TK_true:
				case BLEFT:
				case NOT:
				case MINUS:
				case HEX_LITERAL:
				case ID:
				case CHAR_LITERAL:
				case DECIMAL_LITERAL:
				{
					expr();
					astFactory.addASTChild(currentAST, returnAST);
					{
					_loop38:
					do {
						if ((LA(1)==COMMA)) {
							AST tmp56_AST = null;
							tmp56_AST = astFactory.create(LT(1));
							astFactory.addASTChild(currentAST, tmp56_AST);
							match(COMMA);
							expr();
							astFactory.addASTChild(currentAST, returnAST);
						}
						else {
							break _loop38;
						}
						
					} while (true);
					}
					break;
				}
				case BRIGHT:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				AST tmp57_AST = null;
				tmp57_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp57_AST);
				match(BRIGHT);
				method_call_AST = (AST)currentAST.root;
				break;
			}
			case TK_callout:
			{
				AST tmp58_AST = null;
				tmp58_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp58_AST);
				match(TK_callout);
				AST tmp59_AST = null;
				tmp59_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp59_AST);
				match(BLEFT);
				AST tmp60_AST = null;
				tmp60_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp60_AST);
				match(STRING);
				{
				_loop40:
				do {
					if ((LA(1)==COMMA)) {
						AST tmp61_AST = null;
						tmp61_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp61_AST);
						match(COMMA);
						callout_arg();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						break _loop40;
					}
					
				} while (true);
				}
				AST tmp62_AST = null;
				tmp62_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp62_AST);
				match(BRIGHT);
				method_call_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_4);
		}
		returnAST = method_call_AST;
	}
	
	public final void method_name() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST method_name_AST = null;
		
		try {      // for error handling
			AST tmp63_AST = null;
			tmp63_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp63_AST);
			match(ID);
			method_name_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_14);
		}
		returnAST = method_name_AST;
	}
	
	public final void callout_arg() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST callout_arg_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case TK_false:
			case TK_callout:
			case TK_true:
			case BLEFT:
			case NOT:
			case MINUS:
			case HEX_LITERAL:
			case ID:
			case CHAR_LITERAL:
			case DECIMAL_LITERAL:
			{
				expr();
				astFactory.addASTChild(currentAST, returnAST);
				callout_arg_AST = (AST)currentAST.root;
				break;
			}
			case STRING:
			{
				AST tmp64_AST = null;
				tmp64_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp64_AST);
				match(STRING);
				callout_arg_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_15);
		}
		returnAST = callout_arg_AST;
	}
	
	public final void and_expr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST and_expr_AST = null;
		
		try {      // for error handling
			equal_expr();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop48:
			do {
				if ((LA(1)==DAND)) {
					AST tmp65_AST = null;
					tmp65_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp65_AST);
					match(DAND);
					equal_expr();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop48;
				}
				
			} while (true);
			}
			and_expr_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_16);
		}
		returnAST = and_expr_AST;
	}
	
	public final void equal_expr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST equal_expr_AST = null;
		
		try {      // for error handling
			rel_expr();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case NEQUAL:
			case EQUIV:
			{
				{
				switch ( LA(1)) {
				case EQUIV:
				{
					AST tmp66_AST = null;
					tmp66_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp66_AST);
					match(EQUIV);
					break;
				}
				case NEQUAL:
				{
					AST tmp67_AST = null;
					tmp67_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp67_AST);
					match(NEQUAL);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				rel_expr();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LCURLY:
			case BRIGHT:
			case SEMICOLON:
			case COMMA:
			case DAND:
			case DOR:
			case SRIGHT:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			equal_expr_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_17);
		}
		returnAST = equal_expr_AST;
	}
	
	public final void rel_expr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST rel_expr_AST = null;
		
		try {      // for error handling
			add_expr();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case HIGHER:
			case LOWER:
			case LEQUAL:
			case HEQUAL:
			{
				{
				switch ( LA(1)) {
				case HIGHER:
				{
					AST tmp68_AST = null;
					tmp68_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp68_AST);
					match(HIGHER);
					break;
				}
				case LOWER:
				{
					AST tmp69_AST = null;
					tmp69_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp69_AST);
					match(LOWER);
					break;
				}
				case HEQUAL:
				{
					AST tmp70_AST = null;
					tmp70_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp70_AST);
					match(HEQUAL);
					break;
				}
				case LEQUAL:
				{
					AST tmp71_AST = null;
					tmp71_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp71_AST);
					match(LEQUAL);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				add_expr();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LCURLY:
			case BRIGHT:
			case SEMICOLON:
			case COMMA:
			case NEQUAL:
			case EQUIV:
			case DAND:
			case DOR:
			case SRIGHT:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			rel_expr_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_18);
		}
		returnAST = rel_expr_AST;
	}
	
	public final void add_expr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST add_expr_AST = null;
		
		try {      // for error handling
			times_expr();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop58:
			do {
				if ((LA(1)==PLUS||LA(1)==MINUS)) {
					{
					switch ( LA(1)) {
					case PLUS:
					{
						AST tmp72_AST = null;
						tmp72_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp72_AST);
						match(PLUS);
						break;
					}
					case MINUS:
					{
						AST tmp73_AST = null;
						tmp73_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp73_AST);
						match(MINUS);
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					times_expr();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop58;
				}
				
			} while (true);
			}
			add_expr_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_19);
		}
		returnAST = add_expr_AST;
	}
	
	public final void times_expr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST times_expr_AST = null;
		
		try {      // for error handling
			not_expr();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop62:
			do {
				if (((LA(1) >= MULTIPLY && LA(1) <= DIVIDE))) {
					{
					switch ( LA(1)) {
					case MULTIPLY:
					{
						AST tmp74_AST = null;
						tmp74_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp74_AST);
						match(MULTIPLY);
						break;
					}
					case DIVIDE:
					{
						AST tmp75_AST = null;
						tmp75_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp75_AST);
						match(DIVIDE);
						break;
					}
					case PERCENT:
					{
						AST tmp76_AST = null;
						tmp76_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp76_AST);
						match(PERCENT);
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					not_expr();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop62;
				}
				
			} while (true);
			}
			times_expr_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_20);
		}
		returnAST = times_expr_AST;
	}
	
	public final void not_expr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST not_expr_AST = null;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case NOT:
			{
				AST tmp77_AST = null;
				tmp77_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp77_AST);
				match(NOT);
				break;
			}
			case TK_false:
			case TK_callout:
			case TK_true:
			case BLEFT:
			case MINUS:
			case HEX_LITERAL:
			case ID:
			case CHAR_LITERAL:
			case DECIMAL_LITERAL:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			minus_expr();
			astFactory.addASTChild(currentAST, returnAST);
			not_expr_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_4);
		}
		returnAST = not_expr_AST;
	}
	
	public final void minus_expr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST minus_expr_AST = null;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case MINUS:
			{
				AST tmp78_AST = null;
				tmp78_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp78_AST);
				match(MINUS);
				break;
			}
			case TK_false:
			case TK_callout:
			case TK_true:
			case BLEFT:
			case HEX_LITERAL:
			case ID:
			case CHAR_LITERAL:
			case DECIMAL_LITERAL:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			order();
			astFactory.addASTChild(currentAST, returnAST);
			minus_expr_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_4);
		}
		returnAST = minus_expr_AST;
	}
	
	public final void order() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST order_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case BLEFT:
			{
				AST tmp79_AST = null;
				tmp79_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp79_AST);
				match(BLEFT);
				{
				expr();
				astFactory.addASTChild(currentAST, returnAST);
				}
				AST tmp80_AST = null;
				tmp80_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp80_AST);
				match(BRIGHT);
				order_AST = (AST)currentAST.root;
				break;
			}
			case TK_false:
			case TK_true:
			case HEX_LITERAL:
			case CHAR_LITERAL:
			case DECIMAL_LITERAL:
			{
				literal();
				astFactory.addASTChild(currentAST, returnAST);
				order_AST = (AST)currentAST.root;
				break;
			}
			default:
				if ((LA(1)==ID) && (_tokenSet_21.member(LA(2)))) {
					location();
					astFactory.addASTChild(currentAST, returnAST);
					order_AST = (AST)currentAST.root;
				}
				else if ((LA(1)==TK_callout||LA(1)==ID) && (LA(2)==BLEFT)) {
					method_call();
					astFactory.addASTChild(currentAST, returnAST);
					order_AST = (AST)currentAST.root;
				}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_4);
		}
		returnAST = order_AST;
	}
	
	public final void literal() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST literal_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case HEX_LITERAL:
			case DECIMAL_LITERAL:
			{
				int_literal();
				astFactory.addASTChild(currentAST, returnAST);
				literal_AST = (AST)currentAST.root;
				break;
			}
			case CHAR_LITERAL:
			{
				AST tmp81_AST = null;
				tmp81_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp81_AST);
				match(CHAR_LITERAL);
				literal_AST = (AST)currentAST.root;
				break;
			}
			case TK_false:
			case TK_true:
			{
				bool_literal();
				astFactory.addASTChild(currentAST, returnAST);
				literal_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_4);
		}
		returnAST = literal_AST;
	}
	
	public final void bool_literal() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST bool_literal_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case TK_true:
			{
				AST tmp82_AST = null;
				tmp82_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp82_AST);
				match(TK_true);
				bool_literal_AST = (AST)currentAST.root;
				break;
			}
			case TK_false:
			{
				AST tmp83_AST = null;
				tmp83_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp83_AST);
				match(TK_false);
				bool_literal_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_4);
		}
		returnAST = bool_literal_AST;
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"\"class\"",
		"\"int\"",
		"\"else\"",
		"\"boolean\"",
		"\"void\"",
		"\"if\"",
		"\"return\"",
		"\"false\"",
		"\"callout\"",
		"\"continue\"",
		"\"break\"",
		"\"for\"",
		"\"true\"",
		"{",
		"}",
		"(",
		")",
		"NOT",
		"PEQUALS",
		"SEQUALS",
		"SEMICOLON",
		"COMMA",
		"PLUS",
		"MULTIPLY",
		"PERCENT",
		"DIVIDE",
		"MINUS",
		"HIGHER",
		"LOWER",
		"NEQUAL",
		"EQUIV",
		"LEQUAL",
		"HEQUAL",
		"DAND",
		"DOR",
		"EQUALS",
		"SRIGHT",
		"SLEFT",
		"DIGIT",
		"HEX_DIGIT",
		"ALPHA",
		"ALPHA_NUM",
		"ESC",
		"VALIDCHAR",
		"HEX_LITERAL",
		"ID",
		"CHAR_LITERAL",
		"STRING",
		"WS_",
		"SL_COMMENT",
		"DECIMAL_LITERAL",
		"CALLOUT"
	};
	
	protected void buildTokenTypeASTClassMap() {
		tokenTypeToASTClassMap=null;
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 2L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = { 262304L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = { 562949953421312L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = { 16777216L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = { 1649251844096L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = { 1048576L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	private static final long[] mk_tokenSet_6() {
		long[] data = { 562949953615360L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());
	private static final long[] mk_tokenSet_7() {
		long[] data = { 562949953877570L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_7 = new BitSet(mk_tokenSet_7());
	private static final long[] mk_tokenSet_8() {
		long[] data = { 562949953877664L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_8 = new BitSet(mk_tokenSet_8());
	private static final long[] mk_tokenSet_9() {
		long[] data = { 2748791652352L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_9 = new BitSet(mk_tokenSet_9());
	private static final long[] mk_tokenSet_10() {
		long[] data = { 562949953877504L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_10 = new BitSet(mk_tokenSet_10());
	private static final long[] mk_tokenSet_11() {
		long[] data = { 2199020240896L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_11 = new BitSet(mk_tokenSet_11());
	private static final long[] mk_tokenSet_12() {
		long[] data = { 19984724422891520L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_12 = new BitSet(mk_tokenSet_12());
	private static final long[] mk_tokenSet_13() {
		long[] data = { 1099563139072L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_13 = new BitSet(mk_tokenSet_13());
	private static final long[] mk_tokenSet_14() {
		long[] data = { 524288L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_14 = new BitSet(mk_tokenSet_14());
	private static final long[] mk_tokenSet_15() {
		long[] data = { 34603008L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_15 = new BitSet(mk_tokenSet_15());
	private static final long[] mk_tokenSet_16() {
		long[] data = { 1374441046016L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_16 = new BitSet(mk_tokenSet_16());
	private static final long[] mk_tokenSet_17() {
		long[] data = { 1511879999488L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_17 = new BitSet(mk_tokenSet_17());
	private static final long[] mk_tokenSet_18() {
		long[] data = { 1537649803264L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_18 = new BitSet(mk_tokenSet_18());
	private static final long[] mk_tokenSet_19() {
		long[] data = { 1647171469312L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_19 = new BitSet(mk_tokenSet_19());
	private static final long[] mk_tokenSet_20() {
		long[] data = { 1648312320000L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_20 = new BitSet(mk_tokenSet_20());
	private static final long[] mk_tokenSet_21() {
		long[] data = { 3848275099648L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_21 = new BitSet(mk_tokenSet_21());
	
	}
