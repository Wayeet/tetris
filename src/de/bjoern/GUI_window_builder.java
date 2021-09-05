package de.bjoern;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.Color;


public class GUI_window_builder {

	private JFrame frmTetrisInstaller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_window_builder window = new GUI_window_builder();
					window.frmTetrisInstaller.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI_window_builder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTetrisInstaller = new JFrame();
		frmTetrisInstaller.setBackground(Color.LIGHT_GRAY);
		frmTetrisInstaller.setTitle("Tetris Installer");
		frmTetrisInstaller.setBounds(100, 100, 450, 300);
		frmTetrisInstaller.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		frmTetrisInstaller.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Willkommen beim Tetris Installer");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Systemcheck");
		frmTetrisInstaller.getContentPane().add(btnNewButton, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		frmTetrisInstaller.getContentPane().add(lblNewLabel_1, BorderLayout.CENTER);
		
		
		
		btnNewButton.addActionListener(new ActionListener() {

			
			public String isPythonInstalled() {
			    try {
			            Process process = Runtime.getRuntime().exec("python.exe");
			            return "yes";
			    } catch (Exception e) {
			            return "nope";
			    }
			}
			

			
			
			
			String successfull_python = "<html>Sie haben Python bereits installiert. <br /> Gehen Sie sicher, dass es sich um Python 3 handelt</html>";
			String nope = "<html>Sie haben Python nicht installiert. <br />Klicken Sie jetzt auf installieren, um dies zu tun.</html>";
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (isPythonInstalled() == "yes") {
					lblNewLabel_1.setText(successfull_python);
				} else {
					lblNewLabel_1.setText(nope);
					lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				}
				
			}
			
		});
	}

}
