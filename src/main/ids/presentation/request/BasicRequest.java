package main.ids.presentation.request;


public class BasicRequest implements Request{

	String request;
	RequestType type;
	
	public BasicRequest(){
		
	}
	
	public BasicRequest(String request){
		this.request = request;
	}

	@Override
	public RequestType getType() {
		return type;
	}

	public void setType(RequestType type) {
		this.type = type;
	}
	

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}
	
	
}

