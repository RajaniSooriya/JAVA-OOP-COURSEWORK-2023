import java.time.LocalDate;

public class Patient extends Person {
    // instance variables
    private String id;

    public Patient(String name, String surname, LocalDate dob, String mobileNumber) {
        super(name, surname, dob, String.valueOf(mobileNumber));
        this.id = id;
    }

    public Patient() {

    }

    // getters and setters for instance variables
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
