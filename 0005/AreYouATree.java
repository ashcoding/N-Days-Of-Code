import java.lang.Integer;

public class AreYouATree {
    // http://www.geeksforgeeks.org/amazon-interview-set-71-sde-2/
    // http://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
    public static void main(String[] args) {
        // Check if a tree is a BST tree
        AreYouATree demo = new AreYouATree();
        demo.runDemo();
    }

    public void runDemo() {
        Tree tree = new Tree();
        tree.createDemoTreeValid();
        System.out.println(tree.isBST()? "It's a BST tree." : "It's not a BST tree");
        tree.createDemoTreeInvalid();
        System.out.println(tree.isBST()? "It's a BST tree." : "It's not a BST tree");
    }

    public class Node {
        public Node left, right;
        public int data;
        public Node(int d) {
            data = d;
        }
    }

    public class Tree {
        Node root;

        public Tree() {
        }

        public void createDemoTreeInvalid() {
            root = new Node(3);
            root.left = new Node(2);
            root.right = new Node(5);
            root.left.left = new Node(1);
            root.left.right = new Node(4);
        }

        public void createDemoTreeValid() {
            root = new Node(4);
            root.left = new Node(2);
            root.right = new Node(5);
            root.left.left = new Node(1);
            root.left.right = new Node(3);
        }

        public boolean isBST() {
            return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        public boolean isBSTUtil(Node node, int min, int max) {
            if (node == null)
                return true;

            if (!(min < node.data && node.data < max))
                return false;

            return (isBSTUtil(node.left, min, node.data) && isBSTUtil(node.right, node.data, max));
        }
    }
}
