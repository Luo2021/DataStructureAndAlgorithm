package luo.li.other;
import luo.li.other.common.TreeNode;

import java.util.*;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
 * 示例 2：
 *
 * 输入：root = [1]
 * 输出：[[1]]
 * 示例 3：
 *
 * 输入：root = []
 * 输出：[]
 *
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 * @Author liluo
 * @create 2023/10/13 9:52
 */
public class Demo103 {

    public static void main(String[] args) {
        Demo103 demo103 = new Demo103();
        TreeNode left = new TreeNode(9, null, null);
        TreeNode right = new TreeNode(20, new TreeNode(15),new TreeNode(7));
        TreeNode root = new TreeNode(3, left, right);
        System.out.println(Arrays.deepToString(demo103.zigzagLevelOrder(root).toArray()));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isLeft = true;
        while(!queue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<>();
            int size = queue.size();
            for(int i=0;i<size;i++) {
                TreeNode node = queue.poll();
                if (isLeft) {
                    levelList.addLast(node.val);
                }else{
                    levelList.addFirst(node.val);
                }
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            isLeft = !isLeft;
            result.add(new LinkedList<>(levelList));
        }
        return result;
    }
}

