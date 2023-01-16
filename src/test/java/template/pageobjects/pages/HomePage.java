package template.pageobjects.pages;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import template.pageobjects.components.WelcomeBlock;

public class HomePage extends AbstractPageObject {

  public WelcomeBlock welcomeBlock = new WelcomeBlock();

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
    welcomeBlock.isComponentAvailable();
  }
}
