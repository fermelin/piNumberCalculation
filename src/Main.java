import java.util.function.DoubleBinaryOperator;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Main {

    public static double calculatePi(long nTerms) {
        final double numerator = 4.0;
        double denominator = 1.0;
        double pi = LongStream.range(0, nTerms).mapToDouble(e -> {
                if (e % 2 == 0) {
                    return numerator/(2*e+1);
                } else {
                    return -numerator/(2*e+1);
                }
            }).reduce(0, Double::sum);
//            .map(e -> 2 * e + 1)
        System.out.println(numerator/denominator);
        return pi;
    }
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(calculatePi1(Long.MAX_VALUE/1_000_000_000 ));
        long finish = System.currentTimeMillis();
        System.out.println((finish - start)/1000 + " seconds");
    }
    public static double calculatePi1(long nTerms) {
        final double numerator = 4.0;
        double denominator = 1.0;
//        int operation = 1;
        double pi = 0.0;
        for (long i = 0; i < nTerms; i++) {
            if (i % 2 == 0) {
                pi += numerator/denominator;
            } else {
                pi -= numerator/denominator;
            }
            denominator += 2.0;
        }
        System.out.println(numerator/denominator);
        return pi;
    }
}