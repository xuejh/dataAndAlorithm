package com.test;

public class Main {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(20);
		list.add(0,10);
		list.add(30);
		list.add(list.size(),40);
		list.remove(1);
		System.out.print(list);
	}

}
