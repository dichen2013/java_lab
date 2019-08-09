/**
 * Created by rui on 27/04/17.
 */
public class MultExp extends Exp {

    Exp left,right;

    public MultExp(Exp l, Exp r){
        left = l;
        right = r;
    }

    @Override
    public String toString() {
        return "(" + left + " * " + right + ")";
    }

    @Override
    public double evaluate(Subs subs) {
        return left.evaluate(subs)*right.evaluate(subs);
    }

}
