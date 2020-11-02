package YoutubePlayer;

import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class PlayerApplication extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("JavaYoutubePlayer");
		TextField searchText = new TextField();
		FlowPane rootNode = new FlowPane();
		VideoPane videoPane = new VideoPane();
		Button searchButton = new Button("search the videos");
		searchButton.setOnAction(ae -> videoPane.searchAndShow(searchText.getText()));
		rootNode.getChildren().addAll(searchText, searchButton, videoPane);
		Scene scene = new Scene(rootNode, 1300, 700);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch();
		
	}
	
	

}
