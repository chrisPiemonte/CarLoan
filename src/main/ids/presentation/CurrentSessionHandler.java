package main.ids.presentation;

import javafx.stage.Stage;
import javafx.scene.Scene;

public class CurrentSessionHandler {
	public static String  username;
	public static Scene sessioneScene;
	public static Scene scenaPrecedente;
	public static String tipoAccesso;
	public static String agenzia;
	
	
	
	
	public static Scene getScenaPrecedente() {
		return scenaPrecedente;
	}
	public static void setScenaPrecedente(Scene scenaPrecedente) {
		CurrentSessionHandler.scenaPrecedente = scenaPrecedente;
	}
	public static String getTipoAccesso() {
		return tipoAccesso;
	}
	public static void setTipoAccesso(String tipoAccesso) {
		CurrentSessionHandler.tipoAccesso = tipoAccesso;
	}
	
	public static String getUsername() {
		return username;
	}
	public static void setUsername(String username) {
		CurrentSessionHandler.username = username;
	}
	
	public static Scene getSessioneScene() {
		return sessioneScene;
	}
	public static void setSessioneScene(Scene sessioneScene) {
		CurrentSessionHandler.sessioneScene = sessioneScene;
	}

	public static void refresh(){
		CurrentSessionHandler.username = null;
		CurrentSessionHandler.tipoAccesso = null;
	}
	
	
	

	public static String getAgenzia() {
		return agenzia;
	}
	public static void setAgenzia(String agenzia) {
		CurrentSessionHandler.agenzia = agenzia;
	}
		

}
