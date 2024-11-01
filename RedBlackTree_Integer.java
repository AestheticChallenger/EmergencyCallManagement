public class RedBlackTree_Integer extends RedBlackTree<Integer> {

    public RedBlackTree_Integer(int[] array) {
        for (int i = 0; i < array.length; i++) {
            insert(Integer.valueOf(array[i]));
        }
    }

    public Integer sum() {
        return sum(root);
    }

    protected Integer sum(TreeNode<Integer> root) {
        if (root == NIL) // In RedBlackTree, NIL represents null leaves
            return 0;
        return root.element + sum(root.left) + sum(root.right);
    }

    public Integer sumLeaves() {
        return sumLeaves(root);
    }

    protected Integer sumLeaves(TreeNode<Integer> node) {
        if (node == NIL)
            return 0;
        if (node.left == NIL && node.right == NIL) // Check if it's a leaf
            return node.element;
        return sumLeaves(node.left) + sumLeaves(node.right);
    }

    public Integer countOdd() {
        return countOdd(root);
    }

    protected Integer countOdd(TreeNode<Integer> node) {
        if (node == NIL)
            return 0;
        if (node.element % 2 != 0) // Node stores an odd value
            return 1 + countOdd(node.left) + countOdd(node.right);
        else
            return countOdd(node.left) + countOdd(node.right);
    }
}
