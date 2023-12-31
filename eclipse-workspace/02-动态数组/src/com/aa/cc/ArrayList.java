package com.aa.cc;



public class ArrayList<E> {
	
	private  int size;
	private E[] elements;
	
	private static final int DEFAULT_CAPACITY = 10;
	private static final int ELEMENT_NOT_FOUNT = -1;
	@SuppressWarnings("unchecked")
	public ArrayList(int capaticy) {
		capaticy = (capaticy  < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capaticy;
		elements = (E[])new Object[capaticy];
	}
	
	public ArrayList() {
		//elements = new int[DEFAULT_CAPACITY];
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * 清除所有元素
	 */
	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		//elements = null;
		size = 0;
		if(elements != null && elements.length > DEFAULT_CAPACITY) {
			elements = (E[]) new Object[DEFAULT_CAPACITY];
		}
		
	}

	/**
	 * 元素的数量
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * 是否为空
	 * @return
	 */
	public boolean isEmpty() {
		 return size == 0;
	}

	/**
	 * 是否包含某个元素
	 * @param element
	 * @return
	 */
	public boolean contains(E element) {
		return indexOf(element) != ELEMENT_NOT_FOUNT;
	}

	/**
	 * 添加元素到尾部
	 * @param element
	 */
	public void add(E element) {
		
		//add(size, element);
		add(size, element);
	}

	/**
	 * 获取index位置的元素
	 * @param index
	 * @return
	 */
	public E get(int index) {
		rangeCheck(index);
		return elements[index];
	}

	/**
	 * 设置index位置的元素
	 * @param index
	 * @param element
	 * @return 原来的元素ֵ
	 */
	public E set(int index, E element) {
		rangeCheck(index);
		E old = elements[index];
		elements[index] = element;
		return old;
	}
	
	private void rangeCheck(int index) {
		if(index < 0 || index >= size) {
			outOfBounds(index);
		}
	}
	
	private void rangeCheckForAdd(int index) {
		if(index < 0 || index > size) {
			outOfBounds(index);
		}
	}
	
	private void outOfBounds(int index) {
		throw new IndexOutOfBoundsException("Index:" + index + ",Size:" + size);
	}

	
	private void ensureCapacity(int capacity) {
		int oldCapacity= elements.length;
		if(oldCapacity >= capacity) {
			return;
		}
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		E[] newElements = (E[])new Object[newCapacity];
		for(int i=0;i<size;i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
		System.out.println(oldCapacity +"扩容： "+newCapacity);
		//System.arraycopy(newElements, newCapacity, elements, elements.length, size);
	}
	/**
	 * 在index位置插入一个元素
	 * @param index
	 * @param element
	 */
	public void add(int index, E element) {
		
		
		rangeCheckForAdd(index);
		
		ensureCapacity(size + 1);
		
		/*if(size >= elements.length) {
			int[] element1 = new int[elements.length *2];
			
			for(int i=0;i<elements.length;i++) {
				element1[i] = elements[i];
			}
			
			elements = element1;
		}*/
		
		for(int i=size;i>index;i--) {
			elements[i] = elements[i-1];
		}
		
		elements[index] = element;
		size ++;
		
	}

	/**
	 * 删除index位置的元素
	 * @param index
	 * @return
	 */
	public E remove(int index) {
		rangeCheck(index);
		
		E old = elements[index];
		for (int i = index+1; i <=size-1; i++) {
			elements[i-1] =elements[i];
		}
		
		size --;
		elements[size] = null;
		trim();
		return old;
	}
	
	public void remove(E element) {
		remove(indexOf(element));
	}
	
	/**
	 * 查看元素的索引
	 * @param element
	 * @return
	 */
	public int indexOf(E element) {
		if(element == null) {
			
			for (int i = 0; i < size; i++) {
				if(elements[i] == null ) {
					return i;
				}
			}
			
		}else {
			for (int i = 0; i < size; i++) {
				if(element.equals(elements[i]) ) {
					return i;
				}
			}
		
		}
		return ELEMENT_NOT_FOUNT;
	}
	
	private void trim() {
		int oldCapacity = elements.length;
		int newCapacity = (oldCapacity >> 1);
		if(size >= newCapacity || oldCapacity <= DEFAULT_CAPACITY) {
			return;
		}
		
		//剩余空间还很多
		
		E[] newElements = (E[]) new Object[newCapacity];
		for(int i=0;i<size;i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
		
		System.out.println(oldCapacity +"缩容： "+newCapacity);
	}
	@Override
	public String toString() {
		/*StringBuilder str = new StringBuilder();
		for(int i = 0;i<size;i++) {
			str.append(elements[i] + ",");
		}
		return str.toString();*/
		
		// size=3, [99, 88, 77]
				StringBuilder string = new StringBuilder();
				string.append("size=").append(size).append(", [");
				for (int i = 0; i < size; i++) {
					if (i != 0) {
						string.append(", ");
					}
					
					string.append(elements[i]);
					
//					if (i != size - 1) {
//						string.append(", ");
//					}
				}
				string.append("]");
				return string.toString();
	}
	
}
