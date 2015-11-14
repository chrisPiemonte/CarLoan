package main.ids.presentation;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import main.ids.presentation.CurrentSessionHandler;

public class Dispatcher {
	
	final static String BOOTSTRAP = "/main/ids/presentation/view/Bootstrap.fxml";
	
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
