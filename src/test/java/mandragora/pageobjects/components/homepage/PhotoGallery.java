package mandragora.pageobjects.components.homepage;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import mandragora.pageobjects.components.AbstractComponent;

public class PhotoGallery extends AbstractComponent {

  public SelenideElement photoGalleryTitle;

  @Override
  @Step("Stelle sicher, dass die Fotogallerie korrekt angezeigt wird")
  public void isComponentAvailable() {
    // This is not the optimal solution but the title is to generic and as no identifier to find it but it ensures the visibility of the gallery title
    ElementsCollection allTitles = $$("h2.wp-block-heading");
    for(SelenideElement sectionTitle : allTitles){
      if (sectionTitle.has(exactText("Fotos"))){
        photoGalleryTitle = sectionTitle;
        break;
      }
    }
    photoGalleryTitle.shouldBe(visible);
  }

  @Step("Validiere die Darstellung der Fotogallerie")
  public void validatePhotoGallery(){

  }
}
