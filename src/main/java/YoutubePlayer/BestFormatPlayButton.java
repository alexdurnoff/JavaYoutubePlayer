package YoutubePlayer;

import javafx.scene.control.Button;

public class BestFormatPlayButton extends Button{
	private String videoId;

	public BestFormatPlayButton(String videoId) {
		this.videoId = videoId;
		this.setText("play best format");
		this.setOnAction(ae -> new MPVPlayer().runBestFormat(this.videoId));
		
	}
}
