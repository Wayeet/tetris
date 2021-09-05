package de.bjoern;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class GUI {
	
	//globals
	
	JFrame mainFrame;
	JPanel panel;
	JLabel label;
	
	
	
	public GUI() {
		
		
		mainFrame = new JFrame();
		panel = new JPanel();
		label = new JLabel("a", SwingConstants.CENTER);
		
		
		
		label.setText("Hallo");
		
		
		panel.setBorder(new EmptyBorder(20, 20, 20 , 20));
		panel.setLayout(new GridLayout(0, 1));
		//adds
		panel.add(label);
		//----
		
		mainFrame.add(panel, BorderLayout.CENTER);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setTitle("Our GUI");
		mainFrame.pack();
		mainFrame.setVisible(true);
		
		
	}

	public static void main(String[] args) {
		
		
		new GUI();
	}

}
