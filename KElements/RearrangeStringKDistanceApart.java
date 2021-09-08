package com.top.KElements;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class RearrangeStringKDistanceApart {
	
	
	/*
	 * Input: s = "aaadbbcc" k = 2
	 * 
	 * Output: "abacabcd"
	 */

	public static void main(String[] args) {
		System.out.println(RearrangeStringKDistanceApart.reorganizeString("aaadbbcc", 2));
		

	}
	
	private static String reorganizeString(final String str, final int k) {
		
		
		Map<Character, Integer> map  = new HashMap<Character, Integer> ();
		
		for(char c: str.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		
		PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
				(a,b) -> b.getValue() - a.getValue());
		
		maxHeap.addAll(map.entrySet());
		
		Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
		StringBuilder result = new StringBuilder();
		
		while(!maxHeap.isEmpty()) {
			
			Map.Entry<Character, Integer> curr = maxHeap.poll();
			curr.setValue(curr.getValue()-1);
			queue.add(curr);
			
			result.append(curr.getKey());
			
			if(queue.size() == k) {
				Map.Entry<Character, Integer> entry = queue.poll();
				if(entry.getValue() >0) {
					maxHeap.add(entry);
				}
			}	
		}
		
		// if we were successful in appending all the characters to the result string, return it
        return result.length() == str.length() ? result.toString() : "";
		
	}
}
