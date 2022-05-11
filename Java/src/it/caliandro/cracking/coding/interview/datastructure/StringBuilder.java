package it.caliandro.cracking.coding.interview.datastructure;

public class StringBuilder {
	private char[] words = null;
	private Integer resizingFactor = 0;
	private Integer currentPosition = 0;
	
	public static final int DEFAULT_RESIZING_FACTOR = 25;
	
	StringBuilder() {
		this(DEFAULT_RESIZING_FACTOR);
	}
	
	StringBuilder(Integer resizingFactor) {
		this.words = new char[resizingFactor];
		this.resizingFactor = resizingFactor;
	}
	
	public void append(String word) {
		for(char c: word.toCharArray()) {
			this.insertCharacter(c);
		}
		this.insertCharacter(' ');
	}
	
	private void insertCharacter(char character) {
		// it should never be > 
		char[] newWords = null;
		if(currentPosition != 0 && currentPosition % resizingFactor == 0) {
			newWords = new char[currentPosition + this.resizingFactor];
			for(int i=0; i<this.words.length; i++) {
				newWords[i] = this.words[i];
			}
			this.words = newWords;
		}
		this.words[currentPosition] = character;
		currentPosition++;
	}
	
	public String getString() {
		return new String(words);
	}
	
	public String toString() {
		return getString();
	}
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder(4);
		
		sb.append("Ciao");
		sb.append("sono");
		sb.append("Rocco");
		
		System.out.println(sb.getString());
	}
}
