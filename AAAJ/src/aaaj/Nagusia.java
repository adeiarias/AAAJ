package aaaj;

import java.io.IOException;
import java.sql.SQLException;

public class Nagusia {
	
	static String zerbitzaria= "jdbc:mysql://remotemysql.com:3306/xyhHfhBzVD";
	static String erabiltzailea= "xyhHfhBzVD"; // mysql
	static String pasahitza= "czXUexDV1z"; // mysql

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//SISTEMAN SARTU
		Login login = new Login();
		login.setVisible(true);

	}	

}
