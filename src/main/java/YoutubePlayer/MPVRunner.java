package YoutubePlayer;

import java.io.IOException;

public class MPVRunner {

	public void run(String videoId) {
		ProcessBuilder processBuilder = new ProcessBuilder("mpv", "https://youtu.be/" + videoId);
		try {
			
			processBuilder.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
