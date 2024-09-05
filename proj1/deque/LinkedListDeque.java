package deque;
import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T>{

    public static class Node<T> {
        Node<T> prev;
        T item;
        Node<T> next;

        public Node(T item, Node<T> prev, Node<T> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;

        }
    }

    private Node<T> sentinel = new Node<T>(null, null, null);
    private int size;

    //Constructor
    public LinkedListDeque() {
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        int size = 0;
    }

    public LinkedListDeque(T item) {
        sentinel.next = new Node<T>(item, sentinel, sentinel);
        sentinel.prev = sentinel.next;
        int size = 1;
    }

    @Override
    public void addFirst(T item) {
        size++;
        Node<T> newNode = new Node<>(item, sentinel, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
    }

    @Override
    public void addLast(T item) {
        size++;
        Node<T> newNode = new Node<>(item, sentinel.prev, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
    }

    // whether the list is empty or not
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        Node<T> p = sentinel.next;
        for (int i = 0; i < size; i++) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        size--;
        T removeItem = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        return removeItem;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        size--;
        T removeItem = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        return removeItem;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node<T> p = sentinel.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }

        return p.item;
    }

    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        return helperRecursive(sentinel.next, index);

    }

    public T helperRecursive(Node<T> p, int index) {
        if (index == 0) {
            return p.item;
        }
        return helperRecursive(p.next, index);
    }

    public Iterator<T> iterator() {
        return new LinkedListDequeIterator();
    }

    private class LinkedListDequeIterator implements Iterator<T>{
        private Node<T> p;

        public LinkedListDequeIterator() {
            p = sentinel.next;
        }


        public boolean hasNext() {
            return !(p == sentinel);
        }


        public T next() {
            T item = p.item;
            p = p.next;
            return item;
        }

    }
}
