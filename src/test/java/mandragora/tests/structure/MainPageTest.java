package mandragora.tests.structure;

import com.xceptance.neodymium.util.DataUtils;
import com.xceptance.neodymium.util.Neodymium;
import mandragora.dataobjects.MainPageTestdata;
import org.junit.Test;
import mandragora.flows.OpenPageFlows;
import mandragora.tests.AbstractTest;

public class MainPageTest extends AbstractTest {

  protected MainPageTestdata testdata;
  @Test
  public void testMandragoraThuringiaHomepage() {
    // Setup testdata
    testdata = DataUtils.get(MainPageTestdata.class);

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

    // validate the content within the tour dates block
    homePage.tourDates.isComponentAvailable();
    homePage.tourDates.validateTourdates();
  }
}
