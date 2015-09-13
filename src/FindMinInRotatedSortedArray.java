
public class FindMinInRotatedSortedArray {
	/**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
    	int start = 0, end = nums.length - 1;
    	while (start + 1 < end) {
    		int mid = start + (end - start) / 2;
    		if (nums[mid] > nums[mid + 1]) {
    			end = mid;
    		} else if (nums[mid] > nums[0]) {
    			start = mid;
    		} else {
    			end = mid;
    		}
    	}
    	if (nums[start] > nums[start + 1]) {
    		return nums[start + 1];
    	} else if (end != nums.length - 1 && nums[end] > nums[end + 1]) {
    		return nums[end + 1];
    	} else if (nums.length > 1 && nums[0] > nums[1]) {
    		return nums[1];
    	} else {
    		return nums[0];
    	}
    }
}
