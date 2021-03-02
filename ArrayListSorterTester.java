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
	private ArrayList<Integer> smallDescendingIntegerArray;
	
	private <T> ArrayList<T> deepCopy(ArrayList<T> sourceArray) {
		ArrayList<T> destinationArray = new ArrayList<>();
		for(T element : sourceArray) 
			destinationArray.add(element);
		return destinationArray;
	}

	
	@BeforeEach
	void setUp() {
		emptyIntegerArray = new ArrayList<Integer>();
		oneIntegerArray = ArrayListSorter.generateAscending(1);
		smallAscendingIntegerArray = ArrayListSorter.generateAscending(10);
		smallDescendingIntegerArray = ArrayListSorter.generateDescending(10);
	}

	@Test
	void testSmallAscendingIntegerArray() {
		ArrayList<Integer> testCopy = deepCopy(smallAscendingIntegerArray);
		Collections.sort(testCopy);
		ArrayListSorter.mergesort(smallAscendingIntegerArray);
		
		assertEquals(testCopy, smallAscendingIntegerArray);
	}

}
