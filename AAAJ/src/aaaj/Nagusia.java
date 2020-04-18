package aaaj;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Nagusia {
	
	static String zerbitzaria= "jdbc:mysql://remotemysql.com:3306/xyhHfhBzVD";
	static String erabiltzailea= "xyhHfhBzVD"; // mysql
	static String pasahitza= "czXUexDV1z"; // mysql
	private static Connection k;

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		setKonexioa();
		//SISTEMAN SARTU
		Login login = new Login();
		login.setVisible(true);

	}	
	
	public static void setKonexioa() throws SQLException {
		k = DriverManager.getConnection(Nagusia.zerbitzaria, Nagusia.erabiltzailea, Nagusia.pasahitza);
	}
	
	public Connection getKonexioa() {		
		return k;	
	}

}
