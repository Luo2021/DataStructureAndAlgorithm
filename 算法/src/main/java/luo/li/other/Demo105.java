package luo.li.other;

import luo.li.other.common.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 *
 *
 *
 * 示例 1:
 *
 *
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 * 示例 2:
 *
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 *
 *
 * 提示:
 *
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder 和 inorder 均 无重复 元素
 * inorder 均出现在 preorder
 * preorder 保证 为二叉树的前序遍历序列
 * inorder 保证 为二叉树的中序遍历序列
 * @Author liluo
 * @create 2023/10/13 11:18
 */
public class Demo105 {
    public static void main(String[] args) {
        Demo105 demo105 = new Demo105();
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root1 = demo105.buildTree(preorder, inorder);
        System.out.println(root1);
        int[] preorder2 = {3, 9, 8, 5, 4, 10, 20, 15, 7};
        int[] inorder2 = {4, 5, 8, 10, 9, 3, 15, 20, 7};
        TreeNode root2 = demo105.buildTree2(preorder2, inorder2);
        System.out.println(root2);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;
        if(preLen != inLen) {
            return null;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inLen;i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preLen-1, map, 0, inLen-1);
    }

    public TreeNode buildTree(int[] preorder, int preLeft, int preRight, Map<Integer,Integer> map, int inLeft, int inRight) {
        if(preLeft > preRight || inLeft > inRight) {
            return null;
        }
        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        int index = map.get(rootVal);
        root.left = buildTree(preorder, preLeft+1, index-inLeft+preLeft, map, inLeft, index-1);
        root.right = buildTree(preorder, index-inLeft+preLeft+1, preRight, map, index+1, inRight);
        return root;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int inorderIndex = 0;
        for(int i =1;i<preorder.length;i++) {
            int preVal = preorder[i];
            TreeNode node = stack.peek();
            if(node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preVal);
                stack.push(node.left);
            }else{
                while(!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preVal);
                stack.push(node.right);
            }
        }
        return root;
    }
}
