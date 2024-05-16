public class IntList {
    int first;
    IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }
    //return all values incremented, but L don't change


    public static void main(String[] args){
        IntList L;
        L = new IntList(10,null);
        L.rest = new IntList(5,null);
        L.rest.rest = new IntList(7,null);
        System.out.println(L.first + ", " + L.rest.first + ", " + L.rest.rest.first);
    }

}
