package mandragora.pageobjects.pages;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import com.xceptance.neodymium.util.Neodymium;
import io.qameta.allure.Step;

public class ShoppingCartPage extends AbstractPageObject{

  @Override
  @Step("Stelle sicher, dass der Warenkorb korrekt dargestellt wird")
  public ShoppingCartPage isExpectedPage() {
    $(".entry-title").shouldHave(exactText(Neodymium.localizedText("shop.shoppingCartTitle")));
    $(".woocommerce-cart-form").shouldBe(visible);
    $(".cart-collaterals").shouldBe(visible);
    return this;
  }

  @Step("Gehe zur Checkout Seite")
  public CheckoutPage goToCheckout(){
    $(".checkout-button").click();
    return new CheckoutPage().isExpectedPage();
  }
}
