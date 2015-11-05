package main.ids.presentation.request;

import java.util.ArrayList;

public class Request {
	
	String request;
	ArrayList<String> parameters = new ArrayList<String>();
	
	public ArrayList<String> getParameters() {
		return parameters;
	}

	public void setParameters(ArrayList<String> parameters) {
		this.parameters = parameters;
	}

	public Request(){
		
	}

	public Request(String request){
		this.request = request;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}
	
	
}
