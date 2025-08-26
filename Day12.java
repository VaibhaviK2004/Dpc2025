import java.util.*;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            // Push opening brackets
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } 
            // Check closing brackets
            else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) return false; // No matching opening
                
                char top = stack.pop(); // Last opened bracket
                
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false; // Mismatched
                }
            }
        }
        
        // If stack is empty, all brackets matched
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String input = "[{()}]";
        System.out.println(isValid(input)); // true
    }
}
