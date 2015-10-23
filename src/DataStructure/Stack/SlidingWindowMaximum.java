package DataStructure.Stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hao on 15-10-23.
 */
public class SlidingWindowMaximum {
    /**
     * @param nums: A list of integers.
     * @return: The maximum number inside the window at each moving.
     */
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        List<Element> list = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            while (list.size() > 0 && list.get(list.size() - 1).val < nums[i]) {
                list.remove(list.size() - 1);
            }
            list.add(new Element(nums[i], i));
            if (list.get(0).index == i - k) {
                list.remove(0);
            }
            if (i < k - 1) {
                continue;
            }
            res.add(list.get(0).val);
        }

        return res;
    }

    class Element {
        int val;
        int index;
        Element(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
}
