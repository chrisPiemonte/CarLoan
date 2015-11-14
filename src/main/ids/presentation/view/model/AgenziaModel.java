package main.ids.presentation.view.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class AgenziaModel {
	
	public SimpleStringProperty id = new SimpleStringProperty();
	public SimpleStringProperty città = new SimpleStringProperty();
	public SimpleStringProperty indirizzo = new SimpleStringProperty();
	public SimpleStringProperty telefono = new SimpleStringProperty();
	
	
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
		return telefono.get();
	}

}
