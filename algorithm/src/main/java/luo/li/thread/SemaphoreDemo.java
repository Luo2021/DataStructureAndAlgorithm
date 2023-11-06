package luo.li.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Author liluo
 * @create 2023/10/27 11:24
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        /**
         * 3个车位
         */
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <=6 ; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();//抢占车位
                    System.out.println(Thread.currentThread().getName()+"\t 抢到车位");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName()+"\t 停车3秒后离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();//离开车位，通知其他线程继续抢占
                }
            },String.valueOf(i)).start();
        }
    }
}
