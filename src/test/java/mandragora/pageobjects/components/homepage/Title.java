package mandragora.pageobjects.components.homepage;

import org.junit.Assert;

import com.xceptance.neodymium.util.SelenideAddons;

import static com.codeborne.selenide.Selenide.title;

import io.qameta.allure.Step;
import mandragora.pageobjects.components.AbstractComponent;

public class Title extends AbstractComponent {
  public void isComponentAvailable() {}

  @Step("Stelle sicher, dass der Title der Seite '{title}' lautet")
  public void validateTitle(String title) {
    SelenideAddons.wrapAssertionError(
        () -> {
          Assert.assertEquals(title, title());
        });
  }
}
