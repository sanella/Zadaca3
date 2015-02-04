package Rent;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;


public class Rent {
	private int movieID;
	private int customerID;
	private Date date;
	private int employeeID;
	private boolean payed;
	
	public Rent(int movieID, int customerID, Date date, int employeeID, boolean payed) {
		this.movieID = movieID;
		this.customerID = customerID;
		this.employeeID = employeeID;
		this.date = date;
		this.payed = payed;
	}
	
	
	public boolean isPayed() {
		return payed;
	}

	
	public void setPayed(boolean payed) {
		this.payed = payed;
	}

	public int getMovieID() {
		return movieID;
	}

	
	public int getCustomerID() {
		return customerID;
	}

	
	public Date getDate() {
		return date;
	}

	
	public int getEmployeeID() {
		return employeeID;
	}

	
	public String printRented() {
		String str = "";
		str += " Movie ID: " + movieID;
		str += "\n  Customer ID: " + customerID;
		str += "\n  Employee ID: " + employeeID;
		str += "\n  Date: " + date;
		str += "\n  Payed: " + payed;
		str += "\n\n";
		return str;
	}
	
	
	public void rentToXML(OutputStream os) {
		PrintWriter pw = new PrintWriter(os);
		pw.println("<rent movieID = \"" + movieID
				+ "\" customerID = \"" + customerID
				+ "\" employeeID = \"" + employeeID
				+ "\" date = \"" + date
				+ "\" payed = \"" + payed + "\" />");
		pw.flush();
	}
}
