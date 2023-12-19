import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage implements ActionListener{
	HashMap<String, String> loginInfo = new HashMap<String, String>();
	
	JFrame frame1= new JFrame();
	
	JButton login = new JButton("Login");
	JButton reset = new JButton("Reset");
	
	JTextField userID = new JTextField();
	
	JPasswordField password = new JPasswordField();
	
	ImageIcon bee = new ImageIcon(this.getClass().getResource("bee-removebg-preview.png"));
	ImageIcon loginLogo = new ImageIcon(this.getClass().getResource("icon2.png"));
	
	JLabel idLabel = new JLabel("User ID:");
	JLabel passLabel = new JLabel("Password:");
	JLabel messageLabel = new JLabel("Hey Bee!!");
	JLabel loginStatus = new JLabel("");
	JLabel background = new JLabel(bee);
	
	
	
	
	
	
	LoginPage(HashMap<String, String> loginInfoOriginal) {
		loginInfo = loginInfoOriginal;
		
		idLabel.setBounds(50, 50, 75, 25);
		passLabel.setBounds(35, 100, 75, 25);
		messageLabel.setBounds(150, 25, 200, 25);
		
		userID.setBounds(100, 50, 150, 25);
		password.setBounds(100, 100, 150, 25);
		
		login.setBounds(135, 135, 75, 25);
		login.addActionListener(this);
		login.setFocusable(false);
		
		reset.setBounds(135, 175, 75, 25);
		reset.addActionListener(this);
		reset.setFocusable(false);
		
		background.setBounds(50, 175, 400, 300);
		
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setBackground(Color.GRAY);
		frame1.add(background);
		frame1.add(messageLabel);
		frame1.add(userID);
		frame1.add(password);
		frame1.add(idLabel);
		frame1.add(passLabel);
		frame1.add(login);
		frame1.add(reset);
		frame1.add(loginStatus);
		frame1.setIconImage(loginLogo.getImage());
		frame1.setSize(500, 500);
		frame1.setLayout(null);
		frame1.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == login) {
			String username = userID.getText();
			String userPassword = String.valueOf(password.getPassword());
			
			if(loginInfo.containsKey(username)) {
				if(loginInfo.get(username).equals(userPassword)) {
					frame1.dispose();
					Ui planner = new Ui();
				} else {
					loginStatus.setBounds(300, 100, 150, 25);
					loginStatus.setForeground(Color.RED);
					loginStatus.setText("Incorrect password");
				}
			} else {
				loginStatus.setBounds(300, 50, 150, 25);
				loginStatus.setForeground(Color.RED);
				loginStatus.setText("Username not found");
			}
		} else if(e.getSource() == reset) {
			userID.setText("");
			password.setText("");
		}
	}

}
