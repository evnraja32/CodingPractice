package practice.testng.listeners;

import org.testng.IClassListener;
import org.testng.ITestClass;

public class ClassHelper implements IClassListener {

	public void onBeforeClass(ITestClass testClass) {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void onAfterClass(ITestClass testClass) {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
