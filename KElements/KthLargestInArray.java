package com.top.KElements;

import java.util.PriorityQueue;

public class KthLargestInArray {
	
	public static void main(String[] args) {
		
		int[] input = new int[]{3, 2, 1, 5, 6, 4};
		int k = 2;
		
		System.out.println("Output: " + kthLargest(input, k));
		
	}
	
	
	public static int kthLargest(int[] arr, int k) {
		
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		
		for(int i=0; i<k; i++) {
			minHeap.offer(arr[i]);
		}
		
		for(int i=k; i<arr.length; i++) {
			
			if(arr[i] > minHeap.peek()) {
				minHeap.poll();
				minHeap.offer(arr[i]);
			} 
		}
		
		return minHeap.peek();
		
	}

}
