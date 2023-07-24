package mandragora.dataobjects;

public class Bandmember {

    private String firstName;

    private String lastName;

    private String instrument;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getInstrument() {
        return instrument;
    }

    @Override
    public String toString() {
        return "Bandmember{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", instrument='" + instrument + '\'' +
                '}';
    }
}
