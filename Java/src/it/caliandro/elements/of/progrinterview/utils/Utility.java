package it.caliandro.elements.of.progrinterview.utils;

public class Utility {

	public static <T> String arrayToString(T[] a) {
		String s = "Array: ";
		for(T t:a) {
			s = s.concat(t.toString() + ", ");
		}
		
		s.substring(0, s.length() - 2);
		
		return s;
	}
	
	
	public static <T> void swapElements(T[] array, int i, int j) {
		if(array.length == 0 || array.length == 1) {
			System.out.println("The array length is less then 1, no operation done on the array");
			return;
		}
		
		if((i < 0 || i >= array.length) || (j < 0 || j >= array.length)) {			
			System.out.println("The index i or index j is not valid. Check the input, no operation done on the array");
			return;
		}
		
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
