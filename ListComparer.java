package extra01listcompare;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ListComparer {

	/** The first ArrayList to store the parsed text **/
	private static ArrayList<String> array1 = new ArrayList<>();
	/** The second ArrayList to store the parsed text **/
	private static ArrayList<String> array2 = new ArrayList<>();
	/** The compelte ArrayList to store the parsed and compared text **/
	private static ArrayList<String> complete = new ArrayList<>();
	
	public static void main(String[] args) {
		
		// Creates the files and scanners to parse through the text
		File one = new File("src/extra01listcompare/mods.txt");
		File two = new File("src/extra01listcompare/compr.txt");
		Scanner scanOne = null, scanTwo = null;

		// Try catch to start the scanners off the files
		try {
			scanOne = new Scanner(one);
			scanTwo = new Scanner(two);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		scanAndCompareLists(scanOne, scanTwo);
		for (String s : complete) {
			System.out.println(s.toString());
		}
		System.out.println("DONE!");
	}
	
	/**
	 * Helper method that takes the two lists and parses through them to fill
	 * the two ArrayLists. They are then compared to find similarities and are
	 * stored within the complete ArrayList
	 * @param list1 The first Scanner containing a list
	 * @param list2 The second Scanner containing a list
	 */
	private static void scanAndCompareLists (Scanner list1, Scanner list2) {
		while (list1.hasNextLine()) {
			array1.add(list1.nextLine());
		}
		while (list2.hasNextLine()) {
			array2.add(list2.nextLine());
		}
		for (String s : array2) {
			for (String t : array1) {
				if (s.equalsIgnoreCase(t)) {
					complete.add(s);
				}
			}
		}
	}

}
