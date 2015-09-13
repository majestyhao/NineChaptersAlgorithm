package DynamicProgrammingII;

import java.util.Arrays;
import java.util.HashMap;

public class Backpack {
	/**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
    	int[] result = new int[1]; 
    	int pos = 0;
    	Arrays.sort(A);
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); // 以k为root的子树的最大size是v 
    	backpackHelper(result, map, pos, A, m);
    	return result[0];
    }
    
    private int backpackHelper(int[] result, HashMap<Integer, Integer> map, int pos, int[] A, int m) {
    	if (pos == A.length) {
    		return 0;
    	} 
    	
    	if (map.containsKey(pos)) {
    		return map.get(pos);
    	}
    	
    	int maxSize = 0;
    	for (int i = pos; i < A.length; i++) {
    		int tmp = backpackHelper(result, map, i + 1, A, m);
    		if (tmp + A[pos] <= m && maxSize < tmp) {
    			maxSize = tmp;
    		}
    	}
    	
    	maxSize += A[pos]; 
    	if (maxSize <= m && maxSize > result[0]) {
    		result[0] = maxSize;
    	}
    	map.put(pos, maxSize);
    	return maxSize;
    }
}
