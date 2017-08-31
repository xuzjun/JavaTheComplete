package javaFX;

import javafx.application.*;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

public class JavaFXSkel extends Application {
	
	Label response;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Launching JavaFX application.");
		
		launch(args);
	}
	
	public void init() {
		System.out.println("Inside the init() method.");
	}
	
	public void start(Stage myStage) {
		System.out.println("Inside the start() method.");
		
		myStage.setTitle("JAVAFX Skeleton.");
		
		FlowPane rootNode = new FlowPane(10, 10);
		rootNode.setAlignment(Pos.CENTER);
		
		Scene myScene = new Scene(rootNode, 300, 200);
		
		myStage.setScene(myScene);
		
		response = new Label("Push a Button.");
		
		Button btnAlpha = new Button("Alpha");
		Button btnBeta = new Button("Beta");
		
//		btnAlpha.setOnAction(new EventHandler<ActionEvent>() {
//
//			@Override
//			public void handle(ActionEvent event) {
//				response.setText("Alpha was pressed.");
//			}
//			
//		});
		
		// use a Lambda expression
		btnAlpha.setOnAction((ae) -> response.setText("Alpha was pressed."));
		
//		btnBeta.setOnAction(new EventHandler<ActionEvent>() {
//
//			@Override
//			public void handle(ActionEvent event) {
//				response.setText("Beta was pressed.");
//			}
//			
//		});
		
		// use a Lambda expression
		btnBeta.setOnAction((ae) -> response.setText("Beta was pressed."));
		
		rootNode.getChildren().addAll(btnAlpha, btnBeta, response);
		
		myStage.show();
	}
	
	public void stop() {
		System.out.println("Inside the stop() method");
	}

}
