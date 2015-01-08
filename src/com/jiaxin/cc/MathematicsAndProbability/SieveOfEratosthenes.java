package com.jiaxin.cc.MathematicsAndProbability;

/**
 * Classic way to find out all primes less than max 
 * @author jeffwan
 * @date Feb 26, 2014
 */
public class SieveOfEratosthenes {

	boolean[] sieveOfEratothenes(int max) {
		boolean[] flags = new boolean[max + 1];
		
		init(flags);
		int prime = 2;
		
		while(prime <= max) {
			crossOff(flags, prime);
			prime = getNextPrime(flags, prime);
			
			if (prime > max) {
				break;
			}
		}
		return flags;
	}

	private void crossOff(boolean[] flags, int prime) {
		// i start from prime * prime is so smart! k * prime (k<prime) all ready exclude by k priorly.
		for (int i = prime * prime; i < flags.length; i+=prime) {
			flags[i] = false;
		}
	}

	private int getNextPrime(boolean[] flags, int prime) {
		int next = prime + 1;
		while (next < flags.length && !flags[next]) {
			next++;
		}
		return next;
	}

	private void init(boolean[] flags) {
		for (int i = 0; i< flags.length; i++) {
			flags[i] = true;
		}
	}
	
}
