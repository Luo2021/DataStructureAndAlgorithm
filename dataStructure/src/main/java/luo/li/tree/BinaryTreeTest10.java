package luo.li.tree;

/**
 * 求两个⼆叉树的最低公共祖先节点
 *
 * @Author liluo
 * @create 2023/7/11 14:19
 */
public class BinaryTreeTest10 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        TreeNode t1 = root.left.left.left = new TreeNode(6);
        TreeNode t2 = root.left.left.right = new TreeNode(7);

        System.out.println(getLastCommonParent(root, t1, t2).val);
    }

    private static TreeNode getLastCommonParent(TreeNode root, TreeNode t1, TreeNode t2) {
        if(findNode(root.left, t1)) {
            if(findNode(root.right, t2)) {
                return root;
            }else{
                return getLastCommonParent(root.left, t1, t2);
            }
        }else {
            if(findNode(root.left, t2)) {
                return root;
            }else{
                return getLastCommonParent(root.right, t1, t2);
            }
        }
    }

    // 查找节点node是否在当前 二叉树中
   private static boolean findNode(TreeNode root, TreeNode node) {
        if (root == null || node == null) {
            return false;
        }

        if (root == node) {
            return true;
        }

        boolean flag = findNode(root.left, node);

        if(!flag) {
            flag = findNode(root.right, node);
        }

        return flag;
    }
}
