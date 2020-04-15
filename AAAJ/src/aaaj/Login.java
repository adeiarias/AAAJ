package aaaj;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;

public class Login extends JFrame {
	
	public static String loginID = null;
	
	private JPanel panel;
	private JButton btnOK;
	private JButton btnCancel;
	private JPanel panel_1;
	private JLabel lblIzena;
	private JTextField textField;
	private JLabel lblPasahitza;
	private JPasswordField passwordField;
	private JPanel panel_2;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param konexioa 
	 */
	public Login() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("res/aj.png"));
		initialize();
		setLocationRelativeTo(null);
		setFocusable(true);
		requestFocusInWindow();
		addKeyListener(new KeyListener(){
            @Override
               public void keyPressed(KeyEvent e) {
            	if(e.getKeyCode() == KeyEvent.VK_ENTER){
                   saiatuLogin();
               }
               }

               @Override
               public void keyTyped(KeyEvent e) {
            	   //
               }

               @Override
               public void keyReleased(KeyEvent e) {
            	   //
               }
       });
	}
	

	private void initialize() {
		setTitle("AAAJ");
		setBounds(100, 100, 800, 600);
		getContentPane().add(getPanel(), BorderLayout.SOUTH);
		getContentPane().add(getPanel_1(), BorderLayout.CENTER);
		getContentPane().add(getPanel_2(), BorderLayout.NORTH);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getBtnOK());
			panel.add(getBtnCancel());
		}
		return panel;
	}
	
	private JButton getBtnOK() {
		if (btnOK == null) {
			btnOK = new JButton("OK");
			btnOK.addActionListener(new BtnOKActionListener());
		}
		return btnOK;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Garbitu");
			btnCancel.addActionListener(new BtnCancelActionListener());
		}
		return btnCancel;
	}
	
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBorder(new EmptyBorder(0, 45, 0, 45));
			GridBagLayout gbl_panel_1 = new GridBagLayout();
			gbl_panel_1.columnWidths = new int[] {30, 200};
			gbl_panel_1.rowHeights = new int[] {30, 30};
			gbl_panel_1.columnWeights = new double[]{0.0, 1.0};
			gbl_panel_1.rowWeights = new double[]{0.0, 0.0};
			panel_1.setLayout(gbl_panel_1);
			GridBagConstraints gbc_lblIzena = new GridBagConstraints();
			gbc_lblIzena.anchor = GridBagConstraints.EAST;
			gbc_lblIzena.insets = new Insets(0, 0, 5, 5);
			gbc_lblIzena.gridx = 0;
			gbc_lblIzena.gridy = 0;
			panel_1.add(getLblIzena(), gbc_lblIzena);
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 5, 0);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 1;
			gbc_textField.gridy = 0;
			panel_1.add(getTextField(), gbc_textField);
			GridBagConstraints gbc_lblPasahitza = new GridBagConstraints();
			gbc_lblPasahitza.anchor = GridBagConstraints.EAST;
			gbc_lblPasahitza.insets = new Insets(0, 0, 0, 5);
			gbc_lblPasahitza.gridx = 0;
			gbc_lblPasahitza.gridy = 1;
			panel_1.add(getLblPasahitza(), gbc_lblPasahitza);
			GridBagConstraints gbc_passwordField = new GridBagConstraints();
			gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
			gbc_passwordField.gridx = 1;
			gbc_passwordField.gridy = 1;
			panel_1.add(getPasswordField(), gbc_passwordField);
			
		}
		return panel_1;
	}
	private JLabel getLblIzena() {
		if (lblIzena == null) {
			lblIzena = new JLabel("Izena");
		}
		return lblIzena;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_ENTER){
			               saiatuLogin();
			           }
				}
			});
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLblPasahitza() {
		if (lblPasahitza == null) {
			lblPasahitza = new JLabel("Pasahitza");
		}
		return lblPasahitza;
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_ENTER){
			               saiatuLogin();
			           }
				}
			});
		}
		return passwordField;
	}
	
	private class BtnOKActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			saiatuLogin();
		}
	}
	private class BtnCancelActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			getPasswordField().setText("");
			getTextField().setText("");
		}
	}

	
	public void saiatuLogin() {
		try {
			Connection konexioa= DriverManager.getConnection(Nagusia.zerbitzaria, Nagusia.erabiltzailea, Nagusia.pasahitza);
			Statement stm = konexioa.createStatement();
			String loginerab = getTextField().getText();
			String query="select password from erabiltzaile where user='" + loginerab +"';";
			ResultSet rs = stm.executeQuery(query);
			String loginpasahitza="";
			if (rs.next()) {
				loginpasahitza=rs.getString(1);
			}
			
			if(getPasswordField().getText().contentEquals(loginpasahitza) && !loginpasahitza.equals("")) { // PASAHITZA ONDO SARTUTA		
								
				query="select erabkodea from erabiltzaile where user='" + loginerab +"';";
				rs = stm.executeQuery(query);
				if (rs.next()) {
					loginID=rs.getString(1);
				}
				
				query="select * from bezero where bkode='" + loginID + "';";
				rs = stm.executeQuery(query);
				if (rs.next()) { // BEZEROA BADA
					Bezero bezeroF=new Bezero();
					bezeroF.setVisible(true);
					setVisible(false);
				}
				else {
					query="select * from garraiatzaile where gkode='" + loginID + "';";
					rs = stm.executeQuery(query);
					if (rs.next()) { // GARRAIATZAILEA BADA
						Garraiatzaile garrF=new Garraiatzaile();
						garrF.setVisible(true);
						setVisible(false);
					}
					else {// ADMIN BADA
						Admin adminF = new Admin();
						adminF.setVisible(true);
						setVisible(false);
					}
				}
				
				
			}else {
				JOptionPane.showMessageDialog(null, "Pasahitz okerra!");
				getPasswordField().setText("");
				getPasswordField().requestFocus();
			}
		
		} catch (SQLException e1) {
			Login loginLogout = new Login();
			loginLogout.setVisible(true);
			setVisible(false);}	
	}
	
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.add(getLblNewLabel());
		}
		return panel_2;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel(new ImageIcon("res/aj1.png"));
		}
		return lblNewLabel;
	}
	
}
