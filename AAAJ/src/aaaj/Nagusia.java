package aaaj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Nagusia {
	
	static String zerbitzaria= "jdbc:mysql://remotemysql.com:3306/fOZj7JO0X4";
	static String erabiltzailea= "fOZj7JO0X4"; // mysql
	static String pasahitza= "eHiAgxvLE4"; // mysql
	
	static String sistemakoErab;
	static int sistemakoID;

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		//Connection konexioa= DriverManager.getConnection(zerbitzaria, erabiltzailea, pasahitza);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//SISTEMAN SARTU
		
		
		Login login = new Login();
		login.setVisible(true);
	
		
		
	}

	private static void login(Connection konexioa) throws SQLException, IOException {
		System.out.println();
		Statement stm = konexioa.createStatement();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Sartu erabiltzailea:");
		String erab = br.readLine();
		sistemakoErab=erab;
		
		System.out.println("Sartu pasahitza:");
		String pw = br.readLine();
		
		try {
			String query="select * from erabiltzaile where user='" + erab + "' and password='" + pw + "';";
			//System.out.println(query);
			ResultSet rs = stm.executeQuery(query);
			if (rs.next()) {
				System.out.println("Zuzen! Sisteman sartu zara.");
				
				sistemakoID=Integer.parseInt(rs.getString(1));
				
			}
			else {System.out.println("Gaizki. Sartu datuak berriro");
			login(konexioa);
			}
			
		}	catch(Exception e) {
			System.out.println("Arazoa egon da datua sartzean. Saiatu berriro.");};

		
	}
	
	private static int mota(Connection konexioa) throws SQLException, IOException {
		Statement stm = konexioa.createStatement();
	
		//try {
			String query="select * from bezero where bkode='" + sistemakoID + "';";
			
			ResultSet rs = stm.executeQuery(query);
			if (rs.next()) { // BEZEROA BADA
				return 1;				
			}
			else {
				query="select * from garraiatzaile where gkode='" + sistemakoID + "';";
				rs = stm.executeQuery(query);
				if (rs.next()) { // GARRAIATZAILEA BADA
					return 2;				
				}
				else return 0; // ADMIN BADA
			}
			
		//}	catch(Exception e) {
		//	System.out.println("Arazoa egon da.");};
			
		//return 99;
	}
	
	

	public static void menu(Connection konexioa) throws SQLException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String lerroa;
		int num=99;
		while (num!=0) {
			lerroa = br.readLine();
			try {
			num = Integer.parseInt(lerroa);
			}catch(Exception e){num=-1;}
			switch(num) {
				case 1:
					
					break;
				case 2:
					
					break;
				case 3:
					
					break;
				case 4:
					
					break;
				default:   
			}	
		}
	}
	
	private static void menu() {
		System.out.println("");
		System.out.println("+---------------+");
		System.out.println("|     MENUA     |");
		System.out.println("+---------------+");
		System.out.println("");
		System.out.println("Aukeratu:");
		System.out.println("Zer egin nahi duzu?");
		System.out.println("> 1) ");
		System.out.println("> 2) ");
		System.out.println("> 3) ");
		System.out.println("> 4) ");
		System.out.println("> 5) ");
		System.out.println("> 6) ");
		System.out.println("> 7) ");
		System.out.println("> 8) ");
		System.out.println("> 9) ");
		System.out.println("> 10) ");
		System.out.println("> 0) Irten");
		System.out.println();	
	}
	
	private static void gMenu(Connection konexioa) {
		System.out.println("");
		System.out.println("+---------------+");
		System.out.println("|     MENUA     |");
		System.out.println("+---------------+");
		System.out.println("");
		System.out.println("Aukeratu:");
		System.out.println("Zer egin nahi duzu?");
		System.out.println("> 1) Bere guneko eskaerak ikusi");
		System.out.println("> 2) Eskaera bat entregatu");
		System.out.println("> 3) Bere datuak aldatu");
		System.out.println("> 0) Irten");
		System.out.println();	
	}
	
	private static void bMenu(Connection konexioa) {
		System.out.println("");
		System.out.println("+---------------+");
		System.out.println("|     MENUA     |");
		System.out.println("+---------------+");
		System.out.println("");
		System.out.println("Aukeratu:");
		System.out.println("Zer egin nahi duzu?");
		System.out.println("> 1) Produktuen eskaera egin");
		System.out.println("> 2) Eskaera ezeztatu");
		System.out.println("> 3) Katalogoa ikusi");
		System.out.println("> 4) Bere datuak aldatu");
		System.out.println("> 0) Irten");
		System.out.println();	
	}
	
	private static void adminMenu(Connection konexioa) {
		System.out.println("");
		System.out.println("+---------------+");
		System.out.println("|     MENUA     |");
		System.out.println("+---------------+");
		System.out.println("");
		System.out.println("Aukeratu:");
		System.out.println("Zer egin nahi duzu?");
		System.out.println("> 1) Bezero/garraiatzailea gehitu");
		System.out.println("> 2) Bezero/garraiatzailea kendu");
		System.out.println("> 3) Bezero jakin baten stocka ikusi");
		System.out.println("> 4) Entregatu beharreko eskaera guztiak ikusi");
		System.out.println("> 5) Eskaerak/bezeroak/garraiolariak guneka filtratu");
		System.out.println("> 6) Eskaera jakin bat bistaratu");
		System.out.println("> 7) Eskaeren historiala bistaratu");
		System.out.println("> 8) Bezero/garraiatzaileen informazioa bistaratu");
		System.out.println("> 0) Irten");
		System.out.println();	
	}
	

}
