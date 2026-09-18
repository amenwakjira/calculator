package calc; 
import java.util.*;  

public class main {
    public static void main(String[] args) {

        System.out.println("Welcome! Enter Q to exit calculator! Please enter your expression!"); 
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        while (!input.equals("Q")) { 
            double answer = update.eval_RPN(update.RPN_Form(input)); 
            System.out.println(answer); 
            System.out.println("Please enter your expression!"); 
            input = sc.nextLine();
        }
        sc.close(); 

    //     System.out.println("r - Root");
    //     System.out.println("Abs - Absolute Value"); 
    //     System.out.println("Mod - Modulo"); 
    //     System.out.println("Log - Logrithm (for ln, use -1 as input for base)"); 
    //     System.out.println("SIN - Sine");
    //     System.out.println("COS - Cosine");
    //     System.out.println("TAN - Sine");
    //     System.out.println("X - Exit"); 
    //     System.out.println(); 
    }
}
