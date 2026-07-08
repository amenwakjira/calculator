package calc; 
import java.math.*; 
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
        Queue<String> output = new LinkedList<>(); 
        Stack<String> operations = new Stack<>(); 
        String noSpace = input.replaceAll("\\s+", ""); 

        for (int i = 0; i < noSpace.length(); i++) {
            char token = noSpace.charAt(i);
            if (Character.isDigit(token)) {
                StringBuilder sb =  new StringBuilder(); 
                sb.append(token); 
                int skipto = i; 
                while (skipto < noSpace.length() - 1 && Character.isDigit(noSpace.charAt(skipto + 1))) {
                    sb.append(noSpace.charAt(skipto + 1)); 
                    skipto++; 
                }
                i = skipto;
                System.out.println(sb); 
                output.add(sb + ""); 
            } else {
                if (!operations.isEmpty()) {
                    System.out.println(operations.peek()); 
                    int topValue = Precedence.get(operations.peek()); 
                    while (topValue > Precedence.get(token + "") && !operations.isEmpty()) { 
                        topValue = Precedence.get(operations.peek()); 
                        output.add(operations.pop()); 
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
