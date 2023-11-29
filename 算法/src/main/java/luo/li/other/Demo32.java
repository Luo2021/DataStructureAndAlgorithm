package luo.li.other;

import java.util.Stack;

/**
 * 最长有效括号
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度
 * @Author liluo
 * @create 2022/7/4 9:54
 */
public class Demo32 {
    public static void main(String[] args) {
       String s1 = "(()";
       String s2 = ")()())";
        String s3 = "(())((()()()";
        System.out.println(new Demo32().longestValidParentheses(s1));
        System.out.println(new Demo32().longestValidParentheses(s2));
        System.out.println(new Demo32().longestValidParentheses(s3));

    }

    public int longestValidParentheses(String s) {
        if(s==null || s.length()==0)
            return 0;
        int maxLen = 0;
        Stack<Integer> stack = new Stack();
        stack.push(-1);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    maxLen = Math.max(maxLen,i-stack.peek());
                }
            }
        }
        return maxLen;
    }
}
