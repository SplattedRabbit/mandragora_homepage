package template.tests.structure;

import org.junit.Test;

import com.xceptance.neodymium.util.Neodymium;

import template.flows.OpenPageFlows;
import template.tests.AbstractTest;

public class MainPageTest extends AbstractTest
{
    @Test
    public void testMandragoraThuringiaHomepage()
    {
        // Goto the home page and perform a short validation that we are on the correct page
        var homePage = OpenPageFlows.openHomePage();

        // basic validation
        homePage.validateStructure();
        homePage.title.validateTitle(Neodymium.localizedText("homepage.title"));

        //validate the content within the welcome block
        homePage.welcomeBlock.validateSocialMediaIcons();
homePage.welcomeBlock.validateWelcomeContentBlock();
        homePage.welcomeBlock.validatePartnerIcons();
    }
}
