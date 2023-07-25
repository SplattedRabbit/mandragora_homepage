package mandragora.pageobjects.components.homepage;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.xceptance.neodymium.util.Neodymium;
import io.qameta.allure.Step;
import mandragora.dataobjects.MainPageTestdata;
import mandragora.pageobjects.components.AbstractComponent;

public class PhotoGallery extends AbstractComponent {

  public SelenideElement photoGalleryTitle;

  @Override
  @Step("Stelle sicher, dass die Fotogallerie korrekt angezeigt wird")
  public void isComponentAvailable() {

    //TODO add availability-check for the individual galleries

    // This is not the optimal solution but the title is to generic and as no identifier to find it
    // but it ensures the visibility of the gallery title
    ElementsCollection allTitles = $$("h2.wp-block-heading");
    for (SelenideElement sectionTitle : allTitles) {
      if (sectionTitle.has(exactText("Fotos"))) {
        photoGalleryTitle = sectionTitle;
        break;
      }
    }
    photoGalleryTitle.shouldBe(visible);
  }

  @Step("Validiere die Darstellung der Fotogallerie")
  public void validatePhotoGallery(MainPageTestdata testdata) {
    ElementsCollection allGalleries = $$("h3.wp-block-heading");

    SelenideElement meadAndGreedGallery = allGalleries.get(0);
    SelenideElement mahlstromGallery = allGalleries.get(1);

    meadAndGreedGallery.shouldHave(
        exactText(Neodymium.localizedText("homepage.photoGalleries.meadAndGreed")));
    $("#foogallery-gallery-4770").$$(".fg-type-image")
        .shouldHave(size(testdata.getNumberOfMeadAndGreedImages()));

    mahlstromGallery.shouldHave(
        exactText(Neodymium.localizedText("homepage.photoGalleries.mahlstrom")));
    $("#foogallery-gallery-4560").$$(".fg-type-image")
        .shouldHave(size(testdata.getNumberOfMahlstromImages()));
  }
}
