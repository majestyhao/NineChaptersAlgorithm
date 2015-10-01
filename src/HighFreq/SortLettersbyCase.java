package HighFreq;

public class SortLettersbyCase {
	/** 
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
    	int i = 0, j = chars.length - 1;
    	while (i <= j) {
    		while (i <= j && chars[i] <= 'z' && chars[i] >= 'a') {
    			i++;
    		}
    		while (i <= j && chars[j] <= 'Z' && chars[j] >= 'A') {
    			j--;
    		}
    		if (i <= j) {
    			char tmp = chars[i];
    			chars[i] = chars[j];
    			chars[j] = tmp;
    		}
    	}
    }

}
