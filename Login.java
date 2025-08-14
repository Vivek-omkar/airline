package AirlineManagementSysytem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton submit, reset, close, forgotPassword;
    JTextField tfusername;
    JPasswordField tfpassword;

    public Login() {
        ImageIcon bgIcon = new ImageIcon("C:\\Users\\LENOVO\\Downloads\\AdobeStock_1191769600_Preview.jpeg");
        Image bgImage = bgIcon.getImage().getScaledInstance(420, 250, Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(bgImage));
        background.setBounds(0, 0, 420, 250);
        setContentPane(background);
        setLayout(null);

        Font font = new Font("Tahoma", Font.PLAIN, 14);
        Color textColor = Color.WHITE;
  
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(20, 20, 100, 20);
        lblusername.setForeground(textColor);
        lblusername.setFont(font);
        background.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(130, 20, 200, 20);
        styleTextField(tfusername);
        background.add(tfusername);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(20, 60, 100, 20);
        lblpassword.setForeground(textColor);
        lblpassword.setFont(font);
        background.add(lblpassword);

        // Password field
        tfpassword = new JPasswordField();
        tfpassword.setBounds(130, 60, 200, 20);
        styleTextField(tfpassword);
        background.add(tfpassword);

        // Reset button
        reset = new JButton("Reset");
        reset.setBounds(40, 140, 100, 25);
        styleButton(reset);
        background.add(reset);

        // Submit button
        submit = new JButton("Submit");
        submit.setBounds(150, 140, 100, 25);
       styleButton(submit);
        background.add(submit);

        // Close button
        close = new JButton("Close");
        close.setBounds(260, 140, 100, 25);
        styleButton(close);
        background.add(close);

        // Forgot Password button
        forgotPassword = new JButton("Forgot Password?");
        forgotPassword.setBounds(120, 180, 160, 20);
        forgotPassword.setBorderPainted(false);
        forgotPassword.setContentAreaFilled(false);
        forgotPassword.setOpaque(false);
        forgotPassword.setForeground(Color.CYAN);
        forgotPassword.setFocusPainted(false);
        forgotPassword.setCursor(new Cursor(Cursor.HAND_CURSOR));
        forgotPassword.addActionListener(this);
        background.add(forgotPassword);

        // Frame setup
        setSize(420, 250);
        setVisible(true);
        setLocation(600, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Login");
    }

    // Make input fields transparent
    private void styleTextField(JTextField field) {
        field.setOpaque(false);
        field.setForeground(Color.WHITE);
        field.setCaretColor(Color.WHITE);
        field.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE)); 
    }

    // Style buttons for background integration
    private void styleButton(JButton button) {
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String username = tfusername.getText();
            String password = String.valueOf(tfpassword.getPassword());

            try {
                Conn c = new Conn();
                String query = "select * from login where username ='" + username + "' and password= '" + password + "'";
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    new Home(); // Assuming Home class exists
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == reset) {
            tfusername.setText("");
            tfpassword.setText("");
        } else if (ae.getSource() == close) {
            setVisible(false);
        } else if (ae.getSource() == forgotPassword) {
            String user = JOptionPane.showInputDialog(this, "Enter your username to reset password:");
            if (user != null && !user.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Password reset link sent to the registered email of " + user);
            }
        }
    }

    public static void main(String args[]) {
        new Login();
    }
}
