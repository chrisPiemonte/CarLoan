package main.ids.presentation.command.gestioneClienti;

import java.util.List;

import main.ids.business.applicationServices.GestioneClienti;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.BasicRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.response.Response;
import main.ids.transferObjects.ClienteTO;

public class GetAllClienti implements Command  {
	
	private Request request;
	private GestioneClienti gestioneClienti;
	
	
	public GetAllClienti(Request request){
		this.gestioneClienti = new GestioneClienti();
		this.request = request;
	}
	
	@Override
	public Response execute() {

		List<ClienteTO> listClienti = gestioneClienti.getAll();
		ComplexResponse<ClienteTO> response = new ComplexResponse<ClienteTO>();
		response.setParameters(listClienti);
		return response;
	}
	
	public static void main(String[] args){
		
		BasicRequest req = new BasicRequest();
		GetAllClienti gac = new GetAllClienti(req);
		
		ComplexResponse<ClienteTO> cr = (ComplexResponse<ClienteTO>)gac.execute();
		List<ClienteTO> lc = cr.getParameters();
		
		for(ClienteTO c : lc){
			System.out.println(c.toString());
		}
		
		
	}
	
	
}