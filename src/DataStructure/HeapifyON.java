package DataStructure;

public class HeapifyON {
	public void heapify(int[] A) {
		// bottom up
		// A.lengh / 2 will be the least parent
		for (int i = A.length / 2; i >= 0; i--) {
			siftdown(A, i);
		}
	}
	
	private void siftdown(int[] A, int k) {
		while (k < A.length) {
			int smallest = k; // the smallest of A[k] and its sons
			if (k * 2 + 1 < A.length && A[k * 2 + 1] < A[smallest]) {
				smallest = k * 2 + 1;
			}
			if (k * 2 + 2 < A.length && A[k * 2 + 2] < A[smallest]) {
				smallest = k * 2 + 2;
			}
			if (smallest == k) {
				break;
			}
			int tmp = A[smallest];
			A[smallest] = A[k];
			A[k] = tmp;
			
			k = smallest;
		}
	}
	

}
