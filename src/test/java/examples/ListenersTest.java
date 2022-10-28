package examples;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import practice.testng.listeners.TestSuiteHelper;

//@Listeners(TestSuiteHelper.class)

public class ListenersTest {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@Test
	public void testMethod() {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
	}
}
