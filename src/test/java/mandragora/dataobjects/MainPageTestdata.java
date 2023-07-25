package mandragora.dataobjects;

import java.util.List;

public class MainPageTestdata {

    private String testValue;

    private List<Bandmember> bandmembers;

    private int numberOfMeadAndGreedImages;

    private int numberOfMahlstromImages;



    public String getTestValue() {
        return testValue;
    }

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
            "testValue='" + testValue + '\'' +
            ", bandmembers=" + bandmembers +
            ", numberOfMeadAndGreedImages=" + numberOfMeadAndGreedImages +
            ", numberOfMahlstromImages=" + numberOfMahlstromImages +
            '}';
    }
}
