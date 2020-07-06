package tests;

import java.util.Arrays;
import java.util.List;
import org.testng.annotations.Test;

@SuppressWarnings("javadoc")
public class MainRunner extends BaseTest {

	String siteURL = "http://demo.appsee.sncqe.com:5000/analytics";
	String userName = "viewer";
	String Password = "AStrip01";
	String instance = "demo";
	String oneItemToSearch = "ItemAddedToCart";
	String twoItemToSearch = "purchase";
	int oneItemToValidate = 1;
	int twoItemsToValidate = 2;
	List<String> itemsToValidate = Arrays.asList("PurchaseStarted", "PurchaseComplete");


	@Test(priority = 1, groups = "Open Web Site", description = "Open the web site")
	public void upFooterOpenWebSite() {
		mainPage.getWebSite(siteURL);
	}
	
	@Test(priority = 2, groups = "validate overview page", description = "validate that the user logged in")
	public void loginToWebSite() {
		mainPage.login(userName, instance, Password);
	}

	@Test(priority = 3, groups = "validate events page", description = "validate the user land at events page")
	public void eventsPage() {
		overviewPage.selectTheAnalyticsPage();
	}
	
	@Test(priority = 4, groups = "perform serach on event", description = "search term on event page")
	public void performsearch() {
		eventsPage.searchItem(twoItemToSearch);
	}
	
	@Test(priority = 5, groups = "validate results from table", description = "validate results from table")
	public void validateResultsFromTable() {
		eventsPage.validateResult(itemsToValidate, twoItemsToValidate);
	}

}
