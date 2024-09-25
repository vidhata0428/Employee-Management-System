package employee.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class View_Employee extends JFrame implements ActionListener {
    //Part_1 Making a constructor


    Choice choiceEMP; //Choice class presents a pop- up menu for the user , It is a part of Java Abstract Window Toolkit(AWT)

    JTable table; //Created after Part_5 for Part_6

    JButton searchbtn , print , update , back ;

    View_Employee(){


        //Part_3 Setting up the background
        getContentPane().setBackground(new Color(255,131,122));

        //Part_4 To search the employee
        JLabel search = new JLabel("Search by Employee ID");
        search.setBounds(20,20,150,30);
        add(search);

        choiceEMP = new Choice();
        choiceEMP.setBounds(180,20,150,30);
        add(choiceEMP);

        //Part_5 Database me se Data nikal rahe hai
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            while (resultSet.next()){
                choiceEMP.add(resultSet.getString("empID"));
            }
            //Jab bhi hame data ko database me se nikal ke lana hota hai tab ham executequery ka use karte hai



        }catch (Exception e){
            e.printStackTrace();
        }

        //Part_6 Table me data nikal kar store karwa rahe hai
        table = new JTable();
        try {

            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            //ResultSet Object is used to access query results retrieved from the relational databases
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0,100,900,600);
        add(jp);


        //Part_7 Button banana
        searchbtn = new JButton("Search");
        searchbtn.setBounds(20,70,80,20);
        searchbtn.addActionListener(this);
        add(searchbtn);

        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(220,70,80,20);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(320,70,80,20);
        back.addActionListener(this);
        add(back);


        //Part_2 Setting up the Frame
        setSize(900,700);
        setLocation(300,100);
        setLayout(null);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchbtn){
            String query = "select * from employee where empID = '"+choiceEMP.getSelectedItem()+"'";
            try {
                conn c = new conn();
                ResultSet resultSet = c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));

            }catch (Exception E){
                E.printStackTrace();
            }

        } else if (e.getSource() == print) {
            try {
                table.print();
            }catch (Exception E){
                E.printStackTrace();
            }
            
        } else if (e.getSource() == update) {
            setVisible(false);
            new UpdateEmployee(choiceEMP.getSelectedItem());

        }else {
            setVisible(false);
            new Main_class();
        }

    }

    public static void main(String[] args) {
        new View_Employee();
    }
}
