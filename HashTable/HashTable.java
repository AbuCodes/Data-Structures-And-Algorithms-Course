class LinearProbing {
	
	//We will store our initial table in this size 13 array
	private Integer table[] = new Integer[13];
	//This variable is incremented every time an element is added to our array
	private int count = 0;
	//This variable is a simple flag to check when we will need resizing
	private boolean resize = false;
	//This variable is incremented every time we perform a traversal
	public int traversals = 0;

	// This is the method that will generate the hashCode
	private int hash(int key) {
		return (key) % table.length;
	}

	// This method will return the percentage of how much the table is filled.
	private float precentFilled() {
		return (float) count / table.length;
	}

	// This is the method that will handle our collision by probing
	// If the given hashCode is already filled then we will increment hashCode till
	// we find an empty space in the table
	private int getHashCode(int key, Boolean erase) {
		int hashCode = hash(key);

		if (erase) {
			while (table[hashCode] != key) {
				traversals++;
				hashCode = (hashCode + 1) % table.length;
			}
		}

		else {
			while (table[hashCode] != null) {
				traversals++;
				hashCode = (hashCode + 1) % table.length;
			}
		}
		return hashCode;
	}

	/*
	 * This method takes checks how full our table is and if all criteria are met it
	 * will then resize our table. we do this to make sure that there is always 
	 * space new elements.
	 */
	private void checkTable() {
		resize = true;
		Integer newTable[] = table;

		// Here we check if our table is more than 50% full
		// If so we will double the table size
		if (precentFilled() >= 0.5) {
			table = new Integer[newTable.length * 2];

			for (int i = 0; i < newTable.length; i++) {
				if (newTable[i] != null) {
					Insert(newTable[i]);
				}
			}
		}

		// We also need to control the table size from getting to big so that we are not
		// wasting memory space.
		// If the table is less than 25% filled but is also bigger than 13 then we will
		// decrease the table size by half
		else if (precentFilled() <= 0.25 && newTable.length > 13) {

			table = new Integer[newTable.length / 2];

			for (int i = 0; i < newTable.length; i++) {
				if (newTable[i] != null) {
					Insert(newTable[i]);
				}
			}
		}
		resize = false;
	}

	// In this method we will insert x at the generated position by our hash
	// function
	public void Insert(int x) {
		int position = getHashCode(x, false);
		table[position] = x;

		// Every time we insert a new element we must check if the table is getting
		// full
		if (!resize) {
			count++;
			checkTable();
		}
	}
	
	//This method iterates over our table and displays all of our elements
	public void Display() {

		for (int i = 0; i < table.length; i++) {
			if (table[i] != null) {
				System.out.println(table[i]);
			}
		}
		System.out.println("\n" + table.length);
	}
}

public class HashTable {
	
	//This is simply our driver code. we take the list and feed it into our hashTable with method Insert()
	//Then we display all elements with Display
	public static void main(String[] args) {
		int[] List = { 1, 5, 21, 26, 39, 14, 15, 16, 17, 18, 19, 20, 111, 145, 146 };
		LinearProbing hashTable = new LinearProbing();

		for (int i = 0; i < List.length; i++) {
			hashTable.Insert(List[i]);
		}
		hashTable.Display();
	}
}