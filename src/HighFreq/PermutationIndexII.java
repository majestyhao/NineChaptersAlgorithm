package HighFreq;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hao on 15-10-30.
 */
public class PermutationIndexII {
    /**
     * @param nums an integer array
     * @return a long integer
     */
    public long permutationIndexII(int[] nums) {
        Map<Integer, Long> factMap = genFactorial();

        long factor = 1;
        long res = 0;
        for (int i = nums.length - 2, pos = 1; i >= 0; i--) {
            long countSmaller = 0, equFact = 1;
            Map<Integer, Integer> counter = new HashMap<>();
            counter.put(nums[i], 1);
            for (int j = i + 1; j < nums.length; j++) {
                if (counter.containsKey(nums[j])) {
                    counter.put(nums[j], counter.get(nums[j]) + 1);
                } else {
                    counter.put(nums[j], 1);
                }
                if (nums[j] < nums[i]) {
                    countSmaller++;
                }
            }
            for (int vis : counter.values()) {
                equFact *= factMap.get(vis);
            }

            res += factor * countSmaller / equFact;
            factor *= ++pos;
        }

        return res + 1;
    }

    private Map<Integer, Long> genFactorial() {
        Map<Integer, Long> res = new HashMap<>();
        long result = 1;
        for (int i = 1; i < 1000; i++) {
            result *= i;
            res.put(i, result);
        }

        return res;
    }

    public static void main(String[] args) {
        PermutationIndexII pm = new PermutationIndexII();
        int[] nums = {2, 2, 3, 2};
        pm.permutationIndexII(nums);
    }
}
