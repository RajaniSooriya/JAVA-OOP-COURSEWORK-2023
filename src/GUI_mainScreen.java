import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

public class GUI_mainScreen extends JFrame implements ActionListener  {
    private Container container;
    private JLabel heading,img;
    private JButton patientBtn,doctorBtn;
    JFrame frame = new JFrame();
    ArrayList<Doctor> list = WestminsterSkinConsultationManager.doctorList;
    GUI_mainScreen() {

        URL iconURL = getClass().getResource("doctor.png");
        ImageIcon image1 = new ImageIcon(iconURL);

        URL heroIconURL = getClass().getResource("consultation.png");
        ImageIcon image2 = new ImageIcon(heroIconURL);

        Image heroImage = image2.getImage();
        int width = 250;
        int height = 250;

        Image scaledimage = heroImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledimage);

        setTitle("Skin consultation Centre"); //sets title of frame
        setSize(1000, 600);// sets x-dimension and y-dimension
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
        setIconImage(image1.getImage());
        //setResizable(false);

        container = getContentPane();
        container.setLayout(null);
        container.setBackground(new Color(0xb4e7ce));

        heading = new JLabel("Welcome ");
        heading.setSize(450, 100);
        heading.setLocation(270, 200);
        heading.setVerticalAlignment(JLabel.CENTER);
        heading.setForeground(new Color(0x474a2c));
        heading.setFont(new Font("MV Boil", Font.BOLD,60));
        heading.setIconTextGap(10);
        container.add(heading);

        heading = new JLabel("This is ");
        heading.setSize(800, 100);
        heading.setLocation(340, 260);
        heading.setForeground(new Color(0x474a2c));
        heading.setVerticalAlignment(JLabel.CENTER);
        heading.setFont(new Font("MV Boil", Font.BOLD,30));
        heading.setIconTextGap(10);
        container.add(heading);

        heading = new JLabel("Westminster Skin Consultation System ");
        heading.setSize(800, 100);
        heading.setLocation(110, 310);
        heading.setVerticalAlignment(JLabel.CENTER);
        heading.setForeground(new Color(0x474a2c));
        heading.setFont(new Font("MV Boil", Font.BOLD,30));
        heading.setIconTextGap(10);
        container.add(heading);

        img = new JLabel();
        img.setIcon(scaledIcon);
        img.setHorizontalTextPosition(JLabel.RIGHT);
        img.setVerticalAlignment(JLabel.CENTER);
        img.setIconTextGap(30);
        img.setSize(500, 300);
        img.setLocation(650, 120);
        container.add(img);

        doctorBtn = new JButton("View Doctors");
        doctorBtn.setSize(200, 30);
        doctorBtn.setLocation(150, 450);
        doctorBtn.setFont(new Font("MV Boil", Font.BOLD,20));
        doctorBtn.setFocusable(false);
        doctorBtn.setForeground(new Color(0x474A2C));
        doctorBtn.setBackground(new Color(0x59A96A));
        doctorBtn.addActionListener(this);
        container.add(doctorBtn);

        patientBtn = new JButton("Add a patient");
        patientBtn.setSize(200, 30);
        patientBtn.setLocation(400, 450);
        patientBtn.setFont(new Font("MV Boil", Font.BOLD,20));
        patientBtn.setFocusable(false);
        patientBtn.setForeground(new Color(0x474A2C));
        patientBtn.setBackground(new Color(0x59A96A));
        patientBtn.addActionListener(this);
        container.add(patientBtn);

        setVisible(true);//make frame visible
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == doctorBtn) {
            frame.dispose();
            GUI_doctorTable table = new GUI_doctorTable();
        }else if (e.getSource() == patientBtn) {
            frame.dispose();
            GUI_patient patient = new GUI_patient();
        }
    }
}

