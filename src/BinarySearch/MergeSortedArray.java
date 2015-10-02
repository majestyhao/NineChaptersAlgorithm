package BinarySearch;

public class MergeSortedArray {
	 /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
	public void mergeSortedArray(int[] A, int m, int[] B, int n) {
		if (m <= 0) {
			for (int i = 0; i < n; i++) {
				A[i] = B[i];
			}
			return;
		}
		if (n <= 0) {
			return;
		}
		int lastStart = 0;
		for (int i = 0; i < n; i++) {
			int start = lastStart, end = m + i - 1;
			while (start + 1 < end) {
				int mid = start + (end - start) / 2;
				if (A[mid] == B[i]) {
					end = mid;
				} else if (A[mid] < B[i]) {
					start = mid;
				} else {
					end = mid;
				}
			}
			if (A[start] == B[i]) {
				insertIntoA(A, m + i, start + 1, B[i]);
			} else if (A[end] <= B[i]) {
				insertIntoA(A, m + i, end + 1, B[i]);
			} else if (A[start] < B[i]) {
				insertIntoA(A, m + i, start + 1, B[i]);
			} else if (A[start] > B[i]) {
				// notice this, only happens when all elements in A bigger than B
				insertIntoA(A, m + 1, 0, B[i]);
			}
			lastStart = start;
		}
		//for (int i = 0; i < A.length; i++)
			//System.out.print(A[i]);
    }
	
	private void insertIntoA(int[] A, int A_len, int pos, int target) {
		//System.out.println(target);
		if (pos == A.length - 1) {
			A[pos] = target;
			return;
		}
		//System.out.println(A_len);
		for (int i = A_len - 1; i >= pos; i--) {
		//	System.out.println(i);
			A[i + 1] = A[i];
		}
		A[pos] = target;
	}

}
