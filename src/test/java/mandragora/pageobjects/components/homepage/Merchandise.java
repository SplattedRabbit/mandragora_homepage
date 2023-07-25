package mandragora.pageobjects.components.homepage;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
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
  }
}
