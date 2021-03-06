package main.ids.presentation.view.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
/**
 * Modello per la gestione di dati di tipo {@link AgenziaTO}
 * @author bi
 *
 */
public class AgenziaModel {
	
	public SimpleStringProperty id = new SimpleStringProperty();
	public SimpleStringProperty città = new SimpleStringProperty();
	public SimpleStringProperty indirizzo = new SimpleStringProperty();
	public SimpleStringProperty telefonoAgenzia = new SimpleStringProperty();
	
	
	public String getId() {
		return id.get();
	}
	public String getCittà() {
		return città.get();
	}
	public String getIndirizzo() {
		return indirizzo.get();
	}
	public String getTelefono() {
		return telefonoAgenzia.get();
	}

}
