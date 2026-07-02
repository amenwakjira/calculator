package calc; 
import java.math.*; 
import java.util.*;  

public class update {

    // private static class Element {
    //     String key; 
    //     Integer value; 

    //     Element (String key, Integer value) {
    //         this.key = key; 
    //         this.value = value; 
    //     }
    // }

    public static final HashMap<String, Integer> Precedence = new HashMap<>(); 

    static {
        Precedence.put("+", 1); 
        Precedence.put("-", 1); 
        Precedence.put("*", 2); 
        Precedence.put("/", 2); 
    }
    
    // using Shunting Yard Algorithm to get RPN form of inputed string. 
    public static Queue<String> RPN_Form (String input) {
        Queue<String> output = new LinkedList<>(); 
        Stack<String> operations = new Stack<>(); 
        String noSpace = input.replaceAll("\\s+", ""); 

        for (int i = 0; i < noSpace.length(); i++) {
            char token = noSpace.charAt(i);
            if (Character.isDigit(token)) {
                output.add(token + ""); 
            } else {
                if (!operations.isEmpty()) {
                    int topValue = Precedence.get(operations.peek()); 
                    while (topValue > Precedence.get(token + "")) { 
                        output.add(operations.pop()); 
                        topValue = Precedence.get(operations.peek()); 
                    }
                    operations.add(token + "");
                } else {
                    operations.add(token + ""); 
                }
            }
        }

        while (!operations.isEmpty()) {
            output.add(operations.pop()); 
        }
        return output; 
    }
}
