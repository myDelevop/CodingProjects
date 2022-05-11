package it.caliandro.leetcode.findthecity;

public class Solution {

	public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
		int minNeighNumber = -1;
		int result = -1;
		
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				//System.out.println(edges[i][j]);
				System.out.println(i + "-" + j);
			}
		}
		
		return 0;
	}
		
	public static void main(String[] args) {
		int n1 = 4;
		int threshold1 = 4;

		int[][] cities = new int[n1][n1];
		cities[0][0] = 0;
		cities[0][1] = 3;
		cities[0][2] = 0;
		cities[0][3] = 0;
		cities[1][0] = 3;
		cities[1][1] = 0;
		cities[1][2] = 1;
		cities[1][3] = 4;
		cities[2][0] = 0;
		cities[2][1] = 1;
		cities[2][2] = 0;
		cities[2][3] = 1;
		cities[3][0] = 0;
		cities[3][1] = 4;
		cities[3][2] = 1;
		cities[3][3] = 0;
		
		
		System.out.println("Output: " + findTheCity(n1, cities, threshold1));
	}
}
