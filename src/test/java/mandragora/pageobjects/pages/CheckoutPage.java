package mandragora.pageobjects.pages;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import mandragora.dataobjects.Adress;
import mandragora.dataobjects.CustomerData;
import mandragora.dataobjects.PaymentMethods;
import org.openqa.selenium.By;

public class CheckoutPage extends AbstractPageObject {

  public SelenideElement billingFields = $(".checkout .woocommerce-billing-fields__field-wrapper");

  public SelenideElement federalStateDropdown = billingFields.$("#select2-billing_state-container");

  @Override
  @Step("Stelle sicher, dass die Checkoutpage korrekt dargstellt wird")
  public CheckoutPage isExpectedPage() {
    return this;
  }

  @Step("Gibt die Liefer- und Rechnungsdetails ein")
  public void enterShippingData(CustomerData customerData) {
    Adress customerAdress = customerData.getAdress();

    var billingFields = $(".checkout .woocommerce-billing-fields__field-wrapper");
    billingFields.$("#billing_first_name").val(customerData.getFirstName());
    billingFields.$("#billing_last_name").val(customerData.getLastName());
    billingFields.$("#billing_company").val(customerData.getCompanyName());

    billingFields
        .$("#billing_address_1")
        .val(customerAdress.getStreet() + " " + customerAdress.getHouseNumber());
    billingFields.$("#billing_postcode").val(customerAdress.getZipCode());
    billingFields.$("#billing_city").val(customerAdress.getCity());

    federalStateDropdown.click();
    $(".select2-search__field").val(customerAdress.getFederalState());
    $$(".select2-results__options li").shouldHave(size(1)).first().click();
    federalStateDropdown.getText().equals(customerAdress.getFederalState());

    billingFields.$("#billing_phone").val(customerData.getTelephoneNumber());
    billingFields.$("#billing_email").val(customerData.getMailAdress());
  }

  public void acceptTerms(){
    $("input#legal").click();
    $("input#data-download").click();
  }

  public void choosePaymentMethod(PaymentMethods paymentMethod) {
    SelenideElement payment = $("#payment");
    SelenideElement paypalServices = $("input#payment_method_ppcp-gateway");

    switch (paymentMethod) {
      case VORKASSE:
        payment.$("input#payment_method_bacs").click();
        break;
      case PAYPAL:
        paypalServices.click();
        var paymentFrame = Selenide.switchTo().frame(0);
        var paypalButtonContainer = paymentFrame.findElement(
            By.cssSelector(".paypal-button-container"));
        paypalButtonContainer.findElement(By.cssSelector(".paypal-button-number-0"))
            .click();
        break;
      case SEPA:
        paypalServices.click();
        $(".paypal-button-number-1 .paypal-logo-sepa").click();
        break;
      case GIROPAY:
        paypalServices.click();
        $(".paypal-button-number-2 .paypal-logo-giropay").click();
        break;
      case SOFORT:
        paypalServices.click();
        $(".paypal-button-number-3 .paypal-logo-sofort").click();
        break;
      case DEBIT:
        paypalServices.click();
        $(".paypal-button-number-4 .paypal-logo-card").click();
        break;
    }

  }
}
