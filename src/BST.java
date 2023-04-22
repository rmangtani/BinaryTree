import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Ruchi Mangtani
 * @version: 04/21/23
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
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
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
        return searchHelper(val, root);
    }

    /**
     * Helper method that recursively searches the tree to find val
     * @param val value to search for
     * @param currentNode the current BSTNode that is being searched
     * @return
     */
    public boolean searchHelper(int val, BSTNode currentNode) {
        if (currentNode == null) {
            return false;
        }
        if (currentNode.getVal() == val) {
            return true;
        }
        // Goes to the left or right depending on if val is greater/less than currentNode
        if (val < currentNode.getVal()) {
            return (searchHelper(val, currentNode.getLeft()));
        }
        return (searchHelper(val, currentNode.getRight()));
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        ArrayList<BSTNode> nodeOrder = new ArrayList<BSTNode>();
        inOrderHelper(root, nodeOrder);
        return nodeOrder;
    }

    /**
     * Helper method that recursively traverses the nodes in inorder (left, root, right)
     * @param currentNode
     * @param nodeOrder ArrayList of nodes in inorder
     */
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
        ArrayList<BSTNode> nodeOrder = new ArrayList<BSTNode>();
        preOrderHelper(root, nodeOrder);
        return nodeOrder;
    }

    /**
     * Helper method that recursively traverses the nodes in preorder (root, left, right)
     * @param currentNode
     * @param nodeOrder ArrayList of nodes in preorder
     */
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
        ArrayList<BSTNode> nodeOrder = new ArrayList<BSTNode>();
        postOrderHelper(root, nodeOrder);
        return nodeOrder;
    }

    /**
     * Helper method that recursively traverses the nodes in postorder (left, right, root)
     * @param currentNode
     * @param nodeOrder ArrayList of nodes in postorder
     */
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
        root = insertHelper(val, root);
    }

    /**
     * Helper method that inserts val to the tree by recursively searching
     * the tree to find its correct position
     * @param val the value being inserted
     * @param currentNode the current BSTNode being compared to val
     * @return the root of the updated tree
     */
    public BSTNode insertHelper(int val, BSTNode currentNode) {
        if (val < currentNode.getVal()) {
            if (currentNode.getLeft() == null) {
                currentNode.setLeft(new BSTNode(val));
            }
            else {
                insertHelper(val, currentNode.getLeft());
            }
        }
        else if (val > currentNode.getVal()) {
            if (currentNode.getRight() == null) {
                currentNode.setRight(new BSTNode(val));
            }
            else {
                insertHelper(val, currentNode.getRight());
            }
        }
        return currentNode;
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
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

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
