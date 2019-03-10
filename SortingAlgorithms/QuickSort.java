// Java program for implementation of QuickSort
class QuickSort {
	/*
	 * This function takes last element as pivot, places the pivot element at its
	 * correct position in sorted array, and places all smaller (smaller than pivot)
	 * to left of pivot and all greater elements to right of pivot
	 */
	int partition(int sequence[], int low, int high) {
		int pivot = sequence[high];
		int i = (low - 1); // index of smaller element
		for (int j = low; j < high; j++) {
			// If current element is smaller than or
			// equal to pivot
			if (sequence[j] <= pivot) {
				i++;

				// swap sequence[i] and sequence[j]
				int temp = sequence[i];
				sequence[i] = sequence[j];
				sequence[j] = temp;
			}
		}

		// swap sequence[i+1] and sequence[high] (or pivot)
		int temp = sequence[i + 1];
		sequence[i + 1] = sequence[high];
		sequence[high] = temp;

		return i + 1;
	}

	/*
	 * The main function that implements QuickSort() sequence[] --> Array to be sorted,
	 * low --> Starting index, high --> Ending index
	 */
	void sort(int sequence[], int low, int high) {
		if (low < high) {
			/*
			 * pi is partitioning index, sequence[pi] is now at right place
			 */
			int pi = partition(sequence, low, high);

			// Recursively sort elements before
			// partition and after partition
			sort(sequence, low, pi - 1);
			sort(sequence, pi + 1, high);
		}
	}

	/* A utility function to print array of size n */
	static void Display(int sequence[]) {
		int n = sequence.length;
		for (int i = 0; i < n; ++i)
			System.out.print(sequence[i] + " ");
		System.out.println();
	}

	// Driver program
	public static void main(String args[]) {
		int sequence[] = { 3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5 };
		int n = sequence.length;

		System.out.println("Unsorted array");
		Display(sequence);

		QuickSort list = new QuickSort();
		list.sort(sequence, 0, n - 1);

		System.out.println("Sorted array");
		Display(sequence);
	}
}