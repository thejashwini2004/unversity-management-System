import java.awt.Image;
import java.security.cert.X509CRL;
import java.awt.*;
import javax.swing.*;
public class Splash extends JFrame implements Runnable  {
    Thread t;
    Splash () {
       ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
       Image i2 = i1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3); 
       add(image);
       t =new Thread(this);
       t.start();

    setVisible(true);
    int X=1;
    for(int i=2; i<=500; i+=4,X+=1){
    setLocation(600-(i + X/2) , 350-(i/2));
    setSize(i +3*X,i + X/2);
    
    try {
        Thread.sleep(10);
}catch (Exception e) {}
       }
       }
    public void run() {
        try{
            Thread.sleep(7000);
            setVisible(false);
//next frame
//creating object for login class
new Login();
        }catch(Exception e) {}

    }
    public static void main(String[] args){
        new Splash();
    }
}


    

