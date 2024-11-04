
/**
 * Afrah - 1090111
 * Aysha - 1088000
 * Mehejet - 10
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RedBlackTree_Sec77_G7<E extends Comparable<E>> extends AbstractTree_Sec77_G7<E> {
    protected TreeNode_Sec77_G7<E> root;
    protected int size = 0;
    final TreeNode_Sec77_G7<E> NIL = new TreeNode_Sec77_G7<>(null);

    public RedBlackTree_Sec77_G7() {
        NIL.color = "BLACK";
        root = NIL;
    }

    /* Create a Red-Black Tree from an array of objects */
    public RedBlackTree_Sec77_G7(E[] objects) {
        this();
        for (E e : objects) {
            insert(e);
        }
    }

    // ANSI color codes for black and red
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String BLACK = "\u001B[30m";

    public void print() {
        int maxLevel = maxLevel(this.root);
        List<TreeNode_Sec77_G7<E>> nodes = new ArrayList<>();
        nodes.add(this.root);
        printPyramid(nodes, 1, maxLevel);
    }

    private void printPyramid(List<TreeNode_Sec77_G7<E>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNil(nodes))
            return;

        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, Math.max(floor - 1, 0));
        int firstSpaces = (int) Math.pow(2, floor) - 1;
        int betweenSpaces = (int) Math.pow(2, floor + 1) - 1;

        // Adjust space for multi-digit numbers dynamically
        printSpaces(firstSpaces);

        List<TreeNode_Sec77_G7<E>> newNodes = new ArrayList<>();
        for (TreeNode_Sec77_G7<E> node : nodes) {
            if (node != NIL) {
                String colorCode = node.color.equals("BLACK") ? BLACK : RED;
                if (node.element instanceof EmergencyCall_Sec77_G7) {
                    System.out.println(colorCode + ((EmergencyCall_Sec77_G7) (node.element)).getCallID() + RESET);
                }

                else if (node.element instanceof Ambulance_Sec77_G7) {
                    System.out.println(colorCode + ((Ambulance_Sec77_G7) (node.element)).getAmbulanceID() + RESET);
                }

                else {
                    System.out.print(colorCode + node.element + RESET);
                }
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                System.out.print("  "); // Placeholder for empty space
                newNodes.add(NIL);
                newNodes.add(NIL);
            }
            printSpaces(betweenSpaces);
        }
        System.out.println();

        // Print branch lines connecting nodes
        for (int i = 1; i <= edgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printSpaces(firstSpaces - i);
                if (nodes.get(j) == NIL) {
                    printSpaces(edgeLines + edgeLines + i + 1);
                    continue;
                }

                // Print '/' for left child and '\' for right child
                if (nodes.get(j).left != NIL) {
                    System.out.print("/");
                } else {
                    printSpaces(1);
                }

                printSpaces(i + i - 1);

                if (nodes.get(j).right != NIL) {
                    System.out.print("\\");
                } else {
                    printSpaces(1);
                }

                printSpaces(edgeLines + edgeLines - i);
            }
            System.out.println();
        }
        printPyramid(newNodes, level + 1, maxLevel);
    }

    private void printSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    private int maxLevel(TreeNode_Sec77_G7<E> node) {
        if (node == NIL)
            return 0;
        return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
    }

    private boolean isAllElementsNil(List<TreeNode_Sec77_G7<E>> list) {
        for (TreeNode_Sec77_G7<E> node : list) {
            if (node != NIL)
                return false;
        }
        return true;
    }

    @Override
    public boolean search(E e) {
        TreeNode_Sec77_G7<E> current = root;
        while (current != NIL) {
            if (e.compareTo(current.element) < 0) {
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                current = current.right;
            } else {
                return true;
            }
        }
        return false;
    }

    protected TreeNode_Sec77_G7<E> createNewNode(E e) {
        TreeNode_Sec77_G7<E> node = new TreeNode_Sec77_G7<>(e);
        node.color = "RED";
        node.left = NIL;
        node.right = NIL;
        return node;
    }

    @Override
    public boolean insert(E e) {
        TreeNode_Sec77_G7<E> newNode = createNewNode(e);

        if (root == NIL) {
            root = newNode;
            root.color = "BLACK";
            root.parent = NIL;

        } else {
            TreeNode_Sec77_G7<E> parent = NIL;
            TreeNode_Sec77_G7<E> current = root;

            while (current != NIL) {
                parent = current;
                if (e.compareTo(current.element) < 0) {
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    current = current.right;
                } else {
                    return false;
                }
            }

            newNode.parent = parent;
            if (e.compareTo(parent.element) < 0) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }

            fixInsert(newNode);
        }
        size++;
        return true;
    }

    private void fixInsert(TreeNode_Sec77_G7<E> node) {
        while (node.parent != NIL && node.parent.color.equals("RED")) {
            if (node.parent == node.parent.parent.left) {
                TreeNode_Sec77_G7<E> uncle = node.parent.parent.right;
                if (uncle.color.equals("RED")) {
                    node.parent.color = "BLACK";
                    uncle.color = "BLACK";
                    node.parent.parent.color = "RED";
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.right) {
                        node = node.parent;
                        leftRotate(node);
                    }
                    node.parent.color = "BLACK";
                    node.parent.parent.color = "RED";
                    rightRotate(node.parent.parent);
                }
            } else {
                TreeNode_Sec77_G7<E> uncle = node.parent.parent.left;
                if (uncle.color.equals("RED")) {
                    node.parent.color = "BLACK";
                    uncle.color = "BLACK";
                    node.parent.parent.color = "RED";
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.left) {
                        node = node.parent;
                        rightRotate(node);
                    }
                    node.parent.color = "BLACK";
                    node.parent.parent.color = "RED";
                    leftRotate(node.parent.parent);
                }
            }
        }
        root.color = "BLACK";
    }

    private void leftRotate(TreeNode_Sec77_G7<E> node) {
        TreeNode_Sec77_G7<E> newParent = node.right; // Set newParent as node's right child
        node.right = newParent.left; // Move newParent's left subtree to node's right

        if (newParent.left != NIL) {
            newParent.left.parent = node; // Update parent pointer of the moved subtree
        }

        newParent.parent = node.parent; // Update newParent's parent to be node's parent
        if (node.parent == NIL) {
            root = newParent; // Update root if node was the root
        } else if (node == node.parent.left) {
            node.parent.left = newParent; // Update left child if node was a left child
        } else {
            node.parent.right = newParent; // Update right child if node was a right child
        }

        newParent.left = node; // Move node under newParent as the left child
        node.parent = newParent; // Update node's parent to newParent
    }

    private void rightRotate(TreeNode_Sec77_G7<E> node) {
        TreeNode_Sec77_G7<E> newParent = node.left; // Set newParent as node's left child
        node.left = newParent.right; // Move newParent's right subtree to node's left

        if (newParent.right != NIL) {
            newParent.right.parent = node; // Update parent pointer of the moved subtree
        }

        newParent.parent = node.parent; // Update newParent's parent to node's parent
        if (node.parent == NIL) {
            root = newParent; // Update root if node was the root
        } else if (node == node.parent.right) {
            node.parent.right = newParent; // Update right child if node was a right child
        } else {
            node.parent.left = newParent; // Update left child if node was a left child
        }

        newParent.right = node; // Move node under newParent as the right child
        node.parent = newParent; // Update node's parent to newParent
    }

    @Override
    public void inorder() {
        inorder(root);
    }

    private void inorder(TreeNode_Sec77_G7<E> root) {
        if (root != NIL) {
            inorder(root.left);
            System.out.print("(" + root.element + ", " + root.color + ") ");
            inorder(root.right);
        }
    }

    @Override
    public void postorder() {
        postorder(root);
    }

    private void postorder(TreeNode_Sec77_G7<E> root) {
        if (root != NIL) {
            postorder(root.left);
            postorder(root.right);
            System.out.print("(" + root.element + ", " + root.color + ") ");
        }
    }

    @Override
    public void preorder() {
        preorder(root);
    }

    private void preorder(TreeNode_Sec77_G7<E> root) {
        if (root != NIL) {
            System.out.print("(" + root.element + ", " + root.color + ") ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    public TreeNode_Sec77_G7<E> getRoot() {
        return root;
    }

    public void clear() {
        root = NIL;
        size = 0;
    }

    public ArrayList<TreeNode_Sec77_G7<E>> path(E e) {
        ArrayList<TreeNode_Sec77_G7<E>> list = new ArrayList<>();
        TreeNode_Sec77_G7<E> current = root;
        while (current != NIL) {
            list.add(current);
            if (e.compareTo(current.element) < 0) {
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                current = current.right;
            } else {
                break;
            }
        }
        return list;
    }

    public void deleteByTheElement(E element) {
        TreeNode_Sec77_G7<E> nodeToDelete = searchNode(element);
        if (nodeToDelete == NIL) {
            System.out.println("No node found to delete with value: " + element);
            return;
        }
        deleteNode(nodeToDelete);
        size--;
    }

    private TreeNode_Sec77_G7<E> searchNode(E element) {
        TreeNode_Sec77_G7<E> current = root;
        while (current != NIL) {
            int cmp = element.compareTo(current.element);
            if (cmp < 0) {
                current = current.left;
            } else if (cmp > 0) {
                current = current.right;
            } else {
                return current;
            }
        }
        return NIL;
    }

    private void deleteNode(TreeNode_Sec77_G7<E> node) {
        TreeNode_Sec77_G7<E> replacement = BSTreplace(node);

        boolean bothBlack = ((replacement == NIL || replacement.color.equals("BLACK")) && node.color.equals("BLACK"));
        TreeNode_Sec77_G7<E> parent = node.parent;

        if (replacement == NIL) {
            if (node == root) {
                root = NIL;
            } else {
                if (bothBlack) {
                    fixDoubleBlack(node);
                } else if (node.getSibling() != NIL) {
                    node.getSibling().color = "RED";
                }
                if (node.isLeftChild()) {
                    parent.left = NIL;
                } else {
                    parent.right = NIL;
                }
            }
            return;
        }

        if (node.left == NIL || node.right == NIL) {
            if (node == root) {
                root = replacement;
                root.color = "BLACK";
                root.parent = NIL;
            } else {
                if (node.isLeftChild()) {
                    parent.left = replacement;
                } else {
                    parent.right = replacement;
                }
                replacement.parent = parent;
                if (bothBlack) {
                    fixDoubleBlack(replacement);
                } else {
                    replacement.color = "BLACK";
                }
            }
            return;
        }

        swapValues(node, replacement);
        deleteNode(replacement);
    }

    private TreeNode_Sec77_G7<E> BSTreplace(TreeNode_Sec77_G7<E> node) {
        if (node.left == NIL && node.right == NIL) {
            return NIL;
        }
        if (node.hasTwoChildren()) {
            return findMin(node.right);
        }
        return node.left != NIL ? node.left : node.right;
    }

    private TreeNode_Sec77_G7<E> findMin(TreeNode_Sec77_G7<E> node) {
        if (node == NIL) {
            return NIL;
        }

        while (node.left != NIL) {
            node = node.left;
        }
        return node;
    }

    public Ambulance_Sec77_G7 findNearestAmbulance(TreeNode_Sec77_G7<E> node) {
        if (node == NIL) {
            return null;
        }

        while (node.left != NIL) {
            node = node.left;
        }
        return (Ambulance_Sec77_G7) (node.element);
    }

    private void fixDoubleBlack(TreeNode_Sec77_G7<E> node) {
        if (node == root) {
            return;
        }

        TreeNode_Sec77_G7<E> sibling = node.getSibling();
        TreeNode_Sec77_G7<E> parent = node.parent;

        if (sibling == NIL) {
            fixDoubleBlack(parent);
        } else {
            if (sibling.color.equals("RED")) {
                parent.color = "RED";
                sibling.color = "BLACK";
                if (sibling.isLeftChild()) {
                    rightRotate(parent);
                } else {
                    leftRotate(parent);
                }
                fixDoubleBlack(node);
            } else {
                if (sibling.hasRedChild()) {
                    if (sibling.left != NIL && sibling.left.color.equals("RED")) {
                        if (sibling.isLeftChild()) {
                            sibling.left.color = sibling.color;
                            sibling.color = parent.color;
                            rightRotate(parent);
                        } else {
                            sibling.left.color = parent.color;
                            rightRotate(sibling);
                            leftRotate(parent);
                        }
                    } else {
                        if (sibling.isLeftChild()) {
                            sibling.right.color = parent.color;
                            leftRotate(sibling);
                            rightRotate(parent);
                        } else {
                            sibling.right.color = sibling.color;
                            sibling.color = parent.color;
                            leftRotate(parent);
                        }
                    }
                    parent.color = "BLACK";
                } else {
                    sibling.color = "RED";
                    if (parent.color.equals("BLACK")) {
                        fixDoubleBlack(parent);
                    } else {
                        parent.color = "BLACK";
                    }
                }
            }
        }
    }

    private void swapValues(TreeNode_Sec77_G7<E> node1, TreeNode_Sec77_G7<E> node2) {
        E temp = node1.element;
        node1.element = node2.element;
        node2.element = temp;
    }

    private void fixRedRed(TreeNode_Sec77_G7<E> node) {
        // If node is root, make it black and return
        if (node == root) {
            node.color = "BLACK";
            return;
        }

        TreeNode_Sec77_G7<E> parent = node.parent;
        TreeNode_Sec77_G7<E> grandparent = parent.parent;
        TreeNode_Sec77_G7<E> uncle = node.getUncle();

        // If parent is black, there's no violation, so return
        if (parent.color.equals("BLACK")) {
            return;
        }

        if (uncle != NIL && uncle.color.equals("RED")) {
            // Case 1: Uncle is red; perform recoloring and recurse on grandparent
            parent.color = "BLACK";
            uncle.color = "BLACK";
            grandparent.color = "RED";
            fixRedRed(grandparent);
        } else {
            // Uncle is black, so rotation and recoloring are needed
            if (parent.isLeftChild()) {
                if (node.isLeftChild()) {
                    // Case 2: Left-Left (LL) rotation
                    rightRotate(grandparent);
                } else {
                    // Case 3: Left-Right (LR) rotation
                    leftRotate(parent);
                    rightRotate(grandparent);
                }
            } else {
                if (node.isLeftChild()) {
                    // Case 4: Right-Left (RL) rotation
                    rightRotate(parent);
                    leftRotate(grandparent);
                } else {
                    // Case 5: Right-Right (RR) rotation
                    leftRotate(grandparent);
                }
            }
            // After rotations, adjust colors
            parent.color = "BLACK";
            grandparent.color = "RED";
        }
    }

    // public void MaxOccurence(TreeNode<E> node) {
    Object[][] locations = new Object[8][2];

    //     if (node == NIL)
    //         return 0;
    //     if (node.element % 2 != 0) // Node stores an odd value
    //         return 1 + countOdd(node.left) + countOdd(node.right);
    //     else
    //         return countOdd(node.left) + countOdd(node.right);
    // }
    // }

    
    // public int NumberOfOccurrences(Integer VAL) {
    //     return NumberOfOccurrences(root, VAL);
    // }

    // protected int NumberOfOccurrences(TreeNode<Integer> node, Integer VAL) {
    //     if (node == null)
    //         return 0;
    //     return (node.element % VAL == 0 ? 1 : 0) + NumberOfOccurrences(node.left, VAL)
    //             + NumberOfOccurrences(node.right, VAL);
    // }

    @Override
    public Iterator<E> iterator() {
        return new InorderIterator(); // Return a new instance of InorderIterator
    }

    // Inner class InorderIterator
    private class InorderIterator implements Iterator<E> {
        // Store the elements in a list
        private ArrayList<E> list = new ArrayList<>();
        private int current = 0; // Point to the current element in list

        public InorderIterator() {
            inorder(); // Traverse binary tree and store elements in list
        }

        /* Inorder traversal from the root */
        private void inorder() {
            inorder(root);
        }

        /* Inorder traversal from a subtree */
        private void inorder(TreeNode_Sec77_G7<E> root) {
            if (root == NIL)
                return;
            inorder(root.left);
            list.add(root.element);
            inorder(root.right);
        }

        @Override /* More elements for traversing? */
        public boolean hasNext() {
            if (current < list.size())
                return true;
            return false;
        }

        @Override /* Get the current element and move to the next */
        public E next() {
            return list.get(current++);
        }

        @Override /* Remove the current element */
        public void remove() {
            deleteByTheElement(list.get(current)); // Delete the current element
            list.clear(); // Clear the list
            inorder(); // Rebuild the list
        }
    }
}