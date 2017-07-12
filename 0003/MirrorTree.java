public class MirrorTree {
    // http://www.geeksforgeeks.org/amazon-interview-set-82-for-sde-2/
    // Question: http://www.geeksforgeeks.org/write-an-efficient-c-function-to-convert-a-tree-into-its-mirror-tree/
    public static void main(String[] args) {
        MirrorTree tree = new MirrorTree();
        tree.runDemo();
    }

    Tree tree;
    public MirrorTree() {
        tree = new Tree();
        tree.createDemoTree();
    }

    public void runDemo() {
        tree.printIOT();
        tree.enterMirror();
        tree.printIOT();
    }

    public class Node {
        public Node left, right;
        public int data;
        public Node(int data) {
            this.data = data;
        }
        public Node() {
        }

    }

    public class Tree {
        public Node root;
        public Tree(){
        }

        public void createDemoTree() {
            /*
                    1
                   / \
                  3  2
                    / \
                   5  4
            */
            root = new Node(1);
            root.left = new Node(3);
            root.right = new Node(2);
            root.right.left = new Node(5);
            root.right.right = new Node(4);
        }

        public void enterMirror() {
            /*
                    1
                   / \
                  2  3
                 / \
                4  5
            */
            mirror(root);
        }

        public void mirror(Node node) {
            if (node == null)
                return;

            mirror(node.left);
            mirror(node.right);

            Node temp = node.left;
            node.left = node.right;
            node.right = temp;
        }

        public void inOrderTraversal(Node node) {
            if (node == null)
                return;
            inOrderTraversal(node.left);
            System.out.print(node.data + " ");
            inOrderTraversal(node.right);
        }

        public void printIOT() {
            inOrderTraversal(root);
            System.out.println();
        }
    }
}
