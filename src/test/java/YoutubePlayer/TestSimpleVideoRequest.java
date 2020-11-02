package YoutubePlayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Test;

/**
 * Протестировал. В таком виде не работает. Надо действовать, как в SimpleAuthorization
 * @author alexej
 *
 */
public class TestSimpleVideoRequest {
	
	@Test
	public void testSimpleVideoRequestWithAddingParametrToUrl() throws IOException {
		URL url = new URL("https://www.googleapis.com/youtube/v3/search?key=AIzaSyAeIRTUe3cCMi41-5RB5O6ISJE5dB0g24w");
		String query = "Евгений Борисов Java";
		String maxResults = "25";
		String key = "AIzaSyAeIRTUe3cCMi41-5RB5O6ISJE5dB0g24w";
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		//connection.addRequestProperty("key", key);
		connection.addRequestProperty("maxResults", maxResults);
		connection.addRequestProperty("q", query);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        for (int i = 0; i < 1000; i++) {
        	System.out.println(bufferedReader.readLine());
        }
		
	}

}
