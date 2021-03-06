package YoutubePlayer;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.YouTube.Builder;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;

import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

public class VideoPane extends GridPane {
	private YouTube youtubeService;
	static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
	
	public VideoPane() {
		super();
		this.setupYoutubeService();
	}
	
	public void searchAndShow(String searchString) {
		this.setColumns();
		try {
			SearchListResponse response = this.getResponse(searchString);
			List<SearchResult> resultList = response.getItems();
			for (int i = 0; i < resultList.size(); i++) {
				Label label = new Label(resultList.get(i).getSnippet().getDescription());
				label.setPrefWidth(750);
				label.setWrapText(true);
				this.add(label, 0, i);
				String imageUrl = resultList.get(i).getSnippet().getThumbnails().getDefault().getUrl();
				ImageView imageView = new ImageView(new Image(imageUrl));
				this.add(imageView, 1, i);
				this.add(new PlayButton(new VLCPlayer(), resultList.get(i).getId().getVideoId()), 2, i);
				this.add(new PlayButton(new SMPlayer(), resultList.get(i).getId().getVideoId()), 3, i);
				this.add(new PlayButton(new MPVPlayer(), resultList.get(i).getId().getVideoId()), 4, i);
				this.add(new BestFormatPlayButton(imageUrl), 5, i);
			}
			this.setGridLinesVisible(true);
			this.setAlignment(Pos.CENTER);
			this.setWidth(USE_PREF_SIZE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private SearchListResponse getResponse(String searchString) throws IOException {
		YouTube.Search.List request = this.youtubeService.search().list("snippet");
		SearchListResponse response = request.setMaxResults(25L)
				.setKey("AIzaSyAeIRTUe3cCMi41-5RB5O6ISJE5dB0g24w")
				.setQ(searchString)
				.execute();
		return response;
	}
	
	private void setColumns() {
		ObservableList<ColumnConstraints> columns = this.getColumnConstraints();
		for (int i = 0; i < 5; i++) {
			ColumnConstraints column = new ColumnConstraints();
			column.setHalignment(HPos.CENTER);
			columns.add(column);
		}
	}
	
	private void setupYoutubeService() {
		NetHttpTransport httpTransport = null;
		try {
			httpTransport = GoogleNetHttpTransport.newTrustedTransport();
		} catch (GeneralSecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GoogleCredential credential = new GoogleCredential.Builder()
				.setTransport(httpTransport)
				.setJsonFactory(JSON_FACTORY).build();
		Builder builder = new Builder(httpTransport, JSON_FACTORY, credential);
		builder.setApplicationName("JavaYoutubePlayer");
		this.youtubeService = builder.build();
	}

}
