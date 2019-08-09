/**
 * Created by rui on 27/04/17.
 */
public class LitExp extends Exp{
    Object value;

    public LitExp(Object i){
        value = i;
    }

    @Override
    public String toString() {
        return "" + value;
    }

    @Override
    public double evaluate(Subs subs) {
        return Double.valueOf(value.toString());
    }
}
