package YoutubePlayer;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

/**
 * Класс использует встроенный в javafx player.
 */
public class JavafxPlayer implements VideoPlayer{

    @Override
    public void run(String videoId) {
        Media media = new Media("https://youtu.be/" + videoId);
        MediaPlayer player = new MediaPlayer(media);
        player.setAutoPlay(true);
        MediaView mediaView = new MediaView(player);
        mediaView.setFitWidth(1300);
        VBox vBox = new VBox();
        vBox.getChildren().add(mediaView);
        Stage stage = new Stage();
        Scene scene = new Scene(vBox, 1300, 700);
        stage.setScene(scene);
        stage.setTitle(videoId);
        stage.show();
        player.play();
    }

    @Override
    public void runBestFormat(String videoId) {
        this.run(videoId);
    }

    @Override
    public String name() {
        return "JavaFXPlayer";
    }
}
