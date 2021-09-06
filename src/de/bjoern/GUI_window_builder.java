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
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;


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
		frmTetrisInstaller.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 46);
		frmTetrisInstaller.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tetris Installer");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 0, 394, 56);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 128, 414, 122);
		frmTetrisInstaller.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Systemcheck");
		btnNewButton.setBounds(20, 52, 118, 23);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(161, 11, 243, 100);
		panel_1.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("weiter");
		btnNewButton_1.setBounds(20, 52, 118, 23);
		panel_1.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 69, 414, 46);
		frmTetrisInstaller.getContentPane().add(panel_2);
		
		JLabel lblNewLabel_2 = new JLabel("Welches Betriebssystem nutzen Sie?");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_2);
		
		
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			
			
			//functions
			public String isPythonInstalled() {
			    try {
			            Process process = Runtime.getRuntime().exec("python2.exe");
			            return "yes";
			    } catch (Exception e) {
			            return "nope";
			    }
			}
			

			
			
			
			String successfull_python = "<html>Sie haben Python bereits installiert. <br /> Gehen Sie sicher, dass es sich um Python 3 handelt</html>";
			String nope = "<html>Sie haben Python nicht installiert. <br />Der Installer wird für Sie heruntergeladen.</html>";

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(isPythonInstalled() == "yes") {
					lblNewLabel_1.setText(successfull_python);
					panel_1.remove(btnNewButton);
				}else {
					lblNewLabel_1.setText(nope);
					
					
					
					
					
					try {
						java.awt.Desktop.getDesktop().browse(new URI("https://www.python.org/ftp/python/3.9.7/python-3.9.7-amd64.exe"));
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (URISyntaxException e1) {
						e1.printStackTrace();
					}
				}
				
			}
			
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {

			//functions to check for pygame
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("yeseys");
				
			}
			});
	}
}
