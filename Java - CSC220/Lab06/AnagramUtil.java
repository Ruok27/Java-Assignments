package lab06;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class AnagramUtil {

	public static class OrderStrings implements Comparator<String> {

		@Override
		public int compare(String arg0, String arg1) {

			return sort(arg0).compareTo(sort(arg1));
		}

	}

	public static String sort(String inputString) {

		char[] str = inputString.toLowerCase().toCharArray();
		String tmp = "";

		// insert sort

		for (int i = 0; i < str.length; i++) {

			char index = str[i];
			int j = i;
			while (j > 0 && str[j - 1] > index) {

				str[j] = str[j - 1];
				j--;
			}
			str[j] = index;

		}

		return new String(str);

	}

	public static boolean areAnagrams(String string1, String string2) {

		return sort(string1).equals(sort(string2));

	}

	public static void insertionSort(String[] inputList) {

		OrderStrings cmp = new OrderStrings();

		for (int i = 0; i < inputList.length; i++) {

			String index = inputList[i];
			int j = i;

			while (j > 0 && cmp.compare(index, inputList[j - 1]) < 0) {

				inputList[j] = inputList[j - 1];
				j--;
			}
			inputList[j] = index;

		}

	}

	public static String[] getLargestAnagramGroup(String[] inputList) {

		ArrayList<String> max = new ArrayList<String>();
		ArrayList<String> current = new ArrayList<String>();

		insertionSort(inputList);

		for (int i = 0; i < inputList.length; i++) {

			if (i == 0 || areAnagrams(inputList[i], inputList[i - 1])) {
				current.add(inputList[i]);
			}

			else {
				if (current.size() > max.size()) {

					max = current;
				}

				current.clear();

				current.add(inputList[i]);
			}
		}

		if (current.size() > max.size()) {

			max = current;
		}

		return max.toArray(new String[] {});

	}

	public static String[] getLargestAnagramGroup(String Filename) {

		
			return getLargestAnagramGroup(readFile(Filename));
	}

	private static String arrayString(String[] array) {
		String str = "[ ";
		for (int i = 0; i < array.length; i++) {
			str += (i != 0 ? ", " : "") + "\"" + array[i] + "\"";
		}
		str += " ]";
		return str;
	}

	// Reads words from a file (assumed to contain one word per line)
	// Returns the words as an array of strings.
	
	public static String[] readFile(String filename) {
		ArrayList<String> results = new ArrayList<String>();
		try {
			BufferedReader input = new BufferedReader(new FileReader(filename));
			while (input.ready()) {
				results.add(input.readLine());
			}
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String[] retval = new String[1];
		return results.toArray(retval);
	}

	public static void main(String[] args) {

		// test 1
		System.out.println("sort test:");
		System.out.println(sort(""));
		System.out.println(sort("hello"));
		System.out.println(sort("tygvcdydf"));
		System.out.println();

		// test 2
		System.out.println("areAnagrams test:");
		System.out.println(areAnagrams("hello", ""));
		System.out.println(areAnagrams("hello", "hello"));
		System.out.println(areAnagrams("cba", "bac"));
		System.out.println(areAnagrams("hello", "OlleH"));

		//test 3
		String[] empty = new String[0];
		insertionSort(empty);
		System.out.println(arrayString(empty));

		String[] one = new String[] { "joy" };
		insertionSort(one);
		System.out.println(arrayString(one));

		String[] two = new String[] { "joy", "ski" };
		insertionSort(two);
		System.out.println(arrayString(two));

		String[] sorted = new String[] { "cat", "fed", "ski", "joy" };
		insertionSort(sorted);
		System.out.println(arrayString(sorted));

		String[] unsorted = new String[] { "joy", "ski", "fed", "cat" };
		insertionSort(unsorted);
		System.out.println(arrayString(unsorted));

		System.out.println(arrayString(getLargestAnagramGroup("sample_word_list.txt")));

	}

}
