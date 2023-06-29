package com.test;

import java.util.zip.CRC32;

public class Main {

	public static void main(String[] args) {
		
		
//		CircleTwoLinkedList<Integer> list = new CircleTwoLinkedList<>();
//		list.add(20);
//		System.out.println(list);
//		list.add(0,10);
//		System.out.println(list);
//		list.add(30);
//		list.add(list.size(),40);
//		list.remove(1);
//		System.out.println(list);
		
		//约瑟夫问题
		CircleTwoLinkedList<Integer> list  = new CircleTwoLinkedList<>();
		for (int i = 1; i <= 8; i++) {
			list.add(i);
		}
		
		list.reset();
		while (list.size > 1) {
			list.next();
			list.next();
			list.remove();
			System.out.println(list);
		}
		
	}

}
