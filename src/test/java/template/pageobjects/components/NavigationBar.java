package template.pageobjects.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.xceptance.neodymium.util.Neodymium;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class NavigationBar extends AbstractComponent {

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
        .shouldHave(exactText(Neodymium.localizedText("homepage.navbar.termine")));

    // Validate the menu point 'Band'
    navBar
        .$("#menu-item-151 a")
        .shouldHave(exactText(Neodymium.localizedText("homepage.navbar.band")));

    // Validate the menu point 'Shop'
    navBar
        .$("#menu-item-325 a")
        .shouldHave(exactText(Neodymium.localizedText("homepage.navbar.shop")));

    // Validate the menu point 'Kontakte'
    navBar
        .$("#menu-item-152 a")
        .shouldHave(exactText(Neodymium.localizedText("homepage.navbar.kontakt")));
  }
}
