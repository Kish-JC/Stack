import java.util.Scanner;
import java.util.Stack;

public class DelimiterChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a sequence of characters: ");
        String input = scanner.nextLine();
        
        System.out.println("Input: " + input);
        System.out.println();
        
        checkDelimiters(input);
        
        scanner.close();
    }

    public static void checkDelimiters(String sequence) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < sequence.length(); i++) {
            char ch = sequence.charAt(i);
            
            if (ch == '(' || ch == '[' || ch == '{') {
                System.out.println("Read: " + ch);
                stack.push(ch);
                System.out.println("Operation: PUSH");
                printStack(stack);
                System.out.println();
            }
            else if (ch == ')' || ch == ']' || ch == '}') {
                System.out.println("Read: " + ch);
                
                if (stack.isEmpty()) {
                    System.out.println("Invalid");
                    System.out.println("Reason: closing delimiter has no matching opening delimiter");
                    return;
                }
                
                char top = stack.peek();
                System.out.println("Operation: PEEK -> " + top);
                
                if ((ch == ')' && top != '(') || 
                    (ch == ']' && top != '[') || 
                    (ch == '}' && top != '{')) {
                    System.out.println("Invalid");
                    System.out.println("Reason: mismatched delimiters");
                    return;
                }
                
                stack.pop();
                System.out.println("Operation: POP");
                printStack(stack);
                System.out.println();
            }
        }
        
        if (!stack.isEmpty()) {
            System.out.println("Invalid");
            System.out.println("Reason: unmatched opening delimiter remains");
        } else {
            System.out.println("Valid");
        }
    }

    public static void printStack(Stack<Character> stack) {
        System.out.print("Stack:");
        for (char c : stack) {
            System.out.print(" " + c);
        }
        System.out.println();
    }
}