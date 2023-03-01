package template.pageobjects.components.homepage;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.xceptance.neodymium.util.Neodymium;
import io.qameta.allure.Step;
import template.pageobjects.components.AbstractComponent;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Tourdates extends AbstractComponent {

  public String tableSelector = ".event-table";

  @Override
  @Step("Stelle sicher, dass die Tourdatenkomponente verfügbar ist")
  public void isComponentAvailable() {
    $("#tourdates")
        .shouldHave(Condition.exactText(Neodymium.localizedText("homepage.tourdates.headline")));
    $(tableSelector).shouldBe(visible);
  }

  @Step("")
  public void validateTourdates() {
    ElementsCollection tourDates = $$(tableSelector + "tr");
    for (SelenideElement tourdate : tourDates) {
      ElementsCollection tourdateCells = tourdate.$$("td");
      for (SelenideElement tourdateCell : tourdateCells) {
        tourdate.shouldNotBe(empty);
      }
    }
  }
}
