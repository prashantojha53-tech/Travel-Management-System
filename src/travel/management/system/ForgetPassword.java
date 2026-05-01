package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ForgetPassword extends JFrame implements ActionListener {

    JTextField tfusername, tfname, tfquestion, tfanswer, tfpassword;
    JButton search, retrieve, back;
    Choice security;
//    private PopupMenu answer;

    ForgetPassword() {
        setBounds(350, 200, 850, 380);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580, 70, 200, 200);
        add(image);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30, 50, 500, 280);
        add(p1);

        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblusername.setBounds(50, 20, 125, 25);
        p1.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(220, 20, 150, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);

        search = new JButton("search");
        search.setBackground(Color.GRAY);
        search.setForeground(Color.white);
        search.setBounds(380, 20, 100, 25);
        search.addActionListener(this);
        p1.add(search);

        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblname.setBounds(50, 60, 125, 25);
        p1.add(lblname);

        tfname = new JTextField();
        tfname.setBounds(220, 60, 150, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);

        JLabel lblsecurity = new JLabel("Security Question");
        lblsecurity.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblsecurity.setBounds(40, 100, 150, 25);
        p1.add(lblsecurity);

        security = new Choice();
        security.setBounds(220, 100, 150, 25); // same position

        security.add("Fav Character from The Boys");
        security.add("Fav Teacher");
        security.add("Fav Lucky Number");
        security.add("Fav Childhood Dream");

        p1.add(security);

        JLabel lblanswer = new JLabel("Answer");
        lblanswer.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblanswer.setBounds(40, 140, 150, 25);
        p1.add(lblanswer);

        tfanswer = new JTextField();
        tfanswer.setBounds(220, 140, 150, 25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);

        retrieve = new JButton("Retrieve");
        retrieve.setBackground(Color.GRAY);
        retrieve.setForeground(Color.white);
        retrieve.setBounds(380, 100, 100, 25);
        retrieve.addActionListener(this);
        p1.add(retrieve);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblpassword.setBounds(40, 180, 150, 25);
        p1.add(lblpassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(220, 180, 150, 25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);

        back = new JButton("Back");
        back.setBackground(Color.GRAY);
        back.setForeground(Color.white);
        back.setBounds(150, 230, 140, 25);
        back.addActionListener(this);
        p1.add(back);

        setVisible(true);
    }

    
    public void actionPerformed(ActionEvent ae) {

    if (ae.getSource() == search) {

        if (tfusername.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter Username First!");
            return;
        }

        try {
            conn c = new conn();

            String query = "SELECT * FROM account WHERE username=?";
            PreparedStatement ps = c.c.prepareStatement(query);
            ps.setString(1, tfusername.getText().trim());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                tfname.setText(rs.getString("name"));
                security.select(rs.getString("security"));
            } else {
                JOptionPane.showMessageDialog(null, "Username not found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    } else if (ae.getSource() == retrieve) {

        if (tfanswer.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter Answer!");
            return;
        }

        try {
            conn c = new conn();

            String query = "SELECT * FROM account WHERE username=? AND security=? AND LOWER(answer)=LOWER(?)";
            PreparedStatement ps = c.c.prepareStatement(query);

            ps.setString(1, tfusername.getText().trim());
            ps.setString(2, security.getSelectedItem());
            ps.setString(3, tfanswer.getText().trim());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                tfpassword.setText(rs.getString("password"));
            } else {
                JOptionPane.showMessageDialog(null, "Wrong Question or Answer!");
                tfpassword.setText("");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    } else if (ae.getSource() == back) {
        setVisible(false);
        new Login();
    }
}

    public static void main(String arg[]) {
        new ForgetPassword();
    }
}
