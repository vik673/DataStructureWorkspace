package utils;

import static org.junit.Assert.assertArrayEquals;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BenchMarkTest2 {

	static int[] arr ;
	static int sortedArr[];
	static int testArr[];
	static {
		sortedArr = new int[15000];
		arr = new int[15000];
		for (int i = 0; i < 15000; i++)
			sortedArr[i] = arr[i] = (int) (100 * Math.random());

		Instant start = Instant.now();
		Arrays.sort(sortedArr);
		Instant end = Instant.now();
		System.out.println("Java sort : " + Duration.between(start, end));

	}

	@BeforeEach
	void arrayinit() {
		testArr = Arrays.copyOf(arr, arr.length);
	}

	@Test
	void testBubbleSort() {

		Instant start = Instant.now();
		SortAndSearch.bubbleSort(testArr, testArr.length);
		Instant end = Instant.now();
		System.out.println("Bubble sort : " + Duration.between(start, end));
		assertArrayEquals(testArr, sortedArr);

	}

	@Test
	void testSelectionSort() {

		Instant start = Instant.now();

		SortAndSearch.selectionSort(testArr, testArr.length);
		Instant end = Instant.now();

		System.out.println("Selection sort : " + Duration.between(start, end));
		assertArrayEquals(testArr, sortedArr);

	}

	@Test
	void testQuickSort() {

		Instant start = Instant.now();
		SortAndSearch.quickSort(testArr, 0, testArr.length);
		Instant end = Instant.now();

		System.out.println("Quick sort : " + Duration.between(start, end));
		assertArrayEquals(testArr, sortedArr);

	}

	@Test
	void testInsertionSort() {

		Instant start = Instant.now();
		SortAndSearch.insertionSort(testArr, testArr.length);

		Instant end = Instant.now();
		System.out.println("Insertion sort : " + Duration.between(start, end));
		assertArrayEquals(testArr, sortedArr);

	}

	@Test
	void testMergeSort() {

		Instant start = Instant.now();
		SortAndSearch.mergeSort(testArr, 0, testArr.length);

		Instant end = Instant.now();
		System.out.println("Merge sort : " + Duration.between(start, end));
		assertArrayEquals(testArr, sortedArr);

	}

	@Test
	void testHeapSort() {

		Instant start = Instant.now();
		SortAndSearch.heapSort(testArr, testArr.length);

		Instant end = Instant.now();
		System.out.println("Heap sort : " + Duration.between(start, end));
		assertArrayEquals(testArr, sortedArr);

	}

}
