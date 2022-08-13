import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class Pickup extends JFrame implements ActionListener{
	JTable table;
	JButton submit,back;
	Choice typeOfCar;
	JLabel age;
	JCheckBox checkbox;
	Pickup(){
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel text = new JLabel("Pickup Service");
		text.setBounds(420,20,200,30);
		text.setFont(new Font("serif",Font.PLAIN,25));
        add(text);
		
        JLabel bedType = new JLabel("Type Of Car");
		bedType.setBounds(60,50,100,20);
		add(bedType);
		
		typeOfCar = new Choice();
		typeOfCar.setBounds(150,50,120,30);
		add(typeOfCar);
		
		try {
			conn c = new conn();
			ResultSet rs = c.s.executeQuery("select * from drivers");
			while(rs.next()) {
				typeOfCar.add(rs.getString("Car_model"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
			
        JLabel name = new JLabel("Name");
        name.setBounds(50,100,100,20);
        add(name);
        
        age = new JLabel("Age");
        age.setBounds(200,100,100,20);
        add(age);
        
        JLabel gender = new JLabel("Gender");
        gender.setBounds(350,100,100,20);
        add(gender);
        
        JLabel car_company = new JLabel("Car Company");
        car_company.setBounds(470,100,100,20);
        add(car_company);
        
        JLabel carModel = new JLabel("Car Model");
        carModel.setBounds(620,100,100,20);
        add(carModel);
        
        JLabel availability = new JLabel("Availability");
        availability.setBounds(740,100,100,20);
        add(availability);
        
        JLabel location = new JLabel("Location");
        location.setBounds(900,100,100,20);
        add(location);
        
		table = new JTable();
		table.setBounds(0,120,1000,200);
		add(table);
		try {
			conn c = new conn();
			ResultSet rs = c.s.executeQuery("select * from drivers");
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
				String query = "select * from drivers where Car_model = '"+typeOfCar.getSelectedItem()+"' ";
				conn c = new conn();
				ResultSet rs = c.s.executeQuery(query);
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
		new Pickup();

	}

}

