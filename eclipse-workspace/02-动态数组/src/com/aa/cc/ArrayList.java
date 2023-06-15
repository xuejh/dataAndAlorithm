package com.aa.cc;



public class ArrayList {
	
	private  int size;
	private int[] elements;
	
	private static final int DEFAULT_CAPACITY = 10;
	private static final int ELEMENT_NOT_FOUNT = -1;
	public ArrayList(int capaticy) {
		capaticy = (capaticy  < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capaticy;
		elements = new int[capaticy];
	}
	
	public ArrayList() {
		//elements = new int[DEFAULT_CAPACITY];
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * 清除所有元素
	 */
	public void clear() {
		size = 0;
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
	public boolean contains(int element) {
		return indexOf(element) != ELEMENT_NOT_FOUNT;
	}

	/**
	 * 添加元素到尾部
	 * @param element
	 */
	public void add(int element) {
		
		//add(size, element);
		elements[size ++] = element;
	}

	/**
	 * 获取index位置的元素
	 * @param index
	 * @return
	 */
	public int get(int index) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index:" + index + ",Size:" + size);
		}
		return elements[index];
	}

	/**
	 * 设置index位置的元素
	 * @param index
	 * @param element
	 * @return 原来的元素ֵ
	 */
	public int set(int index, int element) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index:" + index + ",Size:" + size);
		}
		int old = elements[index];
		elements[index] = element;
		return old;
	}

	/**
	 * 在index位置插入一个元素
	 * @param index
	 * @param element
	 */
	public void add(int index, int element) {
		
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index:" + index + ",Size:" + size);
		}
		
		size ++;
		if(size >= elements.length) {
			int[] element1 = new int[elements.length *2];
			
			for(int i=0;i<elements.length;i++) {
				element1[i] = elements[i];
			}
			
			elements = element1;
		}
		
		for(int i=size-1;i>index;i--) {
			elements[i] = elements[i-1];
		}
		
		elements[index] = element;
		
		
	}

	/**
	 * 删除index位置的元素
	 * @param index
	 * @return
	 */
	public int remove(int index) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index:" + index + ",Size:" + size);
		}
		
		int old = elements[index];
		for (int i = index; i <size; i++) {
			elements[i] =elements[i+1];
		}
		
		size --;
		return old;
	}

	/**
	 * 查看元素的索引
	 * @param element
	 * @return
	 */
	public int indexOf(int element) {
		for (int i = 0; i < size; i++) {
			if(elements[i] == element) {
				return i;
			}
		}
		return ELEMENT_NOT_FOUNT;
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
