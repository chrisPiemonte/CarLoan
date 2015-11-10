package main.ids.presentation.command.gestioneAuto;

import java.util.List;

import main.ids.business.applicationServices.GestioneAuto;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.response.Response;
import main.ids.transferObjects.AutoTO;

public class GetAllAuto implements Command  {
	

	private Request request;
	private GestioneAuto gestioneAuto;
	
	
	public GetAllAuto(Request request){
		this.gestioneAuto = new GestioneAuto();
		this.request = request;
	}
	
	@Override
	public Response execute() {

		List<AutoTO> listAuto = gestioneAuto.getAll();
		ComplexResponse<AutoTO> response = new ComplexResponse<AutoTO>();
		response.setParameters(listAuto);
		return response;
	}

}