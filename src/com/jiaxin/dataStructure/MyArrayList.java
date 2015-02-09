package com.jiaxin.dataStructure;
/**
 * 
 *
 * interface List{
	public void add(T o);//add to the last
	public T get(int index); //get the index object
	public int size();//return the size
	public boolean remove(T o);//remove the first o and return true; if not exist, return false.
	}

 * @author jiashan
 *
 */

public class MyArrayList<E> {
	public static final int INITIAL_CAPACITY = 6;
	
	@SuppressWarnings("unchecked")
	private E[] data = (E[]) new Object[INITIAL_CAPACITY];
	protected int size = 0;
	
	public MyArrayList() {
		
	}
	
	public MyArrayList(E[] objects) {
		for (int i = 0; i < objects.length; i++) {
			add(objects[i]);
		}
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void add(E t) {
		add(size, t);
	}
	
    public void add(int index, E e) {
        ensureCapacity();
        
        // move all elements to right by one step
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        // insert element
        data[index] = e;
        // increase size
        size++;
    }

    public boolean remove(E e) {
    	if (indexOf(e) >= 0) {
    		remove(indexOf(e));
    		return true;
    	} else {
    		return false;
    	}
    }

    public E remove(int index) {
        E e = data[index];
        
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        
        //Don't forget this step
        data[size - 1] = null;
        size--;
        return e;
    }


    public void clear() {
        data = (E[]) new Object[INITIAL_CAPACITY];
        size = 0;
        
    }

    public E get(int index) {
        return data[index];
    }

    public E set(int index, E e) { // in interface, here's Object but not e.
        E oldE = data[index];
        data[index] = e;
        
        return oldE;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        
        return false;
    };
    
    public int indexOf(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        
        return -1;
    }

    public int lastIndexOf(E e) {
        for (int i = size - 1; i >= 0; i--) {
            if (data[i] == e) {
                return i;
            }
        }
        
        return -1;
    }

    private void ensureCapacity() {
        if (size >= data.length) {
            E[] newData = (E[]) new Object[size * 2 + 1];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }
    
    public void trimToSize() {
        if (size < data.length) {
            E[] newData = (E[]) new Object[size];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
        System.out.println("datasize now." + data.length);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        
        for (int i = 0; i < size; i++) {
            sb.append(data[i] + ",");
            
        }
        String result = sb.subSequence(0, sb.length() - 1) + "]";
        
        return result;
    }
}
