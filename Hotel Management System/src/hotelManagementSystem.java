import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class hotelManagementSystem extends JFrame implements ActionListener{
	
	hotelManagementSystem() {
//		setSize(1366,565);
//		setLocation(0,100);
		setBounds(0,100,1366,565);
		setLayout(null);
		
		ImageIcon I1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
		JLabel image = new JLabel(I1);
		image.setBounds(0,0,1366,565);
		add(image);
		
		JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
		text.setBounds(35,450,800,40);
		text.setForeground(Color.green);
		text.setFont(new Font("serif",Font.PLAIN,50));
		image.add(text);
		
		JButton next = new JButton(" Next ");
		next.setBounds(1150,450,100,40);
		next.setBackground(Color.white);
		next.setForeground(Color.red);
		next.addActionListener(this);
		next.setFont(new Font("serif",Font.PLAIN,20));
		image.add(next);
		
		setVisible(true);
		
		while(true) {
			text.setVisible(false);
			try {
				Thread.sleep(100);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			text.setVisible(true);
			try {
				Thread.sleep(100);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public void actionPerformed (ActionEvent ae ) {
		setVisible(false);
		new Login();
	}

	public static void main(String[] args) {
		new hotelManagementSystem();

	}

}
