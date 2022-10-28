package practice.testng.listeners;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

public class MethodHelper implements IInvokedMethodListener {

	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		// not implemented
	}

	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	/**
	 * To be implemented if the method needs a handle to contextual information.
	 *
	 * @param method     The invoked method
	 * @param testResult The test result
	 * @param context    The test context
	 */
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	/**
	 * To be implemented if the method needs a handle to contextual information.
	 *
	 * @param method     The invoked method
	 * @param testResult The test result
	 * @param context    The test context
	 */
	public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
