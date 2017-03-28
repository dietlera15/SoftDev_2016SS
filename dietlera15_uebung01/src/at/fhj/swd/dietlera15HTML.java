package at.fhj.swd;

public class dietlera15HTML {

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
	
	public static String getStyleShit() {
		return "\t<style>\n"
				+ ".low {color: red;}"
				+ "#table-header {font-weight: bold; color: blue;}"
				+ "#austria {font-weight: bold; color: green;}"
			+ "\t</style>\n";
	}
	
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
}
