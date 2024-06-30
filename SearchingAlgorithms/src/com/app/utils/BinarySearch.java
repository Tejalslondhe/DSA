package com.app.utils;

public class BinarySearch {

	public static int binarySearch(int[] arr, int key) {
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;

			if (arr[mid] == key) {
				return mid;
			}
			if (key < arr[mid]) {
				high = mid - 1;
			}
			if (key > arr[mid]) {
				low = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		int[] arr = { 2, 14, 16, 25, 36, 47 };
		int key = 36;

		int result = bs.binarySearch(arr, key);

		if (result == -1) {
			System.out.println("Key not found!!!");
		} else {
			System.out.println("Key found at index " + result);
		}

	}

}
