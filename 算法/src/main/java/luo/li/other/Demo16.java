package luo.li.other;

import java.util.Arrays;

/**
 * 最接近的三数之和
 * @Author liluo
 * @create 2022/6/14 10:54
 */
public class Demo16 {
    public static void main(String[] args) {
        int[]nums = {-3,-2,-5,3,-4};
        int target = -1;
        System.out.println(new Demo16().threeSumClosest(nums,target));
    }

    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int best = 1000;
        Arrays.sort(nums);
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int j = first+1;
            int k = n-1;
            while(j<k){
                int sum = nums[first]+nums[j]+nums[k];
                if(sum==target)
                    return target;
                if(Math.abs(sum-target)<Math.abs(best-target)){
                    best = sum;
                }
                if(sum>target){
                    k--;
                    while(j<k && nums[k]==nums[k+1]){
                        k--;
                    }
                }else{
                    j++;
                    while(j<k && nums[j]==nums[j-1]){
                        j++;
                    }
                }
            }
        }
        return best;
    }
}
