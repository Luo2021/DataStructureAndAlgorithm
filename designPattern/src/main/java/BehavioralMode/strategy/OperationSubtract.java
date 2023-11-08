package BehavioralMode.strategy;

/**
 * 减法策略
 * @Author liluo
 * @create 2023/11/3 17:32
 */
public class OperationSubtract implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}