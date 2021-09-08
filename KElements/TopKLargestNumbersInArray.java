package com.top.KElements;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TopKLargestNumbersInArray {
	
	public static void main(String[] args) {
		
		int[] input = new int[]{5, 12, 11, -1, 12};
        int k = 3;
		
        System.out.println(findKLargestNumbersUsingMin(input, k));
	}
	
	
	// Using just MinHeap O(K∗logK + (N−K)∗logK) == O(NlogK)
	public static List<Integer> findKLargestNumbersUsingMin(int[] arr, int k){
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		
		
		// put k elements in minHeap
		for(int i=0; i<k; i++) {
			minHeap.offer(arr[i]);
		}
		
		
		// go through the remaining numbers of the array, if the number from the array is bigger than the
        // top (smallest) number of the min-heap, remove the top number from heap and add the number from array
		for(int i=k; i<arr.length; i++) {
			
			if(arr[i] > minHeap.peek()) {
				
				minHeap.poll();
				minHeap.offer(arr[i]);
			}
		}
		
		 // the heap has the top 'K' numbers, return them in a list
		return new ArrayList<>(minHeap);
		
	}

}
