package luo.li.other;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 *
 *
 * 注意：
 *
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 *
 * 示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 * 示例 2：
 *
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 * 示例 3:
 *
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 *
 *
 * 提示：
 *
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s 和 t 由英文字母组成
 *
 *
 * 进阶：你能设计一个在 o(m+n) 时间内解决此问题的算法吗？
 * @Author liluo
 * @create 2023/10/9 9:40
 */
public class Demo76 {

    public static void main(String[] args) {
        Demo76 demo76 = new Demo76();
        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";
        System.out.println(demo76.minWindow(s1, t1));

        String s2 = "a";
        String t2 = "b";
        System.out.println(demo76.minWindow(s2, t2));

        String s3 = "a";
        String t3 = "aa";
        System.out.println(demo76.minWindow(s3, t3));
    }

    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen < tLen) {
            return "";
        }
        int[]tCount = new int[128];
        int[]sCount = new int[128];
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        for(int i = 0; i < tLen; i++) {
            tCount[t.charAt(i)]++;
        }
        int left = 0;
        int right = 0;
        while(right < sLen) {
            if(tCount[s.charAt(right)] > 0) {
                sCount[s.charAt(right)]++;
            }
            while(cheack(sCount, tCount) && left <= right) {
                if(right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                if(sCount[s.charAt(left)] > 0) {
                    sCount[s.charAt(left)]--;
                }
                left++;
            }
            right++;
        }
        if(minLen == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(start, start+minLen);
    }

    public boolean cheack(int[]sCount, int[]tCount) {
        for(int i = 0; i< 128; i++) {
            if(sCount[i] < tCount[i]) {
                return false;
            }
        }
        return true;
    }

}
