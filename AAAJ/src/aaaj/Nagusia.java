package aaaj;

import java.io.IOException;
import java.sql.SQLException;

public class Nagusia {
	
	static String zerbitzaria= "jdbc:mysql://remotemysql.com:3306/fOZj7JO0X4";
	static String erabiltzailea= "fOZj7JO0X4"; // mysql
	static String pasahitza= "eHiAgxvLE4"; // mysql

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//SISTEMAN SARTU
	
		Login login = new Login();
		login.setVisible(true);

	}	

}
