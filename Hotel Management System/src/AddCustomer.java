import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;
public class AddCustomer extends JFrame implements ActionListener{
	JButton add,back;
	JTextField tfnumber,tfname,tfcountry,tfdeposit;
	JComboBox cbid;
	JRadioButton rbmale,rbfemale;
	Choice croom;
	JLabel lcheckin_time;
	AddCustomer() {
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel heading = new JLabel("Add Customer Details");
		heading.setFont(new Font("Tahoma",Font.BOLD,15));
		heading.setBounds(110,15,200,20);
		add(heading);
		
		JLabel lbid = new JLabel("Id");
		lbid.setBounds(40,70,100,20);
		add(lbid);
		
		String id_options[] = {"Passport","Aadhar Card","Voter-Id Card","Driving License"};
		cbid = new JComboBox(id_options);
		cbid.setBounds(100,70,100,20);
		cbid.setBackground(Color.white);
		add(cbid);
		
		JLabel lbnumber = new JLabel("Number");
		lbnumber.setBounds(40,105,100,20);
		add(lbnumber);
		
		tfnumber = new JTextField();
		tfnumber.setBounds(100,105,100,20);
		add(tfnumber);
		
		JLabel name = new JLabel("Name");
		name.setBounds(40,140,100,20);
		add(name);
		
		tfname = new JTextField();
		tfname.setBounds(100,140,100,20);
		add(tfname);
		
		JLabel gender = new JLabel("Gender");
		gender.setBounds(40,175,100,20);
		add(gender);
		
		rbmale = new JRadioButton("Male");
		rbmale.setBackground(Color.white);
		rbmale.setBounds(90,175,70,20);
		add(rbmale);
		
		rbfemale = new JRadioButton("Female");
		rbfemale.setBackground(Color.white);
		rbfemale.setBounds(140,175,70,20);
		add(rbfemale);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbmale);
		bg.add(rbfemale);
		
		JLabel country = new JLabel("Country");
		country.setBounds(40,210,100,20);
		add(country);
		
		tfcountry = new JTextField();
		tfcountry.setBounds(100,210,100,20);
		add(tfcountry);
		
		JLabel lbroom = new JLabel("Room No.");
		lbroom.setBounds(40,245,100,20);
		add(lbroom);
		
		croom = new Choice();
		try {
			conn c = new conn();
			String query = "select * from rooms where availability = 'Available'";
			ResultSet rs = c.s.executeQuery(query);
			while(rs.next()) {
				croom.add(rs.getString("room_no"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		croom.setBounds(150,245,50,20);
		add(croom);
		
		JLabel time = new JLabel("Checkin Time");
		time.setBounds(40,280,100,20);
		time.setFont(new Font("Tahoma",Font.PLAIN,10));
		add(time);
		
		Date date = new Date();
		
		lcheckin_time = new JLabel(""+date);
		lcheckin_time.setBounds(100,280,100,20);
		lcheckin_time.setFont(new Font("Tahoma",Font.PLAIN,10));
		add(lcheckin_time);
		
		JLabel deposit = new JLabel("Deposit");
		deposit.setBounds(40,315,100,20);
		add(deposit);
		
	    tfdeposit = new JTextField();
		tfdeposit.setBounds(100,315,100,20);
		add(tfdeposit);
		
		add = new JButton(" Add ");
		add.setBounds(40,350,80,20);
		add.setBackground(Color.black);
		add.setForeground(Color.white);
		add.setFont(new Font("serif",Font.PLAIN,12));
		add.addActionListener(this);
		add(add);
		
		back = new JButton("Back");
		back.setBounds(125,350,80,20);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.setFont(new Font("serif",Font.PLAIN,15));
		back.addActionListener(this);
		add(back);
		

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
		Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(200,40,450,300);
		add(image);
		
		setBounds(300,200,600,450);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == add) {
			String id = (String)cbid.getSelectedItem();
			String id_number = tfnumber.getText();
			String name = tfname.getText();
			String gender = null;
			if(rbmale.isSelected()) {
				gender = "Male";
			}else if(rbfemale.isSelected()) {
				gender = "Female";
			}
			String country = tfcountry.getText();
			String room_no = croom.getSelectedItem();
			String checkin_time = lcheckin_time.getText();
			String deposit = tfdeposit.getText();
			
			try {
				conn c = new conn();
				String query1 = "insert into customer values('"+id+"','"+id_number+"','"+name+"','"+gender+"','"+country+"','"+room_no+"','"+checkin_time+"','"+deposit+"')";
				String query2 = "update rooms set availability = 'occupied' where room_no = '"+room_no+"' ";
				c.s.executeUpdate(query1);
				c.s.executeUpdate(query2);
				
				JOptionPane.showMessageDialog(null,"New Customer Added Successfully");
				setVisible(false);
				new Reception();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource() == back) {
			setVisible(false);
			new Reception();
		}
	}

	public static void main(String[] args) {
		new AddCustomer();

	}

}
