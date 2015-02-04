package WorkWithFiles;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;

import User.Customer;
import User.Employee;
import Rent.Rent;
import VideoStore.VideoStore;
import DVD.Actor;
import DVD.Movie;

public class SaveToFile {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		//actors
		Actor actor1 = new Actor("Kevin", "Spacey");
		Actor actor2 = new Actor("Brad", "Pitt");
		Actor actor3 = new Actor("Rober De", "Niro");
		
		//employees
		Employee employee1 = new Employee(1, "Ermina", "Grcic", 11223344, "ermina.grcic@gmail.com");
		Employee employee2 = new Employee(2, "Jamsin", "Grcic", 22334455, "jasmin.grcicc@gmail.com");
		Employee employee3 = new Employee(3, "Sabina", "Grcic", 33445566, "sabina.grcic@gmail.com");
	
		//customers
		Customer customer1 = new Customer(1, "Gorjan", "Kalauzovic", 667788991, "gorjan.kalauzovic@gmail.com");
		Customer customer2 = new Customer(2, "Haris", "Krkalic", 101011112, "haris.krkalic@gmail.com");
		Customer customer3 = new Customer(3, "Vedad", "Zornic", 121213134, "vedad@gmail.com");
		
		//movies
		Movie movie1 = new Movie(1, "american beauty", "comedy", 5);
		Movie movie2 = new Movie(2, "300", "action", 4);
		Movie movie3 = new Movie(3, "V for Vendetta", "triler", 3);
		
		
		movie1.addActor(actor1);
		movie2.addActor(actor2);
		movie3.addActor(actor3);
		
		//rented items
		Rent rent1 = new Rent(movie1.getMovieID(), customer1.getCustomerId(), new Date(2015, 1, 4), employee1.getEmpleyeeId(), true);
		Rent rent2 = new Rent(movie1.getMovieID(), customer1.getCustomerId(), new Date(2015, 1, 4), employee1.getEmpleyeeId(), true);
		Rent rent3 = new Rent(movie1.getMovieID(), customer1.getCustomerId(), new Date(2015, 1, 4), employee1.getEmpleyeeId(), true);
		
		VideoStore videoStore = new VideoStore();
		videoStore.addCustomer(customer1);
		videoStore.addCustomer(customer2);
		videoStore.addCustomer(customer3);
		videoStore.addEmployee(employee1);
		videoStore.addEmployee(employee2);
		videoStore.addEmployee(employee3);
		videoStore.addMovie(movie1);
		videoStore.addMovie(movie2);
		videoStore.addMovie(movie3);
		videoStore.addRentedMovie(rent1);
		videoStore.addRentedMovie(rent2);
		videoStore.addRentedMovie(rent3);
		
		try {
	 		videoStore.videoStoreToXML(videoStore, new FileOutputStream("./XML/VideoStore.xml"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
