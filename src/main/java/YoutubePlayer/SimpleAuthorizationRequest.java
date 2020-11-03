package YoutubePlayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SimpleAuthorizationRequest{
    private final String urlStr = "https://www.googleapis.com/youtube/v3/search";
    private String query;
    private URL url;
    private int maxResults = 25;

    public SimpleAuthorizationRequest(String nameForSearch) throws IOException {
        this.query = nameForSearch.replaceAll(" ", "+");
        System.out.println(this.query);
        String requestString = urlStr + "?" + "key=AIzaSyAeIRTUe3cCMi41-5RB5O6ISJE5dB0g24w" +
                "&" + "q=" + this.query;
        this.url = new URL(requestString);
    }
    
    public SimpleAuthorizationRequest(String nameForSearch, int maxResults) throws IOException {
    	this.maxResults = maxResults;
        this.query = nameForSearch.replaceAll(" ", "+");
        System.out.println(this.query);
        String requestString = urlStr + "?" + "key=AIzaSyAeIRTUe3cCMi41-5RB5O6ISJE5dB0g24w" + 
        		"&" + "maxResults=" + this.maxResults +
                "&" + "q=" + this.query;
        this.url = new URL(requestString);
    }

    public StringBuffer getResponce() throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        System.out.println(connection);
        connection.setRequestMethod("GET");
        //connection.setFixedLengthStreamingMode(300);
        StringBuffer responce = new StringBuffer();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        //String readLine = bufferedReader.readLine();
        /*while(readLine != null){
            responce.append(bufferedReader.readLine());
        }*/
        for (int i = 0; i <1000; i++){
        	responce.append(bufferedReader.readLine());
        }
        return responce;
    }
    
    
}

