package template.pageobjects.components;

import com.codeborne.selenide.*;
import com.codeborne.selenide.conditions.AttributeWithValue;
import com.xceptance.neodymium.util.Neodymium;
import io.qameta.allure.Step;

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

  SelenideElement welcomeSocials = $(welcomeBlock + " .welcome-socials");

  SelenideElement welcomePartners = $(welcomeBlock + " .welcome-partners");

  @Override
  @Step("Stelle sicher, dass der welcome block verfügbar ist")
  public void isComponentAvailable() {
    $(welcomeBlock).shouldBe(visible);
  }

  @Step("Stelle sicher, dass die social media icons korrekt angezeigt werden")
  public void validateSocialMediaIcons() {

    // validate the youtube icon
    welcomeSocials
        .$(" .fa-youtube")
        .shouldBe(visible)
        .shouldHave(new AttributeWithValue("href", youtubeLink));

    // validate the spotify icon
    welcomeSocials
        .$(" .fa-spotify")
        .shouldBe(visible)
        .shouldHave(new AttributeWithValue("href", spotifyLink));

    // validate the instagram icon
    welcomeSocials
        .$(" .fa-instagram")
        .shouldBe(visible)
        .shouldHave(new AttributeWithValue("href", instagramLink));

    // validate the facebook icon
    welcomeSocials
        .$(" .fa-facebook")
        .shouldBe(visible)
        .shouldHave(new AttributeWithValue("href", facebookLink));
  }

  @Step("Stelle sicher, dass die Partner Icons korrekt angezeigt werden")
  public void validatePartnerIcons() {
    ElementsCollection partnerLinks = welcomePartners.$$(" .partner-link");
    partnerLinks.shouldHave(CollectionCondition.size(2));

    // validate the mdd-records icon
    partnerLinks
        .get(0)
        .shouldHave(
            new AttributeWithValue(
                "title", Neodymium.localizedText("homepage.partnerLinks.mddRecords")))
        .shouldHave(new AttributeWithValue("href", mddRecordsLink));

    // validate the pyramid strings icon
    partnerLinks
        .get(1)
        .shouldHave(
            new AttributeWithValue(
                "title", Neodymium.localizedText("homepage.partnerLinks.pyramidStrings")))
        .shouldHave(new AttributeWithValue("href", pyramidStringsLink));
  }
}
