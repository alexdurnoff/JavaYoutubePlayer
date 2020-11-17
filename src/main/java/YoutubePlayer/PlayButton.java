package YoutubePlayer;

import javafx.scene.control.Button;

public class PlayButton extends Button {
	protected String videoId;
		
	public PlayButton(String videoId) {
		this.videoId = videoId;
		this.setText("play");
		//this.setWidth(300);
		this.setOnAction(ae -> new MPVRunner().run(this.videoId));
	}
	
	
}
