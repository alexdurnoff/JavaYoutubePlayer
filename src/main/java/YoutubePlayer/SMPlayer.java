package YoutubePlayer;

import java.io.IOException;

public class SMPlayer implements VideoPlayer{
    @Override
    public void run(String videoId) {
        ProcessBuilder processBuilder = new ProcessBuilder("smplayer", "https://youtu.be/" + videoId).inheritIO();
        try {

            processBuilder.start();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void runBestFormat(String videoId) {
        this.run(videoId);
    }

    @Override
    public String name() {
        return "SMPlayer";
    }
}
