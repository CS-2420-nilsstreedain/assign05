package assign05;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayListSorterTester {
	
	private ArrayList<Integer> emptyIntegerArray;
	private ArrayList<Integer> oneIntegerArray;
	private ArrayList<Integer> smallAscendingIntegerArray;
	private ArrayList<Integer> smallPermutedIntegerArray;
	private ArrayList<Integer> smallDescendingIntegerArray;

	private ArrayList<Integer> mediumAscendingIntegerArray;
	private ArrayList<Integer> mediumPermutedIntegerArray;
	private ArrayList<Integer> mediumDescendingIntegerArray;
	
	private <T extends Comparable<? super T>> ArrayList<T> copyAndSort(ArrayList<T> sourceArray) {
		ArrayList<T> destinationArray = new ArrayList<>(sourceArray);
		Collections.sort(destinationArray);
		
		return destinationArray;
	}

	
	@BeforeEach
	void setUp() {
		emptyIntegerArray = new ArrayList<Integer>();
		oneIntegerArray = ArrayListSorter.generateAscending(1);
		smallAscendingIntegerArray = ArrayListSorter.generateAscending(10);
		smallPermutedIntegerArray = ArrayListSorter.generatePermuted(10);
		smallDescendingIntegerArray = ArrayListSorter.generateDescending(10);
		mediumAscendingIntegerArray = ArrayListSorter.generateAscending(1000);
		mediumPermutedIntegerArray = ArrayListSorter.generatePermuted(1000);
		mediumDescendingIntegerArray = ArrayListSorter.generateDescending(1000);
	}
	
	@Test
	void testEmptyIntegerArray() {
		ArrayListSorter.mergesort(emptyIntegerArray);
		
		assertEquals(new ArrayList<Integer>() , emptyIntegerArray);
	}
	
	@Test
	void testOneIntegerArray() {
		ArrayList<Integer> testCopy = copyAndSort(oneIntegerArray);
		ArrayListSorter.mergesort(oneIntegerArray);

		assertEquals(testCopy, oneIntegerArray);
	}
	
	@Test
	void testSmallAscendingIntegerArray() {
		ArrayList<Integer> testCopy = copyAndSort(smallAscendingIntegerArray);
		ArrayListSorter.mergesort(smallAscendingIntegerArray);
		
		assertEquals(testCopy, smallAscendingIntegerArray);
	}
	
	@Test
	void testSmallPermutedIntegerArray() {
		ArrayList<Integer> testCopy = copyAndSort(smallPermutedIntegerArray);
		ArrayListSorter.mergesort(smallPermutedIntegerArray);
		
		assertEquals(testCopy, smallPermutedIntegerArray);
	}

	@Test
	void testSmallDescendingIntegerArray() {
		ArrayList<Integer> testCopy = copyAndSort(smallDescendingIntegerArray);
		ArrayListSorter.mergesort(smallDescendingIntegerArray);
		
		assertEquals(testCopy, smallDescendingIntegerArray);
	}
	
	
	@Test
	void testMediumAscendingIntegerArray() {
		ArrayList<Integer> testCopy = copyAndSort(mediumAscendingIntegerArray);
		ArrayListSorter.mergesort(mediumAscendingIntegerArray);
		
		assertEquals(testCopy, mediumAscendingIntegerArray);
	}
	
	@Test
	void testMediumPermutedIntegerArray() {
		ArrayList<Integer> testCopy = copyAndSort(mediumPermutedIntegerArray);
		ArrayListSorter.mergesort(mediumPermutedIntegerArray);
		
		assertEquals(testCopy, mediumPermutedIntegerArray);
	}

	@Test
	void testMediumDescendingIntegerArray() {
		ArrayList<Integer> testCopy = copyAndSort(mediumDescendingIntegerArray);
		ArrayListSorter.mergesort(mediumDescendingIntegerArray);
		
		assertEquals(testCopy, mediumDescendingIntegerArray);
	}
}
