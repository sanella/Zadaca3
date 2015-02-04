package User;

import java.io.OutputStream;
import java.io.PrintWriter;
/**
 * 
 * @author Sanela
 * Klasa da napravimo novog Customer/a
 */

public class Customer {
	//ATRIBUTI KUPCA
	private int customerId;
	private String customerName;
	private String customerSurname;
	private long customerPhone;
	private String customerEmail;
	
	//KONSTRUKTOR
	public Customer(int customerId, String customerName, String customerSurname, long customerPhone, String customerEmail) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerSurname = customerSurname;
		this.customerPhone = customerPhone;
		this.customerEmail = customerEmail;
	}
	
	//GETERI I SETERI
	public int getCustomerId() {
		return customerId;
	}
	
	
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	
	public void setCustomerPhone(long customerPhone) {
		this.customerPhone = customerPhone;
	}

	//TO STRING
	public String printCustomer() {
		String str = "";
		str += " Customer ID: " + customerId;
		str += "\n  Name: " + customerName;
		str += "\n  Surname: " + customerSurname;
		str += "\n  Phone: " + customerPhone;
		str += "\n  Email: " + customerEmail + "\n\n";
		return str;
	}

	/**
	 * Metoda koja sprema klijenta u XML file
	 * @param os - metoda prima OutpuStream
	 */
	public void customerToXML(OutputStream os) {
		PrintWriter pw = new PrintWriter(os);
		pw.println("<customer customerId = \"" + customerId 
				+ "\" customerName = \"" + customerName 
				+ "\" customerSurname = \"" + customerSurname 
				+ "\" customerPhone = \"" + customerPhone 
				+ "\" customerEmail = \"" + customerEmail + "\" />");
		//FLUSH da budemo sigurni da je otislo
		pw.flush();
	}
	

}
