package DynamicProgrammingI;

public class ValidPalindrome {
	/**
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
    	if (s == null) {
    		return true;
    	}
    	
    	for (int i = 0, j = s.length() - 1; i < j;) {
    		if (!(s.charAt(i) < 'z' && s.charAt(i) > 'A')) {
    			i++;
    		} else if (!(s.charAt(j) < 'z' && s.charAt(j) > 'A')){
    			j--;
    		} else if (s.charAt(i) != s.charAt(j) 
    				&& Math.abs(s.charAt(i) - s.charAt(j)) != Math.abs('A' - 'a')) {
    			return false;
    		} else {
    			i++;
    			j--;
    		}
    	}
    	
    	return true;
    }

}
