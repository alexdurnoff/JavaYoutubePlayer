package YoutubePlayer;

import javafx.scene.control.Button;

public class BestFormatPlayButton extends Button{
	private String videoId;

	public BestFormatPlayButton(String videoId) {
		this.videoId = videoId;
		this.setText("play" + videoId);
		this.setWidth(100);
		this.setOnAction(ae -> new MPVRunner().runBestFormat(this.videoId));
		
	}
	
	

}
