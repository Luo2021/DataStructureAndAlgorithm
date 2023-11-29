package luo.li.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ⼆叉树的中序遍历
 *
 * @Author liluo
 * @create 2023/7/11 15:21
 */
public class BinaryTreeTest12 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        root.left.left.left = new TreeNode(6);
        root.left.left.right = new TreeNode(7);
        List<Integer> resultList = inOrder(root);
        for(Integer result : resultList) {
            System.out.print(result + " ");
        }
        System.out.println();
        List<Integer> resultList2 = inOrderReverse(root);
        for(Integer result : resultList2) {
            System.out.print(result + " ");
        }
    }

    //中序遍历非递归解法
    private static List<Integer> inOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> resultList = new ArrayList<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            if(root.left != null) {
                stack.push(root.left);
                root = root.left;
            }else{
                root = stack.pop();
                resultList.add(root.val);
                if(root.right != null) {
                    stack.push(root.right);
                    root = root.right;
                }
            }
        }
        return resultList;
    }

    //中序遍历递归解法
    private static List<Integer> inOrderReverse(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        inOrder2(root, resultList);
        return resultList;
    }

    private static void inOrder2(TreeNode root, List<Integer> resultList) {
        if(root == null) {
            return;
        }
        inOrder2(root.left, resultList);
        resultList.add(root.val);
        inOrder2(root.right, resultList);

    }
}
