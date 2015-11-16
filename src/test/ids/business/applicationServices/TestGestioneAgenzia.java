package test.ids.business.applicationServices;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.ids.business.applicationServices.GestioneAgenzie;
import main.ids.transferObjects.AgenziaTO;

public class TestGestioneAgenzia {
	
	GestioneAgenzie gestAgenzie;
	
    @Before
    public void setUp() throws Exception {
    	gestAgenzie = new GestioneAgenzie();
    }

    @After
    public void tearDown() throws Exception {
    	gestAgenzie = null;
    }
	
	
	@Test
	public void testAddNewAgenzia() {
		AgenziaTO agenzia = new AgenziaTO("Torino", "via orabona", "080012345");
		assertTrue("Failed", gestAgenzie.addNewAgenzia(agenzia));
		gestAgenzie.deleteCitta("Torino");
	}
	
	@Test
	public void testGetAgenzia() {
		String[] id = {"1", "70"};
		String[] expected = {"001", null};

		assertEquals("Failed", gestAgenzie.getAgenzia(id[0]).getId(), expected[0]);
		assertEquals("Failed", gestAgenzie.getAgenzia(id[1]), expected[1]);
	}
	
	@Test
	public void testGetManagerOf() {
		String[] id = {"1", "70"};
		String[] expected = {"manag", null};

		assertEquals("Failed", gestAgenzie.getManagerOf(id[0]).getUsername(), expected[0]);
		assertEquals("Failed", gestAgenzie.getManagerOf(id[1]), expected[1]);
	}
	
	@Test
	public void testGetImpiegatiOf() {
		String[] id = {"1", "70"};
		
		assertTrue("Failed", gestAgenzie.getImpiegatiOf(id[0]).size() >= 0);
		assertTrue("Failed", gestAgenzie.getImpiegatiOf(id[1]).size() == 0);
	}
	
	@Test
	public void testUpdate() {
		AgenziaTO agenziaValida = new AgenziaTO("Bari", "via orabona", "080012345");
		agenziaValida.setId("1");
		AgenziaTO agenziaNonValida = new AgenziaTO("Torino", "via orabona", "080012345");
		agenziaNonValida.setId("70");
		
		AgenziaTO[] agenzia = {agenziaValida, agenziaNonValida};
		boolean[] expected = {true, false};
		
		for(int i = 0; i < expected.length; i++){
			assertEquals("Failed at " + i, gestAgenzie.update(agenzia[i]), expected[i]);
		}
		
		AgenziaTO backToNormal = new AgenziaTO("Bari", "via Cavour 5", "080111111");
		backToNormal.setId("1");
		gestAgenzie.update(backToNormal);
	}
	
	@Test
	public void testDeleteCitta() {
		String[] citta = {"Torino", "Londra"};
		boolean[] expected = {true, false};
		
		AgenziaTO agenzia = new AgenziaTO("Torino", "via orabona", "080012345");
		gestAgenzie.addNewAgenzia(agenzia);
		
		for(int i = 0; i < expected.length; i++){
			assertEquals("Failed at " + i, gestAgenzie.deleteCitta(citta[i]), expected[i]);
		}
	}
	
	public void testExists() {
		String[] id = {"1", "70"};
		boolean[] expected = {true, false};
		
		for(int i = 0; i < expected.length; i++){
			assertEquals("Failed at" + i, gestAgenzie.exists(id[i]), expected[i]);
		}
	}
	
}
