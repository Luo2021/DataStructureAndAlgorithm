package luo.li.tree;

/**
 * 求二叉树最小深度
 * @author luoli
 * @date 2022/3/30 11:18
 */
public class BinaryTreeTest01 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(getMinDepth(root));
    }

    private static int getMinDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null || root.right == null) {
            return 1;
        }
        return Math.min(getMinDepth(root.left),getMinDepth(root.right))+1;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

