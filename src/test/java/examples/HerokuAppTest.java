package examples;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;


import org.testng.annotations.BeforeClass;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import static org.testng.Assert.*;

public class HerokuAppTest {
	
	RemoteWebDriver driver = null;
	
	@FindBy(how = How.LINK_TEXT, using = "Drag and Drop")
	private WebElement dragAndDrop;

//	@Test(dataProvider = "dp")
//	public void verifyTheTitle(Integer n, String s) {
	@Test
	public void verifyTheTitle() {
		assertEquals(driver.getTitle(), "The Internet");
	}
	
	@Test
	public void testWaits() {
		
		WebElement ele = new WebDriverWait(driver, Duration.ofSeconds(30))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//ui/li")));
				
		ele.isDisplayed();
		ele.isEnabled();
		ele.isSelected();
		
		ele.click();
		ele.sendKeys("adf");
		ele.getText();
		ele.getTagName();
		ele.getLocation();
		ele.getCssValue("propName");
		
		driver.executeScript("document[0].click();");
		driver.executeScript("");
		
	}

	@Test
	public void verifyTheLinks() {
		List<WebElement> links = driver.findElements(By.xpath("//ul/li/a"));
		ArrayList<String> listOfLinks = new ArrayList<String>();
		for (WebElement ele : links) {
			listOfLinks.add(ele.getText());
		}
		
		assertTrue(listOfLinks.contains("Drag and Drop"));
		assertTrue(listOfLinks.containsAll(Arrays.asList("Drag and Drop", "Dropdown")));

	}

	@Test
	public void testKeyBoardActions() {
		driver.findElement(By.linkText("Key Presses")).click();
		
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.SHIFT).keyUp(Keys.SHIFT).build().perform();
		String paragraphText = driver.findElement(By.xpath("//p[contains(text(), 'You entered:')]")).getText().trim();
		assertTrue(paragraphText.endsWith("SHIFT"));
		
		String file = "./shift_screenshot.png";
		File pic = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(pic, new File(file));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void factoryExample() {
		dragAndDrop.click();
		assertTrue(driver.getCurrentUrl().endsWith("drag_and_drop"));
		
		String file = "./screenshot.png";
		File pic = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(pic, new File(file));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement aBlock = driver.findElement(By.cssSelector("div#column-a"));
		WebElement bBlock = driver.findElement(By.id("column-b"));
		
		Actions actions = new Actions(driver);
		actions.dragAndDrop(aBlock, bBlock).build().perform();
		System.out.println();
		
		try {
			FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), new File("./file2.png") );
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		int x = driver.manage().window().getPosition().getX() / 2;
		int y = driver.manage().window().getPosition().getY() / 2;
		actions.clickAndHold(aBlock).moveByOffset(x, y).build().perform();
		
		try {
			FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), new File("./file3.png") );
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		driver = new ChromeDriver(options);
		driver.get("http://the-internet.herokuapp.com/");
		
		PageFactory.initElements(driver, this);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { 1, "a" }, new Object[] { 2, "b" }, };
	}

	@BeforeClass
	public void beforeClass() {
	}

	@AfterClass
	public void afterClass() {
	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Start the test");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("Close the test");
	}

}
