package luo.li.other;

/**
 * @Author liluo
 * @create 2023/10/11 15:21
 */
public class DIGUI {

    public static void main(String[] args) {
        DIGUI digui = new DIGUI();
        System.out.println(digui.dfs(4));
    }

    public int dfs(int n) {
        if(n == 2) {
            return 2;
        }
        if(n == 1) {
            return 1;
        }
        return dfs(n-1);
    }
}
