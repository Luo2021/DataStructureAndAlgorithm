package luo.li.other;

/**
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,0]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 示例 3：
 *
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 5 * 105
 * -231 <= nums[i] <= 231 - 1
 * @Author liluo
 * @create 2023/10/9 17:05
 */
public class Demo41 {

    public static void main(String[] args) {
        Demo41 demo41 = new Demo41();
        int[]nums1 = {3,1,2};
        System.out.println(demo41.firstMissingPositive2(nums1));

        int[]nums2 = {3,4,-1,1};
        System.out.println(demo41.firstMissingPositive2(nums2));

        int[]nums3 = {7,8,9,11,12};
        System.out.println(demo41.firstMissingPositive2(nums3));
    }

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public int firstMissingPositive2(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            while(nums[i] <= n && nums[i] > 0 && nums[nums[i]-1] != nums[i]) {
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }

        for(int i=0;i<n;i++) {
            if(nums[i] != i+1) {
                return i+1;
            }
        }
        return n+1;
    }
}
