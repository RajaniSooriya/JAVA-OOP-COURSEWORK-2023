import java.time.LocalDate; //to display the current date using this import statement

public class Doctor extends Person { //doctor is a subclass of the person superclass
    // instance variables
    private String medicalLicenseNumber; //restricted access
    private String specialization;      //restricted access


    public Doctor(String firstName, String surname, LocalDate dob, String mobileNumber, String medicalLicenseNumber, String specialization) { //this is a parameterized constructor
        super(firstName, surname, dob,mobileNumber);
        this.medicalLicenseNumber = medicalLicenseNumber;
        this.specialization = specialization;
    }

    public Doctor() {  //this is a non arg constructor ,this is made to call the super class constructor
        super();
    }


    // get method for medicaLicenseNumber
    public String getMedicalLicenseNumber() {
        return medicalLicenseNumber;
    }

    //set method for medicalLicenseNumber
    public void setMedicalLicenseNumber(String medicalLicenseNumber) {
        this.medicalLicenseNumber = medicalLicenseNumber;
    }

    //get method for specialization

    public String getSpecialization() {
        return specialization;
    }

    //set method for specialization
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }



}
