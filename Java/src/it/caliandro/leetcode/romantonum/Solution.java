package it.caliandro.leetcode.romantonum;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static int romanToInt(String s) {
    	
    	Map<Character, Integer> map = new HashMap<Character, Integer>();
    	map.put('I', 1);
    	map.put('V', 5);
    	map.put('X', 10);
    	map.put('L', 50);
    	map.put('C', 100);
    	map.put('D', 500);
    	map.put('M', 1000);
    	
    	int result = 0;
    	
    	for(int i=s.length()-1; i>=0; i--) {
    		int currentDigit = map.get(s.charAt(i));

    		int substract = 0;
    		for(int j=i-1; j>=0; j--) {
    			int prevDigit = map.get(s.charAt(j));
    			if(currentDigit > prevDigit) {
    				substract += prevDigit;
    				System.out.println("CIAO");
    				i--;
    				// da sottrarre
    			}
    		}
    		
    		result = result + currentDigit - substract;
    	}
    	
    	
        return result;
    }
    
    
    public static void main(String[] args) {
		System.out.println(romanToInt("III"));
	}
}
