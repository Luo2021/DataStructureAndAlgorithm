package luo.li.other;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * @Author liluo
 * @create 2022/6/10 15:46
 */
public class Demo10 {

    public static void main(String[] args) {
        String s1 = "aa";
        String p1 = "a";
        System.out.println(new Demo10().isMatch(s1,p1));

        String s2 = "aa";
        String p2 = "a*";
        System.out.println(new Demo10().isMatch(s2,p2));

        String s3 = "ab";
        String p3 = ".*";
        System.out.println(new Demo10().isMatch(s3,p3));

    }

    public boolean isMatch(String s, String p) {

        boolean table[][] = new boolean[s.length() + 1][p.length() + 1];

        table[0][0] = true;

        for (int col=1; col<table[0].length; col++) {
            char ch = p.charAt(col-1);
            if (col > 1) {
                if (ch == '*') {
                    table[0][col] = table[0][col-2];
                } else {
                    table[0][col] = false;
                }
            } else {
                if (ch == '*') {
                    table[0][col] = true;
                }
            }
        }

        for (int row=1; row<table.length; row++) {
            char ch1 = s.charAt(row-1);
            for (int col=1; col<table[row].length; col++) {
                char ch2 = p.charAt(col-1);
                if (ch1==ch2 || ch2 == '.') {
                    table[row][col] = table[row-1][col-1];
                } else if (ch2 == '*') {
                    if(col > 1) {
                        if (table[row][col-2]) {
                            table[row][col] = true; // * 前面的字符出现0次
                        } else {
                            char prev = p.charAt(col-2);
                            if (prev== ch1 || prev == '.') {
                                table[row][col] = table[row - 1][col]; // * 前面的字符出现多次
                            }
                        }

                    }
                }
            }
        }
        return table[s.length()][p.length()];
    }
}
