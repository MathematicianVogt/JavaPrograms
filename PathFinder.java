
import java.io.*;
import java.util.Scanner;

public class PathFinder {
	// class variables
	private String[] keyVal;
	private BufferedReader br;
	private String line;
	private static DFSGraph myGraph;

	/*
	 * @param arg - the arguement send through commandline to read a file public
	 * constructor to be able to make a buffereader to read the file
	 */
	public PathFinder(String arg) throws FileNotFoundException {

		br = new BufferedReader(new FileReader(arg));

	}

	/*
	 * Reads a given file, takes the tuple of two values and adds them to the
	 * graph in as a key and value.
	 */
	private void Read() throws IOException {

		while ((line = br.readLine()) != null) {
			keyVal = line.split(" ");
			myGraph.add(keyVal[0], keyVal[1]);
		}
		br.close();
	}

	// main method
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		boolean done = false;
		String start;
		String finish;
		// make object of classes
		PathFinder myPath = new PathFinder(args[0]);
		myGraph = new DFSGraph();
		myPath.Read();
		System.out.println(myGraph.toString());

		// loop to find different paths in graph
		while (!done) {
			System.out.println("Source:");
			start = in.nextLine();
			if (start.equals("quit") || start.equals("Quit")) {
				System.exit(0);
			}
			System.out.println("Destination:");
			finish = in.nextLine();
			if (finish.equals("quit") || finish.equals("Quit")) {

				System.exit(0);

			}
			System.out.println(myGraph.findPath(start, finish));

		}

	}
}
