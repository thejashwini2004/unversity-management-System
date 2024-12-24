import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;//package for result.rs

public class Login extends JFrame implements ActionListener{


    JButton login,cancel;
    JTextField tfusername,tfpassword;

    Login (){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

//username
    JLabel     lblusername = new JLabel("Username");
        lblusername.setBounds(40,20,100,20);
        add(lblusername);
//input field
         tfusername = new JTextField();
        tfusername.setBounds(150,20,150,20);
        add(tfusername);
//password
    JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40,70,100,20);
        add(lblpassword);
//input field
         tfpassword = new JPasswordField();
        tfpassword.setBounds(150,70,150,20);
        add(tfpassword);
//logain button
        login = new JButton("Login");
        login.setBounds(40,140,120,30);
        login.setBackground(Color.green);
        login.setForeground(Color.BLACK);
        login.addActionListener(this);
        login.setFont(new Font("Tahoma",Font.BOLD,15));
        add(login);
//cancel button
 cancel = new JButton("Cancel");
        cancel.setBounds(180,140,120,30);
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.BLACK);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
add(cancel);
//adding image
ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/Second.jpg"));
       Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3); 
       image.setBounds(350,0,200,200);//setbounds is used only when layout is null
       add(image);

setSize(600, 300);
setLocation(500,250);
setVisible(true);
    }
    //overriden method
   // for clicking on lgain or cancel frame should close 
public void actionPerformed(ActionEvent ae){
    if (ae.getSource () == login){
        String username = tfusername.getText();
        String password = tfpassword.getText();

        String query = "select * from login where username = '" + username+"' and password='"+password+"'";

        try{
          Conn c = new Conn();
        ResultSet rs =  c.s.executeQuery(query);

        if(rs.next()){
         setVisible(false);
          new Project();
        } else {
           JOptionPane.showMessageDialog(null,"invalid username or password" );
           setVisible(false);
        }
        } catch (Exception e){
           e.printStackTrace();     
        }

    }else if (ae.getSource () == cancel){
setVisible(false);
    }

}
public static void main(String[] args){
    new Login();
}
}

    

