package DataStructure;

public class Heapify {
	/**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
    	heap = new int[A.length + 1];
    	heap[1] = A[0]; // root
    	for (int i = 1; i < A.length; i++) {
    		heap[i + 1] = A[i];
    		swim(i + 1);
    		//System.out.println(heap[i + 1]);
    		for (int j = 1; j <= i; j++) {
        		System.out.print(heap[j]);
        		System.out.print(" ");
        	}
    		System.out.println(' ');
    	}
    	
    	for (int i = 0; i < A.length; i++) {
    		A[i] = heap[i + 1];
    		System.out.print(A[i]);
    	}
    }
    
    int[] heap;
    
    private void swim(int i) {
    	while (heap[i] < heap[i / 2]) {
    		int tmp = heap[i];
    		heap[i] = heap[i / 2];
    		heap[i / 2] = tmp;
    		i = i / 2;
    	}
    }

}
