package mandragora.pageobjects.components.homepage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.xceptance.neodymium.util.Neodymium;
import io.qameta.allure.Step;
import mandragora.pageobjects.components.AbstractComponent;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;

public class NavigationBar extends AbstractComponent {

  private String datesLink = "https://test.mandragora-thuringia.de//de/#tourdates";

  private String bandLink = "https://test.mandragora-thuringia.de//de/#band";

  private String shopLink = "https://test.mandragora-thuringia.de/de/shop/";

  private String contactLink = "https://test.mandragora-thuringia.de//de/#contact";

  SelenideElement navBar = $(".main-header .navbar");

  @Override
  @Step("Stelle sicher, dass die Navigationsleiste verfübar ist")
  public void isComponentAvailable() {
    navBar.shouldBe(Condition.visible);
  }

  @Step("Stelle sicher, dass alle Menüpunkte vorhanden sind")
  public void validateMenubar() {
    // Validate the menu point 'Termine'
    navBar
        .$("#menu-item-14 a")
        .shouldHave(exactText(Neodymium.localizedText("homepage.navbar.termine")))
        .shouldHave(attribute("href", datesLink));

    // Validate the menu point 'Band'
    navBar
        .$("#menu-item-151 a")
        .shouldHave(exactText(Neodymium.localizedText("homepage.navbar.band")))
        .shouldHave(attribute("href", bandLink));

    // Validate the menu point 'Shop'
    navBar
        .$("#menu-item-325 a")
        .shouldHave(exactText(Neodymium.localizedText("homepage.navbar.shop")))
        .shouldHave(attribute("href", shopLink));

    // Validate the menu point 'Kontakte'
    navBar
        .$("#menu-item-152 a")
        .shouldHave(exactText(Neodymium.localizedText("homepage.navbar.kontakt")))
        .shouldHave(attribute("href", contactLink));
  }
}
