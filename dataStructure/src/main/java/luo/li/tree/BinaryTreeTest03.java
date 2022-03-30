package luo.li.tree;

/**
 * 求⼆叉树中叶⼦节点的个数
 * @author luoli
 * @date 2022/3/30 13:50
 */
public class BinaryTreeTest03 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(numsOfNoChildNode(root));
    }

    private static int numsOfNoChildNode(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null ) {
            return 1;
        }
        return numsOfNoChildNode(root.left)+numsOfNoChildNode(root.right);
    }
}
