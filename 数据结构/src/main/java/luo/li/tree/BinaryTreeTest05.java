package luo.li.tree;

/**
 * 判断⼆叉树是否是平衡⼆叉树
 * @author luoli
 * @date 2022/3/30 13:55
 */
public class BinaryTreeTest05 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        root.left.left.left = new TreeNode(6);
        root.left.left.right = new TreeNode(7);
        System.out.println(isBalanced(root));
    }

    private static boolean isBalanced(TreeNode root){
        return maxDeath2(root) != -1;
    }

    /**
     * 左右节点高度差是否大于1
     * @param root
     * @return
     */
    private static int maxDeath2(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = maxDeath2(root.left);
        int right = maxDeath2(root.right);
        if(Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
