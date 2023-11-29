package luo.li.tree;

/**
 * 求⼆叉树中节点的个数
 * @author luoli
 * @date 2022/3/30 13:44
 */
public class BinaryTreeTest02 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(numOfTreeNode(root));
    }

    private static int numOfTreeNode(TreeNode root){
        if(root == null){
            return 0;
        }
        return numOfTreeNode(root.left)+numOfTreeNode(root.right)+1;
    }
}
