package phproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUp implements ActionListener {
	
	private static JLabel userLabel;
	private static JTextField userText;
	private static JPasswordField passwordText;
	private static JPasswordField password2Text;
	private static JLabel passwordLabel;
	private static JLabel password2Label;
	private static JButton button;
	private static JLabel success;

	public static void main(String[] args) {
		JPanel panel = new JPanel();
		JFrame frame = new JFrame ();
		frame.setSize(500, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		panel.setLayout(null);
		
		userLabel = new JLabel("Create Username");
		userLabel.setBounds(10, 20, 200, 25);
		panel.add(userLabel);
		
		userText = new JTextField(20);
		userText.setBounds(200, 20, 165, 25);
		panel.add(userText);
		
		passwordLabel = new JLabel("Create Password");
		passwordLabel.setBounds(10, 50, 200, 25);
		panel.add(passwordLabel);
		
		passwordText = new JPasswordField(20);
		passwordText.setBounds(200, 50, 165, 25);
		panel.add(passwordText);
		
		password2Label = new JLabel("Confirm Password");
		password2Label.setBounds(10, 80, 200, 25);
		panel.add(password2Label);
		
		password2Text = new JPasswordField(20);
		password2Text.setBounds(200, 80, 165, 25);
		panel.add(password2Text);
		
		button = new JButton("Sign Up");
		button.setBounds(10 , 110, 80, 25);
		button.addActionListener(new SignUp());
		panel.add(button);
		
		success = new JLabel("");
		success.setBounds(10, 140, 500, 25);
		panel.add(success);
		
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String user = userText.getText();
		String password = passwordText.getText();
		String password2 = password2Text.getText();
		
		if (password.equals(password2)) {
			success.setText("Sign Up Successful");
		} else {
			success.setText("Sign Up Unsuccessful: Passwords do not match.");
		}
		

		
	}

}


