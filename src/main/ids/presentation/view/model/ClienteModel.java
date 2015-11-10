package main.ids.presentation.view.model;

import javafx.beans.property.SimpleStringProperty;

public class ClienteModel {
	
	public SimpleStringProperty cf = new SimpleStringProperty();
	public SimpleStringProperty nome = new SimpleStringProperty();
	public SimpleStringProperty cognome = new SimpleStringProperty();
	public SimpleStringProperty dataNascita = new SimpleStringProperty();
	public SimpleStringProperty telefono = new SimpleStringProperty();
	
	
	public String getCf() {
		return cf.get();
	}
	public String getNome() {
		return nome.get();
	}
	public String getCognome() {
		return cognome.get();
	}
	public String getData() {
		return dataNascita.get();
	}
	public String getTelefono() {
		return telefono.get();
	}


	

}
