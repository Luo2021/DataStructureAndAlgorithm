package luo.li.binarySearch;


/**
 * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target，写一个函数搜索nums中的 target，
 * 如果目标值存在返回下标，否则返回 -1
 *
 * @author luoli
 * @date 2021/9/30 18:06
 */
public class BinarySearchDemo1 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int target = 47;
        BinarySearchDemo1 binarySearchDemo1 = new BinarySearchDemo1();
        System.out.println(binarySearchDemo1.search(nums, target));
        System.out.println(binarySearchDemo1.search2(nums, target));
    }

    public int search(int[] nums, int target) {
        return BinarySearch(nums, target, 0, nums.length - 1);
    }

    /**
     * 递归写法
     * @param nums
     * @param target
     * @param left
     * @param right
     * @return
     */
    int BinarySearch(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        //无符号右移一位，等同于除以2，如果直接用除以2会照成left+right超过Integer.max的范围
        int mid = (left + right) >>> 1;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return BinarySearch(nums, target, left, mid - 1);
        } else {
            return BinarySearch(nums, target, mid + 1, right);
        }
    }

    /**
     * 非递归写法
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1 ;
        while(left <= right) {
            int mid = (left + right) >>> 1;
            if(target < nums[mid]) {
                right = mid - 1;
            }else if(nums[mid] < target) {
                left = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

}
