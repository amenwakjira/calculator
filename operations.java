package calc;
import java.math.BigInteger;

public class operations {
    
    public static double add(double num1, double num2) {
        return num1 + num2; 
    }

    public static double subtract(double num1, double num2) {
        return num1 - num2; 
    }

    public static double multiply(double num1, double num2) {
        return num1 * num2; 
    }

    public static double divide(double num1, double num2) {
        return num1 / num2; 
    }

    public static double power(double num1, double num2) {
        return Math.pow(num1, num2);
    }

    public static BigInteger factorial(BigInteger num) {
        BigInteger total = BigInteger.ONE; 
        while (num != BigInteger.valueOf(0)) {
            total = total.multiply(num); 
            num = num.subtract(BigInteger.ONE); 
        }
        return total; 
    }

    public static String reciprocal(int num1, int num2) {
        return num2 + "/" + num1; 
    }
}
