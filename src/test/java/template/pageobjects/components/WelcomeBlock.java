package template.pageobjects.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.AttributeWithValue;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class WelcomeBlock extends AbstractComponent {

  SelenideElement welcomeBlock = $(".wp-block-create-block-welcome-block");

  private String youtubeLink = "https://www.youtube.com/channel/UCCcgiUD1kkygAtybMk1f5Tg";

  private String spotifyLink = "https://open.spotify.com/artist/3u0jBGQP9MtGV6mCYZmMnU";

  private String instagramLink = "https://www.instagram.com/mandragorathuringia_official";

  private String facebookLink = "https://www.facebook.com/MandragoraTH/";

  @Override
  @Step("Stelle sicher, dass der welcome block verfügbar ist")
  public void isComponentAvailable() {
    welcomeBlock.shouldBe(visible);
  }

  @Step("Stelle sicher, dass die social media icons korrekt angezeigt werden")
  public void validateSocialMediaIcons() {

    // validate the youtube icon
    welcomeBlock
        .$(" .fa-youtube")
        .shouldBe(visible)
        .shouldHave(new AttributeWithValue("href", youtubeLink));

    // validate the spotify icon
    welcomeBlock
        .$(" .fa-spotify")
        .shouldBe(visible)
        .shouldHave(new AttributeWithValue("href", spotifyLink));

    // validate the instagram icon
    welcomeBlock
        .$(" .fa-instagram")
        .shouldBe(visible)
        .shouldHave(new AttributeWithValue("href", instagramLink));

    // validate the facebook icon
    welcomeBlock
        .$(" .fa-facebook")
        .shouldBe(visible)
        .shouldHave(new AttributeWithValue("href", facebookLink));
  }
}
