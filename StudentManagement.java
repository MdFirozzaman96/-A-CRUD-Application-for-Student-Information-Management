/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package STUDENT_MANAGEMENT;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Container;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MD.Firozzaman
 */
public class StudentManagement extends JFrame{
    private ImageIcon image;
    private Container c;
    private JLabel name,password,department,designation,phone,email,Table;
    private JTextField nameF,deptF,desigF,phoneF,emailF;
    private Font f,f1,fB,fT,fA;
    private JButton addB,upB,delB,disB,clB;
    private Cursor cursor;
    private JTextArea Area;
    private JScrollPane scroll;
    private JTable table;
    private DefaultTableModel model;
    
    //Column :
    private String[] colums = {"Name","Department","Designation","Phone","Email"};
    private String[] rows = new String[5];
    
    StudentManagement()
    {
        Start();
    }
    public void Start()
    {
        image=new ImageIcon(getClass().getResource("firoz.jpg"));
        this.setIconImage(image.getImage());
        
        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.LIGHT_GRAY);
        
        name=new JLabel();
        department=new JLabel();
        designation=new JLabel();
        phone=new JLabel();
        email=new JLabel();
        
        nameF=new JTextField();
        deptF=new JTextField();
        desigF=new JTextField();
        phoneF=new JTextField();
        emailF=new JTextField();
        
        f=new Font("Arial",Font.BOLD,15);
        f1=new Font("Arial",Font.ITALIC,16);
        
        name.setText("Name              :");
        name.setBounds(30,20,100,50);
        ///name.setForeground(Color.ORANGE);
        name.setFont(f);
        c.add(name);
        nameF.setBounds(170,30,200,30);
        nameF.setFont(f1);
        nameF.setToolTipText("Enter the teacher's name.");
        c.add(nameF);
        
        department.setText("Department   :");
        department.setBounds(30,60,100,50);
        department.setFont(f);
        c.add(department);
        deptF.setBounds(170,70,200,30);
        deptF.setFont(f1);
        deptF.setToolTipText("Enter the department of the teacher.");
        c.add(deptF);
        
        designation.setText("Designation  :");
        designation.setBounds(30,100,100,50);
        designation.setFont(f);
        c.add(designation);
        desigF.setBounds(170,110,200,30);
        desigF.setFont(f1);
        desigF.setToolTipText("Enter the designation of the teacher.");
        c.add(desigF);
        
        phone.setText("Phone            :");
        phone.setBounds(30,140,100,50);
        phone.setFont(f);
        c.add(phone);
        phoneF.setBounds(170,150,200,30);
        phoneF.setFont(f1);
        phoneF.setToolTipText("Enter the phone number.");
        c.add(phoneF);
        
        email.setText("Email              :");
        email.setBounds(30,180,100,50);
        email.setFont(f);
        c.add(email);
        emailF.setBounds(170,190,200,30);
        emailF.setFont(f1);
        emailF.setToolTipText("Enter the email id.");
        c.add(emailF);
        
        //JButton : 
        addB=new JButton();
        upB=new JButton();
        delB=new JButton();
        disB=new JButton();
        clB=new JButton();
        
        //Button Font :
        fB=new Font("Arial",Font.ITALIC,18);
        
        //Button Cursor : 
        cursor=new Cursor(Cursor.HAND_CURSOR);
        
        //Button :
        addB.setBounds(30,300,120,30);
        addB.setText("ADD");
        addB.setFont(fB);
        addB.setCursor(cursor);
        addB.setBackground(Color.DARK_GRAY);
        addB.setForeground(Color.white);
        c.add(addB);
        
        upB.setBounds(250,300,120,30);
        upB.setText("UPDATE");
        upB.setFont(fB);
        upB.setCursor(cursor);
        c.add(upB);
        
        delB.setBounds(30,460,120,30);
        delB.setText("DELETE");
        delB.setFont(fB);
        delB.setCursor(cursor);
        c.add(delB);
        
        disB.setBounds(250,460,120,30);
        disB.setText("DISPLAY");
        disB.setFont(fB);
        disB.setCursor(cursor);
        c.add(disB);
        
        clB.setBounds(145,380,120,30);
        clB.setText("CLEAR");
        clB.setFont(fB);
        clB.setCursor(cursor);
        c.add(clB);
        
        //Font Area :
        fA=new Font("Arial",Font.ITALIC,15);
        
        //JTextArea :
        Area=new JTextArea();
        //Area.setBounds(600,70,670,600);
        Area.setFont(fA);
        Area.setLineWrap(true);
        Area.setWrapStyleWord(true);
        //c.add(Area);
        
        //Scroll Pane : 
        /*scroll=new JScrollPane(Area,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(600,70,670,600);
        c.add(scroll);*/
        
        //Table Font :
        fT=new Font("Arial",Font.BOLD,22);
        
        //Teacher's Table Label :
        Table=new JLabel();
        Table.setBounds(860,30,200,30);
        Table.setText("TEACHER");
        Table.setFont(fT);
        c.add(Table);
        
        //Text Area's Table : 
        
        table=new JTable();
        model=new DefaultTableModel();
        model.setColumnIdentifiers(colums);
        table.setModel(model);
        table.setSelectionBackground(Color.RED);
        table.setBackground(Color.WHITE);
        table.setRowHeight(25);
        
        //JScrollPane : 
        scroll=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(600,70,670,600);
        c.add(scroll);
        
        
      //Actonlistener : 
      
      Action obj=new Action();
      //Field Action :
      nameF.addActionListener(obj);
      desigF.addActionListener(obj);
      deptF.addActionListener(obj);
      phoneF.addActionListener(obj);
      emailF.addActionListener(obj);
      
      // Button Action :
      addB.addActionListener(obj);
      upB.addActionListener(obj);
      disB.addActionListener(obj);
      delB.addActionListener(obj);
      clB.addActionListener(obj);
      
      table.addMouseListener(new MouseAdapter(){
      
          @Override
          public void mouseClicked(MouseEvent mouse)
          {
              int RowNum=table.getSelectedRow();
              
              String name=model.getValueAt(RowNum,0).toString();
              String dept=model.getValueAt(RowNum, 1).toString();
              String desig=model.getValueAt(RowNum, 2).toString();
              String phone=model.getValueAt(RowNum, 3).toString();
              String email=model.getValueAt(RowNum, 4).toString();
              
              //Set Founded Data Into Field :
              nameF.setText(name);
              deptF.setText(dept);
              desigF.setText(desig);
              phoneF.setText(phone);
              emailF.setText(email);
          }
      });
    
    }
    class Action implements ActionListener{
        
        
        @Override
        public void actionPerformed(ActionEvent obj)
        {
            if(obj.getSource()==nameF)
            {
                String s=nameF.getText();
                if(s.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Empty information. Please Enter the teacher's name.");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Name : "+s);
                }
            }
            else if(obj.getSource()==desigF)
            {
                String s=desigF.getText();
                if(s.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Empty information. Please Enter the designation of the teacher.");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Designation : "+s);
                }
            }
            else if(obj.getSource()==deptF)
            {
                String s=deptF.getText();
                if(s.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Empty information. Please Enter the department of the teacher.");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Department : "+s);
                }
            }
            else if(obj.getSource()==phoneF)
            {
                String s=phoneF.getText();
                if(s.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Empty information. Please Enter the phone number of the teacher.");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Phone : "+s);
                }
            }
            else if(obj.getSource()==emailF)
            {
                String s=email.getText();
                if(s.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Empty information. Please Enter enter the teacher's email.");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Email : "+s);
                }
            }
            else if(obj.getSource()==addB)
            {
                try {
                    rows[0]=nameF.getText();
                    rows[1]=deptF.getText();
                    rows[2]=desigF.getText();
                    rows[3]=phoneF.getText();
                    rows[4]=emailF.getText();
                    model.addRow(rows);
                    
                    Class.forName("com.mysql.jdbc.Driver");
                    String user="root";
                    String password="";
                    String url="jdbc:mysql://127.0.0.1:3306/university?serverTimezone=UTC";
                    Connection Conn=DriverManager.getConnection(url,user,password);
                    Statement statement=Conn.createStatement();
                    
                    String query="INSERT INTO `teacher_baust`(`Name`,`Department`,`Designation`,`Phone`,`Email`) VALUES ('"+rows[0]+"','"+rows[1]+"','"+rows[2]+"','"+rows[3]+"','"+rows[4]+"')";
                    statement.executeUpdate(query);
                    statement.close();
                    try {
                        Conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(StudentManagement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(StudentManagement.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(StudentManagement.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(obj.getSource()==clB)
            {
                nameF.setText("");
                deptF.setText("");
                desigF.setText("");
                phoneF.setText("");
                emailF.setText("");
            }
            else if(obj.getSource()==delB)
            {
                int RowNum=table.getSelectedRow();
                if(RowNum>=0)
                {
                    try {
                        model.removeRow(RowNum);
                        String nam=nameF.getText();
                        Class.forName("com.mysql.jdbc.Driver");
                        String user="root";
                        String password="";
                        String url="jdbc:mysql://127.0.0.1:3306/university?serverTimezone=UTC";
                        Connection Conn=DriverManager.getConnection(url,user,password);
                        Statement statement=Conn.createStatement();
                        String query="DELETE FROM `teacher_baust` WHERE Name='"+nam+"'";
                        statement.executeUpdate(query);
                        statement.close();
                        Conn.close();
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(StudentManagement.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(StudentManagement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Empty Row.");
                }
            }
            else if(obj.getSource()==upB)
            {
                System.out.println("MD.Firozzaman");
                try {
                    int RowNum=table.getSelectedRow();
                    
                    String Name=nameF.getText();
                    String Depat=deptF.getText();
                    String Design=desigF.getText();
                    String Phone=phoneF.getText();
                    String Email=emailF.getText();
                    
                    model.setValueAt(Name,RowNum,0);
                    model.setValueAt(Depat,RowNum,1);
                    model.setValueAt(Design,RowNum,2);
                    model.setValueAt(Phone,RowNum,3);
                    model.setValueAt(Email,RowNum,4);
                    
                    Class.forName("com.mysql.jdbc.Driver");
                    String user="root";
                    String password="";
                    String url="jdbc:mysql://127.0.0.1:3306/university?serverTimezone=UTC";
                    Connection Conn=DriverManager.getConnection(url,user,password);
                    Statement statement=Conn.createStatement();
                    String Ph=phoneF.getText();
                    //String query="UPDATE `teacher_baust` SET `Name`='"+Name+"',`Department`='"+Depat+"',`Designation`='"+Design+"',`Phone`='"+Phone+"',`Email`='"+Email+"', WHERE `Phone`='"+Phone+"'";
                    String query="UPDATE `teacher_baust` SET `Name`='"+Name+"',`Department`='"+Depat+"',`Designation`='"+Design+"',`Phone`='"+Phone+"',`Email`='"+Email+"' WHERE Phone='"+Phone+"'";
                    statement.executeUpdate(query);
                    statement.close();
                    Conn.close();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(StudentManagement.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(StudentManagement.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(obj.getSource()==disB)
            {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    String user="root";
                    String password="";
                    String url="jdbc:mysql://127.0.0.1:3306/university?serverTimezone=UTC";
                    Connection Conn=DriverManager.getConnection(url,user,password);
                    Statement statement=Conn.createStatement();
                    String query="SELECT * FROM teacher_baust;";
                    ResultSet result=statement.executeQuery(query);
                    while(result.next())
                    {
                        //String name,dept,desig,phone,email;
                        rows[0]=result.getString("Name");
                        rows[1]=result.getString("Department");
                        rows[2]=result.getString("Designation");
                        rows[3]=result.getString("Phone");
                        rows[4]=result.getString("Email");
                        model.addRow(rows);
                        //System.out.println(name+" "+dept+" "+desig+" "+phone+" "+email);
                    }
                    statement.close();
                    Conn.close();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(StudentManagement.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(StudentManagement.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public static void main(String[] args){
        
       // JFrame obj=new JFrame();
       StudentManagement obj=new StudentManagement();
       obj.setVisible(true);
       obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       obj.setBounds(55,30,1320,700);
       obj.setTitle("MD.FIROZZAMAN_180201130");
       obj.setResizable(true);
       
       //Database Connection :
       
       /*Class.forName("com.mysql.jdbc.Driver");
       String user="root";
       String password="";
       String url="jdbc:mysql://127.0.0.1:3306/university?serverTimezone=UTC";
       Connection Conn=DriverManager.getConnection(url,user,password);
       Statement statement=Conn.createStatement();*/
       
       //Show Database :
       /*String query="SELECT * FROM teacher_baust;";
       ResultSet result=statement.executeQuery(query);
       while(result.next())
       {
           String name,dept,desig,phone,email;
           name=result.getString("Name");
           dept=result.getString("Department");
           desig=result.getString("Designation");
           phone=result.getString("Phone");
           email=result.getString("Email");
           System.out.println(name+" "+dept+" "+desig+" "+phone+" "+email);
       }*/
       //Insert Row :
       /*String query="INSERT INTO `teacher_baust`(`Name`,`Department`,`Designation`,`Phone`,`Email`) VALUES ('Firoz','CSE','Student','02039','smdfiro')";
       statement.executeUpdate(query);*/
       //Update Row :
       /*String query="UPDATE `teacher_baust` SET `Name`='Firozzaman',`Department`='EEE',`Designation`='Student',`Phone`='01722',`Email`='smdfirozzama' WHERE name='firoz'";
       statement.executeUpdate(query);*/
       //Delete Row :
       /*String query="DELETE FROM `teacher_baust` WHERE name='Firozzaman'";
       statement.executeUpdate(query);*/
       /*statement.close();
       Conn.close();*/
    }
}