package BehavioralMode.Strategy;

/**
 * 策略模式(行为型模式)：定义一系列算法，把他们封装起来，并且使它们可以相互替换
 * 策略接口
 * @Author liluo
 * @create 2023/11/3 17:21
 */
public interface Strategy {

    /**
     * 实现该接口的方法
     * @param num1  数值1
     * @param num2  数值2
     * @return      计算结果
     */
    int doOperation(int num1, int num2);
}
