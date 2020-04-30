package aaaj;
import static org.junit.Assert.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class Testak {
	
	static Connection konexioa;
	static Statement stm;
	ResultSet rs;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Nagusia.setKonexioa("jdbc:mysql://localhost:3306/AAAJTEST","root","");
		konexioa = Nagusia.getKonexioa();
		stm = konexioa.createStatement();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		konexioa.close();
	}
	
	/*
	 * BEZEROA/GARRAIATZAILEA GEHITU
	 */

	@Test
	public void BezeroGarraiatzaileGehitu() throws SQLException {
		// BEZERO:
		stm.executeUpdate("INSERT INTO erabiltzaile VALUES (1, 'a', 'a');");
		stm.executeUpdate("INSERT INTO bezero VALUES (1, 0, 'DENDAIZENA', 'HELBIDEA',944444444, 'IFZ');");
		rs = stm.executeQuery("SELECT * FROM bezero WHERE bkode = 1;");
		assertTrue(rs.next());
		
		// GARRAIATZAILE:
		stm.executeUpdate("INSERT INTO erabiltzaile VALUES (2, 'b', 'b');");
		stm.executeUpdate("INSERT INTO garraiatzaile VALUES (2, 0, 'IZENA', 'ABIZENA',944444444, 'NAN');");
		rs = stm.executeQuery("SELECT * FROM garraiatzaile WHERE gkode = 2;");
		assertTrue(rs.next());
	}
	
	/*
	 * BEZEROA/GARRAIATZAILEA KENDU
	 */

	@Test
	public void BezeroGarraiatzaileKendu() throws SQLException {
		// BEZERO:
		stm.executeUpdate("DELETE FROM erabiltzaile WHERE erabkodea = 1;");
		stm.executeUpdate("DELETE FROM bezero WHERE bkode = 1;");
		rs = stm.executeQuery("SELECT * FROM bezero WHERE bkode = 1;");
		assertFalse(rs.next());
		
		// GARRAIATZAILE:
		stm.executeUpdate("DELETE FROM erabiltzaile WHERE erabkodea = 2;");
		stm.executeUpdate("DELETE FROM garraiatzaile WHERE gkode = 2;");
		rs = stm.executeQuery("SELECT * FROM garraiatzaile WHERE gkode = 2;");
		assertFalse(rs.next());
	}
	
	/*
	 * BEZERO JAKIN BATEN STOCKA IKUSI
	 */

	@Test
	public void BezeroStockIkusi() throws SQLException {
		
		// BEZERO:
		rs=stm.executeQuery("SELECT stock.pkode,stock.kantitate,produktu.izena,produktu.deskribapena FROM (stock JOIN bezero ON stock.bkode=bezero.bkode) JOIN produktu ON stock.pkode=produktu.pkode where stock.bkode=1;");
		assertTrue(rs.next());
		
	}

	/*
	 * ENTREGATU BEHARREKO ESKAERA GUZTIAK IKUSI
	 */

	@Test
	public void EntregatuBeharrekoEskaeraGuztiakIkusi() throws SQLException {

		rs=stm.executeQuery("SELECT eskaera.id, bezero.bkode, bezero.dendaizena,bezero.helbide,bezero.tlf FROM eskaera JOIN bezero ON eskaera.bkode=bezero.bkode where eskaera.entregatuta=false;");
		assertTrue(rs.next());

	}
	
	/*
	 *  ESKAERAK/BEZEROAK/GARRAIATZAILEAK GUNEKA FILTRATU
	 */

	@Test
	public void GunekaFiltratu() throws SQLException {
		
		//BEZERO:
		rs=stm.executeQuery("SELECT bkode, dendaizena, helbide, tlf, ifz FROM bezero WHERE gune=159;");
		assertFalse(rs.next());
		
		//(ESKAERA):
		rs=stm.executeQuery("SELECT eskaera.* FROM eskaera JOIN bezero ON eskaera.bkode=bezero.bkode WHERE gune=154;");
		assertFalse(rs.next());
		
		//GARRATZAILE:
		rs=stm.executeQuery("SELECT gkode, izena, abizena, tlf, nan FROM garraiatzaile WHERE gune=205;");
		assertFalse(rs.next());
	}
	
	/*
	 *  ESKAERA ID-Z BILATU
	 */

	@Test
	public void EskaeraID() throws SQLException {
		
		rs=stm.executeQuery("SELECT bezero.bkode, bezero.dendaizena, eskatu.pkode, produktu.izena, produktu.deskribapena, eskatu.kantitate FROM ((eskatu JOIN eskaera ON eskatu.id=eskaera.id) JOIN produktu ON eskatu.pkode=produktu.pkode) JOIN bezero on eskaera.bkode=bezero.bkode WHERE eskatu.id=17890178900987;");
		assertFalse(rs.next());	
		
	}
	
	/*
	 *  ESKAEREN HISTORIALA BISTARATU 
	 */

	@Test
	public void EskaerenHistoriala() throws SQLException {
		
		rs=stm.executeQuery("SELECT eskaera.id, bezero.bkode, bezero.dendaizena, eskatu.pkode, produktu.izena, produktu.deskribapena, eskatu.kantitate, eskaera.entregatuta FROM ((eskatu JOIN eskaera ON eskatu.id=eskaera.id) JOIN produktu ON eskatu.pkode=produktu.pkode) JOIN bezero ON eskaera.bkode=bezero.bkode;");
		assertTrue(rs.next());
		
	}
	
	/*
	 *	BEZERO/GARRAIATZAILEAREN INFORMAZIOA BISTARATU 
	 */

	@Test
	public void InformazioaBistaratu() throws SQLException {
		
		//BEZERO:
		rs=stm.executeQuery("select * from bezero where bkode=1;");
		assertTrue(rs.next());
		
		//GARRAIATZAILE: 
		rs=stm.executeQuery("select * from garraiatzaile where gkode=1;");
		assertTrue(rs.next());
		
	}
	
	/*
	 *	ORGAN SARTU
	 */

	@Test
	public void OrganSartu() throws SQLException {
		
		stm.executeUpdate("INSERT INTO eskatu VALUES ('1','1', 1)");
		rs=stm.executeQuery("SELECT * FROM eskaera where id=1");
		assertTrue(rs.next());	
		
	}
	
	/*
	 *	ORGA HUSTU 
	 */

	@Test
	public void OrgaHustu() throws SQLException {
		
		stm.executeUpdate("DELETE FROM eskaera WHERE id=1");
		rs=stm.executeQuery("SELECT * FROM eskaera where id=1");
		assertFalse(rs.next());
		
	}
	
	/*
	 *	ESKAERA EZEZTATU
	 */

	@Test
	public void EskaeraEzeztatu() throws SQLException {
		
		stm.executeUpdate("DELETE FROM eskaera WHERE id=2 AND entregatuta=false");
		rs=stm.executeQuery("SELECT * FROM eskaera where id=2");
		assertFalse(rs.next());
		
	}
	
	/*
	 *	PRODUKTUEN LISTA IKUSI
	 */

	@Test
	public void ProduktuakIkusi() throws SQLException {
		
		rs=stm.executeQuery("SELECT * FROM produktu");
		assertTrue(rs.next());
		
	}
	
	/*
	 *	PRODUKTUA STOCK-EAN SARTU
	 */

	@Test
	public void ProduktuaStock() throws SQLException {
		
		stm.executeUpdate("INSERT INTO stock VALUES (145678,6789,1)");
		rs=stm.executeQuery("SELECT * FROM stock where eskBkode=145678");
		assertFalse(rs.next());
		
	}
	
	/*
	 *	GARRAIATZAILE TELEFONOA ALDATU
	 */

	@Test
	public void GarraiatzaileAldatu() throws SQLException {
		
		//GARRAIATZAILE
		stm.executeUpdate("UPDATE `garraiatzaile` SET `tlf` =  666666666 WHERE `garraiatzaile`.`gkode`=1");
		rs=stm.executeQuery("SELECT * FROM garratzaile where tlf=666666666");
		assertTrue(rs.next());
		
	}
	
	/*
	 *	LISTAN DAGO
	 */

	@Test
	public void IDListanDago() throws SQLException {

		rs=stm.executeQuery("SELECT eskaera.bkode FROM eskatu JOIN eskaera ON eskatu.id = eskaera.id where eskatu.id =132469098630");
		assertFalse(rs.next());
		
	}
}
