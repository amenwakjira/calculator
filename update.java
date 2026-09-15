package calc; 
import java.util.*;  

public class update {


    public static final HashMap<String, Integer> Precedence = new HashMap<>(); 

    static {
        Precedence.put("+", 1); 
        Precedence.put("-", 1); 
        Precedence.put("*", 2); 
        Precedence.put("/", 2); 
    }
    
    // using Shunting Yard Algorithm to get RPN form of inputed string. 
    public static Queue<String> RPN_Form (String input) {
        // for numbers and also output
        Queue<String> output = new LinkedList<>(); 
        // for operations
        Stack<String> operations = new Stack<>(); 
        String noSpace = input.replaceAll("\\s+", ""); 

        for (int i = 0; i < noSpace.length(); i++) {
            int currentSpot = i; 
            if (Character.isDigit(noSpace.charAt(i))) {
                String token = ""; 
                while (i < noSpace.length() && Character.isDigit(noSpace.charAt(currentSpot))) {
                    token = token + noSpace.charAt(currentSpot); 
                    currentSpot++;
                    if (currentSpot == noSpace.length()) {
                        break; 
                    }
                }
                i = currentSpot - 1; 
                output.add(token); 
            } else {
                char oper = noSpace.charAt(i); 
                if (!operations.isEmpty()) {
                    int topValue = Precedence.get(operations.peek()); 
                    while (topValue > Precedence.get(oper + "") && !operations.isEmpty()) { 
                        topValue = Precedence.get(operations.peek()); 
                        output.add(operations.pop()); 
                    }
                    operations.add(oper + "");
                } else {
                    operations.add(oper + ""); 
                }
            }
        }

        while (!operations.isEmpty()) {  
            output.add(operations.pop()); 
        }
        return output; 
    }

    public static double eval_RPN (Queue<String> rpn) {
        Stack<Double> solver = new Stack<>();
        while (!rpn.isEmpty()) {
            if (isNum(rpn.peek())) {
                solver.add(Double.parseDouble(rpn.poll()));
            } else {
                if (!solver.isEmpty()) {
                    double unitOne = solver.pop();
                    double unitTwo = solver.pop(); 
                    switch (rpn.poll()) {
                        case "+" -> { 
                            solver.push(unitOne + unitTwo); 
                            break; 
                        }
                        case "-" -> { 
                            solver.push(unitTwo - unitOne);
                            break; 
                        }
                        case "*" -> {
                            solver.push(unitOne * unitTwo); 
                            break; 
                        }
                        case "/" -> { 
                            solver.push(unitTwo / unitOne); 
                            break; 
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
