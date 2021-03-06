package main.ids.presentation;

import java.util.ArrayList;

import javafx.scene.Scene;
import main.ids.presentation.command.Command;
import main.ids.presentation.command.CommandFactory;
import main.ids.presentation.request.Request;
import main.ids.presentation.request.RequestType;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.response.Response;
import main.ids.transferObjects.AdminTO;
import main.ids.transferObjects.ImpiegatoTO;
import main.ids.transferObjects.ManagerTO;
import main.ids.util.json.ViewsJsonParser;

public class DefaultApplicationController implements ApplicationController{
	
	ArrayList<String> parameters = new ArrayList<String>();
	private Dispatcher dispatcher;
	private ViewsJsonParser vjp;
	//Object result;
	ComplexResponse response ;
	CommandFactory commandFactory ;
	Command command ; 

	

	
	public DefaultApplicationController(){
		
		//this.result = null;
		this.commandFactory = CommandFactory.getIstance();
		//this.command = new Command();
		
	}
	
	//richieste che non chiedono l'utilizzo di parametri
	/**
	 * gestisce la richiesta del {@link FrontController}
	 * caricandone interfaccia o servizi
	 * 
	 * @return Response contiene i dati relativa alla 
	 * 					risposta in caso di servizi
	 * 					ed è nulla nel caso di richieste
	 * 					d'interfaccia
	 */
	
	public Response handleRequest(Request request){
		//System.out.println(request.getRequest());
		//System.out.println(request.getType()+"eieiei");
	 if(request.getType().equals(RequestType.SERVICE))
		
	 {
			if(request.getRequest().equals("login"))
				return login(request);
			else {
				try{
					Response response = null ;
					Command command = commandFactory.getCommand(request.getRequest(), request);
					response =  command.execute();
					return response;
				} catch (ClassNotFoundException e){
					e.printStackTrace();
				}
			}
			
			
			

		}
		
	 else if (request.getType().equals(RequestType.VIEW)){
		
		switch (request.getRequest()) {
		case "bootstrap":
			ComplexResponse<Scene> resp = new ComplexResponse<Scene>();
			//ene scene = new Scene();
			dispatcher = new Dispatcher();
			//vjp = ViewsJsonParser.getInstance();
			resp.addParameter(dispatcher.begin()) ;
			return resp;
			
		case "logout":
			resp = new ComplexResponse<Scene>();
			CurrentSessionHandler.refresh();
			dispatcher = new Dispatcher();
			dispatcher.hastaLaVistaBaby() ;
			return resp;
			
		
		
		default:
			
			vjp = ViewsJsonParser.getInstance();
			//vjp.getInstance();
			dispatcher = new Dispatcher();
			dispatcher.setInterface(vjp.getViewPath(request.getRequest()));
			}
		
		}
		return null;
		
	}
	
	
	public Response login(Request request){
	 
		response =  new ComplexResponse<ImpiegatoTO>();
		try{
		Command command = commandFactory.getCommand(request.getRequest(), request);
		response = (ComplexResponse<ImpiegatoTO>) command.execute();
		ImpiegatoTO impiegato = (ImpiegatoTO) response.getParameters().get(0);
		if  (impiegato != null){
			CurrentSessionHandler.setCf(impiegato.getCf());
			CurrentSessionHandler.setUsername(impiegato.getUsername());
			CurrentSessionHandler.setAgenzia(impiegato.getAgenzia());
			if (impiegato.getClass().equals(AdminTO.class)){
				
				CurrentSessionHandler.setTipoAccesso("admin");
				String pathAdmin = "BootAdmin";
				vjp = ViewsJsonParser.getInstance();
				dispatcher = new Dispatcher(); 
				dispatcher.setInterface(vjp.getViewPath(pathAdmin));
			}
			else if (impiegato.getClass().equals(ManagerTO.class)){
				
				CurrentSessionHandler.setTipoAccesso("manager");
				String pathManager= "BootManager";
				vjp = ViewsJsonParser.getInstance();
				dispatcher = new Dispatcher(); 
				dispatcher.setInterface(vjp.getViewPath(pathManager));
				
			}
			
			else {
				
				CurrentSessionHandler.setTipoAccesso("impiegato");
				String pathImpiegato = "impiegatoBoot";
				vjp = ViewsJsonParser.getInstance();
				dispatcher = new Dispatcher(); 
				dispatcher.setInterface(vjp.getViewPath(pathImpiegato));
			}
			response.setResponse(true);
		} else {
			response.setResponse(false);
		}
		
		
		}catch(Exception e){
			e.printStackTrace();
		}
				
				
		
		return response;
		
		
		
	}
	

}
