package main.ids.presentation.command.gestioneFasce;

import java.util.List;

import main.ids.business.applicationServices.GestioneFasce;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.response.Response;
import main.ids.transferObjects.FasciaTO;

public class GetAllFasce implements Command  {
	
	private Request request;
	private GestioneFasce gestioneFasce;
	
	public GetAllFasce(Request request){
		this.gestioneFasce = new GestioneFasce();
		this.request = request;
	}
	
	@Override
	public Response execute() {

		List<FasciaTO> listFasce = gestioneFasce.getAll();
		ComplexResponse<FasciaTO> response = new ComplexResponse<FasciaTO>();
		response.setParameters(listFasce);
		return response;
	}

}