package com.xzz.sort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Heap<T extends Comparable<T>> implements Iterable<T> {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	private List<T> data = new ArrayList<T>();

	public Heap(){
		//add 1st dummy item
		data.add(null);
	}
	
	public boolean isEmpty(){
		return data.size() <= 1;
	}
	
	public void add(T t){
		data.add(t);
		int index = data.size() - 1;
		int parent = index / 2;
		while(parent >= 1){
			if(reorg(data, parent) < 0){
				break;
			}
			parent /= 2;
		}
	}
	
	public T peek(){
		return data.get(1);
	}
	
	public T pop(){
		T top = data.get(1);
		if(data.size() <= 1){
			return top;
		}
		T bot = data.get(data.size() - 1);
		data.set(1, bot);
		data.remove(data.size() - 1);
		int k = 1;
		while(k < data.size()){
			int i = reorg(data, k);
			if(i < 0){
				break;
			}
			k = i;
		}
		return top;
	}

	private int reorg(List<T> list, int p) {
		int i = p * 2;
		if(i >= list.size()){
			return -1;
		}
		T child = list.get(i);
		int i2 = i + 1;
		if(list.size() > i2 && list.get(i2).compareTo(list.get(i)) < 0){
			child = list.get(i2);
			i = i2;
		}
		T parent = list.get(p);
		if(parent.compareTo(child) > 0){
			list.set(p, child);
			list.set(i, parent);
			return i;
		}
		return -1;
	}

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T> (){
            private int pos = 1;
            
            @Override
            public boolean hasNext() {
                return pos < data.size();
            }

            @Override
            public T next() {
                return data.get(pos++);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
            
        };
    }
    
    
}
