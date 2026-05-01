package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener {

    About() {
        setBounds(600, 200, 500, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel l1 = new JLabel("ABOUT");
        l1.setBounds(200, 10, 100, 40);
        l1.setForeground(Color.RED);
        l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(l1);

        String s = "(Travel Management System)\n"
                + "\n"
                + "Our Travel Management System is designed to provide a simple, efficient, and user-friendly platform for managing travel-related services. The system helps users book hotels, check travel packages, manage customer details, and handle reservations with ease.\n"
                + "\n"
                + "We aim to reduce manual work and make the entire travel process faster and more organized. By integrating all travel services into one system, we ensure convenience, accuracy, and better user experience."; //
                 // The system is built using technologies like Java (Swing/AWT) for the interface and MySQL for database management. It improves efficiency, reduces errors, and provides a centralized solution for travel services.  
        
        
        
        TextArea area = new TextArea(s, 10, 40, Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(20, 100, 450, 300);
        add(area);

        JButton back = new JButton("Back");
        back.setBounds(200, 420, 80 + 20, 40 - 25);
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }

    public static void main(String arg[]) {
        new About();
    }

}
