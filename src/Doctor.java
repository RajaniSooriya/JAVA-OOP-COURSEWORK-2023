import java.time.LocalDate;

public class Doctor extends Person {
    // instance variables
    private String medicalLicenseNumber;
    private String specialization;


    public Doctor(String firstName, String surname, LocalDate dob, String mobileNumber, String medicalLicenseNumber, String specialization) {
        super(firstName, surname, dob,mobileNumber);
        this.medicalLicenseNumber = medicalLicenseNumber;
        this.specialization = specialization;
    }

    public Doctor() {
        super();
    }


    // getters and setters for instance variables
    public String getMedicalLicenseNumber() {
        return medicalLicenseNumber;
    }

    public void setMedicalLicenseNumber(String medicalLicenseNumber) {
        this.medicalLicenseNumber = medicalLicenseNumber;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }



}
