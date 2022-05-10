package it.caliandro.leetcode.twosums;

public class BruteForceTwoSums implements TwoSumsInterface {
	
	/*
	 * This is a simple implementation of the problem in which we 
	 * compute all the possible couples in the array and verify the
	 * output condition for each pair of values
	 * 
	 * Time complexity is equal to O(n^2)
	 * */
	public int[] twoSum(int[] nums, int target) {
        
        // Initialization phase
		int[] indexes = new int[2];
        boolean condition = false;
        
        for (int i=0; i<nums.length; i++) {
            for(int j=0; j<nums.length; j++) {
                if(i != j) {
                    condition = (nums[i] + nums[j]) == target;
                    if (condition) {
                        indexes[0] = j;
                        indexes[1] = i;                       
                    }
                }
            }
        }
        
        return indexes;
    }
}
