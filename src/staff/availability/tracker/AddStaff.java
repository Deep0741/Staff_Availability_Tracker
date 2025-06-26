package staff.availability.tracker;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;

public class AddStaff extends JFrame implements ActionListener{
    
    Random ran = new Random();
    int number = ran.nextInt(999999);
    
    JTextField tfname, tfage, tfaddress, tfphone, tfaadhar, tfemail, tfcabin;
    JDateChooser dcdob;
    JComboBox cbdepartment;
    JLabel lblstaffId;
    JButton add, back;
    
    AddStaff() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Staff Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        add(heading);
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);
        
        JLabel labelage = new JLabel("Age");
        labelage.setBounds(400, 150, 150, 30);
        labelage.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelage);
        
        tfage = new JTextField();
        tfage.setBounds(600, 150, 150, 30);
        add(tfage);
        
        JLabel labeldob = new JLabel("Date of Birth");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(200, 200, 150, 30);
        add(dcdob);
        
        JLabel labelcabin = new JLabel("Cabin no");
        labelcabin.setBounds(400, 200, 150, 30);
        labelcabin.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelcabin);
        
        tfcabin = new JTextField();
        tfcabin.setBounds(600, 200, 150, 30);
        add(tfcabin);
        
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50, 250, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);
        
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(400, 250, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 300, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);
        
        JLabel labdepartment = new JLabel("Department");
        labdepartment.setBounds(400, 300, 150, 30);
        labdepartment.setFont(new Font("serif", Font.PLAIN, 20));
        add(labdepartment);
        
        String courses[] = {"CS", "IT", "ECE", "Mechanical", "IOD", "Food Tech", "SHD", "SVS",};
        cbdepartment = new JComboBox(courses);
        cbdepartment.setBackground(Color.WHITE);
        cbdepartment.setBounds(600, 300, 150, 30);
        add(cbdepartment);
        
        
        JLabel labelaadhar = new JLabel("Aadhar Number");
        labelaadhar.setBounds(400, 350, 150, 30);
        labelaadhar.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(600, 350, 150, 30);
        add(tfaadhar);
        
        JLabel labelstaffId = new JLabel("Staff id");
        labelstaffId.setBounds(50, 350, 150, 30);
        labelstaffId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelstaffId);
        
        lblstaffId = new JLabel("" + number);
        lblstaffId.setBounds(200, 350, 150, 30);
        lblstaffId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblstaffId);
        
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
        setLocation(300, 50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String name = tfname.getText();
            String age = tfage.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String cabinno = tfcabin.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String department = (String) cbdepartment.getSelectedItem();
            String aadhar = tfaadhar.getText();
            String staffId = lblstaffId.getText();
            
            try {
                Conn conn = new Conn();
                String query = "insert into employee values('"+name+"', '"+tfage+"', '"+dob+"', '"+cabinno+"', '"+address+"', '"+phone+"', '"+email+"', '"+department+"', '"+aadhar+"', '"+staffId+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new AddStaff();
    }
}
