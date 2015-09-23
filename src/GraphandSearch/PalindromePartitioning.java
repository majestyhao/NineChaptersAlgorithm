package GraphandSearch;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	/**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
    	List<List<String>> result = new ArrayList<List<String>>();
    	if (s == null) {
    		return result;
    	}
    	
    	List<String> list = new ArrayList<String>();
    	partitionHelper(0, list, s, result);
    	return result;
    }
    
    private void partitionHelper(int pos, List<String> list, String s, List<List<String>> result) {
    	//System.out.println(list);
    	//System.out.println(subResult);
    	/*for(String substr : subResult) {
    		if (!isPalindrome(substr)) {
    			return;
    		}
    	}
    	result.add(subResult);*/
    	if (pos == s.length()) {
    		result.add(new ArrayList<String>(list));
    		return;
    	}
    	
    	for (int i = pos; i < s.length(); i++) {
    		// substring from beginIndex to endIndex - 1
    		String prefix = s.substring(pos, i + 1);
    		if (!isPalindrome(prefix)) {
    			continue;
    		}
    		list.add(prefix);
    		partitionHelper(i + 1, list, s, result);
    		list.remove(list.size() - 1);
    	}
    }
    
    /*
    private ArrayList<String> getSubStr(String s, List<Integer> partition) {
    	partition.add(s.length());
    	ArrayList<String> result = new ArrayList<String>();
    	for (int i = 0; i < partition.size() - 1; i++) {
    		if (partition.get(i + 1) != 0 ) {
    			//System.out.print(partition.get(i));
    			//System.out.println(partition.get(i + 1) - 1);
    			//System.out.print(' ');
    			result.add(s.substring(partition.get(i), partition.get(i + 1) - 1));
    			//System.out.println(result);
    		} else {
    			result.add(s.substring(0, 0));
}
    	}
    	//System.out.println(' ');
    	partition.remove(partition.size() - 1);
    	return result;
    }*/
    
    private boolean isPalindrome(String str) {
    	for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
    		if (str.charAt(i) != str.charAt(j)) {
    			return false;
    		}
    	}
    	
    	return true;
    }
}
