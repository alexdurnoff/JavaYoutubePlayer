package YoutubePlayer;

import javafx.scene.control.Button;

public class PlayButton extends Button {
	private String videoId;
		
	public PlayButton(String videoId) {
		this.videoId = videoId;
		this.setOnAction(ae -> new MPVRunner().run(this.videoId));
	}
	
	
}