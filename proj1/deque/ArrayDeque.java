package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T>{
    private T[] items;
    private int size;
    private int front;
    private int rear;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        front = -1;
        rear = -1;
    }

    @Override
    public void addFirst(T item) {
        if (isFull()) {
            resize();
        }
        if (size == 0) {
            items[0] = item;
            front = 0;
            rear = 0;
        } else {
            front = (front - 1) % items.length;
            items[front] = item;
        }
        size++;

    }

    @Override
    public void addLast(T item) {
        if (isFull()) {
            resize();
        }

        if (size == 0) {
            items[0] = item;
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % items.length;
            items[rear] = item;
        }
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (int i = front; i < size; i = (i + 1) % items.length) {
            System.out.print(items[i]);
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T removeItem = items[front];
        if (size == 1) {
            front = - 1;
            rear = -1;
        } else {
            front = (front + 1) % items.length;
        }
        size--;
        return removeItem;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T removeItem = items[rear];
        if (size == 1) {
            front = -1;
            rear = -1;
        } else {
            rear = (rear - 1) % items.length;
        }
        size--;
        return removeItem;

    }

    @Override
    public T get(int index) {
        return items[(front + index) % items.length];
    }

    @Override
    public Iterator iterator() {
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements Iterator<T>{
        private int x;

        public ArrayDequeIterator() {
            x = 0;
        }

        @Override
        public boolean hasNext() {
           return x < size;
        }

        @Override
        public T next() {
            return items[(front + x) % items.length];
        }


    }

    private void resize() {
        T[] newItems = (T[]) new Object[items.length * 2];
        for (int i = 0; i < size; i++) {
            newItems[i] = get(i);
        }
        items = newItems;
        front = 0;
        rear = size - 1;
    }

    private boolean isFull() {
        return size == items.length;
    }
}
