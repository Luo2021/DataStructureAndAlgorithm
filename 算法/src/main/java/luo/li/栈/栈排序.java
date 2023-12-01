package luo.li.栈;

import java.util.Stack;

/**
 *
 * @Author 19612
 * @Create 2023/12/1 17:20
 */
public class 栈排序 {

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(3);
        s.push(8);
        s.push(9);
        s.push(4);
        sort(s);
        while(!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    public static void sort(Stack<Integer> stack) {
        Stack<Integer> ascSortedStack = new Stack<>();
        int current = 0;
        while(!stack.isEmpty()) {
            current = stack.pop();
            while(!ascSortedStack.isEmpty() && current > ascSortedStack.peek()) {
                stack.push(ascSortedStack.pop());
            }
            ascSortedStack.push(current);
        }

        while(!ascSortedStack.isEmpty()) {
            stack.push(ascSortedStack.pop());
        }
    }
}
