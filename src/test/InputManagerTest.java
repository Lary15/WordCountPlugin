package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import wordPlugin.InputManager;


class InputManagerTest {

	@Test
	void should_throw_error_if_file_not_found() {
		List<String> e = new ArrayList<String>();
		
		try {
			InputManager input = new InputManager();
			e = input.loadToList("alice.txt");
			fail("expecting a runtime exception");
		}
		catch(RuntimeException error) {
			assertTrue(true);
		}
	}
	
	@Test
	void should_get_a_non_empty_list_to_dracula() {
		List<String> e = new ArrayList<String>();
		InputManager input = new InputManager();
		e = input.loadToList("resources/dracula.txt");
	
		assertFalse(e.isEmpty());	
	}

}