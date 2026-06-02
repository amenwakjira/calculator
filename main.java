package calc; 
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
            String operation = sc.nextLine(); 
            while (!operation.contentEquals("A") && !operation.contentEquals("S") && !operation.contentEquals("M") && !operation.contentEquals("D") && !operation.contentEquals("X")) {
                System.out.println("Please give a valid operation using the legend!"); 
                operation = sc.nextLine(); 
            }

            if (operation.contains("X")) {
                System.out.println("That was all for this calculator! See you next time!");  
                more = false;
                sc.close(); 
                break; 
            }

            System.out.println("What is the first number?"); 
            double num1 = sc.nextDouble(); 

            System.out.println("What is the second number?");
            double num2 = sc.nextDouble(); 

            double output = 0; 
            switch (operation) {
                case "A" -> {
                    operation = "+";
                    output = calc.operations.add(num1, num2);
                }
                case "S" -> {
                    operation = "-";
                    output = calc.operations.subtract(num1, num2);
                }
                case "M" -> {
                    operation = "*";
                    output = calc.operations.multiply(num1, num2);
                }
                case "D" -> {
                    operation = "/";
                    output = calc.operations.divide(num1, num2);
                }
                default -> {
                    operation = "+"; 
                    output = calc.operations.add(num1, num2); 
                } 
            }

            System.out.println(num1 + " " + operation + " " + num2 + " is " + output); 
        }
        sc.close(); 
    }
}
