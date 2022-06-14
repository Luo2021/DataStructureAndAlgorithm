package luo.li.other;

/**
 * 最长公共前缀
 * @Author liluo
 * @create 2022/6/14 9:35
 */
public class Demo14 {

    public static void main(String[] args) {
        String[] strs1 = {"flower","flow","flight"};
        System.out.println(new Demo14().longestCommonPrefix(strs1));
        String[] strs2 = {"dog","racecar","car"};
        System.out.println(new Demo14().longestCommonPrefix(strs2));
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)
            return "";
        String prefix = strs[0];
        for(int i=1; i<strs.length; i++){
            prefix = longestCommonPrefix(prefix,strs[i]);
            if(prefix.length()==0)
                break;
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while(index < length && str1.charAt(index)==str2.charAt(index))
            index++;
        return str1.substring(0,index);
    }
}
