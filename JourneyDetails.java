package AirlineManagementSysytem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class JourneyDetails extends JFrame implements ActionListener {
    JTable table;
    JTextField pnr;
    JButton show;

    JourneyDetails() {
        setLayout(null);

        // Set Background Image
        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\LENOVO\\Downloads\\—Pngtree—website technology line dark background_2443641.png");
        Image img = backgroundImage.getImage().getScaledInstance(800, 500, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(img);
        JLabel background = new JLabel(scaledIcon);
        background.setBounds(0, 0, 800, 500);
        setContentPane(background);
        background.setLayout(null);

        JLabel lblpnr = new JLabel("PNR Details");
        lblpnr.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblpnr.setForeground(Color.WHITE); // Make label text white
        lblpnr.setBounds(50, 50, 100, 25);
        background.add(lblpnr);

        pnr = new JTextField();
        pnr.setBounds(160, 50, 120, 25);
        background.add(pnr);

        show = new JButton("Show Details");
        show.setBackground(Color.BLACK);
        show.setForeground(Color.WHITE);
        show.setBounds(290, 50, 120, 25);
        show.addActionListener(this);
        background.add(show);

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 100, 800, 150);
        background.add(scrollPane);

        setSize(800, 500);
        setLocation(400, 150);
        setVisible(true);
    }

    public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        String[] columnNames = new String[columnCount];
        for (int column = 0; column < columnCount; column++) {
            columnNames[column] = metaData.getColumnName(column + 1);
        }

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        while (rs.next()) {
            Object[] row = new Object[columnCount];
            for (int i = 0; i < columnCount; i++) {
                row[i] = rs.getObject(i + 1);
            }
            model.addRow(row);
        }

        return model;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            Conn conn = new Conn();
            String query = "SELECT * FROM reservation WHERE PNR = '" + pnr.getText().trim() + "'";
            ResultSet rs = conn.s.executeQuery(query);

            if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "No Information Found");
                return;
            }

            DefaultTableModel model = buildTableModel(rs);
            table.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error retrieving data");
        }
    }

    public static void main(String[] args) {
        new JourneyDetails();
    }
}
