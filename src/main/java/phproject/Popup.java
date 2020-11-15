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

public class Popup { 
	
	
	private JLabel label;
	private JFrame frame;
	private JPanel panel;
	
	public Popup(String popup) {
		
		frame = new JFrame();
		
		
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		panel.setLayout(new GridLayout(0, 1));
		label = new JLabel(popup);
		label.setBounds(10, 110, 300, 25);
		panel.add(label);

		
		
		frame.add(panel,BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.pack();
	    frame.setVisible(true);
	    
	}

	
			
}

