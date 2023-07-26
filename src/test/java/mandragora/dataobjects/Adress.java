package mandragora.dataobjects;

public class Adress {

  private String street;

  private String houseNumber;

  private String zipCode;

  private String city;

  private String federalState;

  public String getStreet() {
    return street;
  }

  public String getHouseNumber() {
    return houseNumber;
  }

  public String getZipCode() {
    return zipCode;
  }

  public String getCity() {
    return city;
  }

  public String getFederalState() {
    return federalState;
  }

  @Override
  public String toString() {
    return "Adress{" +
        "street='" + street + '\'' +
        ", housenumber='" + houseNumber + '\'' +
        ", zipCode='" + zipCode + '\'' +
        ", city='" + city + '\'' +
        ", federalState='" + federalState + '\'' +
        '}';
  }
}
