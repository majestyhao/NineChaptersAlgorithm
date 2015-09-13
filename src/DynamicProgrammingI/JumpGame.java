package DynamicProgrammingI;

public class JumpGame {
	/**
     * @param A: A list of integers
     * @return: The boolean answer
     */
	public boolean canJump(int[] A) {
    	int n = A.length;
    	// do not use int[], since f[i] == 0 + A[j - 1] still
    	// possible to >= i
    	boolean[] f = new boolean[n + 1]; 
    	
    	// init
    	f[0] = true;
    	f[1] = true;
    	
    	// loop
    	for (int i = 2; i <= n; i++) {
    		f[i] = false;
    		for (int j = 1; j < i; j++) {
    			if (f[j] == true && (j + A[j - 1] >= i)) {
    				f[i] = true;
    			}
    		}
    	}
    	
    	return f[n];
    }

}
