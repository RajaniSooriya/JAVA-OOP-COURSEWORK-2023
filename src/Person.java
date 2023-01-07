import java.time.LocalDate;

public class Person {
    // instance variables
    private String firstName;
    private String surname;
    private LocalDate dob;
    private String mobileNumber;

    public Person(String firstName, String surname, LocalDate dob, String mobileNumber) {
        this.firstName = firstName;
        this.surname = surname;
        this.dob = dob;
        this.mobileNumber = mobileNumber;
    }

    public Person() {

    }

    // getters and setters for instance variables
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

}


