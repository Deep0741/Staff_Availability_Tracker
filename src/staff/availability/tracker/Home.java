package staff.availability.tracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{

    JButton view, add, update, remove;
    
    Home() {
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1170, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1170, 650);
        add(image);
        
        JLabel heading = new JLabel("Staff Availability Tracker");
        heading.setBounds(700, 150, 400, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 30));
        image.add(heading);
        
        add = new JButton("Add Staff");
        add.setBounds(700, 250, 150, 40);
        add.addActionListener(this);
        image.add(add);
        
        view = new JButton("View Staff");
        view.setBounds(900, 250, 150, 40);
        view.addActionListener(this);
        image.add(view);
        
        update = new JButton("Update Staff");
        update.setBounds(700, 320, 150, 40);
        update.addActionListener(this);
        image.add(update);
        
        remove = new JButton("Remove Staff");
        remove.setBounds(900, 320, 150, 40);
        remove.addActionListener(this);
        image.add(remove);
        
        setSize(1170, 650);
        setLocation(250, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            setVisible(false);
            new AddStaff();
        } else if (ae.getSource() == view) {
            setVisible(false);
            new ViewStaff();
        } else if (ae.getSource() == update) {
            setVisible(false);
            new ViewStaff();
        } else {
            setVisible(false);
            new RemoveStaff();
        }
    }

    public static void main(String[] args) {
        new Home();
    }
}
