package main.ids.presentation.view.inputValidation;

import java.time.LocalDate;

import javafx.scene.control.Alert.AlertType;
import main.ids.presentation.view.controller.Message;

/**
 * validazione degli input d'interfaccia 
 * differenti in base ad i dati da inserire.
 * I vari metodi prenderanno in input i dati da validare
 * ed in output un boolean che confermerà o meno 
 * gli input inseriti
 * 
 * @author bi
 *
 */
public class TaskValidationFactory {

	public TaskValidationFactory instance = new TaskValidationFactory();
	
	private TaskValidationFactory(){
		
	}
	
	public static boolean getClienteValidation(String cf,String nome,String cognome,LocalDate data,String telefono){
		if(cf != null && nome != null && cognome != null && data != null && telefono != null){
		InputValidation i = InputValidationFactory.getValidation("cf");
		if (i.isValid(cf)){
			i = InputValidationFactory.getValidation("nome");
			if(i.isValid(nome)){
				i = InputValidationFactory.getValidation("cognome");
				if(i.isValid(cognome)){
					i = InputValidationFactory.getValidation("telefono");
					if(i.isValid(telefono)){
						return true;
					}else { Message.display("telefono non valido", AlertType.ERROR);
							
							return false;
					}
				}else { Message.display("Cognome non valido", AlertType.ERROR);
						
						return false;
				}
			}else { Message.display("Nome non valido", AlertType.ERROR);
					
					return false;
			}
		}else { Message.display("Codice Fiscale non valido", AlertType.ERROR);
				
				return false;}
		
	}else{	Message.display("Inserire tutti i campi", AlertType.ERROR);
			return false;
	}
	}
	
	public static boolean getFasciaValidation(String id,String descrizione, String tariffaG, String tariffaS, String tariffaKm){
		if (id != null && descrizione != null && tariffaG != null && tariffaS != null && tariffaKm != null ){
			
			InputValidation i = InputValidationFactory.getValidation("id");
			if (i.isValid(id)){
				i = InputValidationFactory.getValidation("nome");
				if(i.isValid(descrizione)){
					i = InputValidationFactory.getValidation("double");
					if(i.isValid(tariffaG)){
						i = InputValidationFactory.getValidation("double");
						if(i.isValid(tariffaS)){
							i = InputValidationFactory.getValidation("double");
							if(i.isValid(tariffaKm)) {
								return true;
							}else{
								Message.display("Inserire tariffa chilometrica", AlertType.ERROR);
								return false;
							}
						}else { Message.display("Inserire tariffa settimanale", AlertType.ERROR);
								
								return false;
						}
					}else { Message.display("Inserire tariffa giornaliera", AlertType.ERROR);
							
							return false;
					}
				}else { Message.display("Descrizione non valida", AlertType.ERROR);
						
						return false;
				}
			}else { Message.display("ID non valido", AlertType.ERROR);
					
					return false;}
		
	} else {
		Message.display("Inserire tutti i campi", AlertType.ERROR);
		return false;
	}
		}
	
	
	public static boolean controllaInserimentoCliente(String cf,String nome,String cognome,String telefono,LocalDate dataNascita){
		
			
				
		
		if (cf!= null && nome!=null && cognome!= null && dataNascita != null && telefono != null){
			
		InputValidation i = InputValidationFactory.getValidation("cf");
			if (i.isValid(cf)){
				 i = InputValidationFactory.getValidation("nome");
				 if (i.isValid(nome)){
					 i = InputValidationFactory.getValidation("cognome");
					 if (i.isValid(cognome)){
						 i = InputValidationFactory.getValidation("telefono");
						 if (i.isValid(telefono)){
							 return true;
						 }else {
							 Message.display("inserire numero di telefono", AlertType.ERROR);
							 return false;
						 }
					 }else { 
						 Message.display("cognome non inserito", AlertType.ERROR);
						 return false;
						
					 }
				 }else {
					 Message.display("nome non inserito", AlertType.ERROR);
					 return false;
				 }
				 	
				
			} else {
				Message.display("codice fiscale non inserito", AlertType.ERROR);
				return false;
			}
		}else {
			Message.display("Inserire tutti i campi", AlertType.ERROR);
			return false;
		}
		
	} 
	
	
	
public static boolean controllaInserimentoAuto(String targa,String modello,String stato,String fascia,String chilometraggio,LocalDate dataManutenzione){
		
	if (targa != null && modello != null && stato != null && fascia != null && chilometraggio != null && dataManutenzione  != null){
		
		InputValidation i = InputValidationFactory.getValidation("targa");
		if (i.isValid(targa)){
			i = InputValidationFactory.getValidation("nome");
			if (i.isValid(modello)){
				return true;
			}else {
				Message.display("modello non valido", AlertType.ERROR);
				return false;
			}
		}else {
			Message.display("targa non valida", AlertType.ERROR);
			return false;
		}
	}else {
		Message.display("Inserire tutti i campi", AlertType.ERROR);
		return false;
	}



	
	
		
}

}
