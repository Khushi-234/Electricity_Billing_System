package electricty.Biiling.System;

import javax.swing.*;
import javax.swing.plaf.TableHeaderUI;
import java.awt.*;

public class splash extends JFrame implements Runnable
//for solving this we need to implement one abstract one method that is run()
// also we need to abstract the splash class
{

    Thread t;
    //writing constructor
    splash()
    {
        //importing image as size of frame
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/first.jpeg"));
        Image i2= i1.getImage().getScaledInstance(730,550,Image.SCALE_DEFAULT);//same size as frame
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);//we can't directly pass the image icon ,so we have to create object of JLable


        //setting up the frame
        setVisible(true);

        int x=1;
        for(int i=2;i<600;i+=4, x+=1)
        {
            setSize(i+x , i);
            setLocation(700 - ((i+x)/2) , 400 - (i/2));
            //using thread so screen can open slowly
            try{
                Thread.sleep(5);
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        //abstract method - using to hold for 7 second and then open the next page
        t = new Thread(this);
        t.start();//internally calls run
        setVisible(true);
    }

    public void run()
    {
        try{
            Thread.sleep(3000);
            setVisible(false);

            //login frame
            new login();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        //here we only write constructor call not creating any object
        new splash();
    }
}
