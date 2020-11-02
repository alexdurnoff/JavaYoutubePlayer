package YoutubePlayer;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class VideoPane extends GridPane {
	private YouTube youtubeService;
	
	public VideoPane() {
		super();
		try {
			this.youtubeService = YoutubeUtilityClass.getService();
		} catch (GeneralSecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void searchAndShow(String searchString) {
		try {
			YouTube.Search.List request = this.youtubeService.search().list("snippet");
			SearchListResponse response = request.setMaxResults(25L).setQ(searchString).execute();
			List<SearchResult> resultList = response.getItems();
			for (int i = 0; i < resultList.size(); i++) {
				this.add(new Label(resultList.get(i).getEtag()), 0, i);
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
