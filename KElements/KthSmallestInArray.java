package com.top.KElements;

import java.util.PriorityQueue;

public class KthSmallestInArray {
	
	public static void main(String[] args) {
		
		int[] input = new int[]{3, 2, 1, 5, 6, 4};
        int k = 2;
		
		System.out.println(findKthSmallest(input, k));
		
	}
	
	static int findKthSmallest(final int[] nums, final int k) {
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a,b) -> b-a);
		
		for(int i=0; i<k; i++) {
			maxHeap.offer(nums[i]);
		}
		
		for(int i=k; i<nums.length; i++) {
			
			if(nums[i] < maxHeap.peek()) {
				maxHeap.poll();
				maxHeap.add(nums[i]);
			}
			
		}
		
		return maxHeap.poll();
		
	}

}
