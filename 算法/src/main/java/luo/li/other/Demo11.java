package luo.li.other;

/**
 * 盛最多水的容器
 *
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * @Author liluo
 * @create 2022/6/13 15:41
 */
public class Demo11 {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(new Demo11().maxArea(height));
    }

    public int maxArea(int[] height) {
        if(height == null || height.length < 2)
            return 0;
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left],height[right])*(right-left));
            if(height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }
}
