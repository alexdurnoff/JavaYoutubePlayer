package YoutubePlayer;

import javafx.application.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PlayerApplication extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("JavaYoutubePlayer");
		TextField searchText = new TextField();
		GridPane rootNode = new GridPane();
		rootNode.setAlignment(Pos.TOP_CENTER);
		VideoPane videoPane = new VideoPane();
		videoPane.setPrefWidth(rootNode.getWidth());
		ScrollPane scrollPane = new ScrollPane(videoPane);
		scrollPane.setHbarPolicy(ScrollBarPolicy.ALWAYS);
		scrollPane.setFitToWidth(true);
		Button searchButton = new Button("search the videos");
		searchButton.setOnAction(ae -> videoPane.searchAndShow(searchText.getText()));
		ColumnConstraints column0 = new ColumnConstraints();
		ColumnConstraints column1 = new ColumnConstraints();
		column0.setPercentWidth(90);
		column1.setPercentWidth(10);
		rootNode.getColumnConstraints().add(column0);
		rootNode.getColumnConstraints().add(column1);
		rootNode.add(searchText, 0, 0);
		rootNode.add(searchButton, 1, 0);
		rootNode.add(scrollPane, 0, 1, 2, 1);
		Scene scene = new Scene(rootNode, 1300, 700);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch();
		
	}
	
	

}
