package DataStructure.Stack;

import java.util.Stack;

/**
 * Created by hao on 15-10-20.
 */
public class ValidParentheses {
    /**
     * @param s A string
     * @return whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            switch (cur) {
                case ')': if (!isValid(stack, cur)) {
                    return false;
                }
                    break;
                case ']': if (!isValid(stack, cur)) {
                    return false;
                }
                    break;
                case '}': if (!isValid(stack, cur)) {
                    return false;
                }
                    break;
                default: stack.push(cur);
            }
        }

        return stack.isEmpty();
    }

    private boolean isValid(Stack<Character> stack, char b) {
        if (stack.isEmpty()) {
            return false;
        }
        char a = stack.pop();
        return a == b - 1 || a == b - 2;
    }

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        System.out.print(vp.isValidParentheses("[]()"));
    }
}
