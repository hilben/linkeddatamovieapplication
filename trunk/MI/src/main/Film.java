package main;

public class Film implements Comparable<Object>{

	private String Name;
	private String URI;
	
	public Film(String Name, String URI){
		
		this.Name = Name;
		this.URI = URI;
		
	}
	
	public String getName(){
		return this.Name;
	}
	
	public String getURI(){
		return this.URI;
	}

	@Override
	public int compareTo(Object o) {
		Film temp = (Film)o;
		if(this.Name.compareToIgnoreCase(temp.Name) == 0){
			return 0;
		}else if(this.Name.compareToIgnoreCase(temp.Name) < 0){
			return -1;
		}else{
			return 1;
		}
	}

	
	
	
}
