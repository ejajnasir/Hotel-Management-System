import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class ManagerInfo extends JFrame implements ActionListener{
	JTable table;
	JButton back;
	ManagerInfo(){
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		
        JLabel l1 = new JLabel("Name");
        l1.setBounds(50,10,100,20);
        add(l1);
        
        JLabel l2 = new JLabel("Age");
        l2.setBounds(180,10,100,20);
        add(l2);
        
        JLabel l3 = new JLabel("Gender");
        l3.setBounds(280,10,100,20);
        add(l3);
        
        JLabel l4 = new JLabel("Job");
        l4.setBounds(410,10,100,20);
        add(l4);
        
        JLabel l5 = new JLabel("Salary");
        l5.setBounds(530,10,100,20);
        add(l5);
        
        JLabel l6 = new JLabel("Phone Number");
        l6.setBounds(630,10,100,20);
        add(l6);
        
        JLabel l7 = new JLabel("Email Id");
        l7.setBounds(770,10,100,20);
        add(l7);
        
        JLabel l8 = new JLabel("Aadhar Number");
        l8.setBounds(880,10,100,20);
        add(l8);
        
        
        
		table = new JTable();
		table.setBounds(0,40,1000,400);
		add(table);
		try {
			conn c = new conn();
			ResultSet rs = c.s.executeQuery("select * from employeedetails where job = 'manager'");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		back = new JButton("Back");
		back.setBounds(450,500,100,20);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.setFont(new Font("serif",Font.PLAIN,15));
		back.addActionListener(this);
		add(back);
		
		setBounds(250,100,1000,600);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Reception();
	}

	public static void main(String[] args) {
		new ManagerInfo();

	}

}
