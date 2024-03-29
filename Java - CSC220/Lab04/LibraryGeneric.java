package lab04;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Class representation of a library (a collection of library books).
 * 
 */
public class LibraryGeneric<Type> {

	private ArrayList<LibraryBookGeneric<Type>> library;

	public LibraryGeneric() {
		library = new ArrayList<LibraryBookGeneric<Type>>();
	}

	/**
	 * Add the specified book to the library, assume no duplicates.
	 * 
	 * @param isbn
	 *            -- ISBN of the book to be added
	 * @param author
	 *            -- author of the book to be added
	 * @param title
	 *            -- title of the book to be added
	 */
	public void add(long isbn, String author, String title) {
		library.add(new LibraryBookGeneric<Type>(isbn, author, title));
	}

	/**
	 * Add the list of library books to the library, assume no duplicates.
	 * 
	 * @param list
	 *            -- list of library books to be added
	 */
	public void addAll(ArrayList<LibraryBookGeneric<Type>> list) {
		library.addAll(list);
	}

	/**
	 * Add books specified by the input file. One book per line with ISBN,
	 * author, and title separated by tabs.
	 * 
	 * If file does not exist or format is violated, do nothing.
	 * 
	 * @param filename
	 */
	public void addAll(String filename) {
		ArrayList<LibraryBookGeneric<Type>> toBeAdded = new ArrayList<LibraryBookGeneric<Type>>();

		try {
			Scanner fileIn = new Scanner(new File(filename));
			int lineNum = 1;

			while (fileIn.hasNextLine()) {
				String line = fileIn.nextLine();

				Scanner lineIn = new Scanner(line);
				lineIn.useDelimiter("\\t");

				if (!lineIn.hasNextLong())
					throw new ParseException("ISBN", lineNum);
				long isbn = lineIn.nextLong();

				if (!lineIn.hasNext())
					throw new ParseException("Author", lineNum);
				String author = lineIn.next();

				if (!lineIn.hasNext())
					throw new ParseException("Title", lineNum);
				String title = lineIn.next();

				toBeAdded.add(new LibraryBookGeneric<Type>(isbn, author, title));

				lineNum++;
			}
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage() + " Nothing added to the library.");
			return;
		} catch (ParseException e) {
			System.err.println(e.getLocalizedMessage() + " formatted incorrectly at line " + e.getErrorOffset()
					+ ". Nothing added to the library.");
			return;
		}

		library.addAll(toBeAdded);
	}

	/**
	 * Returns the holder of the library book with the specified ISBN. If no
	 * book with the specified ISBN is in the library, returns null.
	 * 
	 * @param isbn
	 *            -- ISBN of the book to be looked up
	 */
	public Type lookup(long isbn) {

		// *FILL IN -- do not return null unless appropriate
		for (int i = 0; i < library.size(); i++) {

			LibraryBookGeneric<Type> book = library.get(i);

			if (book.getIsbn() == isbn) {

				return book.getHolder();

			}

		}
		return null;
	}

	/**
	 * Sets the holder and due date of the library book with the specified ISBN.
	 * If no book with the specified ISBN is in the library, returns false. If
	 * the book with the specified ISBN is already checked out, returns false.
	 * Otherwise, returns true.
	 * 
	 * @param isbn
	 *            -- ISBN of the library book to be checked out
	 * @param holder
	 *            -- new holder of the library book
	 * @param month
	 *            -- month of the new due date of the library book
	 * @param day
	 *            -- day of the new due date of the library book
	 * @param year
	 *            -- year of the new due date of the library book
	 */
	public boolean checkout(long isbn, Type holder, int month, int day, int year) {
		// *FILL IN -- do not return false unless appropriate

		for (int i = 0; i < library.size(); i++) {

			LibraryBookGeneric<Type> book = library.get(i);

			if (book.getIsbn() == isbn) {

				if (book.getHolder() == null) {
					// If the book has no current holders it performs checkout
					// and sets a holder and due date
					book.checkout(holder, new GregorianCalendar(year, month, day));
					return true;
				}
				// if the book is already checked out return false
				return false;
			}
		}

		// if the book with that isbn is not in the library it returns false
		return false;
	}

	// *** you will implement the rest of the methods for your assignment
	// *** don't touch them before finishing the lab portion

	/**
	 * Returns the list of library books checked out to the specified holder.
	 * 
	 * If the specified holder has no books checked out, returns an empty list.
	 * 
	 * @param holder
	 *            -- holder whose checked out books are returned
	 */
	public ArrayList<LibraryBookGeneric<Type>> lookup(Type holder) {
		// FILL IN -- do not return null
		// look again later

		ArrayList<LibraryBookGeneric<Type>> list = new ArrayList<LibraryBookGeneric<Type>>();

		for (int i = 0; i < library.size(); i++) {

			if (library.get(i).getHolder() != null && library.get(i).getHolder().equals(holder)) {

				list.add(library.get(i));

			}

			// return list;
		}

		// no books checked out
		// list.clear();
		return list;

	}

	/**
	 * Unsets the holder and due date of the library book. If no book with the
	 * specified ISBN is in the library, returns false. If the book with the
	 * specified ISBN is already checked in, returns false. Otherwise, returns
	 * true.
	 * 
	 * @param isbn
	 *            -- ISBN of the library book to be checked in
	 */
	public boolean checkin(long isbn) {

		// *FILL IN -- do not return false unless appropriate
		// look back later

		for (int i = 0; i < library.size(); i++) {

			LibraryBookGeneric<Type> book = library.get(i);

			if (book.getIsbn() != isbn) {

				// If checking in is performed it checks in and unsets the
				// holder and due date
				return true;

				// if the book is already checked out return false

			}

			return false;
		}

		// if the book with that isbn is not in the library it returns false
		return false;

	}

	/**
	 * Unsets the holder and due date for all library books checked out by the
	 * specified holder. If no books with the specified holder are in the
	 * library, returns false; Otherwise, returns true.
	 * 
	 * @param holder
	 *            -- holder of the library books to be checked in
	 */
	public boolean checkin(Type holder) {
		// *FILL IN -- do not return false unless appropriate
		// look back later

		for (int i = 0; i < library.size(); i++) {

			LibraryBookGeneric<Type> book = library.get(i);

			if (book.getHolder() == holder) {

				if (book.getHolder() != null) {
					// If checking in is performed it checks in and unsets the
					// holder and due date
					book.checkin();
					return true;
				}
				// if the book is already checked out return false
				return false;
			}
		}

		// if the book with that isbn is not in the library it returns false
		return false;

	}

	// PHASE 3

	/**
	 * Returns the list of library books, sorted by ISBN (smallest ISBN first).
	 */
	public ArrayList<LibraryBookGeneric<Type>> getInventoryList() {
		ArrayList<LibraryBookGeneric<Type>> libraryCopy = new ArrayList<LibraryBookGeneric<Type>>();
		libraryCopy.addAll(library);

		OrderByIsbn comparator = new OrderByIsbn();

		sort(libraryCopy, comparator);

		return libraryCopy;
	}

	/**
	 * Performs a SELECTION SORT on the input ArrayList. 1. Find the smallest
	 * item in the list. 2. Swap the smallest item with the first item in the
	 * list. 3. Now let the list be the remaining unsorted portion (second item
	 * to Nth item) and repeat steps 1, 2, and 3.
	 */
	private static <ListType> void sort(ArrayList<ListType> list, Comparator<ListType> c) {
		for (int i = 0; i < list.size() - 1; i++) {
			int j, minIndex;
			for (j = i + 1, minIndex = i; j < list.size(); j++)
				if (c.compare(list.get(j), list.get(minIndex)) < 0)
					minIndex = j;
			ListType temp = list.get(i);
			list.set(i, list.get(minIndex));
			list.set(minIndex, temp);
		}
	}

	/**
	 * Comparator that defines an ordering among library books using the ISBN.
	 */
	protected class OrderByIsbn implements Comparator<LibraryBookGeneric<Type>> {

		@Override
		public int compare(LibraryBookGeneric<Type> o1, LibraryBookGeneric<Type> o2) {

			long diff = o1.getIsbn() - o2.getIsbn();

			if (diff < 0)

			{

				return -1;
			}

			else if (diff == 0) {

				return 0;
			}

			else {
				return 1;

			}

		}

		// FILL IN - write the compare method
	}

	/**
	 * Returns the list of library books, sorted by author
	 */

	public ArrayList<LibraryBookGeneric<Type>> getOrderedByAuthor() {

		ArrayList<LibraryBookGeneric<Type>> libraryCopy = new ArrayList<LibraryBookGeneric<Type>>();
		libraryCopy.addAll(library);

		OrderByAuthor comparator = new OrderByAuthor();

		sort(libraryCopy, comparator);

		return libraryCopy;

	}

	/**
	 * Returns the list of library books whose due date is older than the input
	 * date. The list is sorted by date (oldest first).
	 *
	 * If no library books are overdue, returns an empty list.
	 */

	public ArrayList<LibraryBookGeneric<Type>> getOverdueList(int month, int day, int year) {

		ArrayList<LibraryBookGeneric<Type>> libraryCopy = new ArrayList<LibraryBookGeneric<Type>>();
		libraryCopy.addAll(library);

		OrderByDueDate comparator = new OrderByDueDate();

		sort(libraryCopy, comparator);
		
		
		

		return libraryCopy;

	}

	/**
	 * Comparator that defines an ordering among library books using the author,
	 * and book title as a tie-breaker.
	 */

	// go back and check if comparing strings works
	protected class OrderByAuthor implements Comparator<LibraryBookGeneric<Type>> {

		@Override
		public int compare(LibraryBookGeneric<Type> o1, LibraryBookGeneric<Type> o2) {

			int diffAut = o1.getAuthor().compareTo(o2.getAuthor());

			if (diffAut < 1)

			{

				return -1;
			}

			else if (diffAut == 0) {

				return 0;
			}

			else {
				return 1;

			}

		}

	}

	/**
	 * Comparator that defines an ordering among library books using the due
	 * date.
	 */

	
	protected class OrderByDueDate implements Comparator<LibraryBookGeneric<Type>> {

		@Override
		public int compare(LibraryBookGeneric<Type> o1, LibraryBookGeneric<Type> o2) {
			
			
			
			return 0;
		}

		// FILL IN - write the compare method

	}

}
