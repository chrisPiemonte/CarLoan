package main.ids.presentation.command.gestioneAgenzie;

import java.util.List;

import main.ids.business.applicationServices.GestioneAgenzie;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.response.Response;
import main.ids.transferObjects.AgenziaTO;

public class GetAllAgenzie implements Command  {
	

	private Request request;
	private GestioneAgenzie gestioneAgenzie;
	
	
	public GetAllAgenzie(Request request){
		this.gestioneAgenzie = new GestioneAgenzie();
		this.request = request;
	}
	
	@Override
	public Response execute() {

		List<AgenziaTO> listAccount = gestioneAgenzie.getAll();
		ComplexResponse<AgenziaTO> response = new ComplexResponse<AgenziaTO>();
		response.setParameters(listAccount);
		return response;
	}

}
