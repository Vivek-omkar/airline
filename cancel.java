package AirlineManagementSysytem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Cancel extends JFrame implements ActionListener {
    JTextField tfpnr;
    JLabel tfname, cancellationno, lblfcode;
    JButton fetchButton, flight;

    public Cancel() {
        setLayout(null);

        // Load and set background image
        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\LENOVO\\Downloads\\—Pngtree—website technology line dark background_2443641.png");
        Image img = backgroundImage.getImage().getScaledInstance(800, 450, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(img);
        JLabel background = new JLabel(scaledIcon);
        background.setBounds(0, 0, 800, 450);
        setContentPane(background);
        background.setLayout(null);

        Random random = new Random();

        JLabel heading = new JLabel("CANCELLATION");
        heading.setBounds(180, 20, 250, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.WHITE);
        background.add(heading);

        JLabel lblpnr = new JLabel("PNR Number");
        lblpnr.setBounds(60, 80, 150, 25);
        lblpnr.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblpnr.setForeground(Color.WHITE);
        background.add(lblpnr);

        tfpnr = new JTextField();
        tfpnr.setBounds(220, 80, 150, 25);
        background.add(tfpnr);

        fetchButton = new JButton("Show Details");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380, 80, 120, 25);
        fetchButton.addActionListener(this);
        background.add(fetchButton);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 130, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblname.setForeground(Color.WHITE);
        background.add(lblname);

        tfname = new JLabel();
        tfname.setBounds(220, 130, 150, 25);
        tfname.setForeground(Color.WHITE);
        background.add(tfname);

        JLabel lblcancel = new JLabel("Cancellation No");
        lblcancel.setBounds(60, 180, 150, 25);
        lblcancel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblcancel.setForeground(Color.WHITE);
        background.add(lblcancel);

        cancellationno = new JLabel("" + random.nextInt(1000000));
        cancellationno.setBounds(220, 180, 150, 25);
        cancellationno.setForeground(Color.WHITE);
        background.add(cancellationno);

        JLabel lblflightcode = new JLabel("Flight Code");
        lblflightcode.setBounds(60, 230, 150, 25);
        lblflightcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblflightcode.setForeground(Color.WHITE);
        background.add(lblflightcode);

        lblfcode = new JLabel();
        lblfcode.setBounds(220, 230, 150, 25);
        lblfcode.setForeground(Color.WHITE);
        background.add(lblfcode);

        flight = new JButton("Cancel");
        flight.setBackground(Color.BLACK);
        flight.setForeground(Color.WHITE);
        flight.setBounds(220, 280, 120, 25);
        flight.addActionListener(this);
        background.add(flight);

      

        setSize(800, 450);
        setLocation(350, 150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == fetchButton) {
            String pnr = tfpnr.getText();
            try {
                Conn conn = new Conn();
                String query = "SELECT * FROM reservation WHERE PNR = '" + pnr + "'";
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()) {
                    tfname.setText(rs.getString("name"));
                    lblfcode.setText(rs.getString("flightcode"));
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid PNR.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == flight) {
            String pnr = tfpnr.getText();
            try {
                Conn conn = new Conn();
                String query = "DELETE FROM reservation WHERE PNR = '" + pnr + "'";
                int rowsAffected = conn.s.executeUpdate(query);
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Reservation Cancelled Successfully.");
                    tfname.setText("");
                    lblfcode.setText("");
                    tfpnr.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "No matching PNR found.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        new Cancel();
    }
}

