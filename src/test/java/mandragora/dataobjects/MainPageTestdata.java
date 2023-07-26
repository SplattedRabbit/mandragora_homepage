package mandragora.dataobjects;

import java.util.List;

public class MainPageTestdata extends AbstractBaseTestdata{

  private List<Bandmember> bandmembers;

  private int numberOfMeadAndGreedImages;

  private int numberOfMahlstromImages;

  public List<Bandmember> getBandmembers() {
    return bandmembers;
  }

  public int getNumberOfMeadAndGreedImages() {
    return numberOfMeadAndGreedImages;
  }

  public int getNumberOfMahlstromImages() {
    return numberOfMahlstromImages;
  }

  @Override
  public String toString() {
    return "MainPageTestdata{" +
        "bandmembers=" + bandmembers +
        ", numberOfMeadAndGreedImages=" + numberOfMeadAndGreedImages +
        ", numberOfMahlstromImages=" + numberOfMahlstromImages +
        '}';
  }
}
