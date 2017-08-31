package javaFX;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ToggleButtonDemo extends Application {
	
	ToggleButton btnOnOff;
	Label response;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Demonstrate a Toggle Button");
		
		FlowPane rootNode = new FlowPane(10, 10);
		
		rootNode.setAlignment(Pos.CENTER);
		Scene primaryScene = new Scene(rootNode, 220, 120);
		
		primaryStage.setScene(primaryScene);
		
		response = new Label("Push the Button");
		
		btnOnOff = new ToggleButton("On/Off");
		
		btnOnOff.setOnAction((ae) -> {
			if (btnOnOff.isSelected()) response.setText("Button is ON");
			else response.setText("Button is Off");
		});
		
		rootNode.getChildren().addAll(btnOnOff, response);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
