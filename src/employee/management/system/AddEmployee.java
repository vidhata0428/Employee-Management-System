package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {

    Random ran = new Random();
    int number = ran.nextInt(999999);//bound means boundary , iske age ki value generate nahi karega
    JLabel tempid;

    JTextField tname,tfname,taddress,tphone,taadhar,temail,tsalary,tdesignation;
    JDateChooser tdob;
    JComboBox Boxeducation;

    JButton add,back;

    AddEmployee(){


        //Part_2
        getContentPane().setBackground(new Color(163,255,183));

        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);


        //Part_3
        //Adding the name coloumn
        JLabel name = new JLabel("Name");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("SAN SERIF",Font.BOLD,20));
        add(name);

        tname = new JTextField();
        tname.setBounds(200,150,150,30);
        tname.setBackground(new Color(177,252,197));
        add(tname);

        //Adding the Fathers name coloumn
        JLabel fname = new JLabel("Fathers Name");
        fname.setBounds(400,150,150,30);
        fname.setFont(new Font("SAN SERIF",Font.BOLD,20));
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(600,150,150,30);
        tfname.setBackground(new Color(177,252,197));
        add(tfname);

        //Adding Date of Birth
        JLabel dob= new JLabel("Date of Birth");
        dob.setBounds(50,200,150,30);
        dob.setFont(new Font("SAN SERIF",Font.BOLD,20));
        add(dob);

            //To add calender we need a jar file
        tdob = new JDateChooser();
        tdob.setBounds(200,200,150,30);
        tdob.setBackground(new Color(177,252,197));
        add(tdob);

        //Adding column of salary
        JLabel salary = new JLabel("Salary");
        salary.setBounds(400,200,150,30);
        salary.setFont(new Font("SAN SERIF",Font.BOLD,20));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(600,200,150,30);
        tsalary.setBackground(new Color(177,252,197));
        add(tsalary);

        //Adding adderess
        JLabel address = new JLabel("Address");
        address.setBounds(50,250,150,30);
        address.setFont(new Font("SAN SERIF",Font.BOLD,20));
        add(address);

        taddress = new JTextField();
        taddress.setBounds(200,250,150,30);
        taddress.setBackground(new Color(177,252,197));
        add(taddress);

        //Adding Phone
        JLabel phone = new JLabel("Phone No.");
        phone.setBounds(400,250,150,30);
        phone.setFont(new Font("SAN SERIF",Font.BOLD,20));
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(600,250,150,30);
        tphone.setBackground(new Color(177,252,197));
        add(tphone);

        //Adding Email
        JLabel email = new JLabel("Email");
        email.setBounds(50,300,150,30);
        email.setFont(new Font("SAN SERIF",Font.BOLD,20));
        add(email);

        temail = new JTextField();
        temail.setBounds(200,300,150,30);
        temail.setBackground(new Color(177,252,197));
        add(temail);

        //Adding Highest Education
        JLabel education = new JLabel("Highest Education");
        education.setBounds(400,300,150,30);
        education.setFont(new Font("SAN SERIF",Font.BOLD,20));
        add(education);

        String itmes[] = {"BBA","BTech","BCA","BA","BSC","B.COM","MBA","MCA","MA","MTech","MSC","PHD"};
        Boxeducation = new JComboBox(itmes);
        Boxeducation.setBackground(new Color(177,252,197));
        Boxeducation.setBounds(600,300,150,30);
        add(Boxeducation);

        //Adding Addhar
        JLabel aadhar = new JLabel("Aadhar No.");
        aadhar.setBounds(400,350,150,30);
        aadhar.setFont(new Font("SAN SERIF",Font.BOLD,20));
        add(aadhar);

        taadhar = new JTextField();
        taadhar.setBounds(600,350,150,30);
        taadhar.setBackground(new Color(177,252,197));
        add(taadhar);

        //Adding Employee ID column
        JLabel empid = new JLabel("Employee ID");
        empid.setBounds(50,400,150,30);
        empid.setFont(new Font("SAN SERIF",Font.BOLD,20));
        add(empid);

        tempid = new JLabel(""+number);
        tempid.setBounds(200,400,150,30);
        tempid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        tempid.setForeground(Color.RED);
        add(tempid);

        //Adding Designation
        JLabel designation = new JLabel("Designation");
        designation.setBounds(50,350,150,30);
        designation.setFont(new Font("SAN SERIF",Font.BOLD,20));
        add(designation);

        tdesignation = new JTextField();
        tdesignation.setBounds(200,350,150,30);
        tdesignation.setBackground(new Color(177,252,197));
        add(tdesignation);


        //Part_4
        add = new JButton("ADD");
        add.setBounds(450,500,150,40);
        add.setBackground(Color.black);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBounds(250,500,150,40);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);




        //Part_1
        setSize(900,600);
        setLayout(null);
        setLocation(300,50);
        setVisible(true);

    }


    //Part_5
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==add){

            //Ye jo bhi values enter hui unko nikal ke ek jagah store kar liya hai
            String name = tname.getText();
            String fname = tfname.getText();
            String dob = ((JTextField) tdob.getDateEditor().getUiComponent()).getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String phone = tphone.getText();
            String aadhar = taadhar.getText();
            String email = temail.getText();
            String education = (String) Boxeducation.getSelectedItem();
            String designation = tdesignation.getText();
            String empID = tempid.getText();

            //~Ab usko table me save karne ke liye table banayenge

            //Part_6
            try {

                conn c = new conn();
                //Ye query ke andar jo data insert kiya hai wo usi line se insert karna h jaise table me kiya hai
                String query = "insert into employee values('"+name+"' , '"+fname+"' , '"+dob+"' , '"+salary+"' ,'"+address+"' , '"+phone+"' , '"+email+"' , '"+education+"' , '"+designation+"' ,'"+aadhar+"' , '"+empID+"')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null , "Details added successfully");
                setVisible(false);
                new Main_class();

            }catch (Exception E){
                E.printStackTrace();
            }

        }else {
            setVisible(false);
            new Main_class();
        }
    }

    public static void main(String[] args) {

        new AddEmployee();

    }
}
