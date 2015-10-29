package HighFreq.SubArraySum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hao on 15-10-29.
 */
public class SubmatrixSum {
    /**
     * @param matrix an integer matrix
     * @return the coordinate of the left-up and right-down number
     */
    public int[][] submatrixSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] res = new int[2][2];
        //起始行
        for (int i = 0; i < m; i++) {
            // 从起始行到终止行每一列所有元素的和
            int[] colSums = new int[n];
            // 终止行
            for (int k = i; k < m; k++) {
                int sum = 0;
                Map<Integer, Integer> map = new HashMap<Integer, Integer>();
                for (int j = 0; j < n; j++) {
                    colSums[j] = colSums[j] + matrix[k][j];
                }
                for (int j = 0; j < n; j++) {
                    sum += colSums[j];
                    if (sum == 0) {
                        res[0][0] = i;
                        res[0][1] = 0;
                        res[1][0] = k;
                        res[1][1] = j;
                        return res;
                    } else if (map.containsKey(sum)) {
                        res[0][0] = i;
                        res[0][1] = map.get(sum) + 1;
                        res[1][0] = k;
                        res[1][1] = j;
                        return res;
                    }
                    map.put(sum, j);
                }
            }
        }

        return res;
    }
}
