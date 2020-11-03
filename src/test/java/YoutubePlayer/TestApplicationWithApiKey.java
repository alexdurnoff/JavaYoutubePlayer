package YoutubePlayer;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.YouTube.Builder;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;

public class TestApplicationWithApiKey {
	static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
	
	
	@Test
	public void testApplicationWithApiKey() throws GeneralSecurityException, IOException {
		final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
		GoogleCredential credential = new GoogleCredential.Builder()
				.setTransport(httpTransport)
				.setJsonFactory(JSON_FACTORY)
				.setClientSecrets("alekseyy.durnov@gmail.com", "64d382328f9f4d93db7ada54087a66eb618501d4").build();
		Builder builder = new Builder(httpTransport, JSON_FACTORY, credential);
		builder.setApplicationName("JavaYoutubePlayer");
		YouTube youtubeService = builder.build();
		Assert.assertNotNull(youtubeService);
		YouTube.Search.List request = youtubeService.search()
	            .list("snippet");
	        SearchListResponse response = request.setMaxResults(25L)
	        	.setKey("AIzaSyAeIRTUe3cCMi41-5RB5O6ISJE5dB0g24w")
	            .setQ("Евгений Борисов Java")
	            .execute();
	        List<SearchResult> resultList = response.getItems();
	        for (SearchResult result:resultList) {
	        	System.out.println("new result");
	        	System.out.println("kind=" + result.getKind());
	        	System.out.println("etag=" + result.getEtag());
	        	System.out.println("resourceId =" + result.getKind());
	        	System.out.println("snipet=" + result.getSnippet());
	        	System.out.println("videoId=" + result.getId().getVideoId());
	        	System.out.println("kindvideoId=" + result.getId().getKind());
	        }
		
	}
	
	@Test
	public void testApplicationWithoutClientSecrets() throws GeneralSecurityException, IOException {
		final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
		GoogleCredential credential = new GoogleCredential.Builder()
				.setTransport(httpTransport)
				.setJsonFactory(JSON_FACTORY).build();
				//.setClientSecrets("alekseyy.durnov@gmail.com", "64d382328f9f4d93db7ada54087a66eb618501d4").build();
		Builder builder = new Builder(httpTransport, JSON_FACTORY, credential);
		builder.setApplicationName("JavaYoutubePlayer");
		YouTube youtubeService = builder.build();
		Assert.assertNotNull(youtubeService);
		YouTube.Search.List request = youtubeService.search()
	            .list("snippet");
	        SearchListResponse response = request.setMaxResults(25L)
	        	.setKey("AIzaSyAeIRTUe3cCMi41-5RB5O6ISJE5dB0g24w")
	            .setQ("Евгений Борисов Java")
	            .execute();
	        List<SearchResult> resultList = response.getItems();
	        for (SearchResult result:resultList) {
	        	System.out.println("new result");
	        	System.out.println("kind=" + result.getKind());
	        	System.out.println("etag=" + result.getEtag());
	        	System.out.println("resourceId =" + result.getKind());
	        	System.out.println("snipet=" + result.getSnippet());
	        	System.out.println("videoId=" + result.getId().getVideoId());
	        	System.out.println("kindvideoId=" + result.getId().getKind());
	        }
	}

}


