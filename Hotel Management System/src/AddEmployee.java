import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener {
	
	JTextField tfname,tfage,tfsalary,tfphone,tfemail,tfaadhar;
	JRadioButton rbfemale,rbmale;
	JComboBox cbjob;
	JButton submit;
	
	AddEmployee(){
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel name = new JLabel("NAME");
		name.setBounds(40,30,100,20);
		add(name);
		
		tfname = new JTextField();
		tfname.setBounds(150,30,100,20);
		add(tfname);
		
		JLabel age = new JLabel("AGE");
		age.setBounds(40,80,100,20);
		add(age);
		
		tfage = new JTextField();
		tfage.setBounds(150,80,100,20);
		add(tfage);
		
		JLabel gender = new JLabel("GENDER");
		gender.setBounds(40,130,50,20);
		add(gender);
		
		rbmale = new JRadioButton("Male");
		rbmale.setBackground(Color.white);
		rbmale.setBounds(150,130,70,20);
		add(rbmale);
		
		rbfemale = new JRadioButton("Female");
		rbfemale.setBackground(Color.white);
		rbfemale.setBounds(200,130,70,20);
		add(rbfemale);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbmale);
		bg.add(rbfemale);
		
		JLabel job = new JLabel("JOB");
		job.setBounds(40,180,100,20);
		add(job);
		
		String str [] = {"Front Desk Clerks","HouseKeeping","Waiter/Waitress","Chef","Kitchen Staff","Room Service","Manager"};
		cbjob = new JComboBox(str);
		cbjob.setBounds(150,180,100,20);
		cbjob.setBackground(Color.white);
		add(cbjob);
		
		JLabel salary = new JLabel("SALARY");
		salary.setBounds(40,230,100,20);
		add(salary);
		
		tfsalary = new JTextField();
		tfsalary.setBounds(150,230,100,20);
		add(tfsalary);
		
		JLabel phone = new JLabel("PHONE NO");
		phone.setBounds(40,280,100,20);
		add(phone);
		

		tfphone = new JTextField();
		tfphone.setBounds(150,280,100,20);
		add(tfphone);
		
		JLabel email = new JLabel("E-MAIL");
		email.setBounds(40,330,100,20);
		add(email);
		
		tfemail = new JTextField();
		tfemail.setBounds(150,330,100,20);
		add(tfemail);
		
		JLabel aadhar = new JLabel("AADHAR NO.");
		aadhar.setBounds(40,380,100,20);
		add(aadhar);
		
		tfaadhar = new JTextField();
		tfaadhar.setBounds(150,380,100,20);
		add(tfaadhar);
		
		submit = new JButton(" Submit ");
		submit.setBounds(100,440,100,25);
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		submit.setFont(new Font("serif",Font.PLAIN,15));
		submit.addActionListener(this);
		add(submit);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
		Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(350,100,450,300);
		add(image);
		
		setBounds(260,150,850,540);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		String name = tfname.getText();
		String age = tfage.getText();
		String salary = tfsalary.getText();
		String phone = tfphone.getText();
		String email = tfemail.getText();
		String aadhar = tfaadhar.getText();
		String gender = null;
		
		if(rbmale.isSelected()) {
			gender = "Male";
		}else if(rbfemale.isSelected()) {
			gender = "Female";
		}
		
		String job = (String) cbjob.getSelectedItem();
		
		try {
			conn c = new conn();
			
			String query = "insert into employeedetails values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";
			c.s.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Employee added successfully");
			setVisible(false);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new AddEmployee();

	}

}
