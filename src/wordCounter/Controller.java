package wordCounter;

import java.io.File;
import java.lang.ClassLoader;
import java.lang.reflect.Method;
import java.util.List;

import org.ini4j.*;


public class Controller {
	
	private static Ini config;
	private static Class<?> input;
	private static Class<?> preprocessor;
	private static Class<?> frequencies;
	
	public static void main(String[] args) {
		load_plugins(args[0]);
		
		try {
			Object inputInst = input.newInstance();
			Object preprocessorInst = preprocessor.newInstance();
			Object frequenciesInst = frequencies.newInstance();
			
			Method load = input.getMethod("loadToList", new Class[] {String.class});
			Method process = preprocessor.getMethod("process", new Class[] { List.class, String.class});
			Method print = frequencies.getMethod("getNFirstFrequencies", new Class[] { List.class, Integer.class, Boolean.class});
			
			List<String> words = (List<String>) load.invoke(inputInst, config.get("Files","dracula"));
			List<String> processedWords = (List<String>) process.invoke(preprocessorInst, words, config.get("Files","stopWords"));
			print.invoke(frequenciesInst, processedWords, Integer.parseInt(args[1]), false);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void load_plugins(String path) {
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		
		try {
			config = new Ini(new File(path));
			
			input = classLoader.loadClass(config.get("Plugins","input"));
			preprocessor = classLoader.loadClass(config.get("Plugins","preprocessor"));
			frequencies = classLoader.loadClass(config.get("Plugins", "frequencies"));
			
		}
		catch(Exception e){
			throw new RuntimeException(e.getMessage());
		}
	}
	
}
