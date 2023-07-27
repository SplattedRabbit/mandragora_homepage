package mandragora.pageobjects.pages.paypalWindows;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import com.xceptance.neodymium.util.Neodymium;
import io.qameta.allure.Step;
import mandragora.pageobjects.pages.AbstractPageObject;

public class PaypalLoginPage extends AbstractPageObject {

  @Override
  @Step("Stelle sicher, dass die PayPal Loginpage korrekt angezeigt wird")
  public PaypalLoginPage isExpectedPage() {
    $("#headerText").shouldHave(exactText(Neodymium.localizedText("shop.paypal.loginPage")));
    $("form .proceed").shouldBe(visible);
    return this;
  }

  @Step("Logge dich bei Paypal ein")
  public PaypalPaymentPage paypalLogin(){
    return new PaypalPaymentPage().isExpectedPage();
  }
}
