package BinarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hao on 15-10-29.
 */
public class FindPeakElementII {
    /**
     * @param nums: An integer matrix
     * @return: The index of the peak
     */
    public List<Integer> findPeakII(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;
        List<Integer> res = new ArrayList<>();
        int start = 0, end = m - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int maxIndex = 0 , max = nums[mid][0];
            for (int i = 1; i < n; i++) {
                if (nums[mid][i] > max) {
                    max = nums[mid][i];
                    maxIndex = i;
                }
            }

            if (nums[mid - 1][maxIndex] < nums[mid][maxIndex] &&
                    nums[mid + 1][maxIndex] < nums[mid][maxIndex]) {
                res.add(mid);
                res.add(maxIndex);
                return res;
            } else if (nums[mid][maxIndex] < nums[mid + 1][maxIndex]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return res;
    }
}
