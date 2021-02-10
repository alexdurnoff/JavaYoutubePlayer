package YoutubePlayer;

import java.io.IOException;

public class MPVPlayer implements VideoPlayer {

	@Override
	public void run(String videoId) {
		ProcessBuilder processBuilder = new ProcessBuilder("mpv", "https://youtu.be/" + videoId).inheritIO();
		try {
			
			processBuilder.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void runBestFormat(String videoId) {
		ProcessBuilder processBuilder = new ProcessBuilder("mpv","--ytdl-format=best", "https://youtu.be/" + videoId).inheritIO();
		try {
			
			processBuilder.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*Runtime runtime = Runtime.getRuntime();
		Process process = null;
		try {
			process = runtime.exec("mpv " + "--ytdl-format=best " + "https://youtu.be/" + videoId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			process.waitFor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	@Override
	public String name() {
		return "MPV";
	}

}
