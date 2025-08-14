package AirlineManagementSysytem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddCustomer extends JFrame implements ActionListener {
    JTextField tfname, tfphone, tfaadhar, tfnationality, tfaddress;
    JRadioButton rbmale, rbfemale;
    JLabel background;

    public AddCustomer() {
        // Set frame properties
        setSize(900, 600);
        setLocation(300, 150);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Load background image
        ImageIcon bgIcon = new ImageIcon("C:\\Users\\LENOVO\\Downloads\\—Pngtree—website technology line dark background_2443641.png");
        Image bgImage = bgIcon.getImage().getScaledInstance(900, 600, Image.SCALE_SMOOTH);
        background = new JLabel(new ImageIcon(bgImage));
        background.setBounds(0, 0, 900, 600);
        setContentPane(background);
        background.setLayout(null);

        // Heading
        JLabel heading = new JLabel("ADD CUSTOMER DETAILS");
        heading.setBounds(320, 20, 500, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.RED);
        background.add(heading);

        // Name
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 80, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblname.setForeground(Color.WHITE);
        background.add(lblname);

        tfname = new JTextField();
        tfname.setBounds(220, 80, 150, 25);
        background.add(tfname);

        // Nationality
        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60, 130, 150, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblnationality.setForeground(Color.WHITE);
        background.add(lblnationality);

        tfnationality = new JTextField();
        tfnationality.setBounds(220, 130, 150, 25);
        background.add(tfnationality);

        // Aadhar
        JLabel lblaadhar = new JLabel("Aadhar Number");
        lblaadhar.setBounds(60, 180, 150, 25);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblaadhar.setForeground(Color.WHITE);
        background.add(lblaadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(220, 180, 150, 25);
        background.add(tfaadhar);

        // Address
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60, 230, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbladdress.setForeground(Color.WHITE);
        background.add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(220, 230, 150, 25);
        background.add(tfaddress);

        // Gender
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60, 280, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblgender.setForeground(Color.WHITE);
        background.add(lblgender);

        rbmale = new JRadioButton("Male");
        rbmale.setBounds(220, 280, 70, 25);
        rbmale.setOpaque(true);
        rbmale.setBackground(Color.WHITE);
        rbmale.setForeground(Color.BLACK);
        background.add(rbmale);

        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(300, 280, 70, 25);
        rbfemale.setOpaque(true);
        rbfemale.setBackground(Color.WHITE);
        rbfemale.setForeground(Color.BLACK);
        background.add(rbfemale);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(rbmale);
        gendergroup.add(rbfemale);

        // Phone
        JLabel lblphone = new JLabel("Phone Number");
        lblphone.setBounds(60, 330, 150, 25);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblphone.setForeground(Color.WHITE);
        background.add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(220, 330, 150, 25);
        background.add(tfphone);

        // Save Button
        JButton save = new JButton("SAVE");
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        save.setBounds(220, 380, 150, 30);
        save.addActionListener(this);
        background.add(save);

        // Optional side image
        ImageIcon icon = new ImageIcon("C:\\Users\\LENOVO\\OneDrive\\Desktop\\icons\\emp.png");
        Image img = icon.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH);
        JLabel imgLabel = new JLabel(new ImageIcon(img));
        imgLabel.setBounds(500, 60, 400, 450);
        background.add(imgLabel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String name = tfname.getText();
        String nationality = tfnationality.getText();
        String phone = tfphone.getText();
        String address = tfaddress.getText();
        String aadhar = tfaadhar.getText();
        String gender = rbmale.isSelected() ? "Male" : "Female";

        try {
            Conn conn = new Conn();
            String query = "insert into passenger values('" + name + "','" + nationality + "','" + phone + "','" + address + "','" + aadhar + "','" + gender + "')";
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        new AddCustomer();
    }
}

