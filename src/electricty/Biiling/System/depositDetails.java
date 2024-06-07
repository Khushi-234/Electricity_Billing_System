package electricty.Biiling.System;

import javax.swing.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import net.proteanit.sql.DbUtils;

public class depositDetails extends JFrame implements ActionListener {
    Choice meternumber, cmonth;
    JTable table;
    JButton search, print;

    depositDetails()
    {
        super("Deposit");//title of frame
        setSize(700,700);
        setLocation(400,100);

        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel lblMeterNumber = new JLabel("Search By Meter Number");
        lblMeterNumber.setBounds(20,20,150,20);
        add(lblMeterNumber);

        meternumber= new Choice();
        meternumber.setBounds(180,20,150,20);
        add(meternumber);

        try{
            connection c= new connection();
            ResultSet rs = c.s.executeQuery("select * from customer");//get meter number

            while (rs.next())
            {
                meternumber.add(rs.getString("meterNo"));
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        //month lbl
        JLabel lblmonth = new JLabel("Search By Month");
        lblmonth.setBounds(400, 20, 100, 20);
        add(lblmonth);

        cmonth = new Choice();
        cmonth.setBounds(520, 20, 150, 20);
        cmonth.add("January");
        cmonth.add("February");
        cmonth.add("March");
        cmonth.add("April");
        cmonth.add("May");
        cmonth.add("June");
        cmonth.add("July");
        cmonth.add("August");
        cmonth.add("September");
        cmonth.add("October");
        cmonth.add("November");
        cmonth.add("December");
        add(cmonth);

        table = new JTable();

        try {
            connection c = new connection();
            ResultSet rs = c.s.executeQuery("select * from bill");

            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0,100,700,600);

        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String query = "select * from bill where meter_no = '"+meternumber.getSelectedItem()+"' and month = '"+cmonth.getSelectedItem()+"'";

            try {
                connection c = new connection();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {

            }
        } else  {
            try {
                //print button
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new depositDetails();
    }
}
