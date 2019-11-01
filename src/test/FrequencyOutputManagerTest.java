package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import wordPlugin.FrequencyOutputManager;

class FrequencyOutputManagerTest {

	@Test
	void test_should_make_a_hash_map() {
		FrequencyOutputManager frequency = new FrequencyOutputManager();
		
		Map<String, Integer> map= new HashMap<String, Integer>();
		Map<String, Integer> newMap= new HashMap<String, Integer>();
		
		newMap.put("oi",2);
		newMap.put("yamin",1);
		
		List<String> words = Stream.of("oi", "yamin", "oi").collect(Collectors.toList());
		frequency.getNFirstFrequencies(words, 3);
		
		map = frequency.frequency;
		
		assertEquals(newMap, map);
	}
}
