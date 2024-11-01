
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
// import java.util.Queue;

public class RedBlackTree<E extends Comparable<E>> extends AbstractTree<E> {
    protected TreeNode<E> root;
    protected int size = 0;
    final TreeNode<E> NIL = new TreeNode<>(null);

    public RedBlackTree() {
        NIL.color = "BLACK";
        root = NIL;
    }

    /* Create a Red-Black Tree from an array of objects */
    public RedBlackTree(E[] objects) {
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
        int maxWidth = (int) Math.pow(2, maxLevel) - 1; // Max width based on height
        List<TreeNode<E>> nodes = new ArrayList<>();
        nodes.add(this.root);
        printPyramid(nodes, 1, maxWidth);
    }

    private void printPyramid(List<TreeNode<E>> nodes, int level, int maxWidth) {

        // private void printPyramid(List<TreeNode<E>> nodes, int level, int maxWidth) {
        // // ... (rest of the method remains the same)

        // int nodeWidth = 5; // Adjust the node width as needed
        // int branchLength = 3; // Adjust the branch length as needed

        // // Print the current level nodes with appropriate spaces
        // printSpaces(firstSpaces);

        // for (TreeNode<E> node : nodes) {
        // if (node != NIL) {
        // // Print the node with color and spacing
        // System.out.printf("%" + nodeWidth + "s", colorCode + node.element + RESET);
        // newNodes.add(node.left);
        // newNodes.add(node.right);
        // } else {
        // // Print empty space
        // printSpaces(nodeWidth);
        // newNodes.add(NIL);
        // newNodes.add(NIL);
        // }
        // printSpaces(betweenSpaces);
        // }
        // System.out.println();

        // // Print branches under the current level of nodes
        // printBranches(nodes, firstSpaces, betweenSpaces, nodeWidth, branchLength);

        // // ... (rest of the method remains the same)
        // }

        // private void printBranches(List<TreeNode<E>> nodes, int firstSpaces, int
        // betweenSpaces, int nodeWidth, int branchLength) {
        // int branchOffset = firstSpaces + nodeWidth / 2;

        // for (TreeNode<E> node : nodes) {
        // printSpaces(branchOffset - branchLength);

        // if (node == null || node == NIL) {
        // printSpaces(betweenSpaces + nodeWidth);
        // continue;
        // }

        // // Print left branch
        // printSpaces(branchLength / 2);
        // System.out.print("/");
        // printSpaces(branchLength / 2);

        // printSpaces(betweenSpaces - branchLength);

        // // Print right branch
        // printSpaces(branchLength / 2);
        // System.out.print("\\");
        // printSpaces(branchLength / 2);

        // printSpaces(betweenSpaces);
        // }
        // System.out.println();
        // }

        if (nodes.isEmpty() || isAllElementsNil(nodes)) {
            return;
        }

        int firstSpaces = (maxWidth / (int) Math.pow(2, level)) - 1; // Calculate leading spaces for the first node
        int betweenSpaces = (maxWidth / (int) Math.pow(2, level + 1)) - 1; // Spaces between nodes
        int nodeWidth = 5; // Adjust the node width as needed
        int branchLength = 3; // Adjust the branch length as needed

        // Print the current level nodes with appropriate spaces
        printSpaces(firstSpaces);

        List<TreeNode<E>> newNodes = new ArrayList<>();
        for (TreeNode<E> node : nodes) {
            if (node != NIL) {

                String colorCode = node.color.equals("BLACK") ? BLACK : RED;

                // Print the node with color and spacing
                System.out.printf("%" + nodeWidth + "s", colorCode + node.element + RESET);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                // Print empty space
                printSpaces(nodeWidth);
                newNodes.add(NIL);
                newNodes.add(NIL);
            }
            printSpaces(betweenSpaces);
        }
        System.out.println();

        // Print branches under the current level of nodes
        printBranches(nodes, firstSpaces, betweenSpaces, nodeWidth, branchLength);

        // Move to the next level of nodes
        printPyramid(newNodes, level + 1, maxWidth);
    }

    private void printBranches(List<TreeNode<E>> nodes, int firstSpaces, int betweenSpaces, int nodeWidth,
            int branchLength) {
        int branchOffset = firstSpaces + 1; // Adjust the branch offset for alignment
        for (TreeNode<E> node : nodes) {
            printSpaces(branchOffset - branchLength);

            if (node == null || node == NIL) {
                printSpaces(betweenSpaces + nodeWidth);
                continue;
            }

            // Print left branch
            printSpaces(branchLength / 2);
            System.out.print("/");
            printSpaces(branchLength / 2);

            printSpaces(betweenSpaces - branchLength);

            // Print right branch
            printSpaces(branchLength / 2);
            System.out.print("\\");
            printSpaces(branchLength / 2);

            printSpaces(betweenSpaces);
        }
        System.out.println();
    }

    private void printSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    private int maxLevel(TreeNode<E> node) {
        if (node == NIL) {
            return 0;
        }
        return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
    }

    private boolean isAllElementsNil(List<TreeNode<E>> list) {
        for (TreeNode<E> node : list) {
            if (node != NIL) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean search(E e) {
        TreeNode<E> current = root;
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

    protected TreeNode<E> createNewNode(E e) {
        TreeNode<E> node = new TreeNode<>(e);
        node.color = "RED";
        node.left = NIL;
        node.right = NIL;
        return node;
    }

    // @Override
    // public boolean insert(E e) {
    // TreeNode<E> newNode = createNewNode(e);

    // if (root == NIL) {
    // root = newNode;
    // root.color = "BLACK";
    // } else {
    // TreeNode<E> parent = null;
    // TreeNode<E> current = root;

    // while (current != NIL) {
    // parent = current;
    // if (e.compareTo(current.element) < 0) {
    // current = current.left;
    // } else if (e.compareTo(current.element) > 0) {
    // current = current.right;
    // } else {
    // return false;
    // }
    // }

    // newNode.parent = parent;
    // if (e.compareTo(parent.element) < 0) {
    // parent.left = newNode;
    // } else {
    // parent.right = newNode;
    // }

    // fixInsert(newNode);
    // }
    // size++;
    // return true;
    // }

    // private void fixInsert(TreeNode<E> k) {
    // while (k.parent.color.equals("RED")) {
    // if (k.parent == k.parent.parent.left) {
    // TreeNode<E> uncle = k.parent.parent.right;
    // if (uncle.color.equals("RED")) {
    // k.parent.color = "BLACK";
    // uncle.color = "BLACK";
    // k.parent.parent.color = "RED";
    // k = k.parent.parent;
    // } else {
    // if (k == k.parent.right) {
    // k = k.parent;
    // leftRotate(k);
    // }
    // k.parent.color = "BLACK";
    // k.parent.parent.color = "RED";
    // rightRotate(k.parent.parent);
    // }
    // } else {
    // TreeNode<E> uncle = k.parent.parent.left;
    // if (uncle.color.equals("RED")) {
    // k.parent.color = "BLACK";
    // uncle.color = "BLACK";
    // k.parent.parent.color = "RED";
    // k = k.parent.parent;
    // } else {
    // if (k == k.parent.left) {
    // k = k.parent;
    // rightRotate(k);
    // }
    // k.parent.color = "BLACK";
    // k.parent.parent.color = "RED";
    // leftRotate(k.parent.parent);
    // }
    // }
    // }
    // root.color = "BLACK";
    // }

    @Override
    public boolean insert(E e) {
        TreeNode<E> newNode = createNewNode(e);

        if (root == NIL) {
            root = newNode;
            root.color = "BLACK";
            root.parent = null; // Ensure root's parent is null
        } else {
            TreeNode<E> parent = null;
            TreeNode<E> current = root;

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

            newNode.parent = parent; // Set the parent of the new node
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

    private void fixInsert(TreeNode<E> k) {
        while (k.parent != null && k.parent.color.equals("RED")) { // Check if k.parent is null
            if (k.parent == k.parent.parent.left) {
                TreeNode<E> uncle = k.parent.parent.right;
                if (uncle.color.equals("RED")) {
                    k.parent.color = "BLACK";
                    uncle.color = "BLACK";
                    k.parent.parent.color = "RED";
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.right) {
                        k = k.parent;
                        leftRotate(k);
                    }
                    k.parent.color = "BLACK";
                    k.parent.parent.color = "RED";
                    rightRotate(k.parent.parent);
                }
            } else {
                TreeNode<E> uncle = k.parent.parent.left;
                if (uncle.color.equals("RED")) {
                    k.parent.color = "BLACK";
                    uncle.color = "BLACK";
                    k.parent.parent.color = "RED";
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.left) {
                        k = k.parent;
                        rightRotate(k);
                    }
                    k.parent.color = "BLACK";
                    k.parent.parent.color = "RED";
                    leftRotate(k.parent.parent);
                }
            }
        }
        root.color = "BLACK";
    }

    private void leftRotate(TreeNode<E> x) {
        TreeNode<E> y = x.right;
        x.right = y.left;
        if (y.left != NIL) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    private void rightRotate(TreeNode<E> x) {
        TreeNode<E> y = x.left;
        x.left = y.right;
        if (y.right != NIL) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    @Override
    public void inorder() {
        inorder(root);
    }

    private void inorder(TreeNode<E> root) {
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

    private void postorder(TreeNode<E> root) {
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

    private void preorder(TreeNode<E> root) {
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

    public TreeNode<E> getRoot() {
        return root;
    }

    public void clear() {
        root = NIL;
        size = 0;
    }

    public ArrayList<TreeNode<E>> path(E e) {
        ArrayList<TreeNode<E>> list = new ArrayList<>();
        TreeNode<E> current = root;
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

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}