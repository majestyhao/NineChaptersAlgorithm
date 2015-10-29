package HighFreq.TwoPointers.QuickSelect;

/**
 * Created by hao on 15-10-28.
 */
public class NutsandBolts {
    /**
     * @param nuts: an array of integers
     * @param bolts: an array of integers
     * @param compare: a instance of Comparator
     * @return: nothing
     */
    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        helper(0, bolts.length - 1, nuts, bolts, compare);
    }

    private void helper(int left, int right, String[] nuts, String[] bolts, NBComparator compare) {
        if (right <= left) {
            return;
        }
        int index = partition(left, right, bolts[left], nuts, compare);
        partition(left, right, nuts[index], bolts, compare);
        helper(left, index - 1, nuts, bolts, compare);
        helper(index + 1, right, nuts, bolts, compare);
    }

    private int partition(int left, int right, String target, String[] str, NBComparator compare) {
        int m = left;
        for (int i = left + 1; i <= right; i++) {
            if (compare.cmp(str[i], target) == -1 ||
                    compare.cmp(target, str[i]) == 1) {
                //
                m++;
                swap(i, m, str);
            } else if (compare.cmp(str[i], target) == 0 ||
                    compare.cmp(target, str[i]) == 0) {
                // swap nuts[l]/bolts[l] with pivot
                swap(i, left, str);
                i--;
            }
        }
        // move pivot to proper index
        swap(m, left, str);

        return m;
    }

    private void swap(int i, int j, String[] strs) {
        String tmp = strs[i];
        strs[i] = strs[j];
        strs[j] = tmp;
    }

    public class NBComparator {
        public int cmp(String a, String b) {
            return a.hashCode() - b.hashCode();
        }
    }
}
