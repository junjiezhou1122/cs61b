package deque;

public class LinkedListDeque<T> {
    public class TNode {
        public T item;
        public TNode next;
        public TNode prev;

        public TNode(T i, TNode n, TNode pn) {
            item = i;
            next = n;
            prev = pn;
        }
    }
    private TNode sentinel;
    private int size = 0;

    public LinkedListDeque() {
            sentinel = new TNode(null, null, null);
            sentinel.prev = sentinel;
        }


        public void addFirst(T item) {
            TNode p = new TNode(item, null, null);

            if (sentinel.next == null) {
                sentinel.next = p;
                p.prev = sentinel;
                sentinel.prev = p;
            }
            else {
                p.next = sentinel.next;
                sentinel.next.prev = p;
                p.prev = sentinel;
                sentinel.next = p;
            }
            size++;

        }

        public void addLast(T item) {
            TNode p = sentinel.prev;
            p.next = new TNode (item, null, null);
            p.next.prev = p;
            sentinel.prev = p.next;
            p.next.next = sentinel;
            size++;
        }

        public boolean isEmpty() {
            if (sentinel.next == null) {
                return true;
            }
            return false;
        }

        public int size(){
            return size;
        }

        public void printDeque() {
            TNode p = sentinel.next;
            for (int i = 0; i < size; i++){
                System.out.print(p.item + " ");
                p = p.next;
            }
            System.out.println();
        }

        public T removeFirst() {
            if (size == 0){
                return null;
            }
            TNode p = sentinel.next;
            sentinel.next = p.next;
            p.next.prev = sentinel;
            p.next = null;
            p.prev = null;
            size--;

            return p.item;
        }

        public T removeLast() {

            if (size == 0) {
                return null;
            }

            TNode p = sentinel.prev;
            sentinel.prev = p.prev;
            p.prev.next = sentinel;
            p.prev = null;
            p.next = null;
            size--;

            return p.item;
        }

        public T get(int index){
            if (sentinel.next == null){
                return null;
            }
            TNode p = sentinel.next;
            while(index != 0){
                p = p.next;
                index--;
            }
            return p.item;
        }

        public T getFirst() {
            return sentinel.next.item;
        }

        public T getLast() {
            return sentinel.prev.item;
        }

        public static void main (String[] args) {
            LinkedListDeque<Integer> li = new LinkedListDeque<Integer>();
            li.addFirst(1);
            li.addFirst(2);
            li.addLast(3);
            System.out.println(li.get(0));
            System.out.println(li.get(1));
            System.out.println(li.get(2));
            li.printDeque();
            System.out.println(li.getFirst());
            System.out.println(li.getLast());
            System.out.println(li.size());
        }


    }

