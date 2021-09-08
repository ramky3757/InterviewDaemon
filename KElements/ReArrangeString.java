package com.top.KElements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*Input: "aappp" 
Output: "papap" 
Explanation: In "papap", none of the repeating characters come next to each other.

Input: S = "aaab" 
Output: ""
Explanation: String cannot be made without repeating characters next to each other.*/

public class ReArrangeString {
	
	public static void main(String[] args) {
		
		ReArrangeString ra = new ReArrangeString();
		System.out.println(ra.arrangeString("aapppbb"));
	}
	
	//pabpabp
	public String arrangeString(String str) {
		
		Map<Character, Integer> map = new HashMap<Character, Integer> ();
		
		for(char c: str.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		
		PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
				(a, b) -> b.getValue()-a.getValue());
				
				Map.Entry<Character, Integer> prev = null;
				StringBuilder result = new StringBuilder();
				
				maxHeap.addAll(map.entrySet());
				
				while(!maxHeap.isEmpty()) {
					
					Map.Entry<Character, Integer> curr = maxHeap.poll();
					
					if(prev!=null && prev.getValue() >0) {
						maxHeap.offer(prev);
					}
					
					result.append(curr.getKey());
					curr.setValue(curr.getValue()-1);
					prev = curr;
					
				}
		
		return result.length() == str.length()? result.toString() : "";
		
	}

}
