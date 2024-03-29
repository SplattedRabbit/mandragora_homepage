package mandragora.pageobjects.components.homepage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.xceptance.neodymium.util.Neodymium;
import io.qameta.allure.Step;
import mandragora.pageobjects.components.AbstractComponent;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class WelcomeBlock extends AbstractComponent {

  private String welcomeBlock = ".wp-block-create-block-welcome-block";

  private String youtubeLink = "https://www.youtube.com/channel/UCCcgiUD1kkygAtybMk1f5Tg";

  private String spotifyLink = "https://open.spotify.com/artist/3u0jBGQP9MtGV6mCYZmMnU";

  private String instagramLink = "https://www.instagram.com/mandragorathuringia_official";

  private String facebookLink = "https://www.facebook.com/MandragoraTH/";

  private String mddRecordsLink = "https://mdd-records.de/";

  private String pyramidStringsLink = "https://pyramid-saiten.de/";

  private String welcomeImageLink =
      "https://mandragora-thuringia.de/wp-content/uploads/2022/09/RexSilvarum_Artwork_1000.jpg";

  SelenideElement welcomeSocials = $(welcomeBlock + " .welcome-socials");

  SelenideElement welcomePartners = $(welcomeBlock + " .welcome-partners");

  SelenideElement welcomeContent = $(welcomeBlock + " .welcome-content");

  @Override
  @Step("Stelle sicher, dass der welcome block verfügbar ist")
  public void isComponentAvailable() {
    welcomeSocials.shouldBe(visible);
    welcomePartners.shouldBe(visible);
    welcomeContent.shouldBe(visible);
  }

  @Step("Stelle sicher, dass die social media icons korrekt angezeigt werden")
  public void validateSocialMediaIcons() {

    // validate the youtube icon
    welcomeSocials.$(" .fa-youtube").shouldBe(visible).shouldHave(attribute("href", youtubeLink));

    // validate the spotify icon
    welcomeSocials.$(" .fa-spotify").shouldBe(visible).shouldHave(attribute("href", spotifyLink));

    // validate the instagram icon
    welcomeSocials
        .$(" .fa-instagram")
        .shouldBe(visible)
        .shouldHave(attribute("href", instagramLink));

    // validate the facebook icon
    welcomeSocials.$(" .fa-facebook").shouldBe(visible).shouldHave(attribute("href", facebookLink));
  }

  @Step("Stelle sicher, dass das welcome image korrekt angezeigt wird")
  public void validateWelcomeContentBlock() {
    SelenideElement imageContainer = welcomeContent.$(" .image-container");

    welcomeContent
        .$(".mt-2.text-center")
        .shouldHave(exactText(Neodymium.localizedText("homepage.welcomeContent.imageSubtitle")));

    imageContainer.shouldBe(visible);
    imageContainer.$("img").shouldHave(attribute("src", welcomeImageLink));
  }

  @Step("Stelle sicher, dass die Partner Icons korrekt angezeigt werden")
  public void validatePartnerIcons() {
    ElementsCollection partnerLinks = welcomePartners.$$(" .partner-link");
    partnerLinks.shouldHave(size(2));

    // validate the mdd-records icon
    partnerLinks
        .get(0)
        .shouldHave(attribute("title", Neodymium.localizedText("homepage.partnerLinks.mddRecords")))
        .shouldHave(attribute("href", mddRecordsLink));

    // validate the pyramid strings icon
    partnerLinks
        .get(1)
        .shouldHave(
            attribute("title", Neodymium.localizedText("homepage.partnerLinks.pyramidStrings")))
        .shouldHave(attribute("href", pyramidStringsLink));
  }
}
