package mandragora.dataobjects;

public class CheckoutDigitalDownloadTestdata extends AbstractBaseTestdata{

  private String shopItemName;

  private CustomerData customerData;

  private PaymentMethods paymentMethod;

  public String getShopItemName() {
    return shopItemName;
  }

  public CustomerData getCustomerData() {
    return customerData;
  }

  public PaymentMethods getPaymentMethod() {
    return paymentMethod;
  }

  @Override
  public String toString() {
    return "CheckoutDigitalDownloadTestdata{" +
        "shopItemName='" + shopItemName + '\'' +
        ", customerData=" + customerData +
        ", paymentMethod=" + paymentMethod +
        '}';
  }
}
