package luo.li.other;

/**
 * 整数转罗马数字
 * @Author liluo
 * @create 2022/6/13 19:48
 */
public class Demo12 {
    public static void main(String[] args) {
        int num1 = 3;
        System.out.println(new Demo12().intToRoman(num1));
        int num2 = 4;
        System.out.println(new Demo12().intToRoman(num2));
        int num3 = 9;
        System.out.println(new Demo12().intToRoman(num3));
        int num4 = 58;
        System.out.println(new Demo12().intToRoman(num4));
        int num5 = 1994;
        System.out.println(new Demo12().intToRoman(num5));

    }

    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<values.length; i++) {
            int value = values[i];
            String symbol = symbols[i];
            while(num >= value) {
                num -= value;
                builder.append(symbol);
            }
            if(num == 0){
                break;
            }
        }
        return builder.toString();
    }

    public String intToRoman2(int num) {
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds  = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens      = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones      = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        StringBuffer roman = new StringBuffer();
        roman.append(thousands[num / 1000]);
        roman.append(hundreds[num % 1000 / 100]);
        roman.append(tens[num % 100 / 10]);
        roman.append(ones[num % 10]);
        return roman.toString();
    }
}
