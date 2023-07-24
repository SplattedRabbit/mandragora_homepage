package mandragora.pageobjects.components.homepage;


import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import mandragora.dataobjects.Bandmember;
import mandragora.pageobjects.components.AbstractComponent;

import java.util.List;

public class TheBand extends AbstractComponent {

  public String GALLERY_SELECTOR = "#foogallery-gallery-213";

  public SelenideElement gallery = $(GALLERY_SELECTOR);

  public ElementsCollection imageGallery = $$(GALLERY_SELECTOR + " .fg-item");

  @Override
  @Step("Stelle sicher, dass die Komponente zur Vorstellung der Band korrekt angezeigt wird")
  public void isComponentAvailable() {
    $("#band").shouldBe(visible);
    gallery.shouldBe(visible);
    imageGallery.shouldHave(size(7));
  }

  @Step("Validiere den Inhalt der Bandgallerie und den dazugehörigen Bildtiteln")
  public void validateGallery(List<Bandmember> bandmembers){
    for(int i = 0; i < bandmembers.size(); i++) {
      var image = imageGallery.get(i);
      image.$("[data-caption-title]").shouldHave(text(bandmembers.get(i).getFirstName()));
    }
  }
}
