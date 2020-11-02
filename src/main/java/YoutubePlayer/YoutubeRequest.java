package YoutubePlayer;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.YouTube.Search;

public class YoutubeRequest extends YouTube.Search.List{

	protected YoutubeRequest(Search search, String part) {
		search.super(part);
		// TODO Auto-generated constructor stub
	}
	
	

}
