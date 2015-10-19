package GraphandSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by watershed2106 on 10/19/15.
 */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Queue<Integer> queue = new LinkedList<Integer>();
        int[] inDegree = new int[numCourses];

        int m = prerequisites.length;
        for (int i = 0; i < m; i++) {
            inDegree[prerequisites[i][0]]++;
        }

        List<Integer> topSort = new ArrayList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] != 0) {
                continue;
            }
            queue.add(i);
            while (!queue.isEmpty()) {
                int len = queue.size();
                for (int j = 0; j < len; j++) {
                    int node = queue.remove();
                    topSort.add(node);
                    for (int k = 0; k < m; k++) {
                        if (prerequisites[k][1] == node) {
                            inDegree[prerequisites[k][0]]--;
                            if (inDegree[prerequisites[k][0]] == 0) {
                                inDegree[prerequisites[k][0]] = -1;
                                queue.add(prerequisites[k][0]);
                            }
                        }
                    }
                }
            }
        }

        if (numCourses != topSort.size()) {
            return new int[0];
        }

        int[] res = new int[topSort.size()];
        for (int i = 0; i < topSort.size(); i++) {
            res[i] = topSort.get(i);
        }
        
        return res;
    }

    public static void main(String[] args) {
        CourseScheduleII cs = new CourseScheduleII();
        int[][] pre = new int[1][];
        pre[0] = new int[2];
        pre[0][0] = 1;
        pre[0][1] = 0;
        cs.findOrder(2, pre);
    }
}
