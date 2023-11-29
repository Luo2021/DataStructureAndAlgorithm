package luo.li.回溯算法;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 * @Author liluo
 * @create 2023/11/9 19:26
 */
public class 全排列 {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        int len = nums.length;
        boolean[] used = new boolean[len];
        dfs(nums, ans,0, used, perm);
        return ans;
    }

    public static void dfs(int[] nums, List<List<Integer>> ans, int index, boolean[] used, List<Integer> perm) {
        if(index == nums.length) {
            ans.add(new ArrayList<>(perm));
            return;
        }
        for(int i=0;i<nums.length;i++) {
           if (!used[i]) {
               perm.add(nums[i]);
               used[i] = true;
               dfs(nums, ans, index + 1, used, perm);
               perm.remove(perm.size() - 1);
               used[i] = false;
           }
        }
    }
}
