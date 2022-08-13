import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class Room extends JFrame implements ActionListener{
	JTable table;
	JButton back;
	Room(){
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
		Image i2 = i1.getImage().getScaledInstance(600, 500,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(500,20,600,500);
		add(image);
		
        JLabel room_no = new JLabel("Room Number");
        room_no.setBounds(5,10,100,20);
        add(room_no);
        
        JLabel availability = new JLabel("Availability");
        availability.setBounds(110,10,100,20);
        add(availability);
        
        JLabel cleaning_status = new JLabel("Cleaning Status");
        cleaning_status.setBounds(200,10,100,20);
        add(cleaning_status);
        
        JLabel price = new JLabel("Price");
        price.setBounds(310,10,100,20);
        add(price);
        
        JLabel bed_type = new JLabel("Bed Type");
        bed_type.setBounds(410,10,100,20);
        add(bed_type);
        
		table = new JTable();
		table.setBounds(0,40,500,400);
		add(table);
		try {
			conn c = new conn();
			ResultSet rs = c.s.executeQuery("select * from rooms");
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
		
		setBounds(250,100,1000,600);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Reception();
	}

	public static void main(String[] args) {
		new Room();

	}

}
