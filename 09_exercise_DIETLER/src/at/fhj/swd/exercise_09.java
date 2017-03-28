package at.fhj.swd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class exercise_09 {

	public static void main(String[] args) {

		String path = "/home/student/Downloads/graz_cityrun_105km.csv";

		String[] lineSplit = null;
		BufferedReader reader = null;
		HashMap<String, Integer> nationCount = new HashMap<String, Integer>();
		
		
		
		try {
			reader = new BufferedReader(new FileReader(path));
			String line = null;
			reader.readLine();
			
			while ((line = reader.readLine()) != null) {
				lineSplit = line.split(";"); // splits Strings at every ";"
				String nation = lineSplit[3];
				
				if (nationCount.containsKey(nation)){
					int curCount = nationCount.get(nation);
					curCount++;
					nationCount.put(nation, curCount);
				} else {
					nationCount.put(nation, 1);
				}
				
			}
				for(String curNation : nationCount.keySet()){
					int count = nationCount.get(curNation);
					System.out.println(curNation + ": " + count);
				}

			

		} catch (IOException ex) {
			System.out.println("Fehler beim Lesen der Datei!");
		}
	}
}
