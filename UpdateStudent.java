import javax.swing.*;
import java.awt.*;//font size will be awk package
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet; 
import java.awt.event.*;
import java.sql.*;


public class UpdateStudent extends JFrame  implements ActionListener{
  
JTextField tfname, tffname,tfcourse,tfaddress,tfphone,tfemail,tfbranch,tfaadhar,tfx,tfxii;
JLabel labelrollno;
JButton submit,cancel;
Choice crollno;


 UpdateStudent() {
        setSize(900,650);
        setLocation(350,50);

        setLayout(null);
        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(50,10,500,50);
        heading.setFont(new Font("Tahome",Font.ITALIC,35));
        add(heading);

         JLabel lblrollnumber =new JLabel("Select by roll Number");
    lblrollnumber .setBounds(50,100,200,20);
    lblrollnumber.setFont(new Font("serif",Font.PLAIN,20));
    add(lblrollnumber);

    crollno = new Choice();
    crollno.setBounds(250,100,200,20);
    add(crollno);

    try{
       Conn c =new Conn();
       ResultSet rs = c.s.executeQuery("select * from student ");
       while (rs.next()){
        crollno.add(rs.getString("rollno"));
       }
    } catch (Exception e){
        e.printStackTrace();
    }


        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50,150,200,30);
        lblname.setFont(new Font("serif",Font.BOLD,20));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);

        JLabel labelname = new JLabel();
        labelname.setBounds(200,150,150,30);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelname);

        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(400,150,200,30);
        lblfname.setFont(new Font("serif",Font.BOLD,20));
        add(lblfname);

        tffname = new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);


         JLabel  labelfname = new JLabel();
        labelfname.setBounds(600,150,150,30);
        lblfname.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelfname);

        JLabel lblrollno = new JLabel("Roll Number");
        lblrollno.setBounds(50,200,200,30);
        lblrollno.setFont(new Font("serif",Font.BOLD,20));
        add(lblrollno);

        labelrollno = new JLabel();//we r not generating value so we r removing it
        labelrollno.setBounds(200,200,200,30);
        labelrollno.setFont(new Font("tahoma",Font.PLAIN,18));
        add(labelrollno);

        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(400,200,200,30);
        lbldob.setFont(new Font("serif",Font.BOLD,20));
        add(lbldob);


      JLabel  labeldob = new JLabel();
      labeldob.setBounds(600,200,150,30);
      labeldob.setFont(new Font("tahoma",Font.PLAIN,18));
     add(labeldob);

JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50,250,200,30);
        lbladdress.setFont(new Font("serif",Font.BOLD,20));
        add(lbladdress);

        tfaddress = new JTextField(); //if not changing we use Jtextfield 



        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(400,250,200,30);
        lblphone.setFont(new Font("serif",Font.BOLD,20));
        add(lblphone);

        tfphone = new JTextField();
    tfphone.setBounds(600,250,150,30);
        add(tfphone);

        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(50,300,200,30);
        lblemail.setFont(new Font("serif",Font.BOLD,20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);

        JLabel lblx = new JLabel("Class X(%)");
        lblx.setBounds(400,300,200,30);
        lblx.setFont(new Font("serif",Font.BOLD,20));
        add(lblx);

       JLabel labelx = new JLabel();
    labelx.setBounds(600,300,150,30);
    labelx.setFont(new Font("tahoma",Font.PLAIN,18));
        add(labelx);

        tfx = new JTextField();
       tfx.setBounds(600,300,150,30);
        add(tfx);

        JLabel lblxii = new JLabel("Class XII(%) ");
        lblxii.setBounds(50,350,200,30);
        lblxii.setFont(new Font("serif",Font.BOLD,20));
        add(lblxii);

        tfxii = new JTextField();
        tfxii.setBounds(200,350,150,30);
        add(tfxii);

     JLabel   labelxii = new JLabel();
        labelxii.setBounds(200,350,150,30);
        labelxii.setFont(new Font("tahoma",Font.PLAIN,18));
        add(labelxii);

        JLabel lblaadhar = new JLabel("Aadhar Number");
        lblaadhar.setBounds(400,350,200,30);
        lblaadhar.setFont(new Font("serif",Font.BOLD,20));
        add(lblaadhar);

        tfaadhar = new JTextField();
    tfaadhar.setBounds(600,350,150,30);
        add(tfaadhar);

        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(50,400,200,30);
        lblcourse.setFont(new Font("serif",Font.BOLD,20));
        add(lblcourse);

        //array for in drop of box
       
        tfcourse = new JTextField();
        tfcourse.setBounds(200,400,150,30);
        tfcourse.setBackground(Color.WHITE);
       add(tfcourse);

       JLabel lblbranch = new JLabel("Branch");
       lblbranch.setBounds(400,400,200,30);
       lblbranch.setFont(new Font("serif",Font.BOLD,20));
       add(lblbranch);

       //array for in drop of box
       
       tfbranch = new JTextField();
       tfbranch.setBounds(600,400,150,30);
       tfbranch.setBackground(Color.WHITE);
      add(tfbranch);

      try{
        Conn c = new Conn();
        String query ="select * from student where rollno='"+crollno.getSelectedItem()+"'";
        ResultSet rs =c.s.executeQuery(query);
        while (rs.next()){
         labelname.setText(rs.getString("name"));
         labelfname.setText(rs.getString("fname"));
         labeldob.setText(rs.getString("dob"));
         tfaddress.setText(rs.getString("address"));
         tfphone.setText(rs.getString("phone"));
         tfemail.setText(rs.getString("email"));
         labelx.setText(rs.getString("class_x"));
         labelxii.setText(rs.getString("class_xii"));
         tfaadhar.setText(rs.getString("aadhar"));
         labelrollno.setText(rs.getString("rollno"));
         tfcourse.setText(rs.getString("course"));
         tfbranch.setText(rs.getString("branch"));

        }

      } catch (Exception e){
        e.printStackTrace();
      }
crollno.addItemListener(new ItemListener() {
  public void itemStateChanged(ItemEvent ie){
    try{
        Conn c = new Conn();
        String query ="select * from student where rollno='"+crollno.getSelectedItem()+"'";
        ResultSet rs =c.s.executeQuery(query);
        while (rs.next()){
         labelname.setText(rs.getString("name"));
         labelfname.setText(rs.getString("fname"));
         labeldob.setText(rs.getString("dob"));
         tfaddress.setText(rs.getString("address"));
         tfphone.setText(rs.getString("phone"));
         tfemail.setText(rs.getString("email"));
         labelx.setText(rs.getString("class_x"));
         labelxii.setText(rs.getString("class_xii"));
         tfaadhar.setText(rs.getString("aadhar"));
         labelrollno.setText(rs.getString("rollno"));
         tfcourse.setText(rs.getString("course"));
         tfbranch.setText(rs.getString("branch"));

        }

      } catch (Exception e){
        e.printStackTrace();
      }

  }  

  
});
     //button
      submit = new JButton("Update");
      submit.setBounds(250,500,120,30);
      submit.setBackground(Color.BLACK);
      submit.setForeground(Color.white);
      submit.addActionListener(this);
      submit.setFont(new Font("Tahoma",Font.BOLD,15));
      add(submit);

      cancel = new JButton("Cancel");
        cancel.setBounds(450,500,120,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
       add(cancel);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==submit){
             String rollno = labelrollno.getText();
            String address = tfaddress.getText();
            String phone =tfphone.getText();
            String email =tfemail.getText();
            String aadhar = tfaadhar.getText();
            String course =tfcourse.getText();
            String branch=tfbranch.getText();

            try{
               
             String query="update  student set address='"+address+"',phone='"+phone+"',email='"+email+"',aadhar='"+aadhar+"',course='"+course+"',branch='"+branch+"'where rollno='"+rollno+"'";

            Conn c = new Conn();
            c.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null,"Student Details updated  Successfully");
            setVisible(false );

            }catch (Exception e) {
                e.printStackTrace();
            }


        }else{
            setVisible(false);
        }
    }

public static void main(String[] args){
new UpdateStudent();
    }
    
}


    

