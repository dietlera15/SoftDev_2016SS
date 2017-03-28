package swd_20160617_currency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

	private static final String CURRENCY_URL = "http://houston.fh-joanneum.at/sodev2/";
	
	public static void main(String[] args) {
		BufferedReader reader = null;
		try {
			URL url = new URL(CURRENCY_URL + "currencies");
			HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
			httpCon.setRequestMethod("GET");
			reader = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
			String line = null;
			while ((line= reader.readLine()) != null) {
				System.out.println("Read: " + line);
			}
		} catch(IOException ex) {
			ex.printStackTrace();
		} finally {
			if(reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
				}
			}
		}
	}
}
