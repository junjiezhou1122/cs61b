package deque;

public class LinkedListDeque implements Deque<T>{
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

    @Override
    public void addFirst(T item) {

    }

    @Override
    public void addLast(T item) {

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {

    }

    @Override
    public T removeFirst() {
        return null;
    }

    @Override
    public T removeLast() {
        return null;
    }

    @Override
    public T get(int index) {
        return null;
    }
}
