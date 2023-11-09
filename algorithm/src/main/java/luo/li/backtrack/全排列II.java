package luo.li.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * @Author liluo
 * @create 2023/11/9 19:25
 */
public class 全排列II {

    public static void main(String[] args) {
//        int[] nums = {1,2,3};
//        System.out.println(permute(nums));

        int[] nums2 = {1,1,2};
        System.out.println(permute(nums2));
    }

    public static List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
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
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }
            perm.add(nums[i]);
            used[i] = true;
            dfs(nums, ans, index + 1, used, perm);
            perm.remove(perm.size() - 1);
            used[i] = false;
        }
    }
}
