package DataStructure.Hash;

import java.util.HashMap;

/**
 * Created by hao on 15-10-21.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        int globalMax = 0;
        int start = 0;
        for (int i = 0 ; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) >= start) {
                    start = map.get(s.charAt(i)) + 1;
                }
            }
            map.put(s.charAt(i), i);
            globalMax = Math.max(globalMax, i - start + 1);
        }

        return globalMax;
    }
}
