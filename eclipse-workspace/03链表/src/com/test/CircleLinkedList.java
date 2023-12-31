package com.test;



public class CircleLinkedList<E> extends AbstractList<E>{
	
	private Node<E> first;
	
	private static class Node<E>{
		E element;
		Node<E> next;
		//产生构造函数，alt+commond+S
		public Node(E element, Node<E> next) {
			this.element = element;
			this.next = next;
		}
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		size = 0;
		first = null;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return node(index).element;
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		Node<E> node =node(index);
		E old = node.element;
		node.element = element;
		return old;		
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		if(index == 0) {
			Node<E> last = (size == 0) ? first : node(size - 1);
			first =	new Node<E>(element, first);
			
			if(last == null) {
				last = first;
			} else {
				last.next = first;
			}
			
			
		}else {
			Node<E> prev = node(index - 1);
			prev.next = new Node<E>(element, prev.next);
		}
		
		
		
		size ++;
		
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		Node<E> node = first;
		if(index == 0) {
			
			if(size == 1) {
				first = null;
			}else {
				Node<E> last = node(size -1);
				first =	first.next;
				last.next = first;
			}
			
			
		}else {
			Node<E> prev = node(index - 1);
			node = prev.next;
			prev.next = node.next;
		}
		size --;
		return node.element;
	}

	public int indexOf(E element) {
		
			if(element == null) {
			Node<E> node = first;
			for (int i = 0; i < size; i++) {
				if(node.element == null ) {
					return i;
				}
			}
			
		}else {
			Node<E> node = first;
			for (int i = 0; i < size; i++) {
				if(element.equals(node.element) ) {
					return i;
				}
			}
		
		}
		return ELEMENT_NOT_FOUNT;
	}
	
	private Node<E> node(int index){
		rangeCheck(index);
		Node<E> node = first;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
	}
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder string = new StringBuilder();
		string.append("size=").append(size).append(", [");
		Node<E> node = first;
		for (int i = 0; i < size; i++) {
			if (i != 0) {
				string.append(", ");
			}
			
			string.append(node.element);
			
//			if (i != size - 1) {
//				string.append(", ");
//			}
			node = node.next;
		}
		string.append("]");
		return string.toString();
	}
}
