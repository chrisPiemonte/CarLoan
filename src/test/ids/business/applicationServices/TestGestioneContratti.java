package test.ids.business.applicationServices;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.ids.business.applicationServices.GestioneContratti;

public class TestGestioneContratti {
	
	GestioneContratti gestContratti;
	
	@Before
	public void setUp() throws Exception {
		gestContratti = new GestioneContratti();
	}

	@After
	public void tearDown() throws Exception {
		gestContratti = null;
	}

	@Test
	public void testGetContratto() {
		String[] id = {"1", "100"};
		String[] expected = {"1", null};

		assertEquals("Failed", gestContratti.getContratto(id[0]).getId(), expected[0]);
		assertEquals("Failed", gestContratti.getContratto(id[1]), expected[1]);
	}

	@Test
	public void testExists() {
		String[] id = {"1", "100"};
		boolean[] expected = {true, false};
		
		for(int i = 0; i < expected.length; i++){
			assertEquals("Failed at " + i, gestContratti.exists(id[i]), expected[i]);
		}
	}
	
	@Test
	public void testChangeModNoleggio() {
		String[] id = {"1", "1", "100"};
		String[] modNoleggio = {"giornaliero", "mensile", "giornaliero"};
		boolean[] expected = {true, false, false};
		
		for(int i = 0; i < expected.length; i++){
			assertEquals("Failed at " + i, gestContratti.changeModNoleggio(id[i], modNoleggio[i]), expected[i]);
		}
	}
	
	@Test
	public void testDataFine() {
		String[] id = {"1", "100"};
		LocalDate[] dataFine = {LocalDate.now(), LocalDate.now()};
		boolean[] expected = {true, false};
		
		for(int i = 0; i < expected.length; i++){
			assertEquals("Failed at " + i, gestContratti.changeDataFine(id[i], dataFine[i]), expected[i]);
		}
	}
	
	@Test
	public void testAgenziaFine() {
		String[] id = {"1", "1", "100"};
		String[] agenziaFine = {"1", "70", "1"};
		boolean[] expected = {true, false, false};
		
		for(int i = 0; i < expected.length; i++){
			assertEquals("Failed at " + i, gestContratti.changeAgenziaFine(id[i], agenziaFine[i]), expected[i]);
		}
	}
	
	@Test
	public void testChiudiContratto() {
		String[] id = {"1", "100", "1", "1", "1"};
		String[] impiegatoFine = {"RBRBRS13G71F145H", "RBRBRS13G71F145H", "", "BBBBBBBBIBBBBBBB", "RBRBRS13G71F145H"};
		double[] kmPercorsi = {10, 10, 10, -10, 10};
		double[] totale = {10, 10, 10, 10, -10};
		boolean[] expected = {true, false, false, false, false};
		
		for(int i = 0; i < expected.length; i++){
			assertEquals("Failed at " + i, 
					gestContratti.chiudiContratto(id[i], impiegatoFine[i], kmPercorsi[i], totale[i]), expected[i]);
		}
	}
	
}
