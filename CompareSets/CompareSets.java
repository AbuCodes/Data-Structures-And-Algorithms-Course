
//java code :

import java.util.Scanner;
import java.util.Arrays;

public class CompareSets {

	public static boolean isSameSet(int[] S1, int[] S2, int n) {
		int i1 = 0; // Index of S1
		int i2 = 0; // Index of S2

		// This variable stores the value when both S1 and S2 are equal at the same
		// exact index
		// We do this so that we can check if the value of a new index is not equal but
		// possibly the same as a previous value to which we will then increment that
		// index
		Integer previousValue = null;

		// This while loop compares S1 and S2 at there specific index.
		// We also take care of any duplicates elements that might occur by not exiting
		// the loop when S1[x] is not equal to S2[x]
		// Instead we check if one those sets at that specific was our previous value to
		// which we will then increment that index and compare S1[x] and S2[x} again
		// If both S1[x] and S2[x] are not equal and are also not duplicates then we
		// know that the sets are not the same
		while (i1 < n && i2 < n) {
			if (S1[i1] == S2[i2]) {
				previousValue = S1[i1];
				i1++;
				i2++;
			} else if (previousValue == S1[i1]) {
				i1++;
			} else if (previousValue == S2[i2]) {
				i2++;
			} else
				return false;
		}
		return true;
	}

	//This our main driver code
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int n;
		System.out.println("Enter Size:");
		n = input.nextInt();
		int S1[] = new int[n];
		int S2[] = new int[n];

		// input in S1 and S2
		System.out.println("Value in S1");
		for (int i = 0; i < n; i++)
			S1[i] = input.nextInt();

		System.out.println("Value in S2");
		for (int i = 0; i < n; i++)
			S2[i] = input.nextInt();

		// sort array
		Arrays.sort(S1);
		Arrays.sort(S2);

		// print array after sorting
		System.out.println("After Sorting");
		for (int i = 0; i < n; i++)
			System.out.print(S1[i] + " ");
		System.out.println();

		for (int i = 0; i < n; i++)
			System.out.print(S2[i] + " ");
		System.out.println();

		if (isSameSet(S1, S2, n) == true)
			System.out.println("S1 and S2 have same sets of element");
		else
			System.out.println("S1 and S2 have different sets of element");

		input.close();
	}
}