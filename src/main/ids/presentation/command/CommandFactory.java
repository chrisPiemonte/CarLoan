package main.ids.presentation.command;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

import main.ids.presentation.command.classCommand.Login;
import main.ids.presentation.request.Request;
public class CommandFactory {
	
	private static CommandFactory sigleton = new CommandFactory();
	final static String PATH = "main.ids.presentation.command.classCommand.";
	Class c ;
	Constructor ctor;
	
	private HashMap <String,String> commandMap ; 
	private CommandFactory(){
		commandMap = new HashMap<String,String>();
		commandMap.put("login", "Login");
		
	}
	
	public static CommandFactory getSigleton(){
		return sigleton;
	}
	
	public /*Command*/void  getCommand(String name, Request request) throws ClassNotFoundException{
		
		String className = commandMap.get(name);
		className = PATH + className;
		try{
		c.forName(className);
		ctor = c.getConstructor();
		
		
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		
		
		
	}

}
