package it.caliandro.leetcode.addbinary;

public class AddBinary {
	
	/*
	 * Given two binary strings a and b, return their sum as a binary string.
	 * 
	 * https://leetcode.com/problems/add-binary/
	 * */
	
    public static String addBinary(String a, String b) {
    	String  result = "";
    	
    	if(a.equals("") || b.equals(""))
    		result = a + b;
    	
    	else {
        	StringBuilder sb = new StringBuilder();
        	int i = a.length() - 1;
        	int j = b.length() - 1;
        	int carry = 0;
        	
        	while(i >= 0 || j >= 0) {
        		int sum = carry;
        		if(i>=0)
        			sum += a.charAt(i) - '0';
        		if(j>=0)
        			sum += b.charAt(j) - '0';
        		sb.append(sum % 2);
        		carry = sum/2;
        		
        		i--;
        		j--;
        		
        		
        	}

        	if (carry != 0)
        		sb.append(carry);
        	result = sb.reverse().toString();
    	}
    	
    	return result;
    }
	
	public static void main(String[] args) {
		System.out.println(addBinary("100", "1"));
	}
}
