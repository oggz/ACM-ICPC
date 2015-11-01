import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;

public class Example {

    static class Scenario {
	public int x, y;
	public int nX, nY;
	public int obs_count;
	public ArrayList obstacles;

	public Scenario(ArrayList init_conds) {
	
	}

	public void AddObstacle(ArrayList obs) {
	    obstacles.add(obs);
	}

	public String Solve() {

	    return "";
	}
    }

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

    public static void main(String[] args) throws IOException {
	input = getInput();
	System.out.println(input);
	ArrayList<Scenario> s_list;
	Scenario cur_scn = null;
	int objs = 0;

	for (int i = 0; i < input.size(); i++) {
	    ArrayList<String> line = input.get(i);
	    
	    if ( line.size() > 2 ) {
		if (line.get(0) == "0" && line.get(1) == "0") {
		    break;
		}
		else {
		    cur_scn = new Scenario(line);
		    for (int j = 0; j < cur_scn.obs_count; j++) {
			i++;
			cur_scn.AddObstacle(input.get(i));
		    }
		}
	    }
	    else if (cur_scn != null){
		cur_scn.AddObstacle(line);
	    }
	}
    }
}
