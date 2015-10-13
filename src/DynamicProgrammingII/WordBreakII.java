package DynamicProgrammingII;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by watershed2106 on 10/13/15.
 */
public class WordBreakII {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> list = new ArrayList<String>();
        List<List<String>> res = new ArrayList<List<String>>();
        int n = s.length();
        boolean[] flag = new boolean[n];
        ArrayList<String>[] dp = new ArrayList[n];
        wordBreakHelper(0, list, res, s, wordDict, flag, dp);

        List<String> result = new ArrayList<String>();
        for (int i = 0; i < res.size(); i++) {
            String subS = new String(res.get(i).get(0));
            //System.out.print(subS);
            for (int j = 1; j < res.get(i).size(); j++) {
                subS += " " + res.get(i).get(j);
            }
            result.add(subS);
        }

        return result;
    }

    private void wordBreakHelper(int pos, List<String> list, List<List<String>> res,
                                 String s, Set<String> wordDict, boolean[] flag, List<String>[] dp) {
        if (pos < s.length() && flag[pos]) {
            list.addAll(dp[pos]);
            res.add(new ArrayList<String>(list));
            return;
        }

        if (pos == s.length()) {
            res.add(new ArrayList<String>(list));
            //System.out.println();
            return;
        }

        for (int i = pos; i < s.length(); i++) {
            String subStr = s.substring(pos, i + 1);
            if (wordDict.contains(subStr)) {
                list.add(subStr);
                wordBreakHelper(i + 1, list, res, s, wordDict, flag, dp);
                list.remove(list.size() - 1);
            }
        }
        dp[pos] = new ArrayList<String>(list);
        flag[pos] = true;
    }
}
