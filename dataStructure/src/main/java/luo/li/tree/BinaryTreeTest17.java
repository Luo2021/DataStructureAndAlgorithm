package luo.li.tree;

/**
 * ⼆叉树内两个节点的最⻓距离
 * ⼆叉树中两个节点的最⻓距离可能有三种情况：
 * 1.左⼦树的最⼤深度+右⼦树的最⼤深度为⼆叉树的最⻓距离
 * 2.左⼦树中的最⻓距离即为⼆叉树的最⻓距离
 * 3.右⼦树种的最⻓距离即为⼆叉树的最⻓距离
 * 因此，递归求解即可
 *         5
 *      /    \
 *     2       9
 *   /  \     / \
 *  1    3   7  11
 * @Author liluo
 * @create 2023/7/14 10:46
 */
public class BinaryTreeTest17 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(11);
        System.out.println(getMaxDistance(root).maxDistance);
    }

    private static class Result {
        private int maxDistance;

        private int maxDepth;

        public Result(){

        }

        public Result(int maxDistance, int maxDepth) {
            this.maxDistance = maxDistance;
            this.maxDepth = maxDepth;
        }
    }

    private static Result getMaxDistance(TreeNode root) {
        if(root == null) {
            return new Result(0, -1);
        }

        Result lmd = getMaxDistance(root.left);
        Result rmd = getMaxDistance(root.right);
        Result result = new Result();
        result.maxDepth = Math.max(lmd.maxDepth, rmd.maxDepth) + 1;
        result.maxDistance = Math.max(lmd.maxDepth+rmd.maxDepth + 2, Math.max(lmd.maxDistance, rmd.maxDistance));
        return result;
    }
}
