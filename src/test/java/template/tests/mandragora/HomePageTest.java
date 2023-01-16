package template.tests.mandragora;

import org.junit.Test;

import com.xceptance.neodymium.util.Neodymium;

import template.flows.OpenPageFlows;
import template.tests.AbstractTest;

public class HomePageTest extends AbstractTest
{
    @Test
    public void testVisitingHomepage()
    {
        // Goto the home page and perform a short validation that we are on the correct page
        var homePage = OpenPageFlows.openHomePage();

        // basic validation
        homePage.validateStructure();
        homePage.title.validateTitle(Neodymium.localizedText("homepage.title"));

        //validate the content on the homepage
        homePage.welcomeBlock.validateSocialMediaIcons();
    }
}
