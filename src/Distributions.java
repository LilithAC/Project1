import java.math.BigDecimal;

public class Distributions {
    public static BigDecimal binomial(int n, int y, double p, double q) {
        ComboPermu test = new ComboPermu();
        BigDecimal combo =  new BigDecimal(test.combination(n,y));
        BigDecimal p1 = BigDecimal.valueOf(Math.pow(p,y));
        BigDecimal q1 = BigDecimal.valueOf(Math.pow(q, (n-y)));
        return combo.multiply(q1.multiply(p1));
    }

    public static double geometric(int y, double p, double q){
        double q1 = Math.pow(q, (y-1));
        return q1*p;
    }
}
