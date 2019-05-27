package com.testinfly.practice;

import java.util.Arrays;

public class Heapify {

	public static void main(String[] args) {

		int[] arr1 = { 2, 6, 27, 14, 18, 3, 11, 21, 4, 1 };
		// System.out.println(Arrays.toString(heapify1(arr1)));
		System.out.println(Arrays.toString(heapify(arr1)));
		System.out.println(Arrays.toString(heapifyMin(arr1)));
		int[] arr2 = Arrays.copyOfRange(arr1, 1, arr1.length+1);
		
		arr2[arr2.length-1] = 9;
		System.out.println("New Array: " + Arrays.toString(arr2));
		System.out.println(Arrays.toString(heapifyMin(arr2)));

	}

	static int[] heapify2(int[] arr) {

		for (int i = arr.length - 1; i >= 0; i--) {
			int parent = i;
			int left = 2 * parent + 1;
			int right = 2 * parent + 2;

			// System.out.println(i+":"+left+":"+right);

			while (isValid(arr, right) && arr[parent] < arr[right]) {
				swap(arr, parent, right);

				while (isValid(arr, left) && arr[parent] < arr[left]) {
					swap(arr, parent, left);
					parent = left;
					left = 2 * parent + 1;
					System.out.println(Arrays.toString(arr));
				}

				parent = right;
				right = 2 * parent + 2;
				System.out.println(Arrays.toString(arr));

			}

		}
		return arr;
	}

	static boolean isValid(int[] arr, int i) {
		if (i < 0 || i > arr.length - 1)
			return false;
		return true;
	}

	static void swap(int[] arr, int i, int j) {
		// if (isValid(arr, i) && isValid(arr, j))
		{
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}

	static int[] heapify1(int[] arr) {
		return heapAlgo1(arr, arr.length - 1);
	}

	static int[] heapAlgo1(int[] arr, int parent) {

		if (parent < 0)
			return arr;

		int right = parent * 2 + 2;
		int left = parent * 2 + 1;

		if (hasChild(arr, right) && arr[parent] < arr[right] || hasChild(arr, left) && arr[parent] < arr[left]) {
			if (arr[right] > arr[left]) {
				swap(arr, parent, right);
				heapAlgo1(arr, right);
			}

			else {
				swap(arr, parent, left);
				heapAlgo1(arr, left);
			}

		}

		return heapAlgo1(arr, parent - 1);

	}

	static int[] heapify(int[] arr) {
		return heapAlgo(arr, arr.length - 1);
	}

	static int[] heapAlgo(int[] arr, int index) {
		if (index < 0)
			return arr;

		int parent = (index - 1) / 2;

		if (hasChild(arr, index) && arr[parent] < arr[index]) {
			swap(arr, parent, index);
			heapAlgo(arr, index * 2 + 2);
			heapAlgo(arr, index * 2 + 1);
			// System.out.println(Arrays.toString(arr));
		}

		return heapAlgo(arr, index - 1);
	}

	static boolean hasChild(int[] arr, int i) {
		if (i < 0 || i > arr.length - 1)
			return false;
		return true;
	}

	static int[] heapifyMin(int[] arr) {
		return heapAlgoMin(arr, arr.length - 1);
	}

	static int[] heapAlgoMin(int[] arr, int index) {
		if (index < 0)
			return arr;
		int parent = (index - 1) / 2;
		if (arr[parent] > arr[index]) {
			swap(arr, parent, index);
			if (hasChild(arr, 2 * index + 2))
				heapAlgoMin(arr, 2 * index + 2);
			if (hasChild(arr, 2 * index + 1))
				heapAlgoMin(arr, 2 * index + 1);

		}
		return heapAlgoMin(arr, index - 1);
	}

}
