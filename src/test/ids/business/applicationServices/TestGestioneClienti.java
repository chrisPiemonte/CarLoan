package test.ids.business.applicationServices;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.ids.business.applicationServices.GestioneClienti;
import main.ids.transferObjects.ClienteTO;

public class TestGestioneClienti {
	
	GestioneClienti gestClienti;

	@Before
	public void setUp() throws Exception {
		gestClienti = new GestioneClienti();
	}

	@After
	public void tearDown() throws Exception {
		gestClienti = null;
	}

	@Test
	public void testAddNewCliente() {
		ClienteTO cliente = new ClienteTO("AAAAAAAAAAAAAAAA", "Renato", "Renati", LocalDate.now(), "0801010101");
		boolean[] expected = {true, false};
		
		for(int i = 0; i < expected.length; i++){
			assertEquals("Failed at " + i, 		gestClienti.addNewCliente(cliente), expected[i]);
		}
		gestClienti.delete(cliente.getCf());
	}
	
	@Test
	public void testGetCliente() {
		String[] cf = {"FRANZS13A01D447S", "AAAAAAAAAAAAAAAA"};
		String[] expected = {"FRANZS13A01D447S", null};

		assertEquals("Failed", gestClienti.getCliente(cf[0]).getCf(), expected[0]);
		assertEquals("Failed", gestClienti.getCliente(cf[1]), expected[1]);
	}
	
	@Test
	public void testUpdate() {
		ClienteTO backToNormal = gestClienti.getCliente("FRANZS13A01D447S");
		
		ClienteTO clienteValido = gestClienti.getCliente("FRANZS13A01D447S");
		clienteValido.setCognome("Neri");
		ClienteTO clienteNonValido = new ClienteTO("AAAAAAAAAAAAAAAA", "Renato", "Renati", LocalDate.now(), "0801010101");
		
		ClienteTO[] cliente = {clienteValido, clienteNonValido};
		boolean[] expected = {true, false};
		
		for(int i = 0; i < expected.length; i++){
			assertEquals("Failed at " + i, gestClienti.update(cliente[i]), expected[i]);
		}
		gestClienti.update(backToNormal);
	}
	
	@Test
	public void testExists() {
		String[] cf = {"FRANZS13A01D447S", "AAAAAAAAAAAAAAAA"};
		boolean[] expected = {true, false};
		
		for(int i = 0; i < expected.length; i++){
			assertEquals("Failed at" + i, gestClienti.exists(cf[i]), expected[i]);
		}
	}
}
