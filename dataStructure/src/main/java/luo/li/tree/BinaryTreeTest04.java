package luo.li.tree;

/**
 * 求⼆叉树中第k层节点的个数
 * @author luoli
 * @date 2022/3/30 13:55
 */
public class BinaryTreeTest04 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(numsOfkLevelTreeNode(root,2));
    }

    private static int numsOfkLevelTreeNode(TreeNode root,int k){
        if(root == null || k < 1){
            return 0;
        }
        if(k == 1) {
            return 1;
        }
        return numsOfkLevelTreeNode(root.left,k-1)+numsOfkLevelTreeNode(root.right,k-1);
    }
}
