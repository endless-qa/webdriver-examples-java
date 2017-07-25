package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class ItemPage {

	@Step("Get title of the opened item")
	public String getTitle() {
		return $(By.id("title_feature_div")).getText();
	}

	@Step("Select the CD option for a music album")
	public ItemPage switchToCD() {
		$("#a-autoid-2 > span").click();
		return this;
	}

	@Step("Add the opened item to the Cart")
	public ItemPage addToCart() {
		$(By.id("add-to-cart-button")).click();
		return this;
	}

	@Step("Navigate to the Cart")
	public CartPage proceedToCheckout() {
		$(By.id("nav-cart")).click();
		return new CartPage();
	}
}
