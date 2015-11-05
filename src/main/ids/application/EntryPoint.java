package main.ids.application;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.ids.integration.dao.factory.QueryFactory;
import main.ids.integration.mySqlDao.factory.SqlQueryFactory;

import main.ids.presentation.CurrentSessionHandler;
import main.ids.presentation.request.Request;
import main.ids.presentation.FrontController;

public class EntryPoint extends Application{
	
	Stage window;
	Scene scene;
	TextField usernameInput;
	
	
	
	
	public static void main(String[] args) {
		
		launch(args);
		//QueryFactory qf = SqlQueryFactory.getInstance();
		//System.out.println(qf.getQuery("Autednticazione"));
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		// in Fx, the stage is the entire window of the project
		// the scene are the content of that
		
		try {
			window = primaryStage;
			Request request = new Request();
			request.setRequest("bootstrap");
			FrontController frontController = new FrontController();
			Scene scene = (Scene)frontController.processRequest(request);
			CurrentSessionHandler.setSessioneScene(scene);
			window.setScene(scene);
			window.setResizable(false);
			window.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
}
