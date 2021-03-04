package assign05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Add description here
 * 
 * @author Nils Streedain, Paul Nuffer
 * @version February 22, 2021
 */

public class ArrayListSorter {

	private static final int INSERTION_SORT_THRESHOLD = 7;
	private static final int PIVOT_METHOD = 1;

	private static Random rng = new Random();

	/**
	 * Public driver method used to supply parameters to a private recursive
	 * mergesort driver method. An arrayList that is put into this method will be
	 * sorted using mergesort.
	 * 
	 * @param arrayList - arrayList to be sorted using mergesort
	 */
	public static <T extends Comparable<? super T>> void mergesort(ArrayList<T> arrayList) {
		// Creates a temporary ArrayList to store values for the mergesort method
		ArrayList<T> tempArrayList = generateEmptyArrayList(arrayList.size());

		// Passes the a arrayList, temporary arrayList, and the left and right bounds
		// for the recursive mergesort method
		mergesort(arrayList, tempArrayList, 0, arrayList.size() - 1);
	}

	/**
	 * Private mergesort driver method to sort an ArrayList using a sublist between
	 * left and right. An arrayList that is put into this method will be sorted
	 * using mergesort.
	 * 
	 * @param arrayList     - arrayList to be sorted using mergesort
	 * @param tempArrayList - arrayList used for temporary storage of elements
	 * @param left          - Left bound of sublist to be sorted
	 * @param right         - Right bound of sublist to be sorted
	 */
	private static <T extends Comparable<? super T>> void mergesort(ArrayList<T> arrayList, ArrayList<T> tempArrayList,
			int left, int right) {

		// Checks that the left end of the sublist is below the right end
		if (left < right) {

			// Checks that the difference between right and left is greater than
			// MERGE_INSERTION_SORT_MAX, if not, insertion sort is used instead of mergesort
			if (right - left > INSERTION_SORT_THRESHOLD) {
				// Finds the missle index between left and right
				int mid = (left + right) / 2;
				
				// Recursively sorts the left and right side of the middle element
				mergesort(arrayList, tempArrayList, left, mid);
				mergesort(arrayList, tempArrayList, mid + 1, right);
				
				// Merges the sorted sublists from the previous step
				merge(arrayList, tempArrayList, left, mid + 1, right);
			} else {
				// Uses insertion sort if the insertionsort threshold is met
				insertionSort(arrayList, left, right);
			}
		}
	}

	/**
	 * Private helper method to combine two sorted sublists for the mergesort method
	 * 
	 * @param arrayList     - arrayList to be sorted using mergesort
	 * @param tempArrayList - arrayList used for temporary storage of elements
	 * @param leftStart     - Left bound and start of sublist to be sorted
	 * @param rightStart    - Right start of sublist to be sorted
	 * @param rightBound    - Right bound of sublist to be sorted
	 */
	private static <T extends Comparable<? super T>> void merge(ArrayList<T> arrayList, ArrayList<T> tempArrayList,
			int leftStart, int rightStart, int rightBound) {

		// Initializes tempIndex, leftCursor, rightCursor, and leftBound.
		int tempIndex = leftStart;
		int leftCursor = leftStart;
		int rightCursor = rightStart;
		int leftBound = rightStart - 1;

		// Loops while left and right cursor have not reached left and right bound
		while (leftCursor <= leftBound && rightCursor <= rightBound) {

			// If element at left cursor is "less than" element at right cursor
			if (arrayList.get(leftCursor).compareTo(arrayList.get(rightCursor)) < 0) {

				// Set next position of temp list to be element at left cursor
				tempArrayList.set(tempIndex, arrayList.get(leftCursor));

				// Increments tempIndex and left cursor
				tempIndex++;
				leftCursor++;
			} else {
				// Sets next position of temp list to be element at right cursor
				tempArrayList.set(tempIndex, arrayList.get(rightCursor));

				// Increments tempIndex and right cursor
				tempIndex++;
				rightCursor++;
			}
		}

		// Adds all elements left in left sublist to the temp arrayList
		while (leftCursor <= leftBound) {
			tempArrayList.set(tempIndex, arrayList.get(leftCursor));
			tempIndex++;
			leftCursor++;
		}

		// Adds all elements left in left sublist to the temp arrayList
		while (rightCursor <= rightBound) {
			tempArrayList.set(tempIndex, arrayList.get(rightCursor));
			tempIndex++;
			rightCursor++;
		}

		// Adds values from tempArrayList back to arrayList but in order
		for (int i = leftStart; i < rightBound + 1; i++)
			arrayList.set(i, tempArrayList.get(i));
	}

	/**
	 * Generates an empty ArrayList the length of n.
	 * 
	 * @param n - length of empty ArrayList to be generated
	 * @return arrayList - generated ArrayList
	 */
	private static <T extends Comparable<? super T>> ArrayList<T> generateEmptyArrayList(int n) {
		ArrayList<T> arrayList = new ArrayList<>();
		for (int i = 0; i < n; i++)
			arrayList.add(null);
		return arrayList;
	}

	/**
	 * Public driver method used to supply parameters to a private recursive
	 * quicksort driver method. An arrayList that is put into this method will be
	 * sorted using quicksort.
	 * 
	 * @param arrayList - arrayList to be sorted using quicksort
	 */
	public static <T extends Comparable<? super T>> void quicksort(ArrayList<T> arrayList) {
		// Uses the private quicksort driver method to add parameters for recursion
		quicksort(arrayList, 0, arrayList.size() - 1);
	}

	/**
	 * Private quicksort driver method to sort an ArrayList using a sublist between
	 * left and right. An arrayList that is put into this method will be sorted
	 * using quicksort.
	 * 
	 * @param arrayList - arrayList to be sorted using quicksort
	 * @param left      - Left bound of sublist to be sorted
	 * @param right     - Right bound of sublist to be sorted
	 */
	private static <T extends Comparable<? super T>> void quicksort(ArrayList<T> arrayList, int left, int right) {
		// Checks that the leftmost index of the sublist is less than the right
		if (left < right) {
			// Defines the pivot for the recursive quicksort methods
			int pivot = partition(arrayList, left, right);

			// Quicksorts both sides of the pivot
			quicksort(arrayList, left, pivot - 1);
			quicksort(arrayList, pivot + 1, right);
		}
	}

	/**
	 * Private helper method for quicksort that takes an ArrayList, chooses a pivot,
	 * and moves all values greater than the pivot above it, and all lesser values
	 * below it. Then the method returns the leftCursor to be used as the next pivot
	 * in the recursive quicksort method.
	 * 
	 * @param arrayList - arrayList to be sorted using quicksort
	 * @param start     - Start bound of sublist to be sorted
	 * @param end       - End bound of sublist to be sorted
	 * @return leftCursor - Next pivot in the recursive quicksort method
	 */
	private static <T extends Comparable<? super T>> int partition(ArrayList<T> arrayList, int start, int end) {
		int pivot = pickPivot(arrayList, start, end);

		// Finds the pivot element and then swaps it with the rightmost element in the
		// sublist
		T pivotElement = arrayList.get(pivot);
		swap(arrayList, end, pivot);

		// Sets the left and right cursors based on the start and end of the sublist
		int leftCursor = start - 1;
		int rightCursor = end;

		// Loops while the left cursor is less than the right cursor
		while (leftCursor < rightCursor) {
			// While element at left cursor is less than the pivot
			while (leftCursor < end && arrayList.get(++leftCursor).compareTo(pivotElement) < 0)
				;

			// While element at right cursor is greater than the pivot
			while (rightCursor > start && arrayList.get(--rightCursor).compareTo(pivotElement) > 0)
				;

			// Swaps elements at right and left cursor if left element is less than right
			if (leftCursor < rightCursor)
				swap(arrayList, leftCursor, rightCursor);
		}

		// Restore the pivot: swap with leftmost element greater than the pivot
		swap(arrayList, end, leftCursor);

		// Return the index of the pivot
		return leftCursor;
	}

	/**
	 * This method picks a pivot for an arrayList between specific bounds. This
	 * method also changes the way in which it picks a pivot based on a private
	 * final variable in this class, to allow the comparison of pivot picking
	 * methods. If no method, or a non-existant method is chosen, left index will be
	 * returned.
	 * 
	 * @param <T>       - a generic type that extends comparable
	 * @param arrayList - the arrayList to pick the pivot value for
	 * @param left      - the minimum index to be included in the array
	 * @param right     - the maximum index to be included in the array
	 * @return pivot - the index to be used as a pivot value
	 */
	private static <T extends Comparable<? super T>> int pickPivot(ArrayList<T> arrayList, int left, int right) {
		int middle = left + ((right - left) / 2);

		// Determines the pivot method to be used for quicksort.
		switch (PIVOT_METHOD) {

		// Returns the median of three values, the leftmost index, the rightmost index,
		// and the middle index
		case 0:
			// Compares left and middle and puts the larger in the middle
			if (arrayList.get(left).compareTo(arrayList.get(middle)) > 0)
				swap(arrayList, left, middle);

			// Compares left and right and puts the larger in the right
			if (arrayList.get(left).compareTo(arrayList.get(right)) > 0)
				swap(arrayList, left, right);

			// Compares middle and right and puts the larger in the right
			if (arrayList.get(middle).compareTo(arrayList.get(right)) > 0)
				swap(arrayList, middle, right);
			
			return middle;

		// Returns index in the middle of left and right
		case 1:
			return middle;

		// Returns a random index
		case 2:
			return left + rng.nextInt(right - left + 1);

		// If no method, or a non-existent method is chosen, left index will be returned.
		default:
			return left;
		}
	}

	/**
	 * Private helper method to swap two elements in an ArrayList.
	 * 
	 * @param arrayList - arrayList to have elements swapped
	 * @param indexOne  - First index to be swapped
	 * @param indexTwo  - Second index to be swapped
	 */
	private static <T extends Comparable<? super T>> void swap(ArrayList<T> arrayList, int indexOne, int indexTwo) {
		// Creates a variable of type T to store the placeholder element
		T tempTwo = arrayList.get(indexTwo);

		// Sets indexOn and indexTwo to their respective values
		arrayList.set(indexTwo, arrayList.get(indexOne));
		arrayList.set(indexOne, tempTwo);
	}

	/**
	 * This method performs insertion sort on an arrayList of generic comparable
	 * type, between a start and end index.
	 * 
	 * @param <T>        a generic type that extends comparable
	 * @param arrayList  the arrayList to perform an insertion sort inside
	 * @param leftStart  the minimum index to be included in the sort
	 * @param rightBound the maximum index to be included in the sort
	 */
	private static <T extends Comparable<? super T>> void insertionSort(ArrayList<T> arrayList, int leftStart,
			int rightBound) {
		// Loops over each element of arrayList other than the first
		for (int i = leftStart + 1; i < rightBound + 1; i++) {

			// Stores element determined by iteration of the loop
			T val = arrayList.get(i);

			// Shifts values larger than i but placed lower than i in the array up 1 index
			int j;
			for (j = i - 1; j >= leftStart && (arrayList.get(j).compareTo(val) > 0); j--)
				arrayList.set(j + 1, arrayList.get(j));

			// Places value in the open space created by the shift of larger values
			arrayList.set(j + 1, val);
		}
	}

	/**
	 * This method generates an ArrayList of type Integer with elements beginning at
	 * 0, and increasing in value by 1 for each element added until the ArrayList
	 * has size elements.
	 * 
	 * @param size, the amount of elements to be in the generated ArrayList
	 * @return generatedAscendingArray, an array of ascending Integers. Returns an
	 *         empty ArrayList if size < 1.
	 */
	public static ArrayList<Integer> generateAscending(int size) {
		// Creates a new Integer ArrayList
		ArrayList<Integer> generatedAscendingArray = new ArrayList<>();

		// Adds each value of i to the arrayList from 1 to size
		for (int i = 1; i < size + 1; i++)
			generatedAscendingArray.add(i);

		return generatedAscendingArray;
	}

	/**
	 * This method generates an ArrayList of type Integer with a specific number of
	 * unique elements, shuffled randomly using Collectoins.shuffle
	 * 
	 * @param size, the amount of elements to be in the generated ArrayList
	 * @return arrayToShuffle, an array of shuffled Integers. Returns an empty
	 *         ArrayList if size < 1.
	 */
	public static ArrayList<Integer> generatePermuted(int size) {
		// Creates a new Integer ArrayList using generateAscending
		ArrayList<Integer> arrayToShuffle = generateAscending(size);

		// Shuffles the array to randomize it
		Collections.shuffle(arrayToShuffle);

		return arrayToShuffle;
	}

	/**
	 * This method generates an ArrayList of type Integer with elements beginning at
	 * value equal to size, and decreasing in value by 1 for each element added
	 * until the ArrayList has size elements.
	 * 
	 * @param size, the amount of elements to be in the generated ArrayList
	 * @return generatedDescendingArray, an array of descending Integers. Returns an
	 *         empty ArrayList if size < 1.
	 */
	public static ArrayList<Integer> generateDescending(int size) {
		// Creates a new Integer ArrayList
		ArrayList<Integer> generatedDescendingArray = new ArrayList<>();

		// Adds each value of i to the arrayList from size down to 1
		for (int i = size; i > 0; i--)
			generatedDescendingArray.add(i);

		return generatedDescendingArray;
	}
}
