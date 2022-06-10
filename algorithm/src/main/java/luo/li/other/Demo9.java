package luo.li.other;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * @Author liluo
 * @create 2022/6/10 15:00
 */
public class Demo9 {
    public static void main(String[] args) {
        int a1 = 121;
        int a2 = -121;
        int a3 = 123;
        System.out.println(new Demo9().isPalindrome(a1));
        System.out.println(new Demo9().isPalindrome(a2));
        System.out.println(new Demo9().isPalindrome(a3));

    }

    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        int res = x;
        int des = 0;
        while(res != 0){
            int digst = res % 10;
            res = res / 10;
            des = 10*des +digst;
        }
        return des == x;
    }
}
