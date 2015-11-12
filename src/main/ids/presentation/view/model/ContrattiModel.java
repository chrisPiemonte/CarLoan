package main.ids.presentation.view.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class ContrattiModel {
	
	
	public SimpleStringProperty cliente = new SimpleStringProperty();
	public SimpleStringProperty auto = new SimpleStringProperty();
	public SimpleStringProperty modNoleggio = new SimpleStringProperty();
	public SimpleDoubleProperty kmPercorsi = new SimpleDoubleProperty();
	public SimpleStringProperty statoContratto = new SimpleStringProperty();
	public SimpleDoubleProperty totale = new SimpleDoubleProperty();
	
	
	public String getCliente() {
		return cliente.get();
	}
	public String getAuto() {
		return auto.get();
	}
	public String getModNoleggio() {
		return modNoleggio.get();
	}
	public Double getKmPercorsi() {
		return kmPercorsi.get();
	}
	public String getStatoContratto() {
		return statoContratto.get();
	}
	public Double getTotale() {
		return totale.get();
	}
	

}
