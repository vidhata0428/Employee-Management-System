package employee.management.system;

import javax.swing.*;//swing is a toolkit to built GUI for applications
import java.awt.*;

public class Splash extends JFrame /*frame banane ke liye*/ {
    Splash(){ //Constructor

        //  Part_2
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.gif")); //Wo image leli ab
        Image i2 = i1.getImage().getScaledInstance(1170,650 , Image.SCALE_DEFAULT);//image ko apne hisab se set kar rahe hai
        ImageIcon i3 = new ImageIcon(i2); //kyoki sidhe image ko use nahi kar sakte

        //Direct image ko frame nahi add karwa sakte isiliye label ka use karna padta hai
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1170,650);
        add(image);




        //Pehle ye set kiya tha maina , isme fram width wagera , visibility default false rehti h isiliye true kari
        //Part_1
        setSize(1170 , 650);//width of the frame
        setLocation(200 , 50);//setting frame from right and left
        setLayout(null);//Cause we dont want default settings
        setVisible(true);

        //Part_3
        /*The Try Catch in java statements allows you to define a block of
         code to be tested for exceptions (errors) while it is being executed
         */
        try{
            Thread.sleep(5000);
            setVisible(false);
            new Login();
        }catch (Exception e ){
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {

        new Splash(); //Object banaya

    }

}
