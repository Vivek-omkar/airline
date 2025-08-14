package AirlineManagementSysytem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Home extends JFrame implements ActionListener {

    JMenu details, ticket;

    public Home() {
        setTitle("Airline Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        
        ImageIcon icon = new ImageIcon("C:\\Users\\LENOVO\\Downloads\\—Pngtree—website technology line dark background_2443641.png");
        Image img = icon.getImage().getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(img);
        JLabel background = new JLabel(scaledIcon);
        background.setBounds(0, 0, 1920, 1080);
        background.setLayout(null);
        setContentPane(background);

      
        JLabel heading = new JLabel("WELCOME TO AIR MANAGEMENT SYSTEM....");
        heading.setBounds(400, 40, 1100, 50);
        heading.setForeground(Color.RED);
        heading.setFont(new Font("Tahoma", Font.BOLD, 36));
        background.add(heading);

        JMenuBar menubar = new JMenuBar();
        menubar.setOpaque(false);
        setJMenuBar(menubar);

        details = new JMenu("Details");
        details.setFont(new Font("Tahoma", Font.BOLD, 14));
        details.setForeground(Color.WHITE);
        details.setOpaque(true);
        details.setBackground(new Color(70, 130, 180)); // Steel Blue
        menubar.add(details);

        JMenuItem flightDetails = new JMenuItem("Flight Details");
        flightDetails.addActionListener(this);
        details.add(flightDetails);

        JMenuItem customerDetails = new JMenuItem("Add Customer  Details");
        customerDetails.addActionListener(this);
        details.add(customerDetails);

        JMenuItem bookFlight = new JMenuItem("Book Flight");
        bookFlight.addActionListener(this);
        details.add(bookFlight);

        JMenuItem journeyDetails = new JMenuItem("Journey Details");
        journeyDetails.addActionListener(this);
        details.add(journeyDetails);

        JMenuItem ticketCancellation = new JMenuItem("Cancel Ticket");
        ticketCancellation.addActionListener(this);
        details.add(ticketCancellation);

     
        ticket = new JMenu("Ticket");
        ticket.setFont(new Font("Tahoma", Font.BOLD, 14));
        ticket.setForeground(Color.WHITE);
        ticket.setOpaque(true);
        ticket.setBackground(new Color(0, 128, 0));
        menubar.add(ticket);

        JMenuItem boardingPass = new JMenuItem("Boarding Pass");
        boardingPass.addActionListener(this);
        ticket.add(boardingPass);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String text = ae.getActionCommand();
        switch (text) {
            case "Add Customer  Details" -> new AddCustomer();
            case "Flight Details" -> new FlightInfo();
            case "Book Flight" -> new BookFlight();
            case "Journey Details" -> new JourneyDetails();
            case "Cancel Ticket" -> new Cancel();
            case "Boarding Pass" -> new BoardingPass();
        }
    }

    public static void main(String args[]) {
        new Home();
    }
}
