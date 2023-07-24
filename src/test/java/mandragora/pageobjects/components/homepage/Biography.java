package mandragora.pageobjects.components.homepage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import mandragora.pageobjects.components.AbstractComponent;

public class Biography extends AbstractComponent {

  @Override
  @Step("Stelle sicher, dass die Bandbiografie korrekt angezeigt wird")
  public void isComponentAvailable() {
    $("#band-bio").shouldBe(visible);
  }

  @Step("Validiere die Länge und Darstellung der Bandbiografie")
  public void validateBiography(){
    //TODO check for a viable solution since the <p></p> elements don't have a usable container around them
  }
}
