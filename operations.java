package calc;
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

    public static double factorial(int num) {
        int total = 1; 
        for (int i = num; i >= 1; i--) {
            total = total * i; 
        }
        return total; 
    }
}
