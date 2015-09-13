public class FindMedianSortedArrays {
	public double findMedianSortedArrays(int[] A, int[] B) {
		if (A.length == 0 && B.length == 0) {
			return 0;
		}
		if (A.length == 0) {
			if (B.length % 2 == 0) {
				// System.out.println(B[B.length / 2]);
				return ((B[B.length / 2] + B[B.length / 2 - 1]) / 2.0);
			} else {
				return B[B.length / 2];
			}
		}
		if (B.length == 0) {
			if (A.length % 2 == 0) {
				return ((A[A.length / 2] + A[A.length / 2 - 1]) / 2.0);
			} else {
				return A[A.length / 2];
			}
		}
		return findKth(A, B, (A.length + B.length) / 2 + 1);
	}

	private int comp(int first, int second) {
		if (first > second) {
			return first;
		} else {
			return second;
		}
	}

	private double findKth(int[] A, int[] B, int k) {
		//System.out.println(k);
		int mid1 = k / 2 - 1; // partition index in array A
		int mid2 = k - k / 2 - 1; // make sure at any time the total amount is k
		// A发生后退则A目前的mid1将作为下次增长的上限
		int mid1Limit = A.length - 1, mid2Limit = B.length - 1;
		if (mid1 > A.length - 1) {
			// forget this 
			mid1 = A.length / 2;
			mid2 = k - (mid1 + 1) - 1;
		} else if (mid2 > B.length - 1) {
			mid2 = B.length / 2;
			mid1 = k - (mid2 + 1) - 1;
		}
		double result;
		while (true) {
			if (A[mid1] < B[mid2]) {
				if (mid1 == A.length - 1 || B[mid2] <= A[mid1 + 1]) {
					// System.out.println(B[mid2]);
					result = B[mid2];
					if ((A.length + B.length) % 2 == 0) {
						if (mid2 == 0) {
							result = (result + A[mid1]) / 2.0;
							break;
						}
						result = (result + comp(B[mid2 - 1], A[mid1])) / 2.0;
					}
					break;
				} else {
					mid2Limit = mid2;
					int move;
					
					if (mid1Limit - mid1 < mid2) {
						move = (mid1Limit - mid1 + 1) / 2;
					} else {
						move = (mid2 + 1) / 2;
					}
					if (move == 0) {
						if (A.length >= k && A[k - 1] < B[0]) {
							result = A[k - 1];
							if ((A.length + B.length) % 2 == 0) {
								result = (result + A[k - 2]) / 2.0;
							}
							break;
						} else if (k >= 2 && k - 2 <= A.length - 1 && B[0] < A[k - 2]) {
							result = A[k - 2];
							if ((A.length + B.length) % 2 == 0) {
								result = (result + comp(A[k - 3], B[0])) / 2;
							}
							break;
						} else 
						{
							result = B[0];
							if ((A.length + B.length) % 2 == 0) {
								result = (A[mid1] + B[0]) / 2.0;
							}
							break;
						}
					}

					mid1 = mid1 + move;
					mid2 = mid2 - move;

				}
			} else {
				if (mid2 == B.length - 1 || A[mid1] <= B[mid2 + 1]) {
					result = A[mid1];
					if ((A.length + B.length) % 2 == 0) {
						if (mid1 == 0) {
							result = (result + B[mid2]) / 2;
							break;
						}
						result = (result + comp(A[mid1 - 1], B[mid2])) / 2.0;
					}
					break;
				} else {
					mid1Limit = mid1;
					int move;
					if (mid2Limit - mid2 < mid1) {
						move = (mid2Limit - mid2 + 1) / 2;
					} else {
						move = (mid1 + 1)/ 2;
					}
					if (move == 0) {
						if (B.length >= k  && B[k - 1] < A[0]) {
							result = B[k - 1];
							if ((A.length + B.length) % 2 == 0) {
								result = (result + B[k - 2]) / 2.0;
							}
							break;
						} else if (k >= 2 && k - 2 <= B.length - 1 && A[0] < B[k - 2]) {
							result = B[k - 2];
							if ((A.length + B.length) % 2 == 0) {
								result = (result + comp(B[k - 3], A[0])) / 2.0;
							}
							break;
						} else {
							result = A[0];
							if ((A.length + B.length) % 2 == 0) {
								//System.out.print(B[B.length - 1]);
								result = (B[mid2] + result) / 2.0;
							}
							break;
						}
					}
					mid2 = mid2 + move;
					mid1 = mid1 - move;
				}
			}
		}
		// System.out.println(result);
		return result;
	}

}
