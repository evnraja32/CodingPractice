package elements;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {

	protected static RemoteWebDriver driver = null;

	public Browser(String browser) {

		String stepDesc = "Launching web application: url";
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
//			ChromeOptions chromeOptions = new ChromeOptions();
//			chromeOptions.setAcceptInsecureCerts(true);
//			chromeOptions.setHeadless(true);
//			chromeOptions.addArguments("--incognito");
//			chromeOptions.setPageLoadTimeout(Duration.ofSeconds(30));
//			chromeOptions.setScriptTimeout(Duration.ofMinutes(20));
			driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			throw new InvalidArgumentException("Invalid browser option: " + browser);
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		FluentWait<RemoteWebDriver> wait = new FluentWait<RemoteWebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5));
		
		((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);


	}
	
	public void closeBrowser(){
		driver.close();
	}
}
