package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.EventsPage;
import pages.MainPage;
import pages.OverviewPage;

@SuppressWarnings("javadoc")
public class BaseTest {

	WebDriver driver;
	MainPage mainPage;
	OverviewPage overviewPage;
	EventsPage eventsPage;
	
	@BeforeTest(alwaysRun = true)
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		mainPage = new MainPage(driver);
		overviewPage = new OverviewPage(driver);
		eventsPage = new EventsPage(driver);
	}

	@AfterTest(alwaysRun = true)
	public void close() {
		driver.quit();
	}
}
