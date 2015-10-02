package BinarySearch;

public class SearchInRotatedSortedArray {
	/** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
	public int search(int[] nums, int target) {
		 int minPos = findMin(nums);
	        int start, end;
	        if (target < nums[0]) {
	            start = minPos;
	            end = nums.length - 1;
	        } else {
	            start = 0;
	            if (minPos == 0) {
	            	end = nums.length - 1;
	            } else {
	            	end = minPos - 1;
	            }
	        }
	        
	        while (start + 1 < end) {
	            int mid = start + (end - start) / 2;
	            if (nums[mid] == target) {
	                end = mid;
	            } else if (nums[mid] < target) {
	                start = mid;
	            } else {
	                end = mid;
	            }
	        }
	        
	        if (nums[start] == target) {
	            return start;
	        }
	        if (nums[end] == target) {
	            return end;
	        }
	        return -1;
	    }
	    
	    private int findMin(int[] nums) {
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
