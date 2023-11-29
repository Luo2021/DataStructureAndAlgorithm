package luo.li.滑动窗口;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * @Author liluo
 * @create 2022/5/9 17:53
 */
public class 无重复字符的最长子串 {

    public static void main(String[] args) {
        String s = "bacabcdbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int maxLen = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;
        //可以考虑用int[128]数组来存储
        Set<Character> set = new HashSet<>();
        for(int i=0; i<s.length(); i++) {
            if(!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                right++;
                maxLen = Math.max(maxLen,right-left);
            }else {
                while(left < right) {
                    set.remove(s.charAt(left));
                    left++;
                    if(!set.contains(s.charAt(i))){
                        set.add(s.charAt(i));
                        right++;
                        break;
                    }
                }
            }
        }

        return maxLen;
    }
}
