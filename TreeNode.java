public class TreeNode<E extends Comparable<E>> {
    E element;
    String color;
    TreeNode<E> left = null, right = null, parent = null;

    public TreeNode(E element) {
        this.element = element;
        this.color = "RED";
    }

    public boolean hasLeft() {
        return left != null;
    }

    public boolean hasRight() {
        return right != null;
    }

    public boolean hasTwoChildren() {
        return left != null && right != null;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }
}