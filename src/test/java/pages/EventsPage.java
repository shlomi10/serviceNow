package pages;

import static org.testng.Assert.assertEquals;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@SuppressWarnings("javadoc")
public class EventsPage extends BasePage{

	public EventsPage(WebDriver driver) {
		super(driver);
	}

	By searchBox = By.id("screens-name-search");
	By rowsAtTable = By.cssSelector(".events-row-container");
	By titleOfResults = By.xpath("//div[@class='event-row']/div/span");
	int actualSizeOfList;
	
	public void searchItem(String event) {
		waitForElementToBeClickable(searchBox);
		clickOnElement(searchBox);
		clearField(searchBox);
		sendKeys(searchBox, event);
		clickEnter();
	}
	
	public void validateResult(List<String>itemsToValidate, int expectedItemAddedToCart) {
		actualSizeOfList = countElements(rowsAtTable, expectedItemAddedToCart);
		assertEquals(actualSizeOfList, expectedItemAddedToCart, "not the right amount of results");
		System.out.println("list of actual items at table: "+getTextFromElementsReturnList(titleOfResults).toString());
		assertEquals(itemsToValidate, getTextFromElementsReturnList(titleOfResults), "the result text at the table is not as expected");
		System.out.println("actualSizeOfList : " + actualSizeOfList);
	}

}
