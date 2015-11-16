package HighFreq.SubArraySum;

import java.util.Arrays;

/**
 * Created by hao on 15-10-29.
 */
public class SubarraySumII {
    /**
     * @param nums an integer array
     * @param s an integer
     * @param t an integer
     * @return the number of possible answer
     */
    public int subarraySumII(int[] nums, int s, int t) {
        int n = nums.length;
        int sum = 0;
        int[] sums = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            sums[i] = sum;
        }
        Arrays.sort(sums);

        for (int i = 0; i < n; i++) {
            if (sums[i] <= t && s <= sums[i]) {
                count++;
            }
            count += search(sums, sums[i] - s + 1) - search(sums, sums[i] - t);
        }

        return count;
    }

    private int search(int[] sums, int target) {
        int start = 0, end = sums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (sums[mid] == target) {
                end = mid;
            } else if (sums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (sums[start] >= target) {
            return start;
        } else if (sums[end] >= target) {
            return end;
        } else {
            return sums.length;
        }
    }

    public static void main(String[] args) {
        SubarraySumII ss = new SubarraySumII();
        //int[] sums = {1, 3, 4, 6, 7, 9, 10};
        //int[] sums = {1, 3, 6, 10};
        //System.out.println(ss.search(sums, -2));
        //System.out.println(ss.search(sums, 1));
        int[] nums = {1, 2, 3, 4};
        ss.subarraySumII(nums, 1, 3);
    }
}
