package luo.li.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ⼆叉树的前序遍历
 *
 * @Author liluo
 * @create 2023/7/11 14:52
 */
public class BinaryTreeTest11 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        root.left.left.left = new TreeNode(6);
        root.left.left.right = new TreeNode(7);
        List<Integer> resultList = preOrder(root);
        for(Integer result : resultList) {
            System.out.print(result + " ");
        }
        System.out.println();
        List<Integer> resultList2 = preOrderReverse(root);
        for(Integer result : resultList2) {
            System.out.print(result + " ");
        }
    }

    //非递归解法
    private static List<Integer> preOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> resultList = new ArrayList<>();
        if(root == null) {
            return resultList;
        }
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            resultList.add(node.val);
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
        }
        return resultList;
    }

    //递归解法
    private static List<Integer> preOrderReverse(TreeNode root){
        List<Integer> resultList = new ArrayList<>();
        preOrder2(root, resultList);
        return resultList;
    }

    private static void preOrder2(TreeNode root, List<Integer> resultList) {
        if(root == null) {
            return ;
        }
        resultList.add(root.val);
        preOrder2(root.left, resultList);
        preOrder2(root.right, resultList);
    }
}
