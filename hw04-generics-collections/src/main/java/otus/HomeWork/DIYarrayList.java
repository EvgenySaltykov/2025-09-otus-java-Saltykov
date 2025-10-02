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
            throw new IndexOutOfBoundsException("class !DIY_ArrayList Index!: " + index + ", Size: " + size);
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
        int cSize = c.size();
        if (c == null) {
            throw new NullPointerException("Collection to add cannot be null");
        }
        if (c.isEmpty()) {
            return false;
        }

        if (Integer.MAX_VALUE - this.size < cSize) {
            throw new OutOfMemoryError("class DIY_ArrayList Required array size too large");
        }

        int newSize = this.size + cSize;
        if (this.elementData.length < newSize) {
            int newCapacity = elementData.length == 0
                    ? Math.max(DEFAULT_CAPACITY, newSize)
                    : Math.max(newSize, elementData.length + (elementData.length / 2));
            elementData = Arrays.copyOf(elementData, newCapacity);
        }

        System.arraycopy(c.toArray(), 0, this.elementData, this.size, c.size());
        this.size = newSize;

        return true;
    }

    public static <T> void copy(List<? super T> dest, List<? extends T> src) {
        int srcSize = src.size();
        if (dest.size() < srcSize) {
            throw new IndexOutOfBoundsException("class DIY_ArrayList Destination list is smaller than source list");
        }

        if (dest instanceof RandomAccess && src instanceof RandomAccess) {
            for (int i = 0; i < srcSize; i++) {
                dest.set(i, src.get(i));
            }
        } else {
            ListIterator<? super T> di = dest.listIterator();
            ListIterator<? extends T> si = src.listIterator();
            for (int i = 0; i < srcSize; i++) {
                di.next();
                T siNext = si.next();
                di.set(siNext);

//                di.set(si.next());
            }
        }
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException("method addAll(int index, Collection<? extends T> c) not implemented");
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("method isEmpty() not implemented");
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException("method contains() not implemented");
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("method iterator() not implemented");
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException("method toArray(T1[] a) not implemented");
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("method remove() not implemented");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("method containsAll() not implemented");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("method removeAll() not implemented");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("method retainAll() not implemented");
    }

    @Override
    public void replaceAll(UnaryOperator<T> operator) {
        throw new UnsupportedOperationException("method replaceAll() not implemented");
    }

    @Override
    public void sort(Comparator<? super T> c) {
        throw new UnsupportedOperationException("method sort() not implemented");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("method clear() not implemented");
    }

    @Override
    public T set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("class !DIY_ArrayList Index!: " + index + ", Size: " + size);
        }

        T oldValue = (T) elementData[index];
        this.elementData[index] = element;

        return oldValue;
    }

    @Override
    public void add(int index, T element) {
        throw new UnsupportedOperationException("method add(int index, T element) not implemented");
    }

    @Override
    public T remove(int index) {
        throw new UnsupportedOperationException("method remove(int index) not implemented");
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("method indexOf() not implemented");
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("method lastIndexOf() not implemented");
    }

    @Override
    public ListIterator<T> listIterator() {
        return new LstIterator();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException("method listIterator(int index) not implemented");
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("method subList() not implemented");
    }

    @Override
    public Spliterator<T> spliterator() {
        throw new UnsupportedOperationException("method spliterator() not implemented");
    }

    private class LstIterator implements ListIterator<T> {
        private int cursor;       // index of next element to return
        private int lastRet = -1; // index of last element returned; -1 if no such

        public LstIterator() {
            this.cursor = 0;
        }

        @Override
        public boolean hasNext() {
            throw new UnsupportedOperationException("method hasNext() not implemented");
        }

        @Override
        public T next() {
            int i = cursor;
            if (i >= size)
                throw new NoSuchElementException("class !DIY_ArrayList no such element at index: " + i);
            Object[] elementData = DIYarrayList.this.elementData;
            if (i >= elementData.length)
                throw new ConcurrentModificationException("class !DIY_ArrayList concurrent modification at index: " + i);
            cursor = i + 1;
            return (T) elementData[lastRet = i];
        }

        @Override
        public boolean hasPrevious() {
            throw new UnsupportedOperationException("method hasPrevious() not implemented");
        }

        @Override
        public T previous() {
            throw new UnsupportedOperationException("method previous() not implemented");
        }

        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException("method nextIndex() not implemented");
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException("method previousIndex() not implemented");
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("method remove() not implemented");
        }

        @Override
        public void set(T t) {
            if(lastRet == -1) {
                throw new IllegalStateException("class !DIY_ArrayList illegal state, lastRet = -1");
            }
            DIYarrayList.this.elementData[lastRet] = t;
        }

        @Override
        public void add(T t) {
            throw new UnsupportedOperationException("method add() not implemented");
        }
    }
}