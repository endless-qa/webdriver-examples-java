package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$$;

public class CartPage {

	@Step("Find the last added item in the cart and get its title")
	public String getLastAddedItemTitle() {
		return $$(By.className("sc-list-body")).first().find(By.className("sc-product-title")).text();
	}
}
