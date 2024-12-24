import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.time.Year;
import java.awt.event.*;
public class StudentFeeForm  extends JFrame implements ActionListener{
    Choice crollno;
    JComboBox cbcourse,cbbranch,cbyear;
    JLabel labeltotal;
    JButton update,pay,back;
   

    StudentFeeForm(){
        setSize(900,500);
        setLocation(300,100);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);


        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3); 
        image.setBounds(400,50,500,300);
        add(image);

         JLabel lblrollnumber =new JLabel("Select Roll No");
         lblrollnumber .setBounds(40,60,150,20);
         lblrollnumber.setFont(new Font("Tahoma",Font.BOLD,16));
         add(lblrollnumber);

    crollno = new Choice();
    crollno.setBounds(200,60,150,20);
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
        lblname.setBounds(40,100,150,20);
        lblname.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblname);

        JLabel labelname = new JLabel();
        labelname.setBounds(200,100,150,20);
        lblname.setFont(new Font("Tahoma",Font.BOLD,16));
        add(labelname);

        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(40,140,150,20);
        lblfname.setFont(new Font("serif",Font.BOLD,16));
        add(lblfname);

         JLabel  labelfname = new JLabel();
        labelfname.setBounds(200,140,150,20);
        lblfname.setFont(new Font("Tahoma",Font.BOLD,16));
        add(labelfname);

        try{
            Conn c = new Conn();
            String query ="select * from student where rollno='"+crollno.getSelectedItem()+"'";
            ResultSet rs =c.s.executeQuery(query);
            while (rs.next()){
             labelname.setText(rs.getString("name"));
             labelfname.setText(rs.getString("fname"));
             
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
                 
                
                }
        
              } catch (Exception e){
                e.printStackTrace();
              }
        
          }  
        
          
        });
        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(40,180,150,20);
        lblcourse.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblcourse);

        String course[]={" ","CSE","AIML","IS","EC","MTech","BCA","MCA"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(200,180,150,20);
        cbcourse.setBackground(Color.WHITE);
       add(cbcourse);

       JLabel lblbranch = new JLabel("Branch");
       lblbranch.setBounds(40,220,150,20);
       lblbranch.setFont(new Font("Tahoma",Font.BOLD,16));
       add(lblbranch);

       //array for in drop of box
       String branch[]={" ","Computer Science","Artificial Intelligence","Electrionics","Information Technology","Mechanical Engineering","Civil Engineering","IT"};
       cbbranch = new JComboBox(branch);
       cbbranch.setBounds(200,220,150,30);
       cbbranch.setBackground(Color.WHITE);
      add(cbbranch);
        
       JLabel lblyear=new JLabel("select year") ;
       lblyear.setBounds(40,260,150,20);
       lblyear.setFont(new Font("Tahoma",Font.BOLD,16));
       add(lblyear);

       String year[]={"First_Year","Second _Year","Third_Year","Fourth_Year"};
      cbyear=new JComboBox(year);
      cbyear.setBounds(200,260,150,20);
      cbyear.setBackground(Color.WHITE);
     add(cbyear);
 
     JLabel lbltotal = new JLabel("Total Payable");
     lbltotal.setBounds(40,300,150,20);
     lbltotal.setFont(new Font("Tahome",Font.BOLD,16));
     add(lbltotal);

      labeltotal = new JLabel();
     labeltotal.setBounds(200,300,150,20);
     labeltotal.setFont(new Font("Tahome",Font.PLAIN,16));
     add(labeltotal);

     update = new JButton("Update");
     update.setBounds(30,380,100,25);
     update.setBackground(Color.BLACK);
     update.setForeground(Color.white);
    update.addActionListener(this);
     update.setFont(new Font("Tahoma",Font.BOLD,15));
     add(update);

       pay = new JButton("Pay fee");
       pay.setBounds(150,380,100,35);
       pay.setBackground(Color.black);
       pay.setForeground(Color.white);
       pay.addActionListener(this);
       pay.setFont(new Font("Tahoma",Font.BOLD,15));
       add(pay);

       back = new JButton("Back");
       back.setBounds(270,380,100,25);
       back.setBackground(Color.black);
       back.setForeground(Color.white);
       back.addActionListener(this);
       back.setFont(new Font("Tahoma",Font.BOLD,15));
       add(back);


     setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
      if (ae.getSource()==update){
        String course = (String)cbcourse.getSelectedItem();
        String year =(String)cbyear.getSelectedItem();
        try{
          Conn c = new Conn();
          ResultSet rs = c.s.executeQuery("select * from fee where course='"+course+"'");
          while(rs.next()){
            labeltotal.setText(rs.getString(year));
          }

        } catch (Exception e){
          e.printStackTrace();
        }
      }else if (ae.getSource()== pay){
        String rollno = crollno.getSelectedItem();
        String course = (String)cbcourse.getSelectedItem();
        String year =(String)cbyear.getSelectedItem();
        String branch =(String)cbbranch.getSelectedItem();
        String total=labeltotal.getText();
        try{
          Conn c = new Conn();
          String query="insert into collegefee values('"+rollno+"','"+course+"','"+branch+"','"+year+"','"+total+"')";
          c.s.executeQuery(query);
          JOptionPane.showMessageDialog(null, "College fee submitted succesfully");
          setVisible(false);
          }

         catch (Exception e){
          e.printStackTrace();
        }
        
      }else{
        setVisible(false);
      }
    }

    public static void main(String[]args){
        new StudentFeeForm();
    }
}
