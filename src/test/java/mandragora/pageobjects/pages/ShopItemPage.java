package mandragora.pageobjects.pages;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import com.xceptance.neodymium.util.Neodymium;
import io.qameta.allure.Step;

public class ShopItemPage extends AbstractPageObject {

  @Override
  @Step("Stelle sicher, dass die Shopseite korrekt dargestellt wird")
  public ShopItemPage isExpectedPage() {
    return this;
  }

  @Step("Füre '{shopItem}' zum Warenkorb hinzu")
  public ShoppingCartPage addToShoppingCart(String shopItem) {
    $(".single_add_to_cart_button").shouldHave(
        exactText(Neodymium.localizedText("shop.shoppingCart"))).click();
    return new ShoppingCartPage().isExpectedPage();
  }
}
