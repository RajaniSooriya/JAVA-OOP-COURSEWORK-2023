import java.time.LocalDate;

public class Patient extends Person { //patient is a subclass of the super class person
                                        //-----------INHERITANCE OOP CONCEPT FOLLOWS HERE----------------
    // instance variables
    private String id; // restricted access to this class attribute

    public Patient(String name, String surname, LocalDate dob, String mobileNumber) { //parameterized constructor
        super(name, surname, dob, String.valueOf(mobileNumber));
        this.id = id;
    }

    public Patient() { //no  arg constructor

    }

    // getters and setters for instance variables

    //get method for Id
    public String getId() {
        return id;
    }

    //set method for id

    public void setId(String id) {
        this.id = id;
    }

}
