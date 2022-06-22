package luo.li.other;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * @Author liluo
 * @create 2022/6/22 9:40
 */
public class Demo22 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(new Demo22().generateParenthesis(n).toString());
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(result,new StringBuilder(),0,0,n);
        return result;
    }

    public void dfs(List<String> result, StringBuilder builder, int leftCount, int rightCount, int n){
        if(builder.length() == 2*n){
            result.add(builder.toString());
            return;
        }
        if(leftCount < n) {
            builder.append("(");
            dfs(result,builder,leftCount+1,rightCount,n);
            builder.deleteCharAt(builder.length()-1);
        }
        if(rightCount < leftCount) {
            builder.append(")");
            dfs(result,builder,leftCount,rightCount+1,n);
            builder.deleteCharAt(builder.length()-1);
        }
    }
}
