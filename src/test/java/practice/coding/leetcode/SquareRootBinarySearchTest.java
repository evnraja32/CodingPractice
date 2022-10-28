package practice.coding.leetcode;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class SquareRootBinarySearchTest {
	@Test
	public void test1() {

		assertEquals(mySqrt(1), 1);
		assertEquals(mySqrt(2), 1);
		assertEquals(mySqrt(4), (int) Math.sqrt(4));
		assertEquals(mySqrt(8), (int) Math.sqrt(8));
		assertEquals(mySqrt(10), 3);
		assertEquals(mySqrt(99), 9);
//		assertEquals(mySqrt(2147483647), (int) Math.sqrt(2147483647));
	}

	public int mySqrt(int x) {
		System.out.println("Finding sq root for: " + x);
		double nearestPerfectSquare = 0, squareRoot = 0;
		if (x == 0)
			return (int) squareRoot;

		long low = 1, high = x, mid = (low + high) / 2;
		System.out
				.println("While Nearest: " + nearestPerfectSquare + " low: " + low + " mid: " + mid + " high: " + high);
		while (low <= high) {
			System.out.println(
					"Before Nearest: " + nearestPerfectSquare + " low: " + low + " mid: " + mid + " high: " + high);
			if (mid * mid == x) {
				nearestPerfectSquare = mid;
				break;
			} else if (mid * mid > x) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
			mid = (low + high) / 2;
			nearestPerfectSquare = mid;

			System.out.println(
					"After Nearest: " + nearestPerfectSquare + " low: " + low + " mid: " + mid + " high: " + high);
		}
		double diff;
		double nsq = (nearestPerfectSquare * nearestPerfectSquare);
//		if (nsq > x) {
			diff = nsq - x;
			squareRoot = (nearestPerfectSquare + (diff / (nearestPerfectSquare * 2)));
			System.out.println("if Nearest: " + nearestPerfectSquare + " Diff: " + diff + " Calci: "
					+ (diff / (nearestPerfectSquare * 2)) + " Final: " + squareRoot);
//		} else {
//			diff = x - nsq;
//			squareRoot = (nearestPerfectSquare + (diff / (nearestPerfectSquare * 2)));
//			System.out.println("else Nearest: " + nearestPerfectSquare + " Diff: " + diff + " Calci: "
//					+ (diff / (nearestPerfectSquare * 2)) + " Final: " + squareRoot + " CalVal: " + (nearestPerfectSquare + (diff / (nearestPerfectSquare * 2))));
//		}

		return (int)squareRoot;
	}
}
