package YoutubePlayer;

import javafx.scene.control.Button;

public class PlayButton extends Button {
	protected String videoId;
	private VideoPlayer player;

	/**
	 * Самый первый конструктор, который использовался для mpv,
	 * и только для него.
	 * @param videoId - идентификатор видео из ответа youtube.
	 */
	public PlayButton(String videoId) {
		this.videoId = videoId;
		this.setText("MPV");
		this.setOnAction(ae -> new MPVPlayer().run(this.videoId));
		this.setPrefWidth(100);
	}

	/**
	 * Новый конструктор, который может использовать разные видеоплееры.
	 * @param player - тот плеер, который будет использоваться.
	 * @param videoId - идентификатор видео из ответа youtube.
	 */
	public PlayButton(VideoPlayer player, String videoId){
		this.player = player;
		this.videoId = videoId;
		this.setOnAction(ae -> this.player.run(this.videoId));
		this.setPrefWidth(100);
		this.setText(player.name());
	}
	
	
}
