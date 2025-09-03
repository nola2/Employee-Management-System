
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;


public class ViewEmployee extends JFrame implements ActionListener {
    
    JTable table;
    Choice comemployeeId;
    JButton search, print, update, back;
    
    ViewEmployee(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(new FlowLayout());
        
        JLabel searchlbl = new JLabel("Search by Employee Id");
        searchlbl.setBounds(20, 20, 150, 20);
        add(searchlbl);
        
        comemployeeId = new Choice();
        comemployeeId.setBounds(180, 20, 150, 20);
        add(comemployeeId);
        
         try{
            
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery ("select * from employee");
            while(rs.next()) {
                
                comemployeeId.add(rs.getString("empId"));
                
            }
            
        } catch (Exception e){
            
            e.printStackTrace();
            
        }
        
        table = new JTable();
        
        
        try{
            
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery ("select * from employee");
            table.setModel (DbUtils.resultSetToTableModel(rs));
                
        } catch (Exception e){
            
            e.printStackTrace();
            
        }
        
       JScrollPane jsp = new JScrollPane(table);
       jsp.setBounds(0,300,800,800);
       add(jsp);
        
        search = new JButton("Search");
        search.setBounds(20, 70,80,20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(120, 70,80,20);
        print.addActionListener(this);
        add(print);
        
        update = new JButton("Update");
        update.setBounds(220, 70,80,20);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(320, 70,80,20);
        back.addActionListener(this);
        add(back);
        
        setSize(750,550);
        setLocation(350,90);
        setVisible(true);
        

        JScrollPane b = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(b);
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == search){
           
            String query = "select * from employee where empId = '"+comemployeeId.getSelectedItem()+"'";
            
            try{
               
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
            } catch (Exception e) {
                
                e.printStackTrace();
            }
            
        } else if(ae.getSource() == print){
            
            try{
               
                table.print();
                
            } catch(Exception e){
                
                e.printStackTrace();
                
            }
            
        } else if(ae.getSource() == update){
            
            setVisible(false);
            new UpdateEmployee(comemployeeId.getSelectedItem());
            
        } else {
            
            setVisible(false);
            new Home();
            
        }
        
    }
    
    public static void main(String[] args){
        
        new ViewEmployee();
        
    }
    
}
