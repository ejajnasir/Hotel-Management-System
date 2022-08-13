import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
	
	JTextField username;
	JPasswordField password;
	JButton login,cancel;
	
	Login() {
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel user = new JLabel("Username");
		user.setBounds(30,40,100,20);
		add(user);
		
		username = new JTextField();
		username.setBounds(140,40,100,20);
		add(username);
		
		JLabel pass = new JLabel("Password");
		pass.setBounds(30,90,100,20);
		add(pass);
		
		password = new JPasswordField();
		password.setBounds(140,90,100,20);
		add(password);
		
		login = new JButton(" Login ");
		login.setBounds(30,140,100,20);
		login.setBackground(Color.black);
		login.setForeground(Color.white);
		login.setFont(new Font("serif",Font.PLAIN,10));
		login.addActionListener(this);
		add(login);
		
		cancel = new JButton(" Cancel");
		cancel.setBounds(140,140,100,20);
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		cancel.setFont(new Font("serif",Font.PLAIN,10));
		cancel.addActionListener(this);
		add(cancel);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(350,15,200,200);
		add(image);
		
		
		setBounds(500,200,600,300);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		conn c = new conn();
		if(ae.getSource() == login) {
			
			String user = username.getText();
			String pass = password.getText();
			
			try {
				String query = "select * from login where username = '" + user + "' and password = '"+ pass + "' ";
				ResultSet rs = c.s.executeQuery(query);
				if(rs.next()) {
					setVisible(false);
					new dashboard();
				}else {
					JOptionPane.showMessageDialog(null, "Invalid username or password");
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
;			
		}else if(ae.getSource() == cancel) {
			setVisible(false);
		}
	}

	public static void main(String[] args) {
		new Login();
	}

}
