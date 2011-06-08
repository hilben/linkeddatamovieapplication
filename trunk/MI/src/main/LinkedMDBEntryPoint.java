package main;

import java.util.ArrayList;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;

public class LinkedMDBEntryPoint {
	
	private	String search = "";
	private Model model;
	private StmtIterator si;
	private Statement st;
	private String filmURI ="";
	private ArrayList<Film> ResultsName;
	private ArrayList<String> Actors;
	
	public LinkedMDBEntryPoint(){
		model = ModelFactory.createDefaultModel();
		model.read("http://data.linkedmdb.org/all/film",null);
		si = model.listStatements();
		ResultsName = new ArrayList<Film>();
		
	}
	
	public String getFilmName(int position){
		if((position < ResultsName.size()) && (!ResultsName.isEmpty())){
			return ResultsName.get(position).getName();
		}else{
			return "Unable to return Film Title";
		}
	}
	
	public void printall(){
		si = model.listStatements();
		while(si.hasNext()){
			if(this.st.toString().contains("Queen")){
				System.out.println(st);
			}
			st = si.nextStatement();
		}
		
	}
	
	public void printRDF(String s){
		si = model.listStatements();
		while(si.hasNext()){
			st = si.nextStatement();
			if(st.toString().contains(s)){
				System.out.println(st);
				//System.out.println(this.getFilmName(st));
			}
			
		}
	}
	
	public String getFilmURI(Statement s){
		String tempURI;
		tempURI =  s.toString().substring(1, s.toString().indexOf(','));
		return tempURI;
	}
	
	public String getFilmName(Statement s){
		return s.toString().substring(s.toString().indexOf('\"')+1 , s.toString().length()-2);
	}
	
	public ArrayList<Film> getSearchResultNames(){
		return this.ResultsName;
	}
	
	public void saveSearchResults(String s){
		this.ResultsName.clear();
		si = model.listStatements();
		while(si.hasNext()){
			st = si.nextStatement();
			if((st.toString().contains(s)) && (st.toString().contains("\""))){
				this.ResultsName.add(new Film(this.getFilmName(st), this.getFilmURI(st)));
			}
		}
	}
	
	public void printNames(){
		for(int i=0; i < this.ResultsName.size();i++){
			System.out.println(this.ResultsName.get(i));
		}
	}
	
	public void printSearchResultsStatements(String s){
		si = model.listStatements();
		while(si.hasNext()){
			st = si.nextStatement();
			if(st.toString().contains(s)){
				System.out.println(this.getFilmName(st));
			}
		}System.out.println("Done....");
	}
	
}
