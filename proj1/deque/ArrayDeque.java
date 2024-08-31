package deque;

public class ArrayDeque<T> {
    public T[] item;
    private int first_index;
    private int last_index;
    public int size = 0;
    private int capacity = 8;

    //init arraydeque
    public ArrayDeque(){
        item = (T[]) new Object[8];
    }

    //resize my array
    public void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            a[i] = item[i];
        }
        item = a;
    }
    // add from the front
    public void addFirst(T item){
        if (capacity == size) {
            resize(size * 2);
        }


    }
}
