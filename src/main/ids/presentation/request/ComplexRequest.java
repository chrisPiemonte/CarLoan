package main.ids.presentation.request;

import java.util.ArrayList;
import java.util.List;

public class ComplexRequest <T> implements Request {

	String request;
	List<T> parameters ;
	RequestType type;
	
	public ComplexRequest(){
		
	}
	
	public ComplexRequest(String request){
		this.request = request;
		this.parameters =  new ArrayList<T>();
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

	
	@Override
	public String getRequest() {
		return request;
	}

	@Override
	public void setRequest(String request) {
		this.request = request;
	}
	
	@Override
	public RequestType getType(){
		return type;
	}
	
	public void setType(RequestType type){
		this.type = type;
	}
	
	

	
}
