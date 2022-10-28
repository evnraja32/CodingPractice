package practice.testng.basics;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ExecutionOrderTest {
	@Test
	public void executionOrderTestMethod() {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@AfterClass
	public void afterClass() {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@AfterTest
	public void afterTest() {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
