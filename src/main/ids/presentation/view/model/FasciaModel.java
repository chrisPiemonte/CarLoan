package main.ids.presentation.view.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class FasciaModel {
	
	public SimpleStringProperty id = new SimpleStringProperty();
	public SimpleStringProperty descrizione = new SimpleStringProperty();
	public SimpleDoubleProperty tariffaGiornaliera = new SimpleDoubleProperty();
	public SimpleDoubleProperty tariffaSettimanale = new SimpleDoubleProperty();
	public SimpleDoubleProperty tariffaKm = new SimpleDoubleProperty();
	
	public String getId() {
		return id.get();
	}
	public String getDescrizione() {
		return descrizione.get();
	}
	public Double getTariffaGiornaliera() {
		return tariffaGiornaliera.get();
	}
	public Double getTariffaSettimanale() {
		return tariffaSettimanale.get();
	}
	public Double getTariffaKm() {
		return tariffaKm.get();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
