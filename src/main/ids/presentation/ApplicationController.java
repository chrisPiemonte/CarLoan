package main.ids.presentation;

import main.ids.presentation.request.Request;
import main.ids.presentation.request.RequestType;
import main.ids.presentation.response.Response;
import main.ids.transferObjects.AdminTO;
import main.ids.transferObjects.ImpiegatoTO;
import main.ids.transferObjects.ManagerTO;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.response.BasicResponse;
import main.ids.presentation.command.Command;
import main.ids.presentation.command.CommandFactory;
import main.ids.util.json.ViewsJsonParser;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import main.ids.presentation.Dispatcher;

/**Interfaccia per l'application controller 
 * Riceve richieste dal {@link FrontController} per delegare l'esecuzione 
 * sei servizi al {@link CommandFactory} e il caricamento delle view 
 * tramite il {@link Dispatcher}
 * 
 * @author bi
 *
 */
public interface ApplicationController {
	
	public Response handleRequest(Request request);
	
	
	
}
