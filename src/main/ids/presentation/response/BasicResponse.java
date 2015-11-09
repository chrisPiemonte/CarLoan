package main.ids.presentation.response;

public class BasicResponse implements Response{
	
	boolean response;
	
	public BasicResponse(){
		this.response = false;
	}

	public boolean isResponse() {
		return response;
	}

	public void setResponse(boolean response) {
		this.response = response;
	}
	

}
