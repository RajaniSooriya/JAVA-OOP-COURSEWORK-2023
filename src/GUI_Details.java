import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI_Details extends JFrame implements ActionListener {
    private Container container;
    private JLabel label,subheading;
    private JButton proceedBtn;
    JFrame frame = new JFrame();
    JTextField textField = new JTextField();

    ArrayList<Patient> patientDetails = GUI_patient.pat_init;
    ArrayList<Consultation> consultation_details =GUI_patient.consultation;

    GUI_Details(){
        ImageIcon image = new ImageIcon("doctor.png");

        setTitle("GUI_Details");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
        setIconImage(image.getImage());
        setResizable(true);

        container = getContentPane();
        container.setLayout(null);
        container.setBackground(new Color(0xb4e7ce));

        label = new JLabel("Appointment GUI_Details");
        label.setFont(new Font("MV Boil", Font.BOLD, 20));
        label.setSize(300, 50);
        label.setLocation(395, 20);
        container.add(label);

        subheading = new JLabel("");
        subheading.setFont(new Font("Arial", Font.PLAIN, 20));
        subheading.setSize(400, 20);
        subheading.setLocation(360, 170);
        subheading.setForeground(new Color(0x474a2c) );
        container.add(subheading);

        for(Patient pat :GUI_patient.pat_init){
            String PatName ="Patient Name :"+" "+ pat.getFirstName()+" "+pat.getSurname();
            subheading.setText(PatName);
        }

        subheading = new JLabel("");
        subheading.setFont(new Font("Arial", Font.PLAIN, 20));
        subheading.setSize(400, 20);
        subheading.setLocation(360, 200);
        subheading.setForeground(new Color(0x474a2c) );
        container.add(subheading);

        for(Patient pat :GUI_patient.pat_init){
            String birthday = "Patient date of birth :"+" "+ pat.getDob();
            subheading.setText(birthday);
        }

        subheading = new JLabel("");
        subheading.setFont(new Font("Arial", Font.PLAIN, 20));
        subheading.setSize(400, 20);
        subheading.setLocation(360, 230);
        subheading.setForeground(new Color(0x474a2c) );
        container.add(subheading);

        for(Patient pat :GUI_patient.pat_init){
            String ID = "Patient Id :"+" "+ pat.getId();
            subheading.setText(ID);
        }

        subheading = new JLabel("");
        subheading.setFont(new Font("Arial", Font.PLAIN, 20));
        subheading.setSize(400, 20);
        subheading.setLocation(360, 260);
        subheading.setForeground(new Color(0x474a2c) );
        container.add(subheading);

        for(Patient pat :GUI_patient.pat_init){
            String Mno = "Patient mobile Number : "+" "+pat.getMobileNumber();
            subheading.setText(Mno);
        }

        subheading = new JLabel("");
        subheading.setFont(new Font("Arial", Font.PLAIN, 20));
        subheading.setSize(400, 20);
        subheading.setLocation(360, 290);
        subheading.setForeground(new Color(0x474a2c) );
        container.add(subheading);

        for(Consultation con :GUI_patient.consultation){
            String Mno = "Special notes : "+" "+con.getNotes();
            subheading.setText(Mno);
        }

        subheading = new JLabel("");
        subheading.setFont(new Font("Arial", Font.PLAIN, 20));
        subheading.setSize(400, 20);
        subheading.setLocation(360, 330);
        subheading.setForeground(new Color(0x474a2c) );
        container.add(subheading);

        for(Consultation con :GUI_patient.consultation){
            String Mno = "Cost for the Consultation : "+" "+con.getCost();
            subheading.setText(Mno);
        }


        proceedBtn = new JButton("Pay");
        proceedBtn.setSize(200, 30);
        proceedBtn.setLocation(440, 450);
        proceedBtn.addActionListener(this);
        proceedBtn.setFocusable(false);
        container.add(proceedBtn);

        setVisible(true);//make frame visible
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == proceedBtn) {
            frame.dispose();
            GUI_payment pay = new GUI_payment();
        }
    }
}
