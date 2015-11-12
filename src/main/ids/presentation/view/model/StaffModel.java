package main.ids.presentation.view.model;

import javafx.beans.property.SimpleStringProperty;

public class StaffModel {
	
	public SimpleStringProperty cf = new SimpleStringProperty();
	public SimpleStringProperty nome = new SimpleStringProperty();
	public SimpleStringProperty cognome = new SimpleStringProperty();
	public SimpleStringProperty dataNascita = new SimpleStringProperty();
	public SimpleStringProperty telefono = new SimpleStringProperty();
	public SimpleStringProperty agenzia = new SimpleStringProperty();
	public SimpleStringProperty username = new SimpleStringProperty();
	
	public String getCf() {
		return cf.get();
	}
	public String getNome() {
		return nome.get();
	}
	public String getCognome() {
		return cognome.get();
	}
	public String getDataNascita() {
		return dataNascita.get();
	}
	public String getTelefono() {
		return telefono.get();
	}
	public String getAgenzia() {
		return agenzia.get();
	}
	public String getUsername() {
		return username.get();
	}

	

}