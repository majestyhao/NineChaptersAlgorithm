package DataStructure.Hash;

import java.util.*;

/**
 * Created by hao on 15-10-21.
 */
public class Anagrams {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        HashMap<String, String> map = new HashMap<String, String>();
        Set<String> set = new HashSet<String>();
        List<String> res = new ArrayList<String>();

        for (int i = 0; i < strs.length; i++) {
            String val = getValue(strs[i]);
            if (map.containsKey(val)) {
                res.add(strs[i]);
                set.add(map.get(val));
            } else {
                map.put(val, strs[i]);
            }
        }

        for (String str : set) {
            res.add(str);
        }

        return res;
    }

    private String getValue(String str) {
        StringBuilder sb = new StringBuilder();
        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                sb.append(i + 'a');
                sb.append(count[i]);
            }
        }

        return sb.toString();
    }
}
