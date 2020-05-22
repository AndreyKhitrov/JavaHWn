package ru.mts;

import java.util.*;

public class DIYarrayList<T> implements List<T> {
    public static void main(String[] args) {
        Random randomm = new Random();
        DIYarrayList<String> list = new DIYarrayList<String>(25);
        for (int i=0; i<25; i++){
            String data = randomm.nextInt(100) + " - dollars";
            list.add(i, data);
        }
        Collections.addAll(list, 20+randomm.nextInt(30) + " - cents",20+randomm.nextInt(30) + " - cents", 20+randomm.nextInt(30) + " - cents");
        for (int i=0; i < list.size(); i++){System.out.println(Integer.toString(i+1) + " element first list is " + list.get(i));}

        DIYarrayList<String> second_list = new DIYarrayList<String>(list.size);
        for (int i=0; i<list.size; i++){
            String data = "";
            second_list.add(i, data);
        }
        Collections.copy(second_list,list);
        for (int i=0; i < second_list.size(); i++){System.out.println(Integer.toString(i+1) + " element second list is " + second_list.get(i));}

        Collections.sort(list, null);
        list.forEach(i -> System.out.println(i));
    }

    private int size = 0;
    private int capacity = 0;
    private final int CAPACITY = 20;
    private Object[] array;

    public DIYarrayList () {
        capacity = CAPACITY;
        array = new Object[capacity];
    }

    public DIYarrayList(int capacity) {
        this.capacity = capacity;
        array = new Object[capacity];
    }

    private void increaseCapacity() {
        capacity = capacity * 2;
        Object[] newArray = new Object[capacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
            array[i] = null;
        }
        array = newArray;
    }

    private void trimToSizeArray() { throw new UnsupportedOperationException(); }

    @Override
    public int size() { return size; }

    @Override
    public boolean isEmpty() { return size == 0; }

    @Override
    public boolean contains(Object o) { throw new UnsupportedOperationException(); }

    @Override
    public Iterator <T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;
            @Override
            public boolean hasNext() {return currentIndex < size && array[currentIndex] != null; }
            @Override
            public T next() {return (T)array[currentIndex++]; }
            @Override
            public void remove() { throw new UnsupportedOperationException(); }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[size];
        System.arraycopy(array, 0, newArray, 0, size);
        return newArray;
    }

    @Override
    public boolean add(Object o) {
        if (size >= capacity) {
            increaseCapacity();
        }
        array[size++] = o;
        return true;
    }

    private void shiftToLeft(int start) { throw new UnsupportedOperationException(); }

    @Override
    public boolean remove(Object o) { throw new UnsupportedOperationException(); }

    @Override
    public boolean addAll(Collection c) { throw new UnsupportedOperationException(); }

    @Override
    public boolean addAll(int index, Collection c) {
        if (c == null) {
            return false;
        }
        if (c.isEmpty() || (index < 0)) {
            return false;
        }
        if (index > size) {
            index = size;
        }
        for (Object item : c) {
            add(index++, item);
        }
        return true;
    }

    @Override
    public void clear() { throw new UnsupportedOperationException(); }

    @Override
    public T get(int index) {
        if ((index < size) && (index >= 0)) {
            return (T) array[index];
        }
        return null;
    }

    @Override
    public Object set(int index, Object element) { throw new UnsupportedOperationException(); }

    @Override
    public void add(int index, Object element) {
        if (index < 0) {
            return;
        }
        if (size + 1 >= capacity) {
            increaseCapacity();
        }
        if (index > size) {
            index = size;
        }
        for (int i = size; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        size++;
    }

    @Override
    public T remove(int index) { throw new UnsupportedOperationException(); }

    @Override
    public int indexOf(Object o) { throw new UnsupportedOperationException(); }

    @Override
    public int lastIndexOf(Object o) {throw new UnsupportedOperationException(); }

    @Override
    public ListIterator listIterator() {
        return new ListIterator<T>() {
            private int currentIndex = 0;
            @Override
            public boolean hasNext() {return currentIndex < size && array[currentIndex] != null; }
            @Override
            public T next() { return (T)array[currentIndex++]; }
            @Override
            public T previous() { return (T)array[currentIndex--]; }
            @Override
            public void remove() { throw new UnsupportedOperationException(); }
            @Override
            public void add (T t){ throw new UnsupportedOperationException(); }
            @Override
            public void set (T t) { array[currentIndex-1] = t; }
            @Override
            public int previousIndex() { return currentIndex-1;}
            @Override
            public int nextIndex() { return currentIndex+1;}
            @Override
            public boolean hasPrevious() {return currentIndex >0 ? true :false;}
        };
    }

    @Override
    public ListIterator listIterator(int index) { throw new UnsupportedOperationException(); }

    @Override
    public List subList(int fromIndex, int toIndex) { throw new UnsupportedOperationException(); }

    @Override
    public boolean retainAll(Collection c) { throw new UnsupportedOperationException(); }

    @Override
    public boolean removeAll(Collection c) { throw new UnsupportedOperationException();  }

    @Override
    public boolean containsAll(Collection c) { throw new UnsupportedOperationException(); }

    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) { throw new UnsupportedOperationException(); }

}
