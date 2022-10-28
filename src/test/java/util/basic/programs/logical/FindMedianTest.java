package util.basic.programs.logical;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FindMedianTest {
	@Test(description = "sorted arrays")
	public void findMedian() {

		int a[] = { 11, 13, 15 };
		int b[] = { 12, 14, 16 };

		if (a.length != b.length)
			fail("given array length is not same");
		else
			Assert.assertEquals(calculateMedian(a, b, a.length), (a[a.length / 2] + b[b.length / 2]) / 2);
	}
	
	@Test(description="a is lesser")
	public void findMedianWhenAislesser() {

		int a[] = { 1, 2, 3 };
		int b[] = { 12, 14, 16 };

		if (a.length != b.length)
			fail("given array length is not same");
		else
			Assert.assertEquals(calculateMedian(a, b, a.length), (3 + 12) / 2);
	}
	
	@Test(description="b is lesser")
	public void findMedianWhenBislesser() {

		int a[] = { 12, 14, 16 };
		int b[] = { 1, 2, 3 };

		if (a.length != b.length)
			fail("given array length is not same");
		else
			Assert.assertEquals(calculateMedian(a, b, a.length), (3 + 12) / 2);
	}

	public int calculateMedian(int[] a, int[] b, int arrSize) {
		int m1 = -1, m2 = -1; // medians of arr a & b
		int i = 0, j = 0; // index positions of arr a & b

		for (int count = 0; count <= arrSize; count++) {

			if (i == arrSize) {
				m1 = m2;
				m2 = b[j];
				break;
			} else if (j == arrSize) {
				m1 = m2;
				m2 = a[i];
				break;
			}

			if (a[i] <= b[j]) {
				m1 = m2;
				m2 = a[i];
				i++;
			} else {
				m1 = m2;
				m2 = b[j];
				j++;
			}

		}

		return (m1 + m2) / 2;
	}
}
