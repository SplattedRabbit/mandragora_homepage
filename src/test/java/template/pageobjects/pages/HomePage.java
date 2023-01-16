package template.pageobjects.pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.AttributeWithValue;
import io.qameta.allure.Step;
import template.pageobjects.components.NavigationBar;
import template.pageobjects.components.WelcomeBlock;

public class HomePage extends AbstractPageObject {

  public WelcomeBlock welcomeBlock = new WelcomeBlock();

  public NavigationBar navigationBar = new NavigationBar();

  private String headerImage = "https://test.mandragora-thuringia.de/wp-content/themes/mandragora/static/images/rex/MT_Rex-Logo_web.webp";

  SelenideElement pageTemplate = $(".page-template");


  @Override
  @Step("Stelle sicher, dass die Startseite korrekt dargestellt wird")
  public HomePage isExpectedPage() {
    pageTemplate.$(" .header-image").shouldBe(visible);
    pageTemplate.$(" .main-navigation").shouldBe(visible);
    return this;
  }

  @Step("Stelle sicher, dass die Homepage korrekt angezeigt wird")
  public void validateStructure() {
    super.validateStructure();
    $(".header-image").shouldHave(attribute("src", headerImage));
    navigationBar.isComponentAvailable();
    welcomeBlock.isComponentAvailable();
  }
}
