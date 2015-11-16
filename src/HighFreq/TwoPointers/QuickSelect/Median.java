package HighFreq.TwoPointers.QuickSelect;

/**
 * Created by hao on 15-10-28.
 */
public class Median {
    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public int median(int[] nums) {
        int k = nums.length / 2;
        if (nums.length % 2 == 0) {
            k--;
        }
        int left = 0, right = nums.length - 1;
        while (left < right){
            int index = partition(left, right, nums);
            if (index < k) {
                left = index + 1;
            } else if (k < index) {
                right = index - 1;
            } else {
                return nums[index];
            }
        }

        return nums[left];
    }

    private int partition(int left, int right, int[] nums) {
        int pivot = left;
        while (left <= right) {
            left++;
            while (left <= right && nums[left] < nums[pivot]) {
                left++;
            }
            while (left <= right && nums[pivot] < nums[right]) {
                right--;
            }
            if (left <= right) {
                swap(left, right, nums);
            }
        }

        swap(pivot, left - 1, nums);
        return left - 1;
    }

    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
