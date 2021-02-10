package YoutubePlayer;

public interface VideoPlayer {
    void run(String videoId);
    void runBestFormat(String videoId);
    String name();
}
