package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


@SuppressWarnings({ "javadoc" })
public class MainPage extends BasePage {

	public MainPage(WebDriver driver) {
		super(driver);
	}

	By UserNameField = By.id("username");
	By instanceField = By.id("instance");
	By passwordField = By.id("password");
	By loginButtun = By.id("login-submit");
	By demoAppButton = By.xpath("//div[@class='dd-select']");
	String expectedLandingPage = "http://demo.appsee.sncqe.com:5000/analytics/home/demo-app#/overview/index#ios/all/month";
	
	public void getWebSite(String siteURL) {
		navigateToURL(siteURL);
	}
	
	public void login(String userName, String instance, String password) {
		sendKeys(UserNameField, userName);
		sendKeys(instanceField, instance);
		sendKeys(passwordField, password);
		clickOnElement(loginButtun);
		waitForElementToBeClickable(demoAppButton);
		assertEquals(getTheURL(), expectedLandingPage, "you are not at the right URL");
	}
		
}
