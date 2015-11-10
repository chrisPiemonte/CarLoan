package main.ids.presentation.command.gestioneManager;

import main.ids.business.applicationServices.GestioneManager;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.BasicResponse;
import main.ids.presentation.response.Response;
import main.ids.transferObjects.ManagerTO;

public class AddManager implements Command  {
	
	private ComplexRequest<ManagerTO> request;
	private GestioneManager gestionemanager;
	
	public AddManager(Request request){
		this.gestionemanager = new GestioneManager();
		this.request = (ComplexRequest<ManagerTO>) request;
	}
	
	@Override
	public Response execute() {

		boolean inserito = gestionemanager.addNewManager(request.getParameters().get(0));
		BasicResponse response = new BasicResponse();
		response.setResponse(inserito);
		return response;
	}

}