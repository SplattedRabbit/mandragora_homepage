package mandragora.dataobjects.shopitems;

public abstract class AbstractShopItem {

    private String productName;

    private ItemType itemType;

    private float price;

  public String getProductName() {
    return productName;
  }

  public ItemType getItemType() {
    return itemType;
  }

  public float getPrice() {
    return price;
  }

  @Override
  public String toString() {
    return "AbstractShopItem{" +
        "productName='" + productName + '\'' +
        ", itemType=" + itemType +
        ", price=" + price +
        '}';
  }
}
