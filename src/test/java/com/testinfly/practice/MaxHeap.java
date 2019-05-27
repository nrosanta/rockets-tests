package com.testinfly.practice;

import java.util.Arrays;

public class MaxHeap {
	static int[] heap = new int[7];
	static int size;

	public static void main(String[] args) {
		int[] arr = { 1, 4, 12, 2, 3, 8, 9 };
		System.out.println("Before: "+Arrays.toString(arr));
		System.out.println("\nHeapfied: "+Arrays.toString(heapify_algo(arr,arr.length-1)));
		
//		for (int i = 0; i < arr.length; i++) {
//			insert(arr[i]);
//		}
//		print();
//
//		sort();
//		printAll();
		
		
	
	}

	static void sort() {
		while (size > 0) {
			// System.out.println("size: "+size);
			delete();

		}
	}

	static void insert(int item) {
		int i = getPos();
		heap[i] = item;
		heapify(i);
	}

	static void print() {
		for (int i = 0; i < size; i++) {
			System.out.print(heap[i] + " ");
		}
	}

	static void printAll() {
		System.out.println();
		for (int i = 0; i < heap.length; i++) {
			System.out.print(heap[i] + " ");
		}
	}

	static void delete() {

		int del_item = heap[0];
		System.out.println("\nItem to be Deleted: " + del_item);
		System.out.println("current size: " + size);

		heap[0] = heap[size - 1]; // gets the last right most item
		System.out.println("Root: " + heap[0]);
		heap[size - 1] = del_item;

		--size; // remove deleted item

		if (size > 1) {
			if (size == 2)
				heapify(1);
			else if (heap[1] > heap[2])
				heapify(1);
			else
				heapify(2);
		}

		printAll();

	}

	static void swap(int x, int y) {
		int temp = heap[x];
		heap[x] = heap[y];
		heap[y] = temp;
	}

	static int getPos() {
		return size++;
	}

	static void heapify(int i) {

		int parent = (i - 1) / 2;
		while (heap[parent] < heap[i]) {
			swap(parent, i);
			i = parent;
			parent = (i - 1) / 2;
		}

	}


	static int[] heapify_algo(int[] arr, int index) {
		
		if(index<0) return arr;
		int parent = (index-1)/2;
		if(arr[parent]<arr[index]) {
			swap_algo(arr,parent, index);
		}
		return heapify_algo(arr, index-1);
		
	}
	
	/*
	 * recursive approach
	 * 
	 */
	static void swap_algo(int[] arr, int parent, int index) {
		if(index>arr.length-1) return;
		if(arr[parent]>arr[index]) return;
		int temp = arr[parent];
		arr[parent] = arr[index];
		arr[index] = temp;
		swap_algo(arr,index, index*2+2); //right
		swap_algo(arr,index, index*2+1); //left
		
	}

}
