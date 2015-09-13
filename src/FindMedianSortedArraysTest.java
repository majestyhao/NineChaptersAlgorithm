import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class FindMedianSortedArraysTest {
	FindMedianSortedArrays findMed = new FindMedianSortedArrays();
	int[] A = {1, 2, 3}, B = {4, 5, 6, 7, 8};
	int[] A2 = {1,2,3,4,5,6}, B2 = {2,3,4,5};
	int[] A3 = {}, B3 = {2, 3};
	int[] A4 = {3}, B4 = {4};
	int[] A5 = {1,2,3,4}, B5 = {5,6,7,8,9};
	int[] A6 = {5,6,9,10}, B6 = {0,2,3,4};
	int[] A7 = {1,1,14,31,33,40,42,66,71,74,113,117,124,125,127,137,143,184,187,188,221,222,224,
			248,251,269,293,294,315,324,330,353,358,366,368,389,389,408,424,432,433,451,452,456,
			459,475,480,483,484,496,509,515,519,523,559,567,568,593,598,600,612,623,626,628,632,
			633,634,646,654,663,681,696,706,709,717,723,746,753,790,790,798,824,826,847,849,857,
			866,879,882,894,894,913,925,938,942,961,974,988,988,989,998}, 
		  B7 = {3,4,5,6,9,15,17,20,21,21,23,25,27,27,28,29,31,32,37,41,43,47,49,50,52,52,52,54,59,
		        60,67,68,71,72,73,77,78,84,86,88,88,91,94,98,98,98,100,102,105,106,107,107,110,117,
		        118,120,122,124,126,129,131,134,135,144,147,154,158,158,163,164,164,170,171,171,172,
		        172,176,178,180,183,184,185,189,196,197,199,200,200,204,208,214,217,223,226,227,231,
		        231,232,232,237,243,244,245,251,258,259,266,271,274,277,279,280,280,281,283,284,284,
		        284,286,288,290,296,299,301,302,302,302,303,305,308,308,309,311,313,313,316,322,323,
		        326,327,328,329,331,331,337,340,340,342,343,345,346,349,349,349,350,354,366,366,375,
		        376,377,377,379,382,389,390,391,392,393,394};
	int[] A8 = {2, 3}, B8 = {1, 4};
	int[] A9 = {4,5}, B9 = {1,2,3,6};

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindMedianSortedArrays() {
		assertEquals(4.5, findMed.findMedianSortedArrays(A, B), 0);
		assertEquals(3.5, findMed.findMedianSortedArrays(A2, B2), 0);
		assertEquals(2.5, findMed.findMedianSortedArrays(A3, B3), 0);
		assertEquals(3.5, findMed.findMedianSortedArrays(A4, B4), 0);
		assertEquals(5.0, findMed.findMedianSortedArrays(A5, B5), 0);
		assertEquals(4.5, findMed.findMedianSortedArrays(A6, B6), 0);
		assertEquals(277.0, findMed.findMedianSortedArrays(A7, B7), 0);
		assertEquals(2.5, findMed.findMedianSortedArrays(A8, B8), 0);
		assertEquals(3.5, findMed.findMedianSortedArrays(A9, B9), 0);
	}

}
