package test.ids.business.applicationServices;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.ids.business.applicationServices.GestioneAccount;
import main.ids.transferObjects.AccountTO;

public class TestGestioneAccount {
	
	GestioneAccount gestAccount;
	
    @Before
    public void setUp() throws Exception {
    	gestAccount = new GestioneAccount();
    }

    @After
    public void tearDown() throws Exception {
    	gestAccount = null;
    }
	
	@Test
	public void testLogin() {
		String[] username = {"admin", "test"};
		String[] password = {"admin", "errata"};
		
		String[] expected = {"admin", null};
		
		assertEquals("Failed", gestAccount.login(username[0], password[0]).getUsername(), expected[0]);
		assertEquals("Failed", gestAccount.login(username[1], password[1]), expected[1]);
	}
	
	@Test
	public void testAddNewAccount() {
		AccountTO accountValido = new AccountTO("test", "0000", "impiegato");
		AccountTO accountNonValido = new AccountTO("admin", "admin", "admin");
		AccountTO[] account = {accountValido, accountNonValido};
		boolean[] expected = {true, false};
		
		for(int i = 0; i < expected.length; i++){
			assertEquals("Failed at" + i, gestAccount.addNewAccount(account[i]), expected[i]);
		}
		gestAccount.delete("test");
	}
	
	@Test
	public void testGetAccount() {
		String[] username = {"admin", "test"};
		String[] expected = {"admin", null};

		assertEquals("Failed", gestAccount.getAccount(username[0]).getUsername(), expected[0]);
		assertEquals("Failed", gestAccount.getAccount(username[1]), expected[1]);
	}
	
	@Test
	public void testGetPasswordOf() {
		String[] username = {"admin", "test"};
		String[] expected = {"admin", null};
		
		for(int i = 0; i < expected.length; i++){
			assertEquals("Failed", gestAccount.getPasswordOf(username[i]), expected[i]);
		}
	}
	
	@Test
	public void testUpdate() {
		AccountTO accountValido = new AccountTO("admin", "pass", "impiegato");
		
		AccountTO accountNonValido = new AccountTO("test", "0000", "impiegato");
		AccountTO[] account = {accountValido, accountNonValido};
		boolean[] expected = {true, false};
		
		for(int i = 0; i < expected.length; i++){
			assertEquals("Failed at" + i, gestAccount.update(account[i]), expected[i]);
		}
		gestAccount.update(new AccountTO("admin", "admin", "admin"));
	}
	
	public void testExists() {
		String[] username = {"admin", "test"};
		boolean[] expected = {true, false};
		
		for(int i = 0; i < expected.length; i++){
			assertEquals("Failed at" + i, gestAccount.exists(username[i]), expected[i]);
		}
	}
	
}
