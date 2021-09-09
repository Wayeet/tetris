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
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;



import javax.swing.JProgressBar;
import java.awt.Canvas;


public class GUI_window_builder {
	
	public String getOperatingSystem() {
	    String os = System.getProperty("os.name");
	    // System.out.println("Using System Property: " + os);
	    return os;
	}
	
	public static String execCmd(String cmd) {
	    String result = null;
	    try (InputStream inputStream = Runtime.getRuntime().exec(cmd).getInputStream();
	            Scanner s = new Scanner(inputStream).useDelimiter("\\A")) {
	        result = s.hasNext() ? s.next() : null;
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return result;
	}
	
	public Boolean download_macos() {
		
		try {
			java.awt.Desktop.getDesktop().browse(new URI("https://www.python.org/ftp/python/3.9.7/python-3.9.7-macosx10.9.pkg"));
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}
		
		return true;
		
	}


	
	public Boolean download_win() {
		
		try {
			java.awt.Desktop.getDesktop().browse(new URI("https://www.python.org/ftp/python/3.9.7/python-3.9.7-amd64.exe"));
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}
		
		return true;
		
	}


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
		
		JButton btn_pip_installed = new JButton("Installieren");
		btn_pip_installed.setBounds(20, 52, 118, 23);
		panel_1.add(btn_pip_installed);
		
		JButton btn_exit = new JButton("Beenden");
		btn_exit.setBounds(20, 52, 118, 23);
		panel_1.add(btn_exit);
		
		
		
		
		
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
			String nope = "<html>Sie haben Python nicht installiert. <br />Der Installer für " + getOperatingSystem() + " wurde für Sie heruntergeladen. Gehen Sie sicher, dass Sie die 'Add to PATH' Option anklicken.</html>";

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(isPythonInstalled() == "yes") {
					lblNewLabel_1.setText(successfull_python);
					panel_1.remove(btnNewButton);
				}else {
					lblNewLabel_1.setText(nope);
					
					btnNewButton.setVisible(false);
					
					
					if (getOperatingSystem().contains("Windows")) {
						download_win();
					} else if(getOperatingSystem().contains("Mac")) {
						download_macos();
					}else if(getOperatingSystem().contains("Linux")) {
						//show linux message
						lblNewLabel_1.setText("<html>Python ist auf LINUX vorinstalliert. Gehen Sie sicher, dass dies auch für Sie zutrifft</html>");
					}else {
						lblNewLabel_1.setText("<html>Dein Betriebssystem konnte nicht festgestellt werden. Bitte lade Python 3 manuell herunter.</html>");
					}
					
					
					

				}
				
			}
			
		});
		

		
		
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {


				
				try {
					
					if (execCmd("pip3").contains("Commands:")) {
						lblNewLabel_1.setText("<html>Pip3 ist auf ihren System installiert.</html>");
						btnNewButton_1.setVisible(false);
					}
				} catch (Exception e2) {
					lblNewLabel_1.setText("<html>Pip3 ist nicht installiert. Führen Sie den Python-Installer neu aus und klicken sie die Option 'Add Python to PATH' an.</html>");
					
				}

				
				
			}
			
		});
		
		
		
		btn_pip_installed.addActionListener(new ActionListener() {

		
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				
				if (execCmd("pip3 install pygame").contains("Successfully")) {
					System.out.println("yes");
					lblNewLabel_1.setText("<html>Sofern Sie im Python-Installer 'Add to PATH' angekilckt haben, ist nun alles bereit.</html>");
					btn_pip_installed.setVisible(false);
				}else if(execCmd("pip3 install pygame").contains("already satisfied")) {
					System.out.println("already yes");
					lblNewLabel_1.setText("<html>Sofern Sie im Python-Installer 'Add to PATH' angekilckt haben, ist nun alles bereit.</html>");
					btn_pip_installed.setVisible(false);
					
				}

				
			}
			
		});
		
		btn_exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
			
		});
		
		
	}
}
