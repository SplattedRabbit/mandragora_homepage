package mandragora.pageobjects.components.homepage;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import com.google.gson.JsonObject;
import com.xceptance.neodymium.util.DataUtils;
import com.xceptance.neodymium.util.Neodymium;
import io.qameta.allure.Step;
import mandragora.pageobjects.components.AbstractComponent;

public class Merchandise extends AbstractComponent {

  public SelenideElement merchandiseBlock = $(".wp-block-handpicked-products");

  @Override
  @Step("Stelle sicher, dass die Merchandise-Komponente korrekt angezeigt wird")
  public void isComponentAvailable() {
    $("#merchandise").shouldHave(
        exactText(Neodymium.localizedText("homepage.merchandise.headline")));
    merchandiseBlock.shouldBe(visible);
  }

  @Step("Validiere den Inhalt der Merchandise-Sektion")
  public void validateMerchandise() {
    var merchandisePreviewArticle = merchandiseBlock.$$("li")
        .shouldHave(CollectionCondition.size(3));

    for (SelenideElement currentPreview : merchandisePreviewArticle) {
      // get the title of the shown shopitem to fetch to corresponding attribute values
      String currentMerchItemTitle = currentPreview.$(".wc-block-grid__product-title").getText();
      var currentMerchItem = DataUtils.getDataAsJsonObject().getAsJsonObject("merchPreview")
          .getAsJsonObject(currentMerchItemTitle);

      // ensure the item has the correct colour
      currentPreview.$(".wc-block-grid__product-image img").shouldHave(
          attribute("alt", altAttributeBuilder(currentMerchItemTitle, currentMerchItem)));

      // ensure the itemlink is correct
      currentPreview.$(".wc-block-grid__product-link").shouldHave(attribute("href",
          Neodymium.localizedText("homepage.merchandise.shoplink")
              + currentMerchItemTitle.toLowerCase()
              + "/"));

      //ensure the correct price is displayed
      currentPreview.$(".price")
          .shouldHave(exactText(currentMerchItem.getAsJsonPrimitive("price").getAsString()));
    }
  }

  private String altAttributeBuilder(String itemTitle, JsonObject merchItem) {
    String altValue;
    if (itemTitle.equals("Krake-Hoodie")) {
      altValue = itemTitle;
    } else {
      altValue = itemTitle.replaceFirst("-", " ") + " "
          + merchItem.getAsJsonPrimitive("colour").getAsString();
    }
    return altValue;
  }
}
