package BehavioralMode.Strategy;

/**
 * 加法策略
 * @Author liluo
 * @create 2023/11/3 17:25
 */
public class OperationAdd implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}