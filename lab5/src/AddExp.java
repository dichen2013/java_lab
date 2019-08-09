/**
 * Created by rui on 27/04/17.
 */
public class AddExp extends Exp {
    Exp left, right;

    public AddExp(Exp l, Exp r){
        left = l;
        right = r;
    }

    @Override
    public double evaluate(Subs subs) {
        return left.evaluate(subs) + right.evaluate(subs);
    }

    @Override
    public String toString() {
        return "(" + left + "+" + right + ")";
    }

}
