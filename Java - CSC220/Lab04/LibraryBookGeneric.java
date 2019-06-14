package lab04;

import java.util.GregorianCalendar;

public class LibraryBookGeneric<Type> extends Book{

	Type holder;
	GregorianCalendar dueDate;

	boolean checkedin;

	public LibraryBookGeneric(long isbn, String author, String title) {

		super(isbn, author, title);
		
	}

	public Type getHolder() {

		return this.holder;

	}

	public GregorianCalendar getDueDate() {

		return this.dueDate;

	}

	public void checkin() {

		// if a library book is checked in, its holder and due date should be
		// set to null

		if (checkedin) {

			this.holder = null;
			this.dueDate = null;

		}

	}

	public void checkout(Type holder, GregorianCalendar dueDate) {

		// If a library book is checked out, its holder and due date should be
		// set accordingly

		if (!checkedin) {
			this.holder = holder;
			this.dueDate = dueDate;

		}

	}
}