package DynamicProgrammingII;

import java.util.ArrayList;

/**
 * Created by hao on 15-10-28.
 */
public class KthLargestElement {
    //param k : description of k
    //param numbers : array of numbers
    //return: description of return
    public int kthLargestElement(int k, ArrayList<Integer> nums) {
        int left = 0, right = nums.size() - 1; k = nums.size() - k;
        while (left < right) {
            int index = partition(left, right, nums);
            if (index < k) {
                left = index + 1;
            } else if (index > k) {
                right = index - 1;
            } else {
                return nums.get(index);
            }
        }

        return nums.get(left);
    }

    private int partition(int left, int right, ArrayList<Integer> nums) {
        int mid = left + (right - left) / 2;
        int pivot = left;
        swap(left, mid, nums);
        while (left <= right) {
            while (left <= right && nums.get(left) <= nums.get(pivot)) {
                left++;
            }
            while (left <= right && nums.get(right) >= nums.get(pivot)) {
                right--;
            }
            if (left <= right) {
                swap(left, right, nums);
            }
        }

        swap(pivot, right, nums);
        return right;
    }

    private void swap(int i, int j, ArrayList<Integer> nums) {
        int tmp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, tmp);
    }
}
