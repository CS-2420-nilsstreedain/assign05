package assign05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Add description here
 * 
 * @author Nils Streedain, Paul Nuffer
 * @version February 22, 2021
 */

public class ArrayListSorter {
	
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
			int mid = (left + right) / 2;
			mergesort(arrayList, tempArrayList, left, mid);
			mergesort(arrayList, tempArrayList, mid + 1, right);
			merge(arrayList, tempArrayList, left, mid + 1, right);
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
		if (leftCursor <= leftBound) { //if elements remain in the left sublist
			while(leftCursor <= leftBound) {
				tempArrayList.set(tempIndex, arrayList.get(leftCursor));
				tempIndex++;
				leftCursor++;
			}
		}
		if (rightCursor <= rightBound) {
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
