package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_class extends JFrame {

    Main_class(){

        //Part_1
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,1120,630);
        add(img);


        //Part_2 //Showing heading of Employee management system
        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(340,155,400,40);
        heading.setFont(new Font("Raleway",Font.BOLD,25));
        img.add(heading);

        //Part_3  //Adding buttons of Add employee , View Employee
        JButton add= new JButton("Add Employee");
        add.setBounds(335,270,150,40);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
            //Part_4
        add.addActionListener(new ActionListener() { //Ek tarika wo bhi tha , constructor ke bahar action perform karwane wala
            @Override
            public void actionPerformed(ActionEvent e) {

                //Ye wala code AddEmployee wali class banne ke bad likha hai
                new AddEmployee();
                setVisible(false);

            }
        });
        img.add(add);

        JButton view= new JButton("View Employee");
        view.setBounds(565,270,150,40);
        view.setForeground(Color.WHITE);
        view.setBackground(Color.BLACK);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Ye wala code Add Employee wali class banne ke bad likha hai
                new View_Employee();
                setVisible(false);

            }
        });
        img.add(view);

        JButton rem = new JButton("Remove Employee");
        rem.setBounds(440,370,150,40);
        rem.setForeground(Color.WHITE);
        rem.setBackground(Color.BLACK);
        rem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RemoveEmployee();
            }
        });
        img.add(rem);

        //Part_1
        setSize(1120,630);
        setLocation(250,100);
        setLayout(null);
        setVisible(true);

    }



    public static void main(String[] args) {
        new Main_class();


    }

}
