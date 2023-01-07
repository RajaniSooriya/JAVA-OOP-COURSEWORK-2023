import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
public class GUI_payment extends JFrame implements ActionListener {
    private Container C;
    URL iconURL = getClass().getResource("doctor.png");
    ImageIcon image;

    {
        assert iconURL != null;
        image = new ImageIcon(iconURL);
    }
    URL heroIconURL = getClass().getResource("thumbs-up.png");
    ImageIcon hero = new ImageIcon(heroIconURL);

    //    String lockedSymbol = "\uD83D\uDD12";
    Image heroImage = hero.getImage();
    int width =250;
    int height = 250;
    Image scaledimage = heroImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    ImageIcon scaledIcon = new ImageIcon(scaledimage);

    JFrame frame = new JFrame(); //creates the frame
    private JButton MScreen;
    private JLabel title, HeadingImage;
    GUI_payment(){
        setTitle("WestminsterSkinConsultation Manager Doctors"); //sets title of frame
        setSize(1212, 702);// sets x-dimension and y-dimension
        setIconImage(image.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
        setResizable(false);

        C = getContentPane();
        C.setLayout(null);
        C.setBackground(new Color(0xb4e7ce));

        HeadingImage = new JLabel();
        HeadingImage.setIcon(scaledIcon);
        HeadingImage.setSize(400,400);
        HeadingImage.setLocation(500,100);
        C.add(HeadingImage);
        
        MScreen = new JButton("Main screen");
        MScreen.setFont(new Font("Arial", Font.BOLD, 20));
        MScreen.setSize(200, 35);
        MScreen.setLocation(520, 540);
        MScreen.addActionListener(this);
        MScreen.setFocusable(false);
        MScreen.setBackground(new Color(0x59A96A));
        MScreen.setForeground(new Color(0x474A2C));
        C.add(MScreen);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==MScreen){
            GUI_mainScreen main = new GUI_mainScreen();
        }
    }
}
