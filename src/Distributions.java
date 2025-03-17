import java.math.BigDecimal;

public class Distributions {
    public static BigDecimal binomial(int n, int y, int p, int q) {
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

    public static BigDecimal negativeBinomial(int y, int r, int p, int q) {
        ComboPermu a = new ComboPermu();
        BigDecimal combo = new BigDecimal(a.combination(y-1,r-1));
        BigDecimal p1 = BigDecimal.valueOf(Math.pow(p,r));
        BigDecimal q1 = BigDecimal.valueOf(Math.pow(q,y-r));
        return combo.multiply(p1.multiply(q1));
    }

    public static BigDecimal hypergeometric(int y, int r, int n, int N) {
        ComboPermu a = new ComboPermu();
        BigDecimal combo1 = new BigDecimal(a.combination(r, y));
        BigDecimal combo2 = new BigDecimal(a.combination(N-r,n-y));
        BigDecimal combo3 = new BigDecimal(a.combination(N, n));
        return combo1.multiply(combo2.multiply(combo3));
    }
}
