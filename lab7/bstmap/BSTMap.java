package bstmap;

import com.sun.jdi.Value;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>,V> implements Map61B<K, V>, Iterable<K>{
    private Node root;
    private int size; // Add this field to track the size

    // Add a no-argument constructor
    public BSTMap() {
        root = null;
        size = 0;
    }

    // Keep your existing constructor if needed
    public BSTMap(K key, V value, Node left, Node right) {
        root = new Node(key, value, left, right);
        root.N++;
    }
    @Override
    public void clear() {
        root = null;
        size = 0; // Reset size when clearing the tree
        return;
    }


  

    @Override
    public boolean containsKey(K key) {
        return containsKey(key, root);
    }

    public boolean containsKey(K key, Node r) {
        if (r == null) {
            return false;
        }

        int cmp = key.compareTo(r.key);
        if (cmp > 0) {
            containsKey(key, r.right);
        }

        if (cmp < 0) {
            containsKey(key, r.left);
        }

        return true;
    }

    @Override
    public V get(K key) {
        if (!containsKey(key)) {
            return null;
        }
        return get(key, root);

    }

    public V get(K key, Node r) {

        if (key == r.key) {
            return r.value;
        }
        int cmp = key.compareTo(r.key);
        if (cmp > 0) {
            return get(key, r.right);
        } else {
            return get(key, r.left);
        }
    }

    @Override
    public int size() {
        return size; // Return the tracked size
    }

    public int size(Node r) {
        if (r == null) {
            return 0;
        }
        return 1 + size(r.left) + size(r.right);
    }

    @Override
    public void put(K key, V value) {
        root = put(key, value, root);
    }

    public Node put(K key, V value, Node r) {
        if (r == null) {
            size++; // Increment size when adding a new node
            return new Node(key, value);
        }

        int cmp = key.compareTo(r.key);
        if (cmp > 0) {
            return put(key, value, r.right);
        }

        if (cmp < 0) {
            return put(key, value, r.left);
        }
        return r;

    }

    @Override
    public Set<K> keySet() {
        Set<K> keySet = new HashSet<>();
        collectKeys(root, keySet);  // Helper method to collect keys
        return keySet;
    }

    // Helper method to traverse the tree and collect keys
    private void collectKeys(Node node, Set<K> keySet) {
        if (node == null) {
            return;
        }
        keySet.add(node.key);        // Add the key of the current node
        collectKeys(node.left, keySet);  // Recur on the left subtree
        collectKeys(node.right, keySet); // Recur on the right subtree
    }


    @Override
    public V remove(K key) {
        Node[] result = new Node[1];
        root = remove(key, root, result);
        if (result[0] != null) {
            size--; // Decrement size when removing a node
            return result[0].value;
        }
        return null;
    }

    public Node remove(K key, Node r, Node[] removed) {
        if (r == null) {
            return null;
        }
        int cmp = key.compareTo(r.key);
        if (cmp > 0) {
            r.right = remove(key, r.right, removed);
        } else if (cmp < 0) {
            r.left = remove(key, r.left, removed);
        } else {
            removed[0] = r; // Store the node to be removed
            if (r.left == null) {
                return r.right;
            }
            if (r.right == null) {
                return r.left;
            }

            Node t = r;
            r = min(t.right);
            r.right = deleteMin(t.right);
            r.left = t.left;
        }
        return r;
    }

    public Node min(Node r) {
        if (r == null) {
            return null;
        }
        if (r.left == null) {
            return r;
        }
        return min(r.left);
    }

    public Node deleteMin(Node x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        return x;
    }

    @Override
    public V remove(K key, V value) {
        V x = null;
        if (containsKey(key)) {
            x = get(key);
            if (x == value) {
                remove(key);
            }
        }
        return x;
    }

    @Override
    public Iterator<K> iterator() {
        return keySet().iterator();
    }


    private class Node {
        private K key;
        private V value;
        private Node left, right;
        private int N;

        public Node(K key, V value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        // Add a constructor that doesn't require left and right nodes
        public Node(K key, V value) {
            this(key, value, null, null);
        }
    }
}
