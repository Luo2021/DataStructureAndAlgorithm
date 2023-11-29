package luo.li.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 串联所有单词的子串
 *
 * 给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 输入：s = "barfoothefoobarman", words = ["foo","bar"]
 * 输出：[0,9]
 *
 * @Author liluo
 * @create 2022/6/29 11:11
 */
public class Demo30 {

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        System.out.println(new Demo30().findSubstring(s,words));

        String s2 = "barfoofoobarthefoobarman";
        String[] words2 = {"bar","foo","the"};
        System.out.println(new Demo30().findSubstring(s2,words2));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int wordLen = words[0].length();
        int sLen = s.length();
        Map<String,Integer> map = new HashMap<>();
        Map<String,Integer> temp = new HashMap<>();
        for(String word : words) {
            map.put(word,map.getOrDefault(word,0)+1);
        }
        for(int i=0;i<wordLen;i++) {
            int left = i;
            int right = i;
            temp.clear();
            while(right+wordLen <= sLen) {
                String str = s.substring(right,right+wordLen);
                right+=wordLen;
                if(!map.containsKey(str)) {
                    left = right;
                    temp.clear();
                }else{
                    temp.put(str,temp.getOrDefault(str,0)+1);
                    while(temp.get(str) > map.get(str)){
                        String str2 = s.substring(left,left+wordLen);
                        left+=wordLen;
                        temp.put(str2,temp.get(str2)-1);
                    }
                    if(temp.equals(map)){
                        ans.add(left);
                    }
                }
            }
        }
        return ans;
    }
}
