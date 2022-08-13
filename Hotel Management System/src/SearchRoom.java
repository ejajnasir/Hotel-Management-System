import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class SearchRoom extends JFrame implements ActionListener{
	JTable table;
	JButton submit,back;
	JComboBox typeCombo;
	JLabel available;
	JCheckBox checkbox;
	SearchRoom(){
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel search = new JLabel("Search For Room");
		search.setBounds(420,20,200,20);
		search.setFont(new Font("serif",Font.PLAIN,25));
        add(search);
		
        JLabel bedType = new JLabel("Bed Type");
		bedType.setBounds(60,50,100,20);
		add(bedType);
		

		String options [] = {"Single Bed","Double Bed","Master Bed"};
		typeCombo = new JComboBox(options);
		typeCombo.setBounds(120,50,100,20);
		typeCombo.setBackground(Color.white);
		add(typeCombo);
		
		checkbox = new JCheckBox("Available");
		checkbox.setBounds(700,50,100,20);
		checkbox.setBackground(Color.white);
	    add(checkbox);
			
        JLabel room_no = new JLabel("Room Number");
        room_no.setBounds(50,100,100,20);
        add(room_no);
        
        available = new JLabel("Availability");
        available.setBounds(250,100,100,20);
        add(available);
        
        JLabel cleaning_status = new JLabel("Cleaning Status");
        cleaning_status.setBounds(450,100,100,20);
        add(cleaning_status);
        
        JLabel price = new JLabel("Price");
        price.setBounds(650,100,100,20);
        add(price);
        
        JLabel bed_type = new JLabel("Bed Type");
        bed_type.setBounds(850,100,100,20);
        add(bed_type);
        
		table = new JTable();
		table.setBounds(0,120,1000,200);
		add(table);
		try {
			conn c = new conn();
			ResultSet rs = c.s.executeQuery("select * from rooms");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		submit = new JButton("Submit");
		submit.setBounds(300,500,100,20);
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		submit.setFont(new Font("serif",Font.PLAIN,15));
		submit.addActionListener(this);
		add(submit);
		
		back = new JButton("Back");
		back.setBounds(520,500,100,20);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.setFont(new Font("serif",Font.PLAIN,15));
		back.addActionListener(this);
		add(back);
		
		setBounds(250,100,1000,600);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==submit) {
			try {
				String query1 = "select * from rooms where bed_type = '"+typeCombo.getSelectedItem()+"' ";
				String query2 = "select * from rooms where availability = 'Available' and bed_type = '"+typeCombo.getSelectedItem()+"' ";
				
				conn c = new conn();
				ResultSet rs;
				if((checkbox.isSelected())) {
					rs = c.s.executeQuery(query2);
				}else {
					rs = c.s.executeQuery(query1);
				}
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else if(ae.getSource()==back) {
				setVisible(false);
		        new Reception();
		}
	}

	public static void main(String[] args) {
		new SearchRoom();

	}

}
