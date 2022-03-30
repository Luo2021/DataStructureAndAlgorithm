package luo.li.link;

/**
 * 反转一个整数，123->321,-456->-654
 * @author luoli
 * @date 2022/3/30 21:55
 */
public class ReverseInt {

    public static void main(String[] args) {
        System.out.println(reverseInt(-12340));
    }

    private static int reverseInt(int n){
        if(n >= 0){
            return reverse(n);
        }else{
            return 0 - reverse(Math.abs(n));
        }
    }

    private static int reverse(int n) {
        int res = 0;
        while(n > 0) {
            int k = n%10;
            res = 10*res + k;
            n = n/10;
        }
        return res;
    }
}
