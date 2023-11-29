package luo.li.other;

import java.util.Stack;

/**
 * 有效的括号
 * @Author liluo
 * @create 2022/6/16 10:13
 */
public class Demo20 {

    public static void main(String[] args) {
        String s1 = "()";
        System.out.println(new Demo20().isValid(s1));
        String s2 = "()[]{}";
        System.out.println(new Demo20().isValid(s2));
        String s3 = "(]";
        System.out.println(new Demo20().isValid(s3));
        String s4 = "([)]";
        System.out.println(new Demo20().isValid(s4));
        String s5 = "{[]}";
        System.out.println(new Demo20().isValid(s5));

    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
                continue;
            }

            if((stack.peek() == '(' && s.charAt(i) == ')')||(stack.peek() == '[' && s.charAt(i) == ']')||(stack.peek() == '{' && s.charAt(i) == '}')){
                stack.pop();
                continue;
            }else{
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
