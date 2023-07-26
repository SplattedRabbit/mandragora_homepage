package mandragora.tests.shop;

import mandragora.flows.OpenPageFlows;
import mandragora.tests.AbstractTest;
import org.junit.Test;

public class CheckoutDigitalDownloadTest extends AbstractTest {

  @Test
  public void testCheckoutDigitalDownload() {
    // Goto the home page and perform a short validation that we are on the correct page
    var homePage = OpenPageFlows.openHomePage();

    // navigate to the shop
    var shop = homePage.pageHeader.navigationBar.openShop();
  }
}
