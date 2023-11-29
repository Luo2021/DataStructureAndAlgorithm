package luo.li.tree;

/**
 * 两个⼆叉树是否完全相同
 * @author luoli
 * @date 2022/3/30 13:55
 */
public class BinaryTreeTest07 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        root.left.left.left = new TreeNode(6);
        root.left.left.right = new TreeNode(7);

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(2);
        root2.left.right = new TreeNode(1);
        root2.left.left.left = new TreeNode(6);
        root2.left.left.right = new TreeNode(7);
        System.out.println(isSameTreeNode(root, root2));
    }

    private static boolean isSameTreeNode(TreeNode t1,TreeNode t2){
        if(t1 == null && t2 == null) {
            return true;
        }

        if(t1 == null || t2 == null) {
            return false;
        }

        if(t1.val != t2.val) {
            return false;
        }

        boolean left = isSameTreeNode(t1.left, t2.left);
        boolean right = isSameTreeNode(t1.right, t2.right);

        return left && right;
    }
}
