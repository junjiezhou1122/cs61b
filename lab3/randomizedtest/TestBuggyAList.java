package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();

        correct.addLast(5);
        correct.addLast(10);
        correct.addLast(15);

        broken.addLast(5);
        broken.addLast(10);
        broken.addLast(15);

        assertEquals(correct.size(), broken.size());

        assertEquals(correct.removeLast(), broken.removeLast());
        assertEquals(correct.removeLast(), broken.removeLast());
        assertEquals(correct.removeLast(), broken.removeLast());
    }
    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B_L = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B_L.addLast(randVal);
                assertEquals(L.getLast(), B_L.getLast());
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int B_size = B_L.size();
                assertEquals(size, B_size);
                System.out.println("L size: " + size + " B_L size: " + B_size);
            }else if (operationNumber == 2 && L.size() > 0) {
                int Last_v = L.getLast();
                int Last_bv = B_L.getLast();
                assertEquals(Last_v, Last_bv);
                System.out.println("L last:" + Last_v + " B_L last: " + Last_bv);
            }else if (operationNumber == 3 && L.size() > 0) {
                int Last_v2 = L.removeLast();
                int Last_bv2 = B_L.removeLast();
                assertEquals(Last_v2, Last_bv2);
                System.out.println("L remove the last:" + Last_v2 + " B_L remove the last: " + Last_bv2);

            }
        }
    }
}
