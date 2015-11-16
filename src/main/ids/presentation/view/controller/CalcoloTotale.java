package main.ids.presentation.view.controller;

import java.time.LocalDate;
import java.time.Period;

import main.ids.transferObjects.FasciaTO;

public class CalcoloTotale {
	
	CalcoloTotale instance = new CalcoloTotale();
	
	public static double setTotale(LocalDate inizio, LocalDate fine,double tariffaBase,double km,String modNoleggio){
		double tariffa = 0;
		try{
			if (modNoleggio.equals("illimitato")){
				double days = Period.between(inizio, fine).getDays();
				if (days == 0) days = 1;
				tariffa = days*tariffaBase;
				}
			else if (modNoleggio.equals("limitato")){
					tariffa = km*tariffaBase;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return tariffa;
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
