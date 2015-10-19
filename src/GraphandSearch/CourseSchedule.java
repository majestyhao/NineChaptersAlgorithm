package GraphandSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by watershed2106 on 10/19/15.
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Queue<Integer> queue = new LinkedList<Integer>();
        int[] inDegree = new int[numCourses];

        int m = prerequisites.length;
        for (int i = 0; i < m; i++) {
            inDegree[prerequisites[i][1]]++;
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
                        if (prerequisites[k][0] == node) {
                            inDegree[prerequisites[k][1]]--;
                            if (inDegree[prerequisites[k][1]] == 0) {
                                inDegree[prerequisites[k][1]] = -1;
                                queue.add(prerequisites[k][1]);
                            }
                        }
                    }
                }
            }
        }

        return numCourses == topSort.size();
    }

    public static void main(String[] args) {
        CourseSchedule cs = new CourseSchedule();
        int[][] pre = new int[1][];
        pre[0] = new int[2];
        pre[0][0] = 0;
        pre[0][1] = 1;
        System.out.print(cs.canFinish(2, pre));
    }
}
