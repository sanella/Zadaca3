package WorkWithFiles;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import DVD.Actor;
import DVD.Movie;
import User.Customer;
import User.Employee;
import VideoStore.VideoStore;
import Rent.Rent;

public class VideoStoreReader {
	public static void main(String[] args) throws SAXException, IOException,
			ParserConfigurationException, ParseException {
		DocumentBuilder docReader = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder();
		Document xmldoc = docReader.parse(new File("./XML/VideoStore.xml"));
		NodeList xmlmovies = xmldoc.getElementsByTagName("movie");
		NodeList xmlcustomers = xmldoc.getElementsByTagName("customer");
		NodeList xmlemployees = xmldoc.getElementsByTagName("employee");
		NodeList xmlrentedItems = xmldoc.getElementsByTagName("rent");
		LinkedList<Movie> movies = new LinkedList<Movie>();
		LinkedList<Customer> customers = new LinkedList<Customer>();
		LinkedList<Employee> employees = new LinkedList<Employee>();
		LinkedList<Rent> rentedItems = new LinkedList<Rent>();
		VideoStore videoStore = new VideoStore();

		for (int i = 0; i < xmlcustomers.getLength(); i++) {
			Node currentCustomer = xmlcustomers.item(i);
			if (currentCustomer instanceof Element) {
				Element currentCustomerEl = (Element) currentCustomer;
				String name = currentCustomerEl.getNodeName();
				String surname = currentCustomerEl
						.getAttribute("customerSurname");
				int ID = Integer.parseInt(currentCustomerEl
						.getAttribute("customerId"));
				long phone = (long) Integer.parseInt(currentCustomerEl
						.getAttribute("customerPhone"));
				String email = currentCustomerEl.getAttribute("customerEmail");

				Customer current = new Customer(ID, name, surname, phone, email);
				customers.add(current);
				videoStore.addCustomer(current);
			}
		}

		for (int i = 0; i < xmlemployees.getLength(); i++) {
			Node currentEmployee = xmlemployees.item(i);
			if (currentEmployee instanceof Element) {
				Element currentEmployeeEl = (Element) currentEmployee;
				String name = currentEmployeeEl.getAttribute("employeeName");
				String surname = currentEmployeeEl
						.getAttribute("employeeSurname");
				int ID = Integer.parseInt(currentEmployeeEl
						.getAttribute("employeeID"));
				long phone = (long) Integer.parseInt(currentEmployeeEl
						.getAttribute("employeePhone"));
				String email = currentEmployeeEl.getAttribute("employeeEmail");

				Employee current = new Employee(ID, name, surname, phone, email);
				employees.add(current);
				videoStore.addEmployee(current);
			}
		}

		for (int i = 0; i < xmlrentedItems.getLength(); i++) {
			Node currentRentedItem = xmlrentedItems.item(i);
			if (currentRentedItem instanceof Element) {
				Element currentRentedEl = (Element) currentRentedItem;
				int movieID = Integer.parseInt(currentRentedEl
						.getAttribute("movieID"));
				int customerID = Integer.parseInt(currentRentedEl
						.getAttribute("customerID"));
				SimpleDateFormat df = new SimpleDateFormat(
						"EEE MMM dd kk:mm:ss zzzz yyyy");
				Date date = df.parse(currentRentedEl.getAttribute("date"));
				int employeeID = Integer.parseInt(currentRentedEl
						.getAttribute("employeeID"));
				boolean payed = Boolean.parseBoolean(currentRentedEl
						.getAttribute("payed"));

				Rent current = new Rent(movieID, customerID, date, employeeID,
						payed);
				rentedItems.add(current);
				videoStore.addRentedMovie(current);
			}
		}

		for (int i = 0; i < xmlmovies.getLength(); i++) {
			Node currentMovie = xmlmovies.item(i);
			if (currentMovie instanceof Element) {
				Element currentMovieEl = (Element) currentMovie;
				int movieID = Integer.parseInt(currentMovieEl
						.getAttribute("movieID"));
				String title = currentMovieEl.getAttribute("title");
				String genre = currentMovieEl.getAttribute("genre");
				int rate = Integer
						.parseInt(currentMovieEl.getAttribute("rate"));

				Movie current = new Movie(movieID, title, genre, rate);
				movies.add(current);

				if (currentMovieEl.hasChildNodes()) {
					NodeList xmlActors = currentMovieEl.getChildNodes();
					for (int j = 0; j < xmlActors.getLength(); j++) {
						Node currentActor = xmlActors.item(j);
						if (currentActor instanceof Element) {
							Element currentActorEl = (Element) currentActor;
							String name = currentActorEl
									.getAttribute("actorName");
							String surname = currentActorEl
									.getAttribute("actorSurname");

							current.addActor(new Actor(name, surname));
							videoStore.addMovie(current);
						}
					}
				}
			}

		}

	}

}
