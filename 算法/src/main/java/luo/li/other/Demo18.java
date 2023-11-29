package luo.li.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 * @Author liluo
 * @create 2022/6/14 14:19
 */
public class Demo18 {
    public static void main(String[] args) {
        int[]nums1 = {1,0,-1,0,-2,2};
        int target1 = 0;
        System.out.println(new Demo18().fourSum(nums1,target1));
    }

    List<List<Integer>> res=new ArrayList<>();
    List<Integer> road=new ArrayList<>();
    int sum=0;
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        dfs(nums,target,0);
        return res;
    }

    private void dfs(int[] nums,int target,int index){
        if(road.size()==4){
            if(sum == target){
                res.add(new ArrayList<>(road));
            }
            return;
        }
        for(int i=index;i< nums.length;i++){
            if(i>index && nums[i] == nums[i-1]){
                continue;
            }
            if((nums[i] >=0) && sum + nums[i] > target){
                return;
            }
            sum+=nums[i];
            road.add(nums[i]);
            dfs(nums,target,i+1);
            road.remove(road.size()-1);
            sum-=nums[i];
        }
    }
}
