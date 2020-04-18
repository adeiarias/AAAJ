package aaaj;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Dimension;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Admin extends JFrame {

	private static final long serialVersionUID = 1L;
	Statement stm;
	Connection konexioa;
	private JPanel contentPane, panel,panel_1,panel_2,panel_3,panel1_0,panel1_0_1,panel1_1,panel1_1_1;
	private JPanel panel1_2,panel1_2_1,panel1_3,panel1_4,panel1_4_1,panel1_5,panel1_5_1,panel1_6,panel1_7,panel1_7_1;
	private static boolean panel1_0bool=false;
	private static boolean panel1_1bool=false;
	private static boolean panel1_2bool=false;
	private static boolean panel1_3bool=false;
	private static boolean panel1_4bool=false;
	private static boolean panel1_5bool=false;
	private static boolean panel1_6bool=false;
	private static boolean panel1_7bool=false;
	DefaultTableModel modelo0;
	DefaultTableModel modelo1;
	DefaultTableModel modelo2;
	DefaultTableModel modelo3;
	DefaultTableModel modelo4;
	DefaultTableModel modelo5;
	DefaultTableModel modelo6;
	DefaultTableModel modelo7;

	public Admin() throws SQLException {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("res/aj.png"));
		
		setTitle("ADMIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try { konexioa.close();	} catch (SQLException e1) {	JOptionPane.showMessageDialog(null, "Arazoa egon da datu basean. Saiatu berriro.", "AAAJ", JOptionPane.WARNING_MESSAGE);	}
                System.exit(0);
            }
        });
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		setLocationRelativeTo(null);
		Nagusia nag=new Nagusia();
		konexioa= nag.getKonexioa();
		stm = konexioa.createStatement();
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 10, 10));
		
		ezkerrekoPanela();
		aukera0();
		aukera1();
		aukera2();
		aukera3();
		aukera4();
		aukera5();
		aukera6();
		aukera7();
		
	}
	
	private void aukera0() {	//BEZERO/GARRAIATZAILEA GEHITU	
		panel1_0 = new JPanel();
		panel1_0_1 = new JPanel();
	
		
		JButton btnNewButton_0 = new JButton("BEZERO/GARRAIATZAILEA GEHITU");
		btnNewButton_0.setBackground(SystemColor.menu);
		btnNewButton_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(false);
				panel1_0.setVisible(true);
				panel1_0_1.setVisible(true);
							
			if (!panel1_0bool) {
				panel1_0.setBorder(new EmptyBorder(50, 100, 0, 100));
				contentPane.add(panel1_0, BorderLayout.CENTER);
				panel1_0.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				
				panel1_0_1.setPreferredSize(new Dimension(300, 600));
				panel1_0.add(panel1_0_1);
				
				JRadioButton rdbtn1_0 = new JRadioButton("Bezero");
				JRadioButton rdbtn2_0 = new JRadioButton("Garraiatzaile");
				rdbtn1_0.setSelected(true);
				ButtonGroup buttonGroup = new ButtonGroup();
				buttonGroup.add(rdbtn1_0);
				buttonGroup.add(rdbtn2_0);
				panel1_0_1.add(rdbtn1_0);
				panel1_0_1.add(rdbtn2_0);
				
				JLabel lblesp_0 = new JLabel("");
				lblesp_0.setPreferredSize(new Dimension(300, 10));
				panel1_0_1.add(lblesp_0);
				
				JLabel lbldatuak_1 = new JLabel("ERABILTZAILEA:");
				panel1_0_1.add(lbldatuak_1);
				
				JTextField textField_1 = new JTextField();
				textField_1.setColumns(25);
				panel1_0_1.add(textField_1);
				
				JLabel lblesp_1 = new JLabel("");
				lblesp_1.setPreferredSize(new Dimension(300, 10));
				panel1_0_1.add(lblesp_1);
				
				//
				
				JLabel lbldatuak_2 = new JLabel("PASAHITZA:");
				panel1_0_1.add(lbldatuak_2);
				
				JPasswordField pwfield = new JPasswordField();
				pwfield.setColumns(25);
				panel1_0_1.add(pwfield);
				
				JCheckBox jch = new JCheckBox("Pasahitza ikusi");
				int defaultpw = pwfield.getEchoChar(); 
				jch.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (jch.isSelected()){
							pwfield.setEchoChar((char)0);
						}
						else {
							pwfield.setEchoChar((char)defaultpw);
						}
					}
				});
				panel1_0_1.add(jch);
				
				/*
				JTextField textField_2 = new JTextField();
				textField_2.setColumns(25);
				panel1_0_1.add(textField_2);
				*/
				JLabel lblesp_2 = new JLabel("");
				lblesp_2.setPreferredSize(new Dimension(300, 5));
				panel1_0_1.add(lblesp_2);
				
				//
				
				JLabel lbldatuak_3 = new JLabel("NAN edo IFZ:");
				panel1_0_1.add(lbldatuak_3);
				
				JTextField textField_3 = new JTextField();
				textField_3.setColumns(25);
				panel1_0_1.add(textField_3);
				
				JLabel lblesp_3 = new JLabel("");
				lblesp_3.setPreferredSize(new Dimension(300, 10));
				panel1_0_1.add(lblesp_3);
				
				//
				
				JLabel lbldatuak_4 = new JLabel("(Gainontzeko informazioa erabiltzaile");
				JLabel lbldatuak_5 = new JLabel("bakoitzak gehitu behar du.)");
				panel1_0_1.add(lbldatuak_4);
				panel1_0_1.add(lbldatuak_5);
				
				JLabel lblesp_4 = new JLabel("");
				lblesp_4.setPreferredSize(new Dimension(300, 10));
				panel1_0_1.add(lblesp_4);

				
				
				JButton btnAldatu = new JButton("SORTU");
				panel1_0_1.add(btnAldatu);
				btnAldatu.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String queryUpdate="";
						long unixTime = System.currentTimeMillis() / 1000L;
						String kod=Integer.toString((int)unixTime).substring(3);
						String erabQ=textField_1.getText();
						char[] value2char=pwfield.getPassword();
						String passQ= new String(value2char);
						
						queryUpdate = "INSERT INTO erabiltzaile VALUES (" + kod + ", '" + erabQ + "', '" + passQ + "');";
						
						try {	stm.executeUpdate(queryUpdate);		} catch (SQLException e) {JOptionPane.showMessageDialog(null, "Arazoa egon da datu basean. Saiatu berriro.", "AAAJ", JOptionPane.WARNING_MESSAGE);}
						
						String nanifz=textField_3.getText();
						
						if(rdbtn1_0.isSelected()) {
							queryUpdate = "INSERT INTO bezero VALUES (" + kod + ", 9999, 'DENDAIZENA', 'HELBIDEA', 000000000, '"+nanifz+"');";
						}
						else{
							queryUpdate = "INSERT INTO garraiatzaile VALUES (" + kod + ", 9999, 'IZENA', 'ABIZENA', 000000000, '"+nanifz+"');";
						}
							
						try {	stm.executeUpdate(queryUpdate);		} catch (SQLException e) {JOptionPane.showMessageDialog(null, "Arazoa egon da datu basean. Saiatu berriro.", "AAAJ", JOptionPane.WARNING_MESSAGE);}
						
						textField_1.setText("");
						pwfield.setText("");
						textField_3.setText("");
						
						JOptionPane.showMessageDialog(null, "Sortuta!", "AAAJ",JOptionPane.DEFAULT_OPTION);
						
					}
				});
				panel1_0bool=true;
			}
			}
		});
		panel.add(btnNewButton_0);
		
	}
	
	private void aukera1() {	//BEZERO/GARRAIATZAILEA KENDU	
		
		panel1_1 = new JPanel();
		panel1_1_1 = new JPanel();
		modelo1 = new DefaultTableModel() {					
			private static final long serialVersionUID = 1L;
			@Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		JTable tabla1 = new JTable(modelo1);
		tabla1.getTableHeader().setReorderingAllowed(false);
		panel1_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel1_1_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton_1 = new JButton("BEZERO/GARRAIATZAILEA KENDU");
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
					JOptionPane.showMessageDialog(null, "Arazoa egon da datu basean. Saiatu berriro.", "AAAJ", JOptionPane.WARNING_MESSAGE);
				}

				if (!panel1_1bool) {
											
						JScrollPane js1=new JScrollPane(tabla1);
						js1.setViewportBorder(new EmptyBorder(0, 0, -30, 0));
						js1.setVisible(true);
						
						panel1_1_1.setBorder(new EmptyBorder(30, 0, 30, 0));
						panel1_1.add(panel1_1_1);
				
						JLabel lblNewLabel_panel1_1 = new JLabel("Sartu ezabatu nahi duzun erabiltzailearen IDa:   ");
						panel1_1_1.add(lblNewLabel_panel1_1);
				
						JTextField textField_panel1_1 = new JTextField();
						panel1_1_1.add(textField_panel1_1);
						textField_panel1_1.setColumns(10);
		
						JLabel lblNewLabel_panel1_1_1 = new JLabel("   ");
						panel1_1_1.add(lblNewLabel_panel1_1_1);
		
						JButton btnNewButton_panel1_1 = new JButton("EZABATU");
						btnNewButton_panel1_1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								try {
									String erabiltzaileID=textField_panel1_1.getText();
									String query = "";
									query = "DELETE FROM erabiltzaile WHERE erabkodea="+erabiltzaileID+";";
									stm.executeUpdate(query);
									
									modelo1.setRowCount(0);
									ResultSet rs = stm.executeQuery("select * FROM erabiltzaile;");
									modelo1.setRowCount(0);
									while (rs.next())
									{
										Object [] fila = new Object[3]; // ALDATU ZUTABE KOP.REN ARABERA
										for (int i=0;i<3;i++)
											fila[i] = rs.getObject(i+1);
										modelo1.addRow(fila);
									}			
									Object [] fila = new Object[3];
									modelo1.addRow(fila);
									modelo1.addRow(fila);
									
									textField_panel1_1.setText("");
									JOptionPane.showMessageDialog(null, "Ezabatuta!", "AAAJ",JOptionPane.DEFAULT_OPTION);
									
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
	
	private void aukera2() {	//BEZERO JAKIN BATEN STOCKA IKUSI	
		
		panel1_2 = new JPanel();
		panel1_2_1 = new JPanel();
		modelo2 = new DefaultTableModel() {					
			private static final long serialVersionUID = 1L;
			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		JTable tabla2 = new JTable(modelo2);
		tabla2.getTableHeader().setReorderingAllowed(false);
		panel1_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel1_2_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton_2 = new JButton("BEZERO JAKIN BATEN STOCKA IKUSI");
		btnNewButton_2.setBackground(SystemColor.menu);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(false);
				panel1_2.setVisible(true);
				panel1_2_1.setVisible(true);
				contentPane.add(panel1_2, BorderLayout.CENTER);
				
				try {
					hasieratu2();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Arazoa egon da datu basean. Saiatu berriro.", "AAAJ", JOptionPane.WARNING_MESSAGE);
				}

				if (!panel1_2bool) {
						
					JScrollPane js2=new JScrollPane(tabla2);
					js2.setViewportBorder(new EmptyBorder(0, 0, -30, 0));
					js2.setVisible(true);
						
					panel1_2_1.setBorder(new EmptyBorder(30, 0, 30, 0));
					panel1_2.add(panel1_2_1);
				
					JLabel lblNewLabel_panel1_2 = new JLabel("Sartu ikusi nahi duzun stockaren bezeroaren IDa:   ");
					panel1_2_1.add(lblNewLabel_panel1_2);
				
					JTextField textField_panel1_2 = new JTextField();
					panel1_2_1.add(textField_panel1_2);
					textField_panel1_2.setColumns(10);
		
					JLabel lblNewLabel_panel1_2_1 = new JLabel("   ");
					panel1_2_1.add(lblNewLabel_panel1_2_1);
		
					JButton btnNewButton_panel1_2 = new JButton("IKUSI");
					btnNewButton_panel1_2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								try {
									String bezeroID=textField_panel1_2.getText();
									String query = "";
									query = "SELECT stock.pkode,stock.kantitate,produktu.izena,produktu.deskribapena FROM (stock JOIN bezero ON stock.bkode=bezero.bkode) "
											+ "JOIN produktu ON stock.pkode=produktu.pkode where stock.bkode="+bezeroID+";";
									modelo2.setRowCount(0);
									modelo2.setColumnCount(0);
									
									ResultSet rs = stm.executeQuery(query);
									
									
									modelo2.addColumn("PKODE");
									modelo2.addColumn("KANT");
									modelo2.addColumn("IZENA");
									modelo2.addColumn("DESKRIBAPENA");
									tabla2.getColumnModel().getColumn(0).setMinWidth(40);
									tabla2.getColumnModel().getColumn(0).setMaxWidth(40);
									tabla2.getColumnModel().getColumn(0).setPreferredWidth(40);
									
									tabla2.getColumnModel().getColumn(1).setMinWidth(40);
									tabla2.getColumnModel().getColumn(1).setMaxWidth(40);
									tabla2.getColumnModel().getColumn(1).setPreferredWidth(40);
									
									
									while (rs.next())
									{
										Object [] fila = new Object[4]; 
										for (int i=0;i<4;i++)
											fila[i] = rs.getObject(i+1);
										modelo2.addRow(fila);
									}			
									Object [] fila = new Object[4];
									if (modelo2.getRowCount()>24) {
										modelo2.addRow(fila);
										modelo2.addRow(fila);
									}
								} catch (SQLException e) {
									JOptionPane.showMessageDialog(null, "Arazoa egon da datu basean. Saiatu berriro.", "AAAJ", JOptionPane.WARNING_MESSAGE);
								}
							}
						});
					panel1_2_1.add(btnNewButton_panel1_2);
					panel1_2.add(js2);
				}
				panel1_2bool=true;
			}
		});
		panel.add(btnNewButton_2);
		
	}
		
	private void aukera3() {	//ENTREGATU BEHARREKO ESKAERA GUZTIAK IKUSI	
		
		panel1_3 = new JPanel();
		JButton btnNewButton_3 = new JButton("ENTREGATU BEHARREKO ESKAERA GUZTIAK IKUSI");
		btnNewButton_3.setBackground(SystemColor.menu);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(false);
				
				
				panel1_3.setVisible(true);
				contentPane.add(panel1_3, BorderLayout.CENTER);
				panel1_3.setLayout(new GridLayout(0, 1, 10, 10));
				
				if (!panel1_3bool) {
					try {
						ResultSet rs = stm.executeQuery("select eskaera.id, bezero.bkode, bezero.dendaizena,bezero.helbide,bezero.tlf from eskaera join bezero on eskaera.bkode=bezero.bkode where eskaera.entregatuta=false;");
						
						DefaultTableModel modelo = new DefaultTableModel() {					
							private static final long serialVersionUID = 1L;
							@Override
						    public boolean isCellEditable(int row, int column) {
						       return false;
						    }
						};
						JTable tabla = new JTable(modelo);
						tabla.getTableHeader().setReorderingAllowed(false);
						modelo.addColumn("ID");
						modelo.addColumn("BKODE");
						modelo.addColumn("DENDAIZENA");
						modelo.addColumn("HELBIDEA");
						modelo.addColumn("TLF");
						

						tabla.getColumnModel().getColumn(0).setMinWidth(60);
						tabla.getColumnModel().getColumn(0).setMaxWidth(60);
						tabla.getColumnModel().getColumn(0).setPreferredWidth(60);
						
						tabla.getColumnModel().getColumn(1).setMinWidth(60);
						tabla.getColumnModel().getColumn(1).setMaxWidth(60);
						tabla.getColumnModel().getColumn(1).setPreferredWidth(60);
						
						tabla.getColumnModel().getColumn(2).setMinWidth(135);
						tabla.getColumnModel().getColumn(2).setMaxWidth(135);
						tabla.getColumnModel().getColumn(2).setPreferredWidth(135);
						
						tabla.getColumnModel().getColumn(4).setMinWidth(80);
						tabla.getColumnModel().getColumn(4).setMaxWidth(80);
						tabla.getColumnModel().getColumn(4).setPreferredWidth(80);
		
						
						while (rs.next())
						{
						   Object [] fila = new Object[5];
						   for (int i=0;i<5;i++)
						      fila[i] = rs.getObject(i+1);
						   modelo.addRow(fila);
						}
						
						Object [] fila = new Object[5];
						if (modelo.getRowCount()>24) {
							modelo.addRow(fila);
							modelo.addRow(fila);
						}
						
						JScrollPane js=new JScrollPane(tabla);
						
						js.setVisible(true);
						panel1_3.add(js);
						
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, "Arazoa egon da datu basean. Saiatu berriro.", "AAAJ", JOptionPane.WARNING_MESSAGE);
					}

				}
				panel1_3bool=true;
			}
		});
		panel.add(btnNewButton_3);
		
	}
		
	private void aukera4() {	//ESKAERAK/BEZEROAK/GARRAIATZAILEAK GUNEKA FILTRATU	
		
		panel1_4 = new JPanel();
		panel1_4_1 = new JPanel();
		panel1_4.add(panel1_4_1);
		DefaultTableModel modelo1_4 = new DefaultTableModel() {					
			private static final long serialVersionUID = 1L;
			@Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		JTable tabla1_4 = new JTable(modelo1_4);
		tabla1_4.getTableHeader().setReorderingAllowed(false);
		panel1_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel1_4_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton_4 = new JButton("ESKAERAK/BEZEROAK/GARRAIATZAILEAK GUNEKA FILTRATU");
		btnNewButton_4.setBackground(SystemColor.menu);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(false);
				panel1_4.setVisible(true);
				contentPane.add(panel1_4, BorderLayout.CENTER);
				panel1_4_1.setVisible(true);
				modelo1_4.setRowCount(0);
				modelo1_4.setColumnCount(0);

				if (!panel1_4bool) {
											
						JScrollPane js4=new JScrollPane(tabla1_4);
						js4.setViewportBorder(new EmptyBorder(0, 0, -30, 0));
						js4.setVisible(true);
						
						panel1_4_1.setBorder(new EmptyBorder(30, 0, 30, 0));
				
						JLabel lblNewLabel_panel1_4 = new JLabel("Sartu IDa:   ");
						panel1_4_1.add(lblNewLabel_panel1_4);
				
						JTextField textField_panel1_4 = new JTextField();
						panel1_4_1.add(textField_panel1_4);
						textField_panel1_4.setColumns(10);

						JLabel lblNewLabel_panel1_4_1 = new JLabel("   ");
						panel1_4_1.add(lblNewLabel_panel1_4_1);
						
						JRadioButton rdbtn1 = new JRadioButton("Eskaera");
						JRadioButton rdbtn2 = new JRadioButton("Garraio");
						JRadioButton rdbtn3 = new JRadioButton("Bezero");
						ButtonGroup buttonGroup = new ButtonGroup();
						buttonGroup.add(rdbtn1);
						buttonGroup.add(rdbtn2);
						buttonGroup.add(rdbtn3);

						JButton btnNewButton_panel1_4 = new JButton("BILATU");
						btnNewButton_panel1_4.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								if(rdbtn1.isSelected()) { // ESKAERA DA
									try {
										modelo1_4.setRowCount(0);
										modelo1_4.setColumnCount(0);
										Vector<String> zutabeak=new Vector<String>();
										modelo1_4.setColumnCount(4);
										zutabeak.add("ID");
										zutabeak.add("BKODE");
										zutabeak.add("PKODE");
										zutabeak.add("KANT");
										modelo1_4.setColumnIdentifiers(zutabeak);
										ResultSet rs = stm.executeQuery("select eskaera.* from eskaera join bezero on eskaera.bkode=bezero.bkode where bezero.gune="+textField_panel1_4.getText()+"");
										while (rs.next())
										{
											Object [] fila = new Object[4]; // ALDATU ZUTABE KOP.REN ARABERA
											for (int i=0;i<4;i++)// ALDATU ZUTABE KOP.REN ARABERA
												fila[i] = rs.getObject(i+1);
											modelo1_4.addRow(fila);
										}			
										Object [] fila = new Object[4];
										if (modelo1_4.getRowCount()>24) {
											modelo1_4.addRow(fila);
											modelo1_4.addRow(fila);
										}
									} catch (SQLException e) {
										JOptionPane.showMessageDialog(null, "Arazoa egon da datu basean. Saiatu berriro.", "AAAJ", JOptionPane.WARNING_MESSAGE);
									}
								}
								else if(rdbtn2.isSelected()) {
									try {
										modelo1_4.setRowCount(0);
										modelo1_4.setColumnCount(0);
										Vector<String> zutabeak=new Vector<String>();
										zutabeak.add("BKODE");
										zutabeak.add("DENDA IZENA");
										zutabeak.add("HELBIDEA");
										zutabeak.add("TLF");
										zutabeak.add("IFZ");
										modelo1_4.setColumnIdentifiers(zutabeak);
										ResultSet rs = stm.executeQuery("select * from bezero where gune="+textField_panel1_4.getText()+"");
										while (rs.next())
										{
											Object [] fila = new Object[5]; // ALDATU ZUTABE KOP.REN ARABERA
											for (int i=0;i<5;i++)// ALDATU ZUTABE KOP.REN ARABERA
												fila[i] = rs.getObject(i+1);
											modelo1_4.addRow(fila);
										}			
										Object [] fila = new Object[5];
										if (modelo1_4.getRowCount()>24) {
											modelo1_4.addRow(fila);
											modelo1_4.addRow(fila);
										}
									} catch (SQLException e) {
										JOptionPane.showMessageDialog(null, "Arazoa egon da datu basean. Saiatu berriro.", "AAAJ", JOptionPane.WARNING_MESSAGE);
									}
								}
								else if(rdbtn3.isSelected()) {
									try {
										modelo1_4.setRowCount(0);
										Vector<String> zutabeak=new Vector<String>();
										zutabeak.add("GKODE");
										zutabeak.add("IZENA");
										zutabeak.add("ABIZENA");
										zutabeak.add("TLF");
										zutabeak.add("NAN");
										modelo1_4.setColumnIdentifiers(zutabeak);
										ResultSet rs = stm.executeQuery("select * from garraiatzaile where gune="+textField_panel1_4.getText()+"");
										while (rs.next())
										{
											Object [] fila = new Object[5]; // ALDATU ZUTABE KOP.REN ARABERA
											for (int i=0;i<5;i++)// ALDATU ZUTABE KOP.REN ARABERA
												fila[i] = rs.getObject(i+1);
											modelo1_4.addRow(fila);
										}			
										Object [] fila = new Object[5];
										if (modelo1_4.getRowCount()>24) {
											modelo1_4.addRow(fila);
											modelo1_4.addRow(fila);
										}
									} catch (SQLException e) {
										JOptionPane.showMessageDialog(null, "Arazoa egon da datu basean. Saiatu berriro.", "AAAJ", JOptionPane.WARNING_MESSAGE);
									}
								}
									
								
								
									
							}
						});
						panel1_4_1.add(btnNewButton_panel1_4);
						panel1_4_1.add(rdbtn1);
						panel1_4_1.add(rdbtn2);
						panel1_4_1.add(rdbtn3);			
						panel1_4.add(js4);	
				}
				panel1_4bool=true;
			}
		});
		panel.add(btnNewButton_4);
		
	}
	
	private void aukera5() {	//ESKAERA ID-Z BILATU	
		
		panel1_5 = new JPanel();
		panel1_5_1 = new JPanel();
		modelo5 = new DefaultTableModel() {					
			private static final long serialVersionUID = 1L;
			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		JTable tabla5 = new JTable(modelo5);
		tabla5.getTableHeader().setReorderingAllowed(false);
		panel1_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel1_5_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton_5 = new JButton("ESKAERA ID-Z BILATU");
		btnNewButton_5.setBackground(SystemColor.menu);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(false);
				panel1_5.setVisible(true);
				panel1_5_1.setVisible(true);
				contentPane.add(panel1_5, BorderLayout.CENTER);
				try {
					hasieratu5();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Arazoa egon da datu basean. Saiatu berriro.", "AAAJ", JOptionPane.WARNING_MESSAGE);
				}

				if (!panel1_5bool) {
						
					JScrollPane js5=new JScrollPane(tabla5);
					js5.setViewportBorder(new EmptyBorder(0, 0, -30, 0));
					js5.setVisible(true);
						
					panel1_5_1.setBorder(new EmptyBorder(30, 0, 30, 0));
					panel1_5.add(panel1_5_1);
				
					JLabel lblNewLabel_panel1_5 = new JLabel("Sartu bilatu nahi duzun eskaeraren IDa:   ");
					panel1_5_1.add(lblNewLabel_panel1_5);
				
					JTextField textField_panel1_5 = new JTextField();
					panel1_5_1.add(textField_panel1_5);
					textField_panel1_5.setColumns(10);
		
					JLabel lblNewLabel_panel1_5_1 = new JLabel("   ");
					panel1_5_1.add(lblNewLabel_panel1_5_1);
		
					JButton btnNewButton_panel1_5 = new JButton("BILATU");
					btnNewButton_panel1_5.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								try {
									modelo5.setRowCount(0);
									modelo5.setColumnCount(0);
									
									String query="SELECT bezero.bkode,bezero.dendaizena,eskatu.pkode,produktu.izena,produktu.deskribapena,eskatu.kantitate "
											+ "FROM ((eskatu JOIN eskaera ON eskatu.id=eskaera.id) JOIN produktu on eskatu.pkode=produktu.pkode) "
											+ "JOIN bezero on eskaera.bkode=bezero.bkode WHERE eskatu.id=" + textField_panel1_5.getText() + ";";
									
									ResultSet rs = stm.executeQuery(query);
									
									modelo5.addColumn("BKODE");
									modelo5.addColumn("DENDAIZENA");
									modelo5.addColumn("PKODE");
									modelo5.addColumn("IZENA");
									modelo5.addColumn("DESKRIBAPENA");
									modelo5.addColumn("KANTITATE");
									
									
									while (rs.next())
									{
										Object [] fila = new Object[6]; // ALDATU ZUTABE KOP.REN ARABERA
										for (int i=0;i<6;i++)// ALDATU ZUTABE KOP.REN ARABERA
											fila[i] = rs.getObject(i+1);
										modelo5.addRow(fila);
									}			
									Object [] fila = new Object[6];
									if (modelo5.getRowCount()>24) {
										modelo5.addRow(fila);
										modelo5.addRow(fila);
									}
								} catch (SQLException e) {
									JOptionPane.showMessageDialog(null, "Arazoa egon da datu basean. Saiatu berriro.", "AAAJ", JOptionPane.WARNING_MESSAGE);
								}
							}
						});
					panel1_5_1.add(btnNewButton_panel1_5);
					panel1_5.add(js5);
				}
				panel1_5bool=true;
			}
		});
		panel.add(btnNewButton_5);
	
	}
	
	private void aukera6() {	//ESKAEREN HISTORIALA BISTARATU		
		
		panel1_6 = new JPanel();
		JButton btnNewButton_6 = new JButton("ESKAEREN HISTORIALA BISTARATU");
		btnNewButton_6.setBackground(SystemColor.menu);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(false);
				
				
				panel1_6.setVisible(true);
				contentPane.add(panel1_6, BorderLayout.CENTER);
				panel1_6.setLayout(new GridLayout(0, 1, 10, 10));
				
				if (!panel1_6bool) {
					try {
						//ResultSet rs = stm.executeQuery("select eskaera.id, bezero.bkode, bezero.dendaizena,bezero.tlf from eskaera join bezero on eskaera.bkode=bezero.bkode where bezero.gune=" + gune_datuak + " AND entregatuta=false;");
						ResultSet rs = stm.executeQuery("SELECT eskaera.id,bezero.bkode,bezero.dendaizena,eskatu.pkode,produktu.izena,produktu.deskribapena,"
								+ "eskatu.kantitate,eskaera.entregatuta FROM ((eskatu JOIN eskaera ON eskatu.id=eskaera.id) "
								+ "JOIN produktu on eskatu.pkode=produktu.pkode) JOIN bezero on eskaera.bkode=bezero.bkode ");
				
						DefaultTableModel modelo6 = new DefaultTableModel() {					
							private static final long serialVersionUID = 1L;
							@Override
						    public boolean isCellEditable(int row, int column) {
						       //all cells false
						       return false;
						    }
						};
						JTable tabla6 = new JTable(modelo6);
						tabla6.getTableHeader().setReorderingAllowed(false);
						// ZUTABEAK SORTU
						modelo6.addColumn("ID");
						modelo6.addColumn("BKODE");
						modelo6.addColumn("DENDA");
						modelo6.addColumn("PKOD");
						modelo6.addColumn("PROD.");
						modelo6.addColumn("DESKRIB.");
						modelo6.addColumn("KTE");
						modelo6.addColumn("✓");
						
						tabla6.getColumnModel().getColumn(0).setMinWidth(56);
						tabla6.getColumnModel().getColumn(0).setMaxWidth(56);
						tabla6.getColumnModel().getColumn(0).setPreferredWidth(56);
						
						tabla6.getColumnModel().getColumn(1).setMinWidth(56);
						tabla6.getColumnModel().getColumn(1).setMaxWidth(56);
						tabla6.getColumnModel().getColumn(1).setPreferredWidth(56);
						
						tabla6.getColumnModel().getColumn(3).setMinWidth(40);
						tabla6.getColumnModel().getColumn(3).setMaxWidth(40);
						tabla6.getColumnModel().getColumn(3).setPreferredWidth(40);
						
						tabla6.getColumnModel().getColumn(6).setMinWidth(40);
						tabla6.getColumnModel().getColumn(6).setMaxWidth(40);
						tabla6.getColumnModel().getColumn(6).setPreferredWidth(40);
						
						tabla6.getColumnModel().getColumn(7).setMinWidth(40);
						tabla6.getColumnModel().getColumn(7).setMaxWidth(40);
						tabla6.getColumnModel().getColumn(7).setPreferredWidth(40);
						


						while (rs.next())
						{
							Object [] fila = new Object[8]; // ALDATU ZUTABE KOP.REN ARABERA
							for (int i=0;i<8;i++)// ALDATU ZUTABE KOP.REN ARABERA
									fila[i] = rs.getObject(i+1);
							modelo6.addRow(fila);
						}
						
						
						JScrollPane js6=new JScrollPane(tabla6);
				
						js6.setVisible(true);
						panel1_6.add(js6);
				
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, "Arazoa egon da datu basean. Saiatu berriro.", "AAAJ", JOptionPane.WARNING_MESSAGE);
					}
				}
				panel1_6bool=true;
			}
		});		
		panel.add(btnNewButton_6);
	
	}
	
	private void aukera7() {	//BEZERO/GARRAIATZAILEAREN INFORMAZIOA BISTARATU	
		
		panel1_7 = new JPanel();
		panel1_7_1 = new JPanel();
		panel1_7.add(panel1_7_1);
		
		panel1_7.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel1_7_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton_7 = new JButton("BEZERO/GARRAIATZAILEAREN INFORMAZIOA BISTARATU");
		btnNewButton_7.setBackground(SystemColor.menu);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(false);
				panel1_7.setVisible(true);
				contentPane.add(panel1_7, BorderLayout.CENTER);
				panel1_7_1.setVisible(true);

				if (!panel1_7bool) {
											

					panel1_7_1.setBorder(new EmptyBorder(30, 0, 30, 0));
					panel1_7_1.setPreferredSize(new Dimension(300, 600));
					
					JLabel lblNewLabel_panel1_7 = new JLabel("Sartu bezero/garraiatzailearen IDa:   ");
					panel1_7_1.add(lblNewLabel_panel1_7);
				
					JTextField textField_panel1_7 = new JTextField();
					panel1_7_1.add(textField_panel1_7);
					textField_panel1_7.setColumns(10);

					JLabel lblNewLabel_panel1_7_1 = new JLabel("   ");
					panel1_7_1.add(lblNewLabel_panel1_7_1);
						

					JButton btnNewButton_panel1_7 = new JButton("BILATU");
					btnNewButton_panel1_7.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							/*
							buscar ID
							if bezero: poner los nombres de columna de bezero (setText)
							else: poner los nombres de columna de garraio (setText)
							*/
						}
					});
					panel1_7_1.add(btnNewButton_panel1_7);
						
					JLabel lblesp_0 = new JLabel("");
					lblesp_0.setPreferredSize(new Dimension(300, 10));
					panel1_7_1.add(lblesp_0);
					
					JLabel lbldatuak_1 = new JLabel(" ");
					panel1_7_1.add(lbldatuak_1);
					
					JTextField textField_1 = new JTextField();
					textField_1.setColumns(25);
					panel1_7_1.add(textField_1);
					
					JLabel lblesp_1 = new JLabel("");
					lblesp_1.setPreferredSize(new Dimension(300, 10));
					panel1_7_1.add(lblesp_1);
					
					//
					
					JLabel lbldatuak_2 = new JLabel(" ");
					panel1_7_1.add(lbldatuak_2);
					
					JTextField textField_2 = new JTextField();
					textField_2.setColumns(25);
					panel1_7_1.add(textField_2);
					
					JLabel lblesp_2 = new JLabel("");
					lblesp_2.setPreferredSize(new Dimension(300, 10));
					panel1_7_1.add(lblesp_2);
					
					//
					
					JLabel lbldatuak_3 = new JLabel(" ");
					panel1_7_1.add(lbldatuak_3);
					
					JTextField textField_3 = new JTextField();
					textField_3.setColumns(25);
					panel1_7_1.add(textField_3);
					
					JLabel lblesp_3 = new JLabel("");
					lblesp_3.setPreferredSize(new Dimension(300, 10));
					panel1_7_1.add(lblesp_3);
					
					//
					
					JLabel lbldatuak_4 = new JLabel(" ");
					panel1_7_1.add(lbldatuak_4);
					
					JTextField textField_4 = new JTextField();
					textField_4.setColumns(25);
					panel1_7_1.add(textField_4);
					
					JLabel lblesp_4 = new JLabel("");
					lblesp_4.setPreferredSize(new Dimension(300, 10));
					panel1_7_1.add(lblesp_4);	
	
						
				}
				panel1_7bool=true;
			}
		});	
		panel.add(btnNewButton_7);
	
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
		
		
		JLabel lblNewLabel_1 = new JLabel("ADMIN");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ADEI ARIAS");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ALVARO HERNANDEZ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("ANDER PRIETO");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("JON BARBERO");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_5);
		
		panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnNewButton_16 = new JButton(new ImageIcon("res/homesmall.png"));
		btnNewButton_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel1_0.setVisible(false);
					panel1_0_1.setVisible(false);
				panel1_1.setVisible(false);
				panel1_2.setVisible(false);
				panel1_3.setVisible(false);
				panel1_4.setVisible(false);
					panel1_4_1.setVisible(false);
				panel1_5.setVisible(false);
				panel1_6.setVisible(false);
				panel1_7.setVisible(false);
					panel1_7_1.setVisible(false);
				panel.setVisible(true);
			}
		});
		panel_2.add(btnNewButton_16);
		
		JButton btnNewButton_17 = new JButton(new ImageIcon("res/logoutsmall.png"));
		btnNewButton_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel1_0=null;
				panel1_0_1=null;
				panel1_1=null;
				panel1_2=null;
				panel1_3=null;
				panel1_4=null;
				panel1_4_1=null;
				panel1_5=null;
				panel1_6=null;
				panel1_7=null;
				panel1_7_1=null;
				panel=null;
				Login.loginID="-1000";
				Login loginLogout = new Login();
				loginLogout.setVisible(true);
				setVisible(false);
				//try {konexioa.close();} catch (SQLException e) {JOptionPane.showMessageDialog(null, "Arazoa egon da datu basean. Saiatu berriro.", "AAAJ", JOptionPane.WARNING_MESSAGE);}
			}
		});
		panel_2.add(btnNewButton_17);
		
	}
	
	private void hasieratu1() throws SQLException {
		ResultSet rs = stm.executeQuery("select * FROM erabiltzaile;");
		modelo1.setRowCount(0);
		modelo1.setColumnCount(0);

		modelo1.addColumn("ERABILTZAILE KODEA");
		modelo1.addColumn("DB-KO ERABILTZAILEA");
		modelo1.addColumn("PASAHITZA");
		while (rs.next())
		{
			Object [] fila = new Object[3];
			for (int i=0;i<3;i++) {
					fila[i] = rs.getObject(i+1);}
			modelo1.addRow(fila);
		}			
		Object [] fila = new Object[3];
		if (modelo1.getRowCount()>24) {
			modelo1.addRow(fila);
			modelo1.addRow(fila);
		}
	}

	private void hasieratu2() throws SQLException {
		ResultSet rs = stm.executeQuery("select * from bezero ORDER BY bezero.gune;");
		modelo2.setRowCount(0);
		modelo2.setColumnCount(0);
		// ZUTABEAK SORTU
		modelo2.addColumn("BKODE");
		modelo2.addColumn("GUNE");
		modelo2.addColumn("DENDA IZENA");
		modelo2.addColumn("HELBIDE");
		modelo2.addColumn("TLF");
		modelo2.addColumn("IFZ");
		while (rs.next())
		{
			Object [] fila = new Object[6]; // ALDATU ZUTABE KOP.REN ARABERA
			for (int i=0;i<6;i++)// ALDATU ZUTABE KOP.REN ARABERA
				fila[i] = rs.getObject(i+1);
			modelo2.addRow(fila);
		}			
		Object [] fila = new Object[6];
		if (modelo2.getRowCount()>24) {
			modelo2.addRow(fila);
			modelo2.addRow(fila);
		}
	}
	
	private void hasieratu5() throws SQLException {
		ResultSet rs = stm.executeQuery("select * from eskaera");
		modelo5.setRowCount(0);
		modelo5.setColumnCount(0);
		// ZUTABEAK SORTU
		modelo5.addColumn("ID");
		modelo5.addColumn("BKODE");
		modelo5.addColumn("PKODE");
		modelo5.addColumn("ENTREGATUTA");
		while (rs.next())
		{
			Object [] fila = new Object[4]; // ALDATU ZUTABE KOP.REN ARABERA
			for (int i=0;i<4;i++)// ALDATU ZUTABE KOP.REN ARABERA
				fila[i] = rs.getObject(i+1);
			modelo5.addRow(fila);
		}			
		Object [] fila = new Object[4];
		if (modelo5.getRowCount()>24) {
			modelo5.addRow(fila);
			modelo5.addRow(fila);
		}
	}
	
}
