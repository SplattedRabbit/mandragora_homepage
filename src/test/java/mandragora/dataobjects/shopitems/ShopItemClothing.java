package mandragora.dataobjects.shopitems;

public class ShopItemClothing extends AbstractShopItem {

  private String colour;

  private String size;

  public String getColour() {
    return colour;
  }

  public String getSize() {
    return size;
  }

  @Override
  public String toString() {
    return "ShopItemShirt{" +
        "colour='" + colour + '\'' +
        ", size='" + size + '\'' +
        '}';
  }
}
