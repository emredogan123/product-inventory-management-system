import java.util.ArrayList;
import java.util.List;

public class Tree<T extends Comparable<T>> {
    private Node<T> root;

    public Tree() {
        root = null;
    }

    public void add(T data) {
        root = addRecursive(root, data);
    }

    private Node<T> addRecursive(Node<T> node, T data) {
        if (node == null) {
            return new Node<>(data);
        }
        if (data.compareTo(node.data) < 0) {
            node.left = addRecursive(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = addRecursive(node.right, data);
        }
        return node;
    }

    public T search(T data) {
        return searchRecursive(root, data);
    }

    private T searchRecursive(Node<T> node, T data) {
        if (node == null || data.equals(node.data)) {
            return node == null ? null : node.data;
        }
        return data.compareTo(node.data) < 0 ? searchRecursive(node.left, data) : searchRecursive(node.right, data);
    }

    public List<T> list() {
        List<T> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    private void inorderTraversal(Node<T> node, List<T> result) {
        if (node != null) {
            inorderTraversal(node.left, result);
            result.add(node.data);
            inorderTraversal(node.right, result);
        }
    }
}
