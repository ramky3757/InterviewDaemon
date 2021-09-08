package com.top.KElements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
	

	public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer> ();
        
        for(int i: nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
            (e1, e2) -> e2.getValue() - e1.getValue());
        
        maxHeap.addAll(map.entrySet());
        
        int[] result = new int[k];
        int counter =0;
        while(counter<k){
            Map.Entry<Integer, Integer> curr= maxHeap.poll();
            result[counter++] = curr.getKey();
        }
        
        return result;
    }

}
