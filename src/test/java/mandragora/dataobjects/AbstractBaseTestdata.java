package mandragora.dataobjects;

import java.util.List;
import mandragora.dataobjects.shopitems.Shopitem;

public class AbstractBaseTestdata {

  protected Shopitem shopItem;

  private List<Shopitem> shopItems;

  public Shopitem getShopItemByItemname(final String itemname){
    return shopItems.stream().filter(shopItem -> shopItem.getShopItem().equals(itemname)).findFirst().get();
  }
}
