package mandragora.Utils;

import com.xceptance.neodymium.util.Neodymium;

public class MTHelper {

  public static final long standardWaitingTime = Neodymium.configuration().selenideTimeout();
  public static final long shortWaitingTime = standardWaitingTime / 3;
  public static final long doubleWaitingTime = standardWaitingTime * 2;
  public static final long tripleWaitingTime = standardWaitingTime * 3;
  public static final long mediumWaitingTime = standardWaitingTime * 5;
  public static final long longWaitingTime = standardWaitingTime * 10;
}
