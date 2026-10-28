import java.util.Scanner;
import java.util.Stack;

        public class DelimiterChecker {
            private static boolean isOpening(char c) {
                return c == '(' || c == '[' || c == '{';
            }

            private static boolean isClosing(char c) {
                return c == ')' || c == ']' || c == '}';
            }

            private static boolean matches(char open, char close) {
                return (open == '(' && close == ')')
                    || (open == '[' && close == ']')
                    || (open == '{' && close == '}');   
            }

            public static String checkDelimiters(String input) {
                if (input == null) {
                    return "Input cannot be null.";
                }

                Stack<Character> stack = new Stack<>();
                String reason = null;   

                for (int i = 0; i < input.length(); i++) {
                    char c = input.charAt(i);

                    if (isOpening(c)) {
                        stack.push(c);
                    } else if (isClosing(c)) {
                        if (stack.isEmpty()) {
                            reason = "Closing delimiter '" + c + "' at position " + i
                                + " has no matching opening delimiter.";
                            break;
                        }

                        char top = stack.peek();

                        if (!matches(top, c)) {
                            reason = "Mismatched delimiters: found '" + c + "' at position " + i
                                + " but the most recent opening delimiter was '" + top + "'.";
                            break;
                        }

                        stack.pop();
                    }
                }

                if (reason == null && !stack.isEmpty()) {
                    reason = "Unmatched opening delimiter remains: '" + stack.peek() + "' ("
                        + stack.size() + " unclosed).";
                }

                return reason;
            }

            public static void main(String[] args) {
                try (Scanner scanner = new Scanner(System.in)) {
                    System.out.print("Enter a sequence of characters: ");
                    String input = scanner.hasNextLine() ? scanner.nextLine() : "";

                    String reason = checkDelimiters(input);

                    if (reason == null) {
                        System.out.println("Valid");
                    } else {
                        System.out.println("Invalid");
                        System.out.println("Reason: " + reason);
                    }
                }
            }
        }