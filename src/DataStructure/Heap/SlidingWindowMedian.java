package DataStructure.Heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by hao on 15-10-22.
 */
public class SlidingWindowMedian {
    /**
     * @param nums: A list of integers.
     * @return: The median of the element inside the window at each moving.
     */
    /**
     * @param nums: A list of integers.
     * @return: The median of the element inside the window at each moving.
     */
    public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (nums.length == 0) {
            return res;
        }

        if (k == 1) {
            for (int i = 0; i < nums.length; i++) {
                res.add(nums[i]);
            }

            return res;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(1, new MaxHeapComparator());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int median = nums[0];
        for (int i = 1; i < k; i++) {
            median = adjustSize(median, maxHeap, minHeap, nums[i]);
        }
        res.add(median);

        for (int i = k; i < nums.length; i++) {
            int rm = nums[i - k];
            if (rm < median) {
                maxHeap.remove(rm);
            } else if (rm == median) {
                if (maxHeap.size() == minHeap.size()) {
                    median = maxHeap.remove();
                } else {
                    median = minHeap.remove();
                }
            } else {
                minHeap.remove(rm);
            }

            median = adjustSize(median, maxHeap, minHeap, nums[i]);
            res.add(median);
        }

        return res;
    }

    public class MaxHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            return b - a;
        }
    }

    private int adjustSize(int median, PriorityQueue<Integer> maxHeap,
                           PriorityQueue<Integer> minHeap, int num) {
        if (num < median) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        if (minHeap.size() == maxHeap.size() ||
                minHeap.size() == maxHeap.size() + 1) {
            return median;
        } else if (minHeap.size() < maxHeap.size()) {
            minHeap.offer(median);
            median = maxHeap.remove();
        } else {
            maxHeap.offer(median);
            median = minHeap.remove();
        }

        return median;
    }
}
