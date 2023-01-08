import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

//git clone test
public class GUI_patient extends JFrame implements ActionListener {

    //used in encryption
    Encryption encryption = new Encryption();
    final String secretKey = "secrete";
    private String JTextArea;
    String encryptedString = encryption.encrypt(JTextArea, secretKey);
    String decryptedString = encryption.decrypt(encryptedString, secretKey);

    //encryption and decryption
    private Container container;
    private JLabel label1, label2,cost;
    private JButton nextBtn, addImageBtn,Cost;
    JFrame frame = new JFrame();
    JTextField PatN_textField = new JTextField();
    JTextField PatL_textField = new JTextField();
    JTextField PatID_textField = new JTextField();
    JTextField PatMob_textField = new JTextField();
    JTextField PatDate_textField = new JTextField();
    JTextField ConsDate_textField = new JTextField();
    JTextField ConsHours_textField = new JTextField();
    JTextArea textArea = new JTextArea();

    JFileChooser fileChooser = new JFileChooser();
    JComboBox comboBox = new JComboBox();
    ArrayList<Doctor> listOfDoctors = WestminsterSkinConsultationManager.doctorList;
    public String[] doctor = new String[listOfDoctors.size()];
    public static  Patient pat_list = new Patient();
    //    creating a genetic array list
    public static ArrayList<Patient> pat_init = new ArrayList<Patient>();
    public static ArrayList<Consultation> consultation = new ArrayList<Consultation>();
    public static Consultation cons_list = new Consultation();
    ImageIcon image = new ImageIcon("doctor.png");
    GUI_patient() {


        setTitle("Patients Form");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
        setIconImage(image.getImage());
        setResizable(true);

        container = getContentPane();
        container.setLayout(null);
        container.setBackground(new Color(0xb4e7ce));

        label1 = new JLabel("SKIN CONSULTATION CENTRE");
        label1.setFont(new Font("MV Boil", Font.BOLD, 23));
        label1.setSize(350, 50);
        label1.setLocation(35, 15);
        container.add(label1);

        label1 = new JLabel("Patient Form");
        label1.setFont(new Font("MV Boil", Font.BOLD, 20));
        label1.setSize(300, 50);
        label1.setLocation(35, 50);
        container.add(label1);

        label1 = new JLabel("First Name");
        label1.setSize(300, 100);
        label1.setFont(new Font("MV Boil", Font.PLAIN, 17));
        label1.setLocation(35, 75);
        container.add(label1);

        PatN_textField = new JTextField();
        PatN_textField.setSize(200, 27);
        PatN_textField.setLocation(200, 115);
        PatN_textField.setBackground(new Color(0xE6E6E6));
        container.add(PatN_textField);

        label1 = new JLabel("Last Name");
        label1.setSize(300, 100);
        label1.setFont(new Font("MV Boil", Font.PLAIN, 17));
        label1.setLocation(35, 125);
        container.add(label1);

        PatL_textField = new JTextField();
        PatL_textField.setSize(200, 27);
        PatL_textField.setLocation(200, 165);
        PatL_textField.setBackground(new Color(0xE6E6E6));
        container.add(PatL_textField);

        label1 = new JLabel("Date of Birth");
        label1.setSize(300, 100);
        label1.setFont(new Font("MV Boil", Font.PLAIN, 17));
        label1.setLocation(35, 175);
        container.add(label1);

        label1 = new JLabel("* Please enter date in this format 'YYYY/MM/DD' *");
        label1.setSize(500, 100);
        label1.setFont(new Font("MV Boil", Font.PLAIN, 17));
        label1.setLocation(55, 220);
        container.add(label1);

        PatDate_textField = new JTextField();
        PatDate_textField.setSize(200, 27);
        PatDate_textField.setLocation(200, 215);
        PatDate_textField.setBackground(new Color(0xE6E6E6));
        container.add(PatDate_textField);

        label1 = new JLabel("Mobile Number");
        label1.setSize(300, 100);
        label1.setFont(new Font("MV Boil", Font.PLAIN, 17));
        label1.setLocation(35, 275);
        container.add(label1);

        PatMob_textField = new JTextField();
        PatMob_textField.setSize(200, 27);
        PatMob_textField.setLocation(200, 315);
        PatMob_textField.setBackground(new Color(0xE6E6E6));
        container.add(PatMob_textField);

        label1 = new JLabel("ID");
        label1.setSize(300, 100);
        label1.setFont(new Font("MV Boil", Font.PLAIN, 17));
        label1.setLocation(35, 325);
        container.add(label1);

        PatID_textField = new JTextField();
        PatID_textField.setSize(200, 27);
        PatID_textField.setLocation(200, 365);
        PatID_textField.setBackground(new Color(0xE6E6E6));
        container.add(PatID_textField);

        label1 = new JLabel("Doctors");
        label1.setSize(300, 100);
        label1.setFont(new Font("MV Boil", Font.PLAIN, 17));
        label1.setLocation(35, 375);
        container.add(label1);

        for (int i=0; i<listOfDoctors.size();i++){
            doctor[i] = listOfDoctors.get(i).getFirstName() +" "+ listOfDoctors.get(i).getSurname();
            System.out.println(doctor[i]);
        }

        comboBox = new JComboBox(doctor);
        comboBox.setSize(200, 23);
        comboBox.setLocation(200, 420);
        container.add(comboBox);
        comboBox.addActionListener(this);
        
        
        label2 = new JLabel("Description");
        label2.setSize(300, 100);
        label2.setFont(new Font("MV Boil", Font.PLAIN, 17));
        label2.setLocation(450, 75);
        container.add(label2);

        textArea = new JTextArea();
        textArea.setSize(300, 110);
        textArea.setLocation(580, 115);
        textArea.setLineWrap(true);
        textArea.setBackground(new Color(0xE6E6E6));
        container.add(textArea);

        label2 = new JLabel("Add Image");
        label2.setSize(300, 100);
        label2.setFont(new Font("MV Boil", Font.PLAIN, 17));
        label2.setLocation(450, 225);
        container.add(label2);

        addImageBtn = new JButton("Choose a image");
        addImageBtn.setSize(130, 30);
        addImageBtn.setLocation(580, 260);
        addImageBtn.addActionListener(this);
        addImageBtn.setFocusable(false);
        container.add(addImageBtn);

        label2 = new JLabel("Consultation Date");
        label2.setSize(400, 100);
        label2.setFont(new Font("MV Boil", Font.PLAIN, 17));
        label2.setLocation(450, 290);
        container.add(label2);

        ConsDate_textField = new JTextField();
        ConsDate_textField.setSize(200, 27);
        ConsDate_textField.setLocation(600, 325);
        ConsDate_textField.setBackground(new Color(0xE6E6E6));
        container.add(ConsDate_textField);

        label1 = new JLabel("* Please enter date in this format 'YYYY/MM/DD' *");
        label1.setSize(500, 100);
        label1.setFont(new Font("MV Boil", Font.PLAIN, 17));
        label1.setLocation(450, 330);
        container.add(label1);

        label2 = new JLabel("Consultation Time (in hours)");
        label2.setSize(400, 100);
        label2.setFont(new Font("MV Boil", Font.PLAIN, 17));
        label2.setLocation(450, 370);
        container.add(label2);

        ConsHours_textField = new JTextField();
        ConsHours_textField.setSize(100, 27);
        ConsHours_textField.setLocation(700, 405);
        ConsHours_textField.setBackground(new Color(0xE6E6E6));
        container.add(ConsHours_textField);

        label2 = new JLabel("Cost");
        label2.setSize(400, 100);
        label2.setFont(new Font("MV Boil", Font.PLAIN, 17));
        label2.setLocation(450, 410);
        container.add(label2);

        Cost = new JButton("calculate the price");
        Cost.setSize(300, 30);
        Cost.setLocation(450, 485);
        Cost.addActionListener(this);
        Cost.setFocusable(false);
        container.add(Cost);

        cost = new JLabel("00.00");
        cost.setSize(400, 100);
        cost.setFont(new Font("MV Boil", Font.PLAIN, 17));
        cost.setLocation(500, 410);
        container.add(cost);

        nextBtn = new JButton("Next");
        nextBtn.setSize(100, 30);
        nextBtn.setLocation(200, 500);
        nextBtn.addActionListener(this);
        nextBtn.setFocusable(false);
        container.add(nextBtn);

        setVisible(true);//make frame visible

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextBtn) {

//Get method
            String patF_name = PatN_textField.getText();
            String patS_name = PatL_textField.getText();
            String patID = PatID_textField.getText();
            String patMobile = PatMob_textField.getText();
            String date = PatDate_textField.getText();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/d");
            LocalDate Date = LocalDate.parse(date,formatter);

//            consultation details
            String cons_date = ConsDate_textField.getText();
            DateTimeFormatter consu_formatter = DateTimeFormatter.ofPattern("yyyy/MM/d");
            LocalDate consu_Date = LocalDate.parse(cons_date,consu_formatter);
            String note = textArea.getText();

//set method
            pat_list.setFirstName(patF_name);
            pat_list.setSurname(patS_name);
            pat_list.setMobileNumber(patID);
            pat_list.setId(patMobile);
            pat_list.setDob(Date);

//consultation data set

            cons_list.setDateTime(consu_Date);
            cons_list.setNotes(note);


//adding to  array list
            pat_init.add(pat_list);


            consultation.add(cons_list);

            frame.dispose();
            GUI_Details next = new GUI_Details();

        } else if (e.getSource() == addImageBtn) {
            fileChooser.setCurrentDirectory(new File("."));
            //int response = fileChooser.showOpenDialog(null); //select file to open
            int response = fileChooser.showSaveDialog(null); //select file to open
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
            }
        }else if (e.getSource() == Cost){
            System.out.println("clicked");
            int hours = Integer.parseInt(ConsHours_textField.getText());
            if(hours==1){
                Double total = 15.0;
                cost.setText(String.valueOf(total));
                cons_list.setCost(total);
            }else if(hours>1){
                int Hours = hours-1;
                Double total = (double) (15+ (Hours * 25));
                cost.setText(String.valueOf(total));
                cons_list.setCost(total);
            }
        }
    }
}

