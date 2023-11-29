package luo.li.tree;

/**
 * 在⼆叉排序树中插⼊节点
 *
 *         5
 *      /    \
 *     2       9
 *   /  \     / \
 *  1    3   7  11
 * @Author liluo
 * @create 2023/7/12 16:16
 */
public class BinaryTreeTest14 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(11);
        TreeNode newRoot = insertNode(root, new TreeNode(6));
        System.out.println(newRoot);
    }

    private static TreeNode insertNode(TreeNode root,TreeNode node){
        if(root == node){
            return node;
        }
        TreeNode temp = root;
        TreeNode last = null;
        while(temp != null) {
            last = temp;
            if(temp.val > node.val) {
                temp = temp.left;
            }else{
                temp = temp.right;
            }
        }
        if(last != null) {
            if(last.val > node.val){
                last.left =  node;
            }else{
                last.right = node;
            }
        }
        return root;
    }

}
