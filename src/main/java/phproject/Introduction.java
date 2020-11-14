package phproject;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Introduction implements ActionListener { 
	
	int count=0;
	private JLabel label;
	private JFrame frame;
	private JButton loginButton;
	private JButton signupButton;
	private JPanel panel;
	
	public Introduction() {
		
		frame = new JFrame();
		
		loginButton = new JButton("Login");
		loginButton.addActionListener(this);
		
		signupButton = new JButton("Sign Up");
		signupButton.addActionListener(this);
		
		
		
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		panel.setLayout(new GridLayout(0, 1));
		panel.add(signupButton);
		panel.add(loginButton);
		
		frame.add(panel,BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.pack();
	    frame.setVisible(true);
	    
	}

	public static void main(String[] args) {
		new Introduction();
			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loginButton) {
			Login.main(null);
		} else {
			SignUp.main(null);
		}
			
		
	}

}
