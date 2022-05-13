package it.caliandro.elements.of.progrinterview.chapters;

import java.util.Random;

/*
 * List of Bitwise Java operators:
 * 
 * 1. Bitwise OR (|) 
 * 2. Bitwise AND (&)
 * 3. Bitwise XOR (^) 
 * 4. Bitwise Complement (~)
 * 5. >> Signed left shift
 * 6. << Signed right shift
 * 7. >>> Unsigned right shift
 * 
 * */


public class ChapterOne {

	static final int NUM_UNSIGN_BITS = 63;
	
	/*
	 * This method counts the number of ones in a decimal number
	 * 
	 * */
	public static int countNumOfOnes_one(int num) {
		
		int posNum = Math.abs(num);
		
		if(posNum == 0)
			return 0;
		else {
			int integralPart = (int) Math.ceil(posNum/10);
			int decimalPart = posNum % 10;
			
			if (decimalPart == 1)
				return 1 + countNumOfOnes_one(integralPart);
			else 
				return countNumOfOnes_one(integralPart);
		}
		
	}
	
	/*
	 * This methods, counts the number of bits to one in the binary 
	 * representation of a decimal number. 
	 * */
	public static short countBits(int x) {
		short numBits = 0;
		while (x != 0) {
			numBits += (x & 1);
			x >>>= 1;
		}		
		return numBits;
	}
	
	
	/* Count parity bit of a word. 1 if ones are odd 0 otherwise 
	 * (brute force solution) */
	public static short parity_one(long x) {
		short result = 0;
		while (x != 0) {
			result ^= (x & 1);
			x >>= 1;
		}
		
		return result;
	}

	/* more efficient */
	public static short parity_two(long x) {
		short result = 0;
		while (x!= 0) {
			result ^= 1;
			x &= (x-1); // drops the lowest set bit of x
		} 
		
		return result;
	}
	
	/* using cache 
	public static short parity_three(long x) {
		final int WORD_SIZE = 16;
		final int BIT_MASK = 0xFFFF;
		
		return (short) (
			precomputedParity[(int)((x >>> (3 * W0RD_SIZE)) & BIT_MASK)]
					^ precomputedParity[(int)((x >>> (2 * W0RD_SIZE)) & BIT_MASK)]
					^ precomputedParity[(int)((x >>> W0RD_SIZE) & BIT_MASK)]
					^ precomputedParity[(int)(x & BIT_MASK)]);
				)
		return 0;
	}
	 */
	
	public static short parity_four(long x) { 
		x ^= x >>> 32;
		x ^= x >>> 16;
		x ^= x >>> 8;
		x ^= x >>> 4;
		x ^= x >>> 2;
		x ^= x >>> 1;
		
		return (short) (x & 0x1);
	}
	
	
	public static long swapBits(long x, int i, int j) {
		// extract i-th and j-th and see if they differ
		if(((x >>> i) & 1) != ((x >>> j) & 1)) {
			// they differ, so we have to swap we can use XOR
			long bitMask = (1L << i) | (1L << j);
			x ^= bitMask;
		}
		
		return x;
	}
	
	/*
	public static long reverseBits(long x) {
		final int WORD_SIZE = 16;
		final int BIT_MASK = 0xFFFF;
		return precomputedReverse [(int)(x & BIT_MASK)] << (3 * W0RD_SIZE)
				| precomputedReverse [(int)((x >> W0RD_SIZE) & BIT_MASK)]
					<< (2 * WORD_SIZE)
						|precomputedReverse[(int)((x >> (2 * W0RD_SIZE)) & BIT_MASK)]
					<< W0RD_SIZE
						|precomputedReverse[(int)((x >> (3 * W0RD_SIZE)) & BIT_MASK)];
	}
	*/
	
	public static long reverseBits(long x) {		
		/*
		 * it works but the first bits are 11111 
		 * For example,                   87 = 														   1010111
		 * and reuslt is 9223372036854775720 = 111111111111111111111111111111111111111111111111111111110101000
		 * */
		
		long bitMask = Long.MAX_VALUE;
		return x^bitMask;
	}
	
	
	
	/* This algorithm find the clotest number of x with the same number of bits equal to 1.
	 * For example, 6 = 110 and it returns 5=101 (both 5 and 6 has two bits equals to 1) */
	public static long closestIntSameBitCount(long x) {
		// x assumed > 0 so 0 is the leading bit. We focus to 63 LSBs
		for (int i=0; i < NUM_UNSIGN_BITS - 1; i++) {
			if((((x >>> i) & 1) != ((x >>> (i+1)) & 1))) {
				x ^= (1L << i) | (1L  << (i+1));
				return x;
			}
		}
		throw new IllegalArgumentException("All bits are 0 or 1");
	}
	
	
	public static long multiply(long x, long y) {
		long sum = 0;
		
		// iterate to the bits of x
		while (x != 0) {
			short currentBit = (short) (x & 1);
			
			if(currentBit == 1) {
				sum = add(sum, y);
			}
			
			x >>>= 1;
			y <<= 1;
		}
	
		return sum;
	}
	
	
	private static long divide(long x, long y) {
		long result = 0;
		int power = 32;
		long yPower = y << power; 
		while (x >= y) {
			while(yPower > x) {
				yPower >>>= 1;
				--power;
			}
			
			result += 1L << power;
			x -= yPower;
		}
		
		return result;
	}
	
	public static double power(double x, int y) {
		double result = 1.0;
		long power = y;
		if(y < 0) {
			power = -power;
			x = 1.0/x;
		}
		
		while(power != 0) {
			if((power & 1) != 0) {
				result *= x;
			}
			x *= x;
			power >>>= 1;
		}
		return result;
	}
	
	
	private static long add(long a, long b) {
		long sum = 0, carryin = 0, k = 1, tempA = a, tempB = b;
		
		while (tempA != 0 || tempB != 0) {
			long ak = a & k, bk = b&k;
			long carryout = (ak & bk) | (ak & carryin) | (bk & carryin);
			sum |= (ak ^ bk ^ carryin);
			carryin = carryout << 1;
			k <<= 1;
			tempA >>>= 1;
			tempB >>>= 1;
		}
		
		return sum | carryin;
	}
	
	public static int reverse(int x) {
		int result = 0;
		
		while(x != 0) {
			int lastDigit = x % 10;
			result = result * 10 + lastDigit;
			x = x / 10;
		}
		
		return result;
	}
	
	/*
	 * Given a number as input, this method return true if the number is palyndrom, flase otherwise
	 * true if 12321
	 * */
	public static boolean isNumberPalyndrom(int x) {
		if(x < 0)
			return false;

		final int numDigits = (int) (Math.floor(Math.log10(x))) + 1;
		int msdMask = (int) Math.pow(10, numDigits - 1);
		
		for(int i=0; i < (numDigits/2); i++) {
			if(x/msdMask != x%10) 
				return false;
		
			x %= msdMask;
			x /= 10;
			msdMask /= 100;
		}		
		return true;
	}
	
	
	/*
	 * this method returns a random integer betweem lowerBound and upperBound
	 * 
	 * */
	public static int uniformRandom(int lowerBound, int upperBound) {
		int numberOfOutcomes = upperBound - lowerBound + 1, result;
		do {
			result = 0;
			for (int i=0; (1 << i) < numberOfOutcomes; i++) {
				// zeroOneRandom() is the provided randomNumber generator
				result = (result << 1) | zeroOneRandom();
			}
		} while (result >= numberOfOutcomes);
		
		return result + lowerBound;
	}

	
	private static int zeroOneRandom() {
		Random random = new Random();
		return random.nextInt(2);
	}

	
	public static void main(String[] args) {
		/*Count number of ones in a decimal number*/
		System.out.println("************************");
		System.out.println("Count number of ones in a decimal number");
		System.out.println("************************");
		System.out.println(countNumOfOnes_one(789119810));
		System.out.println(countNumOfOnes_one(-789119810));
		System.out.println(countNumOfOnes_one(0000));

		/* Count number of bits to 1 in the binary representation */
		System.out.println("************************");
		System.out.println("Count number of bits to 1 in the binary representation");
		System.out.println("************************");
		System.out.println(countBits(4));
		System.out.println(countBits(8));
		System.out.println(countBits(73));
	
		
		/* Returns the parity bit of a number */
		System.out.println("************************");
		System.out.println("Returns the parity bit of a number ");
		System.out.println("************************");
		System.out.println(parity_one(245));
		System.out.println(parity_two(2));
		System.out.println(parity_two(5));
		//System.out.println(parity_three(3));
		
		/* Reverse all the bits in the binary representation and return the number */
		System.out.println(reverseBits(87));
		
		
		/* clotest number of x with the same number of bits = 1 */
		System.out.println("************************");
		System.out.println("Returns the clotest number of x with the same number of bits = 1 ");
		System.out.println("************************");
		System.out.println(closestIntSameBitCount(6));
		System.out.println(closestIntSameBitCount(23));

	
	
		/* This method multiplies two numbers using bit manipulation */
		System.out.println("************************");
		System.out.println("This method multiplies two numbers using bit manipulation");
		System.out.println("************************");
		System.out.println(multiply(13L, 9L));
		System.out.println(multiply(1L, 17L));

		
		/* This method divide two numbers using bit manipulation */
		System.out.println("************************");
		System.out.println("This method divide two numbers using bit manipulation");
		System.out.println("************************");
		System.out.println(divide(9L, 9L));
		System.out.println(divide(9L, 3L));

		
		/* This method divide two numbers using bit manipulation */
		System.out.println("************************");
		System.out.println("This method compute x powered to y");
		System.out.println("************************");
		System.out.println(power(3L, 2));
		System.out.println(power(9L, 3));
		
		
		/* This method reverse the digits given an integer; 354=>453 */
		System.out.println("************************");
		System.out.println("This method reverse the digits given an integer; 354=>453");
		System.out.println("************************");
		System.out.println(reverse(354));

		
		/* Returns true if the number is palyndrom */
		System.out.println("************************");
		System.out.println("Returns true if the number is palyndrom");
		System.out.println("************************");
		System.out.println(isNumberPalyndrom(354));
		System.out.println(isNumberPalyndrom(35453));
		System.out.println(isNumberPalyndrom(121));

		
		/* Returns a random number between min and max */
		System.out.println("************************");
		System.out.println("Returns a random number between min and max");
		System.out.println("************************");
		System.out.println(uniformRandom(7, 11));
		System.out.println(uniformRandom(1990, 1990));
		System.out.println(uniformRandom(1990, 1995));
	}
}
