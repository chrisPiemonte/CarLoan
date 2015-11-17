package main.ids.presentation.view.model;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
/**
 * Modello per la gestione di dati di tipo {@link ImpiegatoTO}
 * @author bi
 *
 */
public class StaffModel {
	
	public SimpleStringProperty cf = new SimpleStringProperty();
	public SimpleStringProperty nome = new SimpleStringProperty();
	public SimpleStringProperty cognome = new SimpleStringProperty();
	public SimpleObjectProperty<String> dataNascita = new SimpleObjectProperty<>();
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
		return dataNascita.getValue().toString();
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
