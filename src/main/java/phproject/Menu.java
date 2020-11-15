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

public class Menu implements ActionListener {
	
	private JLabel label;
	private JFrame frame;
	private JButton option1;
	private JButton option2;
	private JButton option3;
	private JButton option4;
	private JButton option5;
	private JButton option6;
	private JPanel panel;
	private JLabel option;
	
	public Menu() {
		
		frame = new JFrame();
		
		option1 = new JButton("Option 1");
		option1.addActionListener(this);
		
		option2 = new JButton("Option 2");
		option2.addActionListener(this);
		
		option3 = new JButton("Option 3");
		option3.addActionListener(this);
		
		option4 = new JButton("Option 4");
		option4.addActionListener(this);
		
		option5 = new JButton("Option 5");
		option5.addActionListener(this);
		
		option6 = new JButton("Option 6");
		option6.addActionListener(this);
		
		
		
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		panel.setLayout(new GridLayout(0, 1));
		panel.add(option1);
		panel.add(option2);
		panel.add(option3);
		panel.add(option4);
		panel.add(option5);
		panel.add(option6);
		
		frame.add(panel,BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.pack();
	    
	    option = new JLabel("");
		option.setBounds(10, 110, 300, 25);
		panel.add(option);
		
	    frame.setVisible(true);
	    
	}

	public static void main(String[] args) {
		new Menu();
			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == option1) {
			option.setText("U chose 1");
		} else if (e.getSource() == option2) {
			option.setText("U chose 2");
		} else if (e.getSource() == option3) {
			option.setText("U chose 3");
		} else if (e.getSource() == option4) {
			option.setText("U chose 4");
		} else if (e.getSource() == option5) {
			option.setText("U chose 5");
		} else {
			Popup popup = new Popup("u chose 6");
		}

}

}
