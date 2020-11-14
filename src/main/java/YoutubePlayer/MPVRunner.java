package YoutubePlayer;

import java.io.IOException;

public class MPVRunner {

	public void run(String videoId) {
		ProcessBuilder processBuilder = new ProcessBuilder("mpv", "https://youtu.be/" + videoId).inheritIO();
		try {
			
			processBuilder.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

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

}
