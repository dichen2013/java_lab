import java.util.ArrayList;

/*
 * Exp 
 * Eric McCreath 2017
 */

public abstract class Exp {
	public abstract int evaluate(Subs subs, Functions funs);

	public abstract String show();

	/*
	 * <exp> ::= 0 | inc ( <exp> ) | dec ( <exp> ) | <variable> | <funtion name>
	 * ( <exps> ) | ( <exp> ? <exp> : <exp> ) <exps> ::= <exp> | <exp> , <exps>
	 * <function> ::= <function name> ( <vars> ) = <exp> <functions> ::=
	 * <function> | <function> <functions> <vars> ::= <variable> | <variable> ,
	 * <vars>
	 */

	static public Exp parseExp(Tokenizer tok) {
		if (tok.current().equals(new Integer(0))) {
			tok.next(); // consume the "0"
			return new ZeroExp();
		} else if ((tok.current().equals("inc"))) {
			tok.next(); // consume the "inc"
			tok.parse("(");
			Exp exp = parseExp(tok); // recursively parse the sub expression
			tok.parse(")");
			return new IncExp(exp);
		}else if (tok.current().equals("dec")){
			tok.next(); // consume the "inc"
			tok.parse("(");
			Exp exp = parseExp(tok); // recursively parse the sub expression
			tok.parse(")");
			return new DecExp(exp);
		} else if(tok.current().equals("(")){
			tok.next();
			Exp exp1 = parseExp(tok);
			tok.parse("?");
			Exp exp2 = parseExp(tok);
			tok.parse(":");
			Exp exp3 = parseExp(tok);
			tok.parse(")");
			return new SelectExp(exp1,exp2,exp3);
		}
			// add your code here
		throw new Error();
	}

	static public Function parseFunction(Tokenizer tok){
		return null;
	}

	public static void main(String[] args) {
//		String txt = "(inc(0)? 0 : dec(dec(0)))";
		String txt = "(0 ? 0 : 0)";
		SimpleTokenizer ST = new SimpleTokenizer(txt);
		parseExp(ST).show();
	}




}
