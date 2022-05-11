package it.caliandro.cracking.coding.interview;

public class Test {

	static String joinWords_bad(String[] words) {
		String sentence = "";
		for(String w: words) {
			sentence = sentence + w;
		}
		return sentence;
	}

	static String joinWords_efficient(String[] words) {
		StringBuilder sentence = new StringBuilder();
		for(String w: words) {
			sentence.append(w);
		}
		return sentence.toString();
	}

	public static void main(String[] args) {
		System.out.println("CIAO");
		
	}
}
