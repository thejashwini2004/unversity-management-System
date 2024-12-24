import javax.swing.*;//frame
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.*;
import  net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class TeacherLeaveDetails extends JFrame implements ActionListener {

    Choice cempId;
    JTable table;
    JButton search,print,exit;
    //default constructor
   TeacherLeaveDetails(){

    getContentPane().setBackground(Color.WHITE);
    setLayout(null);

    JLabel heading =new JLabel("Search by Employee Id ");
    heading .setBounds(20,20,150,20);
    add(heading);

    cempId = new Choice();
    cempId.setBounds(180,20,150,20);
    add(cempId);

    try{
       Conn c =new Conn();
       ResultSet rs = c.s.executeQuery("select * from Teacher ");
       while (rs.next()){
        cempId.add(rs.getString("empId"));
       }
    } catch (Exception e){
        e.printStackTrace();
    }

    table= new JTable();

    try{
        Conn c =new Conn();
        ResultSet rs = c.s.executeQuery("select * from TeacherLeaveDetails ");
        table.setModel(DbUtils.resultSetToTableModel(rs));
     } catch (Exception e){
         e.printStackTrace();
     }


    

JScrollPane jsp = new JScrollPane(table);
    jsp.setBounds(0,100,900,600);
    add(jsp);

    search= new JButton("Search");
    search.setBounds(20,70,80,20);
    search.addActionListener(this);
    add (search);

    print= new JButton("Print");
    print.setBounds(120,70,80,20);
    print.addActionListener(this);
    add (print);

    
   

    exit= new JButton("Exit");
    exit.setBounds(220,70,80,20);
    exit.addActionListener(this);
    add (exit);

    


//frame
setSize(900,700);
setLocation(300,100);
setVisible(true);
   }
    
   public void actionPerformed(ActionEvent ae){

    if (ae.getSource()== search) {
        String query = "select *  from TeacherLeaveDetails where empId='"+cempId.getSelectedItem()+"'";
        try{
          Conn c =new Conn();
          ResultSet rs= c.s.executeQuery(query);
          table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e){
            e.printStackTrace();
        }

    } else if(ae.getSource()==print) {
        try{
        table.print();
        } catch (Exception e){
            e.printStackTrace();
        }

    }else{
        setVisible(false);
    }


   }

    public static void main(String[] args){
         new TeacherLeaveDetails();
    }
}
 
