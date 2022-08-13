import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Reception extends JFrame implements ActionListener{
	Reception() {
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JButton new_customer = new JButton("New Customer Form");
		new_customer.setBackground(Color.black);
		new_customer.setForeground(Color.white);
		new_customer.setBounds(40,20,200,20);
		new_customer.addActionListener(this);
		add(new_customer);
		
		JButton rooms = new JButton("Rooms");
		rooms.setBackground(Color.black);
		rooms.setForeground(Color.white);
		rooms.setBounds(40,55,200,20);
		rooms.addActionListener(this);
		add(rooms);
		
		JButton department = new JButton("Department");
		department.setBackground(Color.black);
		department.setForeground(Color.white);
		department.setBounds(40,90,200,20);
		department.addActionListener(this);
		add(department);
		
		JButton all_employee = new JButton("All Employee");
		all_employee.setBackground(Color.black);
		all_employee.setForeground(Color.white);
		all_employee.setBounds(40,125,200,20);
		all_employee.addActionListener(this);
		add(all_employee);
		
		JButton customer_info = new JButton("Customer Info");
		customer_info.setBackground(Color.black);
		customer_info.setForeground(Color.white);
		customer_info.setBounds(40,160,200,20);
		customer_info.addActionListener(this);
		add(customer_info);
		
		JButton manager_info = new JButton("Manager Info");
		manager_info.setBackground(Color.black);
		manager_info.setForeground(Color.white);
		manager_info.setBounds(40,195,200,20);
		manager_info.addActionListener(this);
		add(manager_info);
		
		JButton checkout = new JButton("Checkout");
		checkout.setBackground(Color.black);
		checkout.setForeground(Color.white);
		checkout.setBounds(40,230,200,20);
		checkout.addActionListener(this);
		add(checkout);
		
		JButton update_status = new JButton("Update Status");
		update_status.setBackground(Color.black);
		update_status.setForeground(Color.white);
		update_status.setBounds(40,265,200,20);
		update_status.addActionListener(this);
		add(update_status);
		
		JButton update_room_status = new JButton("Update Room Status");
		update_room_status.setBackground(Color.black);
		update_room_status.setForeground(Color.white);
		update_room_status.setBounds(40,300,200,20);
		update_room_status.addActionListener(this);
		add(update_room_status);
		
		JButton pickup_service = new JButton("Pickup Service");
		pickup_service.setBackground(Color.black);
		pickup_service.setForeground(Color.white);
		pickup_service.setBounds(40,335,200,20);
		pickup_service.addActionListener(this);
		add(pickup_service);
		
		JButton search_room = new JButton("Search Room");
		search_room.setBackground(Color.black);
		search_room.setForeground(Color.white);
		search_room.setBounds(40,370,200,20);
		search_room.addActionListener(this);
		add(search_room);
		
		JButton logout = new JButton("Logout");
		logout.setBackground(Color.black);
		logout.setForeground(Color.white);
		logout.setBounds(40,405,200,20);
		logout.addActionListener(this);
		add(logout);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
//		Image i2 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
//		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i1);
		image.setBounds(250,20,650,400);
		add(image);
		
		setBounds(270,150,900,500);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if((ae.getActionCommand().equals("New Customer Form"))){
			setVisible(false);
			new AddCustomer();
		}else if((ae.getActionCommand().equals("Rooms"))){
			setVisible(false);
			new Room();
		}else if ((ae.getActionCommand().equals("Department"))){
			setVisible(false);
			new Department();
		}else if ((ae.getActionCommand().equals("All Employee"))){
			setVisible(false);
			new EmployeeInfo();
		}else if((ae.getActionCommand().equals("Manager Info"))){
			setVisible(false);
			new ManagerInfo();
		}else if((ae.getActionCommand().equals("Customer Info"))){
			setVisible(false);
			new CustomerInfo();
		}else if((ae.getActionCommand().equals("Search Room"))){
			setVisible(false);
			new SearchRoom();
		}else if((ae.getActionCommand().equals("Update Status"))){
			setVisible(false);
			new CheckoutUpdate();
		}else if((ae.getActionCommand().equals("Update Room Status"))){
			setVisible(false);
			new UpdateRoom();
		}else if((ae.getActionCommand().equals("Pickup Service"))){
			setVisible(false);
			new Pickup();
		}else if((ae.getActionCommand().equals("Checkout"))){
			setVisible(false);
			new Checkout();
		}else if((ae.getActionCommand().equals("Logout"))){
			setVisible(false);
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new Reception();

	}

}
