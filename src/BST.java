import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Your Name Here
 * @version: Date
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
//        this.root = new BSTNode(10);
//        this.root.setLeft(new BSTNode(5));
//        this.root.setRight(new BSTNode((15)));
//        this.root.getLeft().setLeft(new BSTNode(3));
//        this.root.getLeft().setRight(new BSTNode(9));
//        this.root = new BSTNode(8);
//        this.root.setLeft(new BSTNode(3));
//        this.root.getLeft().setLeft(new BSTNode(1));
//        this.root.getLeft().setRight(new BSTNode(6));
//        this.root.getLeft().getRight().setLeft(new BSTNode(4));
//        this.root.getLeft().getRight().setRight(new BSTNode(7));
//        this.root.setRight(new BSTNode((10)));
//        this.root.getRight().setRight(new BSTNode(14));
//        this.root.getRight().getRight().setLeft(new BSTNode(13));
        this.root = new BSTNode(4);
        this.root.setLeft(new BSTNode(2));
        this.root.getLeft().setLeft(new BSTNode(1));
        this.root.getLeft().setRight(new BSTNode(3));
        this.root.setRight(new BSTNode(7));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        // TODO: Complete the search function
        return recursiveSearch(val, root);
    }

    public boolean recursiveSearch(int val, BSTNode currentNode) {
        if (currentNode == null)
            return false;
        if (currentNode.getVal() == val) {
            return true;
        }
        if (val < currentNode.getVal())
            return (recursiveSearch(val, currentNode.getLeft()));
        else
            return (recursiveSearch(val, currentNode.getRight()));
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        // TODO: Complete inorder traversal
        // left root right
        ArrayList<BSTNode> nodeOrder = new ArrayList<BSTNode>();
        inOrderHelper(root, nodeOrder);
        return nodeOrder;
    }

    public void inOrderHelper(BSTNode currentNode, ArrayList<BSTNode> nodeOrder) {
        if (currentNode == null) {
            return;
        }
        inOrderHelper(currentNode.getLeft(), nodeOrder);
        nodeOrder.add(currentNode);
        inOrderHelper(currentNode.getRight(), nodeOrder);
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // TODO: Complete preorder traversal
        ArrayList<BSTNode> nodeOrder = new ArrayList<BSTNode>();
        preOrderHelper(root, nodeOrder);
        return nodeOrder;
    }

    public void preOrderHelper(BSTNode currentNode, ArrayList<BSTNode> nodeOrder) {
        if (currentNode == null) {
            return;
        }
        nodeOrder.add(currentNode);
        preOrderHelper(currentNode.getLeft(), nodeOrder);
        preOrderHelper(currentNode.getRight(), nodeOrder);
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // TODO: Complete postorder traversal
        ArrayList<BSTNode> nodeOrder = new ArrayList<BSTNode>();
        postOrderHelper(root, nodeOrder);
        return nodeOrder;
    }

    public void postOrderHelper(BSTNode currentNode, ArrayList<BSTNode> nodeOrder) {
        if (currentNode == null) {
            return;
        }
        postOrderHelper(currentNode.getLeft(), nodeOrder);
        postOrderHelper(currentNode.getRight(), nodeOrder);
        nodeOrder.add(currentNode);
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // TODO: Complete insert
        insertHelper(val, root);
    }

    // end up returning everything in the pathway that it took
    public BSTNode insertHelper(int val, BSTNode root) {
        if (root.getVal() == val) {
            return root;
        }
        if (val < root.getVal()) {
            if (root.getLeft() == null) {
                root.setLeft(new BSTNode(val));
            }
            return insertHelper(val, root.getLeft());
        }
        else {
            if (root.getRight() == null) {
                root.setRight(new BSTNode(val));
            }
            return insertHelper(val, root.getRight());
        }
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(5);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
