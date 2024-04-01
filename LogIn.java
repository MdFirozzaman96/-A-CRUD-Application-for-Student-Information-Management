
package STUDENT_MANAGEMENT;


import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class LogIn extends JFrame{
 
    private JLabel userName,password;
    private JTextField nameField;
    private JPasswordField passwordField;
    private JButton clear,login;
    
    Common common=new Common();
    
    public LogIn()
    {
        createFrame();
        clearIcon();
        loginIcon();
        createLabel();
        createTextField();
        createPasswordField();
        createButton();
        createLabel();
        
        putToContainer();
        addAction();
    }
    
    
    private void createFrame()
    {
        this.setSize(1000,700);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Log In");
        this.setIconImage(common.frameIcon("Md_Firozzaman.png").getImage());
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        
        JPanel panel = new JPanel() {
                           
            @Override   
            protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            ImageIcon imageIcon = common.getIcon("baust.jpg");
            Image image = imageIcon.getImage();
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    };
        this.setContentPane(panel);
        this.setVisible(true);
        
    }
    
    private ImageIcon clearIcon()
    {
        ImageIcon img=new ImageIcon(getClass().getResource("clear.jpg"));
        return img;
    }
    private ImageIcon loginIcon()
    {
        ImageIcon img=new ImageIcon(getClass().getResource("login.png"));
        return img;
    }
    
    private void createLabel()
    {
        userName=new JLabel("Enter your user name :");
        userName.setBounds(160,240,180,40);
        userName.setFont(common.getItalicFont(17));
        userName.setForeground(Color.BLACK);
        
        password=new JLabel("Enter your password :");
        password.setBounds(160,290,180,40);
        password.setFont(common.getItalicFont(17));
        password.setForeground(Color.BLACK);
    }
    private void createTextField()
    {
        nameField=new JTextField();
        nameField.setBounds(340,245,230,30);
        nameField.setFont(common.getPlainFont(20));
        nameField.setForeground(Color.BLACK);
    }
    private void createPasswordField()
    {
        passwordField=new JPasswordField();
        passwordField.setBounds(340,295,230,30);
        passwordField.setFont(common.getPlainFont(20));
        passwordField.setForeground(Color.BLACK);
        passwordField.setEchoChar('*');
    }
    private void createButton()
    {
        clear=new JButton();
        clear.setBounds(495,345,75,30);
        clear.setIcon(clearIcon());
        clear.setCursor(common.getCursor());
        
        login=new JButton();
        login.setBounds(400,345,75,30);
        login.setIcon(loginIcon());
        login.setCursor(common.getCursor());
    }
    private void putToContainer()
    {
        Container c=this.getContentPane();
        c.setBackground(Color.CYAN);
        
        c.add(userName);
        c.add(password);
        c.add(nameField);
        c.add(passwordField);
        c.add(clear);
        c.add(login);
    }
    
    public static void main(String[] args) {
        
        LogIn obj = new LogIn();
    }
    
    private void addAction()
    {
        ActionHandler action=new ActionHandler();
        clear.addActionListener(action);
        login.addActionListener(action);
        passwordField.addActionListener(action);
    }
  
 
    class ActionHandler implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource()==clear)
            {
                String str=nameField.getText();
                if(str.isEmpty()==true)
                {
                    JOptionPane.showMessageDialog(null, "You did not enter anythig.");
                }
                nameField.setText("");
                passwordField.setText("");
            }
            if(event.getSource()==passwordField)
            {
                String pass=passwordField.getText();
                JOptionPane.showMessageDialog(null,pass);
            }
            if(event.getSource()==login)
            {
                String userName,password;
                userName=nameField.getText();
                password=passwordField.getText();
                if(userName.equals("firoz96")&&password.equals("130"))
                {
                    JOptionPane.showMessageDialog(null,"Your are successfully loged in.");
                    StudentManagement info=new StudentManagement();
                    info.setVisible(true);
                    dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Wrong passowrd or username !");
                }
            }
        }
    }
    
}
