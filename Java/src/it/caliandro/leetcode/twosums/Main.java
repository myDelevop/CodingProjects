package it.caliandro.leetcode.twosums;



// int[] twoSum(int[] nums, int target);
public class Main {
	public static void main(String[] args) {
		TwoSumsInterface bruteForce = new BruteForceTwoSums();
		TwoSumsInterface hashMaps = new HashmapsTwoSums();
		TwoSumsInterface leetCode = new HashmapsTwoSums();
		int[] indexes = new int[2];
		long startTime = 0;
		long endTime = 0;

		startTime = System.nanoTime();    
		indexes = bruteForce.twoSum(new int[] {1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0}, 3);
		endTime = System.nanoTime() - startTime;
		System.out.println("Brute Force: " + endTime + "ms");
		System.out.println("Indexes: [" + indexes[0] + ", " + indexes[1] + "]\n");

		startTime = System.nanoTime();    
		indexes = hashMaps.twoSum(new int[] {1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0}, 3);
		endTime = System.nanoTime() - startTime;
		System.out.println("HashMaps: " + endTime + "ms");
		System.out.println("Indexes: [" + indexes[0] + ", " + indexes[1] + "]\n");

		startTime = System.nanoTime();    
		indexes = leetCode.twoSum(new int[] {1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0}, 3);
		endTime = System.nanoTime() - startTime;
		System.out.println("LeetCode: " + endTime + "ms");
		System.out.println("Indexes: [" + indexes[0] + ", " + indexes[1] + "]\n");
		
		
	}
}
