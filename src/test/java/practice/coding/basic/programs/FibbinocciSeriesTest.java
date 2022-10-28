package practice.coding.basic.programs;

import java.util.Scanner;

import util.basic.programs.Fibbinocci;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FibbinocciSeriesTest {
	@Test(dataProvider = "provideMaxCount")
	public void bruteForce(int maxCount) {

		int a = 0, b = 1;
//		int maxCount = 10;

		for (int i = 1; i <= maxCount; i++) {
			int t = a; // 0
			System.out.print(t + " ");
			a = b; // 1
			b += t;
		}
		
		System.out.println();
	}

	@Test(dataProvider = "provideMaxCount")
	public void recursionMethod(int maxCount) {
		int a = 0, b = 1; // maxCount = 10;
		Fibbinocci.fibbiSeries(a, b, maxCount);
		System.out.println();
	}

	@DataProvider(name = "provideMaxCount")
	public Integer[] providerMethod() {

//      System.out.println("How many numbers do you want to print? :");
//      Scanner scanner = new Scanner(System.in);
//      int maxCount = scanner.nextInt();
		return new Integer[] { 10 };
	}

}
