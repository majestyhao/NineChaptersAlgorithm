public class FindMedianSortedArraysDoAgain {
	public double findMedianSortedArrays(int[] A, int[] B) {
		if ((A.length + B.length) % 2 == 0) {
			return (findKth(A, 0, B, 0, (A.length + B.length) / 2) + findKth(A,
					0, B, 0, (A.length + B.length) / 2 + 1)) / 2.0;
		} else {
			return findKth(A, 0, B, 0, (A.length + B.length) / 2 + 1);
		}
	}

	// 从 以A_start和B_start为开始的两个数组所合并的数组中寻找第k大的数
	// A_start 的指向位置相当于新的0元素, 则增加k / 2元素后坐标为A_start + k / 2 - 1
	public int findKth(int[] A, int A_start, int[] B, int B_start, int k) {
		// base-cases
		// A_start 会多跳一格, 当A_start跳出A时, 代表A的元素已实际全部考虑并丢弃过了
		if (A_start == A.length) {
			return B[B_start + k - 1];
		} else if (B_start == B.length) {
			return A[A_start + k - 1];
		}

		// 相当于A_start + B_start 代表的长度始终比k大1
		// 当k == 1时, 代表仅剩一个元素待取, 从剩下的两个选项中小的优先级高
		if (k == 1) {
			return Math.min(A[A_start], B[B_start]);
		}

		// induction cases
		// 3 facts: 至少有一个数组长度 > k / 2
		// 当A.length < k / 2时, B的前k / 2 一定在前k中, 丢弃 (因为即使A的全在k之前, 也只少还差B的k/2个)
		// 当A_key < B_key时, A的前k / 2一定在前k中, 丢弃
		int A_key = A_start + k / 2 - 1 < A.length ? A[A_start + k / 2 - 1]
				: Integer.MAX_VALUE; // 引入MAX相当于说A退出此轮竞争,可以理解为A, B后面跟了个virtual inf
		int B_key = B_start + k / 2 - 1 < B.length ? B[B_start + k / 2 - 1]
				: Integer.MAX_VALUE;
		if (A_key < B_key) {
			return findKth(A, A_start + k / 2, B, B_start, k - k / 2);
		} else {
			return findKth(A, A_start, B, B_start + k / 2, k - k / 2);
		}
	}

}
