package luo.li.other;

/**
 * 删除有序数组中的重复项
 *
 * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
 * 输出：5
 * @Author liluo
 * @create 2022/6/23 17:28
 */
public class Demo26 {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(new Demo26().removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len <= 1)
            return len;
        int fast = 1;
        int slow = 1;
        while(fast < len) {
            if(nums[fast] != nums[fast-1]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
