package DataStructure.UnionFind;

import DataStructure.Hash.Point;

import java.util.*;

/**
 * Created by hao on 15-10-23.
 */
public class NumberofIslandsII {
    /**
     * @param n an integer
     * @param m an integer
     * @param operators an array of point
     * @return an integer array
     */
    public List<Integer> numIslands2(int m, int n, Point[] operators) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < operators.length; i++) {
            int index = twoDToOneD(operators[i].x, operators[i].y, n);
            set.add(index);
        }
        UnionFind uf = new UnionFind(set);

        int count = 0;
        List<Integer> res = new ArrayList<Integer>();
        boolean[] isLand = new boolean[m * n];
        for (int i = 0; i < operators.length; i++) {
            count++;
            int index = twoDToOneD(operators[i].x, operators[i].y, n);
            //System.out.print(index);
            //System.out.print(":");
            isLand[index] = true;
            for (int j = 0; j < 4; j++) {
                int newX = operators[i].x + dx[j];
                int newY = operators[i].y + dy[j];
                if (newX < m && newX >= 0 && newY < n && newY >= 0) {
                    //System.out.println("");
                    //System.out.print(newX);
                    //System.out.print(newY);
                    int node = twoDToOneD(newX, newY, n);
                    if (index == 12) {
                        System.out.print(newX);
                        System.out.print(newY);
                    }
                    if (isLand[node]) {
                        if (uf.find(node) != uf.find(index)) {
                            //System.out.print(uf.find(node));
                            //System.out.print(uf.find(index));
                            uf.union(index, node);

                            //System.out.print(count);
                            count--;
                        }
                    }
                }
            }

            res.add(count);
            System.out.println(count);
            System.out.println("");
        }

        return res;
    }

    private int twoDToOneD(int x, int y, int n) {
        return x * n + y;
    }

    class UnionFind {
        Map<Integer, Integer> father = new HashMap<>();

        UnionFind(Set<Integer> set) {
            for (int element : set) {
                father.put(element, element);
            }
        }

        int find(int x) {
            int parent = father.get(x);
            while (parent != father.get(parent)) {
                parent = father.get(parent);
            }

            int tmp = -1;
            int cur = x;
            while (father.get(cur) != parent) {
                tmp = father.get(cur);
                father.put(cur, parent);
                cur = tmp;
            }

            return parent;
        }

        void union(int x, int y) {
            int ceoX = find(x);
            int ceoY = find(y);
            father.put(ceoX, ceoY);
        }
    }

    public static void main(String[] args) {
        NumberofIslandsII nf = new NumberofIslandsII();
        //4, 5, [[1,1],[0,1],[3,3],[3,4]]
        Point[] a = new Point[6];
        a[0] = new Point(0, 9);
        a[1] = new Point(5, 4);
        a[2] = new Point(0, 12);
        a[3] = new Point(6, 9);
        a[4] = new Point(6, 5);
        a[5] = new Point(0, 4);

        nf.numIslands2(8, 14, a);
    }
}
