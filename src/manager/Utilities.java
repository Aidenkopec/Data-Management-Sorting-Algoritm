package manager;

import model.parents.Shape;

/**
 * This class contains the sort functions
 * 
 * @author Aiden
 *
 */
public class Utilities {
	Manager manager = new Manager();
	Shape[] sortedShapes;
	VolumeCompare vc = new VolumeCompare();
	AreaCompare ac = new AreaCompare();
	// for timing the execution of sorts (milliseconds)
	private long start;
	private long end;
	private String type;

	/**
	 * This method will invoke the right sort method, based on the user input parameters
	 * @param searchType
	 * @param sortMethod
	 * @param shapes
	 * @author Lenard
	 */
	public void sortManager(String searchType, String sortMethod, Shape[] shapes) {
		sortedShapes = shapes; // creating an array of future sorted shapes
		String sort = sortMethod.toLowerCase();
		type = searchType.toLowerCase();

		// (\"b\"=bubble,\"m\"=merge,\"s\"=selection,\"i\"=insert,\"q\"=quick,\"z\"=radix)
		switch (sort) {
		case "b":
			bubbleSort(type);
			break;
		case "m":
			mergeSort(type);
			break;
		case "s":
			selectionSort(type);
			break;
		case "i":
			insertSort(type);
			break;
		case "q":
			quickSort(type);
			break;
		case "z":
			oddEvenSort(type);
			break;
		default:
		}
	}

	/**
	 * This sort will compare each pair of data from start to finish
	 * 
	 * @author Aiden
	 * @param searchType
	 */
	private void bubbleSort(String type) {

		start = System.currentTimeMillis();
		// write code for sort here

		// indicator if we performed a swap (this means whole array is not sorted yet)
		boolean swapped = true;
		int length = sortedShapes.length - 1; // we will add -1 and keep adding -1 for every swap we make

		switch (type.toLowerCase()) {
		case "h":// compare height
			// System.out.println("height sort");
			while (swapped) {
				swapped = false; // if our if conditions did not trigger, the while loop will terminate meaning
									// our array is sorted

				// go thru the array except the last one (the last one would end up being the
				// biggest number, so we can't compare it with anything)
				for (int i = 0; i < length; i++) {

					// switch position with next shape if current shape is bigger
					if (sortedShapes[i].compareTo(sortedShapes[i + 1]) > -1) {
						Shape temp = sortedShapes[i];
						sortedShapes[i] = sortedShapes[i + 1];
						sortedShapes[i + 1] = temp;
						swapped = true;

					}

				}
				length--;

			}
			break;
		case "v":// compare volume
			while (swapped) {
				swapped = false; // if our if conditions did not trigger, the while loop will terminate meaning
									// our array is sorted

				// go thru the array except the last one (the last one would end up being the
				// biggest number, so we can't compare it with anything)
				for (int i = 0; i < length; i++) {

					// switch position with next shape if current shape is bigger
					if (sortedShapes[i].compare(sortedShapes[i], sortedShapes[i + 1]) > -1) {
						Shape temp = sortedShapes[i];
						sortedShapes[i] = sortedShapes[i + 1];
						sortedShapes[i + 1] = temp;
						swapped = true;

					}

				}
				length--;
			}
			break;
		case "a":// compare basearea
			while (swapped) {
				swapped = false; // if our if conditions did not trigger, the while loop will terminate meaning
									// our array is sorted

				// go thru the array except the last one (the last one would end up being the
				// biggest number, so we can't compare it with anything)
				for (int i = 0; i < length; i++) {

					// switch position with next shape if current shape is bigger
					if (sortedShapes[i].compareBaseArea(sortedShapes[i], sortedShapes[i + 1]) > -1) {
						Shape temp = sortedShapes[i];
						sortedShapes[i] = sortedShapes[i + 1];
						sortedShapes[i + 1] = temp;
						swapped = true;

					}

				}
				length--;
			}
			break;
		default:
			System.out.println("Error");
			System.exit(0);

		}

		/*
		 * for (int i = 0; i < sortedShapes.length-1; i ++) {
		 * System.out.println(sortedShapes[i]); }
		 */
		end = System.currentTimeMillis();
		printSorted();
		System.out.println("Note: Bubble Sorted Smallest to Largest");
	}

	/**
	 * A divide and conquer algorithm where continuously divide the arrays into sub
	 * arrays to compare
	 * 
	 * @param searchType
	 * @author Aiden
	 */
	private void mergeSort(String searchType) {

		start = System.currentTimeMillis();
		// write code for sort here
		mergerSort(sortedShapes, 0, sortedShapes.length - 1, type);

		end = System.currentTimeMillis();
		printSorted();
		System.out.println("Note: Merge Sorted Largest to Smallest");
	}
	
	/**
	 * a sort method used by mergeSort
	 * @param currentArray
	 * @param left
	 * @param right
	 * @param type
	 */
	private void mergerSort(Shape currentArray[], int left, int right, String type) {
		if (left < right) {
			// Find the middle point
			int middle = left + (right - left) / 2;

			// Sort first and second halves
			mergerSort(currentArray, left, middle, type);
			mergerSort(currentArray, middle + 1, right, type);

			// Merge the sorted halves
			merge(currentArray, left, middle, right, type);
		}
	}
	/**
	 * Merge method used by merge sort to merge arrays
	 * @param currentArray
	 * @param left
	 * @param middle
	 * @param right
	 * @param type
	 */
	private void merge(Shape currentArray[], int left, int middle, int right, String type) {

		int leftLength = middle - left + 1;
		int rightLength = right - middle;

		Shape leftArray[] = new Shape[leftLength];
		Shape rightArray[] = new Shape[rightLength];

		for (int index = 0; index < leftLength; ++index) {
			leftArray[index] = currentArray[left + index];
		}
		for (int j = 0; j < rightLength; ++j) {
			rightArray[j] = currentArray[middle + 1 + j];
		}

		int i = 0;
		int j = 0;
		int k = left;

		switch (type.toLowerCase()) {
		case "h":// compare height
			// System.out.println("height sort");

			// Initial index of merged subarray array
			while (i < leftLength && j < rightLength) {
				if (leftArray[i].compareTo(rightArray[j]) >= 0) {
					currentArray[k] = leftArray[i];
					i++;
				} else {
					currentArray[k] = rightArray[j];
					j++;
				}
				k++;
			}

			while (i < leftLength) {
				currentArray[k] = leftArray[i];
				i++;
				k++;
			}

			while (j < rightLength) {
				currentArray[k] = rightArray[j];
				j++;
				k++;
			}
			break;

		case "v":// compare volume
			while (i < leftLength && j < rightLength) {
				// sortedShapes[i].compare(sortedShapes[i],sortedShapes[i + 1]) < 0
				if (leftArray[i].compare(leftArray[i], rightArray[j]) >= 0) {
					currentArray[k] = leftArray[i];
					i++;
				} else {
					currentArray[k] = rightArray[j];
					j++;
				}
				k++;
			}

			while (i < leftLength) {
				currentArray[k] = leftArray[i];
				i++;
				k++;
			}

			while (j < rightLength) {
				currentArray[k] = rightArray[j];
				j++;
				k++;
			}
			break;
		case "a":// compare base area
			while (i < leftLength && j < rightLength) {
				// sortedShapes[i].compareBaseArea(sortedShapes[i],sortedShapes[i + 1]) < 0
				if (leftArray[i].compareBaseArea(leftArray[i], rightArray[j]) >= 0) {
					currentArray[k] = leftArray[i];
					i++;
				} else {
					currentArray[k] = rightArray[j];
					j++;
				}
				k++;
			}

			while (i < leftLength) {
				currentArray[k] = leftArray[i];
				i++;
				k++;
			}

			while (j < rightLength) {
				currentArray[k] = rightArray[j];
				j++;
				k++;
			}
			break;
		default:
			System.out.println("Error");
			System.exit(0);
		}

	}
	
	/**
	 * An algorithm that splits the aray into sorted and unsorted parts, then places unsorted values to the sorted part like sorting playing cards
	 * @param searchType
	 * @author Aiden
	 */
	private void insertSort(String searchType) {

		start = System.currentTimeMillis();
		// write code for sort here
		Shape currentShape;
		int seeker;
		

		switch (type.toLowerCase()) {
		case "h":
			for (int index = 1; index < sortedShapes.length; index++) {
				currentShape = sortedShapes[index];
				seeker = index - 1;

				while (seeker >= 0 && sortedShapes[seeker].compareTo(currentShape) < 0) {
					sortedShapes[seeker + 1] = sortedShapes[seeker];
					seeker--;
				}
				sortedShapes[seeker + 1] = currentShape;
			}
			break;
		case "v":
			for (int index = 1; index < sortedShapes.length; index++) {
				currentShape = sortedShapes[index];
				seeker = index - 1;

				while (seeker >= 0 && vc.compare(sortedShapes[seeker], currentShape) < 0) {
					sortedShapes[seeker + 1] = sortedShapes[seeker];
					seeker--;
				}
				sortedShapes[seeker + 1] = currentShape;
			}
			break;
		case "a":
			for (int index = 1; index < sortedShapes.length; index++) {
				currentShape = sortedShapes[index];
				seeker = index - 1;

				while (seeker >= 0 && ac.compare(sortedShapes[seeker], currentShape) < 0) {
					sortedShapes[seeker + 1] = sortedShapes[seeker];
					seeker--;
				}
				sortedShapes[seeker + 1] = currentShape;
			}
			break;
		}
		
		end = System.currentTimeMillis();
		printSorted();
		System.out.println("Note: Insertion Sorted Largest to Smallest");
		;
	}
	
	/**
	 * A sorting algorithm that uses a pivot for sorting a subarray and will do this in recursion
	 * @param searchType
	 */
	private void quickSort(String searchType) {

		start = System.currentTimeMillis();
		// write code for sort here
		
		quickSort(sortedShapes, 0, sortedShapes.length-1,searchType);
	    
	
		end = System.currentTimeMillis();
		printSorted();
		System.out.println("Note: Quick sorted smallest to largest");
	}
	/**
	 * Used by quickSort for recursion
	 * @param shapes
	 * @param low
	 * @param high
	 * @param type
	 */
	private void quickSort(Shape[] shapes, int low, int high,String type) {
		
		if (low >= high) {
		      return;
		    }
		
		Shape pivot = sortedShapes[high];
		
		int pointerL = low;
		int pointerR = high;
		
		pointerL = quickPartition(shapes, high, pivot, pointerL, pointerR,type);
		
		quickSort(shapes,low,pointerL -1,type);
		quickSort(shapes,pointerL + 1,high,type);
		
	}

	/**
	 * method used by quick sort to compare indexes of an array based on their respective pointer positions
	 * @param shapes
	 * @param high
	 * @param pivot
	 * @param pointerL
	 * @param pointerR
	 * @return
	 */
	private int quickPartition(Shape[] shapes, int high, Shape pivot, int pointerL, int pointerR,String type) {
		while (pointerL<pointerR) {
			
			switch (type.toLowerCase()) {
			case "h":
				while(shapes[pointerL].compareTo(pivot) <= pivot.compareTo(shapes[pointerL]) && pointerL < pointerR ) {
					pointerL++;
				}
				while(shapes[pointerR].compareTo(pivot) >= pivot.compareTo(shapes[pointerR]) && pointerL < pointerR ) {
					pointerR--;
				}
				break;
			case "a":
				while(shapes[pointerL].compareBaseArea(shapes[pointerL],pivot) <= pivot.compareBaseArea(pivot,shapes[pointerL]) && pointerL < pointerR ) {
					pointerL++;
				}
				while(shapes[pointerR].compareBaseArea(shapes[pointerR],pivot) >= pivot.compareBaseArea(pivot,shapes[pointerR]) && pointerL < pointerR ) {
					pointerR--;
				}
				break;
			case "v":
				while(shapes[pointerL].compare(shapes[pointerL],pivot) <= pivot.compare(pivot,shapes[pointerL]) && pointerL < pointerR ) {
					pointerL++;
				}
				while(shapes[pointerR].compare(shapes[pointerR],pivot) >= pivot.compare(pivot,shapes[pointerR]) && pointerL < pointerR ) {
					pointerR--;
				}
				break;
			}
			
			swap(shapes,pointerL,pointerR);
		}
		swap(shapes,pointerL,high);
		return pointerL;
	}
	
	/**
	 * Swap method used by quickpartition
	 * @param shape
	 * @param i
	 * @param j
	 */
	private void swap(Shape[] shape, int i, int j) {
		Shape temp = shape[i];
		shape[i] = shape[j];
		shape[j] = temp;
	}


	/**
	 * An algorithm that will sort by finding the lowest value and putting it in the front, like a reverse bubble
	 * @param searchType
	 * @author Aiden
	 */
	private void selectionSort(String searchType) {

		start = System.currentTimeMillis();
		// write code for sort here
		int quantity = sortedShapes.length;
		Shape currentShape;
		int seeker;
		
		
		switch (type.toLowerCase()) {
		case "h":
			for (int index = 1; index < quantity; index++) {
				currentShape = sortedShapes[index];
				seeker = index - 1;

				while (seeker >= 0 && (sortedShapes[seeker].compareTo(currentShape) < 0)) {
					sortedShapes[seeker + 1] = sortedShapes[seeker];
					seeker--;
				}
				sortedShapes[seeker + 1] = currentShape;
			}
			break;

		case "v":
			for (int index = 1; index < quantity; index++) {
				currentShape = sortedShapes[index];
				seeker = index - 1;

				while (seeker >= 0 && (vc.compare(sortedShapes[seeker], currentShape) < 0)) {
					sortedShapes[seeker + 1] = sortedShapes[seeker];
					seeker--;
				}
				sortedShapes[seeker + 1] = currentShape;
			}
			break;

		case "a":
			for (int index = 1; index < quantity; index++) {
				currentShape = sortedShapes[index];
				seeker = index - 1;

				while (seeker >= 0 && (ac.compare(sortedShapes[seeker], currentShape) < 0)) {
					sortedShapes[seeker + 1] = sortedShapes[seeker];
					seeker--;
				}
				sortedShapes[seeker + 1] = currentShape;
			}
			break;
		}
		
		end = System.currentTimeMillis();
		printSorted();
		System.out.println("Note: Selection Sorted Largest to Smallest");
	}

	/**
	 * This sort is a bubble sort variant, where we compare in parallel the odd and
	 * even index pairs
	 * 
	 * @param searchType
	 * @author Aiden
	 */
	private void oddEvenSort(String searchType) {
		start = System.currentTimeMillis();
		// write code for sort here
		boolean swapped = true;

		int length = sortedShapes.length - 1;

		switch (searchType.toLowerCase()) {
		case "a":
			while (swapped) {
				swapped = false; // if our if conditions did not trigger, the while loop will terminate meaning
									// our array is sorted

				// go thru the array skipping 2
				for (int i = 1; i < length; i += 2) {

					// every pair in ODD position starting with 1, switch position with next shape
					// if current shape is bigger
					if (sortedShapes[i].compareBaseArea(sortedShapes[i], sortedShapes[i + 1]) > sortedShapes[i]
							.compareBaseArea(sortedShapes[i + 1], sortedShapes[i])) {
						Shape temp = sortedShapes[i];
						sortedShapes[i] = sortedShapes[i + 1];
						sortedShapes[i + 1] = temp;
						swapped = true;

					}

				}
				for (int i = 0; i < length; i += 2) {

					// every pair in Even position starting with 0, switch position with next shape
					// if current shape is bigger
					if (sortedShapes[i].compareBaseArea(sortedShapes[i], sortedShapes[i + 1]) > sortedShapes[i]
							.compareBaseArea(sortedShapes[i + 1], sortedShapes[i])) {
						Shape temp = sortedShapes[i];
						sortedShapes[i] = sortedShapes[i + 1];
						sortedShapes[i + 1] = temp;
						swapped = true;

					}

				}
				// we don't need to check the last number because the largest number would've
				// bubbled to the last position already

			}
			break;
		case "v":
			while (swapped) {
				swapped = false; // if our if conditions did not trigger, the while loop will terminate meaning
									// our array is sorted

				// go thru the array skipping 2
				for (int i = 1; i < length; i += 2) {

					// every pair in ODD position starting with 1, switch position with next shape
					// if current shape is bigger
					if (sortedShapes[i].compare(sortedShapes[i], sortedShapes[i + 1]) > sortedShapes[i]
							.compare(sortedShapes[i + 1], sortedShapes[i])) {
						Shape temp = sortedShapes[i];
						sortedShapes[i] = sortedShapes[i + 1];
						sortedShapes[i + 1] = temp;
						swapped = true;

					}

				}
				for (int i = 0; i < length; i += 2) {

					// every pair in Even position starting with 0, switch position with next shape
					// if current shape is bigger
					if (sortedShapes[i].compare(sortedShapes[i], sortedShapes[i + 1]) > sortedShapes[i]
							.compare(sortedShapes[i + 1], sortedShapes[i])) {
						Shape temp = sortedShapes[i];
						sortedShapes[i] = sortedShapes[i + 1];
						sortedShapes[i + 1] = temp;
						swapped = true;

					}

				}

			}
			break;
		case "h":
			while (swapped) {
				swapped = false; // if our if conditions did not trigger, the while loop will terminate meaning
									// our array is sorted

				// go thru the array skipping 2 so we are always even or always odd
				for (int i = 1; i < length; i += 2) {

					// every pair in ODD position starting with 1, switch position with next shape
					// if current shape is bigger
					if (sortedShapes[i].compareTo(sortedShapes[i + 1]) > sortedShapes[i].compareTo(sortedShapes[i])) {
						Shape temp = sortedShapes[i];
						sortedShapes[i] = sortedShapes[i + 1];
						sortedShapes[i + 1] = temp;
						swapped = true;

					}

				}

				for (int j = 0; j < length; j += 2) {

					// every pair in Even position starting with 0, switch position with next shape
					// if current shape is bigger
					if (sortedShapes[j].compareTo(sortedShapes[j + 1]) > sortedShapes[j].compareTo(sortedShapes[j])) {
						Shape temp = sortedShapes[j];
						sortedShapes[j] = sortedShapes[j + 1];
						sortedShapes[j + 1] = temp;
						swapped = true;

					}

				}

			}
			break;
		}

		end = System.currentTimeMillis();
		/*
		 * System.out.println("sorted..:"); for (int i = 0; i < sortedShapes.length; i
		 * ++) { System.out.println(sortedShapes[i]); }
		 */
		printSorted();
		System.out.println("Note: Odd Even Sorted Smallest to Largest");
	}

	/**
	 * this method prints the sorted shapes (first,last, and every 1000th shape +
	 * the elapsed time)
	 * 
	 * @author Aiden
	 * @param sortedShapes
	 */
	private void printSorted() {

		// print first
		System.out.println("\nFirst Shape:");
		System.out.println(sortedShapes[0] + "\n");
		// print every 1000th value
		System.out.println("Every 1000nth shape:\n");
		for (int i = 1000; i < sortedShapes.length; i += 1000) {
			System.out.println(sortedShapes[i]);
		}
		// print last
		System.out.println("\nLast Shape:");
		System.out.println(sortedShapes[sortedShapes.length - 1]);

		// System.out.println("sort criteria: " + type);
		// print elapsed time
		System.out.println("\nTotal Elapsed Time of Sort (milli seconds): " + (end - start));
	}
}
