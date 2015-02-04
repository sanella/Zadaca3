package User;

import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * 
 * @author Sanela
 * Metoda za kreiranje Employee
 */

public class Employee {
	// ATRIBUTI
	private int empleyeeId;
	private String employeeName;
	private String employeeSurname;
	private long employeePhone;
	private String employeeEmail;

	public Employee(int empleyeeId, String employeeName,
			String employeeSurname, long employeePhone, String employeeEmail) {
		this.empleyeeId = empleyeeId;
		this.employeeName = employeeName;
		this.employeeSurname = employeeSurname;
		this.employeePhone = employeePhone;
		this.employeeEmail = employeeEmail;
	}

	// GETER za ID
	public int getEmpleyeeId() {
		return empleyeeId;
	}

	// to STRING
	public String printEmployee() {
		String str = "";
		str += " Employee ID: " + empleyeeId;
		str += "\n  Name: " + employeeName;
		str += "\n  Surname: " + employeeSurname;
		str += "\n  Phone: " + employeePhone;
		str += "\n  Email: " + employeeEmail + "\n\n";
		return str;
	}

	/**
	 * Metoda koja ispsuje podatke o uposleniku u xnl file
	 * 
	 * @param os
	 *            - metoda prima OutputStream
	 */
	public void employeeToXML(OutputStream os) {
		PrintWriter pw = new PrintWriter(os);
		pw.println("<employee employeeID = \"" + empleyeeId
				+ "\" employeeName = \"" + employeeName
				+ "\" employeeSurname = \"" + employeeSurname
				+ "\" employeePhone = \"" + employeePhone
				+ "\" employeeEmail = \"" + employeeEmail + "\" />");
		pw.flush();
	}

}
