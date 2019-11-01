package wordPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;

public class InputManager {
	
	public List<String> loadToList(String path) {
		try {
			File file = new File(path);
			Scanner input = new Scanner(file).useDelimiter("[^a-zA-Z]+");
			List<String> words = new ArrayList<String>();
			
			while(input.hasNext()) {
				words.add(input.next());
			}
			
			input.close();
			return words;
			
		}
		catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		
	}

}
