package mandragora.dataobjects;

import java.util.List;

public class MainPageTestdata {

    private String testValue;

    private List<Bandmember> bandmembers;

    public String getTestValue() {
        return testValue;
    }

    public List<Bandmember> getBandmembers() {
        return bandmembers;
    }

    @Override
    public String toString() {
        return "MainPageTestdata{" +
                "testValue='" + testValue + '\'' +
                ", bandmembers=" + bandmembers +
                '}';
    }
}
