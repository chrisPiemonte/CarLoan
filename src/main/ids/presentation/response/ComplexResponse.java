package main.ids.presentation.response;

/**
 * implementano {@link Response}. Utilizzate per risposte
 * che comprendono parametri di ritorno dalle richieste
 */
import java.util.ArrayList;
import java.util.List;

public class ComplexResponse<T> implements Response{
	
	boolean response;
	List<T> parameters;
	
	public ComplexResponse(){
		this.response = false;
		this.parameters = new ArrayList<T>();
	}

	public boolean isResponse() {
		return response;
	}

	public void setResponse(boolean response) {
		this.response = response;
	}

	public List<T> getParameters() {
		return parameters;
	}

	public void setParameters(List<T> parameters) {
		this.parameters = parameters;
	}
	
	public void addParameter(T parameter){
		this.parameters.add(parameter);
	}
	
	
	

}