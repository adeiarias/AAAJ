package aaaj;

import java.io.IOException;
import java.sql.SQLException;

public class Nagusia {
	
	static String zerbitzaria= "jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7333994";
	static String erabiltzailea= "sql7333994"; // mysql
	static String pasahitza= "DdkjPEkHYL"; // mysql

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//SISTEMAN SARTU
		Login login = new Login();
		login.setVisible(true);

	}	

}
