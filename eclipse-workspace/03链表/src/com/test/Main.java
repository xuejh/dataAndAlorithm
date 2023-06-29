package com.test;

public class Main {

	public static void main(String[] args) {
		
		CircleLinkedList<Integer> list =  new CircleLinkedList<>();
		list.add(20);
		
		list.add(0,10);
		System.out.println(list);
		list.add(30);
		list.add(list.size(),40);
		list.remove(1);
		System.out.println(list);
	}

}
