package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@SuppressWarnings("javadoc")
public class OverviewPage extends BasePage {

	public OverviewPage(WebDriver driver) {
		super(driver);
	}
	
	By analyticsIcon = By.cssSelector(".icon.appsee-icon_analytics");
	By events = By.xpath("//a[@context='/analytics/custom-events']");
	
	
	public void selectTheAnalyticsPage() {
		mouseHooverFromElement(analyticsIcon);
		clickOnElement(analyticsIcon);
		mouseHooverFromElement(events);
		clickOnElement(events);
		refreshPage();
	}

}
