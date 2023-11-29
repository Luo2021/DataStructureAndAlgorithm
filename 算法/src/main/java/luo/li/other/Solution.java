package luo.li.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat", "bat", "bat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>(16);
        for(String str : strs) {
            int[]counts = new int[26];
            int length = str.length();
            for(int i = 0; i < length; i++) {
                counts[str.charAt(i)-'a']++;
            }
            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < counts.length; i++) {
                if(counts[i]!=0) {
                    builder.append((char)('a'+i));
                    builder.append(counts[i]);
                }
            }
            String key = builder.toString();

           List<String>list = map.getOrDefault(key, new ArrayList<>());
           list.add(str);
           map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}