package test.ids.util.security;

import static org.junit.Assert.*;

import org.junit.Test;

import main.ids.util.security.BaseEncrypter;

public class TestBaseEncrypter {
	
	BaseEncrypter encrypter = new BaseEncrypter();
	
	@Test
	public void testDecrypt() {
		String string = "manager";
		String stringEncrypted = encrypter.encrypt(string);
		assertEquals("Failed ", encrypter.decrypt(stringEncrypted), string);
	}

}
