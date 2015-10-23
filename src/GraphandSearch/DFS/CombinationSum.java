package GraphandSearch.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	if (candidates == null || target < 1) {
    		return new ArrayList<List<Integer>>();
    	}
    	Arrays.sort(candidates);
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	List<Integer> list = new ArrayList<Integer>();
    	combinationSumHelper(result, list, 0, candidates, target);
    	return result;
    }
    
    private void combinationSumHelper(List<List<Integer>> result, List<Integer> list, 
    		int pos, int[] nums, int target) {
    	int sum = 0;
    	for (int i = 0; i < list.size(); i++) {
    		sum += list.get(i);
    	}
    	if (sum == target) {
    		result.add(new ArrayList<Integer>(list));
    	} else if (target < sum) {
    		return;
    	}
    	for (int i = pos; i < nums.length; i++) {
    		list.add(nums[i]);
    		combinationSumHelper(result, list, i, nums, target); // notice here
    		list.remove(list.size() - 1);
    	}
    }
}
