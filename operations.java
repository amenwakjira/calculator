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

    public static BigInteger factorial(int num) {
        BigInteger total = BigInteger.ONE; 
        for (int i = num; i > 0; i--) {
            total = total.multiply(BigInteger.valueOf(i)); 
            System.out.println(total); 
        }
        return total; 
    }
}
