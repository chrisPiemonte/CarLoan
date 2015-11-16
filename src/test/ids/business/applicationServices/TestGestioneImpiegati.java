package test.ids.business.applicationServices;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.ids.business.applicationServices.GestioneAccount;
import main.ids.business.applicationServices.GestioneImpiegati;
import main.ids.transferObjects.AccountTO;
import main.ids.transferObjects.ImpiegatoTO;

public class TestGestioneImpiegati {
	
	GestioneImpiegati gestImpiegati;
	
	@Before
	public void setUp() throws Exception {
		gestImpiegati = new GestioneImpiegati();
	}

	@After
	public void tearDown() throws Exception {
		gestImpiegati = null;
	}

	@Test
	public void testAddNewImpiegato() {
		AccountTO account = new AccountTO("bibi", "0000", "impiegato");
		GestioneAccount gestAccount = new GestioneAccount();
		gestAccount.addNewAccount(account);
		
		ImpiegatoTO impiegato = 
				new ImpiegatoTO("BIBIBIBIBIBIBIBI", "Berto", "Bibi", LocalDate.now(), "0101010101", "1", "bibi");
		boolean[] expected = {true, false};
		
		for(int i = 0; i < expected.length; i++){
			assertEquals("Failed at " + i, gestImpiegati.addNewImpiegato(impiegato), expected[i]);
		}
		gestImpiegati.delete(impiegato.getCf());
		gestAccount.delete("bibi");
	}
	
	@Test
	public void testGetImpiegato() {
		String[] cf = {"ABRBRS13G71F145H", "BIBIBIBIBIBIBIBI"};
		String[] expected = {"ABRBRS13G71F145H", null};

		assertEquals("Failed", gestImpiegati.getImpiegato(cf[0]).getCf(), expected[0]);
		assertEquals("Failed", gestImpiegati.getImpiegato(cf[1]), expected[1]);
	}
	
	@Test
	public void testUpdate() {
		ImpiegatoTO backToNormal = gestImpiegati.getImpiegato("ABRBRS13G71F145H");

		ImpiegatoTO impiegatoValido = gestImpiegati.getImpiegato("ABRBRS13G71F145H");
		impiegatoValido.setTelefono("1111111111");
		ImpiegatoTO impiegatoNonValido = 
				new ImpiegatoTO("BIBIBIBIBIBIBIBI", "Berto", "Bibi", LocalDate.now(), "0101010101", "1", "bibi");
		
		ImpiegatoTO[] impiegato = {impiegatoValido, impiegatoNonValido};
		boolean[] expected = {true, false};
		
		for(int i = 0; i < expected.length; i++){
			assertEquals("Failed at " + i, gestImpiegati.update(impiegato[i]), expected[i]);
		}
		gestImpiegati.update(backToNormal);
	}
	
	@Test
	public void testDelete() {
		ImpiegatoTO impiegatoPresente = 
				new ImpiegatoTO("BIBIBIBIBIBIBIBI", "Berto", "Bibi", LocalDate.now(), "0101010101", "1", "bibi");
		AccountTO account = new AccountTO("bibi", "0000", "impiegato");
		GestioneAccount gestAccount = new GestioneAccount();
		gestAccount.addNewAccount(account);
		gestImpiegati.addNewImpiegato(impiegatoPresente);
		
		String[] impiegato = {impiegatoPresente.getCf(), "IKIKIKIKIKIKIKIK"};
		boolean[] expected = {true, false};
		
		for(int i = 0; i < expected.length; i++){
			assertEquals("Failed at " + i, gestImpiegati.delete(impiegato[i]), expected[i]);
		}
		gestAccount.delete("bibi");
	}
	
	public void testExists() {
		String[] cf = {"ABRBRS13G71F145H", "BIBIBIBIBIBIBIBI"};
		boolean[] expected = {true, false};
		
		for(int i = 0; i < expected.length; i++){
			assertEquals("Failed at" + i, gestImpiegati.exists(cf[i]), expected[i]);
		}
	}
	
}
