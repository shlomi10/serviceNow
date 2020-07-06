package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@SuppressWarnings("javadoc")
public class BasePage {

	public WebDriver driver;
	public WebDriverWait wait;
	public Actions action;
	Robot r;


	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
	}
	
	public void navigateToURL(String URL) {
		driver.get(URL);
	}
	
	public String getTheURL() {
		return driver.getCurrentUrl();
	}
	
	public void refreshPage() {
		 driver.navigate().refresh();
	}
		
	public void sendKeys(By elem, String text) {
		driver.findElement(elem).sendKeys(text);
	}
	
	public void clickEnter() {
		try {
			r = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void clickOnElement(By elem) {
		driver.findElement(elem).click();
	}
	
	public void clearField(By elem) {
		driver.findElement(elem).clear();
	}

	public void waitForElementToBeClickable(By elem) {
		wait.until(ExpectedConditions.elementToBeClickable(elem));
	}

	public void waitForElementToBeVisable(By elem) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(elem));
	}

	public String getTextFromElement(By elem) {
		return driver.findElement(elem).getText();
	}

	public void mouseHooverFromElement(By elem) {
		action = new Actions(driver);
		WebElement element1 = driver.findElement(elem);
		action.moveToElement(element1).build().perform();
	}

	public int countElements(By elem, int numberOfElementsToBE) {
		wait.until(ExpectedConditions.numberOfElementsToBe(elem, numberOfElementsToBE));
		List<WebElement> list = driver.findElements(elem);
		return list.size();
	}

	public List<Integer> getNumberTextFromElements(By elem) {

		List<WebElement> elementList = driver.findElements(elem);
		List<Integer> intList = new ArrayList<>();

		for (WebElement element : elementList) {
			intList.add(Integer.valueOf(element.getText()));
		}
		return intList;
	}

	public List<String> getTextFromElements(By elem) {

		List<WebElement> elementList = driver.findElements(elem);
		List<String> stringList = new ArrayList<>();

		for (WebElement element : elementList) {
			stringList.add(element.getText());
		}
		return stringList;
	}

	public List<String> getTextFromElementsReturnList(By elem) {

		List<WebElement> elementList = driver.findElements(elem);
		List<String> stringList = new ArrayList<>();

		for (WebElement element : elementList) {
			stringList.add(element.getText());
		}
		return stringList;
	}
}
