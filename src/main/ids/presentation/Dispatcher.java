package main.ids.presentation;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import main.ids.presentation.CurrentSessionHandler;

/**
 * Permette la gestione delle view dell'interfaccia
 * del sistema
 * 
 * @author bi
 *
 */
public class Dispatcher {
	
	final static String BOOTSTRAP = "/main/ids/presentation/view/Bootstrap.fxml";
	
	/**
	 * Decidono la grandezza della finestra
	 */
	public int height = 700;
	public int weight = 930;
	
	
	private static Dispatcher dispatcher ;
	
	public Dispatcher(){
		
	}
	
	public static Dispatcher getIstance(){
		if (dispatcher == null) {
			dispatcher = new Dispatcher();
		}
		return dispatcher;
	}
	
	/**
	 * Carica le informazioni relative alla scena iniziale
	 * del sistema
	 * 
	 * @return la Scene della pagina d'avvio
	 */
	public Scene begin(){
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource(BOOTSTRAP));
			Scene scene = new Scene(root,weight,height);
			CurrentSessionHandler.setSessioneScene(scene);
			return CurrentSessionHandler.getSessioneScene();
		}catch (IOException | NullPointerException e) {
			
			e.printStackTrace();
			

		}
		
		return null;
		
	}
	
	/**
	 * Carica l'interfaccia per il logout dal sistema
	 */
	
	public void hastaLaVistaBaby(){
		try{
			Parent parent = FXMLLoader.load(getClass().getResource(BOOTSTRAP));
			BorderPane root = (BorderPane) CurrentSessionHandler.getSessioneScene().getRoot();
			root.setCenter(parent);
			root.setLeft(null);
			root.setRight(null);
			root.setBottom(null);
			root.setTop(null);
		}catch(IOException | NullPointerException e) {
			
			e.printStackTrace();
			

		}
		
	}
	/**
	 * Carica l interfaccia relativa alla richiesta proveniente 
	 * dall {@link ApplicationController}
	 * 	
	 * @param path valore del percorso d'interfaccia richiesto
	 */
	public void setInterface(String path){
		try {
			Parent root = FXMLLoader.load(getClass().getResource(path));
			//Scene scene = new Scene(root,height,weight);
			CurrentSessionHandler.setScenaPrecedente(CurrentSessionHandler.sessioneScene);
			CurrentSessionHandler.getSessioneScene().setRoot(root);
		}catch (IOException | NullPointerException e) {
			
			e.printStackTrace();
			

		}
	}

}
