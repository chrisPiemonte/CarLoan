package main.ids.presentation.request;

import java.util.List;

public interface Request {
	
	public RequestType getType() ;

	public String getRequest();

	public void setRequest(String request);
		
}
