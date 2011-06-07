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
	private ResultSet Results;
	
	
	public ArrayList<String> getMovieActorsList(ResultSet s){
		String temp;
		String temp2;
		MovieActors = new ArrayList<String>();
		while(s.hasNext()){
			temp =  s.next().toString();
			temp2 = temp.substring(temp.indexOf("\"")+1,temp.lastIndexOf("\""));
			MovieActors.add(temp2);
		}
		return MovieActors;
	}
	
	
	public ResultSet getMovieAbstract(String Film){
		query =	"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "+
			"	PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "+
		"		PREFIX dbpedia2: <http://dbpedia.org/property/> "+
		"		PREFIX dbpedia: <http://dbpedia.org/> "+
		
		" SELECT ?x "+
	" 	  WHERE  "+
	"	    {  "+
	"		?sub2 rdf:type <http://dbpedia.org/ontology/Film> . " +
	"	    OPTIONAL{ ?sub2 rdfs:comment ?x    . } "+
	"       ?sub2 rdfs:label \""+Film+"\"@en " +
	"		FILTER(lang(?x) = \"en\")" +
	"	    }  "+
	"	  ORDER BY DESC(?date)  " ;
	
		  
		Query q = QueryFactory.create(query);
		QueryExecution qe = QueryExecutionFactory.sparqlService("http://dbpedia.org/sparql", query);
		ResultSet rs = qe.execSelect();
		Results = rs;
		return rs;
	}
	
	public String getFilmDescription(String Film){
		ResultSet s = this.getMovieAbstract(Film);
		String temp;
		if(s.hasNext()){
			temp = s.next().getLiteral("?x").getString();
		}else{
			temp = "No Description Found";
		}
		
		return temp;
	}
	
	public ResultSet getMovieActors(String MovieURI){
		model = ModelFactory.createMemModelMaker().createDefaultModel();
		model.read("http://data.linkedmdb.org/all/film",null);
		query = "PREFIX imdb: <http://data.linkedmdb.org/resource/movie/>" +
		 		"PREFIX dcterms: <http://purl.org/dc/terms/> " + 
		 		"PREFIX dbpedia: <http://dbpedia.org/ontology/> " +
		         "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " + 
		         "PREFIX foaf: <http://xmlns.com/foaf/0.1/>"+
				"SELECT ?name "+
				"WHERE{"+
				"SERVICE <http://data.linkedmdb.org/sparql> { "+
				 "          <"+MovieURI+"> dcterms:title ?movie . " + 
				 "          <"+MovieURI+"> imdb:actor ?actor . " + 
				 "          ?actor imdb:actor_name ?name . " + 
				"}" + 
				"}";
		
		Query q = QueryFactory.create(query);
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		
		ResultSet rs = qe.execSelect();
		Results = rs;
	
		return rs;
	}
	
	
	public ResultSet getMovieActors2(String MovieURI){
		
		query =  "PREFIX movie: <http://data.linkedmdb.org/resource/movie/>"+
				 "PREFIX dbpedia: <http://dbpedia.org/ontology/>"+
				 "PREFIX foaf: <http://xmlns.com/foaf/0.1/>"+
				 "SELECT ?actor_name ?birth_date"+
				 " FROM <http://xmlns.com/foaf/0.1/>"+
				 "WHERE {"+
				 "SERVICE <http://data.linkedmdb.org/sparql> {"+
				 "   <"+MovieURI+"> movie:actor ?actor ."+
				  "  ?actor movie:actor_name ?actor_name"+
				 " }"+
				  "SERVICE <http://dbpedia.org/sparql> {"+
				  "  OPTIONAL{?actor2 a dbpedia:Actor ; foaf:name ?actor_name_en ; dbpedia:birthDate ?birth_date }"+
				   " FILTER(STR(?actor_name_en) = ?actor_name)"+
				  "}"+
				"}";
		
		Query q = QueryFactory.create(query);
		QueryExecution qe = QueryExecutionFactory.sparqlService("http://sparql.org/sparql", query);
		
		ResultSet rs = qe.execSelect();
		Results = rs;
	
		
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
		Results = rs;
	
		
		return rs;
		
			
	}
	
	
	public LinkedMDBFilmData(){
	
		model = ModelFactory.createMemModelMaker().createDefaultModel();
		model.read("http://xmlns.com/foaf/0.1/",null);
		
	}
	
	
	
	public static void main(String[] args){
		LinkedMDBFilmData d = new LinkedMDBFilmData();
		
		System.out.println(d.getFilmDescription("Braveheart"));
	
	}
	
	
	
}
