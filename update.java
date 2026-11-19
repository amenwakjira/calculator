package calc; 
import java.util.*;  

public class update {


    public static final HashMap<String, Integer> Precedence = new HashMap<>(); 

    static {
        Precedence.put("+", 1); 
        Precedence.put("-", 1); 
        Precedence.put("*", 2); 
        Precedence.put("/", 2); 
        Precedence.put("(", -1); 
        Precedence.put("|", -1);
        Precedence.put("^", 3);
    }
    
    // using Shunting Yard Algorithm to get RPN form of inputed string. 
    public static Queue<String> RPN_Form (String input) {
        // for numbers and also output
        Queue<String> output = new LinkedList<>(); 
        // for operations
        Stack<String> operations = new Stack<>(); 
        //get rid of spaces
        String noSpace = input.replaceAll("\\s+", ""); 

        // boolean for expecting operands
        boolean operandExpected = true; 

        // looping through input
        for (int i = 0; i < noSpace.length(); i++) {
            int currentSpot = i; 
            // if current character is a digit
            if (Character.isDigit(noSpace.charAt(i))) {
                operandExpected = false; // no more operands needed 
                String token = ""; 
                // while loop for multi-digit number inputs 
                while (currentSpot < noSpace.length() && Character.isDigit(noSpace.charAt(currentSpot))) {
                    token = token + noSpace.charAt(currentSpot); 
                    currentSpot++;
                    if (currentSpot == noSpace.length()) {
                        break; 
                    }
                }
                i = currentSpot - 1; 
                // add number to the output queue
                output.add(token);
            } else if (noSpace.charAt(i) == '(') {
                //if it's a (, then add it to the operations stack
                operandExpected = true;  // operands needed for opening parenthesis 
                operations.add(noSpace.charAt(i) + ""); 
            } else if (noSpace.charAt(i) == ')') {
                operandExpected = false; //finsihed with parenthesis so done with operands
                // if it's a ), add everything in the operations stack to the output queue until we reach (
                while(!operations.peek().equals("(")) {
                    output.add(operations.pop()); 
                }
                //remove (
                operations.pop(); 
            } else if (noSpace.charAt(i) == '|') {
                //for opening abs, add to operations
                if (operandExpected) {
                    operandExpected = true; 
                    operations.add("|"); 
                } else {
                   // if closing abs, move all elements up until the opening abs in the operations stack to the output queue
                    while (!operations.peek().equals("|")) {
                        output.add(operations.pop()); 
                    }
                    // move opening abs to output queue as well
                    output.add(operations.pop()); 
                    operandExpected = false; 
                    // System.out.println("output: " + output); 
                } 
                // System.out.println("output: " + output); 
                // System.out.println("ops: " + operations);
                // System.out.println();  
            // handling negative inputs
            } else if (noSpace.charAt(i) == '-' && operandExpected) {
                operandExpected = true; // operand expected in order to consider negative
                String token = ""; 
                currentSpot++;  
                while (currentSpot < noSpace.length() && Character.isDigit(noSpace.charAt(currentSpot))) {
                    token = token + noSpace.charAt(currentSpot); 
                    currentSpot++;
                    if (currentSpot == noSpace.length()) {
                        break; 
                    }
                }
                i = currentSpot - 1; 
                output.add("-" + token);
                operandExpected = false; // operand no longer expected after input of negative number
            // handling operation
            } else if (noSpace.charAt(i) == 's') {
                operandExpected = true; 
                operations.add("root"); 
                
                while (noSpace.charAt(i+1) != ')') {
                    i = i + 1; 
                    if (noSpace.charAt(i) == '(') {
                        continue;
                    } else if (Character.isDigit(noSpace.charAt(i))) {
                        // multi-digit input handling
                        String token = noSpace.charAt(i) + ""; 
                        while (i != noSpace.length()-1 && Character.isDigit(noSpace.charAt(i+1))) {
                            token = token + noSpace.charAt(i+1); 
                            i = i + 1; 
                        }
                        output.add(token); 
                        System.out.println("nums " + operations); 
                        System.out.println("nums " + output); 
                    } else {
                        if (operations.peek().equals("root")) {
                            operations.add(noSpace.charAt(i) + ""); 
                            System.out.println("root top of op " + operations); 
                            System.out.println("root top of op " + output); 
                        } else {
                            while (!operations.isEmpty() && Precedence.get(operations.peek()) >= Precedence.get(noSpace.charAt(i) + "")) {
                                output.add(operations.pop()); 
                            }
                            System.out.println("root NOT top of op " + operations); 
                            System.out.println("root NOT top of op " + output); 
                            operations.add(noSpace.charAt(i) + ""); 
                        }
                    }
                }

                while (!operations.peek().equals("root")) {
                    output.add(operations.pop()); 
                    
                }
                output.add(operations.pop()); 
                i = i + 1; 
                operandExpected = false; 

            } else {
                operandExpected = true; // operand expected to complete operation
                char oper = noSpace.charAt(i); // inputted operation

                // adding to rpn
                while (!operations.isEmpty() && Precedence.get(operations.peek()) >= Precedence.get(oper + "")) {
                    output.add(operations.pop());
                }
                operations.add(oper + "");

                // System.out.println("output: " + output); 
                // System.out.println("ops: " + operations); 
                // System.out.println();
            }
        }

        if (operandExpected) {
            System.out.println("Unfinished Expression. Try Again."); 
        }

        // completing the move from stack to queue
        while (!operations.isEmpty()) {  
            output.add(operations.pop()); 
        }
        System.out.println(output); 
        return output; 
    }

    public static double eval_RPN (Queue<String> rpn) {
        Stack<Double> solver = new Stack<>();
        while (!rpn.isEmpty()) {
            if (isNum(rpn.peek())) {
                solver.add(Double.parseDouble(rpn.poll()));
            } else {
                if (!solver.isEmpty()) {
                    switch (rpn.poll()) {
                        case "+" -> { 
                            double unitOne = solver.pop();
                            double unitTwo = solver.pop(); 
                            solver.push(unitOne + unitTwo); 
                            break; 
                        }
                        case "-" -> { 
                            double unitOne = solver.pop();
                            double unitTwo = solver.pop();
                            solver.push(unitTwo - unitOne);
                            break; 
                        }
                        case "*" -> {
                            double unitOne = solver.pop();
                            double unitTwo = solver.pop(); 
                            solver.push(unitOne * unitTwo); 
                            break; 
                        }
                        case "/" -> { 
                            double unitOne = solver.pop();
                            double unitTwo = solver.pop(); 
                            solver.push(unitTwo / unitOne); 
                            break; 
                        } 
                        case "^" -> {
                            double unitOne = solver.pop(); 
                            double unitTwo = solver.pop();
                            solver.push(Math.pow(unitTwo, unitOne)); 
                        }
                        case "|" -> {
                            Double unit = solver.pop(); 
                            solver.push(Math.abs(unit)); 
                        } 
                        case "root" -> {
                            Double unit = solver.pop(); 
                            solver.push(Math.sqrt(unit)); 
                        }
                    }
                }
            }
        } 
        return solver.peek(); 
    }

    private static boolean isNum (String str) {
        if (str == null) {
            return false; 
        }

        try {
            Double.parseDouble(str); 
            return true; 
        } catch (NumberFormatException nfe) {
            return false; 
        }
    }
}
