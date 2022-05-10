package it.caliandro.cracking.coding.interview.chapters;

import java.util.Arrays;

public class Chapter1 {
	
	
	/*
	 * Complexity of implemented solution = O(n)
	 * 
	 * We can check all possible pairs with two loops in O(n^2)
	 * Or we can also order first and solve in O(nlogn)
	 * */
	boolean isUniqueChars(String str) {
		if(str.length() > 128)
			return false;
		
		boolean[] char_set = new boolean[128];
		for(int i=0; i<str.length(); i++) {
			int val = str.charAt(i);
			if(char_set[val])
				return false;
			char_set[val] = true;
		}
		return true;
	}
	
	boolean permutation_1(String s, String t) {
		boolean res = false;
		if(s.length() == t.length())
			res = this.sort(s).equals(this.sort(t));

		return res;
	}

	boolean permutation_2(String s, String t) {
		boolean res = true;
		if(s.length() == t.length()) {
			int[] letters = new int[128];
			
			char[] s_array = s.toCharArray();
			for(char c:s_array) {
				letters[c]++;
			}
			
			for(int i=0; i<t.length(); i++) {
				int c = (int) t.charAt(i);
				letters[c]--;
				if (letters[c] < 0)
					return false;
			}
		}

		return res;
	}

	
	public void replaceSpaces(char[] str, int trueLength) {
		int spaceCount=0, index, i=0;

		for(i=0; i<trueLength; i++) {
			if(str[i] == ' ') {
				spaceCount++;
			}
		}
	
		index = trueLength + spaceCount * 2;
		if(trueLength < str.length) 
			str[trueLength] = '\0';
		
		for(i = trueLength-1; i>= 0; i--) {
			if(str[i] == ' ') {
				str[index - 1] = '0';
				str[index - 2] = '2';
				str[index - 3] = '%';
				index = index - 3;
			} else {
				str[index - 1] = str[i];
				index--;
			}
		}
	}
	
	
	private String sort(String s) {
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
	
	public boolean oneAway(String s1, String s2) {
		boolean b = false;
		
		if(s2.length() == s1.length())
			b = checkReplacement(s1, s2);
		else if(s2.length() == s1.length()-1)
			b = checkDeletion(s1, s2);
		else if(s2.length() == s1.length()+1)
			b = checkInsertion(s1, s2);
		else 
			b = false;
		
		return b;
	}
	
	private boolean checkReplacement(String s1, String s2) {
		boolean foundDifference = false;
		
		for(int i=0; i<s1.length(); i++) {
			if(s1.charAt(i) != s2.charAt(i)) {
				if(foundDifference)
					return false;
				else 
					foundDifference = true;
			}
		}
		return foundDifference;
	}
	private boolean checkInsertion(String s1, String s2) {
		boolean foundDifference = false;
		for(int i=0; i<s1.length(); i++) {
			if(!foundDifference) {
				if(s1.charAt(i) != s2.charAt(i))
					foundDifference = true;
			} else {
				if(s1.charAt(i-1) != s2.charAt(i))
					return false;
			}	
		}
		return true;
	}
	
	private boolean checkDeletion(String s1, String s2) {
		return checkInsertion(s2, s1);
	}
	
	public String compress(String string) {
		/* Check final length and return input string if it would be longer */
		int finalLength = countCompression(string);
		if(finalLength >= string.length())
			return string;
		
		StringBuilder compressed = new StringBuilder(finalLength); // Initial capacity
		int countConsecutive = 0;
		for(int i=0; i<string.length(); i++) {
			countConsecutive++;
			
			/* If next char is different than current, append this char to result */
			if(i+1 >= string.length() || string.charAt(i) != string.charAt(i+1)) {
				compressed.append(string.charAt(i));
				compressed.append(countConsecutive);
				countConsecutive = 0;
			}
		}
		
		return compressed.toString();
	}
	
	
	private int countCompression(String string) {
		int compressedLength = 0;
		int countConsecutive = 0;
		
		for(int i=0; i<string.length(); i++) {
			countConsecutive++;
			
			/* If next char is different than current, increase the length */
			if(i+1 >= string.length() || string.charAt(i) != string.charAt(i+1)) {
				compressedLength += 1 + String.valueOf(countConsecutive).length();
				countConsecutive = 0;
			}
		}
		
		return compressedLength;
	}
	
	
	public static void main(String[] args) {
		Chapter1 ch1 = new Chapter1();
		
		System.out.println("Calling char_set for \"abcdefghilm\": " + ch1.isUniqueChars("abcdefghilm"));
		System.out.println("Calling char_set for \"abcdefghilml\": " + ch1.isUniqueChars("abcdefghilml"));
		
		System.out.println("Calling permutation_1 for \"abcdf\" and \"fbcad\": " + ch1.permutation_1("abcdf", "fbcad"));
		System.out.println("Calling permutation_1 for \"abgdf\" and \"fbcad\": " + ch1.permutation_1("abgdf", "fbcad"));
		System.out.println("Calling permutation_2 for \"abcdf\" and \"fbcad\": " + ch1.permutation_2("abcdf", "fbcad"));
		System.out.println("Calling permutation_2 for \"abgdf\" and \"fbcad\": " + ch1.permutation_2("abgdf", "fbcad"));
		
		char[] str = "Mr John Smith    ".toCharArray();
		ch1.replaceSpaces(str, 13);
		System.out.print("Calling replaceSpaces for \"Mr John Smith    \": ");
		for(char c:str) 
			System.out.print(c);
		System.out.println("");
		
		
		System.out.println("Compressing \"AABCD\"" + ch1.compress("AABCD"));
		System.out.println("Compressing \"ABCD\"" + ch1.compress("ABCD"));
		System.out.println("Compressing \"aabcccccaaa\"" + ch1.compress("aabcccccaaa"));
	}
}
