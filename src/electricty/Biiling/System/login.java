package electricty.Biiling.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class login extends JFrame implements ActionListener {

    //declaring globally, so we can take action on click the button
    JButton login, cancel, signUp;
    JTextField username, password;
    Choice loggingIn;

    login()
    {
        super("Login Page");//adding header

        //changing background
        getContentPane().setBackground(Color.white);
        setLayout(null);//for using user defined layout

        //wring on the frame
        JLabel userName = new JLabel("Username : ");
        userName.setBounds(200,20,100,20);//x,y is location withrespect to frame
        add(userName);
        //making text field
        username =  new JTextField();
        username.setBounds(300,20,150,20);
        add(username);

        JLabel pass = new JLabel("Password : ");
        pass.setBounds(200,60,100,20);//x,y is location withrespect to frame
        add(pass);
        password =  new JTextField();
        password.setBounds(300,60,150,20);
        add(password);

        JLabel loginAs = new JLabel("Login As : ");
        loginAs.setBounds(200,100,100,20);//x,y is location with respect to frame
        add(loginAs);
        //adding choice
        loggingIn = new Choice();
        loggingIn.add("Customer");
        loggingIn.add("Admin");
        loggingIn.setBounds(300,100,150,20);
        add(loggingIn);


        //creating buttons
        login = new JButton("Login");
        login.setBackground(Color.lightGray);
        login.setBounds(220,160,100,20);
        login.addActionListener(this);
        add(login);


        signUp = new JButton("Sign Up");
        signUp.setBackground(Color.lightGray);
        signUp.setBounds(380,160,100,20);
        signUp.addActionListener(this);
        add(signUp);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.lightGray);
        cancel.setBounds(300,200,100,20);
        cancel.addActionListener(this);
        add(cancel);

        //setting up the frame
        setSize(640,300);
        setLocation(400,200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        //differentiate  between the different buttons
        if(ae.getSource() == login)
        {
            //query to fetch data from the database to check valid uname and pass
            String susername = username.getText();
            String spassword = password.getText();
            String user = loggingIn.getSelectedItem();

            try {
                connection c = new connection();
                String query = "select * from info where userName = '"+susername+"' and password = '"+spassword+"' and name = '"+user+"'";

                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    String meter = rs.getString("MeterNo");
                    setVisible(false);
                    new Project("", "");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                    username.setText("");
                    password.setText("");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource()== cancel) {
            setVisible(false);

        }
        else if(ae.getSource()== signUp)
        {
            setVisible(false);
            new signUp();
        }
    }

    public static void main(String[] args) {
        new login();
    }
}
