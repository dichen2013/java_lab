import java.util.ArrayList;

public abstract class Exp {

	/* <assign> ::= <var> "=" <exp>
	 * <exp> ::= <term> | <term> + <exp>
	 * <term> ::= <factor> | <factor> * <term>
	 * <factor> ::= <lit> | <var>
	 */

	public abstract double evaluate(Subs subs);

	static public Exp parseAssign(Tokenizer tok) {
		Exp var = parseFactor(tok);

		if(tok.currentis("=")){
			tok.next();
			Exp exp = parseExp(tok);
			return new AssignExp((VarExp)var, exp);
		}else{
			throw new Error("Wrong Assign Expression");
		}
	}


	static public Exp parseExp(Tokenizer tok) {
		Exp term = parseTerm(tok);

		if(tok.currentis("+")){
			tok.next();
			Exp exp = parseExp(tok);
			return new AddExp(term, exp);
		}else{
			return term;
		}
	}

	static public Exp parseTerm(Tokenizer tok){
		Exp factor = parseFactor(tok);
		if(tok.currentis("*")){
			tok.next();
			Exp exp = parseExp(tok);
			return new MultExp(factor,exp);
		}else{
			return factor;
		}
	}

	private static Exp parseFactor(Tokenizer tok) {
		if(tok.current() instanceof Double || tok.current() instanceof Integer){
			Exp exp = new LitExp(tok.current());
			tok.next();
			return exp;
		}else{
			Exp exp = new VarExp((String) tok.current() );
			tok.next();
			return exp;
		}
	}


	public static void main(String[] args) {
//		String txt = "(inc(0)? 0 : dec(dec(0)))";
		Subs subs = new Subs();
		String txt = "x = 26;\ny=27;";

		String codes[] = txt.split(";");
		int n = codes.length;
		System.out.println(n);
		for(int i =0; i<n;i++){
			SimpleTokenizer ST = new SimpleTokenizer(codes[i]);
			Exp exp = parseAssign(ST);
			exp.evaluate(subs);
		}
		System.out.println(subs+"");

	}
}
