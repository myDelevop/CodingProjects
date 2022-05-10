package it.caliandro.leetcode.plusone;

public class PlusOne {
	public static int[] plusOne(int[] digits) {				
		int n = digits.length - 1;

		for(int i = n; i>=0; i--) {
			if(digits[i]<9) {
				digits[i]++;
				return digits;
			}
			digits[i] = 0;
		}
		
		int[] new_number = new int[n+2];
		new_number[0] = 1;
		
		return new_number;
	}
	
	public static void main(String[] args) {
		int[] digits = {9,9,9};
		int[] plusOne = plusOne(digits);
		
		for(int i: plusOne) 
			System.out.println(i);
		
	}
}
