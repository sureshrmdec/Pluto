package com.jiaxin.company.fb.online;

import org.junit.Test;

public class Fibnacci {
	public int getNthfibo(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n cannot be negative");
        }

        if (n <= 1) return n;

        int[][] result = {{1, 0}, {0, 1}};
        int[][] fiboM = {{1, 1}, {1, 0}};

        while (n > 0) {
            if (n % 2 == 1) {
                multMatrix(result, fiboM);
            }
            n = n / 2;
            multMatrix(fiboM, fiboM);
        }

        return result[1][0];
    }

    private void multMatrix(int[][] m, int [][] n) { 
        int a = m[0][0] * n[0][0] +  m[0][1] * n[1][0];
        int b = m[0][0] * n[0][1] +  m[0][1] * n[1][1];
        int c = m[1][0] * n[0][0] +  m[1][1] * n[1][0];
        int d = m[1][0] * n[0][1] +  m[1][1] * n[1][1];

        m[0][0] = a;
        m[0][1] = b;
        m[1][0] = c;
        m[1][1] = d; 
    }
    
    @Test
    public void test() {
    	System.out.println(getNthfibo(10));
    }
}
