package main;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gdata.client.youtube.YouTubeQuery;
import com.google.gdata.client.youtube.YouTubeService;
import com.google.gdata.data.youtube.VideoFeed;
import com.google.gdata.data.youtube.YouTubeMediaContent;
import com.google.gdata.data.youtube.YouTubeMediaGroup;
import com.google.gdata.util.ServiceException;

public class Youtube {

	private YouTubeService service;
	private YouTubeQuery yquery;
	
	public Youtube(){
		
		service = new YouTubeService("Trailers");
		try {
			yquery = new YouTubeQuery(new URL("http://gdata.youtube.com/feeds/api/videos"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	public String searchTrailer(String searchString){
		
		String returnvalue = "No Results";
		yquery.setFullTextQuery(searchString);
		yquery.setSafeSearch(YouTubeQuery.SafeSearch.NONE);
		
		try{
			
			VideoFeed v = service.query(yquery, VideoFeed.class);
			int i = 0;
			while((returnvalue.equals("No Results") || returnvalue.contains(".3gp")) && (i < v.getEntries().size())){
				YouTubeMediaGroup mediaGroup =  v.getEntries().get(i).getMediaGroup();
				int j = 0; 
				while((returnvalue.equals("No Results") || returnvalue.contains(".3gp")) && (j < mediaGroup.getYouTubeContents().size())){
					YouTubeMediaContent con = mediaGroup.getYouTubeContents().get(j);
					returnvalue = con.getUrl();
					j++;
				}
				i++;
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		return returnvalue;
	}
	
	
}
