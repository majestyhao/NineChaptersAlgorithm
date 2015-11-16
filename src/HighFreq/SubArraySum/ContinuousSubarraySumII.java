package HighFreq.SubArraySum;

import java.util.ArrayList;

/**
 * Created by hao on 15-10-29.
 */
public class ContinuousSubarraySumII {
    /**
     * @param nums an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySumII(int[] nums) {
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

        int sumsMax = 0, sumsMaxIndex = -1;
        int globalMin = Integer.MAX_VALUE, globalMinIndex = -1;
        ArrayList<Integer> res2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (sums[i] - sumsMax < globalMin) {
                globalMinIndex = i;
                globalMin = sums[i] - sumsMax;
                res2.clear();
                res2.add(globalMinIndex + 1);
                res2.add(sumsMaxIndex);
            }
            if (sums[i] > sumsMax) {
                sumsMax = sums[i];
                sumsMaxIndex = i;
            }
        }

        if (sums[n - 1] == globalMin) {
            return res;
        }
        return sums[n - 1] - globalMin > globalMax ? res2: res;
    }

    public static void main(String[] args) {
        int[] nums = {-101,-33,-44,-55,-67,-78,-101,-33,-44,-55,-67,-78,-100,-200,-1000,-22,-100,-200,-1000,-22};
        ContinuousSubarraySumII cs = new ContinuousSubarraySumII();
        cs.continuousSubarraySumII(nums);
    }
}
