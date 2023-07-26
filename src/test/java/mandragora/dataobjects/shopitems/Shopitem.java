package mandragora.dataobjects.shopitems;

public class Shopitem {

  private String shopItem;

  private ItemType itemType;

  private String price;

  private String colour;

  private String size;

  public String getShopItem() {
    return shopItem;
  }

  public ItemType getItemType() {
    return itemType;
  }

  public String getPrice() {
    return price;
  }

  public String getColour() {
    return colour;
  }

  public String getSize() {
    return size;
  }

  @Override
  public String toString() {
    return "Shopitem{" +
        "shopItem='" + shopItem + '\'' +
        ", itemType=" + itemType +
        ", price='" + price + '\'' +
        ", colour='" + colour + '\'' +
        ", size='" + size + '\'' +
        '}';
  }
}
