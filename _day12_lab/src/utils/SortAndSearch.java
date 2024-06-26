package utils;

public class SortAndSearch {

	public static void bubbleSort(int[] elements, int size) {
		int hi = size - 1;
		int lo = 0;
		for (int i = lo; i < size - 1; i++) {
			int swap = 0;
			for (int right = hi; right > lo; right--) {
				int left = right - 1;
				if (elements[left] > elements[right]) {
					int tmp = elements[right];
					elements[right] = elements[left];
					elements[left] = tmp;
					swap++;
				}
			}
			if (swap == 0)
				return;
		}
	}

	public static boolean linearSearch(int[] elements, int e, int size) {
		for (int i = 0; i < size; i++)
			if (elements[i] == e)
				return true;

		return false;
	}

	public static boolean binarySearch(int[] elements, int e, int size) {

		int lo = 0;
		int hi = size - 1;
		int i = (lo + hi) / 2;
		while (!(lo > hi)) {
			int data = elements[i];
			if (data == e)
				return true;
			if (data > e)
				hi = i - 1;
			else
				lo = i + 1;

			i = (lo + hi) / 2;

		}

		return false;
	}

	public static void selectionSort(int[] elements, int size) {
		// we select a position and place the smallest element int the sub array
		// we start at first index : 0 upto second last index
		for (int position = 0; position <= size - 2; position++) {
			int smallest = size - 1; // assume the last element is the smallest
			for (int cur = size - 2; cur >= position; cur--) {
				if (elements[smallest] > elements[cur])
					smallest = cur;
			}
			int tmp = elements[position];
			elements[position] = elements[smallest];
			elements[smallest] = tmp; // swap the smallest element in the selected sub array with the first element of
										// the sub array

		}

	}

	public static void quickSort(int[] elements, int start, int end) {
		int pivot = start;
		int left = start;
		int right = end - 1;
//		int tmp2 = elements[(left+right)/2];
//		elements[(left+right)/2] = elements[pivot];
//		elements[pivot] = tmp2;
		// while left and right donot cross over do
		while (left <= right) {

			// while left elements are lesser than pivot
			while (left < end && elements[left] < elements[pivot])
				left++;

			// while right elements are lesser than the pivot
			while (elements[right] > elements[pivot]||(elements[right]==elements[pivot]&&right!=pivot))
				right--;
			// we have reached where both condtions are false
			// swapping will make it correct
			if (left == end)
				break;
			if (right == start)
				break;
			int tmp = elements[right];
			elements[right] = elements[left];
			elements[left] = tmp;
		}
		// change the pivot with right
		int tmp = elements[right];
		elements[right] = elements[pivot];
		elements[pivot] = tmp;

		// pivot on correct position

		// we have to sort the elements left of right
		// if the start less than right's previous
		if (start < right - 1)
			quickSort(elements, start, right);
		// we have to sort the right elements of the right
		// if right's next is less than the end
		if (right + 1 < end - 1)
			quickSort(elements, right + 1, end);

	}

	public static void insertionSort(int[] elements, int size) {
		// first sub array is sorted
		// start with first + 1 as end of first sub array
		// inserting first +1 th element in the array

		for (int insertFrom = 1; insertFrom < size; insertFrom++) {
			int insertElement = elements[insertFrom];
			int insertAt = insertFrom - 1;
			while (insertAt >= 0) {
				if (elements[insertAt] > insertElement)
					elements[insertAt + 1] = elements[insertAt];
				else
					break;
				insertAt--;
			}
			elements[insertAt + 1] = insertElement;

		}

	}

	public static void mergeSort(int[] elements, int start, int end) {
		if (end - start <= 1) {
			return;
		}

		int mid = (start + end) / 2;
		// the dividing point of merge sort

		// sort the arrays

		mergeSort(elements, start, mid);
		mergeSort(elements, mid, end);

		// now merge the arrays

		merge(elements, start, mid, mid, end);

	}

	public static void merge(int[] elements, int start1, int end1, int start2, int end2) {
		int cur1 = start1;

		int cur2 = start2;
		int k = 0;
		int size = end1 - start1 + end2 - start2;
		int[] result = new int[size];

		while (cur1 < end1 && cur2 < end2)
			if (elements[cur1] < elements[cur2])
				result[k++] = elements[cur1++];
			else
				result[k++] = elements[cur2++];

		while (cur1 < end1)
			result[k++] = elements[cur1++];

		while (cur2 < end2)
			result[k++] = elements[cur2++];

		for (int i = 0, j = start1; i < size; i++, j++)
			elements[j] = result[i];

	}

	public static void heapSort(int[] elements, int end) {
		// make heap out of the tree(array)
		createHeap(elements, end);
		// last leaf node

		int lastLeaf = end - 1;

		while (lastLeaf > 0) {
			// swap the root and last leaf

			int tmp = elements[0];
			elements[0] = elements[lastLeaf];
			elements[lastLeaf] = tmp;
			// remove the last leaf from the tree
			lastLeaf--;
			// make heap of the root
			makeHeap(elements, 0, lastLeaf + 1);
		}

	}

	public static void createHeap(int[] elements, int end) {
		// start from the last parent
		int cur = end / 2 - 1;
		// upto root
		while (cur >= 0) {
			makeHeap(elements, cur, end);
			cur--;
		}

	}

	public static void makeHeap(int[] elements, int root, int end) {
		if (root == end - 1)
			return;

		int lastParent = end / 2 - 1;

		// select the maxchild of root and swap with root
		int left = 2 * root + 1;
		int right = 2 * root + 2;
		int maxChild;
		if (right < end)
			maxChild = elements[left] > elements[right] ? left : right;
		else if(left < end)
			maxChild = left;
		else 
			return;
		if (elements[maxChild] > elements[root]) {
			int tmp = elements[root];
			elements[root] = elements[maxChild];
			elements[maxChild] = tmp;
			if (maxChild <= lastParent)
				makeHeap(elements, maxChild, end);
		}

	}

}
