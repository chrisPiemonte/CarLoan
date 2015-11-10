package main.ids.presentation.command.gestioneFasce;

import main.ids.business.applicationServices.GestioneFasce;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.BasicResponse;
import main.ids.presentation.response.Response;
import main.ids.transferObjects.FasciaTO;

public class AddFascia implements Command  {
	
	private ComplexRequest<FasciaTO> request;
	private GestioneFasce gestioneFasce;
	
	public AddFascia(Request request){
		this.gestioneFasce = new GestioneFasce();
		this.request = (ComplexRequest<FasciaTO>) request;
	}
	
	@Override
	public Response execute() {

		boolean inserito = gestioneFasce.addNewFascia(request.getParameters().get(0));
		BasicResponse response = new BasicResponse();
		response.setResponse(inserito);
		return response;
	}

}