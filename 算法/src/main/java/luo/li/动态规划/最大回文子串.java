package luo.li.动态规划;

import java.util.ArrayList;
import java.util.List;

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
        System.out.println("----------动态规划写法----------");
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("ac"));
        System.out.println("----------中心扩展算法----------");
        System.out.println(longestPalindrome2("babad"));
        System.out.println(longestPalindrome2("cbbd"));
        System.out.println(longestPalindrome2("ac"));
        System.out.println("----------Manacher 算法----------");
        System.out.println(longestPalindrome3("babad"));
        System.out.println(longestPalindrome3("cbbd"));
        System.out.println(longestPalindrome3("ac"));
    }

    /**
     * 动态规划写法
     * 时间复杂度O(n2)
     * 空间复杂度O(n2)
     * @param s
     * @return
     */
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

    /**
     * 中心扩展算法
     * 时间复杂度O(n2)
     * 空间复杂度：O(1)
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }

    /**
     * Manacher 算法
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param s
     * @return
     */
    public static String longestPalindrome3(String s) {
        int start = 0, end = -1;
        StringBuffer t = new StringBuffer("#");
        for (int i = 0; i < s.length(); ++i) {
            t.append(s.charAt(i));
            t.append('#');
        }
        t.append('#');
        s = t.toString();

        List<Integer> arm_len = new ArrayList<Integer>();
        int right = -1, j = -1;
        for (int i = 0; i < s.length(); ++i) {
            int cur_arm_len;
            if (right >= i) {
                int i_sym = j * 2 - i;
                int min_arm_len = Math.min(arm_len.get(i_sym), right - i);
                cur_arm_len = expand(s, i - min_arm_len, i + min_arm_len);
            } else {
                cur_arm_len = expand(s, i, i);
            }
            arm_len.add(cur_arm_len);
            if (i + cur_arm_len > right) {
                j = i;
                right = i + cur_arm_len;
            }
            if (cur_arm_len * 2 + 1 > end - start) {
                start = i - cur_arm_len;
                end = i + cur_arm_len;
            }
        }

        StringBuffer ans = new StringBuffer();
        for (int i = start; i <= end; ++i) {
            if (s.charAt(i) != '#') {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }

    public static int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return (right - left - 2) / 2;
    }

}
