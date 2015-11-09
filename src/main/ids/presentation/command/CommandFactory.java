package main.ids.presentation.command;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

import main.ids.presentation.command.gestioneAccount.Login;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
public class CommandFactory {
	
	private static CommandFactory singleton = new CommandFactory();
	final static String PATH = "main.ids.presentation.command.classCommand.";
	
	
	
	private Map <String,Class> commandMap ; 
	private CommandFactory(){
		commandMap = new HashMap<String,Class>();
		commandMap.put("login", Login.class);
		
	}
	
	public static CommandFactory getIstance(){
		return singleton;
	}
	
	public Command getCommand(String commandName, Request request) throws ClassNotFoundException{
		
		Command command = null;
		Class c = commandMap.get(commandName);
		if (c != null){
			try{
				if (request.getClass().equals(ComplexRequest.class)){
					Constructor costructor = c.getConstructor(Request.class);
					command = (Command)costructor.newInstance(request);
					return command;
				} else {
						command = (Command) c.newInstance();
						return command;
				}
		
			}
			catch(Exception e){
				e.printStackTrace();
			
			}
		} else {
				
			}
	return null;	
	}

}
