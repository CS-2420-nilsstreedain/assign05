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
	
	private ArrayList<Integer> bigAscendingIntegerArray;
	private ArrayList<Integer> bigPermutedIntegerArray;
	private ArrayList<Integer> bigDescendingIntegerArray;
	
	private ArrayList<String> smallStringArray;
 	
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
		bigAscendingIntegerArray = ArrayListSorter.generateAscending(1000000);
		bigPermutedIntegerArray = ArrayListSorter.generatePermuted(1000000);
		bigDescendingIntegerArray = ArrayListSorter.generateDescending(1000000);
		
		smallStringArray = new ArrayList<>();
		for (int i = 0; i < 10; i++)
			smallStringArray.add("b");
		smallStringArray.add("a");
		
	}
// 
// MERGE SORT TESTS
//
	@Test
	void testEmptyIntegerArrayMerge() {
		ArrayListSorter.mergesort(emptyIntegerArray);
		
		assertEquals(new ArrayList<Integer>() , emptyIntegerArray);
	}
	
	@Test
	void testOneIntegerArrayMerge() {
		ArrayList<Integer> testCopy = copyAndSort(oneIntegerArray);
		ArrayListSorter.mergesort(oneIntegerArray);

		assertEquals(testCopy, oneIntegerArray);
	}
	
	@Test
	void testSmallAscendingIntegerArrayMerge() {
		ArrayList<Integer> testCopy = copyAndSort(smallAscendingIntegerArray);
		ArrayListSorter.mergesort(smallAscendingIntegerArray);
		
		assertEquals(testCopy, smallAscendingIntegerArray);
	}
	
	@Test
	void testSmallPermutedIntegerArrayMerge() {
		ArrayList<Integer> testCopy = copyAndSort(smallPermutedIntegerArray);
		ArrayListSorter.mergesort(smallPermutedIntegerArray);
		
		assertEquals(testCopy, smallPermutedIntegerArray);
	}

	@Test
	void testSmallDescendingIntegerArrayMerge() {
		ArrayList<Integer> testCopy = copyAndSort(smallDescendingIntegerArray);
		ArrayListSorter.mergesort(smallDescendingIntegerArray);
		
		assertEquals(testCopy, smallDescendingIntegerArray);
	}
	
	
	@Test
	void testMediumAscendingIntegerArrayMerge() {
		ArrayList<Integer> testCopy = copyAndSort(mediumAscendingIntegerArray);
		ArrayListSorter.mergesort(mediumAscendingIntegerArray);
		
		assertEquals(testCopy, mediumAscendingIntegerArray);
	}
	
	@Test
	void testMediumPermutedIntegerArrayMerge() {
		ArrayList<Integer> testCopy = copyAndSort(mediumPermutedIntegerArray);
		ArrayListSorter.mergesort(mediumPermutedIntegerArray);
		
		assertEquals(testCopy, mediumPermutedIntegerArray);
	}

	@Test
	void testMediumDescendingIntegerArrayMerge() {
		ArrayList<Integer> testCopy = copyAndSort(mediumDescendingIntegerArray);
		ArrayListSorter.mergesort(mediumDescendingIntegerArray);
		
		assertEquals(testCopy, mediumDescendingIntegerArray);
	}
	
	@Test
	void testBigAscendingIntegerArrayMerge() {
		ArrayList<Integer> testCopy = copyAndSort(bigAscendingIntegerArray);
		ArrayListSorter.mergesort(bigAscendingIntegerArray);
		
		assertEquals(testCopy, bigAscendingIntegerArray);
	}
	
	@Test
	void testBigPermutedIntegerArrayMerge() {
		ArrayList<Integer> testCopy = copyAndSort(bigPermutedIntegerArray);
		ArrayListSorter.mergesort(bigPermutedIntegerArray);
		
		assertEquals(testCopy, bigPermutedIntegerArray);
	}
	
	@Test
	void testBigDescendingIntegerArrayMerge() {
		ArrayList<Integer> testCopy = copyAndSort(bigDescendingIntegerArray);
		ArrayListSorter.mergesort(bigDescendingIntegerArray);
		
		assertEquals(testCopy, bigDescendingIntegerArray);
	}
	
	@Test
	void testSmallStringArrayMerge() {
		ArrayList<String> testCopy = copyAndSort(smallStringArray);
		ArrayListSorter.mergesort(smallStringArray);
		
		assertEquals(testCopy, smallStringArray);
	}
	
//	
// QUICK SORT TESTS
//	
	@Test
	void testEmptyIntegerArrayQuicksort() {
		ArrayListSorter.quicksort(emptyIntegerArray);
		
		assertEquals(new ArrayList<Integer>() , emptyIntegerArray);
	}
	
	@Test
	void testOneIntegerArrayQuicksort() {
		ArrayList<Integer> testCopy = copyAndSort(oneIntegerArray);
		ArrayListSorter.quicksort(oneIntegerArray);

		assertEquals(testCopy, oneIntegerArray);
	}
	
	@Test
	void testSmallAscendingIntegerArrayQuicksort() {
		ArrayList<Integer> testCopy = copyAndSort(smallAscendingIntegerArray);
		ArrayListSorter.quicksort(smallAscendingIntegerArray);
		
		assertEquals(testCopy, smallAscendingIntegerArray);
	}
	
	@Test
	void testSmallPermutedIntegerArrayQuicksort() {
		ArrayList<Integer> testCopy = copyAndSort(smallPermutedIntegerArray);
		ArrayListSorter.quicksort(smallPermutedIntegerArray);
		
		assertEquals(testCopy, smallPermutedIntegerArray);
	}

	@Test
	void testSmallDescendingIntegerArrayQuicksort() {
		ArrayList<Integer> testCopy = copyAndSort(smallDescendingIntegerArray);
		ArrayListSorter.quicksort(smallDescendingIntegerArray);
		
		assertEquals(testCopy, smallDescendingIntegerArray);
	}
	
	
	@Test
	void testMediumAscendingIntegerArrayQuicksort() {
		ArrayList<Integer> testCopy = copyAndSort(mediumAscendingIntegerArray);
		ArrayListSorter.quicksort(mediumAscendingIntegerArray);
		
		assertEquals(testCopy, mediumAscendingIntegerArray);
	}
	
	@Test
	void testMediumPermutedIntegerArrayQuicksort() {
		ArrayList<Integer> testCopy = copyAndSort(mediumPermutedIntegerArray);
		ArrayListSorter.quicksort(mediumPermutedIntegerArray);
		
		assertEquals(testCopy, mediumPermutedIntegerArray);
	}

	@Test
	void testMediumDescendingIntegerArrayQuicksort() {
		ArrayList<Integer> testCopy = copyAndSort(mediumDescendingIntegerArray);
		ArrayListSorter.quicksort(mediumDescendingIntegerArray);
		
		assertEquals(testCopy, mediumDescendingIntegerArray);
	}
	
	@Test
	void testBigAscendingIntegerArrayQuicksort() {
		ArrayList<Integer> testCopy = copyAndSort(bigAscendingIntegerArray);
		ArrayListSorter.quicksort(bigAscendingIntegerArray);
		
		assertEquals(testCopy, bigAscendingIntegerArray);
	}
	
	@Test
	void testBigPermutedIntegerArrayQuicksort() {
		ArrayList<Integer> testCopy = copyAndSort(bigPermutedIntegerArray);
		ArrayListSorter.quicksort(bigPermutedIntegerArray);
		
		assertEquals(testCopy, bigPermutedIntegerArray);
	}
	
	@Test
	void testBigDescendingIntegerArrayQuicksort() {
		ArrayList<Integer> testCopy = copyAndSort(bigDescendingIntegerArray);
		ArrayListSorter.quicksort(bigDescendingIntegerArray);
		
		assertEquals(testCopy, bigDescendingIntegerArray);
	}
	
	@Test
	void testSmallStringArrayQuicksort() {
		ArrayList<String> testCopy = copyAndSort(smallStringArray);
		ArrayListSorter.quicksort(smallStringArray);
		
		assertEquals(testCopy, smallStringArray);
	}
	
//
// GENERATE ARRAYLIST TESTS
//
	@Test
	void testGenerateAscending() {
		ArrayList<Integer> smallAscending = ArrayListSorter.generateAscending(10);
		ArrayList<Integer> comparisonList = new ArrayList<>();
		for (int i = 1; i < 11; i++)
			comparisonList.add(i);
		assertEquals(comparisonList, smallAscending);
		assertEquals(10, smallAscending.size());
	}
	
	@Test 
	void testGeneratePermuted() {
		ArrayList<Integer> smallPermuted = ArrayListSorter.generatePermuted(10);
		
		boolean isTooLarge = false;
		for (int i : smallPermuted) {
			if (i > 10)
				isTooLarge = true;
		}
			
		assertFalse(isTooLarge);
		assertEquals(10, smallPermuted.size());
	}
	
	@Test 
	void testGenerateDescending() {
		ArrayList<Integer> smallDescending = ArrayListSorter.generateDescending(10);
		ArrayList<Integer> comparisonList = new ArrayList<>();
		for (int i = 10; i > 0; i--)
			comparisonList.add(i);
		assertEquals(comparisonList, smallDescending);
		assertEquals(10, smallDescending.size());
	}
}
