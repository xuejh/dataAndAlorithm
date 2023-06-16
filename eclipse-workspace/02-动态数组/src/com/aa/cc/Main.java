package com.aa.cc;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList list  = new ArrayList();
		list.add(99);
		list.add(88);
		list.add(77);
		
		list.add(66);
		list.add(55);
		
		list.set(3, 80);
		
		/*if(list.get(3) != 80) {
			throw  new IllegalArgumentException("测试不通过");
		}*/
		Asserts.test(list.get(3) == 80);

	}

}
