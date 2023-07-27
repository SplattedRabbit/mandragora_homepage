package mandragora.tests.shop;

import com.codeborne.selenide.Selenide;
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

    // navigate to the shop, get the desired item from testdata and navigate to the product in the Shop
    var shop = homePage.pageHeader.navigationBar.openShop();
    var shopItem = testdata.getShopItemByItemname(testdata.getShopItemName());

    var productPage = shop.goToProductPage(shopItem.getShopItem());
    var shoppingCart = productPage.addToShoppingCart(shopItem.getShopItem());

    var checkoutPage = shoppingCart.goToCheckout();
    checkoutPage.enterShippingData(testdata.getCustomerData());

    checkoutPage.acceptTerms();
    checkoutPage.choosePaymentMethod(testdata.getPaymentMethod());
    //comment
  }
}
