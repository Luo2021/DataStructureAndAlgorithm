package luo.li.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断⼆叉树是否是完全⼆叉树
 * @author luoli
 * @date 2022/3/30 13:55
 */
public class BinaryTreeTest06 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        root.left.left.left = new TreeNode(6);
        root.left.left.right = new TreeNode(7);
        System.out.println(isCompleteTreeNode(root));
    }

    private static boolean isCompleteTreeNode(TreeNode root) {
        if(root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        boolean result = true;
        boolean hasNoChild = false;
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode current = queue.remove();
            if(hasNoChild) {
                if(current.left != null || current.right != null){
                    result = false;
                    break;
                }
            }else{
                if(current.left != null && current.right != null) {
                    queue.add(current.left);
                    queue.add(current.right);
                }else if(current.left != null && current.right == null) {
                    queue.add(current.left);
                    hasNoChild = true;
                }else if(current.left == null && current.right != null){
                    result = false;
                    break;
                }else{
                    hasNoChild = true;
                }
            }
        }
        return result;
    }
}
