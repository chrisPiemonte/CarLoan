package main.ids.presentation.command;

import main.ids.presentation.response.Response;
import main.ids.presentation.request.Request;


public interface Command {
	
	public Response execute();
	
	
}
