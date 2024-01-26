package arrays;

import java.util.Arrays;

public class MaxOccurence {

	public static void main(String[] args) {
		int arr[] = { 2, 3, 3, 5, 3, 4, 1, 7 };
		int n = arr.length;
		int k = 8;
		System.out.println("Maximum repeating element is: " + maxRepeating(arr, n, k));
	}

	public static int maxRepeating(int arr[], int n, int k) {
		// Iterate though input array, for every element arr[i], increment arr[arr[i]%k]
		// by k
		for (int i = 0; i < n; i++)
			arr[(arr[i] % k)] += k;
		// Find index of the maximum repeating element
		int max = arr[0], result = 0;
		for (int i = 1; i < n; i++) {
			if (arr[i] > max) {
				max = arr[i];
				result = i;
			}
		}

		/*
		 * Uncomment this code to get the original array back 
		 * for (int i = 0; i< n; i++)
		 * arr[i] = arr[i]%k;
		 */

		return result;
	}


	static int mostFrequent(int arr[], int n) {
		Arrays.sort(arr);
		// find the max frequency using linear traversal
		int max_count = 1, res = arr[0];
		int curr_count = 1;
		for (int i = 1; i < n; i++) {
		if (arr[i] == arr[i - 1])
				curr_count++;
			else {
				if (curr_count > max_count) {
					max_count = curr_count;
					res = arr[i - 1];
				}
				curr_count = 1;
			}
		}

		// If last element is most frequent
		if (curr_count > max_count) {
			max_count = curr_count;
			res = arr[n - 1];
		}

		return res;
	}

}
