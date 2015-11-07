package main.ids.presentation;

import main.ids.presentation.request.Request;
import main.ids.presentation.response.Response;
import main.ids.presentation.command.Command;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import main.ids.presentation.Dispatcher;

public class ApplicationController {
	
	ArrayList<String> parameters = new ArrayList<String>();
	private Dispatcher dispatcher;
	Object result;
	Command command;

	
	public ApplicationController(){
		
		this.result = null;
		//this.command = new Command();
		
	}
	
	//richieste che non chiedono l'utilizzo di parametri
	
	public Object handleRequest(Request request){
		switch(request.getRequest()){
		
		case "bootstrap" :
			dispatcher = new Dispatcher();
			result = dispatcher.begin();
			break;
			
		case "credenzialiErrate":
			dispatcher = new Dispatcher();
			dispatcher.setInterface("/main/ids/presentation/view/Bootstrap.fxml");
			break;
			
		case "gestioneCliente":
			dispatcher = new Dispatcher();
			dispatcher.setInterface("/main/ids/presentation/view/CrudCliente.fxml");
			break;
		
		case "gestioneAuto":
			dispatcher = new Dispatcher();
			dispatcher.setInterface("/main/ids/presentation/view/CrudAuto.fxml");
			break;
			
		case "gestioneContratti":
			dispatcher = new Dispatcher();
			dispatcher.setInterface("/main/ids/presentation/view/CrudContratti.fxml");
			break;
			
		case "gestioneFascia":
			dispatcher = new Dispatcher();
			dispatcher.setInterface("/main/ids/presentation/view/CrudFascia.fxml");
			break;
			
		case "gestioneStaff":
			dispatcher = new Dispatcher();
			dispatcher.setInterface("/main/ids/presentation/view/Staff.fxml");
			break;
			
		case "modificaCliente":
			dispatcher = new Dispatcher();
			dispatcher.setInterface("/main/ids/presentation/view/ModificaClienteLeaf.fxml");
			break;
			
		}
		
		return result;
	}
	
	public Object handleRequest(Request request, ArrayList<String> parameters ){
		switch(request.getRequest()){
			
		case "login":
			String result = login(request.getParameters());
			switch(result){
			case "impiegato":
				dispatcher = new Dispatcher();
				dispatcher.setInterface("/main/ids/presentation/view/ImpiegatoPostLogin.fxml");
				break;
			case "errore":
				dispatcher = new Dispatcher();
				dispatcher.setInterface("/main/ids/presentation/view/CredenzialiErrate.fxml");
				
			} // close login switch...
			break;
		
		
		}
		
		return null;
		
	}
	
	public String login(ArrayList<String> parameters){
		//controllo delle credenziali 
		String username = parameters.get(0);
		String password = parameters.get(1);
		//System.out.println("Utente identificato come impiegato!");
		String check = "errore";
		if (username.equals("gino")) check = "impiegato";
		System.out.println(check);
		return check;
		
		
		
	}
	
	
	
}
