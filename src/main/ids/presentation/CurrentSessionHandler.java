package main.ids.presentation;

import javafx.stage.Stage;
import javafx.scene.Scene;

public class CurrentSessionHandler {
	public static String  username;
	public static String getUsername() {
		return username;
	}
	public static void setUsername(String username) {
		CurrentSessionHandler.username = username;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		CurrentSessionHandler.password = password;
	}
	public static Scene getSessioneScene() {
		return sessioneScene;
	}
	public static void setSessioneScene(Scene sessioneScene) {
		CurrentSessionHandler.sessioneScene = sessioneScene;
	}
	public static String password;
	public static Scene sessioneScene;
	
		

}
