import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.*;

public class WestminsterSkinConsultationManager implements SkinConsultationManager {
    static Scanner input = new Scanner(System.in);
    public static ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
    private static final int MAX_DOCTORS = 10;

//    private static test Test = new test();

//    public WestminsterSkinConsultationManager() {
//        this.doctorList = new ArrayList<>();
//    }

    // Displays a menu of management actions for the user to choose from.
    public void displayMenu() throws IOException {
        Boolean displayMenu = true;
        while (displayMenu) {
            System.out.println("\n------------- Welcome to Skin Consultation Centre -------------");
            System.out.println("==============================================================\n");
            System.out.println("Enter 1 to add a new doctor");
            System.out.println("Enter 2 to delete a doctor");
            System.out.println("Enter 3 to print the list of doctors");
            System.out.println("Enter 4 to save doctors details to a file");
            System.out.println("Enter 5 to load data from a file");
            System.out.println("Enter 6 to Launch GUI");
            System.out.println("Enter 0 to Exit");
            System.out.println("=======================================================");
            String select = input.next();
            switch (select) {
                case "1":
                    addDoctor();
                    break;
                case "2":
                    deleteDoctor();
                    break;
                case "3":
                    viewDoctor();
                    break;
                case "4":
                    storeData();
                    break;
                case "5":
                    readData();
                    break;
                case "6":
                    GUI();
                    break;
                case "0":
                    System.out.println("------------- Thank You for using Skin Consultation Centre ------------");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter a valid input...");
            }
        }
    }


    // Adds a new doctor to the system. Returns true if successful, false if there are already
    // MAX_DOCTORS doctors in the system.
    private void addDoctor() {
        System.out.println("\n-----------Add new Doctor-----------");
        boolean full = true;
        while (full) {
            try {
                if (doctorList.size() < MAX_DOCTORS) {

                    System.out.println("Enter your First name : ");
                    String fname = input.next();

                    System.out.println("Enter your Surname : ");
                    String sname = input.next();

                    System.out.print("Enter your date of birth (yyyy/mm/dd): ");
                    String date = input.next();
                    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/d");
                    LocalDate dob = LocalDate.parse(date,dateFormatter);

                    System.out.println("Enter your Mobile Number : ");
                    String mobileNum = input.next();

                    System.out.println("Enter your Medical Licence Number : ");
                    String medicalLicenseNumber = input.next();

                    System.out.println("Enter Specialization : (cosmetic dermatology, medical dermatology, paediatric,dermatology)");
                    String specialisation = input.next();

                    Doctor doctor = new Doctor();
                    doctor.setFirstName(fname);
                    doctor.setSurname(sname);
                    doctor.setDob(dob);
                    doctor.setMobileNumber(mobileNum);
                    doctor.setMedicalLicenseNumber(medicalLicenseNumber);
                    doctor.setSpecialization(specialisation);

                    // Doctor docArray = new Doctor();
                    doctorList.add(doctor);
                    break;
                }else {
                    System.out.println("Maximum Doctor counter is exceeded.");
                    //Queue Method
                }
            } catch (Exception e) {
                //if user entered wrong input
                input.nextLine(); //to stop printing error message infinitely
                System.out.println("Invalid input. Please try again...");
                full = true;
            }
        }

    }

    private void viewDoctor() {
        System.out.println("\n--------View Doctor-----------");
        for (Doctor DocObj : doctorList) {
            System.out.println("Doctor's first Name " + DocObj.getFirstName());
            System.out.println("Doctor's surName " + DocObj.getSurname());
            System.out.println("Doctor's Date of Birth " + DocObj.getDob());
            System.out.println("Doctor's Mobile Number " + DocObj.getMobileNumber());
            System.out.println("Doctor's Medical Licence " + DocObj.getMedicalLicenseNumber());
            System.out.println("Doctor's Specialization " + DocObj.getSpecialization() + "\n" );
        }
    }

    private void deleteDoctor() {
        System.out.println("\n-----------Delete Doctor-----------");
        boolean x = true;
        System.out.println("Enter medical LicenseNumber of Doctor to be deleted");
        while (x) {
            try {
                String medicalLicenseNumber = input.next();
                for (Doctor DocObj : doctorList) {
                    if (DocObj.getMedicalLicenseNumber().equals((medicalLicenseNumber))) {
                        doctorList.remove(DocObj);
                        System.out.println(medicalLicenseNumber + " is Deleted...");
                        x = false;
                        break;
                    }
                    if (DocObj.getMedicalLicenseNumber().equalsIgnoreCase(medicalLicenseNumber)) {
                        System.out.println("PLEASE ENTER VALID");
                    }
                }
            } catch (Exception e) {
                //if user entered wrong input
                input.nextLine(); //to stop printing error message infinitely
                System.out.println("Invalid input. Please try again...");
            }
        }
    }


    //save data into .txt file
    public void storeData() throws IOException {
        try {
            FileWriter output = new FileWriter("SkinConsultationCentre.txt"); //Create FileWriter and create .txt file
            for (Doctor DocObj : doctorList) {
                //write data into txt file
                output.write("Doctor's first Name : " + DocObj.getFirstName()+ "\n");
                output.write("Doctor's surName : " + DocObj.getSurname()+ "\n");
                output.write("Doctor's Date of Birth : " + DocObj.getDob()+ "\n");
                output.write("Doctor's Mobile Number : " + DocObj.getMobileNumber()+ "\n");
                output.write("Doctor's Medical Licence : " + DocObj.getMedicalLicenseNumber()+ "\n");
                output.write("Doctor's Specialization : " + DocObj.getSpecialization()+ "\n\n");
            }
            output.close(); //close the writer
            System.out.println("Data is successfully stored in the file...");
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    //read Data from .txt file
    public void readData() {
        System.out.println("-------------------- Load Doctor's Data --------------------\n");
        try {
            File readData = new File("SkinConsultationCentre.txt"); //create object
            Scanner read = new Scanner(readData);
            while (read.hasNextLine()) { //read txt file line
                String data = read.nextLine();
                System.out.println(data); //print data
            }
            read.close();//close the reader

        } catch (FileNotFoundException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public void GUI(){
        GUI_mainScreen gui = new GUI_mainScreen();
GUI_payment pay = new GUI_payment();
    }



}
