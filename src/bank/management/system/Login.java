package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{

    JButton login, signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    Login() {
        
        setTitle("Automated Teller Machine");
        
        setLayout(null);
        
        //Bank icon
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bankIMG.png"));
        Image i2 = i1.getImage().getScaledInstance(170 , 170, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 30, 170, 170);
        add(label);
        
        
        //welcome text
        JLabel text = new JLabel("Welcome to ATM!!!");
        text.setFont(new Font("Raleway", Font.BOLD, 38));
        text.setBounds(350, 90, 400, 40);
        add(text);
        
        //cand no 
        JLabel cardno = new JLabel("Card No.");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(300, 240, 150, 40);
        add(cardno);
        
        //card no field
        cardTextField = new JTextField();
        cardTextField.setBounds(450, 245, 250, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);
        
        //pin
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(300, 300, 100, 40);
        add(pin);
        
        //password field
        pinTextField = new JPasswordField();
        pinTextField.setBounds(450, 305, 250, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);
        
        //sign in button
        login = new JButton("SIGN IN");
        login.setBounds(300, 400, 120, 40);
        login.setBackground(new Color(5, 117, 165));
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        //clear button
        clear = new JButton("CLEAR");
        clear.setBounds(440, 400, 120, 40);
        clear.setBackground(new Color(5, 117, 165));
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        //sign up button
        signup = new JButton("SIGN UP");
        signup.setBounds(580, 400, 120, 40);
        signup.setBackground(new Color(5, 117, 165));
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        setSize(1000, 550);
        setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2); 
        setLocationRelativeTo(null);

    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");
        }else if(ae.getSource() == login) {
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"' ";
            try {
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()) {
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                }
            }catch(Exception e) {
                System.out.println(e);
            }
            
        }else if(ae.getSource() == signup) {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }
}
