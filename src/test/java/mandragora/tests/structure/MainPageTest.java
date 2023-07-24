package mandragora.tests.structure;

import com.xceptance.neodymium.util.DataUtils;
import com.xceptance.neodymium.util.Neodymium;
import mandragora.dataobjects.MainPageTestdata;
import org.junit.Before;
import org.junit.Test;
import mandragora.flows.OpenPageFlows;
import mandragora.tests.AbstractTest;

public class MainPageTest extends AbstractTest {

  protected MainPageTestdata testdata;

  @Before
  public void before() {
    testdata = DataUtils.get(MainPageTestdata.class);
  }

  @Test
  public void testMandragoraThuringiaHomepage() {

    // Goto the home page and perform a short validation that we are on the correct page
    var homePage = OpenPageFlows.openHomePage();
    var test = testdata.getTestValue();
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

    // validate the content within the 'the band' block
    homePage.theBand.isComponentAvailable();
    homePage.theBand.validateGallery(testdata.getBandmembers());
  }
}
