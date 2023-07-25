package mandragora.pageobjects.components.homepage;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import mandragora.pageobjects.components.AbstractComponent;

public class Merchandise extends AbstractComponent {

  public SelenideElement merchandise;

  @Override
  @Step("Stelle sicher, dass die Merchandise-Komponente korrekt angezeigt wird")
  public void isComponentAvailable() {
    // This is not the optimal solution but the title is to generic and as no identifier to find it
    // but it ensures the visibility of the merchandise title
    ElementsCollection allTitles = $$("h2.wp-block-heading");
    for (SelenideElement sectionTitle : allTitles) {
      if (sectionTitle.has(exactText("Fotos"))) {
        merchandise = sectionTitle;
        break;
      }
    }
    merchandise.shouldBe(visible);
  }

  @Step("Validiere den Inhalt der Merchandise-Sektion")
  public void validateMerchandise(){



  }
}
