package calc; 
import java.math.BigInteger;
import java.util.*;  

public class main {
    public static void main(String[] args) {
        boolean more = true;
        Scanner sc = new Scanner(System.in); 
        System.out.println("Welcome! I heard you got some calculations to do! Weird, you don't look like a math person! Anyways, let's get started!");
        while (more) {
            System.out.println("Specify which operation you would like for me to perform! (Case Sensitive)"); 
            System.out.println("A - Add"); 
            System.out.println("S - Subtract"); 
            System.out.println("M - Multiply"); 
            System.out.println("D - Divide"); 
            System.out.println("P - Power (first number raised to the second number)"); 
            System.out.println("F - Factorial (one input)"); 
            System.out.println("R - Reciprocal (if you need the recipical of an integer, input the integer as numerator and 1 as numberator)");
            System.out.println("r - Root");
            System.out.println("Abs - Absolute Value"); 
            System.out.println("Mod - Modulo"); 
            System.out.println("Log - Logrithm (for ln, use -1 as input for base)"); 
            System.out.println("SIN - Sine");
            System.out.println("COS - Cosine");
            System.out.println("TAN - Sine");
            System.out.println("X - Exit"); 
            System.out.println(); 
            
            String operation = sc.nextLine(); 
            while (!operation.contentEquals("A") && !operation.contentEquals("S") && !operation.contentEquals("M") && !operation.contentEquals("D") && !operation.contentEquals("X") && !operation.contentEquals("P") && !operation.contentEquals("F") && !operation.contentEquals("R") && !operation.contentEquals("r") && !operation.contentEquals("Abs") 
                && !operation.contentEquals("Mod") && !operation.contentEquals("Log") && !operation.contentEquals("SIN") && !operation.contentEquals("COS") && !operation.contentEquals("TAN")) {
                System.out.println("Please give a valid operation using the legend!"); 
                operation = sc.nextLine(); 
            }

            double output = 0; 

            if (operation.contentEquals("X")) {
                System.out.println("That was all for this calculator! See you next time!");  
                more = false;
                sc.close(); 
                break; 
            } 
            
            if (operation.contentEquals("F")) { 
                System.out.println("Enter your number:"); 
                operation = "!";
                BigInteger num = sc.nextBigInteger(); 
                while (num.compareTo(BigInteger.ZERO) < 0) {
                    System.out.println("How would I be able to calculate the factorial of a negative?! Try again with a positive number.");
                    try {
                        Thread.sleep(1000); 
                    } catch (Exception e) {
                        Thread.currentThread().interrupt(); 
                    } 
                    num = sc.nextBigInteger(); 
                }
                BigInteger output2 = calc.operations.factorial(num); 
                System.out.println(num + operation + " is " + output2); 
                try {
                    Thread.sleep(1000); 
                } catch (Exception e) {
                    Thread.currentThread().interrupt(); 
                }
                continue; 
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
                case "R" -> {
                    System.out.println("What is the numerator?"); 
                    int num1 = sc.nextInt();
                    System.out.println("What is the denominator?"); 
                    int num2 = sc.nextInt(); 

                    operation = "^-1";
                    String output3 = calc.operations.reciprocal(num1, num2); 
                    System.out.println("(" + num1 + " / " + num2 + ")" + operation  + " is " + output3);
                    try {
                        Thread.sleep(1000); 
                    } catch (Exception e) {
                        Thread.currentThread().interrupt(); 
                    } 
                }
                case "r" -> {
                    System.out.println("What is the base?"); 
                    double num1 = sc.nextDouble();
                    System.out.println("What is the root"); 
                    int num2 = sc.nextInt(); 
                    if (num2 % 1 != 0) {
                        System.out.println("Make sure your root is an integer or we won't get anywhere lol."); 
                        try {
                            Thread.sleep(1000); 
                        } catch (Exception e) {
                            Thread.currentThread().interrupt(); 
                        } 
                        continue; 
                    }

                    if (num1 < 0 && num2 % 2 == 0) {
                        System.out.println("Girl, negative base and even root?! you can't do that!"); 
                        try {
                            Thread.sleep(1000); 
                        } catch (Exception e) {
                            Thread.currentThread().interrupt(); 
                        } 
                        continue; 
                    } 

                    operation = "rt";
                    double output4 = calc.operations.root(num1, num2); 
                    System.out.println(num2 + "rt( " + num1 + " )" + " = " + output4);
                    try {
                        Thread.sleep(1000); 
                    } catch (Exception e) {
                        Thread.currentThread().interrupt(); 
                    }
                }
                case "Abs" -> {
                    System.out.println("What is the number?"); 
                    double num = sc.nextDouble(); 
                    operation = "|";
                    output = calc.operations.absVal(num); 
                    System.out.println(operation + num + operation + " is " +  output);
                    try {
                        Thread.sleep(1000); 
                    } catch (Exception e) {
                        Thread.currentThread().interrupt(); 
                    }
                }
                case "Mod" -> {
                    System.out.println("What is the dividend?"); 
                    double dividend = sc.nextDouble(); 

                    System.out.println("What is the divisor?");
                    double divisor = sc.nextDouble(); 
                    operation = "%";
                    output = calc.operations.mod(dividend, divisor);
                    System.out.println(dividend + " " + operation + " " + divisor + " is " + output); 
                    try {
                        Thread.sleep(1000); 
                    } catch (Exception e) {
                        Thread.currentThread().interrupt(); 
                    }
                }
                case "Log" -> {
                    System.out.println("What is the base?"); 
                    double base = sc.nextDouble(); 
                    while (base < -1 || base == 1) {
                        System.out.println("Now, you know you need a positive real number for the base (NOT 1), so why would you give me this?"); 
                        base = sc.nextDouble(); 
                    }
                    if (base == -1) {
                        base = Math.E; 
                    } 

                    System.out.println("What is the argument for the logritham?");
                    double arg = sc.nextDouble(); 
                    while (arg <= 0) {
                        System.out.println("Postive. Real. Number."); 
                        arg = sc.nextDouble(); 
                    }
                    operation = "Log";
                    output = calc.operations.log(base, arg); 
                    if (base == Math.E) {
                        System.out.println(operation + " ( " + arg + " ) " + " is " + output + " (base " + " e" + ").");
                    } else {
                        System.out.println(operation + " ( " + arg + " ) " + " is " + output + " (base " + base + ").");
                    }
                    
                    try {
                        Thread.sleep(1000); 
                    } catch (Exception e) {
                        Thread.currentThread().interrupt(); 
                    } 
                }
                case "SIN" -> {
                    System.out.println("Degrees (D) or Radians (R)?"); 
                    String type = sc.nextLine(); 
                    while (!type.contentEquals("D") && !type.contentEquals("R")) {
                        System.out.println("I gave you the two possible options, didn't I? (D or R)");
                        type = sc.nextLine(); 
                    }

                    double displayOutput = 0.0; 
                    if (type.contentEquals("D")) {
                        System.out.println("What is you're input? (Any real number is fine)"); 
                        double input = sc.nextDouble(); 
                        double realInput = input * (Math.PI / 180); 
                        displayOutput = input; 
                        output = calc.operations.sincostan("SIN", realInput);
                    } else {
                        System.out.println("What is you're input? (Any real number is fine)"); 
                        double input = sc.nextDouble(); 
                        displayOutput = input; 
                        output = calc.operations.sincostan("SIN", input);
                    }
                    operation = "Sin";
                    System.out.println(operation + "(" + displayOutput + ") " + "is " + output); 
                    try {
                        Thread.sleep(1000); 
                    } catch (Exception e) {
                        Thread.currentThread().interrupt(); 
                    }
                }
                case "COS" -> {
                    System.out.println("Degrees (D) or Radians (R)?"); 
                    String type = sc.nextLine(); 
                    while (!type.contentEquals("D") && !type.contentEquals("R")) {
                        System.out.println("I gave you the two possible options, didn't I? (D or R)");
                        type = sc.nextLine(); 
                    }

                    double displayOutput = 0.0; 
                    if (type.contentEquals("D")) {
                        System.out.println("What is you're input? (Any real number is fine)"); 
                        double input = sc.nextDouble(); 
                        double realInput = input * (Math.PI / 180); 
                        displayOutput = input; 
                        output = calc.operations.sincostan("COS", realInput);
                    } else {
                        System.out.println("What is you're input? (Any real number is fine)"); 
                        double input = sc.nextDouble(); 
                        displayOutput = input; 
                        output = calc.operations.sincostan("COS", input);
                    }
                    operation = "Cos";
                    System.out.println(operation + "(" + displayOutput + ") " + "is " + output); 
                    try {
                        Thread.sleep(1000); 
                    } catch (Exception e) {
                        Thread.currentThread().interrupt(); 
                    }
                }
                case "TAN" -> {
                    System.out.println("Degrees (D) or Radians (R)?"); 
                    String type = sc.nextLine(); 
                    while (!type.contentEquals("D") && !type.contentEquals("R")) {
                        System.out.println("I gave you the two possible options, didn't I? (D or R)");
                        type = sc.nextLine(); 
                    }

                    double displayOutput = 0.0; 
                    if (type.contentEquals("D")) {
                        System.out.println("What is you're input? (Any real number is fine)"); 
                        double input = sc.nextDouble(); 
                        double realInput = input * (Math.PI / 180); 
                        displayOutput = input; 
                        output = calc.operations.sincostan("TAN", realInput);
                    } else {
                        System.out.println("What is you're input? (Any real number is fine)"); 
                        double input = sc.nextDouble(); 
                        displayOutput = input; 
                        output = calc.operations.sincostan("TAN", input);
                    }
                    operation = "Tan";
                    System.out.println(operation + "(" + displayOutput + ") " + "is " + output); 
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
