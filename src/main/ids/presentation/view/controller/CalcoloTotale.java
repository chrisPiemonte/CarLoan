package main.ids.presentation.view.controller;

import java.time.LocalDate;
import java.time.Period;

import javafx.scene.control.Alert.AlertType;
import main.ids.transferObjects.FasciaTO;

public class CalcoloTotale {
	
	CalcoloTotale instance = new CalcoloTotale();
	
	public static double setTotale(LocalDate inizio, LocalDate fine,double tariffaBase,double km,String modNoleggio){
		double tariffa = 0;
		if (modNoleggio.equals("illimitata")){
			double days = Period.between(inizio, fine).getDays();
			if (days == 0) days = 1;
			tariffa = days*tariffaBase;
			return tariffa;
			}
		else if (modNoleggio.equals("limitata")){
			tariffa = km*tariffaBase;
			return tariffa;
		}else return tariffa;
		
	}
	
	public static double getTariffaBase(FasciaTO fascia, String mod, String durata){
		if (mod.equals("illimitata")){
			if (durata.equals("giornaliera")){
				return fascia.getTariffaGiornaliera();
			}else {
				return fascia.getTariffaSettimanale();
			}
		}else 
			return fascia.getTariffaKm();
	}
	
	

}
