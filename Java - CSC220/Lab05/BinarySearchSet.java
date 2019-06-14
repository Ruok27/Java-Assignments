package lab05;

public class BinarySearchSet {

	public double[] storage;
	private int capacity;
	private int numItems;

	public BinarySearchSet() {

		double[] storage = new double[6];
		capacity = storage.length;
		numItems = 0;

	}

	public boolean isEmpty() {

		if (numItems == 0) {

			return true;
		}

		else {
			return false;
		}

	}

	public int size() {

		return numItems;

	}

	// **************************************************
	public void grow() {

		double[] tmp = new double[storage.length * 2];

		capacity = tmp.length;

		for (int i = 0; i < storage.length; i++) {

			tmp[i] = storage[i];

		}

		storage = tmp;

	}

	// ****************************************************

	public String toString() {

		String set = "";

		for (int i = 0; i < numItems; i++) {

			set += (i == 0 ? "" : ", ") + storage[i];

		}

		return "[ " + set + " ], " + capacity + ", " + numItems;

	}

	public int sequentialFind(double value) {

		int i = 0;

		while (i < numItems && storage[i] < value) {

			i++;

		}

		return i;

	}

	public boolean remove(double value) {

		/*
		 * removes the given value from the list returns true if this list
		 * contained the given value otherwise, return false be careful about
		 * what states need to be changed after the remove
		 */

		int erase = sequentialFind(value);

		if (storage[erase] != value) {
			return false;

		}
		for (int i = erase; i < numItems - 1; i++) {

			storage[i] = storage[i + 1];

		}

		numItems--;
		return true;

	}

	public boolean sequential_add(double newVal) {

		/*
		 * if this list does not contain the newVal, add it to the correct
		 * position of the list and return true remember that the list is
		 * required to be sorted at all times – that specifies the correct
		 * position for the newVal
		 * 
		 * returns false, if the list already includes the value
		 * 
		 * use a sequential search in this phase (you will write an efficient
		 * add for your assignment)
		 * 
		 * be careful about what states need to be changed after the remove
		 * 
		 */

		int add = sequentialFind(newVal);

		if (add < numItems && storage[add] == newVal) {

			return false;

		}

		if (numItems == capacity) {

			grow();

		}

		for (int i = numItems; i >= add + 1; i--) {

			storage[i] = storage[i - 1];

		}

		storage[add] = newVal;

		numItems++;

		return true;

	}

	public boolean contains(double value) {

		int i = 0;

		while (i < numItems && storage[i] < value) {

			i++;

		}

		if (i == value) {

			return true;
		}

		else

			return false;
	}

	public boolean containsAll(double[] elements) {

		int i = 0;

		while (i < numItems && storage[i] < elements[i]) {

			i++;

		}

		if (i == elements[i]) {

			return true;
		}

		else

			return false;

	}

	/*
	 * public booleanbinary_add(double newVal){
	 * 
	 * // make binary find
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 */

	public BinarySearchSet(double[] input) {

		capacity = storage.length;
		numItems = 0;

		double[] tmp = new double[input.length];

		for (int i = 0; i < input.length; i++) {

			tmp[i] = input[i];

		}

	}

	public void clear() {

		numItems = 0;

	}

}
