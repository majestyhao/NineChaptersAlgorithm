package HighFreq.SubArraySum;

import java.util.ArrayList;

/**
 * Created by hao on 15-10-29.
 */
public class ContinuousSubarraySum {
    /**
     * @param nums an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySum(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }

        int[] sums = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            sums[i] = sum;
        }

        int sumsMin = 0, sumsMinIndex = -1;
        int globalMax = Integer.MIN_VALUE, globalMaxIndex = -1;
        for (int i = 0; i < n; i++) {
            if (sums[i] - sumsMin > globalMax) {
                globalMaxIndex = i;
                globalMax = sums[i] - sumsMin;
                res.clear();
                res.add(sumsMinIndex + 1);
                res.add(globalMaxIndex);
            }
            if (sums[i] < sumsMin) {
                sumsMin = sums[i];
                sumsMinIndex = i;
            }
        }

        return res;
    }
}
