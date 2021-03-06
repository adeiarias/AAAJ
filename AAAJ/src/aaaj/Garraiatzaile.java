package aaaj;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Garraiatzaile extends JFrame {

	private static final long serialVersionUID = 1L;
	Connection konexioa;
	Statement stm;
	private JPanel contentPane,panel,panel_1,panel1_0,panel1_1,panel1_1_1,panel1_2;
	private JPanel panel1_3,panel1_3_1,panel_2,panel_3;
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
	
	JTable tabla1;
	private DefaultTableModel modelo1;

	public Garraiatzaile() throws SQLException {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("res/aj.png"));
		
		setTitle("GARRAIATZAILE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try { konexioa.close();	} catch (SQLException e1) {	e1.printStackTrace();	}
                System.exit(0);
            }
        });
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		setLocationRelativeTo(null);
		
		konexioa= Nagusia.getKonexioa();
		stm = konexioa.createStatement();
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 10, 10));
		
		datuakHasieratu();
		ezkerrekoPanela();
		aukera0();
		aukera1();
		aukera2();
		aukera3();
	}
	
	private void datuakHasieratu() {	
		try {
			ResultSet rs = stm.executeQuery("select * from garraiatzaile where gkode=" + Login.loginID+";");
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
			JOptionPane.showMessageDialog(null, "Arazoa egon da datu basean. Saiatu berriro.", "AAAJ", JOptionPane.WARNING_MESSAGE);
		}
				
			
	}
	
	private void aukera0() { //GUNEKO ESKAERAK IKUSI	
		
		panel1_0 = new JPanel();
		
		JButton btnNewButton = new JButton("GUNEKO ESKAERAK IKUSI");
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(false);
				
				
				panel1_0.setVisible(true);
				contentPane.add(panel1_0, BorderLayout.CENTER);
				panel1_0.setLayout(new GridLayout(0, 1, 10, 10));
				
				if (!panel1_0bool) {
					try {
						ResultSet rs = stm.executeQuery("select eskaera.id, bezero.bkode, bezero.dendaizena,bezero.tlf,bezero.helbide from "
						+ "eskaera join bezero on eskaera.bkode=bezero.bkode where bezero.gune=" + gune_datuak + " AND entregatuta=false;");
				
						DefaultTableModel modelo0 = new DefaultTableModel() {					
							private static final long serialVersionUID = 1L;
							@Override
							public boolean isCellEditable(int row, int column) {
								return false;
							}
						};
						JTable tabla0 = new JTable(modelo0);
						tabla0.getTableHeader().setReorderingAllowed(false);
		
						modelo0.addColumn("ID");
						modelo0.addColumn("BKODE");
						modelo0.addColumn("DENDA IZENA");
						modelo0.addColumn("TLF");
						modelo0.addColumn("HELBIDEA");
						
						tabla0.getColumnModel().getColumn(0).setMinWidth(40);
						tabla0.getColumnModel().getColumn(0).setMaxWidth(40);
						tabla0.getColumnModel().getColumn(0).setPreferredWidth(40);
						
						tabla0.getColumnModel().getColumn(1).setMinWidth(56);
						tabla0.getColumnModel().getColumn(1).setMaxWidth(56);
						tabla0.getColumnModel().getColumn(1).setPreferredWidth(56);
						
						tabla0.getColumnModel().getColumn(2).setMinWidth(150);
						tabla0.getColumnModel().getColumn(2).setMaxWidth(150);
						tabla0.getColumnModel().getColumn(2).setPreferredWidth(150);
						
						tabla0.getColumnModel().getColumn(3).setMinWidth(75);
						tabla0.getColumnModel().getColumn(3).setMaxWidth(75);
						tabla0.getColumnModel().getColumn(3).setPreferredWidth(75);

		
						while (rs.next()){
						   Object [] fila = new Object[5]; 
						   for (int i=0;i<5;i++)
						      fila[i] = rs.getObject(i+1);
						   modelo0.addRow(fila);
						}
						
						Object [] fila = new Object[5];
						if (modelo0.getRowCount()>24) {
							modelo0.addRow(fila);
							modelo0.addRow(fila);
						}
	
						JScrollPane js0=new JScrollPane(tabla0);
						
						js0.setVisible(true);
						panel1_0.add(js0);
					
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, "Arazoa egon da datu basean. Saiatu berriro.", "AAAJ", JOptionPane.WARNING_MESSAGE);
					}
					
					////////////////////////
					}
					panel1_0bool=true;
			}
		});
		panel.add(btnNewButton);
	
	}
	
	private void aukera1() { //ESKAERA BAT ENTREGATU	
		
		panel1_1 = new JPanel();
		panel1_1_1 = new JPanel();
		modelo1 = new DefaultTableModel() {					
			private static final long serialVersionUID = 1L;
			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		tabla1 = new JTable(modelo1);
		tabla1.getTableHeader().setReorderingAllowed(false);
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
									String entEskID = textField_panel1_1.getText();
									Integer eskBkode;
									ResultSet rs = stm.executeQuery("SELECT eskaera.bkode FROM eskatu JOIN eskaera ON eskatu.id=eskaera.id where eskatu.id="+entEskID+";");
									if(rs.next()) { 
										eskBkode = (Integer) rs.getObject(1);
									
	
										stm.executeUpdate("UPDATE `eskaera` SET `entregatuta` = true WHERE `eskaera`.`id` = "+entEskID+";");
										stm.executeUpdate("UPDATE `eskaera` SET `gkode` = " + gkode_datuak + " WHERE `eskaera`.`id` = "+entEskID+";");
										Statement stm2 = konexioa.createStatement();
										Statement stm3 = konexioa.createStatement();
										ResultSet rs1 = stm.executeQuery("SELECT eskatu.pkode,eskatu.kantitate FROM eskatu where eskatu.id="+entEskID+";");
										while (rs1.next()) { // RS1 = EROSKETAKO PRODUKTUEN LISTA
											Integer stockpkode = (Integer) rs1.getObject(1); 	// LISTAKO PRODUKTUA
											Integer stockkant = (Integer) rs1.getObject(2);	// PRODUKTUAREN KANTITATEA
											
											System.out.println("PKODE: "+stockpkode);
											System.out.println("KANT: "+stockkant);
											
											ResultSet rs2 = stm2.executeQuery("SELECT * from stock where stock.bkode="+eskBkode+" having stock.pkode="+stockpkode+";");	// PRODUKTUA STOCKEAN DAGO?
											
											if(!rs2.next()) { // PRODUKTUA EZ DAGO
												stm3.executeUpdate("INSERT INTO stock VALUES ("+eskBkode+","+stockpkode+","+stockkant+");");
											}
											else { // PRODUKTUA BADAGO
												Integer badagoKant = (Integer)rs2.getObject(3); // kant BADAGO
												Integer badagoPkode = (Integer)rs2.getObject(2); // pkde BADAGO
												int stockUpd = badagoKant+stockkant;
												stm3.executeUpdate("UPDATE stock SET kantitate="+stockUpd+" WHERE stock.pkode="+badagoPkode+" AND stock.bkode="+eskBkode+";");	
											}
										}
										JOptionPane.showMessageDialog(null, "Entregatuta!", "AAAJ",JOptionPane.DEFAULT_OPTION);
										hasieratu1();
									} else {
										JOptionPane.showMessageDialog(null, "Ez da aurkitu. Saiatu berriro.", "AAAJ", JOptionPane.WARNING_MESSAGE);
									}
								} catch (SQLException e) {
									JOptionPane.showMessageDialog(null, "Arazoa egon da datu basean. Saiatu berriro.", "AAAJ", JOptionPane.WARNING_MESSAGE);
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
	
	}
	
	private void aukera2() { //ENTREGATUTAKO ESKAERAK 	
		
		panel1_2 = new JPanel();
		
		JButton btnNewButton_2 = new JButton("ENTREGATUTAKO ESKAERAK");
		btnNewButton_2.setBackground(SystemColor.menu);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(false);
				panel1_2.setVisible(true);
				
				
				if (!panel1_2bool) {
				
					contentPane.add(panel1_2, BorderLayout.CENTER);
					panel1_2.setLayout(new GridLayout(0, 1, 10, 10));

					try {
						ResultSet rs = stm.executeQuery("select eskaera.id, bezero.bkode, bezero.dendaizena,bezero.tlf,bezero.helbide from eskaera "
								+ "join bezero on eskaera.bkode=bezero.bkode where eskaera.gkode=" + gkode_datuak + " AND eskaera.entregatuta='1';");
						
						DefaultTableModel modelo2 = new DefaultTableModel() {					
							private static final long serialVersionUID = 1L;
		
							@Override
						    public boolean isCellEditable(int row, int column) {
						       //all cells false
						       return false;
						    }
						};
						
						JTable tabla2 = new JTable(modelo2);
						tabla2.getTableHeader().setReorderingAllowed(false);
						
						modelo2.addColumn("ID");
						modelo2.addColumn("BKODE");
						modelo2.addColumn("DENDA IZENA");
						modelo2.addColumn("TLF");
						modelo2.addColumn("HELBIDEA");
						
						tabla2.getColumnModel().getColumn(0).setMinWidth(56);
						tabla2.getColumnModel().getColumn(0).setMaxWidth(56);
						tabla2.getColumnModel().getColumn(0).setPreferredWidth(56);
						
						tabla2.getColumnModel().getColumn(1).setMinWidth(56);
						tabla2.getColumnModel().getColumn(1).setMaxWidth(56);
						tabla2.getColumnModel().getColumn(1).setPreferredWidth(56);
						
						tabla2.getColumnModel().getColumn(2).setMinWidth(150);
						tabla2.getColumnModel().getColumn(2).setMaxWidth(150);
						tabla2.getColumnModel().getColumn(2).setPreferredWidth(150);
						
						tabla2.getColumnModel().getColumn(3).setMinWidth(75);
						tabla2.getColumnModel().getColumn(3).setMaxWidth(75);
						tabla2.getColumnModel().getColumn(3).setPreferredWidth(75);
						
						while (rs.next())
						{
						   Object [] fila = new Object[5];
						   for (int i=0;i<4;i++)
						      fila[i] = rs.getObject(i+1);
						   modelo2.addRow(fila);
						}
						
						Object [] fila = new Object[5];
						if (modelo2.getRowCount()>24) {
							modelo2.addRow(fila);
							modelo2.addRow(fila);
						}
										
						JScrollPane js2=new JScrollPane(tabla2);
						
						js2.setVisible(true);
						panel1_2.add(js2);
					
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, "Arazoa egon da datu basean. Saiatu berriro.", "AAAJ", JOptionPane.WARNING_MESSAGE);
					}

				}
				panel1_2bool=true;
			}
		});
		panel.add(btnNewButton_2);

	}
	
	private void aukera3() { //DATUAK ALDATU	
		
		panel1_3 = new JPanel();
		panel1_3_1 = new JPanel();
		
		JButton btnNewButton_3 = new JButton("DATUAK ALDATU");
		btnNewButton_3.setBackground(SystemColor.menu);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(false);
				panel1_3.setVisible(true); 
				panel1_3_1.setVisible(true);
							
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
				
				JButton btnAldatu = new JButton("ALDATU");
				panel1_3_1.add(btnAldatu);
				btnAldatu.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String queryUpdate="";
						
						if (!textField_1.getText().equals(izena_datuak) ){
							izena_datuak=textField_1.getText();
							izena_datuak=izena_datuak.toUpperCase();
							lblNewLabel_1.setText(izena_datuak + " " + abizena_datuak);
							queryUpdate = "UPDATE `garraiatzaile` SET `izena` = '"+ izena_datuak +"' WHERE `garraiatzaile`.`gkode` = "+gkode_datuak+";";
							
							try {
								stm.executeUpdate(queryUpdate);
							} catch (SQLException e) {
								JOptionPane.showMessageDialog(null, "Arazoa egon da datu basean. Saiatu berriro.", "AAAJ", JOptionPane.WARNING_MESSAGE);
							}
						}
						
						if (!textField_2.getText().equals(abizena_datuak) ){
							abizena_datuak=textField_2.getText();
							abizena_datuak=abizena_datuak.toUpperCase();
							lblNewLabel_1.setText(izena_datuak + " " + abizena_datuak);
							queryUpdate = "UPDATE `garraiatzaile` SET `abizena` = '"+ abizena_datuak +"' WHERE `garraiatzaile`.`gkode` = "+gkode_datuak+";";
							
							try {
								stm.executeUpdate(queryUpdate);
							} catch (SQLException e) {
								JOptionPane.showMessageDialog(null, "Arazoa egon da datu basean. Saiatu berriro.", "AAAJ", JOptionPane.WARNING_MESSAGE);
							}
						}
						
						if (!textField_3.getText().equals(tlf_datuak) ){
							tlf_datuak=textField_3.getText();
							lblNewLabel_5.setText("TLF: " + tlf_datuak);
							queryUpdate = "UPDATE `garraiatzaile` SET `tlf` = "+ tlf_datuak +" WHERE `garraiatzaile`.`gkode` = "+gkode_datuak+";";
							
							try {
								stm.executeUpdate(queryUpdate);
							} catch (SQLException e) {
								JOptionPane.showMessageDialog(null, "Arazoa egon da datu basean. Saiatu berriro.", "AAAJ", JOptionPane.WARNING_MESSAGE);
							}
						}
						
						if (!textField_4.getText().equals(gune_datuak) ){
							gune_datuak=textField_4.getText();
							lblNewLabel_4.setText("GUNE: "+gune_datuak);
							queryUpdate = "UPDATE `garraiatzaile` SET `gune` = "+ gune_datuak +" WHERE `garraiatzaile`.`gkode` = "+gkode_datuak+";";
							
							try {
								stm.executeUpdate(queryUpdate);
							} catch (SQLException e) {
								JOptionPane.showMessageDialog(null, "Arazoa egon da datu basean. Saiatu berriro.", "AAAJ", JOptionPane.WARNING_MESSAGE);
							}
						}
						JOptionPane.showMessageDialog(null, "Aldatuta!", "AAAJ",JOptionPane.DEFAULT_OPTION);
					}
				});
				panel1_3bool=true;
			}
			}
		});
		panel.add(btnNewButton_3);

	}
	
	private void ezkerrekoPanela() {
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new GridLayout(0, 1, 10, 0));
		panel_1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5)); 
		
		JLabel lblNewLabel = new JLabel(new ImageIcon("res/avatar1.jpg"));
		panel_1.add(lblNewLabel);
		
		panel_3 = new JPanel();
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
		
		// GUNEA
		lblNewLabel_4 = new JLabel("GUNE: " + gune_datuak);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_4);
		
		// NAN		
		lblNewLabel_3 = new JLabel("NAN: " + nan_datuak);			
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_3);
		
		// TLF
		lblNewLabel_5 = new JLabel("TLF: " + tlf_datuak);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_5);
		
		
		panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnNewButton_6 = new JButton(new ImageIcon("res/homesmall.png"));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel1_0.setVisible(false);
				panel1_1.setVisible(false);
					panel1_1_1.setVisible(false);
				panel1_2.setVisible(false);
				panel1_3.setVisible(false);
					panel1_3_1.setVisible(false);
				panel.setVisible(true);
			}
		});
		panel_2.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton(new ImageIcon("res/logoutsmall.png"));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel1_0bool=false;
				panel1_1bool=false;
				panel1_2bool=false;
				panel1_3bool=false;
				panel1_0=null;
				panel1_1=null;
				panel1_1_1=null;
				panel1_2=null;
				panel1_3=null;
				panel1_3_1=null;
				panel=null;
				Login.loginID="-1000";
				Login loginLogout = new Login();
				loginLogout.setVisible(true);
				setVisible(false);
			}
		});
		panel_2.add(btnNewButton_7);
		
	}
	
	public void hasieratu1() throws SQLException {
		ResultSet rs = stm.executeQuery("select eskaera.id, bezero.bkode, bezero.dendaizena,bezero.tlf,bezero.helbide from "
				+ "eskaera join bezero on eskaera.bkode=bezero.bkode where bezero.gune=" + gune_datuak + " AND entregatuta=false;");
		modelo1.setRowCount(0);
		modelo1.setColumnCount(0);
		
		modelo1.addColumn("ID");
		modelo1.addColumn("BKODE");
		modelo1.addColumn("DENDA IZENA");
		modelo1.addColumn("TLF");
		modelo1.addColumn("HELBIDEA");
		
		tabla1.getColumnModel().getColumn(0).setMinWidth(56);
		tabla1.getColumnModel().getColumn(0).setMaxWidth(56);
		tabla1.getColumnModel().getColumn(0).setPreferredWidth(56);
		
		tabla1.getColumnModel().getColumn(1).setMinWidth(56);
		tabla1.getColumnModel().getColumn(1).setMaxWidth(56);
		tabla1.getColumnModel().getColumn(1).setPreferredWidth(56);
		
		tabla1.getColumnModel().getColumn(2).setMinWidth(100);
		tabla1.getColumnModel().getColumn(2).setMaxWidth(100);
		tabla1.getColumnModel().getColumn(2).setPreferredWidth(100);
		
		tabla1.getColumnModel().getColumn(3).setMinWidth(75);
		tabla1.getColumnModel().getColumn(3).setMaxWidth(75);
		tabla1.getColumnModel().getColumn(3).setPreferredWidth(75);
		

		while (rs.next())
		{
			Object [] fila = new Object[5]; // ALDATU ZUTABE KOP.REN ARABERA
			for (int i=0;i<5;i++)// ALDATU ZUTABE KOP.REN ARABERA
				fila[i] = rs.getObject(i+1);
			modelo1.addRow(fila);
		}			
		Object [] fila = new Object[5];
		if (modelo1.getRowCount()>24) {
			modelo1.addRow(fila);
			modelo1.addRow(fila);
		}
		
	}

}
