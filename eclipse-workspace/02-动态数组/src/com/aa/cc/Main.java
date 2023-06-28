package com.aa.cc;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*ArrayList<Integer> list  = new ArrayList<>();
		list.add(99);
		list.add(88);
		list.add(77);
		
		list.add(66);
		list.add(55);
		
		list.set(3, 80);
		
		if(list.get(3) != 80) {
			throw  new IllegalArgumentException("测试不通过");
		}
		Asserts.test(list.get(3) == 80);*/
		
//		ArrayList<Person> persons = new ArrayList<>();
//		persons.add(new Person(10, "Jack"));
//		persons.add(new Person(12, "James"));
//		persons.add(new Person(15, "Rose"));
//		persons.add(null);
//		persons.clear();
//		//提醒JVM进行垃圾回收
//		System.gc();
		
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			list.add(i);
		}
		for (int i = 0; i < 50; i++) {
			list.remove(0);
		}
		
		System.out.println(list);
	}

}
