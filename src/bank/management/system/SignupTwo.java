package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    
    JTextField pan, aadhar;
    JButton next;
    JRadioButton syes, sno, eno, eyes;
    JComboBox religions, incomeCategory, edu, occupations;
    String formno;
    
    SignupTwo(String formno) {
        this.formno = formno;
        setLayout(null);
        
        setTitle("New Account Application Form - Page 2");
        
        //additional details
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);
        
        
        //religion
        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100, 140, 100, 30);
        add(religion);
        
        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religions = new JComboBox(valReligion);
        religions.setBounds(300, 140, 400, 30);
        religions.setBackground(Color.WHITE);
        add(religions);
        
        
        //Date of Birth
        JLabel income = new JLabel("Income(monthly):");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100, 240, 180, 30);
        add(income);
        
        String str[] = {"NULL", "< 10,000", "< 50,000", "< 1,00,000", ">1,00,00"};
        incomeCategory = new JComboBox(str);
        incomeCategory.setBounds(300, 240, 400, 30);
        incomeCategory.setBackground(Color.WHITE);
        add(incomeCategory);
       
        //education
        JLabel education = new JLabel("Educational");
        education.setFont(new Font("Raleway", Font.BOLD, 20));
        education.setBounds(100, 310, 150, 30);
        add(education);
        
        //email
        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        qualification.setBounds(100, 330, 150, 30);
        add(qualification);
        
        String courses[] = {"Metric", "Graduate", "Post-Graduate", "Doctrate", "Others"};
        edu = new JComboBox(courses);
        edu.setBounds(300, 330, 400, 30);
        edu.setBackground(Color.WHITE);
        add(edu);
        
        //marital status
        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100, 390, 150, 30);
        add(occupation);
        
        String occupationValues[] = {"Salaried", "Self-Employed", "Bussiness", "Student", "Retired", "Others"};
        occupations = new JComboBox(occupationValues);
        occupations.setBounds(300, 390, 400, 30);
        occupations.setBackground(Color.WHITE);
        add(occupations);
 
        //address
        JLabel panNo = new JLabel("PAN No:");
        panNo.setFont(new Font("Raleway", Font.BOLD, 20));
        panNo.setBounds(100, 440, 150, 30);
        add(panNo);
        
        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300, 440, 400, 30);
        add(pan);
        
        //city
        JLabel aadharNo = new JLabel("Aadhar No:");
        aadharNo.setFont(new Font("Raleway", Font.BOLD, 20));
        aadharNo.setBounds(100, 490, 150, 30);
        add(aadharNo);
        
        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhar.setBounds(300, 490, 400, 30);
        add(aadhar);
        
        //State
        JLabel seniorCitizen = new JLabel("Senior Citizen:");
        seniorCitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorCitizen.setBounds(100, 540, 150, 30);
        add(seniorCitizen);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(400, 540, 100, 30);
        add(sno);
        
        ButtonGroup seniorCitizenGroup = new ButtonGroup();
        seniorCitizenGroup.add(syes);
        seniorCitizenGroup.add(sno);

       
        //Pin Code
        JLabel existingAccount = new JLabel("Existing Account:");
        existingAccount.setFont(new Font("Raleway", Font.BOLD, 20));
        existingAccount.setBounds(100, 590, 150, 30);
        add(existingAccount);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(400, 590, 100, 30);
        add(eno);
        
        ButtonGroup existingAccGroup = new ButtonGroup();
        existingAccGroup.add(eyes);
        existingAccGroup.add(eno);
        
        next = new JButton("Next");
        next.setBackground(new Color(5, 117, 165));
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 700, 80, 30);
        next.addActionListener(this);
        add(next);
        
        setSize(850, 800); 
        setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2); 
        setLocationRelativeTo(null);
    }
    
    public void actionPerformed(ActionEvent ae) {
        String sreligion = (String)religions.getSelectedItem(); 
        String sincome = (String)incomeCategory.getSelectedItem();
        String seducation = (String)edu.getSelectedItem();
        String soccupation = (String)occupations.getSelectedItem();
        String seniorcitizen = null;
        if(syes.isSelected()) {
            seniorcitizen = "Yes";
        }else seniorcitizen = "No";
      
        
        String existingaccount = null;
        if(eyes.isSelected()){
            existingaccount = "Yes";
        }else existingaccount = "No";
        
        String span = pan.getText();
        String saadhar = aadhar.getText();
        
        
        try {
                Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"','"+sreligion+"', '"+sincome+"','"+seducation+"','"+soccupation+"','"+seniorcitizen+"','"+existingaccount+"','"+span+"','"+saadhar+"')";
                //Step 4.
                c.s.executeUpdate(query);
           
                //signup3 Object
                setVisible(false);
                new SignupThree(formno).setVisible(true);
                
        }catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void main(String [] args) {
        new SignupTwo("");
    }
}
