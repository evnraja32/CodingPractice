package examples;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.easyautomation.driver.factory.WebBrowser;

import elements.Browser;

public class BotTest {

	RemoteWebDriver driver;

	@BeforeMethod
	public void initDriver() {
		driver = WebBrowser.init("chrome");
	}

	@Test
	public void testMethod() {
	}
}
