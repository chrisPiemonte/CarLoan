package main.ids.presentation.view.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class AutoModel {
	
	public SimpleStringProperty targa = new SimpleStringProperty();
	public SimpleStringProperty modello = new SimpleStringProperty();
	public SimpleStringProperty stato = new SimpleStringProperty();
	public SimpleDoubleProperty km = new SimpleDoubleProperty();
	public SimpleStringProperty fasciaAuto = new SimpleStringProperty();
	public SimpleStringProperty manutenzione = new SimpleStringProperty();
	public SimpleStringProperty agenzia = new SimpleStringProperty();
	
	
	public String getTarga() {
		return targa.get();
	}
	public String  getModello() {
		return modello.get();
	}
	public String  getStato() {
		return stato.get();
	}
	public double getKm() {
		return km.get();
	}
	public String getFasciaAuto() {
		return fasciaAuto.get();
	}
	public String getManutenzione() {
		return manutenzione.get();
	}
	public String getAgenzia() {
		return agenzia.get();
	}

}
