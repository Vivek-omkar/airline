package AirlineManagementSysytem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BoardingPass extends JFrame implements ActionListener {

    JTextField tfpnr;
    JLabel tfname, tfnationality, lblsrc, lbldest, labelfname, labelfcode, labeldate;
    JButton fetchButton;

    public BoardingPass() {
        setTitle("Boarding Pass");
        setSize(1000, 450);
        setLocation(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\LENOVO\\Downloads\\—Pngtree—website technology line dark background_2443641.png");
        Image img1 = backgroundImage.getImage().getScaledInstance(1000, 450, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon1 = new ImageIcon(img1);
        JLabel background = new JLabel(scaledIcon1);
        background.setBounds(0, 0, 1000, 450);
        setContentPane(background);
        background.setLayout(null);

        ImageIcon icon = new ImageIcon("C:\\Users\\LENOVO\\OneDrive\\Desktop\\icons\\airindia.png");
        Image img = icon.getImage().getScaledInstance(450, 450, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(img);
        JLabel imgLabel = new JLabel(scaledIcon);
        imgLabel.setBounds(550, 0, 450, 450);
        background.add(imgLabel);

        JLabel heading = new JLabel("AIR INDIA");
        heading.setBounds(250, 10, 450, 35);
        heading.setFont(new Font("Tahoma", Font.BOLD, 32));
        heading.setForeground(Color.WHITE);
        background.add(heading);

        JLabel subheading = new JLabel("Boarding Pass");
        subheading.setBounds(230, 50, 300, 30);
        subheading.setFont(new Font("Tahoma", Font.PLAIN, 24));
        subheading.setForeground(Color.CYAN);
        background.add(subheading);

        JLabel lblaadhar = new JLabel("PNR DETAILS");
        lblaadhar.setBounds(60, 100, 150, 25);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblaadhar.setForeground(Color.WHITE);
        background.add(lblaadhar);

        tfpnr = new JTextField();
        tfpnr.setBounds(220, 100, 150, 25);
        background.add(tfpnr);

        fetchButton = new JButton("Enter");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380, 100, 120, 25);
        fetchButton.addActionListener(this);
        background.add(fetchButton);

        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60, 140, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblname.setForeground(Color.WHITE);
        background.add(lblname);

        tfname = new JLabel();
        tfname.setBounds(220, 140, 250, 25);
        tfname.setForeground(Color.WHITE);
        background.add(tfname);

        JLabel lblnationality = new JLabel("NATIONALITY");
        lblnationality.setBounds(60, 180, 150, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblnationality.setForeground(Color.WHITE);
        background.add(lblnationality);

        tfnationality = new JLabel();
        tfnationality.setBounds(220, 180, 250, 25);
        tfnationality.setForeground(Color.WHITE);
        background.add(tfnationality);

        JLabel lbladdress = new JLabel("SRC");
        lbladdress.setBounds(60, 220, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbladdress.setForeground(Color.WHITE);
        background.add(lbladdress);

        lblsrc = new JLabel();
        lblsrc.setBounds(220, 220, 250, 25);
        lblsrc.setForeground(Color.WHITE);
        background.add(lblsrc);

        JLabel lblgender = new JLabel("DEST");
        lblgender.setBounds(380, 220, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblgender.setForeground(Color.WHITE);
        background.add(lblgender);

        lbldest = new JLabel();
        lbldest.setBounds(540, 220, 250, 25);
        lbldest.setForeground(Color.WHITE);
        background.add(lbldest);

        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setBounds(60, 260, 150, 25);
        lblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblfname.setForeground(Color.WHITE);
        background.add(lblfname);

        labelfname = new JLabel();
        labelfname.setBounds(220, 260, 250, 25);
        labelfname.setForeground(Color.WHITE);
        background.add(labelfname);

        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(380, 260, 150, 25);
        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblfcode.setForeground(Color.WHITE);
        background.add(lblfcode);

        labelfcode = new JLabel();
        labelfcode.setBounds(540, 260, 250, 25);
        labelfcode.setForeground(Color.WHITE);
        background.add(labelfcode);

     

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String pnr = tfpnr.getText();
        try {
            Conn conn = new Conn();
            String query = "SELECT * FROM reservation WHERE PNR = '" + pnr + "'";
            ResultSet rs = conn.s.executeQuery(query);
            if (rs.next()) {
                tfname.setText(rs.getString("name"));
                tfnationality.setText(rs.getString("nationality"));
                lblsrc.setText(rs.getString("src"));
                lbldest.setText(rs.getString("des"));
                labelfname.setText(rs.getString("flightname"));
                labelfcode.setText(rs.getString("flightcode"));
                labeldate.setText(rs.getString("ddate"));
            } else {
                JOptionPane.showMessageDialog(null, "Please enter correct PNR");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new BoardingPass();
    }
}
