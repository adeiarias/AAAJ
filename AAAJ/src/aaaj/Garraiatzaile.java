package aaaj;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Garraiatzaile extends JFrame {

	private JPanel contentPane;
	private static boolean panel1_0bool=false;
	private static boolean panel1_1bool=false;
	private static boolean panel1_2bool=false;
	private static boolean panel1_3bool=false;
	
	JLabel lblNewLabel_1,lblNewLabel_2,lblNewLabel_3,lblNewLabel_4,lblNewLabel_5,lblNewLabel_6;
	String izena_datuak="";
	String abizena_datuak="";
	String gkode_datuak="";
	String gune_datuak="";
	String tlf_datuak="";
	String nan_datuak="";
	private DefaultTableModel modelo1;
	private DefaultTableModel modelo2;
	private DefaultTableModel modelo3;
	private DefaultTableModel modelo4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Garraiatzaile frame = new Garraiatzaile();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Garraiatzaile() throws SQLException {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("res/aj.png"));
		
		setTitle("GARRAIATZAILE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		setLocationRelativeTo(null);
		
		Connection konexioa= DriverManager.getConnection(Nagusia.zerbitzaria, Nagusia.erabiltzailea, Nagusia.pasahitza);
		Statement stm = konexioa.createStatement();
		
	try {
		//ResultSet rs = stm.executeQuery("select * from garraiatzaile where gkode=" + Login.loginID+";");
		ResultSet rs = stm.executeQuery("select * from garraiatzaile where gkode=2;");
		while (rs.next())
		{
			
			gkode_datuak=rs.getString(1);
			gune_datuak=rs.getString(2);
			izena_datuak=rs.getString(3);
			abizena_datuak=rs.getString(4);
			tlf_datuak=rs.getString(5);
			nan_datuak=rs.getString(6);
		}
		
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			
		
		
		
		JPanel panel1_0 = new JPanel();
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 10, 10));
		
		JButton btnNewButton = new JButton("GUNEKO ESKAERAK IKUSI");
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(false);
				
				
				panel1_0.setVisible(true);
				contentPane.add(panel1_0, BorderLayout.CENTER);
				panel1_0.setLayout(new GridLayout(0, 1, 10, 10));
				
				if (!panel1_0bool) {
				////////////////////////
				try {
				//ResultSet rs = stm.executeQuery("select eskaera.id, bezero.bkode, bezero.dendaizena,bezero.tlf from eskaera join bezero on eskaera.bkode=bezero.bkode where bezero.gune=" + gune_datuak + " AND entregatuta=false;");
				ResultSet rs = stm.executeQuery("select eskaera.id, bezero.bkode, bezero.dendaizena,bezero.tlf from eskaera join bezero on eskaera.bkode=bezero.bkode where bezero.gune=-1 AND entregatuta=false;");
				
				DefaultTableModel modelo0 = new DefaultTableModel();
				JTable tabla0 = new JTable(modelo0);
				// Creamos las columnas.
				modelo0.addColumn("id");
				modelo0.addColumn("bkode");
				modelo0.addColumn("dendaizena");
				modelo0.addColumn("tlf");

				// Bucle para cada resultado en la consulta
				while (rs.next())
				{
				   // Se crea un array que será una de las filas de la tabla.
				   Object [] fila = new Object[4]; // Hay n columnas en la tabla

				   // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
				   for (int i=0;i<4;i++)
				      fila[i] = rs.getObject(i+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.

				   // Se añade al modelo la fila completa.
				   modelo0.addRow(fila);
				}
				
				
				
				JScrollPane js0=new JScrollPane(tabla0);
				
				js0.setVisible(true);
				panel1_0.add(js0);
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				////////////////////////
				}
				panel1_0bool=true;
			}
		});
		panel.add(btnNewButton);
		
		JPanel panel1_1 = new JPanel();
		JPanel panel1_1_1 = new JPanel();
		modelo1 = new DefaultTableModel();
		JTable tabla1 = new JTable(modelo1);
		panel1_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel1_1_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton_1 = new JButton("ESKAERA BAT ENTREGATU");
		btnNewButton_1.setBackground(SystemColor.menu);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(false);
				panel1_1.setVisible(true);
				panel1_1_1.setVisible(true);
				contentPane.add(panel1_1, BorderLayout.CENTER);
				try {
					hasieratu1();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if (!panel1_1bool) {
						
					JScrollPane js1=new JScrollPane(tabla1);
					js1.setViewportBorder(new EmptyBorder(0, 0, -30, 0));
					js1.setVisible(true);
						
					panel1_1_1.setBorder(new EmptyBorder(30, 0, 30, 0));
					panel1_1.add(panel1_1_1);
				
					JLabel lblNewLabel_panel1_1 = new JLabel("Sartu entregatu nahi duzun eskaeraren IDa:   ");
					panel1_1_1.add(lblNewLabel_panel1_1);
				
					JTextField textField_panel1_1 = new JTextField();
					panel1_1_1.add(textField_panel1_1);
					textField_panel1_1.setColumns(10);
		
					JLabel lblNewLabel_panel1_1_1 = new JLabel("   ");
					panel1_1_1.add(lblNewLabel_panel1_1_1);
		
					JButton btnNewButton_panel1_1 = new JButton("ENTREGATU");
					btnNewButton_panel1_1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								try {
									modelo1.setRowCount(0);
								// FILTRAR:
								
									ResultSet rs = stm.executeQuery("select * from produktu WHERE prezioa>5");
									modelo1.setRowCount(0);
									while (rs.next())
									{
										Object [] fila = new Object[4]; // ALDATU ZUTABE KOP.REN ARABERA
										for (int i=0;i<4;i++)// ALDATU ZUTABE KOP.REN ARABERA
											fila[i] = rs.getObject(i+1);
										modelo1.addRow(fila);
									}			
									Object [] fila = new Object[4];
									modelo1.addRow(fila);
									modelo1.addRow(fila);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						});
					panel1_1_1.add(btnNewButton_panel1_1);
					panel1_1.add(js1);
				
					
				}
				panel1_1bool=true;
			}
		});
		panel.add(btnNewButton_1);
		
		JPanel panel1_2 = new JPanel();
		
		JButton btnNewButton_2 = new JButton("ENTREGATUTAKO ESKAERAK");
		btnNewButton_2.setBackground(SystemColor.menu);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(false);
				panel1_2.setVisible(true);
				
				
				if (!panel1_2bool) {
				
				contentPane.add(panel1_2, BorderLayout.CENTER);
				panel1_2.setLayout(new GridLayout(0, 1, 10, 10));
				////////////////////////
				try {
				ResultSet rs = stm.executeQuery("select * from produktu");
				
				DefaultTableModel modelo2 = new DefaultTableModel() {					
					@Override
				    public boolean isCellEditable(int row, int column) {
				       //all cells false
				       return false;
				    }
				};
				
				JTable tabla2 = new JTable(modelo2);
				modelo2.addColumn("id");
				modelo2.addColumn("izena");
				modelo2.addColumn("deskribapena");
				modelo2.addColumn("kantitatea");
				tabla2.getColumnModel().getColumn(0).setMinWidth(40);
				tabla2.getColumnModel().getColumn(0).setMaxWidth(40);
				tabla2.getColumnModel().getColumn(0).setPreferredWidth(40);
				tabla2.getColumnModel().getColumn(3).setMinWidth(40);
				tabla2.getColumnModel().getColumn(3).setMaxWidth(40);
				tabla2.getColumnModel().getColumn(3).setPreferredWidth(40);
				
				while (rs.next())
				{
				   Object [] fila = new Object[4];
				   for (int i=0;i<4;i++)
				      fila[i] = rs.getObject(i+1);
				   modelo2.addRow(fila);
				}
								
				JScrollPane js2=new JScrollPane(tabla2);
				
				js2.setVisible(true);
				panel1_2.add(js2);
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				////////////////////////
				}
				panel1_2bool=true;
			}
		});
		panel.add(btnNewButton_2);

		JPanel panel1_3 = new JPanel();
		JPanel panel1_3_1 = new JPanel();
		
		JButton btnNewButton_3 = new JButton("DATUAK ALDATU");
		btnNewButton_3.setBackground(SystemColor.menu);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(false);
				panel1_3.setVisible(true);
							
			if (!panel1_3bool) {
				panel1_3.setBorder(new EmptyBorder(100, 100, 0, 100));
				contentPane.add(panel1_3, BorderLayout.CENTER);
				panel1_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				
				panel1_3_1.setPreferredSize(new Dimension(300, 600));
				panel1_3.add(panel1_3_1);
				
				
				JLabel lbldatuak_1 = new JLabel("IZENA:");
				panel1_3_1.add(lbldatuak_1);
				
				JTextField textField_1 = new JTextField(izena_datuak);
				textField_1.setColumns(25);
				panel1_3_1.add(textField_1);
				
				JLabel lblesp_1 = new JLabel("");
				lblesp_1.setPreferredSize(new Dimension(300, 10));
				panel1_3_1.add(lblesp_1);
				
				//
				
				JLabel lbldatuak_2 = new JLabel("ABIZENA:");
				panel1_3_1.add(lbldatuak_2);
				
				JTextField textField_2 = new JTextField(abizena_datuak);
				textField_2.setColumns(25);
				panel1_3_1.add(textField_2);
				
				JLabel lblesp_2 = new JLabel("");
				lblesp_2.setPreferredSize(new Dimension(300, 10));
				panel1_3_1.add(lblesp_2);
				
				//
				
				JLabel lbldatuak_3 = new JLabel("TELEFONOA:");
				panel1_3_1.add(lbldatuak_3);
				
				JTextField textField_3 = new JTextField(tlf_datuak);
				textField_3.setColumns(25);
				panel1_3_1.add(textField_3);
				
				JLabel lblesp_3 = new JLabel("");
				lblesp_3.setPreferredSize(new Dimension(300, 10));
				panel1_3_1.add(lblesp_3);
				
				//
				
				JLabel lbldatuak_4 = new JLabel("GUNEA:");
				panel1_3_1.add(lbldatuak_4);
				
				JTextField textField_4 = new JTextField(gune_datuak);
				textField_4.setColumns(25);
				panel1_3_1.add(textField_4);
				
				JLabel lblesp_4 = new JLabel("");
				lblesp_4.setPreferredSize(new Dimension(300, 10));
				panel1_3_1.add(lblesp_4);
				/*
				//
				
				JLabel lbldatuak_5 = new JLabel("New label");
				panel1_3_1.add(lbldatuak_5);
				
				JTextField textField_5 = new JTextField("tf 1");
				textField_5.setColumns(25);
				panel1_3_1.add(textField_5);
				
				JLabel lblesp_5 = new JLabel("");
				lblesp_5.setPreferredSize(new Dimension(300, 10));
				panel1_3_1.add(lblesp_5);
				
				//
				
				JLabel lbldatuak_6 = new JLabel("New label");
				panel1_3_1.add(lbldatuak_6);
				
				JTextField textField_6 = new JTextField("tf 1");
				textField_6.setColumns(25);
				panel1_3_1.add(textField_6);
				*/
				
				
				JButton btnAldatu = new JButton("ALDATU");
				panel1_3_1.add(btnAldatu);
				btnAldatu.addActionListener(new ActionListener() {
					

					public void actionPerformed(ActionEvent arg0) {
						// query. 	UPDATE `bezero` SET `ifz` = '00000001B' WHERE `bezero`.`bkode` = 1; 
						String queryUpdate="";
						
						if (!textField_1.getText().equals(izena_datuak) ){
							tlf_datuak=textField_1.getText();
							lblNewLabel_1.setText(izena_datuak + " " + abizena_datuak);
							queryUpdate = "UPDATE `bezero` SET `izena` = "+ izena_datuak +" WHERE `bezero`.`bkode` = "+gkode_datuak+";";
							
							try {
								stm.executeUpdate(queryUpdate);
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
						
						if (!textField_2.getText().equals(abizena_datuak) ){
							tlf_datuak=textField_2.getText();
							lblNewLabel_1.setText(izena_datuak + " " + abizena_datuak);
							queryUpdate = "UPDATE `bezero` SET `helbide` = "+ abizena_datuak +" WHERE `bezero`.`bkode` = "+gkode_datuak+";";
							
							try {
								stm.executeUpdate(queryUpdate);
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
						
						if (!textField_3.getText().equals(tlf_datuak) ){
							tlf_datuak=textField_3.getText();
							lblNewLabel_5.setText(tlf_datuak);
							queryUpdate = "UPDATE `bezero` SET `tlf` = "+ tlf_datuak +" WHERE `bezero`.`bkode` = "+gkode_datuak+";";
							
							try {
								stm.executeUpdate(queryUpdate);
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
						
						if (!textField_4.getText().equals(gune_datuak) ){
							tlf_datuak=textField_4.getText();
							lblNewLabel_4.setText(gune_datuak);
							queryUpdate = "UPDATE `bezero` SET `gune` = "+ gune_datuak +" WHERE `bezero`.`bkode` = "+gkode_datuak+";";
							
							try {
								stm.executeUpdate(queryUpdate);
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
				});
				panel1_3bool=true;
			}
			}
		});
		panel.add(btnNewButton_3);

		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new GridLayout(0, 1, 10, 0));
		panel_1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5)); 
		
		JLabel lblNewLabel = new JLabel(new ImageIcon("res/avatar1.jpg"));
		panel_1.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
			
		
		
		
		
		// IZEN ABIZENAK
		lblNewLabel_1 = new JLabel(izena_datuak + " " + abizena_datuak);			
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_1);
		
		// GKODEA
		lblNewLabel_2 = new JLabel("GKODE: " + gkode_datuak);		
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_2);
		
		// NAN		
		lblNewLabel_3 = new JLabel("NAN: " + nan_datuak);			
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_3);
		
		// GUNEA
		lblNewLabel_4 = new JLabel("GUNE: " + gune_datuak);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_4);
		
		// TLF
		lblNewLabel_5 = new JLabel(tlf_datuak);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_5);
		
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnNewButton_6 = new JButton(new ImageIcon("res/homesmall.png"));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel1_0.setVisible(false);
				panel1_1.setVisible(false);
				//panel1_2.setVisible(false);
				panel1_3.setVisible(false);
				//panel1_4.setVisible(false);
				panel.setVisible(true);
			}
		});
		panel_2.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton(new ImageIcon("res/logoutsmall.png"));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login.loginID="-1000";
				Login loginLogout = new Login();
				loginLogout.setVisible(true);
				setVisible(false);
			}
		});
		panel_2.add(btnNewButton_7);
		
		
	}
	
	public void hasieratu1() throws SQLException {
		Connection konexioa= DriverManager.getConnection(Nagusia.zerbitzaria, Nagusia.erabiltzailea, Nagusia.pasahitza);
		Statement stm = konexioa.createStatement();
		ResultSet rs = stm.executeQuery("select * from produktu");
		modelo1.setRowCount(0);
		modelo1.setColumnCount(0);
		// ZUTABEAK SORTU
		modelo1.addColumn("ZUTABE1");
		modelo1.addColumn("ZUTABE2");
		modelo1.addColumn("ZUTABE3");
		modelo1.addColumn("ZUTABE4 ETC");
		while (rs.next())
		{
			Object [] fila = new Object[4]; // ALDATU ZUTABE KOP.REN ARABERA
			for (int i=0;i<4;i++)// ALDATU ZUTABE KOP.REN ARABERA
				fila[i] = rs.getObject(i+1);
			modelo1.addRow(fila);
		}			
		Object [] fila = new Object[4];
		modelo1.addRow(fila);
		modelo1.addRow(fila);
	}

}
