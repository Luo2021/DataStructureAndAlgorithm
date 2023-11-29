package luo.li.other;

/**
 * 移除元素
 * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
 * 输出：5, nums = [0,1,4,0,3]
 * @Author liluo
 * @create 2022/6/23 18:21
 */
public class Demo27 {
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(new Demo27().removeElement(nums,val));
    }

    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int fast =0;
        int slow = 0;
        while(fast<len) {
            if(nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
