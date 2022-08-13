import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class AddDriver extends JFrame implements ActionListener{
	JTextField tfname,tfage,tfCar_company,tfCar_model,tflocation;
	JRadioButton rbfemale,rbmale;
	JComboBox cbavail;
	JButton addDriver,cancel;
	AddDriver() {
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel heading = new JLabel("Add Drivers");
		heading.setFont(new Font("Tahoma",Font.BOLD,15));
		heading.setBounds(110,15,100,20);
		add(heading);
		
		JLabel name = new JLabel("Name");
		name.setBounds(50,50,100,20);
		add(name);
		
		tfname = new JTextField();
		tfname.setBounds(160,50,100,20);
		add(tfname);
		
		JLabel age = new JLabel("Age");
		age.setBounds(50,80,100,20);
		add(age);
		
		tfage = new JTextField();
		tfage.setBounds(160,80,100,20);
		add(tfage);
		
		JLabel gender = new JLabel("Gender");
		gender.setBounds(50,110,50,20);
		add(gender);
		
		rbmale = new JRadioButton("Male");
		rbmale.setBackground(Color.white);
		rbmale.setBounds(160,110,70,20);
		add(rbmale);
		
		rbfemale = new JRadioButton("Female");
		rbfemale.setBackground(Color.white);
		rbfemale.setBounds(210,110,70,20);
		add(rbfemale);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbmale);
		bg.add(rbfemale);
		
		JLabel Car_company = new JLabel("Car Company");
		Car_company.setBounds(50,140,100,20);
		add(Car_company);
		
		tfCar_company = new JTextField();
		tfCar_company.setBounds(150,140,100,20);
		add(tfCar_company);
		
		JLabel Car_model = new JLabel("Car Model");
		Car_model.setBounds(50,170,100,20);
		add(Car_model);
		
		tfCar_model = new JTextField();
		tfCar_model.setBounds(150,170,100,20);
		add(tfCar_model);
		
		JLabel available = new JLabel("Available");
		available.setBounds(50,200,100,20);
		add(available);
		
		String avail [] = {"Available","Occupied"};
		cbavail = new JComboBox(avail);
		cbavail.setBounds(150,200,100,20);
		cbavail.setBackground(Color.white);
		add(cbavail);
		
		JLabel location = new JLabel("Location");
		location.setBounds(50,230,100,20);
		add(location);
		
		tflocation = new JTextField();
		tflocation.setBounds(150,230,100,20);
		add(tflocation);
		
		addDriver = new JButton(" Add Driver ");
		addDriver.setBounds(50,270,100,20);
		addDriver.setBackground(Color.black);
		addDriver.setForeground(Color.white);
		addDriver.setFont(new Font("serif",Font.PLAIN,12));
		addDriver.addActionListener(this);
		add(addDriver);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(180,270,100,20);
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		cancel.setFont(new Font("serif",Font.PLAIN,15));
		cancel.addActionListener(this);
		add(cancel);
		

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
		Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(300,30,550,280);
		add(image);
		
		setBounds(280,150,900,400);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == addDriver) {
			
			String name = tfname.getText();
			String age = tfage.getText();
			String Car_company = tfCar_company.getText();
			String Car_model = tfCar_model.getText();
			String location = tflocation.getText();
			String gender = null;
			
			if(rbmale.isSelected()) {
				gender = "Male";
			}else if(rbfemale.isSelected()) {
				gender = "Female";
			}
			String availability = (String) cbavail.getSelectedItem();
			
			try {
				conn c = new conn();
				String query = "insert into drivers values('"+name+"','"+age+"','"+gender+"','"+Car_company+"','"+Car_model+"','"+availability+"','"+location+"')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Driver Added Succesfully");
				setVisible(false);
			}catch(Exception e) {
				e.printStackTrace();
			}

		}else {
			setVisible(false);
		}
}

	public static void main(String[] args) {
		new AddDriver();

	}

}
