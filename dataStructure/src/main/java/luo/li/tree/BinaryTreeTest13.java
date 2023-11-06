package luo.li.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ⼆叉树的后序遍历
 *
 * @Author liluo
 * @create 2023/7/11 15:56
 */
public class BinaryTreeTest13 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        root.left.left.left = new TreeNode(6);
        root.left.left.right = new TreeNode(7);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(9);
        root.left.left.right.left = new TreeNode(10);
        root.left.left.right.right = new TreeNode(11);
        List<Integer> resultList = postOrder(root);
        for (Integer result : resultList) {
            System.out.print(result + " ");
        }
        System.out.println();
        List<Integer> resultList2 = postOrderReverse(root);
        for (Integer result : resultList2) {
            System.out.print(result + " ");
        }
    }

    //后序遍历非递归写法
    private static List<Integer> postOrder(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        List<Integer> resultList = new ArrayList<>();
        stack1.push(root);
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
            if(stack2.peek().left != null) {
                stack1.push(stack2.peek().left);
            }
            if(stack2.peek().right != null) {
                stack1.push(stack2.peek().right);
            }
        }

        while(!stack2.isEmpty()) {
            resultList.add(stack2.pop().val);
        }

        return resultList;
    }

    //后序遍历递归写法
    private static List<Integer> postOrderReverse(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        postOrder2(root, resultList);
        return resultList;
    }

    private static void postOrder2(TreeNode root, List<Integer> resultList) {
        if(root == null){
            return;
        }
        postOrder2(root.left, resultList);
        postOrder2(root.right, resultList);
        resultList.add(root.val);
    }

}
