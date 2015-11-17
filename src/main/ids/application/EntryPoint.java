package main.ids.application;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.ids.integration.dao.factory.QueryFactory;
import main.ids.integration.mySqlDao.dbUtil.DbInitializer;
import main.ids.integration.mySqlDao.factory.SqlQueryFactory;

import main.ids.presentation.CurrentSessionHandler;
import main.ids.presentation.DefaultFrontController;
import main.ids.presentation.request.BasicRequest;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.request.RequestType;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.response.Response;
import main.ids.presentation.FrontController;

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
			ComplexResponse response ;
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
