package HighFreq.ScanningLine;

import java.util.*;

/**
 * Created by hao on 15-10-28.
 */
public class BuildingOutline {
    /**
     * @param buildings: A list of lists of integers
     * @return: Find the outline of those buildings
     */
    public ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (buildings.length == 0) {
            return res;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>();
        List<Point> list = new ArrayList<Point>();
        for (int i = 0; i < buildings.length; i++) {
            list.add(new Point(buildings[i][0], i, buildings[i][2], true));
            list.add(new Point(buildings[i][1], i, buildings[i][2], false));
        }

        Collections.sort(list, new PointComparator());

        int prevHeight = list.get(0).height;
        ArrayList<Integer> now = null;
        for (Point building : list) {
            if (building.flag) {
                maxHeap.add(-1 * building.height);
            } else {
                maxHeap.remove(-1 * building.height);
            }
            if (maxHeap.isEmpty()) {
                now = new ArrayList<Integer>(Arrays.asList(building.loc, 0));
                res.add(now);
                prevHeight = 0;
            } else if (maxHeap.peek() != prevHeight) {
                now = new ArrayList<Integer>(Arrays.asList(building.loc,
                        -1 * maxHeap.peek()));
                res.add(now);
                prevHeight = maxHeap.peek();
            }
            /*if (building.flag) {
                if (maxHeap.isEmpty() || building.height > -1 * maxHeap.peek()) {
                    now = new ArrayList<Integer>(Arrays.asList(building.loc,
							  building.height));
					res.add(now);
                }
                maxHeap.add(-1 * building.height);
            } else {
                maxHeap.remove(-1 * building.height);
                if (maxHeap.isEmpty() || building.height > -1 * maxHeap.peek()) {
                    if (maxHeap.isEmpty()) {
                        now = new ArrayList<Integer>(Arrays.asList(building.loc,
							  0));
                    } else {
                        now = new ArrayList<Integer>(Arrays.asList(building.loc,
							  -1 * maxHeap.peek()));
                    }
					res.add(now);
                }
            }*/
        }

        return output(res);
    }

    ArrayList<ArrayList<Integer>> output(ArrayList<ArrayList<Integer>> res) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if (res.size() > 0) {
            int pre = res.get(0).get(0);
            int height = res.get(0).get(1);
            for (int i = 1; i < res.size(); i++) {
                ArrayList<Integer> now = new ArrayList<Integer>();
                int id = res.get(i).get(0);
                if (height > 0) {
                    now.add(pre);
                    now.add(id);
                    now.add(height);
                    if (pre != id) {
                        ans.add(now);
                    }
                }
                pre = id;
                height = res.get(i).get(1);
            }
        }
        return ans;
    }

    class Point {
        int loc, id, height;
        boolean flag;
        Point (int loc, int id, int height, boolean flag) {
            this.loc = loc;
            this.id = id;
            this.height = height;
            this.flag = flag;
        }
    }

    public class PointComparator implements Comparator<Point> {
        public int compare(Point l1, Point l2) {
            if (l1.loc != l2.loc)
                return Integer.compare(l1.loc, l2.loc);
            if (l1.flag && l2.flag) {
                return Integer.compare(l2.height, l1.height);
            }
            if (!l1.flag && !l2.flag) {
                return Integer.compare(l1.height, l2.height);
            }
            return l1.flag ? -1 : 1;
        }
    }
}
