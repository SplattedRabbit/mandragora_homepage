package template.flows;

import com.codeborne.selenide.AuthenticationType;
import com.xceptance.neodymium.util.Neodymium;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.open;

import io.cucumber.java.en.And;
import io.qameta.allure.Step;
import template.pageobjects.pages.HomePage;

public class OpenPageFlows {
  @Step("Öffne die die Websiteund logge den Benutzer per htaccess an")
  public static HomePage openHomePage() {
    // clear browser cookies to remove old data
    clearBrowserCookies();

    // navigate to the home page and login
    open(
        Neodymium.configuration().url(),
        AuthenticationType.BASIC,
        Neodymium.configuration().basicAuthUsername(),
        Neodymium.configuration().basicAuthPassword());
    return new HomePage().isExpectedPage();
  }
}
