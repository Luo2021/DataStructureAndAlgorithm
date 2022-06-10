package luo.li.other;

/**
 * 字符串转换整数 (atoi)
 * @Author liluo
 * @create 2022/6/10 14:06
 */
public class Demo8 {
    public static void main(String[] args) {
        String str1 = "42";
        String str2 = "   -42";
        String str3 = "4193 with words";
        String str4 = "9223372036854775808";
        System.out.println(new Demo8().myAtoi(str1));
        System.out.println(new Demo8().myAtoi(str2));
        System.out.println(new Demo8().myAtoi(str3));
        System.out.println(new Demo8().myAtoi(str4));
    }

    // 使用long类型

    public int myAtoi(String s) {
        //如果为空，直接返回0
        if (s.length() == 0)
            return 0;
        int index = 0;//遍历字符串中字符的位置
        long res = 0;//最终结果
        int sign = 1;//符号，1是正数，-1是负数，默认为正数
        int length = s.length();
        // 过滤掉字符串前面的空格
        while (index < length && s.charAt(index) == ' ')
            index++;
        if (index == length)
            return 0;
        //判断符号
        if (s.charAt(index) == '-' || s.charAt(index) == '+')
            sign = s.charAt(index++) == '+' ? 1 : -1;

        for (; index < length; index++) {
            //取出字符串中字符，然后转化为数字
            int digit = s.charAt(index) - '0';
            //按照题中的要求，读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。
            //字符串的其余部分将被忽略。如果读取了非数字，后面的都要忽略
            if (digit < 0 || digit > 9)
                break;

            res = res * 10 + digit;

            //越界处理
            if (res * sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (res * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int) (sign * res);
    }
}
