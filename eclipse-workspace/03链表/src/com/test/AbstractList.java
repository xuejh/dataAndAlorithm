package com.test;

public abstract class AbstractList<E> implements List<E> {
	
	
	protected   int size;
	
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	public boolean contains(E element) {
		// TODO Auto-generated method stub
		return indexOf(element) != ELEMENT_NOT_FOUNT;
	}

	public void add(E element) {
		// TODO Auto-generated method stub
		add(size, element);
	}
	
	protected void outOfBounds(int index) {
		throw new IndexOutOfBoundsException("Index:"+ index +", Size:"+size);
	}
	protected void rangeCheck(int index) {
		if(index <0 || index >= size) {
			outOfBounds(index);
		}
	}
	protected void rangeCheckForAdd(int index) {
		if(index <0 || index >size) {
			outOfBounds(index);
		}
	}
}
