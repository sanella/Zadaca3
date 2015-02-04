package DVD;

import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * 
 * @author Sanela
 *
 */
 public class Movie {
	//ATRIBUTI ZA MOVIE
	private String title;
	private String genre;
	private Actor[] actors;
	private int movieID;
	private int rate; 
	private int size;
	
	// KONSTRUKTOR
	public Movie(int movieID, String title, String genre, int rate) {
		size = 0;
		actors = new Actor[5];
		this.movieID = movieID;
		this.title = title;
		this.genre = genre;
		this.rate = rate;
	}
	
	// GETER
	public int getMovieID() {
		return movieID;
	}

	// TO STRING
	public String printMovie() {
		String str = "";
		str += " Title: " + title;
		str += "\n  Genre: " + genre;
		str += "\n  Movie ID:" + movieID;
		str += "\n  Rate: " + rate;
		str += "\n  Actors: ";
		for (int i = 0; i < size; i++) {
			str += actors[i].toString();
		}
		str += "\n\n";
		return str;
	}
	
	
	/**
	 * Metoda za dodavanja Actora u Movie
	 * @param actor
	 */
	public void addActor(Actor actor) {
		if (size == actors.length)
			resize();
		actors[size] = actor;
		size++;
	}
	
	// metoda za prosirivanje niza ukoliko je mali
	private void resize() {
		Actor[] array = new Actor[size + 1];
		for (int i = 0; i < actors.length; i++)
			array[i] = actors[i];
		actors = array;
	}
	
	/**
	 * Metoda za ispisvanje Movie to XML
	 * @param os
	 */
	public void movieToXML(OutputStream os) {
		PrintWriter pw = new PrintWriter(os);
		pw.println("<movie title = \"" + title
				+ "\" genre = \"" + genre
				+ "\" movieID = \"" +movieID
				+ "\" rate = \"" + rate + "\" >");
		for (int i = 0; i < size; i++) {
			pw.println("	<actor actorName = \"" + actors[i].getActorName()
					+ "\" actorSurname = \"" + actors[i].getActorSurname() + "\" />");
		}
		pw.println("</movie>");
		pw.flush();
	}

}
