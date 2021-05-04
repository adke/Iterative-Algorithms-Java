import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import junit.framework.TestCase;

public class SearcherTest extends TestCase {

	public void testBinarySearch() {
		
		Searcher s = new Searcher();
		int[] arrayToSort = readFile("res/10E4-ordered.txt");
		//'normal' searches
		assertEquals(1978, s.doBinarySearch(arrayToSort, 2010));
		//search for element that is duplicated; should return the 1st occurence
		assertEquals(4993, s.doBinarySearch(arrayToSort, 5000));
        assertEquals(4995, s.doBinarySearch(arrayToSort, 5001));
		//search for element at lower bound
		assertEquals(0, s.doBinarySearch(arrayToSort, 2));
		//search for element at upper bound
		assertEquals(9999, s.doBinarySearch(arrayToSort, 10000));

		//search for non-existent element
		assertEquals(-1, s.doBinarySearch(arrayToSort, 2000));
		//search for non-existent element at lower bound
		assertEquals(-1, s.doBinarySearch(arrayToSort, 1));
		//search for non-existent element at upper bound
		assertEquals(-1, s.doBinarySearch(arrayToSort, 12345));
				
	}

	private int[] readFile(String path) {

		BufferedReader br = null;
		boolean eof = false;
		ArrayList<Integer> temp = new ArrayList<Integer>();
		
		try {
			br = new BufferedReader(new FileReader(path));
		} catch (FileNotFoundException e1) {
			return new int[0];
		}

		while (!eof) {
			try {
				int i = Integer.parseInt(br.readLine());
				temp.add(new Integer(i));
			}
			catch(NumberFormatException e) {
				eof = true;
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				eof = true;
			}		
		}
		
		int[] arrayToSort = new int[temp.size()];
		for (int i = 0; i < temp.size(); i++) {
			arrayToSort[i] = temp.get(i).intValue();
		}
		
		try {
			br.close();
		} catch (IOException e) {
		}
		return arrayToSort;
		
	}
	
}
