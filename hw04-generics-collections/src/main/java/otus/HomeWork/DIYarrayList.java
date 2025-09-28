package otus.HomeWork;

import java.util.*;
import java.util.function.UnaryOperator;

public class DIYarrayList<T> implements List<T> {
    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elementData;
    private static final Object[] EMPTY_ELEMENTDATA = {};
    private int size = 0;

    public DIYarrayList() {
        this.elementData = EMPTY_ELEMENTDATA;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size || elementData.length == 0) {
            throw new IndexOutOfBoundsException();
        }
        return (T) elementData[index];
    }

    @Override
    public boolean add(T t) {
        if (elementData.length == 0) {
            elementData = new Object[DEFAULT_CAPACITY];
            elementData[size] = t;
            size++;
        } else {
            if (elementData.length == size) {
                int newCapacity = elementData.length + (elementData.length / 2);
                elementData = Arrays.copyOf(elementData, newCapacity);
                elementData[size] = t;
                size++;
            } else {
                elementData[size] = t;
                size++;
            }
        }

        return true;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c == null || c.isEmpty()) {
            return false;
        }

//        i f (elementData.length == 0) {
//            size = DEFAULT_CAPACITY;
//            elementData = new Object[size];
//        }
        int newSize = this.size + c.size();
        if (newSize > this.elementData.length) {
            int newCapacity = newSize + newSize / 2;
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
        System.arraycopy(c.toArray(), 0, this.elementData, this.size, c.size());
        this.size = newSize;

        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void replaceAll(UnaryOperator<T> operator) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void sort(Comparator<? super T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public T set(int index, T element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, T element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Spliterator<T> spliterator() {
        throw new UnsupportedOperationException();
    }
}