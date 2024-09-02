package deque;

import org.junit.Test;

import java.util.Objects;


public class ArrayDeque<T> implements Deque<T>{
    private T[] items;
    private int front;
    private int rear;
    private int size;

    public ArrayDeque() {
        items = (T[]) new Objects[8];
        front = -1;
        rear = -1;
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        if (isFull()) {
            items = resize(items);
        }
        size++;
        if (front == - 1) {
            front = 0;
            rear = 0;
            items[front] = item;
        } else if (front == 0) {
            front = items.length - 1;
            items[front] = item;
        } else {
            front -= 1;
            items[front] = item;
        }
    }

    @Override
    public void addLast(T item) {
        if (isFull()) {
            items = resize(items);
        }

        size++;
        if (front == -1) {
            front = 0;
            rear = 0;
            items[rear] = item;
        } else if (rear == items.length - 1) {
            rear = 0;
            items[rear] = item;
        } else {
            rear += 1;
            items[rear] = item;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (T item: items) {
            System.out.print(item + " ");
        }

        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (front == - 1) {
            return null;
        }
        T removeItem = items[front];
        front = (front + 1) % items.length;
        return removeItem;
    }

    @Override
    public T removeLast() {
        if (rear == -1) {
            return null;
        }
        T removeItem = items[front];
        rear = (rear - 1) % items.length;
        return removeItem;
    }

    @Override
    public T get(int index) {
        return items[index];
    }

    public T[] resize(T[] items) {
        T[] items2 = (T[]) new Objects[items.length * 2];
        for (int i = 0; i < items.length; i++) {
            items2[i] = items[i];
        }
        return items2;
    }

    public boolean isFull() {
        if (size == items.length) {
            return true;
        }
        return false;
    }
}

    