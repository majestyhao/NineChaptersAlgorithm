package DataStructure.Stack;

import java.util.Stack;

/**
 * Created by hao on 15-10-20.
 */
public class EvaluateReversePolishNotation {
    /**
     * @param tokens The Reverse Polish Notation
     * @return the value
     */
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++) {
            if (isOperator(tokens[i])) {
                int op1 = stack.pop(), op2 = stack.pop();
                stack.push(operation(tokens[i], op1, op2));
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }

        return stack.peek();
    }

    private boolean isOperator(String op) {
        return op.equals("*") || op.equals("/") ||
                op.equals("+") || op.equals("-");
    }

    private int operation(String op, int op1, int op2) {
        switch (op) {
            case "+": return op2 + op1;
            case "-": return op2 - op1;
            case "*": return op1 * op2;
            case "/": return op2 / op1;
        }

        return 0;
    }
}
