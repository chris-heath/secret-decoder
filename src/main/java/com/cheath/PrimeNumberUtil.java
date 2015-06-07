package main.java.com.cheath;

import java.util.BitSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Utility that provide some basic methods in determining and finding prime numbers
 * 
 * @author cheath
 *
 */
public class PrimeNumberUtil {

	public static Boolean isPrime(int num){
		if (num <= 1)
			return false;
		
	    for (int i=2; (i*i) <= num; i++) {
	        if (num % i == 0)
	        	return false;
	    }
	    return true;
	}
	
	public static Boolean xyBothPrime(int x, int y){
		return (isPrime(x) && isPrime(y));
	}
	
	/**
	 * Simple Sieve of Eratosthenes implementation to find list of prime numbers less than N
	 * 
	 * @param N
	 * @return
	 */
	public static List<Integer> getPrimesUnderN(int N){
		BitSet primes = new BitSet(N);
		List<Integer> primeList = new LinkedList<Integer>();
		int pos = 2; // 2 is the first prime number
		int i;
		
		while((pos = primes.nextClearBit(pos)) < N){
			primeList.add(pos);
			i = 2*pos;
			
			while(i<N){
				primes.set(i);
				i+=pos;
			}
			pos++;
			
		}
		
		return primeList;
	}
}
