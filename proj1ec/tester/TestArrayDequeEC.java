package tester;

import static org.junit.Assert.*;
import edu.princeton.cs.introcs.StdRandom;
import org.junit.Test;
import student.StudentArrayDeque;

public class TestArrayDequeEC {

    @Test
    public void randomizedTest() {
        StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solution = new ArrayDequeSolution<>();
        StringBuilder operations = new StringBuilder();

        for (int i = 0; i < 1000; i++) {
            //@source StudentArrayDequeLauncher.java
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.25) {
                student.addFirst(i);
                solution.addFirst(i);
                operations.append("addFirst(").append(i).append(")\n");
            } else if (numberBetweenZeroAndOne < 0.5) {
                student.addLast(i);
                solution.addLast(i);
                operations.append("addLast(").append(i).append(")\n");
            } else if (numberBetweenZeroAndOne < 0.75) {
                if (!student.isEmpty() && !solution.isEmpty()) {
                    Integer studentRemoved = student.removeFirst();
                    Integer solutionRemoved = solution.removeFirst();
                    operations.append("removeFirst()\n");
                    assertEquals(operations.toString(), solutionRemoved, studentRemoved);
                }
            } else {
                if (!student.isEmpty() && !solution.isEmpty()) {
                    Integer studentRemoved = student.removeLast();
                    Integer solutionRemoved = solution.removeLast();
                    operations.append("removeLast()\n");
                    assertEquals(operations.toString(), solutionRemoved, studentRemoved);
                }
            }
        }
    }
}
