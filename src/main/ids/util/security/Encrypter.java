package main.ids.util.security;

/**
 * Cifratore di stringhe
 * 
 * @author chris
 */
public interface Encrypter {
	
	/**
	 * Cifra una tringa
	 * 
	 * @param toEncrypt Stringa da crittografare
	 * @return Stringa crittografata
	 */
	public String encrypt(String toEncrypt);
	
	/**
	 * Decifra una stringa
	 * 
	 * @param encrypted Stringa cifrata
	 * @return Stringa decifrata
	 */
	public String decrypt(String encrypted);
	
}
