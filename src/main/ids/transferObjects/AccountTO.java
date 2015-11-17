package main.ids.transferObjects;

/**
 * Transfer object per il business object {@link AccountBO}
 * 
 * @author chris
 */
public class AccountTO implements TransferObject {
	
	private String username;
	private String password;
	private String ruolo;
	
	public AccountTO(){
		
	}
	
	public AccountTO(String username, String password, String ruolo) {
		this.username = username;
		this.password = password;
		this.ruolo = ruolo;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	
	public String toString(){
		return this.username + " " + this.password + " " + this.ruolo;
	}

}
