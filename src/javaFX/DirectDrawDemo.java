package javaFX;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class DirectDrawDemo extends Application {
	
	GraphicsContext gc;
	Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.BLACK};
	int colorIdx = 0;

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Draw Dirctly to a Canvas");
		
		FlowPane rootNode = new FlowPane();
		
		rootNode.setAlignment(Pos.CENTER);
		
		Scene primaryScene = new Scene(rootNode, 450, 450);
		
		primaryStage.setScene(primaryScene);
		
		Canvas primaryCanvas = new Canvas(400, 400);
		
		gc = primaryCanvas.getGraphicsContext2D();
		
		Button btnChangeColor = new Button("Change Color");
		
		btnChangeColor.setOnAction((ae) -> {
			gc.setStroke(colors[colorIdx]);
			gc.setFill(colors[colorIdx]);
			
			gc.strokeLine(0, 0, 200, 200);
			gc.fillText("This is drawn on the canvas.", 60, 50);
			gc.fillRect(100, 320, 300, 40);
			colorIdx++;
			if (colorIdx == colors.length)
				colorIdx = 0;
		});
		
		gc.strokeLine(0, 0, 200, 200);
		gc.strokeOval(100, 100, 200, 200);
		gc.strokeRect(0, 200, 50, 200);
		gc.fillOval(0, 0, 20, 20);
		gc.fillRect(100, 320, 300, 40);
		
		gc.setFont(new Font(20));
		gc.fillText("This is drawn on the canvas", 60, 50);
		
		rootNode.getChildren().addAll(primaryCanvas, btnChangeColor);
		
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
