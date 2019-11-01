package wordPlugin;


import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyOutputManager {

	public Map<String, Integer> frequency = new HashMap<>();
	
	public void getNFirstFrequencies(List<String> words, Integer N){
		words.stream().forEach(elem -> {
			Integer count = frequency.getOrDefault(elem, 0);
			frequency.put(elem, count+1);
		});
		
		frequency.entrySet()
				 .stream()
				 .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				 .limit(N)
				 .forEach( e -> System.out.println(e.getKey()+" - "+e.getValue()));
	}
} 
