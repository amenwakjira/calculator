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

        //counter for the number of |
        int absCounter = 0; 

        // looping through input
        for (int i = 0; i < noSpace.length(); i++) {
            int currentSpot = i; 
            // if current character is a digit
            if (Character.isDigit(noSpace.charAt(i))) {
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
               operations.add(noSpace.charAt(i) + ""); 
            } else if (noSpace.charAt(i) == ')') {
                // if it's a ), add everything in the operations stack to the output queue until we reach (
                while(!operations.peek().equals("(")) {
                    output.add(operations.pop()); 
                }
                //remove (
                operations.pop(); 
            } else if (noSpace.charAt(i) == '|') {
                //if it's a |, add to the counter for |
                absCounter = absCounter + 1; 
                // if the counter is an even number, add everything in operation stack to the output queue until |
                if (absCounter % 2 == 0) {
                    while (!operations.isEmpty() && !operations.peek().equals("|")) {
                        output.add(operations.pop() + "");  
                    } 

                    // cover case that operations stack is empty
                    if (operations.isEmpty()) {
                        operations.add("|"); 
                    }
                } else {
                    // if we have encountered only one |, then just add to the operations stack
                    operations.add("|"); 
                }
            // handling negative inputs
            } else if (noSpace.charAt(i) == '-' && (i == 0 || noSpace.charAt(i - 1) == '(' || !Character.isDigit(noSpace.charAt(i - 1)))) {
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
            // handling operation
            } else {
                char oper = noSpace.charAt(i); 
                //disregarding precedence for |
                if (!operations.isEmpty() && operations.peek().equals("|") && absCounter % 2 == 0) {
                    output.add(operations.pop()); 
                }
                //comparing precedences to add to output queue from operations stack
                if (!operations.isEmpty()) {
                    int topValue = Precedence.get(operations.peek()); 
                    while (!operations.isEmpty() && topValue > Precedence.get(oper + "")) { 
                        topValue = Precedence.get(operations.peek()); 
                        output.add(operations.pop()); 
                    }
                    operations.add(oper + "");
                } else {
                    operations.add(oper + ""); 
                }
            }
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
