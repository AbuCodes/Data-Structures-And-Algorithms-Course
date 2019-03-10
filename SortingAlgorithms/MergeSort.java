class MergeSort {
	// Merges two sublist of sequence[].
	// First sublist is sequence[l..m]
	// Second sublist is sequence[m+1..r]
	void merge(int sequence[], int l, int m, int r) {
		// Find sizes of two sublists to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temporary arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];

		/* Copy data to temporary arrays */
		for (int i = 0; i < n1; ++i)
			L[i] = sequence[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = sequence[m + 1 + j];

		/* Merge the temporary arrays */

		// Initial indexes of first and second sublists
		int i = 0, j = 0;

		// Initial index of merged sublist array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				sequence[k] = L[i];
				i++;
			} else {
				sequence[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			sequence[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			sequence[k] = R[j];
			j++;
			k++;
		}
	}

	// Main function that sorts sequence[l..r] using
	// merge()
	void sort(int sequence[], int l, int r) {
		if (l < r) {
			// Find the middle point
			int m = (l + r) / 2;

			// Sort first and second halves
			sort(sequence, l, m);
			sort(sequence, m + 1, r);

			// Merge the sorted halves
			merge(sequence, l, m, r);
		}
	}

	/* A utility function to print array of size n */
	static void Display(int sequence[]) {
		int n = sequence.length;
		for (int i = 0; i < n; ++i)
			System.out.print(sequence[i] + " ");
		System.out.println();
	}

	// Driver method
	public static void main(String args[]) {
		int sequence[] = { 3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5 };

		System.out.println("Given Array");
		Display(sequence);

		MergeSort list = new MergeSort();
		list.sort(sequence, 0, sequence.length - 1);

		System.out.println("\nSorted array");
		Display(sequence);
	}
}