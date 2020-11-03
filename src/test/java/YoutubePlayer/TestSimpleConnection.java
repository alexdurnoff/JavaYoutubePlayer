package YoutubePlayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.GeneralSecurityException;

import org.apache.http.HttpConnection;
import org.junit.Test;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.Credential.AccessMethod;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;

public class TestSimpleConnection {
	
	@Test
	public void testSimpleConnection() throws IOException {
		URL url = new URL("https://www.googleapis.com/youtube/v3/search"
				+"?key=AIzaSyAeIRTUe3cCMi41-5RB5O6ISJE5dB0g24w"+
				"&maxResults=25" + "&q=Евгений+Борисов+Java");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line = bufferedReader.readLine();
        while (line != null) {
        	System.out.println(line);
        	line = bufferedReader.readLine();
        }
        System.out.println("Получили список видео");
        System.exit(0);
	}
	
	@Test
	public void testApplication() throws GoogleJsonResponseException, GeneralSecurityException, IOException {
		System.out.println(YoutubeUtilityClass.getVideoIdList("Евгений Борисов Java"));
	}
	
	
}
