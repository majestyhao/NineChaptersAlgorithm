package HighFreq.ScanningLine;

import DataStructure.SegmentTree.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by hao on 15-10-28.
 */
public class NumberofAirplanesintheSky {
    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) {
        List<Point> list = new ArrayList<>();

        for (Interval plane : airplanes) {
            list.add(new Point(plane.start, true));
            list.add(new Point(plane.end, false));
        }

        Collections.sort(list, new PointComparator());
        int count = 0;
        int res = 0;
        for (Point point : list) {
            if (point.flag) {
                count++;
            } else {
                count--;
            }
            res = Math.max(res, count);
        }

        return res;
    }

    public class Point {
        public int time;
        public boolean flag;
        public Point (int time, boolean flag) {
            this.time = time;
            this.flag = flag;
        }
    }

    public class PointComparator implements Comparator<Point> {
        public int compare(Point p1, Point p2) {
            if (p1.time == p2.time) {
                if (p1.flag && !p2.flag) {
                    return 1;
                } else if (!p1.flag && p2.flag) {
                    return -1;
                } else {
                    return 0;
                }
            }

            return p1.time - p2.time;
        }
    }
}
