package DataStructure.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by hao on 15-10-20.
 */
public class ConvertExpressiontoReversePolishNotation {
    /**
     * @param expression: A string array
     * @return: The Reverse Polish notation of this expression
     */
    public ArrayList<String> convertToRPN(String[] expression) {
        ExpressionTreeNode root = build(expression);
        ArrayList<String> res = (ArrayList)postOrder(root);
        if (res == null) {
            return new ArrayList<String>();
        }
        return res;
    }

    class MyTreeNode {
        int priority;
        ExpressionTreeNode exprNode;
        MyTreeNode(int priority, String op) {
            this.priority = priority;
            exprNode = new ExpressionTreeNode(op);
        }
    }

    public ExpressionTreeNode build(String[] expression) {
        if (expression.length == 0) {
            return null;
        }

        Stack<MyTreeNode> stack = new Stack<MyTreeNode>();
        int paraEffect = 0;
        MyTreeNode node = null;
        for (int i = 0; i < expression.length + 1; i++) {
            String op;
            if (i == expression.length) {
                op = "~";
            } else {
                op = expression[i];
            }

            if (op.equals("(") || op.equals(")")) {
                int plus = expression[i].equals("(")? 10: -10;
                paraEffect += plus;
                continue;
            }

            int priority = getPriority(op, paraEffect);
            node = new MyTreeNode(priority, op);
            while (!stack.isEmpty() && priority <= stack.peek().priority) {
                MyTreeNode prev = stack.pop();
                if (!stack.isEmpty() && priority <= stack.peek().priority) {
                    stack.peek().exprNode.right = prev.exprNode;
                } else {
                    node.exprNode.left = prev.exprNode;
                }
            }
            stack.push(node);
        }

        return node.exprNode.left;
    }

    private int getPriority(String op, int paraEffect) {
        if (op.equals("+") || op.equals("-")) {
            return 1 + paraEffect;
        } else if (op.equals("*") || op.equals("/")) {
            return 2 + paraEffect;
        } else if (op.equals("~")){
            return Integer.MIN_VALUE;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public class ExpressionTreeNode {
        public String symbol;
        public ExpressionTreeNode left, right;
        public ExpressionTreeNode(String symbol) {
            this.symbol = symbol;
            this.left = this.right = null;
        }
    }

    private List<String> postOrder(ExpressionTreeNode head) {
        if (head == null) {
            return null;
        }

        List<String> res = new ArrayList<String>();
        if (head.left != null) {
            res.addAll(postOrder(head.left));
        }
        if (head.right != null) {
            res.addAll(postOrder(head.right));
        }
        res.add(head.symbol);

        return res;
    }
}
