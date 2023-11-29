package luo.li.排序算法;

import java.util.Arrays;

/**
 * 快速排序
 * @Author liluo
 * @create 2023/9/26 10:08
 */
public class 快速排序 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 8, 4, 5, 9, 6, 7};
        quickSort1(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));

    }

    /**
     * 单边循环快排
     * @param nums
     * @param left
     * @param right
     */
    public static void quickSort1(int[] nums, int left, int right) {
        if(left >= right) {
            return;
        }
        int partition = getPartition(nums, left, right);
        quickSort1(nums, left, partition -1);
        quickSort1(nums, partition + 1, right);
    }

    /**
     * 单边循环快排
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private static int getPartition(int[] nums, int left, int right) {
        int pv = nums[right];
        int i = left;
        int j = left;
        while(j < right) {
            if(nums[j] < pv) {
                if(i != j) {
                    swap(nums, i, j);
                }
                i++;
            }
            j++;
        }
        swap(nums, i, right);
        return i;

    }

    private static void swap(int[]nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
