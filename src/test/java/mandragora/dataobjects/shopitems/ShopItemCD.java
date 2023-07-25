package mandragora.dataobjects.shopitems;

public class ShopItemCD extends AbstractShopItem {

  private String albumType;

  public String getAlbumType() {
    return albumType;
  }

  @Override
  public String toString() {
    return "ShopItemCD{" +
        "albumType='" + albumType + '\'' +
        '}';
  }
}
