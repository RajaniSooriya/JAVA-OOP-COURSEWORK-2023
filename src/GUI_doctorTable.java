import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI_doctorTable {
    JFrame frame = new JFrame("Patients");
    JTable table = new JTable();
    Object[] columns = {"First Name", "Last Name", "Date Of Birth", "Mobile Number", "LicenseNumber", "Specialization"};
    DefaultTableModel model = new DefaultTableModel();
    JScrollPane pane = new JScrollPane(table);
    ArrayList<Doctor> list = WestminsterSkinConsultationManager.doctorList;
    JButton btnAscendingOrder = new JButton("Sort in Alphabetically");
    JButton btnChannel = new JButton("Back to main screen");
    ImageIcon image = new ImageIcon("doctor.png");
    GUI_doctorTable() {

        frame.setTitle("View Patients");
        frame.setSize(1000, 600);
        frame.setIconImage(image.getImage());
        frame.setVisible(true);//make frame visible
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
        frame.setResizable(true);
        frame.getContentPane().add(btnAscendingOrder);
        frame.getContentPane().add(btnChannel);
        frame.getContentPane().add(pane);

        model.setColumnIdentifiers(columns);

        table.setModel(model);
        table.setRowHeight(30);
        table.setAutoCreateRowSorter(true);

        pane.setForeground(Color.RED);
        pane.setBackground(Color.black);
        pane.setBounds(0, 0, 500, 100);

        btnAscendingOrder.setBounds(70, 510, 300, 35); //button position and dimensions
        btnAscendingOrder.setBackground(new Color(0x59A96A));
        btnAscendingOrder.setForeground(new Color(0x474A2C));
        btnAscendingOrder.setFont(new Font("", Font.BOLD,20));
        btnAscendingOrder.setFocusable(false);


        btnChannel.addActionListener(new Button2Listener());
        btnChannel.setBounds(600, 510, 300, 35); //button position and dimensions
        btnChannel.setForeground(new Color(0x474A2C));
        btnChannel.setBackground(new Color(0x59A96A));
        btnChannel.setFont(new Font("", Font.BOLD,20));


        Object[] columns = new Object[6];
        for (Doctor doc : list ) {
            columns[0] = doc.getFirstName();
            columns[1] = doc.getSurname();
            columns[2] = doc.getDob();
            columns[3] = doc.getMobileNumber();
            columns[4] = doc.getMedicalLicenseNumber();
            columns[5] = doc.getSpecialization();

            model.addRow(columns);
        }
        btnAscendingOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Object[] newColumn = new Object[6];
                model.setRowCount(0);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    for (int j = size - 1; j > 0 ; j--) {
                        Doctor temp;
                        if(list.get(j).getFirstName().charAt(0) < list.get(j - 1).getFirstName().charAt(0)) {
                            temp = list.get(j);
                            list.set(j, list.get(j - 1));
                            list.set(j - 1, temp);
                        }
                    }
                }

                for (Doctor d : list) {
                    newColumn[0] = d.getFirstName();
                    newColumn[1] = d.getSurname();
                    newColumn[2] = d.getMobileNumber();
                    newColumn[3] = d.getDob();
                    newColumn[4] = d.getMedicalLicenseNumber();
                    newColumn[5] = d.getSpecialization();
                    model.addRow(newColumn);
                }
            }
        });
    }

    private class Button2Listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==btnChannel){
                frame.dispose();
                GUI_mainScreen main =new GUI_mainScreen();
            }
        }
    }

    }


