package AirlineManagementSysytem;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class FlightInfo extends JFrame {

    JTable table;

    FlightInfo() {
        ImageIcon icon = new ImageIcon("C:\\Users\\LENOVO\\Downloads\\—Pngtree—website technology line dark background_2443641.png");
        Image img = icon.getImage().getScaledInstance(800, 500, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(img);
        JLabel background = new JLabel(scaledIcon);
        background.setBounds(0, 0, 800, 500);
        background.setLayout(null);
        setContentPane(background);

        table = new JTable();
        table.setOpaque(false);
        table.setBackground(new Color(0, 0, 0, 0)); 
        table.setForeground(Color.WHITE); 
        table.setGridColor(Color.LIGHT_GRAY);

      
        JTableHeader header = table.getTableHeader();
        header.setOpaque(false);
        header.setBackground(new Color(0, 0, 0, 150));
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Tahoma", Font.BOLD, 14));

    
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 20, 760, 400);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);
        background.add(scrollPane);


        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("SELECT * FROM flight");
            table.setModel(buildTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

  
        setSize(800, 500);
        setLocation(400, 200);
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

    public static void main(String[] args) {
        new FlightInfo();
    }
}
