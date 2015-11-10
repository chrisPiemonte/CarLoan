package main.ids.presentation.command.gestioneManager;

import java.util.List;

import main.ids.business.applicationServices.GestioneManager;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.response.Response;
import main.ids.transferObjects.ManagerTO;

public class GetAllManagers implements Command  {
	
	private Request request;
	private GestioneManager gestioneManager;
	
	public GetAllManagers(Request request){
		this.gestioneManager = new GestioneManager();
		this.request = request;
	}
	
	@Override
	public Response execute() {

		List<ManagerTO> listManagers = gestioneManager.getAll();
		ComplexResponse<ManagerTO> response = new ComplexResponse<ManagerTO>();
		response.setParameters(listManagers);
		return response;
	}

}