package DataStructure.Hash;

import java.util.HashMap;

/**
 * Created by hao on 15-10-21.
 */
public class LongestSubstringwithAtMostKDistinctCharacters {
    /**
     * @param s : A string
     * @return : The length of the longest substring
     *           that contains at most k distinct characters.
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        int start = 0, globalMax = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
                while (map.size() > k) {
                    char startChar = s.charAt(start++);
                    int count = map.get(startChar);
                    if (count > 1) {
                        map.put(startChar, count - 1);
                    } else {
                        map.remove(startChar);
                    }
                }
            }

            globalMax = Math.max(globalMax, i - start + 1);
        }

        return globalMax;
    }
}
