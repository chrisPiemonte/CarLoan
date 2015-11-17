package main.ids.presentation.view.controller;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

/**Controller per la gestione di un alert, utilizzato 
 * per mostrare messaggi nel sistema  
 * 
 * @author bi
 *
 */
public class Message {
	
	private Message instance = new Message();
	
	private Message() {
		
	}
	/**Chiama l attivazione di un nuovo message con i parametri
	 * impostati
	 * 
	 * @param text testo del messaggio
	 * @param type tipologia di alert, da modificare in base agli utilizzi
	 * @return boolean di ritorno, particolarmente utile nel caso si richieste di conferma
	 */
	public static boolean display(String text, AlertType type){
		boolean check = false ;
		Alert alert = new Alert(type);
		alert.setHeaderText(text);
		alert.showAndWait();
		if (alert.getResult() == ButtonType.OK){
			return true;
		}
		else return false;
	}
	

}


