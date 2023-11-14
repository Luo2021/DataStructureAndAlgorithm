package luo.li.dynamic;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 * @Author liluo
 * @create 2023/11/9 21:00
 */
public class 最大回文子串 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("ac"));
    }

    public static String longestPalindrome(String s) {
        if(s == null || s.length() < 2) {
            return s;
        }
        int len = s.length();
        char[] chs = s.toCharArray();
        boolean[][] dp = new boolean[len][len];
        for(int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int maxLen = 1;
        int start = 0;
        for(int L = 2; L <=len; L++) {
            for(int left = 0; left < len; left++) {
                int right = left + L - 1;
                if(right >= len) {
                    break;
                }
                if(chs[left] != chs[right]) {
                    dp[left][right] = false;
                }else{
                    if(right-left <= 2) {
                        dp[left][right] = true;
                    }else{
                        dp[left][right] = dp[left + 1][right - 1];
                    }
                }
                if(dp[left][right] && maxLen < right-left+1) {
                    maxLen = right-left+1;
                    start = left;
                }
            }
        }
        return s.substring(start, start+maxLen);
    }
}
