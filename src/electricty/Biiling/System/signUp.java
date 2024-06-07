package electricty.Biiling.System;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class signUp extends JFrame implements ActionListener {

    JButton create, back;
    Choice accountType;
    JTextField meter, userName, name, password;

    signUp()
    {
        setBounds(450,150,780,400);//setting up frame without setLocation
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        //creating panel and header
        JPanel panel = new JPanel();
        panel.setBounds(30,30,700,300);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230), 2), "Create-Account", TitledBorder.LEADING, TitledBorder.TOP, null, Color.red));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setForeground(new Color(34, 139, 34));
        add(panel);

        //create account as
        JLabel heading = new JLabel("Create Account As");
        heading.setBounds(100, 50, 140, 20);
        heading.setForeground(Color.GRAY);
        heading.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(heading);

        //choice from two
        accountType = new Choice();
        accountType.add("Admin");
        accountType.add("Customer");
        accountType.setBounds(260, 50, 150, 20);
        panel.add(accountType);


        //meter number
        JLabel lblmeter = new JLabel("Meter Number");
        lblmeter.setBounds(100, 90, 140, 20);
        lblmeter.setForeground(Color.GRAY);
        lblmeter.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblmeter.setVisible(false);
        panel.add(lblmeter);

        meter = new JTextField();//text field
        meter.setBounds(260, 90, 150, 20);
        meter.setVisible(false);
        panel.add(meter);


        //username
        JLabel username = new JLabel("Username");
        username.setBounds(100, 130, 140, 20);
        username.setForeground(Color.GRAY);
        username.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(username);

        userName = new JTextField();
        userName.setBounds(260, 130, 150, 20);
        panel.add(userName);

        //name
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(100, 170, 140, 20);
        lblname.setForeground(Color.GRAY);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lblname);

        //adding focus listener, so we can send api call to database to fetch name from meter num
        meter.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {}

            @Override
            public void focusLost(FocusEvent e) {
                try {

                    connection c = new connection();
                    ResultSet rs = c.s.executeQuery("select * from info where meterNo = '" +meter.getText()+"' ");

                    while (rs.next())
                    {
                        name.setText(rs.getString("name "));//set value at name field
                    }
                }catch (Exception exception)
                {
                    exception.printStackTrace();
                }
            }
        });


        name = new JTextField();
        name.setBounds(260, 170, 150, 20);
        panel.add(name);

        //password
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(100, 210, 140, 20);
        lblpassword.setForeground(Color.GRAY);
        lblpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lblpassword);

        password = new JTextField();
        password.setBounds(260, 210, 150, 20);
        panel.add(password);

        accountType.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                String user = accountType.getSelectedItem();
                //check which is selected
                if(user.equals("Customer"))
                {
                    lblmeter.setVisible(true);
                    meter.setVisible(true);
                    name.setEditable(false);
                }else {
                    lblmeter.setVisible(false);
                    meter.setVisible(false);
                    name.setEditable(true);
                }

            }
        });

        //buttons
        create = new JButton("Create");
        create.setBackground(Color.lightGray);
        create.setBounds(140, 260, 120, 25);
        create.addActionListener(this);
        panel.add(create);

        //back button
        back = new JButton("Back");
        back.setBackground(Color.lightGray);
        back.setBounds(300, 260, 120, 25);
        back.addActionListener(this);
        panel.add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signUp.jpg"));
        Image i2 = i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(430, 30, 250, 250);
        panel.add(image);


        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()== create)
        {
            //fetching data from database
            String acType = accountType.getSelectedItem();
            String susername = userName.getText();
            String sname = name.getText();
            String smeter = meter.getText();
            String spassword = password.getText();

            String query;
            try{
                connection c = new connection();
                if (acType.equals("Admin")) {
                    query = "insert into info values('"+smeter+"', '"+susername+"', '"+spassword+"', '"+sname+"', '"+acType+"')";
                } else {
                    query = "update info set userName = '"+susername+"', password = '"+spassword+"', name = '"+sname+"' , acType = '"+acType+"' where MeterNo = '"+smeter+"'";
                }

                int r= c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                setVisible(false);
                new login();

            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()== back)
        {
            setVisible(false);
            new login();
        }
    }

    public static void main(String[] args) {

        new signUp();
    }
}
