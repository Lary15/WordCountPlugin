package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import wordPlugin.PreprocessorManager;

class PreprocessorManagerTest {

	@Test
	void test_should_print_words() {
		PreprocessorManager processor = new PreprocessorManager();

		List<String> words = Stream.of("hasn't", "it's", "define").collect(Collectors.toList());
		List<String> processedWords = processor.process(words, "resources/stop-words.txt");
		
		assertEquals(processedWords.get(0), "hasnt");
	}
}
