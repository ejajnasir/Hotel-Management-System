import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class Checkout extends JFrame implements ActionListener{
	Choice customer;
	JTextField tfroom_number,tfcheckinTime;
	JLabel tfcheckoutTime;
	JButton checkout,back;
	Checkout() {
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel text = new JLabel("Checkout");
		text.setBounds(100,20,100,30);
		text.setForeground(Color.blue);
		text.setFont(new Font("serif",Font.PLAIN,25));
        add(text);
		
        JLabel id = new JLabel("Customer Id");
		id.setBounds(30,80,100,20);
		add(id);
		
		customer = new Choice();
		customer.setBounds(150,80,100,20);
		add(customer);
		
		JLabel room_number = new JLabel("Room Number");
		room_number.setBounds(30,130,100,20);
		add(room_number);
		
		tfroom_number = new JTextField();
		tfroom_number.setBounds(150,130,100,20);
		add(tfroom_number);
		
		JLabel checkinTime = new JLabel("Checkin Time");
		checkinTime.setBounds(30,180,100,20);
		add(checkinTime);
		
		tfcheckinTime = new JTextField();
		tfcheckinTime.setBounds(150,180,100,20);
		add(tfcheckinTime);
		
		JLabel checkoutTime = new JLabel("Checkout Time");
		checkoutTime.setBounds(30,230,100,20);
		add(checkoutTime);
		
		Date date = new Date();
		tfcheckoutTime = new JLabel(""+date);
		tfcheckoutTime.setBounds(150,230,100,20);
		add(tfcheckoutTime);
		
		checkout = new JButton(" Checkout ");
		checkout.setBounds(30,300,100,20);
		checkout.setBackground(Color.black);
		checkout.setForeground(Color.white);
		checkout.setFont(new Font("serif",Font.PLAIN,12));
		checkout.addActionListener(this);
		add(checkout);
		
		back = new JButton(" Back ");
		back.setBounds(150,300,80,20);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.setFont(new Font("serif",Font.PLAIN,12));
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
		Image i2 = i1.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(350,50,400,250);
		add(image);
		
		try {
			conn c = new conn();
			ResultSet rs = c.s.executeQuery("select * from customer");
			while(rs.next()) {
				customer.add(rs.getString("id_number"));
				tfroom_number.setText(rs.getString("room_no"));
				tfcheckinTime.setText(rs.getString("checkin_time"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		setBounds(300,200,800,400);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == checkout) {
			String query1 = "delete from customer where id_number = '"+customer.getSelectedItem()+"'";
			String query2 = "update rooms set availability = 'Available' where room_no = '"+tfroom_number.getText()+"'";
			try {
				conn c = new conn();
				c.s.executeUpdate(query1);
				c.s.executeUpdate(query2);
				JOptionPane.showMessageDialog(null,"Checkout Complete");
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
		new Checkout();

	}

}
