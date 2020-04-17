package aaaj;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;

public class Bezero extends JFrame {

	private static final long serialVersionUID = 1L;
	Connection konexioa;
	Statement stm;
	private JPanel contentPane,panel,panel_0,panel_0_4,panel_0_5,panel_0_6,panel_1,panel1_1,panel1_1_1,panel1_2;
	private JPanel panel1_3,panel1_3_1,panel_2,panel_3;

	private static boolean panel1_0bool=false;
	private static boolean eskaerabool=false;
	private static String eskaeraid="";
	private static boolean panel1_1bool=false;
	private static boolean panel1_2bool=false;
	private static boolean panel1_3bool=false;
	private DefaultTableModel modelo1;
	private JTable tabla1; 
	String izena_datuak="";
	String bkode_datuak="";
	String gune_datuak="";
	String helbidea_datuak="";
	String tlf_datuak="";
	String ifz_datuak="";
	JLabel lblNewLabel_1,lblNewLabel_2,lblNewLabel_3,lblNewLabel_4,lblNewLabel_5,lblNewLabel_6;
	private DefaultTableModel modelo_0;
	private DefaultTableModel modelo0_1;
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bezero frame = new Bezero();
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Arazoa egon da datu basean. Saiatu berriro.", "AAAJ", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	}*/

	public Bezero() throws SQLException {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("res/aj.png"));
		setTitle("BEZERO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try { konexioa.close();	} catch (SQLException e1) {	e1.printStackTrace();	}
                System.exit(0);
            }
        });
		setBounds(100, 100, 800, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		konexioa= DriverManager.getConnection(Nagusia.zerbitzaria, Nagusia.erabiltzailea, Nagusia.pasahitza);
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
			ResultSet rs = stm.executeQuery("select * from bezero where bkode=" + Login.loginID+";");
			while (rs.next()) {
				bkode_datuak=rs.getString(1);
				gune_datuak=rs.getString(2);
				izena_datuak=rs.getString(3);
				helbidea_datuak=rs.getString(4);
				tlf_datuak=rs.getString(5);
				ifz_datuak=rs.getString(6);
			}
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Arazoa egon da datu basean. Saiatu berriro.", "AAAJ", JOptionPane.WARNING_MESSAGE);
		}

	}
	
	private void aukera0() {	
		
		panel_0 = new JPanel();
		panel_0.setLayout(new GridLayout(0, 1, 10, 10));
		
		
		modelo_0 = new DefaultTableModel() {					
			private static final long serialVersionUID = 1L;
			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		JTable tabla = new JTable(modelo_0);
		tabla.getTableHeader().setReorderingAllowed(false);
		
		panel_0_4 = new JPanel();
		panel_0_4.setBorder(new EmptyBorder(50, 100, 0, 100));
		panel_0.add(panel_0_4);
		panel_0_4.setLayout(new BorderLayout(0, 0));
		
		modelo0_1 = new DefaultTableModel(){					
			private static final long serialVersionUID = 1L;
			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		modelo0_1.addColumn("ID");
		modelo0_1.addColumn("KANTITATE");
		JTable tabla0_1 = new JTable(modelo0_1);
		tabla0_1.getTableHeader().setReorderingAllowed(false);
		
		panel_0_5 = new JPanel();
		panel_0_4.add(panel_0_5, BorderLayout.WEST);
		GridBagLayout gbl_panel_0_5 = new GridBagLayout();
		gbl_panel_0_5.columnWidths = new int[]{0, 0};
		gbl_panel_0_5.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_0_5.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_0_5.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_0_5.setLayout(gbl_panel_0_5);
		
		JButton btnNewButton = new JButton("PRODUKTUEN ESKAERA EGIN");
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.add(panel_0, BorderLayout.CENTER);
				panel.setVisible(false);				
				panel_0.setVisible(true);
				panel_0_4.setVisible(true);
				panel_0_5.setVisible(true);
				try {
					hasieratu0();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}

				if (!panel1_0bool) {
					JScrollPane js0=new JScrollPane(tabla);
					js0.setVisible(true);
					tabla0_1.getColumnModel().getColumn(0).setMinWidth(40);
					tabla0_1.getColumnModel().getColumn(0).setMaxWidth(40);
					tabla0_1.getColumnModel().getColumn(0).setPreferredWidth(40);

					js0.setPreferredSize(new Dimension(200,200));

					tabla0_1.getColumnModel().getColumn(0).setMinWidth(40);
					tabla0_1.getColumnModel().getColumn(0).setMaxWidth(40);
					tabla0_1.getColumnModel().getColumn(0).setPreferredWidth(40);

					
					JScrollPane js0_1=new JScrollPane(tabla0_1);
					js0_1.setVisible(true);
					js0_1.setPreferredSize(new Dimension(200,200));// 400, 600 );
					
					
					JLabel lblNewLabel_0_5 = new JLabel("Sartu produktuaren IDa");
					GridBagConstraints gbc_lblNewLabel_0_5 = new GridBagConstraints();
					gbc_lblNewLabel_0_5.insets = new Insets(0, 0, 5, 0);
					gbc_lblNewLabel_0_5.gridx = 0;
					gbc_lblNewLabel_0_5.gridy = 0;
					panel_0_5.add(lblNewLabel_0_5, gbc_lblNewLabel_0_5);
					
					JTextField textField_0_0 = new JTextField();
					textField_0_0.setColumns(10);
					GridBagConstraints gbc_textField = new GridBagConstraints();
					gbc_textField.insets = new Insets(0, 0, 5, 0);
					gbc_textField.fill = GridBagConstraints.HORIZONTAL;
					gbc_textField.gridx = 0;
					gbc_textField.gridy = 1;
					panel_0_5.add(textField_0_0, gbc_textField);
					
					JLabel lblNewLabel_0_6 = new JLabel("Sartu kantitatea");
					GridBagConstraints gbc_lblNewLabel_0_6 = new GridBagConstraints();
					gbc_lblNewLabel_0_6.insets = new Insets(0, 0, 5, 0);
					gbc_lblNewLabel_0_6.gridx = 0;
					gbc_lblNewLabel_0_6.gridy = 2;
					panel_0_5.add(lblNewLabel_0_6, gbc_lblNewLabel_0_6);
					
					JTextField textField_0_1 = new JTextField();
					textField_0_1.setColumns(10);
					GridBagConstraints gbc_textField_0_1 = new GridBagConstraints();
					gbc_textField_0_1.insets = new Insets(0, 0, 5, 0);
					gbc_textField_0_1.fill = GridBagConstraints.HORIZONTAL;
					gbc_textField_0_1.gridx = 0;
					gbc_textField_0_1.gridy = 3;
					panel_0_5.add(textField_0_1, gbc_textField_0_1);
					
					JButton btnNewButton = new JButton("Produktua orgara gehitu");
					GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
					gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
					gbc_btnNewButton.gridx = 0;
					gbc_btnNewButton.gridy = 4;
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							String queryUpdate="";
							String produktuID=textField_0_0.getText();
							String produktuKantitatea=textField_0_1.getText();
							textField_0_0.setText("");
							textField_0_1.setText("");
							
							if(!eskaerabool) {
								try {/*
									ResultSet rsID = stm.executeQuery("select id from eskaera;");
									rsID.last();*/
									long unixTime = System.currentTimeMillis() / 1000L;
									eskaeraid=Integer.toString((int)unixTime).substring(3);
									
									queryUpdate = "INSERT INTO eskaera VALUES (" + eskaeraid + ", " + bkode_datuak + ", null, false);";
									eskaerabool=true;
									stm.executeUpdate(queryUpdate);		
								} 
								catch (SQLException e) {
									JOptionPane.showMessageDialog(null, "Arazoa egon da datu basean. Saiatu berriro.", "AAAJ", JOptionPane.WARNING_MESSAGE);
								}
								
							}
							// eskatu -> id, pkode, kantitate
							queryUpdate = "INSERT INTO eskatu VALUES (" + eskaeraid + ", " + produktuID + ", "+ produktuKantitatea +");";
							Object [] produktuagehitu = new Object [2];
							produktuagehitu[0] = produktuID;
							produktuagehitu[1] = produktuKantitatea;
							modelo0_1.addRow(produktuagehitu);
							
							Object [] fila = new Object[2];
							if (modelo0_1.getRowCount()>24) {
								modelo0_1.addRow(fila);
								modelo0_1.addRow(fila);
							}
							
							try {	
								stm.executeUpdate(queryUpdate);		
							} 
							catch (SQLException e) {
								JOptionPane.showMessageDialog(null, "Arazoa egon da datu basean. Saiatu berriro.", "AAAJ", JOptionPane.WARNING_MESSAGE);
							}
						}
					});
					panel_0_5.add(btnNewButton, gbc_btnNewButton);
					
					JSeparator separator = new JSeparator();
					GridBagConstraints gbc_separator = new GridBagConstraints();
					gbc_separator.insets = new Insets(0, 0, 5, 0);
					gbc_separator.gridx = 0;
					gbc_separator.gridy = 5;
					panel_0_5.add(separator, gbc_separator);
					
					JSeparator separator_1 = new JSeparator();
					GridBagConstraints gbc_separator_1 = new GridBagConstraints();
					gbc_separator_1.insets = new Insets(0, 0, 5, 0);
					gbc_separator_1.gridx = 0;
					gbc_separator_1.gridy = 6;
					panel_0_5.add(separator_1, gbc_separator_1);
					
					JButton btnNewButton_1 = new JButton("Erosketako orga hustu");
					GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
					gbc_btnNewButton_1.gridx = 0;
					gbc_btnNewButton_1.gridy = 7;
					btnNewButton_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							if (!eskaeraid.equals("")) {
								try {	
									String queryUpdate = "delete from eskaera where id=" + eskaeraid + ";";
									eskaeraid="";
									eskaerabool=false;
									modelo0_1.setRowCount(0);
									textField_0_0.setText("");
									textField_0_1.setText("");
									stm.executeUpdate(queryUpdate);		
								} 
								catch (SQLException e) {
									JOptionPane.showMessageDialog(null, "Arazoa egon da datu basean. Saiatu berriro.", "AAAJ", JOptionPane.WARNING_MESSAGE);
								}
							}
						}
					});
					panel_0_5.add(btnNewButton_1, gbc_btnNewButton_1);
					
					JButton btnNewButton_2 = new JButton("EROSI");
					GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
					gbc_btnNewButton_2.gridx = 0;
					gbc_btnNewButton_2.gridy = 8;
					btnNewButton_2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							if (!eskaeraid.equals("")) {
								textField_0_0.setText("");
								textField_0_1.setText("");
								JOptionPane.showMessageDialog(null, "Erosita!", "AAAJ",JOptionPane.DEFAULT_OPTION);
								eskaeraid="";
								modelo0_1.setRowCount(0);
							}
						}
					});
					panel_0_5.add(btnNewButton_2, gbc_btnNewButton_2);
					
					
					panel_0_6 = new JPanel();
					panel_0_4.add(panel_0_6, BorderLayout.EAST);
					
					panel_0_6.add(js0_1);
					
					panel_0.add(js0);
					
					
					
				}
				panel1_0bool=true;
			}
		});
		panel.add(btnNewButton);
	
	}
	
	private void aukera1() {	
		
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
		
		JButton btnNewButton_1 = new JButton("ESKAERA EZEZTATU");
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
				
						JLabel lblNewLabel_panel1_1 = new JLabel("Sartu ezabatu nahi duzun eskaeraren IDa:   ");
						panel1_1_1.add(lblNewLabel_panel1_1);
				
						JTextField textField_panel1_1 = new JTextField();
						panel1_1_1.add(textField_panel1_1);
						textField_panel1_1.setColumns(10);
		
						JLabel lblNewLabel_panel1_1_1 = new JLabel("   ");
						panel1_1_1.add(lblNewLabel_panel1_1_1);
		
						JButton btnNewButton_panel1_1 = new JButton("EZABATU");
						btnNewButton_panel1_1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								String eskaeraID=textField_panel1_1.getText();
								try {
									String queryUpdate="delete from eskaera where id="+eskaeraID+";";
									stm.executeUpdate(queryUpdate);
									JOptionPane.showMessageDialog(null, "Eskaera ezeztatuta!", "AAAJ",JOptionPane.DEFAULT_OPTION);
									modelo1.setRowCount(0);
									modelo1.setColumnCount(0);
									hasieratu1();
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
	
	private void aukera2() {	
			
		panel1_2 = new JPanel();
		
		JButton btnNewButton_2 = new JButton("KATALOGOA IKUSI");
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
					private static final long serialVersionUID = 1L;
					@Override
				    public boolean isCellEditable(int row, int column) {
				       //all cells false
				       return false;
				    }
				};
				
				JTable tabla2 = new JTable(modelo2);
				tabla2.getTableHeader().setReorderingAllowed(false);
				modelo2.addColumn("id");
				modelo2.addColumn("izena");
				modelo2.addColumn("deskribapena");
				modelo2.addColumn("prezioa");
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
				
				Object [] fila = new Object[4];
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
				
				////////////////////////
				}
				panel1_2bool=true;
			}
		});
		panel.add(btnNewButton_2);

	}
	
	private void aukera3() {	
		
		panel1_3 = new JPanel();
		panel1_3_1 = new JPanel();
		
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
				
				JLabel lbldatuak_2 = new JLabel("HELBIDEA");
				panel1_3_1.add(lbldatuak_2);
				
				JTextField textField_2 = new JTextField(helbidea_datuak);
				textField_2.setColumns(25);
				panel1_3_1.add(textField_2);
				
				JLabel lblesp_2 = new JLabel("");
				lblesp_2.setPreferredSize(new Dimension(300, 10));
				panel1_3_1.add(lblesp_2);
				
				//
				
				JLabel lbldatuak_3 = new JLabel("TELEFONOA");
				panel1_3_1.add(lbldatuak_3);
				
				JTextField textField_3 = new JTextField(tlf_datuak);
				textField_3.setColumns(25);
				panel1_3_1.add(textField_3);
				
				JLabel lblesp_3 = new JLabel("");
				lblesp_3.setPreferredSize(new Dimension(300, 10));
				panel1_3_1.add(lblesp_3);
				
				//
				
				JLabel lbldatuak_4 = new JLabel("GUNEA");
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
							lblNewLabel_1.setText(izena_datuak);
							queryUpdate = "UPDATE `bezero` SET `dendaizena` = '"+ izena_datuak +"' WHERE `bezero`.`bkode` = "+bkode_datuak+";";
							
							try {
								stm.executeUpdate(queryUpdate);
							} catch (SQLException e) {
								JOptionPane.showMessageDialog(null, "Arazoa egon da datu basean. Saiatu berriro.", "AAAJ", JOptionPane.WARNING_MESSAGE);
							}
						}
						
						if (!textField_2.getText().equals(helbidea_datuak) ){
							helbidea_datuak=textField_2.getText();
							helbidea_datuak=helbidea_datuak.toUpperCase();
							lblNewLabel_6.setText(helbidea_datuak);
							queryUpdate = "UPDATE `bezero` SET `helbide` = '"+ helbidea_datuak +"' WHERE `bezero`.`bkode` = "+bkode_datuak+";";
							
							try {
								stm.executeUpdate(queryUpdate);
							} catch (SQLException e) {
								JOptionPane.showMessageDialog(null, "Arazoa egon da datu basean. Saiatu berriro.", "AAAJ", JOptionPane.WARNING_MESSAGE);
							}
						}
						
						if (!textField_3.getText().equals(tlf_datuak) ){
							tlf_datuak=textField_3.getText();
							lblNewLabel_5.setText("TLF: " + tlf_datuak);
							queryUpdate = "UPDATE `bezero` SET `tlf` = "+ tlf_datuak +" WHERE `bezero`.`bkode` = "+bkode_datuak+";";
							
							try {
								stm.executeUpdate(queryUpdate);
							} catch (SQLException e) {
								JOptionPane.showMessageDialog(null, "Arazoa egon da datu basean. Saiatu berriro.", "AAAJ", JOptionPane.WARNING_MESSAGE);
							}
						}
						
						if (!textField_4.getText().equals(gune_datuak) ){
							gune_datuak=textField_4.getText();
							lblNewLabel_4.setText("GUNE: "+gune_datuak);
							queryUpdate = "UPDATE `bezero` SET `gune` = "+ gune_datuak +" WHERE `bezero`.`bkode` = "+bkode_datuak+";";
							
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
	lblNewLabel_1 = new JLabel(izena_datuak);			
	lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
	lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	panel_3.add(lblNewLabel_1);
	
	// helb
	lblNewLabel_6 = new JLabel("HELBIDEA: " + helbidea_datuak);		
	lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
	panel_3.add(lblNewLabel_6);
	
	// bkodeA
	lblNewLabel_2 = new JLabel("BKODE: " + bkode_datuak);		
	lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
	panel_3.add(lblNewLabel_2);
	
	// IFZ		
	lblNewLabel_3 = new JLabel("IFZ: " + ifz_datuak);			
	lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
	panel_3.add(lblNewLabel_3);
	
	// GUNEA
	lblNewLabel_4 = new JLabel("GUNE: " + gune_datuak);
	lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
	panel_3.add(lblNewLabel_4);
	
	// TLF
	lblNewLabel_5 = new JLabel("TLF: " + tlf_datuak);
	lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
	panel_3.add(lblNewLabel_5);
		
		
		panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnNewButton_6 = new JButton(new ImageIcon("res/homesmall.png"));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_0.setVisible(false);
					panel_0_4.setVisible(false);
					panel_0_5.setVisible(false);
				panel1_1.setVisible(false);
					panel1_1_1.setVisible(false);
				panel1_2.setVisible(false);
				panel1_3.setVisible(false);
				panel.setVisible(true);
			}
		});
		panel_2.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton(new ImageIcon("res/logoutsmall.png"));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_0=null;
				panel_0_4=null;
				panel_0_5=null;
				panel1_1=null;
				panel1_1_1=null;
				panel1_2=null;
				panel1_3=null;
				panel=null;
				Login.loginID="-1000";
				Login loginLogout = new Login();
				loginLogout.setVisible(true);
				setVisible(false);
				try {konexioa.close();} catch (SQLException e) {JOptionPane.showMessageDialog(null, "Arazoa egon da datu basean. Saiatu berriro.", "AAAJ", JOptionPane.WARNING_MESSAGE);}
			}
		});
		panel_2.add(btnNewButton_7);
	}
	
	private void hasieratu0() throws SQLException {
		Connection konexioa= DriverManager.getConnection(Nagusia.zerbitzaria, Nagusia.erabiltzailea, Nagusia.pasahitza);
		Statement stm = konexioa.createStatement();
		
		ResultSet rs = stm.executeQuery("select * from produktu;");
		
		
		modelo_0.setRowCount(0);
		modelo_0.setColumnCount(0);
		
		modelo_0.addColumn("id");
		modelo_0.addColumn("izena");
		modelo_0.addColumn("deskr");

		while (rs.next())
		{
		   Object [] fila = new Object[3];
		   for (int i=0;i<3;i++)
		      fila[i] = rs.getObject(i+1);
		   modelo_0.addRow(fila);
		}
		
		Object [] fila = new Object[3];
		if (modelo_0.getRowCount()>24) {
			modelo_0.addRow(fila);
			modelo_0.addRow(fila);
		}		
	}
	
	private void hasieratu1() throws SQLException {
		ResultSet rs = stm.executeQuery("select eskaera.id,eskaera.entregatuta,bezero.bkode,bezero.gune,eskatu.pkode,eskatu.kantitate,"
				+ "produktu.izena,produktu.deskribapena from ((eskaera join bezero on eskaera.bkode=bezero.bkode) JOIN eskatu on eskaera.id=eskatu.id) "
				+ "JOIN produktu on eskatu.pkode=produktu.pkode where bezero.bkode="+bkode_datuak+";");
		modelo1.setRowCount(0);
		modelo1.setColumnCount(0);
		// ZUTABEAK SORTU
		modelo1.addColumn("ID");
		modelo1.addColumn("ENTREGATUTA");
		modelo1.addColumn("BKODE");
		modelo1.addColumn("BGUNE");
		modelo1.addColumn("PKODE");
		modelo1.addColumn("KANTITATE");
		modelo1.addColumn("IZENA");
		modelo1.addColumn("DESKR");
		

		tabla1.getColumnModel().getColumn(0).setMinWidth(56);
		tabla1.getColumnModel().getColumn(0).setMaxWidth(56);
		tabla1.getColumnModel().getColumn(0).setPreferredWidth(56);
		
		tabla1.getColumnModel().getColumn(1).setMinWidth(30);
		tabla1.getColumnModel().getColumn(1).setMaxWidth(30);
		tabla1.getColumnModel().getColumn(1).setPreferredWidth(30);
		
		tabla1.getColumnModel().getColumn(2).setMinWidth(56);
		tabla1.getColumnModel().getColumn(2).setMaxWidth(56);
		tabla1.getColumnModel().getColumn(2).setPreferredWidth(56);
		
		tabla1.getColumnModel().getColumn(3).setMinWidth(40);
		tabla1.getColumnModel().getColumn(3).setMaxWidth(40);
		tabla1.getColumnModel().getColumn(3).setPreferredWidth(40);
		
		tabla1.getColumnModel().getColumn(4).setMinWidth(40);
		tabla1.getColumnModel().getColumn(4).setMaxWidth(40);
		tabla1.getColumnModel().getColumn(4).setPreferredWidth(40);
		
		tabla1.getColumnModel().getColumn(5).setMinWidth(30);
		tabla1.getColumnModel().getColumn(5).setMaxWidth(30);
		tabla1.getColumnModel().getColumn(5).setPreferredWidth(30);

		while (rs.next())
		{
			Object [] fila = new Object[8];
			for (int i=0;i<8;i++) {
					fila[i] = rs.getObject(i+1);}
			modelo1.addRow(fila);
		}			
		Object [] fila = new Object[8];
		if (modelo1.getRowCount()>24) {
			modelo1.addRow(fila);
			modelo1.addRow(fila);
		}
	}
	
	

}
