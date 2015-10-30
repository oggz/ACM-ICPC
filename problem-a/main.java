import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;
    
public class Pangram {
    private static ArrayList<ArrayList<String>> input;

    public static ArrayList<ArrayList<String>> getInput() {
	Scanner console = new Scanner(System.in);
	Scanner lineTokenizer;
	ArrayList<ArrayList<String>> input = new ArrayList<ArrayList<String>>();

	while (console.hasNextLine()) {
	    ArrayList<String> list = new ArrayList();
	    
	    lineTokenizer = new Scanner(console.nextLine());
	    while (lineTokenizer.hasNext()) {
		list.add(lineTokenizer.next());
	    }
	    input.add(list);
	}
	
	return input;
    }

    public static void pp (Collection input) {
	System.out.println(input.stream()
			   .map(line -> line.getBytes().stream()
				.collect(Collectors.joining("")))
			   .collect(Collectors.joining("\n")));
    }
    
    public static void main(String[] args) throws IOException {
	input = getInput();
	System.out.println(input);

	Set<Character> linechars = new HashSet<>();

	String str = input.stream()
	    .map(a -> a.stream()
		 .collect(Collectors.joining("")))
	    .collect(Collectors.joining("\n"));

	pp(input);
	//str = str.forEach(s -> System.out.println(s));
	
    }

}
