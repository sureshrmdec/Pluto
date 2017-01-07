package com.jiaxin.dataStructure;

import java.util.HashMap;

/**
 * TODO: ReHash 
 * Reference:
 * 1. http://blog.csdn.net/vking_wang/article/details/14166593
 * 2. http://blog.csdn.net/perrywork/article/details/13287917
 * 3. http://zhangshixi.iteye.com/blog/672697
 * 
 * @author jeffwan
 * @date Apr 13, 2014
 */

public class HashMapImpl<K, V> {
    private Entry[] table;
    private int DEFAULT_INNITIAL_CAPACITY = 16; 
    private int MAXIMUM_CAPACITY = Integer.MAX_VALUE;
    private float loadFactor = 0.75f;
    private int threshold;
    private int size;
    
    
    public HashMapImpl() {
        table = new Entry[DEFAULT_INNITIAL_CAPACITY];
        size = 0;
        threshold = (int) (DEFAULT_INNITIAL_CAPACITY * loadFactor);
    }
    
    public int getSize() {
        return size;
    }
    
    int indexFor(int hash, int length) {
        return hash % (length - 1);
    }
    
    public V get(K key) {
        if (key == null) {
            return getForNullKey();
        }
        
        int hash = key.hashCode();
        int index = indexFor(hash, table.length);
        for (Entry<K, V> e = table[index]; e != null; e = e.next) {
            Object k = e.key;
            if (e.key.hashCode() == hash && (key == k || key.equals(k))) {
                return e.value;
            }
        }
        return null;
    }
    
    // find null key from list that index = 0
    private V getForNullKey() {
        for (Entry<K,V> e = table[0]; e != null; e = e.next) {
            if (e.key == null)
                return e.value;
        }
        return null;
    }

	public V put(K key, V value) {
        if (key == null) {
            return putForNullKey(value);
        }
        
        int hash = key.hashCode();
        int index = indexFor(hash, table.length);
        
        for (Entry<K, V> e = table[index]; e != null; e = e.next) {
            Object k = e.key;
            // if key already exist, replace to new value 
            if (e.key.hashCode() == hash && (key == k || key.equals(k))) {
                V oldValue = e.value;
                e.value = value;
                return oldValue;
            }
        }
        
        addEntry(hash, key, value, index);
       
        return null;
    }
    
    
    // null key always store as first element in Entry[]. index==0 may have other elements.
    // there must be only one null key element.
    private V putForNullKey(V value) {
    	for (Entry<K,V> e = table[0]; e != null; e = e.next) {
            if (e.key == null) {
                V oldValue = e.value;
                e.value = value;
                return oldValue;
            }
        }
    	
    	addEntry(0, null, value, 0);
		return null;
	}

	private void addEntry(int hash2, K key, V value, int index) {
        Entry<K, V> e = table[index];
        table[index] = new Entry<K, V>(key, value, e); 
		
        // every time, added new entry, check capacity
        if (size++ >= threshold) {
        	resize(2 * table.length);
        }
	}

	private void resize(int newCapacity) {
        Entry[] oldTable = table;
        int oldCapacity = oldTable.length;
        if (oldCapacity == MAXIMUM_CAPACITY) {
            threshold = Integer.MAX_VALUE;
            return;
        }
        
        Entry[] newTable = new Entry[newCapacity];
        transfer(newTable);
        table = newTable;
        threshold = (int)(newCapacity * loadFactor);
        
    }

    private void transfer(Entry[] newTable) {
        Entry[] src = table;
        int newCapacity = newTable.length;
        
        for (int i = 0; i < src.length; i++) {
            Entry<K, V> e = src[i];
            
            if (e != null) {
                src[i] = null;
                do {
                    Entry<K, V> next = e.next;
                    int k = indexFor(e.hashCode(), newCapacity);
                    e.next = newTable[k];
                    newTable[k] = e;
                    e = next;
                    
                } while (e != null);
                
            }
        }
    }
}
