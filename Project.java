import javax.swing.*;
import java.awt.*;//image class will be stored in this package
import java .awt.event.*;//exit button to work




public class Project extends JFrame implements ActionListener {
    
        Project(){
            setSize(1940,850);
    
            ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
           Image i2 = i1.getImage().getScaledInstance(1500, 750, Image.SCALE_DEFAULT);
           ImageIcon i3 = new ImageIcon(i2);
           JLabel image = new JLabel(i3); 
           add(image);
    //creating menu bar class
     JMenuBar mb = new JMenuBar ();
    
    //New Information
     JMenu newInformation = new JMenu("New Information");
     newInformation.setForeground(Color.BLUE);
    mb.add(newInformation);
    
    JMenuItem facultyInfo =new JMenuItem("New Faculty Information");
    facultyInfo.setBackground(Color.WHITE);
    facultyInfo.addActionListener(this);
    newInformation.add(facultyInfo);
    
    JMenuItem studentInfo =new JMenuItem("New Student Information");
    studentInfo.setBackground(Color.WHITE);
    studentInfo.addActionListener(this);
    newInformation.add(studentInfo);
    
    //Details
    JMenu details = new JMenu("View Details");
     details.setForeground(Color.RED);
    mb.add(details);
    
    JMenuItem facultydetails =new JMenuItem("view Faculty Details");
    facultydetails.setBackground(Color.WHITE);
    facultydetails.addActionListener(this);
    details.add(facultydetails);
    
    JMenuItem studentdetails =new JMenuItem("view Student Details");
    studentdetails.setBackground(Color.WHITE);
    studentdetails.addActionListener(this);
    details.add(studentdetails);
    
    //Leave
    JMenu leave = new JMenu("Apply Leave");
     leave.setForeground(Color.BLUE);
    mb.add(leave);
    
    JMenuItem facultyleave =new JMenuItem("Faculty Leave");
    facultyleave.setBackground(Color.WHITE);
    facultyleave.addActionListener(this);
    leave.add(facultyleave);
    
    JMenuItem studentleave =new JMenuItem("Student Leave");
    studentleave.setBackground(Color.WHITE);
    studentleave.addActionListener(this);
    leave.add(studentleave);
           
    //leave details
    JMenu leaveDetails = new JMenu("Leave Details");
    leaveDetails.setForeground(Color.RED);
    mb.add(leaveDetails);
    
    JMenuItem facultyleaveDetails =new JMenuItem("Faculty leave details ");
    facultyleaveDetails.setBackground(Color.WHITE);
    facultyleaveDetails.addActionListener(this);
 leaveDetails.add(facultyleaveDetails);
    
    JMenuItem studentleaveDetails =new JMenuItem("Student leave details");
    studentleaveDetails.setBackground(Color.WHITE);
    studentleaveDetails.addActionListener(this);
    leaveDetails.add(studentleaveDetails);
    
    //Exams
    JMenu exam = new JMenu("Examination");
    exam.setForeground(Color.BLUE);
    mb.add(exam);
    
    JMenuItem examinationDetails =new JMenuItem("Examination Results");
    examinationDetails.setBackground(Color.WHITE);
    examinationDetails.addActionListener(this);
    exam.add(examinationDetails);
    
    JMenuItem entermarks = new JMenuItem("Enter Marks");
    entermarks.setBackground(Color.WHITE);
    entermarks.addActionListener(this);
    exam.add(entermarks);
    
    //UpdateInfo
    JMenu updateInfo = new JMenu("Update Details");
    updateInfo.setForeground(Color.RED);
    mb.add(updateInfo);
    
    JMenuItem updatefacultyInfo =new JMenuItem("Update Faculty  details");
    updatefacultyInfo.setBackground(Color.WHITE);
    updatefacultyInfo.addActionListener(this);
    updateInfo.add(updatefacultyInfo);
    
    JMenuItem updatestudentInfo=new JMenuItem("Update Student details");
    updatestudentInfo.setBackground(Color.WHITE);
    updatestudentInfo.addActionListener(this);
    updateInfo.add(updatestudentInfo);
    
    //fee
    JMenu fee = new JMenu("Fee Details");
    fee.setForeground(Color.BLUE);
    mb.add(fee);
    
    JMenuItem feestructure =new JMenuItem("Fee Structure");
    feestructure.setBackground(Color.WHITE);
    feestructure.addActionListener(this);
    fee.add(feestructure);
    
    JMenuItem feeform =new JMenuItem("Student Fee Form");
    feeform.setBackground(Color.WHITE);
    feeform.addActionListener(this);
    fee.add(feeform);
    
    //utility
    JMenu utility = new JMenu("Utility");
    utility.setForeground(Color.RED);
    mb.add(utility);
    
    JMenuItem notepad =new JMenuItem(" Notepad ");
    notepad.setBackground(Color.WHITE);
    notepad.addActionListener(this);
    //we are adding facultyInfo under newInformation
    utility.add(notepad);
    
    JMenuItem calc =new JMenuItem("Calculator");
    calc.setBackground(Color.WHITE);
    calc.addActionListener(this);
    //we are adding facultyInfo under newInformatio
    utility.add(calc);
    
    //about
    JMenu about = new JMenu("About");
    about.setForeground(Color.BLUE);
    mb.add(about);
    
    JMenuItem ab =new JMenuItem("About");
    ab.setBackground(Color.WHITE);
    ab.addActionListener(this);
    //we are adding facultyInfo under newInformation
    about.add(ab);
    
    JMenu exit = new JMenu("Exit");
    exit.setForeground(Color.RED);
    mb.add(exit);
    
    JMenuItem ex =new JMenuItem("Exit");
    ex.setBackground(Color.WHITE);
    ex.addActionListener(this);
    //we are adding facultyInfo under newInformation
    exit.add(ex);                                                                                                                                                                                                                                                                                                                                                                                                                   
 //to display  it on frame
 setJMenuBar(mb);  
        
    
            setVisible(true);
            
        }
        public void actionPerformed(ActionEvent ae){
            String msg =ae.getActionCommand();
    
            if(msg.equals(" Exit ")){
                setVisible(false);
            } else if (msg.equals("Calculator")) {
                try{
    Runtime.getRuntime().exec("Calc.exe");
                } catch (Exception e){
    
                }
            } else if (msg.equals(" Notepad ")) {
                try{
    Runtime.getRuntime().exec("notepad.exe");
                } catch (Exception e){
    
                }
            } else if (msg.equals("New Faculty Information")) {
                new AddTeacher();
            } else if (msg.equals("New Student Information")) {
                new  AddStudent();
            }else if (msg.equals("view Faculty Details")) {
                new  TeacherDetails();
            }else if (msg.equals("view Student Details")) {
                new StudentDetails();
            }else if (msg.equals("Faculty Leave")) {
                new TeacherLeave();
            }else if (msg.equals("Student Leave")) {
                new StudentLeave();
            }else if (msg.equals("Faculty leave details ")) {
                new TeacherLeaveDetails();
            }else if (msg.equals("Student leave details")) {
                new StudentLeaveDetails();
            }else if (msg.equals("Update Faculty  details")) {
                new UpdateTeacher();
            }else if (msg.equals("Update Student details")) {
                new UpdateStudent();
            }else if (msg.equals("Enter Marks")) {
                new EnterMarks();
            }else if (msg.equals("Examination Results")) {
                new ExaminationDetails();
            }else if (msg.equals("Fee Structure")) {
                new FeeStructure ();
            }else if (msg.equals("About")) {
                new About();
            }else if (msg.equals("Student Fee Form")) {
                new StudentFeeForm();
            }
        
        }
    
        public static void main(String[] args){
            new Project();
    
        }
        
    }    
    

