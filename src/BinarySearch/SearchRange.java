package BinarySearch;
import java.util.ArrayList;


public class SearchRange {
	/** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (A == null || A.size() == 0) {
            result.add(-1);
            result.add(-1);
            return result;
        }
        
        int start = 0, end = A.size() - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A.get(mid) == target) {
                end = mid;
            } else if (A.get(mid) < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A.get(start) == target) {
            result.add(start);
        } else if (A.get(end) == target) {
            result.add(end);
        } else {
            result.add(-1);
        }
        
        start = 0; end = A.size() - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A.get(mid) == target) {
                start = mid;
            } else if (A.get(mid) < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A.get(end) == target) {
            result.add(end);
        } else if (A.get(start) == target) {
            result.add(start);
        } else {
            result.add(-1);
        }
        
        return result;
    }
}
