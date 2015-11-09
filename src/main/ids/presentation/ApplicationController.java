package main.ids.presentation;

import main.ids.presentation.request.Request;
import main.ids.presentation.response.Response;
import main.ids.presentation.command.Command;
import main.ids.util.json.ViewsJsonParser;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import main.ids.presentation.Dispatcher;

public class ApplicationController {
	
	ArrayList<String> parameters = new ArrayList<String>();
	private Dispatcher dispatcher;
	private ViewsJsonParser vjp;
	Object result;
	Command command;

	

	
	public ApplicationController(){
		
		this.result = null;
		//this.command = new Command();
		
	}
	
	//richieste che non chiedono l'utilizzo di parametri
	
	public Object handleRequest(Request request){
		System.out.println(request.getRequest());
		switch(request.getRequest()){
		
		case "bootstrap" :
			dispatcher = new Dispatcher();
			vjp = ViewsJsonParser.getInstance();
			result = dispatcher.begin();
			break;
			
		}	
		
		vjp = ViewsJsonParser.getInstance();
		//vjp.getInstance();
		dispatcher = new Dispatcher();
		dispatcher.setInterface(vjp.getViewPath(request.getRequest()));
			
		
		return result;
	}
	
	public Object handleRequest(Request request, ArrayList<String> parameters ){
		switch(request.getRequest()){
			
		case "login":
			String result = login(request.getParameters());
			switch(result){
			case "impiegato":
				String pathImpiegato = "impiegatoBoot";
				vjp = ViewsJsonParser.getInstance();
				dispatcher = new Dispatcher(); 
				dispatcher.setInterface(vjp.getViewPath(pathImpiegato));
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
