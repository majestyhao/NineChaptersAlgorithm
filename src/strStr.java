class StrStrSolution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
    	// mistake on the role of source and target
    	if (source == null || target == null || target.length() > source.length()) {
    		return -1;
    	}
    	
    	if (target == "") {
    		// totally forgot
    		return 0;
    	}
    	
    	// hesitate at i < source.length() - target.length() + 1
    	for (int i = 0; i < source.length() - target.length() + 1; i++) {
    		for (int j = 0; j < target.length(); ) {
    			if (target.charAt(j) == source.charAt(i + j)) {
    				// error: source.charAt(j) == target.charAt(i)
    				j++;
    				if (j == target.length()) {
    					// make a mistake as j == source.length() + 1
    					return i;
    				}
    			} else {
    				break;
    			}
    		}
    	}
        
        return -1;
    }
}