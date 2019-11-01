package wordPlugin2;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class FrequencyOutputManager {
	
	public void getNFirstFrequencies(List<String> words, Integer N, Boolean naturalOrder) {
		Map<String, Integer> frequency = new HashMap<>();
		Iterator<Entry<String, Integer>> i;
		
		words.stream().forEach(elem -> {
			Integer count = frequency.getOrDefault(elem, 0);
			frequency.put(elem, count+1);
		});
		
		
		if(naturalOrder) {
			i = sortNaturalOrder(frequency);
		} 
		else {
			i = sortReverseOrder(frequency);
		}
		
		printMap(i, N);
	}
	
	private Iterator<Entry<String, Integer>> sortNaturalOrder(Map<String, Integer> map) {
		return map.entrySet().stream()
                .sorted(Entry.comparingByValue())
                .iterator();
	}
	
	private Iterator<Entry<String, Integer>> sortReverseOrder(Map<String, Integer> map) {
		return map.entrySet().stream()
                .sorted(Entry.comparingByValue(Comparator.reverseOrder()))
                .iterator();
	}
	
	private void printMap(Iterator<Entry<String, Integer>> i, Integer N) {
		Integer idx=1;
		while(i.hasNext()) {
			if(idx>N) break;
			
			Entry e = i.next();
	        System.out.println(idx+". "+e.getKey()+" - "+e.getValue());
	        idx++;       
		}
	}

}
