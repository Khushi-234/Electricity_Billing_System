package electricty.Biiling.System;

import javax.swing.*;
import java.awt.*;

public class temp {
    public static class project extends JFrame {

        String atype, meter;
        project(String atype, String meter)
        {
            this.atype = atype;
            this.meter = meter;
            setExtendedState(JFrame.MAXIMIZED_BOTH);//frame open in full screen

            ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/homePage.jpg"));
            Image i2 = i1.getImage().getScaledInstance(825,420,Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);

            //creating menu bar that show on the home page
            JMenuBar mb = new JMenuBar();
            setJMenuBar(mb);
            mb.setBounds(10,20,100,200);
            //adding icon to menu bar
            JMenu master =  new JMenu("Master");
            master.setForeground(Color.blue);
            mb.add(master);

            //we have menu item inside the menu
            JMenuItem newCustomer = new JMenuItem("New Customer");
            newCustomer.setFont(new Font("Tahoma", Font.PLAIN, 14));
            newCustomer.setBackground(Color.WHITE);
            ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icons/icon1.png"));
            Image image1 = icon1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
            newCustomer.setIcon(new ImageIcon(image1));
            master.add(newCustomer);


            //customer details
            JMenuItem customerDetail = new JMenuItem("Customer  Details");
            customerDetail.setFont(new Font("Tahoma", Font.PLAIN, 14));
            customerDetail.setBackground(Color.WHITE);
            ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("icons/icon2.png"));
            Image image2 = icon2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
            customerDetail.setIcon(new ImageIcon(image2));
            master.add(customerDetail);


            //depositDetails
            JMenuItem depositDetails = new JMenuItem("Deposit Details");
            depositDetails.setFont(new Font("Tahoma", Font.PLAIN, 12));
            depositDetails.setBackground(Color.WHITE);
            ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("icons/icon3.png"));
            Image image3 = icon3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
            depositDetails.setIcon(new ImageIcon(image3));
            master.add(depositDetails);

            //calculate bill
            JMenuItem calculateBill = new JMenuItem("Calculate Bill");
            calculateBill.setFont(new Font("Tahoma", Font.PLAIN, 12));
            calculateBill.setBackground(Color.WHITE);
            ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("icons/icon5.png"));
            Image image4 = icon4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
            calculateBill.setIcon(new ImageIcon(image4));
            master.add(calculateBill);


            //information menu
            JMenu info = new JMenu("Information");
            mb.add(info);
            info.setForeground(Color.blue);


            //update information
            JMenuItem updateInformation = new JMenuItem("Update Information");
            updateInformation.setFont(new Font("Tahoma", Font.PLAIN, 12));
            updateInformation.setBackground(Color.WHITE);
            ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("icons/icon4.png"));
            Image image5 = icon5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
            updateInformation.setIcon(new ImageIcon(image5));
            info.add(updateInformation);
            setLayout(new FlowLayout());


            //view information
            JMenuItem viewInformation = new JMenuItem("View Information");
            viewInformation.setFont(new Font("Tahoma", Font.PLAIN, 12));
            viewInformation.setBackground(Color.WHITE);
            ImageIcon icon6 = new ImageIcon(ClassLoader.getSystemResource("icons/icon6.png"));
            Image image6 = icon6.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
            viewInformation.setIcon(new ImageIcon(image6));
            info.add(viewInformation);


            JMenu mexit = new JMenu("Exit");
            mb.add(mexit);
            mexit.setForeground(Color.blue);


            JMenuItem exit = new JMenuItem("Exit");
            exit.setFont(new Font("Tahoma", Font.PLAIN, 12));
            exit.setBackground(Color.WHITE);
            ImageIcon icon12 = new ImageIcon(ClassLoader.getSystemResource("icons/icon11.png"));
            Image image12 = icon12.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
            exit.setIcon(new ImageIcon(image12));
            setVisible(true);

        }

        public static void main(String[] args) {
            new project("", "");
        }
    }
}
