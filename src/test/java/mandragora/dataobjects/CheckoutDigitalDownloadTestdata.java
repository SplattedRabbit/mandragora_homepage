package mandragora.dataobjects;

public class CheckoutDigitalDownloadTestdata extends AbstractBaseTestdata{

  private String shopItemName;

  public String getShopItemName() {
    return shopItemName;
  }

  @Override
  public String toString() {
    return "CheckoutDigitalDownloadTestdata{" +
        "shopItem='" + shopItemName + '\'' +
        '}';
  }
}
