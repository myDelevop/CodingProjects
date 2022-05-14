package it.caliandro.elements.of.progrinterview.chapters;

import it.caliandro.elements.of.progrinterview.utils.Utility;

public class ChapterTwo {
	/*
	 * This method take in input an array and reorder so that the even entries 
	 * appears first and then the odd entries later
	 * 
	 * */
	public static void evenOdd(Integer[] A) {
		int nextEven = 0, nextOdd = A.length - 1;
		while(nextEven < nextOdd) {
			if(A[nextEven]%2 == 0) {
				nextEven++;
			} else {
				Utility.swapElements(A, nextOdd, nextEven);
				nextOdd--;
			}
		}
	}
	

	public static void main(String[] args) {
		/*This method Reorder array so that even entries appear first and then odds*/
		System.out.println("************************");
		System.out.println("Reorder array so that even entries appear first and then odds");
		System.out.println("************************");
		Integer[] array =  {9, 4, 1, 8, -3, 5};
		evenOdd(array);
		System.out.println(Utility.arrayToString(array));
		
		//System.out.println(countNumOfOnes_one(-789119810));
		//System.out.println(countNumOfOnes_one(0000));
		
	}
}
