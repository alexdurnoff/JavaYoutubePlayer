package YoutubePlayer;

import java.io.IOException;

public class VLCPlayer implements VideoPlayer {
    @Override
    public void run(String videoId) {
        ProcessBuilder processBuilder = new ProcessBuilder("cvlc", "https://youtu.be/" + videoId).inheritIO();
        try {

            processBuilder.start();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Этот метод фактически пустой. Мы делегируем к методу run, поскольку для vlc,
     * видимо, не актуальна опция --best-format
     * @param videoId
     */
    @Override
    public void runBestFormat(String videoId) {
        this.run(videoId);
    }

    @Override
    public String name() {
        return "VLC";
    }
}
