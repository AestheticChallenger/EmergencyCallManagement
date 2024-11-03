
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

    public boolean isLeftChild() {
        return this == parent.left;
    }

    // gets the other child of the parent node
    public TreeNode<E> getSibling() {
        if (parent == null) {
            return null;
        }

        if (isLeftChild()) {
            return parent.right;
        }

        return parent.left;
    }

    public TreeNode<E> getUncle() {
        TreeNode<E> grandparent = parent.parent;
        if (parent == null || grandparent == null)
            return null;

        if (parent.isLeftChild())
            return grandparent.right; // uncle i.e parent's sibling

        else
            return grandparent.left;
    }

    public boolean hasRedChild() {
        return (hasLeft() && left.color == "RED") || (hasRight() && right.color == "RED");
    }

     void moveDown(TreeNode<E> newNode) {
        if (parent != null) {
            if (isLeftChild())
                parent.left = newNode;
            else
                parent.right = newNode;
        }
        newNode.parent = parent;
        parent = newNode;
    }

}