
public class SearchInRotatedSortedArray {
	/** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
	public int search(int[] A, int target) {
		if (A.length == 0) {
			return -1;
		}
		
		int start, end;
		int tmp = findMin(A);
		System.out.print(tmp);
		if (tmp == 0) {
			start = 0; end = A.length - 1;
		} else if (target > A[0]) {
			start = 0; end = findMin(A) - 1;
		} else {
			start = findMin(A); end = A.length - 1;
		}
		
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (A[mid] == target) {
				end = mid;
			} else if (A[mid] < target) {
				start = mid;
			} else {
				end = mid;
			}
		}
		
		if (A[start] == target) {
			return start;
		} else if (A[end] == target) {
			return end;
		} else {
			return -1;
		}
    }
	
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
    	
    	if (start != nums.length - 1 && nums[start] > nums[start + 1]) {
    		return start + 1;
    	} else if (end != nums.length - 1 && nums[end] > nums[end + 1]) {
    		return end + 1;
    	} else if (nums.length > 1 && nums[0] > nums[1]) {
    		return 1;
    	} else {
    		return 0;
    	}
    }
}
