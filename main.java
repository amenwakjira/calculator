package calc; 
import java.math.BigInteger;
import java.util.*;  

public class main {
    public static void main(String[] args) {
        boolean more = true;
        Scanner sc = new Scanner(System.in); 
        System.out.println("Welcome! I heard you got some calculations to do! Weird, you don't look like a math person! Anyways, let's get started!");
        while (more) {
            System.out.println("Specify which operation you would like for me to perform!"); 
            System.out.println("A - Add"); 
            System.out.println("S - Subtract"); 
            System.out.println("M - Multiply"); 
            System.out.println("D - Divide"); 
            System.out.println("X - Exit"); 
            System.out.println("P - Power (first number raised to the second number)"); 
            System.out.println("F - Factorial (one input)"); 
            String operation = sc.nextLine(); 
            while (!operation.contentEquals("A") && !operation.contentEquals("S") && !operation.contentEquals("M") && !operation.contentEquals("D") && !operation.contentEquals("X") && !operation.contentEquals("P") && !operation.contentEquals("F")) {
                System.out.println("Please give a valid operation using the legend!"); 
                operation = sc.nextLine(); 
            }

            double output = 0; 

            if (operation.contentEquals("X")) {
                System.out.println("That was all for this calculator! See you next time!");  
                more = false;
                sc.close(); 
                break; 
            } else if (operation.contentEquals("F")) {
                System.out.println("Enter your number:"); 
                operation = "!";
                int num = sc.nextInt(); 
                BigInteger output2 = calc.operations.factorial(num); 
                System.out.println(num + operation + " is " + output2); 
                try {
                    Thread.sleep(1000); 
                } catch (Exception e) {
                    Thread.currentThread().interrupt(); 
                }
                break; 
            }

            switch (operation) {
                case "A" -> {
                    System.out.println("What is the first number?"); 
                    double num1 = sc.nextDouble(); 

                    System.out.println("What is the second number?");
                    double num2 = sc.nextDouble(); 
                    operation = "+";
                    output = calc.operations.add(num1, num2);
                    System.out.println(num1 + " " + operation + " " + num2 + " is " + output); 
                    try {
                        Thread.sleep(1000); 
                    } catch (Exception e) {
                        Thread.currentThread().interrupt(); 
                    }
                }
                case "S" -> {
                    System.out.println("What is the first number?"); 
                    double num1 = sc.nextDouble(); 

                    System.out.println("What is the second number?");
                    double num2 = sc.nextDouble(); 
                    operation = "-";
                    output = calc.operations.subtract(num1, num2);
                    System.out.println(num1 + " " + operation + " " + num2 + " is " + output);
                    try {
                        Thread.sleep(1000); 
                    } catch (Exception e) {
                        Thread.currentThread().interrupt(); 
                    }
                }
                case "M" -> {
                    System.out.println("What is the first number?"); 
                    double num1 = sc.nextDouble(); 

                    System.out.println("What is the second number?");
                    double num2 = sc.nextDouble(); 
                    operation = "*";
                    output = calc.operations.multiply(num1, num2);
                    System.out.println(num1 + " " + operation + " " + num2 + " is " + output);
                    try {
                        Thread.sleep(1000); 
                    } catch (Exception e) {
                        Thread.currentThread().interrupt(); 
                    }
                }
                case "D" -> {
                    System.out.println("What is the first number?"); 
                    double num1 = sc.nextDouble(); 

                    System.out.println("What is the second number?");
                    double num2 = sc.nextDouble(); 
                    operation = "/";
                    output = calc.operations.divide(num1, num2);
                    System.out.println(num1 + " " + operation + " " + num2 + " is " + output); 
                    try {
                        Thread.sleep(1000); 
                    } catch (Exception e) {
                        Thread.currentThread().interrupt(); 
                    }
                }
                case "P" -> {
                    System.out.println("What is the first number?"); 
                    double num1 = sc.nextDouble(); 

                    System.out.println("What is the second number?");
                    double num2 = sc.nextDouble(); 
                    operation = "^";
                    output = calc.operations.power(num1, num2);
                    System.out.println(num1 + " " + operation + " " + num2 + " is " + output);
                    try {
                        Thread.sleep(1000); 
                    } catch (Exception e) {
                        Thread.currentThread().interrupt(); 
                    } 
                }
                default -> {
                    System.out.println("What is the first number?"); 
                    double num1 = sc.nextDouble(); 

                    System.out.println("What is the second number?");
                    double num2 = sc.nextDouble(); 
                    operation = "+"; 
                    output = calc.operations.add(num1, num2); 
                    System.out.println(num1 + " " + operation + " " + num2 + " is " + output);
                    try {
                        Thread.sleep(1000); 
                    } catch (Exception e) {
                        Thread.currentThread().interrupt(); 
                    } 
                } 
            }
        }
        sc.close(); 
    }
}
