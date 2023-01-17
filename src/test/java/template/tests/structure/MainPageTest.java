package template.tests.structure;

import com.xceptance.neodymium.util.Neodymium;
import org.junit.Test;
import template.flows.OpenPageFlows;
import template.tests.AbstractTest;

public class MainPageTest extends AbstractTest {
  @Test
  public void testMandragoraThuringiaHomepage() {
    // Goto the home page and perform a short validation that we are on the correct page
    var homePage = OpenPageFlows.openHomePage();

    // basic validation
    homePage.title.validateTitle(Neodymium.localizedText("homepage.title"));
    homePage.validateStructure();

    // validate the navigation bar
    homePage.pageHeader.navigationBar.validateMenubar();

    // validate the content within the welcome block
    homePage.welcomeBlock.validateSocialMediaIcons();
    homePage.welcomeBlock.validateWelcomeContentBlock();
    homePage.welcomeBlock.validatePartnerIcons();
  }
}
