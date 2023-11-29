package luo.li.数学;

/**
 * 整数翻转
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * @Author liluo
 * @create 2022/6/10 9:59
 */
public class 整数翻转 {

    public static void main(String[] args) {
        int a1 = 12345;
        int a2= -12345;
        int a3 = 1534236469;
        System.out.println(new 整数翻转().reverse(a1));
        System.out.println(new 整数翻转().reverse(a2));
        System.out.println(new 整数翻转().reverse(a3));
    }
    public int reverse(int x) {
       int rev = 0;
       while(x != 0){
           if(rev < Integer.MIN_VALUE/10 || rev > Integer.MAX_VALUE/10){
               return 0;
           }
           int digist = x % 10;
           x = x/10;
           rev = 10 * rev + digist;
       }
       return rev;
    }
}
