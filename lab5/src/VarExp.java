
/*
 * VarExp
 * Eric McCreath 2017
 */

public class VarExp extends Exp {

	String var;
	
	@Override
	public double evaluate(Subs subs) {
		Double res = subs.get(var);
		return  (res == null? 0:res) ;
	}

	@Override
	public String toString() {
		return var;
	}

	public VarExp(String var) {
		super();
		this.var = var;
	}

}
