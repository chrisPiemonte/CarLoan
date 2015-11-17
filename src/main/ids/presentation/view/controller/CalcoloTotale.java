package main.ids.presentation.view.controller;

import java.time.LocalDate;
import java.time.Period;

import javafx.scene.control.Alert.AlertType;
import main.ids.transferObjects.FasciaTO;
/**Classe per effettuare il calcolo del totale 
 * di un contratto e per la tariffa base relativa
 * ad i parametri di noleggio in input
 * 
 * @author bi
 *
 */
public class CalcoloTotale {
	
	CalcoloTotale instance = new CalcoloTotale();
	/**Calcola il totale
	 * 
	 * @param inizio data d'inizio contratto
	 * @param fine data d'inizio contratto
	 * @param tariffaBase tariffa base del contratto
	 * @param km chilometri percorsi durante il noleggio 
	 * @param modNoleggio specifica la modalità di noleggio relativa ad i chilometri del contratto
	 * @return il totale calcolato
	 */
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
	/**Calcola la tariffa base all'apertura di un contratto
	 * 
	 * @param fascia relativa alla macchina scelta per il noleggio
	 * @param mod modalità di noleggio relativa ad i chilometri 
	 * @param durata modalità di noleggio relativa alla durata, può essere giornaliera o settimanale
	 * @return
	 */
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
