import javax.swing.*;
import java.awt.*;
public class About extends JFrame {

    About(){
        setSize(1100, 1500);
        setLocation(400, 100);
        getContentPane().setBackground(Color.WHITE);


        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/about.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3); 
        image.setBounds(650,160,400,300);
        add(image);

        JLabel heading = new JLabel("<html>City Engineering College(CEC)<br/>Management System</html>");
        heading.setBounds(70, 10, 500, 140);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        add(heading);



       JLabel name= new JLabel("<html><hr/>City Engineering College (CEC),<br/> established under Jayanagar Education Society by Dr K.R Paramahamsa,<br/> Chairman in the year 2001. CEC is one of the most sought colleges by students from across the country for Engineering and Management Education. The college believe in providing a high-quality education to the prospective professionals of the country for which necessary quality bench marks have been put in place, in the areas of faculty recruitment, training and development, teaching and learning process, student’s grooming, external academic audits and feedback system for academic enhancement.</html>");
        name.setBounds(70, 80, 600, 750);
        name.setFont(new Font("Tahoma",Font.PLAIN,30));
        add(name);


        setLayout(null);

        setVisible(true);
    }

    public static void main(String[] args){
        new About();
    }
    
}
