package wordPlugin;

import java.util.List;
import java.util.stream.Collectors;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PreprocessorManager {
	
	public List<String> process(List<String> words, String path){
		try {	
			List<String> stopWords = Files.readAllLines(Paths.get(path));
			
			return words.stream()
					.map(word -> word.toLowerCase().replaceAll("[^a-zA-Z ]", ""))
					.filter(word -> !stopWords.contains(word))
					.collect(Collectors.toList());
		}
		catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}		
	}
	
}
