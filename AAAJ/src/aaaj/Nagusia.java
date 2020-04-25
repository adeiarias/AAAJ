package aaaj;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Nagusia {
	
	
	private static Connection k;

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String zerbitzaria= "jdbc:mysql://remotemysql.com:3306/xyhHfhBzVD";
		String erabiltzailea= "xyhHfhBzVD"; // mysql
		String pasahitza= "czXUexDV1z"; // mysql
		setKonexioa(zerbitzaria,erabiltzailea,pasahitza);
		//SISTEMAN SARTU
		Login login = new Login();
		login.setVisible(true);

	}	
	
	public static void setKonexioa(String zerbitzaria, String erabiltzailea, String pasahitza) throws SQLException {
		k = DriverManager.getConnection(zerbitzaria, erabiltzailea, pasahitza);
	}
	
	public static Connection getKonexioa() {		
		return k;	
	}

}
