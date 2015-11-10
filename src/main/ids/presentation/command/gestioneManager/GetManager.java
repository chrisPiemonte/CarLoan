package main.ids.presentation.command.gestioneManager;

import main.ids.business.applicationServices.GestioneManager;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.response.Response;
import main.ids.transferObjects.ManagerTO;

public class GetManager implements Command  {
	
	private ComplexRequest<String> request;
	private GestioneManager gestioneManager;
	
	public GetManager(Request request){
		this.gestioneManager = new GestioneManager();
		this.request = (ComplexRequest<String>) request;
	}
	
	@Override
	public Response execute() {

		ManagerTO manager = gestioneManager.getManager(request.getParameters().get(0));
		ComplexResponse<ManagerTO> response = new ComplexResponse<ManagerTO>();
		response.addParameter(manager);
		return response;
	}

}