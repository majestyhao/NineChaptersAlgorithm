package HighFreq.TwoPointers;

/**
 * Created by watershed2106 on 12/31/15.
 */
public class UglyNumber {
    /**
     * @param k: The number k.
     * @return: The kth prime number as description.
     */
    public long kthPrimeNumber(int k) {
        int i3 = 0, i5 = 0, i7 = 0;
        long[] res = new long[k + 1];
        res[0] = 1;
        for (int i = 1; i <= k; i++) {
            res[i] = Math.min(res[i3] * 3, Math.min(res[i5] * 5, res[i7] * 7));
            if (res[i] / res[i3] == 3) {
                i3++;
            }
            if (res[i] / res[i5] == 5) {
                i5++;
            }
            if (res[i] / res[i7] == 7) {
                i7++;
            }
        }

        return res[k];
    }

    public static void main(String[] args) {
        UglyNumber un = new UglyNumber();
        un.kthPrimeNumber(11);
    }
}
