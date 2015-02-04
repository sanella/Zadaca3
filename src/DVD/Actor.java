package DVD;

import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * 
 * @author Sanela 
 * Klasa za kreiranje Glumca
 */

public class Actor {
	// ATRIBUTI
	private String actorName;
	private String actorSurname;

	// KONSTRUKTOR
	public Actor(String actorName, String actorSurname) {
		this.actorName = actorName;
		this.actorSurname = actorSurname;
	}

	// TO STRING
	public String toString() {
		String str = "";
		str += "\n   Name of the actor: " + actorName;
		str += "\n   Surname of the actor: " + actorSurname;
		return str;
	}

	// GETERI
	public String getActorName() {
		return actorName;
	}

	public String getActorSurname() {
		return actorSurname;
	}

	/**
	 * Metoda za kreiranje xml file
	 * 
	 * @param actor
	 *            - Glumac
	 * @param os
	 *            - OutputStream
	 */
	public void actorToXML(Actor actor, OutputStream os) {
		PrintWriter pw = new PrintWriter(os);
		pw.println("<actor actorName = \"" + actor.actorName
				+ "\" actorSurname = \"" + actor.actorSurname + "\" />");
		pw.flush();
	}

}
