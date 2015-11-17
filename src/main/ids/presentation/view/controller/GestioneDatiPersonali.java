package main.ids.presentation.view.controller;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.ids.presentation.DefaultFrontController;
import main.ids.presentation.FrontController;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.RequestType;
import main.ids.presentation.response.Response;
import main.ids.util.json.ViewsJsonParser;
/**Controller cje permette il logout tramite il bottone 
 * presente in tutte le view 
 * 
 * @author bi
 *
 */
public class GestioneDatiPersonali {
	
	GestioneDatiPersonali instance = new GestioneDatiPersonali();
	
	/**Richiede la procedura di logout
	 * 
	 */
	public static void logout(){
		FrontController frontController = new DefaultFrontController();
		ComplexRequest request = new ComplexRequest();
		request.setType(RequestType.VIEW);
		request.setRequest("logout");
		Response response = frontController.processRequest(request);
	}
	
	
	

}
