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
<<<<<<< HEAD
        Node<T> newNode = new Node<>(item, sentinel, sentinel.next);
        if (sentinel.next != null) {
            sentinel.next.previous = newNode;
        }
        sentinel.next = newNode;
        if (size == 0) {
            sentinel.previous = newNode;
        }
        size += 1;
=======
        size++;
        if (sentinel.next == sentinel) {
            sentinel.next = new Node<T>(item, sentinel, sentinel);
            sentinel.prev = sentinel.next;
        } else {
            Node<T> p = new Node<T>(item, sentinel, sentinel.next);
            sentinel.next.prev = p;
            sentinel.next = p;
        }
>>>>>>> HEAD@{1}
    }

    @Override
    public void addLast(T item) {
<<<<<<< HEAD
        Node<T> newNode = new Node<>(item, sentinel.previous, sentinel);
        if (sentinel.next != null) {
            sentinel.previous.next = newNode;
        }
        sentinel.previous = newNode;
        if (size == 0) {
            sentinel.next = newNode;
        }
        size += 1;
    }

    // whether the list is empty or not
    @Override
    public boolean isEmpty() {
        if (sentinel.next == null) {
            return true;
=======
        size++;
        if (sentinel.next == sentinel) {
            sentinel.next = new Node<T>(item, sentinel, sentinel);
            sentinel.prev = sentinel.next;
        } else {
            Node<T> p = new Node<T>(item, sentinel.prev, sentinel);
            sentinel.prev.next = p;
            sentinel.prev = p;
>>>>>>> HEAD@{1}
        }

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        Node<T> p = sentinel;
        for (int i = 0; i < size; i++) {
            System.out.print(p.next.item);
            p = p.next;

        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        T removeItem = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;

        return removeItem;

       

    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        T removeItem = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size -= 1;
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
