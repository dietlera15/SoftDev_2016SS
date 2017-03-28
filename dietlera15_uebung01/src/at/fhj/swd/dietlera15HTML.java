/**
 * My HTML
 * 
 * @author andreas
 * @version 0.1a Build 0001 May 6, 2016.
 */

package at.fhj.swd;

public class dietlera15HTML {
	
	/**
	 * 
	 * @return HTML Header as a String
	 */
	public static String getHeader(){
		return "<!DOCTYPE html>\n"
				+ "<html xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"en\" xml:lang=\"en\">\n"
				+ "<head>\n"
					+ "\t<meta charset=\"UTF-8\"/>\n"
					+ "\t<meta name=\"viewport\" content=\"width=device-width\"/>\n"
					+ "\t<meta name=\"author\" content=\"Andreas Dietler\"/>\n"
					+ "\t<title>Software Development </title>\n"
					+ getStyleShit()
				+ "</head>\n";
	}
	
	/**
	 * 
	 * @return Style Sheet in an  HTML-Tag as a String
	 */
	public static String getStyleShit() {
		return "\t<style>\n"
				+ ".low {color: red;}"
				+ "#table-header {font-weight: bold; color: blue;}"
				+ "#austria {font-weight: bold; color: green;}"
			+ "\t</style>\n";
	}
	
	/**
	 * 
	 * @return HTML Footer as a String
	 */
	public static String getFooter(){
		return "\t<footer>\n"
				+ "\t\t<h6>Andreas Dietler<br></br>\n"
				+ "\t\tSoftware Development<br></br>\n"
				+ "\t\tSoftware Design WS2015<br></br>\n"
				+ "\t\tFH Joanneum Kapfenberg</h6>\n"
			+ "\t</footer>\n"
		+ "</body>\n"
		+ "</html>\n";
	}
	
	/**
	 * format customer into HTML
	 * @param customer Text
	 * @return text in HTML-Format
	 */
	public static String customerToHTML(String text) {
		return "\t\t<h4>" + text + "</h4>\n";
	}
}
