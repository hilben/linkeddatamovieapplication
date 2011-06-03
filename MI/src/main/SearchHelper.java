package main;

public class SearchHelper {

	public SearchHelper(){
		
	}
	
	public String formatSearchString(String in){
		String temp = in;
		
		while(temp.contains(":")){
			temp = temp.substring(0, temp.indexOf(":")) + temp.substring(temp.indexOf(':')+1, temp.length());
		}
		
		while(temp.contains(",")){
			temp = temp.substring(0, temp.indexOf(",")) + temp.substring(temp.indexOf(',')+1, temp.length());
		}
		
		
		return temp;
	}
	
	
}
