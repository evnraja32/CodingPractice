package util.basic.programs;

public abstract class Fibbinocci {

	public static void fibbiSeries(int a, int b, int maxCount) {
		int t = a;
		System.out.print(t + " ");
		a = b;
		b += t;
		--maxCount;
		if (maxCount > 0) {
			fibbiSeries(a, b, maxCount);
		}
	}
	
}
