package luo.li;

/**
 * @Author liluo
 * @create 2022/5/11 18:00
 */
public class Test {
    public static void main(String[] args) {
        byte a = 2;
        byte b = 3;
        b= (byte) (b+a);
        b += a;
        System.out.println(b);
    }
}
