package main.ids.presentation.command;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

import main.ids.presentation.command.gestioneAccount.*;
import main.ids.presentation.command.gestioneAgenzie.*;
import main.ids.presentation.command.gestioneAuto.*;
import main.ids.presentation.command.gestioneClienti.*;
import main.ids.presentation.command.gestioneContratti.*;
import main.ids.presentation.command.gestioneFasce.*;
import main.ids.presentation.command.gestioneImpiegati.*;
import main.ids.presentation.command.gestioneManager.*;
import main.ids.presentation.request.BasicRequest;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
	/**Permette di scomporre le diverse operazioni estraibili rispetto ad una chiave 
	 * 
	 * @author bi
	 *
	 */
public class CommandFactory {
	
	private static CommandFactory singleton = new CommandFactory();
	final static String PATH = "main.ids.presentation.command.classCommand.";
	
	
	
	private Map <String,Class> commandMap ; 
	private CommandFactory(){
		commandMap = new HashMap<String,Class>();
		commandMap.put("login", Login.class);
		commandMap.put("addAccount", AddAccount.class);
		commandMap.put("existsAccount", ExistsAccount.class);
		commandMap.put("getAccount", GetAccount.class);
		commandMap.put("getAllAccounts", GetAllAccounts.class);
		commandMap.put("getPasswordOf", GetPasswordOf.class);
		commandMap.put("updateAccount", UpdateAccount.class);
		//agenzie
		commandMap.put("addAgenzia", AddAgenzia.class);
		commandMap.put("existsAgenzia", ExistsAgenzia.class);
		commandMap.put("getAgenzia", GetAgenzia.class);
		commandMap.put("getAllAgenzie", GetAllAgenzie.class);
		commandMap.put("getImpiegatiFromAgenzia", GetImpiegatiFromAgenzia.class);
		commandMap.put("getManagerOfAgenzia", GetManagerOfAgenzia.class);
		commandMap.put("updateAgenzia", UpdateAgenzia.class);
		//auto
		commandMap.put("addAuto", AddAuto.class);
		commandMap.put("changeKmOfAuto", ChangeKmOfAuto.class);
		commandMap.put("changeStatoOfAuto", ChangeStatoOfAuto.class);
		commandMap.put("existsAuto", ExistsAuto.class);
		commandMap.put("getAllAuto", GetAllAuto.class);
		commandMap.put("getAuto", GetAuto.class);
		commandMap.put("getAutoByAgenzia", GetAutoByAgenzia.class);
		commandMap.put("getAutoByFascia", GetAutoByFascia.class);
		commandMap.put("updateAuto", UpdateAuto.class);
		//clienti
		commandMap.put("addCliente", AddCliente.class);
		commandMap.put("existsCliente", ExistsCliente.class);
		commandMap.put("getAllClienti", GetAllClienti.class);
		commandMap.put("getCliente", GetCliente.class);
		commandMap.put("getClienteByCognome", GetClienteByCognome.class);
		commandMap.put("updateCliente", UpdateCliente.class);
		commandMap.put("changeKmOfAuto", ChangeKmOfAuto.class);
		// contratti
		commandMap.put("apriContratto", ApriContratto.class);
		commandMap.put("changeAgenziaFineContratto", ChangeAgenziaFineContratto.class);
		commandMap.put("changeDataFineContratto", ChangeDataFineContratto.class);
		commandMap.put("changeModNoleggioContratto", ChangeModNoleggioContratto.class);
		commandMap.put("chiudiContratto", ChiudiContratto.class);
		commandMap.put("existsContratto", ExistsContratto.class);
		commandMap.put("getAllContratti", GetAllContratti.class);
		commandMap.put("getContratto", GetContratto.class);
		commandMap.put("updateContratto", UpdateContratto.class);
		// fasce
		commandMap.put("addFascia", AddFascia.class);
		commandMap.put("existsFascia", ExistsFascia.class);
		commandMap.put("getAllFasce", GetAllFasce.class);
		commandMap.put("getFascia", GetFascia.class);
		commandMap.put("updateFascia", UpdateFascia.class);
		//impiegati
		commandMap.put("addImpiegato", AddImpiegato.class);
		commandMap.put("changeAgenziaOfImpiegato", ChangeAgenziaOfImpiegato.class);
		commandMap.put("existsImpiegato", ExistsImpiegato.class);
		commandMap.put("getAgenziaOfImpiegato", GetAgenziaOfImpiegato.class);
		commandMap.put("getImpiegatiByCognome", GetImpiegatiByCognome.class);
		commandMap.put("getImpiegato", GetImpiegato.class);
		commandMap.put("getAllImpiegati", GetAllImpiegati.class);
		commandMap.put("updateImpiegato", UpdateImpiegato.class);
		//manager
		commandMap.put("addManager", AddManager.class);
		commandMap.put("changeAgenziaOfManager", ChangeAgenziaOfManager.class);
		commandMap.put("existsManager", ExistsManager.class);
		commandMap.put("getAgenziaOfManager", GetAgenziaOfManager.class);
		commandMap.put("getManager", GetManager.class);
		commandMap.put("getAllManagers", GetAllManagers.class);
		commandMap.put("updateManager", UpdateManager.class);
		
		
		
		
	}
	
	public static CommandFactory getIstance(){
		return singleton;
	}
	/**
	 * 
	 * @param commandName è la chiave per la selezione dell'operazione 
	 * @param request contiene i parametri relativi alle operazioni 
	 * @return ritorna un istanza dell'operazione selezionata
	 */
	public Command getCommand(String commandName, Request request) throws ClassNotFoundException{
		
		Command command = null;
		Class<?> c = commandMap.get(commandName);
		if (c != null){
			try{
				if (request.getClass().equals(ComplexRequest.class)){
					Constructor<?> constructor = c.getConstructor(Request.class);
					command = (Command)constructor.newInstance(request);
					return command;
				}else{
						command = (Command) c.newInstance();
						return command;
				}
		
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}else{
				throw new ClassNotFoundException();
		}
		return null;	
	}
	
	
	public static void main(String[] args){
		CommandFactory cf = CommandFactory.getIstance();
		try{
			Command c = cf.getCommand("getAllClienti", new ComplexRequest());
			System.out.println(c.getClass().toString());
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	

}
