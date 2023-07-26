package mandragora.tests.shop;

import com.xceptance.neodymium.util.DataUtils;
import mandragora.dataobjects.CheckoutDigitalDownloadTestdata;
import mandragora.flows.OpenPageFlows;
import mandragora.tests.AbstractTest;
import org.junit.Before;
import org.junit.Test;

public class CheckoutDigitalDownloadTest extends AbstractTest {

  protected CheckoutDigitalDownloadTestdata testdata;

  @Before
  public void before() {
    testdata = DataUtils.get(CheckoutDigitalDownloadTestdata.class);
  }

  @Test
  public void testCheckoutDigitalDownload() {
    // Goto the home page and perform a short validation that we are on the correct page
    var homePage = OpenPageFlows.openHomePage();
    String productName = null;

    // navigate to the shop
    var shop = homePage.pageHeader.navigationBar.openShop();
    var productPage = shop.goToProductPage(testdata.getShopItemByItemname(testdata.getShopItemName()).getShopItem());
  }
}
