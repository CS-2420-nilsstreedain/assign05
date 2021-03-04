package assign05;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class collects running times for methods of SimplePriorityQueue.
 * 
 * @author Erin Parker
 * @version February 9, 2021
 */
public class ArrayListSorterTimer {
	
	public static void main(String[] args) {
		System.out.println("\nN\t|  nanoTime\t\tT(N)/N\t\tT(N)/NlogN\tT(N)/N^2");
		System.out.println("-----------------------------------------------------------------------------------");
		int incr = 30000;
		for(int probSize = 30000; probSize <= 400000; probSize += incr) {
			
			
			int timesToLoop = 500;
			

			// First, spin computing stuff until one second has gone by.
			// This allows this thread to stabilize.

			long stopTime, midpointTime, startTime = System.nanoTime();

			while(System.nanoTime() - startTime < 1000000000) { // empty block
			}

			// Collect running times.
			startTime = System.nanoTime();
			for(int i = 0; i < timesToLoop; i++) {
				ArrayList<Integer> testArrayList = ArrayListSorter.generatePermuted(probSize);
				ArrayListSorter.mergesort(testArrayList);
			}

			midpointTime = System.nanoTime();

			// Capture the cost of running the loop and any other operations done
			// above that are not the essential method call being timed.
			for(int i = 0; i < timesToLoop; i++) {
				ArrayList<Integer> testArrayList = ArrayListSorter.generatePermuted(probSize);
			}

			stopTime = System.nanoTime();

			// Compute the time, subtract the cost of running the loop
			// from the cost of running the loop and searching.
			// Average it over the number of runs.
			double averageTime = ((midpointTime - startTime) - 
						(stopTime - midpointTime)) / (double) timesToLoop;
			System.out.println(
					probSize + "\t|  " + 
					String.format("%.5f", averageTime) + "\t" +
					String.format("%.5f", (averageTime / probSize)) + "\t" +
					String.format("%.5f", (averageTime / (probSize * (Math.log10(probSize) / Math.log10(2))))) + "\t" +
					String.format("%.5f", (averageTime / (probSize * probSize))));
			
		}
	}
}
