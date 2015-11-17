package main.ids.application;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.stage.Stage;

import main.ids.integration.mySqlDao.dbUtil.DbInitializer;
import main.ids.presentation.CurrentSessionHandler;
import main.ids.presentation.DefaultFrontController;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.RequestType;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.FrontController;

/**
 * 
 * Entry point del sistema configura il database e lo Stage iniziale
 * @author chris
 *
 */
public class EntryPoint extends Application{
	
	Stage window;
	Scene scene;
	
	public static void main(String[] args) {
		DbInitializer.init();
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		
		try {
			ComplexResponse response;
			window = primaryStage;
			ComplexRequest request = new ComplexRequest();
			request.setRequest("bootstrap");
			request.setType(RequestType.VIEW);
			FrontController frontController = new DefaultFrontController();
			response = (ComplexResponse<Scene>)frontController.processRequest(request);
			scene = (Scene)response.getParameters().get(0);
			CurrentSessionHandler.setSessioneScene(scene);
			window.setScene(scene);
			window.setResizable(false);
			window.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
}
