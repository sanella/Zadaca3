package Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import DVD.Actor;
import DVD.Movie;
import Rent.Rent;
import User.Customer;
import User.Employee;
import VideoStore.VideoStore;

/**
 * 
 * @author Sanela
 *
 */

public class GraphicUserInterface {
	public JButton customer = new JButton("Customer");
	public JButton employee = new JButton("Employee");
	public JButton movie = new JButton("Movie");
	public JButton rent = new JButton("Rent Movie");
	public JButton add = new JButton("Add");
	public JButton remove = new JButton("Remove");
	public JButton print = new JButton("All customers");
	public JButton save = new JButton("SAVE");
	public JButton actors = new JButton("Actors");
	public JTextArea display;
	public JTextField name;
	public JTextField surname;
	public JTextField phone;
	public JTextField email;
	public JTextField id;
	public JTextField Id;
	public VideoStore videoStore = new VideoStore();
	public JTextField title;
	public JTextField genre;
	public JTextField ID;
	public JTextField rate;
	public Movie movie1;
	public JTextField daTe;
	public JTextField payeD;
	public JLabel movieTitle;
	public JLabel movieGenre;
	public JLabel movieID;
	public JLabel movieRate;
	public JPanel panel;
	public JFrame frame;
	public JLabel customerID;
	public JLabel employeeID;
	public JLabel date;
	public JLabel payed;
	public JLabel customerName;
	public JLabel customerSurname;
	public JLabel customerPhone;
	public JLabel customerEmail;
	public JLabel employeeName;
	public JLabel employeeSurname;
	public JLabel employeeEmail;
	public JLabel employeePhone;
	public Rent rent1;

	public GraphicUserInterface(int width, int height) {
		JFrame frame = new JFrame("VideoStore");
		frame.setSize(width, height);
		frame.setResizable(false);
		JPanel panel = new JPanel();
		ButtonListener listener = new ButtonListener();
		customer.addActionListener(listener);
		employee.addActionListener(listener);
		movie.addActionListener(listener);
		rent.addActionListener(listener);
		panel.add(customer);
		panel.add(employee);
		panel.add(movie);
		panel.add(rent);
		panel.setVisible(true);
		frame.add(panel);
		frame.setVisible(true);
	}

	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == customer) {
				customerFrame("Customer");
				ButtonListener1 listener = new ButtonListener1();
				add.addActionListener(listener);
				remove.addActionListener(listener);
				print.addActionListener(listener);
				panel.add(display);
				panel.add(add);
				panel.add(remove);
				panel.add(print);
				panel.setVisible(true);
				frame.add(panel);
				frame.setVisible(true);

			}

			if (e.getSource() == employee) {
				employeeFrame("Employee");
				ButtonListener4 listener = new ButtonListener4();
				add.addActionListener(listener);
				remove.addActionListener(listener);
				print.addActionListener(listener);
				panel.add(display);
				panel.add(add);
				panel.add(remove);
				panel.add(print);
				panel.setVisible(true);
				frame.add(panel);
				frame.setVisible(true);
			}

			if (e.getSource() == movie) {
				movieFrame("Movie");
				ButtonListener7 listener = new ButtonListener7();
				add.addActionListener(listener);
				remove.addActionListener(listener);
				print.addActionListener(listener);

				panel.add(display);
				panel.add(add);
				panel.add(remove);
				panel.add(print);
				panel.setVisible(true);
				frame.add(panel);
				frame.setVisible(true);

			}

			if (e.getSource() == rent) {
				rentFrame("Rent movie");
				ButtonListener11 listener = new ButtonListener11();
				add.addActionListener(listener);
				remove.addActionListener(listener);
				print.addActionListener(listener);

				panel.add(display);
				panel.add(add);
				panel.add(remove);
				panel.add(print);
				panel.setVisible(true);
				frame.add(panel);
				frame.setVisible(true);
			}
		}
	}

	private class ButtonListener1 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == print) {
				display.setText(videoStore.printCustomers());
				display.setLineWrap(true);
			}

			if (e.getSource() == remove) {
				customerSaveFrame("Remove customer");
				ButtonListener3 listener = new ButtonListener3();
				save.addActionListener(listener);
				panel.add(customerName);
				panel.add(name);
				panel.add(customerSurname);
				panel.add(surname);
				panel.add(customerID);
				panel.add(id);
				panel.add(customerPhone);
				panel.add(phone);
				panel.add(customerEmail);
				panel.add(email);
				panel.add(save);
				frame.add(panel);
				frame.setVisible(true);
			}

			if (e.getSource() == add) {
				customerSaveFrame("Add customer");

				ButtonListener2 listener = new ButtonListener2();
				save.addActionListener(listener);

				panel.add(display);
				panel.add(customerName);
				panel.add(name);
				panel.add(customerSurname);
				panel.add(surname);
				panel.add(customerID);
				panel.add(id);
				panel.add(customerPhone);
				panel.add(phone);
				panel.add(customerEmail);
				panel.add(email);
				panel.add(save);
				panel.setVisible(true);
				frame.add(panel);
				frame.setVisible(true);
			}
		}
	}

	private class ButtonListener2 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == save) {
				int customerId = Integer.parseInt(id.getText());
				String customerName = name.getText();
				String customerSurname = surname.getText();
				long customerPhone = (long) Integer.parseInt(phone.getText());
				String customerEmail = email.getText();
				Customer customer = new Customer(customerId, customerName,
						customerSurname, customerPhone, customerEmail);
				videoStore.addCustomer(customer);
			}

		}

	}

	private class ButtonListener3 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == save) {
				int customerId = Integer.parseInt(id.getText());
				String customerName = name.getText();
				String customerSurname = surname.getText();
				long customerPhone = (long) Integer.parseInt(phone.getText());
				String customerEmail = email.getText();
				Customer customer = new Customer(customerId, customerName,
						customerSurname, customerPhone, customerEmail);
				try {
					videoStore.deleteCustomer(customer);
				} catch (Exception e1) {
					error("customer");
				}
			}

		}

	}

	private class ButtonListener4 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == remove) {
				employeeSaveFrame("Fire employee");
				ButtonListener5 listener = new ButtonListener5();
				save.addActionListener(listener);
				panel.add(employeeName);
				panel.add(employeeSurname);
				panel.add(employeeID);
				panel.add(employeePhone);
				panel.add(employeeEmail);
				panel.add(save);
				frame.add(panel);
				frame.setVisible(true);
			}

			if (e.getSource() == add) {
				employeeSaveFrame("Hire employee");
				ButtonListener6 listener = new ButtonListener6();
				save.addActionListener(listener);
				panel.add(employeeName);
				panel.add(name);
				panel.add(employeeSurname);
				panel.add(surname);
				panel.add(employeeID);
				panel.add(id);
				panel.add(employeePhone);
				panel.add(phone);
				panel.add(employeeEmail);
				panel.add(email);
				panel.add(save);
				frame.add(panel);
				frame.setVisible(true);
			}

			if (e.getSource() == print) {
				display.setText(videoStore.printEmployees());
				display.setLineWrap(true);
			}

		}

	}

	private class ButtonListener5 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == save) {
				int empleyeeId = Integer.parseInt(id.getText());
				String employeeName = name.getText();
				String employeeSurname = surname.getText();
				long employeePhone = (long) Integer.parseInt(phone.getText());
				String employeeEmail = email.getText();
				Employee employee = new Employee(empleyeeId, employeeName,
						employeeSurname, employeePhone, employeeEmail);
				try {
					videoStore.fireEmployee(employee);
				} catch (Exception e1) {
					error("employee");
				}
			}

		}

	}

	private class ButtonListener6 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == save) {
				int empleyeeId = Integer.parseInt(id.getText());
				String employeeName = name.getText();
				String employeeSurname = surname.getText();
				long employeePhone = (long) Integer.parseInt(phone.getText());
				String employeeEmail = email.getText();
				Employee employee = new Employee(empleyeeId, employeeName,
						employeeSurname, employeePhone, employeeEmail);
				videoStore.addEmployee(employee);
			}

		}

	}

	private class ButtonListener7 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == add) {
				movieSaveFrame("Add movie");
				ButtonListener9 listener = new ButtonListener9();
				save.addActionListener(listener);
				actors.addActionListener(listener);
				panel.add(movieTitle);
				panel.add(title);
				panel.add(movieGenre);
				panel.add(genre);
				panel.add(movieID);
				panel.add(ID);
				panel.add(movieRate);
				panel.add(rate);
				panel.add(save);
				frame.add(panel);
				frame.setVisible(true);
			}

			if (e.getSource() == remove) {
				movieSaveFrame("Remove movie");
				ButtonListener8 listener = new ButtonListener8();
				save.addActionListener(listener);
				panel.add(movieTitle);
				panel.add(title);
				panel.add(movieGenre);
				panel.add(genre);
				panel.add(movieID);
				panel.add(ID);
				panel.add(movieRate);
				panel.add(rate);
				panel.add(save);
				frame.add(panel);
				frame.setVisible(true);
			}

			if (e.getSource() == print) {
				display.setText(videoStore.printMovies());
				display.setLineWrap(true);
			}

		}

	}

	private class ButtonListener8 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == save) {
				String mTitle = title.getText();
				String mGenre = genre.getText();
				int mId = Integer.parseInt(ID.getText());
				int mRate = Integer.parseInt(rate.getText());
				movie1 = new Movie(mId, mTitle, mGenre, mRate);
				try {
					videoStore.removeMovie(movie1);
				} catch (Exception e1) {
					error("movie");
				}
			}

		}

	}

	private class ButtonListener9 implements ActionListener {

		String mTitle = title.getText();
		String mGenre = genre.getText();
		int mId = Integer.parseInt(ID.getText());
		int mRate = Integer.parseInt(rate.getText());

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == save) {
				movie1 = new Movie(mId, mTitle, mGenre, mRate);
				videoStore.addMovie(movie1);
			}

			if (e.getSource() == actors) {
				JFrame frame = new JFrame("Actor");
				frame.setSize(400, 400);
				frame.setResizable(false);
				JPanel panel = new JPanel();
				display.setEditable(false);
				display.setLineWrap(true);
				JLabel actorName = new JLabel("Name: ");
				name = new JTextField();
				JLabel actorSurname = new JLabel("Surname: ");
				surname = new JTextField();
				ButtonListener10 listener = new ButtonListener10();
				save.addActionListener(listener);
				panel.add(actorName);
				panel.add(name);
				panel.add(actorSurname);
				panel.add(surname);
				panel.add(save);
				frame.add(panel);
				frame.setVisible(true);
			}

		}

	}

	private class ButtonListener10 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == save) {
				String actorName = name.getText();
				String actorSurname = surname.getText();
				Actor actor = new Actor(actorName, actorSurname);
				movie1.addActor(actor);
			}

		}

	}

	private class ButtonListener11 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == add) {
				movieRent("Rent movie");
				ButtonListener12 listener;
				try {
					listener = new ButtonListener12();
					save.addActionListener(listener);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				panel.add(movieID);
				panel.add(ID);
				panel.add(customerID);
				panel.add(id);
				panel.add(date);
				panel.add(daTe);
				panel.add(employeeID);
				panel.add(Id);
				panel.add(payed);
				panel.add(payeD);
				frame.add(panel);
				frame.setVisible(true);

			}

			if (e.getSource() == remove) {
				movieRent("Return movie");
				ButtonListener13 listener;
				try {
					listener = new ButtonListener13();
					save.addActionListener(listener);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				panel.add(movieID);
				panel.add(ID);
				panel.add(customerID);
				panel.add(id);
				panel.add(date);
				panel.add(daTe);
				panel.add(employeeID);
				panel.add(Id);
				panel.add(payed);
				panel.add(payeD);
				frame.add(panel);
				frame.setVisible(true);
			}

			if (e.getSource() == print) {
				display.setText(videoStore.printRentedMovies());
				display.setLineWrap(true);
			}

		}

	}

	private class ButtonListener12 implements ActionListener {

		public ButtonListener12() throws ParseException {
			int movieID = Integer.parseInt(ID.getText());
			int customerID = Integer.parseInt(id.getText());
			SimpleDateFormat df = new SimpleDateFormat(
					"EEE MMM dd kk:mm:ss zzzz yyyy");
			Date date = df.parse(daTe.getText());
			int employeeID = Integer.parseInt(Id.getText());
			boolean payed = Boolean.parseBoolean(payeD.getText());
			rent1 = new Rent(movieID, customerID, date, employeeID, payed);
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == save) {
				videoStore.addRentedMovie(rent1);
			}

		}

	}

	private class ButtonListener13 implements ActionListener {

		public ButtonListener13() throws ParseException {
			int movieID = Integer.parseInt(ID.getText());
			int customerID = Integer.parseInt(id.getText());
			SimpleDateFormat df = new SimpleDateFormat(
					"EEE MMM dd kk:mm:ss zzzz yyyy");
			Date date = df.parse(daTe.getText());
			int employeeID = Integer.parseInt(Id.getText());
			boolean payed = Boolean.parseBoolean(payeD.getText());
			rent1 = new Rent(movieID, customerID, date, employeeID, payed);
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == save) {
				videoStore.returnRentedItem(rent1);
			}

		}

	}

	private void movieFrame(String text) {
		frame = new JFrame(text);
		frame.setSize(400, 400);
		frame.setResizable(false);
		panel = new JPanel();
		display = new JTextArea();
		display.setEditable(false);
		display.setLineWrap(true);
		add = new JButton("Add");
		remove = new JButton("Remove");
		print = new JButton("All movies");
	}

	private void rentFrame(String text) {
		frame = new JFrame(text);
		frame.setSize(400, 400);
		frame.setResizable(false);
		panel = new JPanel();
		display = new JTextArea();
		display.setEditable(false);
		display.setLineWrap(true);
		add = new JButton("Rent");
		remove = new JButton("Return");
		print = new JButton("All rented movies");
	}

	private void customerFrame(String text) {
		frame = new JFrame(text);
		frame.setSize(400, 400);
		frame.setResizable(false);
		panel = new JPanel();
		JTextArea display = new JTextArea();
		display.setEditable(false);
		display.setLineWrap(true);
		add = new JButton("Add");
		remove = new JButton("Remove");
		print = new JButton("All customers");
	}

	private void employeeFrame(String text) {
		frame = new JFrame("Employee");
		frame.setSize(400, 400);
		frame.setResizable(false);
		panel = new JPanel();
		JTextArea display = new JTextArea();
		display.setEditable(false);
		display.setLineWrap(true);
		add = new JButton("Hire");
		remove = new JButton("Fire");
		print = new JButton("All employees");
	}

	private void movieRent(String text) {
		frame = new JFrame(text);
		frame.setSize(400, 400);
		panel = new JPanel();
		movieID = new JLabel("Movie ID: ");
		ID = new JTextField(5);
		ID.setEditable(true);
		customerID = new JLabel("Customer ID: ");
		id = new JTextField(5);
		id.setEditable(true);
		date = new JLabel("Date: ");
		daTe = new JTextField(10);
		daTe.setEditable(true);
		employeeID = new JLabel("Employee ID: ");
		Id = new JTextField(5);
		Id.setEditable(true);
		payed = new JLabel("Payed: ");
		payeD = new JTextField(5);
		payeD.setEditable(true);
	}

	private void movieSaveFrame(String text) {
		frame = new JFrame(text);
		frame.setSize(400, 400);
		frame.setResizable(false);
		panel = new JPanel();
		display.setEditable(false);
		display.setLineWrap(true);
		movieTitle = new JLabel("Title: ");
		title = new JTextField(10);
		title.setEditable(true);
		movieGenre = new JLabel("Genre: ");
		genre = new JTextField(10);
		genre.setEditable(true);
		movieID = new JLabel("Movie ID: ");
		ID = new JTextField(10);
		ID.setEditable(true);
		movieRate = new JLabel("Rate: ");
		rate = new JTextField(3);
		rate.setEditable(true);
	}

	private void customerSaveFrame(String text) {
		frame = new JFrame(text);
		frame.setSize(400, 400);
		frame.setResizable(false);
		panel = new JPanel();
		display.setEditable(false);
		display.setLineWrap(true);
		customerName = new JLabel("Name: ");
		name = new JTextField(10);
		name.setEditable(true);
		customerSurname = new JLabel("Surname: ");
		surname = new JTextField(10);
		surname.setEditable(true);
		customerPhone = new JLabel("Phone: ");
		phone = new JTextField(10);
		phone.setEditable(true);
		customerEmail = new JLabel("Email: ");
		email = new JTextField(10);
		email.setEditable(true);
		customerID = new JLabel("ID: ");
		id = new JTextField(5);
		id.setEditable(true);
	}

	private void employeeSaveFrame(String text) {
		frame = new JFrame(text);
		frame.setSize(400, 400);
		frame.setResizable(false);
		panel = new JPanel();
		display.setEditable(false);
		display.setLineWrap(true);
		employeeName = new JLabel("Name: ");
		name = new JTextField(10);
		name.setEditable(true);
		employeeSurname = new JLabel("Surname: ");
		surname = new JTextField(10);
		surname.setEditable(true);
		employeePhone = new JLabel("Phone: ");
		phone = new JTextField(10);
		phone.setEditable(true);
		employeeEmail = new JLabel("Email: ");
		email = new JTextField(10);
		email.setEditable(true);
		employeeID = new JLabel("ID: ");
		id = new JTextField(5);
		id.setEditable(true);
	}

	private void error(String msg) {
		frame = new JFrame();
		frame.setSize(100, 100);
		panel = new JPanel();
		JTextArea text = new JTextArea();
		text.setText("You don't have " + msg + " by that name!");
		text.setEditable(false);
		panel.add(text);
		frame.add(panel);
		frame.setVisible(true);
	}

}
