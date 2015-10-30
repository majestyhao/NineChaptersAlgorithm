package HighFreq;

/**
 * Created by hao on 15-10-30.
 */
public class PermutationIndex {
    /**
     * @param nums an integer array
     * @return a long integer
     */
    public long permutationIndex(int[] nums) {
        long factor = 1;
        long res = 0;
        for (int i = nums.length - 2, pos = 1; i >= 0; i--) {
            long count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    count++;
                }
            }
            res += factor * count;
            factor *= ++pos;
        }

        return res + 1;
    }
}
