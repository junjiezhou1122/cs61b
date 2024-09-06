package deque;

import java.util.Comparator;
public class MaxArrayDeque<T> extends ArrayDeque<T>{
    private Comparator<T> comparator;

    public MaxArrayDeque(Comparator<T> c) {
        super();
        comparator = c;
    }

    public T max() {
        return max(this.comparator);
    }

    public T max(Comparator<T> c) {
        if (isEmpty()) {
            return null;
        }

        T maxItem = get(0);

        for (int i = 1; i < size(); i++) {
            T item = get(i);
            if (c.compare(item, maxItem) > 0) {
                maxItem = item;
            }
        }

        return maxItem;

    }
}
