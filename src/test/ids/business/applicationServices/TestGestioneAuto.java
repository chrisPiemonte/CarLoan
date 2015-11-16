package test.ids.business.applicationServices;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.ids.business.applicationServices.GestioneAuto;
import main.ids.transferObjects.AutoTO;

public class TestGestioneAuto {
	
	GestioneAuto gestAuto;
	
	@Before
	public void setUp() throws Exception {
		gestAuto = new GestioneAuto();
	}

	@After
	public void tearDown() throws Exception {
		gestAuto = null;
	}

	@Test
	public void testAddNewAuto() {
		AutoTO auto = new AutoTO("qq444qq", "Reanult Twingo", "D", "A", 0, LocalDate.now(), "1");
		boolean[] expected = {true, false};
		
		for(int i = 0; i < expected.length; i++){
			assertEquals("Failed at " + i, gestAuto.addNewAuto(auto), expected[i]);
		}
		gestAuto.delete(auto.getTarga());
	}
	
	@Test
	public void testGetAuto() {
		String[] targa = {"kj088fv", "qq444qq"};
		String[] expected = {"kj088fv", null};

		assertEquals("Failed", gestAuto.getAuto(targa[0]).getTarga(), expected[0]);
		assertEquals("Failed", gestAuto.getAuto(targa[1]), expected[1]);
	}
	
	@Test
	public void testUpdate() {
		AutoTO backToNormal = gestAuto.getAuto("kj088fv");

		AutoTO autoValida = gestAuto.getAuto("kj088fv");
		autoValida.setKm(870);
		AutoTO autoNonValida = new AutoTO("qq444qq", "Reanult Twingo", "D", "A", 0, LocalDate.now(), "1");
		
		AutoTO[] auto = {autoValida, autoNonValida};
		boolean[] expected = {true, false};
		
		for(int i = 0; i < expected.length; i++){
			assertEquals("Failed at " + i, gestAuto.update(auto[i]), expected[i]);
		}
		gestAuto.update(backToNormal);
	}

	public void testExists() {
		String[] targa = {"kj088fv", "qq444qq"};
		boolean[] expected = {true, false};
		
		for(int i = 0; i < expected.length; i++){
			assertEquals("Failed at" + i, gestAuto.exists(targa[i]), expected[i]);
		}
	}
	
	@Test
	public void testChangeStatoOf() {
		String[] targa = {"kj088fv", "kj088fv", "qq444qq", "qq444qq"};
		String[] stato = {"D", "G", "N", "G"};
		boolean[] expected = {true, false, false, false};
		
		for(int i = 0; i < expected.length; i++){
			assertEquals("Failed at " + i, gestAuto.changeStatoOf(targa[i], stato[i]), expected[i]);
		}
	}
	
	@Test
	public void testChangeKmOf() {
		String[] targa = {"kj088fv", "kj088fv", "qq444qq"};
		double[] km = {37, -37, 0};
		boolean[] expected = {true, false, false};
		
		for(int i = 0; i < expected.length; i++){
			assertEquals("Failed at " + i, gestAuto.changeKmOf(targa[i], km[i]), expected[i]);
		}
	}

}
