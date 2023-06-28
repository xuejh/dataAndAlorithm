package com.test;


public class LinkedList3<E> extends AbstractList<E>{
	
	private Node<E> first;
	private Node<E> last;
	
	private static class Node<E>{
		E element;
		Node<E> prev;
		Node<E> next;
		//产生构造函数，alt+commond+S
		public Node(Node<E> prev,E element, Node<E> next) {
			this.element = element;
			this.next = next;
			this.prev =prev;
		}
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		size = 0;
		first = null;
		last = null;
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
			Node<E> firstNode =	new Node<E>(null,element, first);
			if(first == null) {
				last = firstNode;
			}else {
				first.prev = firstNode;
			}
			
			first = firstNode;
			
			
		}else if(index == size) {
			
			Node<E> lastNode =	new Node<E>(last,element, null);
			last.next = lastNode;
			last = lastNode;
		}else {
//			Node<E> node = node(index);
//			Node<E> newNode = new Node<E>(node.prev,element, node);
//			node.prev.next = newNode;
//			node.prev = newNode;
			Node<E> next = node(index);
			Node<E> prev = next.prev;
			Node<E> node = new Node<>(prev, element, next);
			prev.next = node;
			next.prev = node;
		}
		
		
		
		size ++;
		
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		Node<E> node = first;
		if(index == 0) {
			first =	first.next;
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
		
		if(index < (size >> 1)) {
			
			Node<E> node = first;
			for (int i = 0; i < index; i++) {
				node = node.next;
			}
			return node;
			
			
		}else {
			
			Node<E> node = last;
			for (int i = size -1; i > index; i--) {
				node = node.prev;
			}
			return node;
			
		}
		
		
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
