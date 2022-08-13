import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class UpdateRoom extends JFrame implements ActionListener {
	Choice customer;
	JButton check,update,back;
	JTextField tfroom_number,tfavailability,tfcleaningStatus;
	UpdateRoom(){
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel heading = new JLabel("Update Room Status");
		heading.setFont(new Font("Tahoma",Font.PLAIN,20));
		heading.setBounds(100,30,200,20);
		add(heading);
		
		JLabel id = new JLabel("Customer Id");
		id.setBounds(30,80,100,20);
		add(id);
		
		customer = new Choice();
		customer.setBounds(150,80,100,20);
		add(customer);
		
		try {
			conn c = new conn();
			ResultSet rs = c.s.executeQuery("select * from customer");
			while(rs.next()) {
				customer.add(rs.getString("id_number"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		

		JLabel room_number = new JLabel("Room Number");
		room_number.setBounds(30,130,100,20);
		add(room_number);
		
		tfroom_number = new JTextField();
		tfroom_number.setBounds(150,130,100,20);
		add(tfroom_number);
		
		JLabel availability = new JLabel("Availability");
		availability.setBounds(30,180,100,20);
		add(availability);
		
		tfavailability = new JTextField();
		tfavailability.setBounds(150,180,100,20);
		add(tfavailability);
		
		JLabel cleaningStatus = new JLabel("Cleaning Status");
		cleaningStatus.setBounds(30,230,100,20);
		add(cleaningStatus);
		
		tfcleaningStatus = new JTextField();
		tfcleaningStatus.setBounds(150,230,100,20);
		add(tfcleaningStatus);
		
		check = new JButton(" Check ");
		check.setBounds(30,280,100,20);
		check.setBackground(Color.black);
		check.setForeground(Color.white);
		check.setFont(new Font("serif",Font.PLAIN,12));
		check.addActionListener(this);
		add(check);
		
		update = new JButton(" Update ");
		update.setBounds(150,280,100,20);
		update.setBackground(Color.black);
		update.setForeground(Color.white);
		update.setFont(new Font("serif",Font.PLAIN,12));
		update.addActionListener(this);
		add(update);
		
		back = new JButton(" Back ");
		back.setBounds(100,330,100,20);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.setFont(new Font("serif",Font.PLAIN,12));
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(350,30,500,350);
		add(image);
		
		setBounds(250,200,900,450);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == check) {
			String i = customer.getSelectedItem();
			String query = "select * from customer where id_number = '"+i+"'";
			try {
				conn c = new conn();
				ResultSet rs = c.s.executeQuery(query);
				while(rs.next()) {
					tfroom_number.setText(rs.getString("room_no"));
				}
				String query2 = "select * from rooms where room_no = '"+tfroom_number.getText()+"' ";
				ResultSet rs2 = c.s.executeQuery(query2);
				while(rs2.next()) {
					tfavailability.setText(rs2.getString("availability"));
					tfcleaningStatus.setText(rs2.getString("clean_status"));
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource() == update) {
			String id_number = customer.getSelectedItem();
			String room_no = tfroom_number.getText();
			String available = tfavailability.getText();
			String cleaning_status = tfcleaningStatus.getText();
			
			try {
				conn c = new conn();
				c.s.executeUpdate("update rooms set room_no = '"+room_no+"',availability = '"+available+"',clean_status = '"+cleaning_status+"' where room_no = '"+room_no+"'");
				JOptionPane.showMessageDialog(null,"Data Updated Succssfully");
				setVisible(false);
				new Reception();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			setVisible(false);
			new Reception();
		}
	}

	public static void main(String[] args) {
		new UpdateRoom();
	}

}