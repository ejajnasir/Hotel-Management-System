import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class Department extends JFrame implements ActionListener{
	JTable table;
	JButton back;
	Department(){
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		
        JLabel l1 = new JLabel("Department");
        l1.setBounds(110,10,100,20);
        add(l1);
        
        JLabel l2 = new JLabel("Budget(in Rupee)");
        l2.setBounds(320,10,100,20);
        add(l2);
        
        
		table = new JTable();
		table.setBounds(0,40,500,400);
		add(table);
		try {
			conn c = new conn();
			ResultSet rs = c.s.executeQuery("select * from department");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		back = new JButton("Back");
		back.setBounds(200,500,100,20);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.setFont(new Font("serif",Font.PLAIN,15));
		back.addActionListener(this);
		add(back);
		
		setBounds(450,100,500,600);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Reception();
	}

	public static void main(String[] args) {
		new Department();

	}

}
