package test.ids.business.applicationServices;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.ids.business.applicationServices.GestioneFasce;
import main.ids.transferObjects.FasciaTO;

public class TestGestioneFasce {
	
	GestioneFasce gestFasce;
	
	@Before
	public void setUp() throws Exception {
		gestFasce = new GestioneFasce();
	}

	@After
	public void tearDown() throws Exception {
		gestFasce = null;
	}

	@Test
	public void testAddNewFascia() {
		FasciaTO fascia = new FasciaTO("Z", "Prova", 10, 10, 10);
		boolean[] expected = {true, false};
		
		for(int i = 0; i < expected.length; i++){
			assertEquals("Failed at " + i, gestFasce.addNewFascia(fascia), expected[i]);
		}
		gestFasce.delete(fascia.getId());
	}
	
	@Test
	public void testGetFascia() {
		String[] id = {"A", "Z"};
		String[] expected = {"A", null};

		assertEquals("Failed", gestFasce.getFascia(id[0]).getId(), expected[0]);
		assertEquals("Failed", gestFasce.getFascia(id[1]), expected[1]);
	}
	
	@Test
	public void testUpdate() {
		FasciaTO backToNormal = gestFasce.getFascia("A");

		FasciaTO fasciaValida = gestFasce.getFascia("A");
		fasciaValida.setDescrizione("Test");
		FasciaTO fasciaNonValida = new FasciaTO("Z", "Test", 10, 10, 10);
		
		FasciaTO[] fascia = {fasciaValida, fasciaNonValida};
		boolean[] expected = {true, false};
		
		for(int i = 0; i < expected.length; i++){
			assertEquals("Failed at " + i, gestFasce.update(fascia[i]), expected[i]);
		}
		gestFasce.update(backToNormal);
	}

	public void testExists() {
		String[] id = {"A", "Z"};
		boolean[] expected = {true, false};
		
		for(int i = 0; i < expected.length; i++){
			assertEquals("Failed at" + i, gestFasce.exists(id[i]), expected[i]);
		}
	}
	
}
