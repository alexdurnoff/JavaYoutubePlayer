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
		Button searchButton = new Button("search the videos");
		searchButton.setOnAction(ae -> videoPane.searchAndShow(searchText.getText()));
		rootNode.getColumnConstraints().add(new ColumnConstraints(600));
		rootNode.getColumnConstraints().add(new ColumnConstraints(600));
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
