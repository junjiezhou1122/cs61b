package deque;

public class LinkedListDeque<T> {
    private static class Node<T> {
        //declare the main variable for Double list
        T item;
        Node<T> previous;
        Node<T> next;

        //declare a constructor for circular
        public Node(T item, Node<T> previous, Node<T> next){
            this.item = item;
            this.previous = previous;
            this.next = next;
        }

        public T getRecursive(int index) {

            if (index == 0) {
                return this.item;
            } else if (this.next != null){
                return this.next.getRecursive(index - 1);
            }
            return null;
        }
    }



    //create a sentinel
    Node<T> sentinel;

    //constructor
    public LinkedListDeque() {
        sentinel = new Node<T>(null, null, null);
    }

    // create a size variable
    int size = 0;

    //create a constructor
    public LinkedListDeque(T item, Node<T> previous, Node<T> next){
        sentinel = new Node<T>(null, null, null);
        sentinel = new Node<T>(item, sentinel,sentinel);
    }

    // insert the item at first
    public void addFirst(T item) {
        Node<T> p = new Node<>(item, null, null);
        sentinel.next.next = p.next;
        sentinel.next.next.previous = p;
        sentinel.next = p;
        p.previous = sentinel;
        size += 1;
    }

    // insert the item at last
    public void addLast(T item) {
        Node<T> p = new Node<>(item, null, null);
        sentinel.previous.next = p;
        p.previous = sentinel.previous;
        p.next = sentinel;
        sentinel.previous = p;
        size += 1;
    }

    // whether the list is empty or not
    public boolean isEmpty() {
        if (sentinel.next == null) {
            return true;
        }

        return false;
    }

    // return the size of list
    public int size() {
        return size;
    }

    // Prints the items in the deque from first to last, separated by a space.
    // Once all the items have been printed, print out a new line.
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(sentinel.next.item + " ");
            sentinel.next = sentinel;
        }
        System.out.println();
    }

    //Removes and returns the item at the front of the deque. If no such item exists, returns null.
    public T removeFirst() {
        if (sentinel.next == null) {
            return null;
        }

        Node<T> first = sentinel.next;
        sentinel.next = sentinel.next.next;
        sentinel.next.next.previous = sentinel;
        return first.item;
    }

     //Removes and returns the item at the back of the deque. If no such item exists, returns null.
     public T removeLast() {
        if (sentinel.previous == null) {
            return null;
        }

        Node<T> last = sentinel.previous;
        sentinel.previous = sentinel.previous.previous;
        sentinel.previous.previous.next = sentinel;
        return last.item;
     }

     //Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     // If no such item exists, returns null
    public T get(int index) {
        Node<T> p = sentinel;
        if (index <= 0 || index >= size) {
            return null;
        }

        for (int i = 0; i <= index; i++) {
            p = p.next;
        }

        return p.item;
    }

    //recursion version of get function
    public T getRecursive(int index) {
        //using helper function
        if (index < 0 || index >= size) {
            return null;
        }

        return sentinel.next.getRecursive(index);
    }
}
