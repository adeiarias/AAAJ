package aaaj;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
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

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
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
	
	

}
