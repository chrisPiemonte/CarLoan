package main.ids.presentation.view.controller;

import java.time.LocalDate;
import java.time.Period;

import main.ids.transferObjects.FasciaTO;

public class CalcoloTotale {
	
	CalcoloTotale instance = new CalcoloTotale();
	
	public static double setTotale(LocalDate inizio, LocalDate fine,FasciaTO fascia,boolean modIllimitata){
		double settimana,giorni,tariffa;
		double days = Period.between(inizio, fine).getDays();
		if (days%7 == 0){
			giorni = 1;
		} else giorni = days%7;
		if (days/7 >= 7){
			settimana = days/7;
			tariffa = (settimana*fascia.getTariffaSettimanale()) + (giorni*fascia.getTariffaGiornaliera());
		}else {
			tariffa = (giorni*fascia.getTariffaGiornaliera());
		}
		
		if (modIllimitata)
			return tariffa;
		else
			return tariffa;
	}
	
	public static void main (String[] args){
		FasciaTO fasciascia = new FasciaTO ("P","bellabella",20.0,10.0,5.0);
		System.out.println(CalcoloTotale.setTotale(LocalDate.now().minusDays(6),LocalDate.now(), fasciascia, true));
		
	}
	
	
	

}
