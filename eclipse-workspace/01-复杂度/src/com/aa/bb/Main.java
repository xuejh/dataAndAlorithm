package com.aa.bb;

import com.aa.bb.Times.Task;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 0 1 1 2 3 5 8
		 */
		Times.test("fib1", new Task() {
			
			public void execute() {
				System.out.println(fib1(40));
			}
		});
		
		Times.test("fib2", new Task() {
			
			@Override
			public void execute() {
				System.out.println(fib2(40));
			}
		});

	}
	
	
	public static int fib1(int n) {
		
		if(n<=1) return n;
		
		return fib1(n-1) + fib1(n - 2);
	}
	
	public static int fib2(int n) {
		if(n<=1) return n;
		int first = 0;
		int sec = 1;
		int sum = 0;
		for(int i=0;i<n-1;i++) {
			sum = first + sec;
			first = sec;
			sec = sum;
			
		}
		return sum;
	}
}
