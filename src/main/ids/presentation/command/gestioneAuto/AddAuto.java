package main.ids.presentation.command.gestioneAuto;

import main.ids.business.applicationServices.GestioneAuto;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.BasicResponse;
import main.ids.presentation.response.Response;
import main.ids.transferObjects.AutoTO;

public class AddAuto implements Command  {
	

	private ComplexRequest<AutoTO> request;
	private GestioneAuto gestioneAuto;
	
	
	public AddAuto(Request request){
		this.gestioneAuto = new GestioneAuto();
		this.request = (ComplexRequest<AutoTO>) request;
	}
	
	@Override
	public Response execute() {

		boolean inserito = gestioneAuto.addNewAuto(request.getParameters().get(0));
		BasicResponse response = new BasicResponse();
		response.setResponse(inserito);
		return response;
	}

}