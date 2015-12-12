package HighFreq.Array;

/**
 * Created by watershed2106 on 12/11/15.
 */
public class MergeSortedArray {
    /**
     * @param A: sorted integer array A which has m elements,
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] < B[j]) {
                A[k] = B[j];
                j--;
            } else {
                A[k] = A[i];
                i--;
            }
            k--;
        }
        while (j >= 0) {
            A[k] = B[j];
            j--;
            k--;
        }
    }
}
