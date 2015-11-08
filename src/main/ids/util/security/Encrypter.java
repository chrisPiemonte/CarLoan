package main.ids.util.security;

public interface Encrypter {
	
	public String encrypt(String toEncrypt);

	public String decrypt(String encrypted);
	
}
