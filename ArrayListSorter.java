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
	
	private static final int MERGE_INSERTION_SORT_MAX = 5;
	private static final int PIVOT_METHOD = 0;
	
	private static Random rng = new Random();
	
	/**
	 * Add Description here
	 * 
	 * @param parameter - parameter description
	 * @throws exception - description for why exception was thrown
	 * @return return description
	 */
	public static <T extends Comparable<? super T>> void mergesort(ArrayList<T> arrayList) {
		ArrayList<T> tempArrayList = generateEmptyArrayList(arrayList.size());
		mergesort(arrayList, tempArrayList, 0, arrayList.size() - 1);
	}
	
	private static <T extends Comparable<? super T>> void mergesort(ArrayList<T> arrayList, ArrayList<T> tempArrayList, int left, int right) {
		if (left < right) {
			if (right - left > MERGE_INSERTION_SORT_MAX)  {
				int mid = (left + right) / 2;
				mergesort(arrayList, tempArrayList, left, mid);
				mergesort(arrayList, tempArrayList, mid + 1, right);
				merge(arrayList, tempArrayList, left, mid + 1, right);
			} else {
				insertionSort(arrayList, left, right);
			}
		}
	}
	
	private static <T extends Comparable<? super T>> void merge(ArrayList<T> arrayList, ArrayList<T> tempArrayList, int leftStart, int rightStart, int rightBound) {

			int leftCursor = leftStart;
			int rightCursor = rightStart;
			int leftBound = rightStart - 1; 
			int tempIndex = leftStart;
			while (leftCursor <= leftBound && rightCursor <= rightBound) {
				if (arrayList.get(leftCursor).compareTo(arrayList.get(rightCursor)) < 0) { //if element at left cursor is "less than" element at right cursor
					tempArrayList.set(tempIndex, arrayList.get(leftCursor)); //set next position of temp list to be element at left cursor
					tempIndex++;
					leftCursor++;
					
				} else {
					tempArrayList.set(tempIndex, arrayList.get(rightCursor)); //set next position of temp list to be element at right cursor
					tempIndex++;
					rightCursor++;
				}
			}
			//if elements remain in the left sublist
			while(leftCursor <= leftBound) {
				tempArrayList.set(tempIndex, arrayList.get(leftCursor));
				tempIndex++;
				leftCursor++;
			}
			while(rightCursor <= rightBound) {
				tempArrayList.set(tempIndex, arrayList.get(rightCursor));
				tempIndex++;
				rightCursor++;
			}
			for (int i = leftStart; i < rightBound + 1; i++) {
				arrayList.set(i, tempArrayList.get(i));
			}
		} 
	
	
	private static <T extends Comparable<? super T>> ArrayList<T> generateEmptyArrayList(int n) {
		ArrayList<T> arrayList = new ArrayList<>();
		for (int i = 0; i < n; i++)
			arrayList.add(null);
		return arrayList;
	}
	
	/**
	 * Add Description here
	 * 
	 * @param parameter - parameter description
	 * @throws exception - description for why exception was thrown
	 * @return return description
	 */	
	public static <T extends Comparable<? super T>> void quicksort(ArrayList<T> arrayList) {
		// Uses the private quicksort driver method to add parameters for recursion
		quicksort(arrayList, 0, arrayList.size() - 1);
	}
	
	private static <T extends Comparable<? super T>> void quicksort(ArrayList<T> arrayList, int left, int right) {
		// Checks that the leftmost index of the sublist is less than the right
		if(left < right) {
			// Defines the pivot for the recursive quicksort methods
			int pivot = partition(arrayList, left, right);
			
			// Quicksorts both sides of the pivot
			quicksort(arrayList, left, pivot - 1);
			quicksort(arrayList, pivot + 1, right);
		}
	}
	
	private static <T extends Comparable<? super T>> int partition(ArrayList<T> arrayList, int start, int end) {
		int pivot = pickPivot(arrayList, start, end);

		// Finds the pivot element and then swaps it with the rightmost element in the sublist
		T pivotElement = arrayList.get(pivot);
		swap(arrayList, end, pivot);
		
		// Sets the left and right cursors based on the start and end of the sublist
		int leftCursor = start - 1;
		int rightCursor = end;
		
		// Loops while the left cursor is less than the right cursor
		while(leftCursor < rightCursor) {
			// While element at left cursor is less than the pivot
			while (leftCursor < end && arrayList.get(++leftCursor).compareTo(pivotElement) < 0);
			
			// While element at right cursor is greater than the pivot
			while (rightCursor > start && arrayList.get(--rightCursor).compareTo(pivotElement) > 0);

			// Swaps elements at right and left cursor if left element is less than right
			if (leftCursor < rightCursor)
				swap(arrayList, leftCursor, rightCursor);
		}
		
		// Restore the pivot: swap with leftmost element greater than the pivot
		swap(arrayList, end, leftCursor);
		
		// Return the index of the pivot
		return leftCursor;
	}
	
	/**This method picks a pivot for an arrayList between specific bounds. This method also
	 * changes the way in which it picks a pivot based on a private final variable in this class,
	 * to allow the comparison of pivot picking methods.
	 * @param <T> a generic type that extends comparable
	 * @param arrayList the arrayList to pick the pivot value for
	 * @param left the minimum index to be included in the array the pivot is picked for
	 * @param right the maximum index to be included in the array the pivot is picked for
	 * @return int pivot, the index to be used as a pivot value
	 */
	private static <T extends Comparable<? super T>> int pickPivot(ArrayList<T> arrayList, int left, int right) {
		int middle = left + ((right - left) / 2);
		
		switch(PIVOT_METHOD) {
		case 0: //middle index
			return middle;
		case 1: //median of three
			if (arrayList.get(left).compareTo(arrayList.get(middle)) > 0)
				swap(arrayList, left, middle);
			if (arrayList.get(left).compareTo(arrayList.get(right)) > 0)
				swap(arrayList, left, right);
			if (arrayList.get(middle).compareTo(arrayList.get(right)) > 0)
				swap(arrayList, middle, right);
			swap(arrayList, middle, right - 1);
			
			return middle;
		case 2:	//random index
			return rng.nextInt(right + 1);
		default:
			return 0;
		}
	}
	
	private static <T extends Comparable<? super T>> void swap(ArrayList<T> arrayList, int indexOne, int indexTwo) {
		T tempTwo = arrayList.get(indexTwo);
		arrayList.set(indexTwo, arrayList.get(indexOne));
		arrayList.set(indexOne, tempTwo);
	}
	
	/**This method performs insertion sort on an arrayList of generic comparable type, between a start and end index.
	 * @param <T> a generic type that extends comparable
	 * @param arrayList the arrayList to perform an insertion sort inside
	 * @param leftStart the minimum index to be included in the sort
	 * @param rightBound the maximum index to be included in the sort
	 */
	private static <T extends Comparable<? super T>> void insertionSort(ArrayList<T> arrayList, int leftStart, int rightBound) {
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
	 * 0, and increasing in value by 1 for each element added until the ArrayList has size elements.
	 * 
	 * @param size, the amount of elements to be in the generated ArrayList
	 * @return generatedAscendingArray, an array of ascending Integers. Returns an empty ArrayList
	 * if size < 1.
	 */	
	public static ArrayList<Integer> generateAscending(int size) {
		ArrayList<Integer> generatedAscendingArray = new ArrayList<>();
		for (int i = 1; i < size + 1; i++) 
			generatedAscendingArray.add(i);
		return generatedAscendingArray;
	}
	
	/**
	 * This method generates an ArrayList of type Integer with a specific number of unique elements,
	 * shuffled randomly using Collectoins.shuffle
	 * 
	 * @param size, the amount of elements to be in the generated ArrayList
	 * @return arrayToShuffle, an array of shuffled Integers. Returns an empty ArrayList
	 * if size < 1.
	 */	
	public static ArrayList<Integer> generatePermuted(int size) {
		ArrayList<Integer> arrayToShuffle = new ArrayList<>();
		for (int i = 1; i < size + 1; i++) 
			arrayToShuffle.add(i);
		Collections.shuffle(arrayToShuffle);
		return arrayToShuffle;
	}
	
	/**
	 * This method generates an ArrayList of type Integer with elements beginning at
	 * value equal to size, and decreasing in value by 1 for each element added until the ArrayList has size elements.
	 * 
	 * @param size, the amount of elements to be in the generated ArrayList
	 * @return generatedDescendingArray, an array of descending Integers. Returns an empty ArrayList
	 * if size < 1.
	 */	
	public static ArrayList<Integer> generateDescending(int size) {
		ArrayList<Integer> generatedDescendingArray = new ArrayList<>();
		for (int i = size; i > 0; i--) 
			generatedDescendingArray.add(i);
		return generatedDescendingArray;
	}
}
