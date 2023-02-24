package com.newlecture.web.entity;

public class gNList2<T> {
	
	private T[] data;
	private int index;
	private int max;
	
	public gNList2() {
		index = 0;
		max = 3;
		data = (T[])new Object [max];
	}
	
	public void add (T n) {
		//공간이 부족하면
		if(index == max) {
			T[] temp = (T[])new Object [max +3 ];
			for(int i =0 ; i<max; i ++)
				temp[i] = data[i];
			data = temp;
			max = max + 3;
		}
		//공간을 늘리기
		data[index++] = n;
	}
	
	public T get (int index) {
		return data[index];
	}
	
	public int size() {
		return index;
	}
}

// Object -> Object[] -> Generic

// gNList2<Integer>[] list = new gNList<>[];
// list.add(3)