public class lab8 {
    public static TreeNode getInOrderSuccessor(TreeNode root, TreeNode p) {
        TreeNode cur = root;
        TreeNode successor = null;

        if (root == null) return null;
        else {
            while (cur != null) {
                if (p.value < cur.value) { //if the target is smaller than the current value, target will be in the left subtree by BST property
                    successor = cur; //the successor will always be greater than current node, so it is only assigned to here to ensure this property remains
                    cur = cur.left;
                } else if (p.value >= cur.value) { //if target is greater than or equal to current value, target will be in the right subtree by BST property
                    cur = cur.right;
                }
            }
        }
        return successor; //if there are no greater values than p's value, will return null. otherwise, returns a valid node
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(7);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(11);
        root.left.right.left = new TreeNode(9);
        root.left.right.right = new TreeNode(12);
        root.right.left = new TreeNode(20);
        root.right.right = new TreeNode(35);
        root.right.right.left = new TreeNode(32);
        root.right.right.right = new TreeNode(40);

        TreeNode A = getInOrderSuccessor(root, root.left.right); //getting 11's successor
        TreeNode B = getInOrderSuccessor(root, root.right.left); //getting 20's successor
        TreeNode C = getInOrderSuccessor(root, root.left.left); //getting 2's successor
        TreeNode D = getInOrderSuccessor(root, root.right.right.right); //getting 40's successor

        System.out.println("11's succesor is " + A.value);
        System.out.println("20's succesor is " + B.value);
        System.out.println("2's succesor is " + C.value);
        System.out.println("40's succesor is " + D);
    }
}
