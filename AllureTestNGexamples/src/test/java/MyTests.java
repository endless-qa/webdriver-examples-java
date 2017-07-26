import com.codeborne.selenide.Configuration;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.AmazonMainPage;
import pages.CartPage;
import pages.ItemPage;

@Listeners({BaseListener.class})
public class MyTests {

    @BeforeClass
    public void globalSetUp() {
        Configuration.reportsFolder = "target/selenideReports/tests";
    }

    @BeforeTest
    public void testSetUp() { }

    @AfterTest
    public void testTearDown() { }

    @Feature("Searching")
    @Story("Search by titles")
    @Severity(SeverityLevel.CRITICAL)
    @Parameters("searchString")
    @Test(description = "Check that a product can be found through the Search")
    public void testSearchingItems(String searchString) {
        new AmazonMainPage().searchFor(searchString)
                            .withResultsMoreThan(1)
                            .firstItemTitleContains("API testing");
    }

	@Feature("Discounts")
    @Story("Discount content global updating")
    @Severity(SeverityLevel.MINOR)
    @Parameters("label")
    @Test(description = "Check the correct label for an item on the Today’s Deals page")
    public void testTodaysDealsAvailability(String label) {
        new AmazonMainPage().enterTodaysDeal()
                            .withResultsMoreThan(1)
                            .firstItemHasLabel("Discounts");
    }

    @Feature("Purchasing")
    @Feature("User profile")
    @Story("Adding MP3 to the Cart")
    @Severity(SeverityLevel.BLOCKER)
    @Issue("777")
    @TmsLink("12345")
    @Test(description = "Check adding an album to the Cart")
    public void testAddingItemToCart() {
        ItemPage item = new AmazonMainPage().searchFor("Joe Satriani")
                                            .getFirstFound();

        String expectedTitle = item.getTitle();

        CartPage cart = item.switchToCD()
                            .addToCart()
                            .proceedToCheckout();

        Assert.assertEquals("Super Colossal", cart.getLastAddedItemTitle());
    }

    @Owner("John Doe")
    @Severity(SeverityLevel.TRIVIAL)
    @Issue("1027")
    @Test
    @Description("This test always fails in order to have different results in the report")
    public void testWhichAlwaysFails() {
        Assert.fail("Error message: this test was failed intentionally!");
    }
}
