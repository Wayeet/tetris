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
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Welches Betriebssystem nutzen Sie?");
		lblNewLabel_2.setBounds(0, 5, 414, 14);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_2);
		
		JButton btnNewButton_windows = new JButton("Windows");
		btnNewButton_windows.setBounds(0, 23, 120, 23);
		panel_2.add(btnNewButton_windows);
		
		JButton btnNewButton_macos = new JButton("MacOS X (Intel)");
		btnNewButton_macos.setBounds(275, 23, 139, 23);
		panel_2.add(btnNewButton_macos);
		
		JButton btnNewButton_linux = new JButton("AnyLINUX");
		btnNewButton_linux.setBounds(130, 23, 135, 23);
		panel_2.add(btnNewButton_linux);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(20, 59, 389, 191);
		frmTetrisInstaller.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		
		
		panel_2.setVisible(false);
		
		
		
		
		
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
			String nope = "<html>Sie haben Python nicht installiert. <br />Welches Betriebssystem nutzen Sie?</html>";

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(isPythonInstalled() == "yes") {
					lblNewLabel_1.setText(successfull_python);
					panel_1.remove(btnNewButton);
				}else {
					lblNewLabel_1.setText(nope);
					
					
					panel_2.setVisible(true);
					btnNewButton.setVisible(false);
					
					

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
		
		btnNewButton_windows.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				lblNewLabel_1.setText("Der Installer wurde für Sie geladen");
				
				
				try {
					java.awt.Desktop.getDesktop().browse(new URI("https://www.python.org/ftp/python/3.9.7/python-3.9.7-amd64.exe"));
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				}
				
			}
			
		});
		
		
		btnNewButton_linux.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				lblNewLabel_1.setText("<html>Python ist auf LINUX vorinstalliert. Gehen Sie sicher, dass dies auch für Sie zutrifft</html>");
				

				
			}
			
		});
		btnNewButton_macos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				lblNewLabel_1.setText("Der Installer wurde für Sie geladen");
				
				
				try {
					java.awt.Desktop.getDesktop().browse(new URI("https://www.python.org/ftp/python/3.9.7/python-3.9.7-macosx10.9.pkg"));
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				}
				
			}
			
		});
		
		
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				
			}
			
		});
	}
}
