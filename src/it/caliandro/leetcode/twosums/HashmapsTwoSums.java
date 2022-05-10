package it.caliandro.leetcode.twosums;

import java.util.HashMap;
import java.util.Map;


public class HashmapsTwoSums implements TwoSumsInterface {
	
	
	/*
	 * In this case, instead, we use HashMaps in which keys are the 
	 * values of the array and keys are the indexes of the elements.
	 * At each step i we compute the complement (target - nums[i]) and
	 * we find if the complement is present in the HashMap. If so, we
	 * found the two values.
	 * 
	 * Time complexity is equal to O(n)
	 * */
	public int[] twoSum(int[] nums, int target) {
        
        // Initialization phase
        int[] indexes = {-1, -1};
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        //int complement = 0;
        
        // Scanning all elements of the array
        for(int i=0; i<nums.length; i++) {
            //if(nums[i] <= target) {
                int complement = target - nums[i];
                // Check if exists the complement
                if (map.containsKey(complement)) {
                    indexes[0] = i;
                    indexes[1] = map.get(complement); 
                }
                map.put(nums[i], i);
            //}
        }
        
        return indexes;
    }
}
