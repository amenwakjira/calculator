package calc;
import java.math.BigInteger;

public class operations {
    public static double e = Math.E; 
    
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

    public static double root (double num1, int num2) {
        if (num1 < 0) {
            num1 = -num1;
            return - Math.pow(num1, 1.0/num2); 
        }
        return Math.pow(num1, 1.0/num2); 
    }

    public static double absVal(double num) {
        // can use Math.abs() but also
        if (num < 0) {
            return num - num - num;
        }
        return num; 
    }

    public static double mod(double dividend, double divisor) {
        return dividend % divisor; 
    }

    public static double log(double base, double arg) {
        // log_b(x) = ln(x) / ln(b)
        return Math.log(arg) / Math.log(base); 
    }

    public static double sincostan(String operation, double input) {
        if (operation.contentEquals("SIN")) {
            return Math.sin(input); 
        } else if (operation.contentEquals("COS")) {
            return Math.cos(input); 
        }
        return Math.tan(input); 
    }
}
