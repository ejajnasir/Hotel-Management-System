import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class dashboard extends JFrame implements ActionListener{
	
	dashboard() {
		setLayout(null);
		setBounds(0,0,1570,1000);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1570, 1000,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,1570,1000);
		add(image);
		
		JLabel text = new JLabel("THE TAJ GROUP WELCOMES YOU");
		text.setBounds(350,80,700,30);
		text.setForeground(Color.white);
		text.setFont(new Font("serif",Font.PLAIN,40));
		image.add(text);
		
		JMenuBar mb = new JMenuBar();
		mb.setBounds(0,10,1550,30);
		image.add(mb);
		
		JMenu hotel = new JMenu("Hotel Managenent");
		hotel.setForeground(Color.black);
		mb.add(hotel);
		
		JMenuItem reception = new JMenuItem("Reception");
		reception.addActionListener(this);
		hotel.add(reception);
		
		JMenu admin = new JMenu("Admin");
		admin.setForeground(Color.black);
		mb.add(admin);
		
		JMenuItem addemployee = new JMenuItem("Add Employee");
		addemployee.addActionListener(this);
		admin.add(addemployee);
		
		JMenuItem addroom = new JMenuItem("Add Room");
		addroom.addActionListener(this);
		admin.add(addroom);
		
		JMenuItem adddriver = new JMenuItem("Add Driver");
		adddriver.addActionListener(this);
		admin.add(adddriver);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("Add Employee")) {
			new AddEmployee();
		}else if(ae.getActionCommand().equals("Add Room")) {
			new AddRooms();
		}else if(ae.getActionCommand().equals("Add Driver")) {
			new AddDriver();
		}else if(ae.getActionCommand().equals("Reception")) {
			new Reception();
		}
	}

	public static void main(String[] args) {
		new dashboard();
	}

}
