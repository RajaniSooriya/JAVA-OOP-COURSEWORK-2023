import java.time.LocalDate; //to display the current date using this import statement

public class Person {               //Person is a superclass
    // instance variables
    private String firstName;       //these four variables are restricted using the private access modifier
                                    //---------------ENCAPSULATION METHOD IS BEING USED HERE ------------------------------------
    private String surname;         //restricted access
    private LocalDate dob;          //restricted access
    private String mobileNumber;    //restricted access

    //this parameterized constructor initialize the attributes of the class
    public Person(String firstName, String surname, LocalDate dob, String mobileNumber) { //this is a parameterized constructor
        this.firstName = firstName;
        this.surname = surname;
        this.dob = dob;
        this.mobileNumber = mobileNumber;
    }

    public Person() { //this is a non arg constructor ,this is made to call the super class constructor

    }

    //get methods and set methods are provided for to access the value of the private variables

    //get method for firstName
    public String getFirstName() {
        return firstName;
    }

    //set method for firstName
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //get method for surname
    public String getSurname() {
        return surname;
    }

    //set method for surname
    public void setSurname(String surname) {
        this.surname = surname;
    }

    //get method for date
    public LocalDate getDob() {
        return dob;
    }

    //set method for date
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    //get method for mobileNumber
    public String getMobileNumber() {
        return mobileNumber;
    }

    //set method for mobileNumber
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

}


