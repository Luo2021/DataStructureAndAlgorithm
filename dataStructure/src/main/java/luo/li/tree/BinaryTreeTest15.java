package luo.li.tree;

import java.util.Stack;

/**
 * 输⼊⼀个⼆叉树和⼀个整数，打印出⼆叉树中节点值的和等于输⼊整数所有的路径
 *         5
 *      /    \
 *     2       9
 *   /  \     / \
 *  1    3   7  11
 * @Author liluo
 * @create 2023/7/13 11:35
 */
public class BinaryTreeTest15 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(11);
        findPath(root, 25);
    }

    private static void findPath(TreeNode root, int i) {
        if (root == null) {
            return;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int currentSum = 0;
        findPath(root, i, stack, currentSum);
    }

    private static void findPath(TreeNode r, int i, Stack<Integer> stack, int currentSum) {
        currentSum += r.val;
        stack.push(r.val);
        if (r.left == null && r.right == null) {
            if (currentSum == i) {
                for (int path : stack) {
                    System.out.println(path);
                }
            }
        }
        if (r.left != null) {
            findPath(r.left, i, stack, currentSum);
        }
        if (r.right != null) {
            findPath(r.right, i, stack, currentSum);
        }
        stack.pop();
    }
}
