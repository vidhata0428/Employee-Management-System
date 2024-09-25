package employee.management.system; //A package in Java is used to group related classes.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {//The extends keyword extends a class (indicates that a class is inherited from another class).
    //Action listner kisi button ke sath laga doge toh pata chalega ki us button par click hua hai

    //Part_3
    //These are global variables
    JTextField tusername;
    JPasswordField tpassword;
    JButton login , back;


    Login(){

        //Part_2
        //JLabel jab apko kisi bhi text ko frame(JFrame) ke upar visible karwana ho
        JLabel username = new JLabel("username");
        username.setBounds(40,20,100,30);
        add(username);

        //After Part_3 we added it here under Part_2
        tusername = new JTextField();
        tusername.setBounds(150,20,150,30);
        add(tusername);


        JLabel password = new JLabel("Password");
        password.setBounds(40,70,100,30);
        add(password);

        //After Part_3 we added it here under Part_2
        tpassword = new JPasswordField();
        tpassword.setBounds(150,70,150,30);
        add(tpassword);

        //Adding Buttons here
        login = new JButton("LOGIN");
        login.setBounds(150,140,150,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this); /* 'this' class implements the ActionListener interface,
         the word 'this' can be used as an argument.*/
        add(login);

        back = new JButton("BACK");
        back.setBounds(150,180,150,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);


        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));//Adding background Image
        Image i21 = i11.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);//Scaling image
        ImageIcon i33 = new ImageIcon(i21);
        JLabel imgg = new JLabel(i33);
        imgg.setBounds(350,10,600,400); //Ye values set karna hit and trial h , practice se ata h
        add(imgg);

        //Adding Background Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.jpg"));//Adding background Image
        Image i2 = i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);//Scaling image
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,600,300);
        add(img);


        //Part_1
        setSize(600,400);
        setLayout(null);
        setLocation(450,200);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Jo bhi click hua hoga wo e me store ho jayega
        if (e.getSource() == login){
            try{
                String username = tusername.getText();
                String password = tpassword.getText();

                conn conn = new conn();
                String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
                ResultSet resultSet = conn.statement.executeQuery(query);
                if(resultSet.next()){
                    setVisible(false);
                    new Main_class();
                }else {
                    JOptionPane.showMessageDialog(null , "Invalid username or password");
                }

            }catch (Exception E){
                E.printStackTrace();
            }
            
        } else if (e.getSource() == back) {
            System.exit(90);
        }

    }

    public static void main(String[] args) {
        new Login();

    }
}
