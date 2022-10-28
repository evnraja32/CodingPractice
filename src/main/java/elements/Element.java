package elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class Element {

	protected WebDriver driver = null;
	protected String how = null;
	protected String using = null;

	public Element(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement() {

		By by = null;
		switch (how) {
		case "id":
			by = By.id(using);
			break;
		case "xpath":
			by = By.xpath(using);
			break;
		case "css":
			by = By.cssSelector(using);
			break;
		case "tagName":
			by = By.tagName(using);
			break;
		case "linkText":
			by = By.linkText(using);
			break;
		case "partialLinkText":
			by = By.partialLinkText(using);
			break;
		case "name":
			by = By.name(using);
			break;
		case "class":
			by = By.className(using);
			break;
		}

		return driver.findElement(by);
	}

//	public List<WebElement> getElements() {
//
//		By by = null;
//		switch (how) {
//		case "id":
//			by = By.id(using);
//			break;
//		case "xpath":
//			by = By.xpath(using);
//			break;
//		case "css":
//			by = By.cssSelector(using);
//			break;
//		case "tagName":
//			by = By.tagName(using);
//			break;
//		case "linkText":
//			by = By.linkText(using);
//			break;
//		case "partialLinkText":
//			by = By.partialLinkText(using);
//			break;
//		case "name":
//			by = By.name(using);
//			break;
//		case "class":
//			by = By.className(using);
//			break;
//		}
//
//		return driver.findElements(by);
//	}

	
	public boolean click() {
		try {
			getElement().click();
		} catch(Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}

	
	public void submit() {
		getElement();

	}

	
	public boolean sendKeys(String keysToSend) {
		try {
			getElement().sendKeys(keysToSend);
		} catch(Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}

	
	public boolean clear() {
		try {
			getElement().clear();
		} catch(Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
		return true;

	}

	
	public String getTagName() {
		getElement();
		return null;
	}

	
	public String getAttribute(String name) {
		getElement();
		return null;
	}

	
	public boolean isSelected() {
		getElement();
		return false;
	}

	
	public boolean isEnabled() {
		getElement();
		return false;
	}

	
	public String getText() {
		getElement();
		return null;
	}

	
	public List<WebElement> findElements(By by) {
		getElement();
		return null;
	}

	
	public WebElement findElement(By by) {
		getElement();
		return null;
	}

	
	public boolean isDisplayed() {
		getElement();
		return false;
	}

	
	public Point getLocation() {
		getElement();
		return null;
	}

	
	public Dimension getSize() {
		getElement();
		return null;
	}

	
	public Rectangle getRect() {
		getElement();
		return null;
	}

	
	public String getCssValue(String propertyName) {
		getElement();
		return null;
	}

}
