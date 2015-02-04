package VideoStore;

import java.io.OutputStream;
import java.io.PrintWriter;

import DVD.Movie;
import User.Customer;
import User.Employee;
import Rent.Rent;

public class VideoStore {
	private Customer[] customers;
	private Employee[] employees;
	private Rent[] rentedMovies;
	private Movie[] movies;
	private int sizeCustomer;
	private int sizeEmployee;
	private int sizeMovie;
	private int sizeRent;
	
	
	public VideoStore() {
		customers = new Customer[20];
		employees = new Employee[5];
		rentedMovies = new Rent[10];
		movies = new Movie[20];
		sizeCustomer = 0;
		sizeMovie = 0;
		sizeEmployee = 0;
		sizeRent = 0;
	}
	
	
	public void addCustomer(Customer customer) {
		if(sizeCustomer == customers.length)
			resizeCustomer();
		customers[sizeCustomer] = customer;
		sizeCustomer++;
	}
	
	public void deleteCustomer(Customer customer) {
		for(int i = 0; i < sizeCustomer; i++) {
			if(customers[i] == customer) {
				for(int j = i; j < sizeCustomer; j++)
					customers[j] = customers[j + 1];
				break;
			}
		}
		sizeCustomer--;
	}
	
	
	private void resizeCustomer() {
		Customer[] array = new Customer[sizeCustomer + 1];
		for(int i = 0; i < sizeCustomer; i++)
			array[i] = customers[i];
		customers = array;
	}
	
	
	public void fireEmployee(Employee employee) {
		for(int i = 0; i < sizeEmployee; i++) {
			if(employees[i] == employee) {
				for(int j = i; j < sizeEmployee; j++)
					employees[j] = employees[j + 1];
				break;
			}
		}
		sizeEmployee--;
	}
	
	
	public void addEmployee(Employee employee) {
		if(sizeEmployee == employees.length)
			resizeEmployee();
		employees[sizeEmployee] = employee;
		sizeEmployee++;
	}
	
	
	private void resizeEmployee() {
		Employee[] array = new Employee[sizeEmployee + 1];
		for(int i = 0; i < sizeEmployee; i++)
			array[i] = employees[i];
		employees = array;
	}
	
	
	public void addMovie(Movie movie) {
		if(sizeMovie == movies.length)
			resizeMovie();
		movies[sizeMovie] = movie;
		sizeMovie++;
	}
	
	
	public void removeMovie(Movie movie) {
		for(int i = 0; i < sizeMovie; i++) {
			if(movies[i] == movie) {
				for(int j = i; j < sizeMovie; j++)
					movies[j] = movies[j + 1];
				break;
			}
		}
		sizeMovie--;
			
	}
	
	
	private void resizeMovie() {
		Movie[] array = new Movie[sizeMovie + 1];
		for(int i = 0; i < sizeMovie; i++)
			array[i] = movies[i];
		movies = array;
	}
	
	public void addRentedMovie(Rent rent) {
		if(sizeRent == rentedMovies.length)
			resizeRent();
		rentedMovies[sizeRent] = rent;
		for(int i = 0; i < sizeMovie; i++) {
			if(movies[i].getMovieID() == rent.getMovieID()) {
				for(int j = i ; j < sizeMovie; j++)
					movies[j] = movies[j + 1];
				break;
			}
		}
		sizeRent++;
	}
	
	
	private void resizeRent() {
		Rent[] array = new Rent[sizeRent + 1];
		for(int i = 0; i < sizeRent; i++)
			array[i] = rentedMovies[i];
		rentedMovies = array;
	}
	
	
	public void returnRentedItem(Rent rent) {
		for(int i = 0; i < sizeRent; i++) {
			if(rentedMovies[i] == rent) {
				for(int j = i; j < sizeRent; j++)
					rentedMovies[j] = rentedMovies[j + 1];
				break;
			}
		}
		sizeRent--;
	}
	
	
	public String printVideoStore(){
		String str = "";
		str += "VideoStore";
		str += "\n Customers: \n";
		for(int i = 0; i < sizeCustomer; i++)
			str += " " + customers[i].printCustomer();
		str += " Employees: \n";
		for(int i = 0; i < sizeEmployee; i++)
			str += " " + employees[i].printEmployee();
		str += " Movies: \n";
		for(int i = 0; i < sizeMovie; i++)
			str += " " + movies[i].printMovie();
		str += " Rented items: \n";
		for(int i = 0; i < sizeRent; i++)
			str += " " + rentedMovies[i].printRented();
		return str;
	}
	
	
	public void videoStoreToXML(VideoStore videoStore, OutputStream os) {
		PrintWriter pw = new PrintWriter(os);
		pw.println("<?xml version = \"1.0\"?>");
		pw.println("<videostore>");
		pw.flush();
		for (int i = 0; i < sizeCustomer; i++) {
			pw.print("	");
			videoStore.customers[i].customerToXML(os);
		}
		for(int i = 0; i < sizeEmployee; i++) {
			pw.print("	");
			videoStore.employees[i].employeeToXML(os);
		}
		for(int i = 0; i < sizeMovie; i++) {
			pw.print("	");
			videoStore.movies[i].movieToXML(os);
		}
		for(int i = 0; i < sizeRent; i++) {
			pw.print("	");
			videoStore.rentedMovies[i].rentToXML(os);
		}
		pw.println("</videostore>");
		pw.flush();
		
	}
	
	
	public String printCustomers() {
		String str = "";
		for(int i = 0; i < sizeCustomer; i++) {
			str += customers[i].printCustomer();
		}
		return str;
	}
	
	
	public String printMovies() {
		String str = "";
		for(int i = 0; i < sizeMovie; i++)
			str += movies[i].printMovie();
		return str;
	}
	
	
	public String printEmployees() {
		String str = "";
		for(int i = 0; i < sizeEmployee; i++) 
			str += employees[i].printEmployee();
		return str;
	}
	
	
	public String printRentedMovies() {
		String str = "";
		for(int i = 0; i < sizeRent; i++)
			str += rentedMovies[i].printRented();
		return str;
			
	}

}
