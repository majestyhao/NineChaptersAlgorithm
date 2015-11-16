package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by watershed2106 on 11/15/15.
 */
public class LargestNumber {
    /**
     * @param num: A list of non negative integers
     * @return: A string
     */
    public String largestNumber(int[] num) {
        if (num.length == 0) {
            return "";
        }
        String[] nums = new String[num.length];
        for (int i = 0; i < num.length; i++) {
            nums[i] = Integer.toString(num[i]);
        }
        Arrays.sort(nums, new NumComparator());

        if (Integer.parseInt(nums[0]) == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length; i++) {
            //System.out.println(nums[i]);
            List<Integer> numsL = new ArrayList<>();
            int n = Integer.parseInt(nums[i]);
            if (n == 0) {
                numsL.add(0);
            }
            while (n != 0) {
                numsL.add(n % 10);
                n /= 10;
            }
            for (int j = numsL.size() - 1; j >= 0; j--) {
                sb.append(numsL.get(j).toString());
            }
        }

        return sb.toString();
    }

    class NumComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            return (s2 + s1).compareTo(s1 + s2);
        }
    }

    public static void main(String[] args) {
        LargestNumber largestNumber = new LargestNumber();
        /*int[] num = {1, 20, 23, 4, 8};
        System.out.println(largestNumber.largestNumber(num));
        int[] num2 = {0};
        System.out.println(largestNumber.largestNumber(num2));*/
        int[] num3 = {1,2,3,4,5,6,7,8,9,0};
        System.out.println(largestNumber.largestNumber(num3));
    }
}
