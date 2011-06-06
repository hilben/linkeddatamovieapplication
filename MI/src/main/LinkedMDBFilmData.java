package main;

import java.util.ArrayList;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.ResIterator;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;


public class LinkedMDBFilmData{

	private ArrayList<String> ActorMovies;
	private ArrayList<String> MovieActors;
	private Model model;
	private StmtIterator si;
	private Statement st;
	private Resource Film;
	private ResIterator act;
	private String Service = "http://data.linkedmdb.org/sparql";
	private String query;
	private ResultSet getActorMoviesResults;
	
	
	public ResultSet getMovieActors(String Movie){
		model = ModelFactory.createMemModelMaker().createDefaultModel();
		model.read("http://data.linkedmdb.org/all/film",null);
		query = "PREFIX imdb: <http://data.linkedmdb.org/resource/movie/>" +
		 		"PREFIX dcterms: <http://purl.org/dc/terms/> " + 
				"SELECT ?name "+
				"WHERE{"+
				"SERVICE <http://data.linkedmdb.org/sparql> { "+
				 "          <http://data.linkedmdb.org/resource/film/101> dcterms:title ?movie . " + 
				 "          <http://data.linkedmdb.org/resource/film/101> imdb:actor ?actor . " + 
				 "          ?actor imdb:actor_name ?name . " + 
				"}" + 
				"}";
		
		Query q = QueryFactory.create(query);
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		
		ResultSet rs = qe.execSelect();
		getActorMoviesResults = rs;
	
		
		return rs;
	}
	
	
	
	public void saveResultSet(ResultSet set, ArrayList<String> Save){
		while(set.hasNext()){
			Save.add(set.next().toString());
		}
	}
	
	
	
	public ResultSet getActorMovies(String Actor){
		model = ModelFactory.createMemModelMaker().createDefaultModel();
		model.read("http://data.linkedmdb.org/all/film",null);
		query = "PREFIX imdb: <http://data.linkedmdb.org/resource/movie/>" +
		 		"PREFIX dcterms: <http://purl.org/dc/terms/> " + 
				"SELECT ?movieTitle "+
				"WHERE{"+
				"SERVICE <http://data.linkedmdb.org/sparql> { "+
				 "          ?actor1 imdb:actor_name \""+Actor+"\" . " + 
			        "          ?movie imdb:actor ?actor1 ; " +
			        "                 dcterms:title ?movieTitle . " + 
				"}" + 
				"}";
		
		Query q = QueryFactory.create(query);
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		
		ResultSet rs = qe.execSelect();
		getActorMoviesResults = rs;
	
		
		return rs;
		
			
	}
	
	
	public LinkedMDBFilmData(String FilmURI){
	
		this.ActorMovies = new ArrayList<String>();
		this.MovieActors = new ArrayList<String>();
		
	}
	
	
	
	public static void main(String[] args){
		LinkedMDBFilmData d = new LinkedMDBFilmData("");
		d.getMovieActors("Sleepers");
		ResultSetFormatter.out(d.getActorMoviesResults);
	}
	
	
	
}
