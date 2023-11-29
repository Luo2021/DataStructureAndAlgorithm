package luo.li.排序算法;

/**
 * @Author 19612
 * @Create 2023/11/21 11:45
 */
public class 部分有序数查找 {

    public static void main(String[] args) {
        int[]nums = {4,5,6,7,0,1,2,3};
        System.out.println(getIndex(nums, 2));
        System.out.println(getIndex(nums, 5));
        System.out.println(getIndex(nums, 8));
    }

    public static int getIndex(int[] nums, int target) {
        return dfs(nums, target, 0, nums.length-1);
    }

    public static int dfs(int[]nums, int target, int left, int right) {
        if(left == right) {
            if(nums[left] == target) {
                return left;
            }else{
                return -1;
            }
        }
        if(left > right) {
            return -1;
        }

        int mid = (left + right) >>> 1;
        if(nums[mid] == target) {
            return mid;
        }
        if(nums[left] <= nums[mid - 1]) {
            if(nums[left] <= target && target <= nums[mid-1]) {
                return dfs(nums, target, left, mid-1);
            }else {
                return dfs(nums, target, mid+1, right);
            }
        }else{
            if(nums[mid+1] <= target && target <= nums[right]) {
                return dfs(nums, target, mid+1, right);
            }else{
                return dfs(nums, target, left, mid-1);
            }
        }
    }
}
