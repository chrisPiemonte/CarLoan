package main.ids.presentation.command.gestioneFasce;

import main.ids.business.applicationServices.GestioneFasce;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.response.Response;
import main.ids.transferObjects.FasciaTO;

public class GetFascia implements Command  {
	
	private ComplexRequest<String> request;
	private GestioneFasce gestioneFasce;
	
	public GetFascia(Request request){
		this.gestioneFasce = new GestioneFasce();
		this.request = (ComplexRequest<String>) request;
	}
	
	@Override
	public Response execute() {

		FasciaTO fascia = gestioneFasce.getFascia(request.getParameters().get(0));
		ComplexResponse<FasciaTO> response = new ComplexResponse<FasciaTO>();
		response.addParameter(fascia);
		return response;
	}

}