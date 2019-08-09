
/**
 * Created by rui on 11/05/17.
 */

public class AssignExp extends Exp{

    VarExp var;
    Exp exp;

    public AssignExp(VarExp var, Exp exp){
        this.var = var;
        this.exp = exp;
    }


    @Override
    public double evaluate(Subs subs) {
        subs.put(var.toString(), exp.evaluate(subs));
        return 0;
    }
}
