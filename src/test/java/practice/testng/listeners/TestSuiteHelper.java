package practice.testng.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestSuiteHelper implements ISuiteListener {

	public void onStart(ISuite suite) {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " - " + suite.getName());
	}

	/**
	 * This method is invoked after the SuiteRunner has run all the tests in the
	 * suite.
	 *
	 * @param suite The suite
	 */
	public void onFinish(ISuite suite) {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
