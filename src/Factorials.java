import java.math.BigInteger;

public class Factorials {

    public BigInteger combination(int n, int r) {
        BigInteger combination;
        combination = factorial(n).divide(factorial(r).multiply(factorial(n-r)));
        return combination;
    }

    public BigInteger permutation(int n, int r) {
        BigInteger permutation;
        permutation = factorial(n).divide(factorial(n-r));
        return permutation;
    }

    public BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = n; i > 0; i--) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
