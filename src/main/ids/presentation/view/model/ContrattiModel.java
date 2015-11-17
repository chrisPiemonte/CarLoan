package main.ids.presentation.view.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
/**
 * Modello per la gestione di dati di tipo {@link ContrattiTO}
 * @author bi
 *
 */
public class ContrattiModel {
	
	public SimpleStringProperty id = new SimpleStringProperty();
	public SimpleStringProperty cliente = new SimpleStringProperty();
	public SimpleStringProperty auto = new SimpleStringProperty();
	public SimpleStringProperty modNoleggio = new SimpleStringProperty();
	public SimpleDoubleProperty kmPercorsi = new SimpleDoubleProperty();
	public SimpleStringProperty statoContratto = new SimpleStringProperty();
	public SimpleDoubleProperty totale = new SimpleDoubleProperty();
	public SimpleStringProperty agenziaFine = new SimpleStringProperty();
	
	public String getId() {
		return id.get();
	}
	
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
	public String getAgenziaFine() {
		return agenziaFine.get();
	}
	

}
