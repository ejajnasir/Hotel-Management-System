import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class CheckoutUpdate extends JFrame implements ActionListener {
	Choice customer;
	JButton check,update,back;
	JTextField tfroom_number,tfname,tfcheckinTime,tfamountPaid,tfpendingAmount;
	CheckoutUpdate(){
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel heading = new JLabel("Update Status");
		heading.setFont(new Font("Tahoma",Font.PLAIN,15));
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
		
		JLabel name = new JLabel("Name");
		name.setBounds(30,180,100,20);
		add(name);
		
		tfname = new JTextField();
		tfname.setBounds(150,180,100,20);
		add(tfname);
		
		JLabel checkinTime = new JLabel("Checkin Time");
		checkinTime.setBounds(30,230,100,20);
		add(checkinTime);
		
		tfcheckinTime = new JTextField();
		tfcheckinTime.setBounds(150,230,100,20);
		add(tfcheckinTime);
		
		JLabel amountPaid = new JLabel("Amount Paid");
		amountPaid.setBounds(30,280,100,20);
		add(amountPaid);
		
		tfamountPaid = new JTextField();
		tfamountPaid.setBounds(150,280,100,20);
		add(tfamountPaid);
		
		JLabel pendingAmount = new JLabel("Pending Amount");
		pendingAmount.setBounds(30,330,100,20);
		add(pendingAmount);
		
		tfpendingAmount = new JTextField();
		tfpendingAmount.setBounds(150,330,100,20);
		add(tfpendingAmount);
		
		check = new JButton(" Check ");
		check.setBounds(30,380,100,20);
		check.setBackground(Color.black);
		check.setForeground(Color.white);
		check.setFont(new Font("serif",Font.PLAIN,12));
		check.addActionListener(this);
		add(check);
		
		update = new JButton(" Update ");
		update.setBounds(150,380,100,20);
		update.setBackground(Color.black);
		update.setForeground(Color.white);
		update.setFont(new Font("serif",Font.PLAIN,12));
		update.addActionListener(this);
		add(update);
		
		back = new JButton(" Back ");
		back.setBounds(100,420,100,20);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.setFont(new Font("serif",Font.PLAIN,12));
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
		JLabel image = new JLabel(i1);
		image.setBounds(350,30,450,350);
		add(image);
		
		setBounds(250,200,900,500);
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
					tfname.setText(rs.getString("name"));
					tfcheckinTime.setText(rs.getString("checkin_time"));
					tfamountPaid.setText(rs.getString("deposit"));
				}
				String query2 = "select * from rooms where room_no = '"+tfroom_number.getText()+"' ";
				ResultSet rs2 = c.s.executeQuery(query2);
				while(rs2.next()) {
					String price = rs2.getString("price");
					int amountToBePaid = Integer.parseInt(price) - Integer.parseInt(tfamountPaid.getText());
					tfpendingAmount.setText("" + amountToBePaid);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource() == update) {
			String id_number = customer.getSelectedItem();
			String room = tfroom_number.getText();
			String name = tfname.getText();
			String checkin = tfcheckinTime.getText();
			String deposit = tfamountPaid.getText();
			
			try {
				conn c = new conn();
				c.s.executeUpdate("update customer set room_no = '"+room+"',name = '"+name+"',checkin_time = '"+checkin+"',deposit = '"+deposit+"' where id_number = '"+id_number+"'");
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
		new CheckoutUpdate();
	}

}