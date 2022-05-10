package it.caliandro.leetcode.twosums;

public interface TwoSumsInterface {
	
	/**
	 * @param nums array of numbers
	 * @param target target
	 * @return indexes array of lenght 2 such that nums[indexes[0]] + nums[indexes[1]] = target
	 * **/
	int[] twoSum(int[] nums, int target);
}
