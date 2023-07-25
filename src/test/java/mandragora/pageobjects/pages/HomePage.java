package mandragora.pageobjects.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import mandragora.pageobjects.components.homepage.Biography;
import mandragora.pageobjects.components.homepage.Header;
import mandragora.pageobjects.components.homepage.Merchandise;
import mandragora.pageobjects.components.homepage.PhotoGallery;
import mandragora.pageobjects.components.homepage.TheBand;
import mandragora.pageobjects.components.homepage.Tourdates;
import mandragora.pageobjects.components.homepage.WelcomeBlock;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class HomePage extends AbstractPageObject {

  public Header pageHeader = new Header();

  public WelcomeBlock welcomeBlock = new WelcomeBlock();

  public Tourdates tourDates = new Tourdates();

  public TheBand theBand = new TheBand();

  public Biography biography = new Biography();

  public PhotoGallery photoGallery = new PhotoGallery();

  public Merchandise merchandise = new Merchandise();

  private final String headerImage = "https://test.mandragora-thuringia.de/wp-content/themes/mandragora/static/images/rex/MT_Rex-Logo_web.webp";

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
    pageHeader.validatePageHeader();
    welcomeBlock.isComponentAvailable();
  }
}
