package main.ids.presentation.view.model;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
/**
 * Modello per la gestione di dati di tipo {@link ClienteTO}
 * @author bi
 *
 */
public class ClienteModel {
	
	public SimpleStringProperty cf = new SimpleStringProperty();
	public SimpleStringProperty nome = new SimpleStringProperty();
	public SimpleStringProperty cognome = new SimpleStringProperty();
	public SimpleObjectProperty<String> dataNascita = new SimpleObjectProperty<>();
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
	public String getDataNascita() {
		return dataNascita.getValue().toString();
	}
	public String getTelefono() {
		return telefono.get();
	}


	

}
