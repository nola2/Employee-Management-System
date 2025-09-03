
package employee.management.system;
import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;


public class AddEmployee extends JFrame implements ActionListener{
    
    Random ran = new Random();
    int number = ran.nextInt(999999);
    
    JTextField tfname, tffname, tfmname, tfaddress, tfnid, tfemail, tfsalary, tfphone, tfdesignation;
    JDateChooser  dcdob;
    JComboBox cbeducation;
    JLabel lblid;
    JButton add, back;
    
    AddEmployee () {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("SERIF", Font.PLAIN, 20));
        add(labelname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);
        
        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(400, 150, 150, 30);
        labelfname.setFont(new Font("SERIF", Font.PLAIN, 20));
        add(labelfname);
        
        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 30);
        add(tffname);
        
        JLabel labelmname = new JLabel("Mother's Name");
        labelmname.setBounds(50, 200, 150, 30);
        labelmname.setFont(new Font("SERIF", Font.PLAIN, 20));
        add(labelmname);
        
        tfmname = new JTextField();
        tfmname.setBounds(200, 200, 150, 30);
        add(tfmname);
        
        JLabel labeldob = new JLabel("Date Of Birth");
        labeldob.setBounds(400, 200, 150, 30);
        labeldob.setFont(new Font("SERIF", Font.PLAIN, 20));
        add(labeldob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(600, 200, 150, 30);
        add(dcdob);
        
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50, 250, 150, 30);
        labeladdress.setFont(new Font("SERIF", Font.PLAIN, 20));
        add(labeladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);
        
        JLabel labelnid = new JLabel("NID No");
        labelnid.setBounds(400, 250, 150, 30);
        labelnid.setFont(new Font("SERIF", Font.PLAIN, 20));
        add(labelnid);
        
        tfnid = new JTextField();
        tfnid.setBounds(600, 250, 150, 30);
        add(tfnid);
        
        JLabel labelphone = new JLabel("Phone No");
        labelphone.setBounds(50, 300, 150, 30);
        labelphone.setFont(new Font("SERIF", Font.PLAIN, 20));
        add(labelphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(200, 300, 150, 30);
        add(tfphone);
        
      
        JLabel labeleducation = new JLabel("Highest Education");
        labeleducation.setBounds(400, 300, 150, 30);
        labeleducation.setFont(new Font("SERIF", Font.PLAIN, 20));
        add(labeleducation);
        
        String courses [] = {"BBA","BCA", "BA", "BSC", "BE", "B.COM", "BTech", "MBA", "MCA", "MA", "MTech", "MSC", "ME", "PHD"};
        cbeducation = new JComboBox(courses);
        cbeducation.setBackground(Color.WHITE);
        cbeducation.setBounds(600, 300, 150, 30);
        add(cbeducation);
        
       
        
        JLabel labelemail = new JLabel("Email Id");
        labelemail.setBounds(50, 350, 150, 30);
        labelemail.setFont(new Font("SERIF", Font.PLAIN, 20));
        add(labelemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 350, 150, 30);
        add(tfemail);
        
        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(400, 350, 150, 30);
        labeldesignation.setFont(new Font("SERIF", Font.PLAIN, 20));
        add(labeldesignation);
        
      
        tfdesignation = new JTextField();
        tfdesignation.setBounds(600, 350, 150, 30);
        add(tfdesignation); 
       
        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(50, 400, 150, 30);
        labelsalary.setFont(new Font("SERIF", Font.PLAIN, 20));
        add(labelsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(200, 400, 150, 30);
        add(tfsalary);
        
        JLabel labelid = new JLabel("Employee Id");
        labelid.setBounds(400, 400, 150, 30);
        labelid.setFont(new Font("SERIF", Font.PLAIN, 20));
        add(labelid);
        
      
        lblid = new JLabel("" + number);
        lblid.setBounds(600, 400, 150, 30);
        lblid.setFont(new Font("SERIF", Font.PLAIN, 20));
        add(lblid);
         
        add = new JButton("Add Details");
        add.setBounds(250, 550, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
       
        
        setSize(900, 700);
        setLocation(330, 50);
        setVisible(true);
    
}
    
   
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == add){
            String name = tfname.getText();
            String fname = tffname.getText();
            String mname = tfmname.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String nid = tfnid.getText();
            String phone = tfphone.getText();
            String education = (String) cbeducation.getSelectedItem();
            String email = tfemail.getText();
            String designation = tfdesignation.getText();
            String salary = tfsalary.getText();
            String id = lblid.getText();
            
            try{
                
                Conn conn = new Conn();
                String query = "insert into employee values('"+name+"', '"+fname+"', '"+mname+"', '"+dob+"', '"+address+"', '"+nid+"', '"+phone+"', '"+education+"', '"+email+"', '"+designation+"', '"+salary+"', '"+id+"' )"; 
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Home();
                
            } catch (Exception e){
                
                e.printStackTrace();
                
            }
            
        } else{
            setVisible(false);
            new Home();
        }
    }    
        
    
    public static void main(String[] arg){
        new AddEmployee();
    }
    
}
