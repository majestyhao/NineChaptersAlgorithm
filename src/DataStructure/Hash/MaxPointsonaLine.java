package DataStructure.Hash;

import sun.nio.cs.ext.MacArabic;

import java.util.HashMap;

/**
 * Created by hao on 15-10-21.
 */
public class MaxPointsonaLine {
    /**
     * @param points an array of point
     * @return an integer
     */
    public int maxPoints(Point[] points) {
        if (points == null) {
            return 0;
        }

        HashMap<Double, Integer> map;

        int globalMax = 1;
        for (int i = 0; i < points.length; i++) {
            map = new HashMap<Double, Integer>();
            int dup = 0;
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].y == points[j].y && points[i].x == points[j].x) {
                    dup++;
                    continue;
                }
                double k;
                if (points[i].x - points[j].x == 0) {
                    k = Float.MAX_VALUE;
                } else {
                    k = (double)(points[i].y - points[j].y) / (double)(points[i].x - points[j].x);
                }
                if (map.containsKey(k)) {
                    map.put(k, map.get(k) + 1);
                } else {
                    map.put(k, 2);
                }
            }

            for (int count : map.values()) {
                globalMax = Math.max(globalMax, count + dup);
            }
            globalMax = Math.max(globalMax, 1 + dup);
        }

        return globalMax;
    }

    public static void main(String[] args) {
        MaxPointsonaLine mp = new MaxPointsonaLine();
        Point a = new Point(1, 2);
        Point b = new Point(3, 6);
        Point c = new Point(0, 0);
        Point d = new Point(1, 3);
        Point[] points = new Point[4];
        points[0] = a;
        points[1] = b;
        points[2] = c;
        points[3] = d;

        System.out.print(mp.maxPoints(points));
    }
}
