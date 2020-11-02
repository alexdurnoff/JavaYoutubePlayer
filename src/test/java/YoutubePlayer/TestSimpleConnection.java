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
	}
	
	@Test
	public void testApplication() throws GoogleJsonResponseException, GeneralSecurityException, IOException {
		System.out.println(YoutubeUtilityClass.getVideoIdList("Евгений Борисов Java"));
	}
	
	@Test
	public void testStupidRequest() throws IOException {
		URL url = new URL("https://www.youtube.com/results?search_query=%D0%B5%D0%B2%D0%B3%D0%B5%D0%BD%D0%B8%D0%B9+%D0%B1%D0%BE%D1%80%D0%B8%D1%81%D0%BE%D0%B2+java");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line = bufferedReader.readLine();
        while (line != null) {
        	System.out.println(line);
        	line = bufferedReader.readLine();
        }

	}
	
	
}
