package electricty.Biiling.System;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class newCustomer extends JFrame implements ActionListener {

    JTextField tfname, tfaddress, tfstate, tfcity, tfemail, tfphone;
    JButton next, cancel;
    JLabel lblmeter;

    newCustomer()
    {
        setSize(700, 500);
        setLocation(400, 200);

        //panel
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173, 216, 230));
        add(p);

        JLabel heading = new JLabel("New Customer");
        heading.setBounds(200, 10, 200, 25);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 24));
        p.add(heading);


        //Customer - name
        JLabel lblname = new JLabel("Customer Name");
        lblname.setBounds(100, 80, 100, 20);
        p.add(lblname);
        tfname = new JTextField();
        tfname.setBounds(240, 80, 200, 20);
        p.add(tfname);


        //meter number
        JLabel lblmeterno = new JLabel("Meter Number");
        lblmeterno.setBounds(100, 120, 100, 20);
        p.add(lblmeterno);
        lblmeter = new JLabel("");
        lblmeter.setBounds(240, 120, 100, 20);
        p.add(lblmeter);

        //randomly generate meter number
        Random ran = new Random();
        long number = ran.nextLong() % 1000000;//this also generate negative val so use math.abs
        lblmeter.setText("" + Math.abs(number));//set Text only accept string so use "" +


        //address
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(100, 160, 100, 20);
        p.add(lbladdress);
        tfaddress = new JTextField();
        tfaddress.setBounds(240, 160, 200, 20);
        p.add(tfaddress);


        //city
        JLabel lblcity = new JLabel("City");
        lblcity.setBounds(100, 200, 100, 20);
        p.add(lblcity);
        tfcity = new JTextField();
        tfcity.setBounds(240, 200, 200, 20);
        p.add(tfcity);


        //state
        JLabel lblstate = new JLabel("State");
        lblstate.setBounds(100, 240, 100, 20);
        p.add(lblstate);
        tfstate = new JTextField();
        tfstate.setBounds(240, 240, 200, 20);
        p.add(tfstate);


        //mail
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(100, 280, 100, 20);
        p.add(lblemail);
        tfemail = new JTextField();
        tfemail.setBounds(240, 280, 200, 20);
        p.add(tfemail);


        //number
        JLabel lblphone = new JLabel("Phone Number");
        lblphone.setBounds(100, 320, 100, 20);
        p.add(lblphone);
        tfphone = new JTextField();
        tfphone.setBounds(240, 320, 200, 20);
        p.add(tfphone);

        //next button
        next = new JButton("Next");
        next.setBounds(120, 390, 100,25);
        next.setBackground(Color.lightGray);
        next.addActionListener(this);
        p.add(next);


        //cancel button
        cancel = new JButton("Cancel");
        cancel.setBounds(250, 390, 100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        p.add(cancel);
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == next)
        {
            String name = tfname.getText();
            String meter = lblmeter.getText();
            String address = tfaddress.getText();
            String city = tfcity.getText();
            String state = tfstate.getText();
            String email = tfemail.getText();
            String phone = tfphone.getText();

            String query1 = "insert into customer values('"+name+"', '"+meter+"', '"+address+"', '"+city+"', '"+state+"', '"+email+"', '"+phone+"')";
            String query2 = "insert into info values('"+meter+"', '', '"+name+"', '', '')";

            try{
                connection c = new connection();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);


                JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
                setVisible(false);

                //new frame
                new meterInfo(meter);
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        } else {
            setVisible(false);//cancel button
        }
    }
    
    public static void main(String[] args) {
        new newCustomer();
    }
}
