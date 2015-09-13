package DynamicProgrammingI;

public class JumpGameII {
	/**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
    	int n = A.length;
    	int[] f = new int[n];
    	
    	// init
    	f[0] = 0;
    	
    	// loop
    	for (int i = 1; i < n; i++) {
    		f[i] = Integer.MAX_VALUE;
    		for (int j = 0; j < i; j++) {
    			if (f[j] < f[i] && j + A[j] >= i) {
    				f[i] = f[j] + 1;
    			}
    		}
    	}
    	
    	// end
    	return f[n - 1];
    }
}
