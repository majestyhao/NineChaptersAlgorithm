package BinarySearch;

public class FindMinInRotatedSortedArray {
	/**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
    	int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[nums.length - 1]) {
                end = mid;
            } else if (nums[mid] > nums[0]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (nums[start] > nums[end]) {
            return end;
        } else {
            return start;
        }
    }
}
