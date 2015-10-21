package DataStructure.Stack;

import java.util.Stack;

/**
 * Created by hao on 15-10-20.
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        if (path.length() == 0) {
            return null;
        }
        Stack<Character> stack = new Stack<Character>();
        char[] res = null;
        stack.push('/');
        for (int i = 1; i < path.length(); i++) {
            if (path.charAt(i) == '/') {
                if (stack.peek() == '/') {
                    continue;
                }
                res = new char[stack.size()];
                int j = stack.size() - 1;
                while (!stack.isEmpty()) {
                    res[j] = stack.pop();
                    j--;
                }
            }
            stack.push(path.charAt(i));
        }

        if (!stack.isEmpty()) {
            res = new char[stack.size()];
            int j = stack.size() - 1;
            while (!stack.isEmpty()) {
                res[j] = stack.pop();
                j--;
            }
        }
        if (res == null) {
            return "/";
        }

        int start = 0;
        for (int i = 0; i < res.length; i++) {
            if (res[i] != '.') {
                break;
            } else {
                start++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < res.length; i++) {
            sb.append(res[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SimplifyPath sp = new SimplifyPath();
        System.out.print(sp.simplifyPath("/..."));
    }
}
