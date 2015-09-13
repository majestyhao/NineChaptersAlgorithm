import java.util.ArrayList;

public class SolveNQueens {
	/**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<String>> solveNQueens(int n) {
    //ArrayList<ArrayList<Integer>> solveNQueens(int n) {
    	/* observations: 1. 組合而非排列(不用區分Q, 不用17和71)
    	 * 2. 用1維數組配合XY21D, 把所在位置的組合作爲樹杈, 樹高4?
    	 * 3. 斜線"座標" = x - y
    	 * 4. x_a != x_b, y_a != y_b, x_a - y_a != x_b - y_b 
    	 */
    	if (n < 1) {
    		return new ArrayList<ArrayList<String>>();
    		//return new ArrayList<ArrayList<Integer>>();
    	}
    	if (n == 1) {
    		ArrayList<String> tmp = new ArrayList<String>();
    		tmp.add("Q");
    		ArrayList<ArrayList<String>> tmpp = new ArrayList<ArrayList<String>>();
    		tmpp.add(tmp);
    		return tmpp;
    	}
    	int[] nums = new int[n];
    	for (int i = 0; i < n; i++) {
    		nums[i] = i;
    	}
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	solveNQueensHelper(result, list, 0, nums, n);
    	ArrayList<ArrayList<String>> resultStr = result2Str(result, n);
    	//return result;
    	//System.out.println(result);
    	return resultStr;
    }
    
    private ArrayList<ArrayList<String>> result2Str(ArrayList<ArrayList<Integer>> result, int n) {
    	ArrayList<ArrayList<String>> resultStr = new ArrayList<ArrayList<String>>();
    	for (int i = 0; i < result.size(); i++) {
    		ArrayList<String> stringArr = new ArrayList<String>();
    		for (int j = 0; j < n; j++) {
    			int[] xy = index2XY(result.get(i).get(j), n);
    			char[] string = new char[n];
    			for (int k = 0; k < n; k++) {
    				if (k == xy[1]) {
    					string[k] = 'Q';
    				} else {
    				string[k] = '.';
    				}
    			}
    			//System.out.println(string);
    			stringArr.add(String.valueOf(string));
    		}
    		//System.out.print(stringArr);
    		resultStr.add(stringArr);
    	}
    	return resultStr;
    }
    
    private int[] index2XY(int index, int n) {
    	int[] xy = new int[2];
    	xy[0] = index / n;
    	xy[1] = index % n;
    	return xy;
    }
    
    private void solveNQueensHelper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, 
    		int depth, int[] nums, int n) {
    	if (list.size() == n) {
    		result.add(new ArrayList<Integer>(list));
    		return;
    	}
    	int[] xy1, xy2;
    	boolean flag = false;
    	for (int i = 0; i < n; i++) {
    		xy1 = index2XY(depth * n + i , n);
    		//System.out.println(depth * n + i);
    		//System.out.print(xy1[0]);
    		//System.out.println(xy1[1]);
    		for (int j = 0; j < list.size(); j++) {
    			xy2 = index2XY(list.get(j), n);
    			if (xy1[1] == xy2[1] 
    					|| xy1[0] - xy1[1] == xy2[0] - xy2[1]
    							|| xy1[0] + xy1[1] == xy2[0] + xy2[1]) {
    				flag = true;
    				break;
    			}
    		}
    		if (flag) {
    			flag = false;
    			continue;
    		}
    		//System.out.print(xy1);
    		//System.out.println(xy2);
    		list.add(depth * n + i);
			solveNQueensHelper(result, list, depth + 1, nums, n);
			list.remove(list.size() - 1);
    	}
    }
}
