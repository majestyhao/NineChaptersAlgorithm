package DataStructure.Stack;

import java.util.Stack;

/**
 * Created by hao on 15-10-20.
 */
public class SimplifyPath {
    /**
     * @param path the original path
     * @return the simplified path
     */
    public String simplifyPath(String path) {
        if (path.length() == 0) {
            return null;
        }

        String[] parts = path.split("/");
        Stack<String> stack = new Stack<String>();
        for (String s : parts) {
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (s.length() == 0 || s.equals(".")) {
                continue;
            } else {
                stack.push(s);
            }
        }

        StringBuilder str = new StringBuilder();
        if (stack.isEmpty()) {
            return "/";
        }
        while (!stack.isEmpty()) {
            str.append("/").append(stack.remove(0));
        }

        return str.toString();
    }
}
