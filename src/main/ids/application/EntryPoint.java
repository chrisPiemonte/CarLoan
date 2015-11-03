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

public class EntryPoint extends Application{
	
	Stage window;
	Scene scene;
	TextField usernameInput;
	final static String BOOTSTRAP = "/main/ids/presentation/view/Bootstrap.fxml";
	
	
	
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
			Parent root = FXMLLoader.load(getClass().getResource(BOOTSTRAP));
			Scene scene = new Scene(root,400,400);
			window.setScene(scene);
			window.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		/*window = primaryStage;
		
		window.setScene(scene);
		window.show();
		*/
	}
	
	
	
	
}
