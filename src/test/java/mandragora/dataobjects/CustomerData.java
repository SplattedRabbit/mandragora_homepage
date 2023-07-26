package mandragora.dataobjects;

public class CustomerData {

  private String firstName;

  private String lastName;

  private String companyName;

  private Adress adress;

  private String telephoneNumber;

  private String mailAdress;

  private String additionalInfo;

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getCompanyName() {
    return companyName;
  }

  public Adress getAdress() {
    return adress;
  }

  public String getTelephoneNumber() {
    return telephoneNumber;
  }

  public String getMailAdress() {
    return mailAdress;
  }

  public String getAdditionalInfo() {
    return additionalInfo;
  }

  @Override
  public String toString() {
    return "CustomerData{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", companyName='" + companyName + '\'' +
        ", adress=" + adress +
        ", telephoneNumber='" + telephoneNumber + '\'' +
        ", mailAdress='" + mailAdress + '\'' +
        ", additionalInfo='" + additionalInfo + '\'' +
        '}';
  }
}
