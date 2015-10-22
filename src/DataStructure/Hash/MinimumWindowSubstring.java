package DataStructure.Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hao on 15-10-21.
 */
public class MinimumWindowSubstring {
    /**
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window
     *          Return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        for (int i = 0; i < target.length(); i++) {
            if (count.containsKey(target.charAt(i))) {
                count.put(target.charAt(i), count.get(target.charAt(i)) + 1);
            } else {
                count.put(target.charAt(i), 1);
            }
        }

        int counter = 0, start = 0;
        String res = "";
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            if (count.containsKey(c)) {
                count.put(c, count.get(c) - 1);
                if (count.get(c) >= 0) {
                    counter++;
                }
                if (counter == target.length()) {
                    while (start <= i) {
                        char startChar = source.charAt(start);
                        if (count.containsKey(startChar)) {
                            if (count.get(startChar) < 0) {
                                count.put(startChar, count.get(startChar) + 1);
                            } else {
                                break;
                            }
                        }
                        start++;
                    }
                    if (i - start + 1 < len) {
                        len = i - start + 1;
                        res = source.substring(start, start + len);
                    }
                }
            }
        }


        return res;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring mw = new MinimumWindowSubstring();
        System.out.print(mw.minWindow("abcde", "bd"));
    }
}
