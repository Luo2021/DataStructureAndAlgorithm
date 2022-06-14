package luo.li.other;

/**
 * 罗马数字转整数
 * @Author liluo
 * @create 2022/6/13 20:12
 */
public class Demo13 {
    public static void main(String[] args) {
        String s1 = "III";
        System.out.println(new Demo13().romanToInt(s1));
        String s2 = "IV";
        System.out.println(new Demo13().romanToInt(s2));
        String s3 = "IX";
        System.out.println(new Demo13().romanToInt(s3));
        String s4 = "LVIII";
        System.out.println(new Demo13().romanToInt(s4));
        String s5 = "MCMXCIV";
        System.out.println(new Demo13().romanToInt(s5));
    }

    public int romanToInt(String s) {
        int sum = 0;
        int pre = getValue(s.charAt(0));
        for(int i = 1; i<s.length(); i++){
            int cur = getValue(s.charAt(i));
            if(pre < cur) {
                sum -= pre;
            }else{
                sum += pre;
            }
            pre = cur;
        }
        sum += pre;
        return sum;
    }

    private int getValue(char ch){
        switch(ch){
            case 'I' : return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
