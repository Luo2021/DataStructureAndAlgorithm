package luo.li.binarySearch;

import java.util.Arrays;
import java.util.List;

/**
 * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target，写一个函数搜索nums中的 target，
 * 如果目标值存在返回下标，否则返回 -1
 * @author luoli
 * @date 2021/9/30 18:06
 */
public class BinarySearchDemo1 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int target = 47;
        BinarySearchDemo1 binarySearchDemo1 = new BinarySearchDemo1();
        System.out.println(binarySearchDemo1.search(nums,target));
    }

    public int search(int[] nums, int target) {
        return BinarySearch(nums,target,0,nums.length-1);
    }

    int BinarySearch(int[] nums, int target, int left, int right){
        if(left > right){
            return -1;
        }
        int mid = (left + right )/2;
        if(nums[mid] == target) {
            return mid;
        }else if(nums[mid] > target) {
            return BinarySearch(nums,target,left, mid-1);
        }else{
            return BinarySearch(nums,target,mid+1, right);
        }
    }
}
