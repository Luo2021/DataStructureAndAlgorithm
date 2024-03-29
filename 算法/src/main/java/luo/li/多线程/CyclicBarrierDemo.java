package luo.li.多线程;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author liluo
 * @create 2023/10/27 11:21
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier =    new CyclicBarrier(7,()->{
            System.out.println("集齐龙珠召唤神龙");
        });

        for (int i = 1; i <=7 ; i++) {
            final int  tempInt = i;
            new Thread(()->{
                System.out.println("收集到第："+tempInt+"颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }

    }
}
