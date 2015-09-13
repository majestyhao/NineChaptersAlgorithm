package DynamicProgrammingI;

import java.util.Set;

public class WordBreak {
	/**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
    	int n = s.length();
    	// 前i个字符是否是word break
    	boolean[] f = new boolean[n + 1];
    	
    	// a little optimize
    	int maxLen = 0;
    	for (String word: dict) {
    		if (word.length() > maxLen) {
    			maxLen = word.length();
    		}
    	}
    	
    	// init: 
    	f[0] = true;
    	
    	// func: f[j]是否是word break和从j 到i是否是dict里的word
    	for (int i = 1; i <= n; i++) {
    		// 切割点j从0开始, 0表示前面无切割
    		//for (int j = 0; j < i; j++) {
    		for (int j = Math.max(0, i - maxLen); j < i; j++) {
    			// string copy
    			/*char[] substring = new char[i - j]; 
    			for (int k = j + 1; k <= i; k++) {
    				substring[k - j - 1] = s.charAt(k - 1);
    			}*/
    			String substring = s.substring(j, i);
    			//System.out.println(substring);
    			//System.out.println(dict.contains(substring.toString()));
    			if (f[j] && (substring == null || dict.contains(substring))) {
    				f[i] = true; // 只要找到一个即可
    				//System.out.print(i);
    				break;
    			}
    		}
    	}
    	
    	// end
    	return f[n];
    }

}
