package luo.li.tree;

/**
 * 翻转⼆叉树or镜像⼆叉树
 * @author luoli
 * @date 2022/3/30 13:55
 */
public class BinaryTreeTest09 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        root.left.left.left = new TreeNode(6);
        root.left.left.right = new TreeNode(7);
        System.out.println(mirrorTreeNode(root));
    }

    private static TreeNode mirrorTreeNode(TreeNode root){
        if(root == null) {
            return null;
        }
        TreeNode left = mirrorTreeNode(root.left);
        TreeNode right = mirrorTreeNode(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
