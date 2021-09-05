package de.bjoern;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class GUI implements ActionListener {
	
	//globals
	
	JFrame mainFrame;
	JPanel panel;
	JLabel label;
	JButton checker;
	JOptionPane pane;
	
	
	
	public GUI() {
		
		
		mainFrame = new JFrame();
		panel = new JPanel();
		label = new JLabel("a", SwingConstants.CENTER);
		checker = new JButton("Systemcheck");
		
		pane = new JOptionPane("test");
		
		
		checker.addActionListener(this);
		
		
		
		label.setText("Willkommen beim Tetris Installer");
		
		
		panel.setBorder(new EmptyBorder(20, 20, 20 ,20));
		panel.setLayout(new GridLayout(0, 1));
		//adds
		panel.add(label);
		panel.add(checker);
		//----
		
		mainFrame.add(panel, BorderLayout.CENTER);
		mainFrame.setPreferredSize(new Dimension(800, 500));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setTitle("Tetris Installer");
		mainFrame.pack();
		mainFrame.setVisible(true);
		
		
	}

	public static void main(String[] args) {
		
		
		new GUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println("check started...");
		
		
		
	}

}
