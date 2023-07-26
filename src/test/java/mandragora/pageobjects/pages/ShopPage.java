package mandragora.pageobjects.pages;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.$$;
import io.qameta.allure.Step;

public class ShopPage extends AbstractPageObject {

  @Override
  public ShopPage isExpectedPage() {
    return this;
  }

  @Step("Öffne die Produktseite")
  public ShopItemPage goToProductPage(String shopItemName) {
    String linkPrefix = "https://test.mandragora-thuringia.de/de/produkt/";
    $$("#main .container li a").filterBy(
            attribute("href", linkPrefix + shopItemName.toLowerCase() + "/")).first()
        .click();
    return new ShopItemPage().isExpectedPage();
  }
}
