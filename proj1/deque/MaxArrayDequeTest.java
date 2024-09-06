package deque;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Comparator;

public class MaxArrayDequeTest {

    private static class IntegerComparator implements Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            return a.compareTo(b);
        }
    }

    private static class StringLengthComparator implements Comparator<String> {
        public int compare(String a, String b) {
            return Integer.compare(a.length(), b.length());
        }
    }

    @Test
    public void testMaxWithIntegers() {
        MaxArrayDeque<Integer> mad = new MaxArrayDeque<>(new IntegerComparator());
        mad.addLast(3);
        mad.addLast(1);
        mad.addLast(4);
        mad.addLast(2);

        assertEquals(Integer.valueOf(4), mad.max());
    }

    @Test
    public void testMaxWithStrings() {
        MaxArrayDeque<String> mad = new MaxArrayDeque<>(new StringLengthComparator());
        mad.addLast("a");
        mad.addLast("abc");
        mad.addLast("ab");
        mad.addLast("abcd");

        assertEquals("abcd", mad.max());
    }

    @Test
    public void testMaxWithCustomComparator() {
        MaxArrayDeque<String> mad = new MaxArrayDeque<>(String::compareTo);
        mad.addLast("b");
        mad.addLast("a");
        mad.addLast("c");

        Comparator<String> reverseComparator = (s1, s2) -> s2.compareTo(s1);
        assertEquals("c", mad.max());
        assertEquals("a", mad.max(reverseComparator));
    }

    @Test
    public void testMaxWithEmptyDeque() {
        MaxArrayDeque<Integer> mad = new MaxArrayDeque<>(new IntegerComparator());
        assertNull(mad.max());
    }
}
