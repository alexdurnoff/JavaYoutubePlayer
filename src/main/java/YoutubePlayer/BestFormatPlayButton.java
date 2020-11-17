package YoutubePlayer;

import javafx.scene.control.Button;

public class BestFormatPlayButton extends Button{
	private String videoId;

	public BestFormatPlayButton(String videoId) {
		this.videoId = videoId;
		this.setText("play best format");
		//this.setWidth(400);
		this.setOnAction(ae -> new MPVRunner().runBestFormat(this.videoId));
		
	}
	
	

}
