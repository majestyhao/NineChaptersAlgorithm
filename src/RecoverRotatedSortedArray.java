import java.util.ArrayList;

public class RecoverRotatedSortedArray {
	/**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
    	if (nums == null) {
    		return;
    	}
    	int partition = 0;
    	for (int i = 0; i < nums.size() - 1; i++) {
    		if (nums.get(i) > nums.get(i + 1)) {
    			partition = i;
    			break;
    		}
    	}
    	
    	if (partition == 0) {
    		return;
    	}
    	
    	reverse(nums, 0, partition);
    	reverse(nums, partition + 1, nums.size() - 1);
    	reverse(nums, 0, nums.size() - 1);
    	//System.out.print(nums);
    }
    
    private void reverse(ArrayList<Integer> nums, int start, int end) {
    	for (int i = start, j = end; i < j; i++, j--) {
    		int tmp = nums.get(i);
    		nums.set(i, nums.get(j));
    		nums.set(j, tmp);
    	}
    }
}
