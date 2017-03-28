package at.fhj.swd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import at.fhj.swd.Customer;
import at.fhj.swd.Order;
import at.fhj.swd.OrderItem;

public class OrderProcessing {

	private static String logFile = System.getProperty("user.dir") + "/log.txt";
	/*
	private static Order createDummyOrders() {
		Customer customer = new Customer ("Andreas", "Dietler", "Somewhere", "over the Rainbow", "666", "Austr(al)ia");
		ArrayList<OrderItem> items = new ArrayList<>();
		items.add(new OrderItem("B123", "Bier", 1.5f, 4));
		Order order = new Order(1000001, customer, items);
		return order;
	}
	*/
	// liest die Bestellung aus dem CSV-Datei
	private static Order readOrder(String fileName) {
		Order readOrder = null;
		Customer readCustomer = null;
		ArrayList<OrderItem> readItems = new ArrayList<OrderItem>();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(fileName));
			String line = null;
			/* Kann die Zeilennummer aus dem File ausgelesen werden?
			 */
			// gibt die anzahl der gelesen Zeilennummern an
			int index = 1;
			String[] fullName = reader.readLine().split(" ");
			index++;
			String address = reader.readLine();
			index++;
			String zipCode = reader.readLine();
			index++;
			String city = reader.readLine();
			index++;
			String country = reader.readLine();
			index++;
			readCustomer = new Customer(fullName[0], fullName[1], address, zipCode, city, country);
			
			// es wird Zeile fuer Zeile eingelesen bis keine mehr vorhanden ist.
			String header[] = reader.readLine().split(";");
			if(checkCSV(header)) {
				while ((line = reader.readLine()) != null) {
					// gelesenen Zeile wird aufgeteilt mit dem Seperator ";"
					String[] splited = line.split(";");
					try {
						// Zuweisen und Umwandeln der seperierten Werte
						String articleNumber = splited[0];
						String name = splited[1];
						float price = Float.parseFloat(splited[2]);
						int quantity = Integer.parseInt(splited[3]);
						// Erstellen eines neuen Countries und übergeben der gelesenen Werte
						readItems.add(new OrderItem(articleNumber, name, price, quantity));
					} catch (Exception error) {
						System.out.println("Fehlerhafte Werte in Zeile " + index + ".");
						System.out.println("Details unter \"" + logFile + "\"");
						LogFileWriter(error);
					}
					index++;
				}
			} else {
				System.out.println("Das CSV-File Format ist falsch.");
			}
			readOrder = new Order(1001, readCustomer, readItems);
		} catch (Exception error) {
			System.out.println("Fehler beim Lesen der Datei" + fileName + ". Bitte Eingaben pruefen");
			System.out.println("Details unter \"" + logFile + "\"");
			LogFileWriter(error);
		} finally {
			if (reader != null){
				try {
					reader.close();
					System.out.println("["+ actualDateTime() + "] - " + "Das Lesen des CSV-Files wurde beendet.");
				} catch (Exception e){}
			}
		}	
		return readOrder;
	}
	// schreibt die Bestellung in eine HTML-Datei
	private static void HTMLWriter(Order order) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new FileOutputStream("C:\\temp\\order\\test"));
			
			// Header wird eingefuegt
			writer.println(dietlera15HTML.getHeader());
			
			writer.println("<body>\n"
				+ "\t<header>\n"
					+ "\t\t<h1>Bestellbest�tigung: "+ order.getOrderID() + "</h1>\n"
				+ "\t</header>\n\n\n"
				+ "\t<main>\n"
					+ "\t\t<h3>Adresse:</h3>\n"
					+ customerToHTML(order.getCustomer().getFirstName() + " " + order.getCustomer().getLastName())
					+ customerToHTML(order.getCustomer().getAddress())
					+ customerToHTML(order.getCustomer().getZipCode())
					+ customerToHTML(order.getCustomer().getCity())
					+ customerToHTML(order.getCustomer().getCountry())
					+ "\n"
					+ "\t\t<table>\n"
						+ "\t\t\t<thead>\n"
							+ "\t\t\t\t<tr id=\"table-header\">"
								+ "<td>Pos</td>"
								+ "<td>Artikelnummer</td>"
								+ "<td>Artikel</td>"
								+ "<td>Einzelpreis</td>"
								+ "<td>Anzahl</td>"
								+ "<td>Summe</td></tr>\n"
						+ "\t\t\t</thead>\n"
						+ "\t\t\t<tbody>\n");
			/* Content einfügen (Länderstatistik)
			 * Für jedes Land wird eine Table-Row eingefügt
			 */ 
			for(int i = 0; i < order.getOrderItem().size(); i++){
				/* fügt eine normale Table-Row ein wenn ein Land weniger als x% Internetnutzer besitzt.
				 * Nur gültig wenn Länder mit weniger als x% geschreiben werden sollen.
				 * Wenn alle Länder geschreiben werden sollen, werden die else if ausgeführt
				 */
					writer.println("\t\t\t\t<tr><td>" + (i+1) + "</td>\n"
							+ "\t\t\t\t<td>" + order.getOrderItem().get(i).getArticleNumber() + "</td>\n"
							+ "\t\t\t\t<td>" + order.getOrderItem().get(i).getName() + "</td>\n"
							+ "\t\t\t\t<td>" + order.getOrderItem().get(i).getPrice() + "</td>\n"
							+ "\t\t\t\t<td>" + order.getOrderItem().get(i).getPrice() + "</td>\n"
							+ "\t\t\t\t<td>" + order.getOrderItem().get(i).calcTotal() + "</td></tr>\n");
			}		
			
			writer.println("\t\t\t</tbody>\n"
							+ "\t\t</table>\n"
						+ "\t</main>\n");
			
			//Footer schreiben.
			writer.println(dietlera15HTML.getFooter());
					
		} catch (IOException error) {
			System.out.println("Fehler beim Schreiben der Datei. Bitte Pfadangabe prüfen.");
			System.out.println("Details unter \"" + logFile + "\"");
			LogFileWriter(error);
		} finally {
			if (writer != null){
				try {
					writer.close();
					System.out.println("["+ actualDateTime() + "] - " + "Das Schreiben des HTML-Files wurde beendet.");
				} catch (Exception e){}
			}
		}
	}
	
	public static String customerToHTML(String text) {
		text = "\t\t<h4>" + text + "</h4>\n";
		return text;
	}
	// Schreibt eine Fehlermeldung in das Log-File
	private static void LogFileWriter(Exception msg){
		PrintWriter writer = null;
		try {
			// neue Zeile ins Log-File hinzufügen
			writer = new PrintWriter(new FileOutputStream(logFile, true));
			writer.println("["+ actualDateTime() + "] - " + msg);								
		} catch (IOException error) {
			/* wenn das Schreiben ins log file nicht funktioniert,
			 * wird in der Console eine Fehlermeldung ausgegeben
			 */
			System.out.println("Error during writing the Log-File to \"" + logFile + "\"");
			System.out.println("Error-Details: " + error);
		} finally {
			if (writer != null){
				try {
					writer.close();
				} catch (Exception e){}
			}
		}
	}
	// Schreibt eine Meldung in das Log-File
	private static void LogFileMessage(String msg){
		PrintWriter writer = null;
		try {
			// neue Zeile ins Log-File hinzufügen
			writer = new PrintWriter(new FileOutputStream(logFile, true));
			writer.println("["+ actualDateTime() + "] - " + msg);								
		} catch (IOException error) {
			/* wenn das Schreiben ins log file nicht funktioniert,
			 * wird in der Console eine Fehlermeldung ausgegeben
			 */
			System.out.println("Error during writing the Log-File to \"" + logFile + "\"");
			System.out.println("Error-Details: " + error);
		} finally {
			if (writer != null){
				try {
					writer.close();
				} catch (Exception e){}
			}
		}
	}
	
	public static void main(String[] args) {
		if(args.length == 1) {
			File folder = new File(args[0]);
			File[] listOfFiles = folder.listFiles();
			listOfFiles[0].getName();
			for(int i=0; i < listOfFiles.length; i++) {
				String FileName = listOfFiles[i].getAbsolutePath();
				System.out.println(listOfFiles[i].getAbsolutePath());
				Order order = readOrder(FileName);
				HTMLWriter(order);
			}
		}
		// Order order = createDummyOrders();
		// float total = order.getTotalSum();
		// System.out.println("Total price: " + total);
	}
	// Ueberpruefen ob alle Spalten im CSV File enthalten sind
	private static boolean checkCSV(String[] header){
		boolean[] col = new boolean[] {false, false, false, false};
		if(header.length != 4) return false;
		if(header[0].equals("articelnr")) col[0] = true;
		if(header[1].equals("name")) col[1] = true;
		if(header[2].equals("price")) col[2] = true;
		if(header[3].equals("quant")) col[3] = true;
		return (col[0] && col[1] && col[2] && col[3]);
	}
	// Ausgabe des aktuellen Datums und der Zeit
	private static String actualDateTime() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		String strDate = sdfDate.format(now);
		return strDate;
	}	
}
