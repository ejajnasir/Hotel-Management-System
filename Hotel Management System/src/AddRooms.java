import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class AddRooms extends JFrame implements ActionListener{
	
	JTextField tfroom,tfprice;
	JButton addRooms,cancel;
	JComboBox typeCombo,cbClean,cbavail;
	AddRooms(){
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel heading = new JLabel("Add Rooms");
		heading.setFont(new Font("Tahoma",Font.BOLD,15));
		heading.setBounds(110,30,100,20);
		add(heading);
		
		JLabel room_no = new JLabel("Room Number");
		room_no.setFont(new Font("Tahoma",Font.PLAIN,15));
		room_no.setBounds(50,80,100,20);
		add(room_no);
		
		tfroom = new JTextField();
		tfroom.setBounds(180,80,100,20);
		add(tfroom);
		
		JLabel available = new JLabel("Available");
		available.setFont(new Font("Tahoma",Font.PLAIN,15));
		available.setBounds(50,120,100,20);
		add(available);
		
		String avail [] = {"Available","Occupied"};
		cbavail = new JComboBox(avail);
		cbavail.setBounds(180,120,100,20);
		cbavail.setBackground(Color.white);
		add(cbavail);
		
		JLabel clean = new JLabel("Clean Status");
		clean.setFont(new Font("Tahoma",Font.PLAIN,15));
		clean.setBounds(50,160,100,20);
		add(clean);
		
		String cleanStatus [] = {"Cleaned","Dirty"};
		cbClean = new JComboBox(cleanStatus);
		cbClean.setBounds(180,160,100,20);
		cbClean.setBackground(Color.white);
		add(cbClean);
		
		JLabel price = new JLabel("Price");
		price.setFont(new Font("Tahoma",Font.PLAIN,15));
		price.setBounds(50,200,100,20);
		add(price);
		
		tfprice = new JTextField();
		tfprice.setBounds(180,200,100,20);
		add(tfprice);
		
		JLabel bedType = new JLabel("Bed Type");
		bedType.setFont(new Font("Tahoma",Font.PLAIN,15));
		bedType.setBounds(50,240,100,20);
		add(bedType);
		

		String options [] = {"Single Bed","Double Bed","Master Bed"};
		typeCombo = new JComboBox(options);
		typeCombo.setBounds(180,240,100,20);
		typeCombo.setBackground(Color.white);
		add(typeCombo);
		
		addRooms = new JButton(" Add Rooms ");
		addRooms.setBounds(60,280,100,20);
		addRooms.setBackground(Color.black);
		addRooms.setForeground(Color.white);
		addRooms.setFont(new Font("serif",Font.PLAIN,12));
		addRooms.addActionListener(this);
		add(addRooms);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(180,280,100,20);
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		cancel.setFont(new Font("serif",Font.PLAIN,15));
		cancel.addActionListener(this);
		add(cancel);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
		JLabel image = new JLabel(i1);
		image.setBounds(400,30,430,280);
		add(image);
		
		setBounds(280,150,900,400);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == addRooms) {
			
			String room_no = tfroom.getText();
			String availability = (String) cbavail.getSelectedItem();
			String clean_Status = (String) cbClean.getSelectedItem();
			String price = tfprice.getText();
			String bed_type = (String) typeCombo.getSelectedItem();
			
			try {
				conn c = new conn();
				String query = "insert into rooms values('"+room_no+"','"+availability+"','"+clean_Status+"','"+price+"','"+bed_type+"')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Room added successfully");
				setVisible(false);
			}catch(Exception e) {
				e.printStackTrace();
			}
			}
		else {
			setVisible(false);
		}
	}

	public static void main(String[] args) {
		new AddRooms();

	}

}
